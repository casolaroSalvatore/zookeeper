/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.zookeeper.server.watch.watchmanager.variant_c4;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerMetrics;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.ZooTrace;
import org.apache.zookeeper.server.watch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages watches associated with ZooKeeper paths.
 *
 * <p>The class maintains two synchronized indexes:
 * one from paths to watchers and another from watchers to paths.
 */
public class WatchManager implements IWatchManager {

    private static final Logger LOG = LoggerFactory.getLogger(WatchManager.class);
    private static final int INITIAL_WATCHERS_PER_PATH_CAPACITY = 4;

    private final Map<String, Set<Watcher>> watchTable = new HashMap<>();
    private final Map<Watcher, Map<String, WatchStats>> watch2Paths = new HashMap<>();

    private int recursiveWatchQty;

    @Override
    public synchronized int size() {
        int watcherRegistrationCount = 0;
        for (Set<Watcher> watchers : watchTable.values()) {
            watcherRegistrationCount += watchers.size();
        }
        return watcherRegistrationCount;
    }

    @Override
    public boolean addWatch(String path, Watcher watcher) {
        return addWatch(path, watcher, WatcherMode.DEFAULT_WATCHER_MODE);
    }

    @Override
    public synchronized boolean addWatch(
            String path,
            Watcher watcher,
            WatcherMode watcherMode) {

        if (isDeadWatcher(watcher)) {
            LOG.debug("Ignoring addWatch with closed cnxn");
            return false;
        }

        addWatcherToPathIndex(path, watcher);

        Map<String, WatchStats> watchedPaths =
                watch2Paths.computeIfAbsent(watcher, ignored -> new HashMap<>());

        WatchStats currentStats =
                watchedPaths.getOrDefault(path, WatchStats.NONE);
        WatchStats updatedStats = currentStats.addMode(watcherMode);

        if (updatedStats == currentStats) {
            return false;
        }

        watchedPaths.put(path, updatedStats);
        incrementRecursiveWatchCountIfNeeded(watcherMode);
        return true;
    }

    private boolean isDeadWatcher(Watcher watcher) {
        return watcher instanceof ServerCnxn
                && ((ServerCnxn) watcher).isStale();
    }

    private void addWatcherToPathIndex(String path, Watcher watcher) {
        Set<Watcher> watchers = watchTable.get(path);
        if (watchers == null) {
            watchers = new HashSet<>(INITIAL_WATCHERS_PER_PATH_CAPACITY);
            watchTable.put(path, watchers);
        }
        watchers.add(watcher);
    }

    private void incrementRecursiveWatchCountIfNeeded(WatcherMode watcherMode) {
        if (watcherMode.isRecursive()) {
            ++recursiveWatchQty;
        }
    }

    private void decrementRecursiveWatchCountIfNeeded(WatchStats stats) {
        if (stats.hasMode(WatcherMode.PERSISTENT_RECURSIVE)) {
            --recursiveWatchQty;
        }
    }

    @Override
    public synchronized void removeWatcher(Watcher watcher) {
        Map<String, WatchStats> watchedPaths = watch2Paths.remove(watcher);
        if (watchedPaths == null) {
            return;
        }

        for (String path : watchedPaths.keySet()) {
            removeWatcherFromPathIndex(path, watcher);
        }

        for (WatchStats stats : watchedPaths.values()) {
            decrementRecursiveWatchCountIfNeeded(stats);
        }
    }

    private void removeWatcherFromPathIndex(String path, Watcher watcher) {
        Set<Watcher> watchers = watchTable.get(path);
        if (watchers == null) {
            return;
        }

        watchers.remove(watcher);
        if (watchers.isEmpty()) {
            watchTable.remove(path);
        }
    }

    @Override
    public WatcherOrBitSet triggerWatch(
            String path,
            EventType type,
            long zxid,
            List<ACL> acl) {

        return triggerWatch(path, type, zxid, acl, null);
    }

    @Override
    public WatcherOrBitSet triggerWatch(
            String path,
            EventType type,
            long zxid,
            List<ACL> acl,
            WatcherOrBitSet suppress) {

        WatchedEvent event =
                new WatchedEvent(type, KeeperState.SyncConnected, path, zxid);

        Set<Watcher> triggeredWatchers = collectTriggeredWatchers(path);

        if (triggeredWatchers.isEmpty()) {
            traceNoWatchers(path);
            return null;
        }

        updateWatchMetrics(type, triggeredWatchers.size());
        notifyWatchers(triggeredWatchers, event, acl, suppress);

        return new WatcherOrBitSet(triggeredWatchers);
    }

    private synchronized Set<Watcher> collectTriggeredWatchers(String path) {
        Set<Watcher> triggeredWatchers = new HashSet<>();
        PathParentIterator pathIterator = getPathParentIterator(path);

        for (String candidatePath : pathIterator.asIterable()) {
            Set<Watcher> registeredWatchers = watchTable.get(candidatePath);
            if (registeredWatchers == null || registeredWatchers.isEmpty()) {
                continue;
            }

            collectWatchersForPath(
                    candidatePath,
                    pathIterator.atParentPath(),
                    registeredWatchers,
                    triggeredWatchers);

            if (registeredWatchers.isEmpty()) {
                watchTable.remove(candidatePath);
            }
        }

        return triggeredWatchers;
    }

    private void collectWatchersForPath(
            String path,
            boolean parentPath,
            Set<Watcher> registeredWatchers,
            Set<Watcher> triggeredWatchers) {

        Iterator<Watcher> watcherIterator = registeredWatchers.iterator();

        while (watcherIterator.hasNext()) {
            Watcher watcher = watcherIterator.next();
            Map<String, WatchStats> watchedPaths =
                    watch2Paths.getOrDefault(watcher, Collections.emptyMap());
            WatchStats stats = watchedPaths.get(path);

            if (stats == null) {
                LOG.warn(
                        "inconsistent watch table for watcher {}, {} not in path list",
                        watcher,
                        path);
                continue;
            }

            if (parentPath) {
                collectRecursiveParentWatcher(
                        watcher,
                        stats,
                        triggeredWatchers);
            } else {
                collectDirectWatcher(
                        path,
                        watcher,
                        stats,
                        watchedPaths,
                        watcherIterator,
                        triggeredWatchers);
            }
        }
    }

    private void collectRecursiveParentWatcher(
            Watcher watcher,
            WatchStats stats,
            Set<Watcher> triggeredWatchers) {

        if (stats.hasMode(WatcherMode.PERSISTENT_RECURSIVE)) {
            triggeredWatchers.add(watcher);
        }
    }

    private void collectDirectWatcher(
            String path,
            Watcher watcher,
            WatchStats stats,
            Map<String, WatchStats> watchedPaths,
            Iterator<Watcher> watcherIterator,
            Set<Watcher> triggeredWatchers) {

        triggeredWatchers.add(watcher);

        WatchStats updatedStats = stats.removeMode(WatcherMode.STANDARD);
        if (updatedStats == WatchStats.NONE) {
            watcherIterator.remove();
            watchedPaths.remove(path);
        } else if (updatedStats != stats) {
            watchedPaths.put(path, updatedStats);
        }
    }

    private void notifyWatchers(
            Set<Watcher> watchers,
            WatchedEvent event,
            List<ACL> acl,
            WatcherOrBitSet suppress) {

        for (Watcher watcher : watchers) {
            if (suppress != null && suppress.contains(watcher)) {
                continue;
            }

            if (watcher instanceof ServerWatcher) {
                ((ServerWatcher) watcher).process(event, acl);
            } else {
                watcher.process(event);
            }
        }
    }

    private void updateWatchMetrics(EventType eventType, int watcherCount) {
        switch (eventType) {
            case NodeCreated:
                ServerMetrics.getMetrics()
                        .NODE_CREATED_WATCHER
                        .add(watcherCount);
                break;
            case NodeDeleted:
                ServerMetrics.getMetrics()
                        .NODE_DELETED_WATCHER
                        .add(watcherCount);
                break;
            case NodeDataChanged:
                ServerMetrics.getMetrics()
                        .NODE_CHANGED_WATCHER
                        .add(watcherCount);
                break;
            case NodeChildrenChanged:
                ServerMetrics.getMetrics()
                        .NODE_CHILDREN_WATCHER
                        .add(watcherCount);
                break;
            default:
                break;
        }
    }

    private void traceNoWatchers(String path) {
        if (LOG.isTraceEnabled()) {
            ZooTrace.logTraceMessage(
                    LOG,
                    ZooTrace.EVENT_DELIVERY_TRACE_MASK,
                    "No watchers for " + path);
        }
    }

    @Override
    public synchronized String toString() {
        StringBuilder description = new StringBuilder();

        description.append(watch2Paths.size())
                .append(" connections watching ")
                .append(watchTable.size())
                .append(" paths\n");

        int totalWatches = 0;
        for (Map<String, WatchStats> watchedPaths : watch2Paths.values()) {
            totalWatches += watchedPaths.size();
        }

        description.append("Total watches:")
                .append(totalWatches);

        return description.toString();
    }

    @Override
    public synchronized void dumpWatches(
            PrintWriter writer,
            boolean byPath) {

        if (byPath) {
            dumpWatchesByPath(writer);
        } else {
            dumpWatchesByConnection(writer);
        }
    }

    private void dumpWatchesByPath(PrintWriter writer) {
        for (Entry<String, Set<Watcher>> entry : watchTable.entrySet()) {
            writer.println(entry.getKey());

            for (Watcher watcher : entry.getValue()) {
                writer.print("\t0x");
                writer.print(Long.toHexString(sessionIdOf(watcher)));
                writer.print("\n");
            }
        }
    }

    private void dumpWatchesByConnection(PrintWriter writer) {
        for (Entry<Watcher, Map<String, WatchStats>> entry
                : watch2Paths.entrySet()) {

            writer.print("0x");
            writer.println(Long.toHexString(sessionIdOf(entry.getKey())));

            for (String path : entry.getValue().keySet()) {
                writer.print("\t");
                writer.println(path);
            }
        }
    }

    private long sessionIdOf(Watcher watcher) {
        return ((ServerCnxn) watcher).getSessionId();
    }

    @Override
    public synchronized boolean containsWatcher(
            String path,
            Watcher watcher) {

        return containsWatcher(path, watcher, null);
    }

    @Override
    public synchronized boolean containsWatcher(
            String path,
            Watcher watcher,
            WatcherMode watcherMode) {

        Map<String, WatchStats> watchedPaths = watch2Paths.get(watcher);
        if (watchedPaths == null) {
            return false;
        }

        WatchStats stats = watchedPaths.get(path);
        return stats != null
                && (watcherMode == null || stats.hasMode(watcherMode));
    }

    @Override
    public synchronized boolean removeWatcher(
            String path,
            Watcher watcher,
            WatcherMode watcherMode) {

        Map<String, WatchStats> watchedPaths = watch2Paths.get(watcher);
        Set<Watcher> watchersForPath = watchTable.get(path);

        if (watchedPaths == null || watchersForPath == null) {
            return false;
        }

        WatchStats currentStats = watchedPaths.get(path);
        if (currentStats == null) {
            return false;
        }

        if (watcherMode == null) {
            WatchStats removedStats =
                    unwatch(path, watcher, watchedPaths, watchersForPath);
            decrementRecursiveWatchCountIfNeeded(removedStats);
            return true;
        }

        WatchStats updatedStats = currentStats.removeMode(watcherMode);
        if (updatedStats == currentStats) {
            return false;
        }

        if (updatedStats == WatchStats.NONE) {
            unwatch(path, watcher, watchedPaths, watchersForPath);
        } else {
            watchedPaths.put(path, updatedStats);
        }

        if (watcherMode.isRecursive()) {
            --recursiveWatchQty;
        }

        return true;
    }

    @Override
    public synchronized boolean removeWatcher(
            String path,
            Watcher watcher) {

        return removeWatcher(path, watcher, null);
    }

    private WatchStats unwatch(
            String path,
            Watcher watcher,
            Map<String, WatchStats> watchedPaths,
            Set<Watcher> watchersForPath) {

        WatchStats removedStats = watchedPaths.remove(path);
        if (removedStats == null) {
            return WatchStats.NONE;
        }

        if (watchedPaths.isEmpty()) {
            watch2Paths.remove(watcher);
        }

        watchersForPath.remove(watcher);
        if (watchersForPath.isEmpty()) {
            watchTable.remove(path);
        }

        return removedStats;
    }

    // VisibleForTesting
    Map<Watcher, Map<String, WatchStats>> getWatch2Paths() {
        return watch2Paths;
    }

    @Override
    public synchronized WatchesReport getWatches() {
        Map<Long, Set<String>> pathsBySession = new HashMap<>();

        for (Entry<Watcher, Map<String, WatchStats>> entry
                : watch2Paths.entrySet()) {

            long sessionId = sessionIdOf(entry.getKey());
            Set<String> paths =
                    new HashSet<>(entry.getValue().keySet());
            pathsBySession.put(sessionId, paths);
        }

        return new WatchesReport(pathsBySession);
    }

    @Override
    public synchronized WatchesPathReport getWatchesByPath() {
        Map<String, Set<Long>> sessionsByPath = new HashMap<>();

        for (Entry<String, Set<Watcher>> entry : watchTable.entrySet()) {
            Set<Long> sessionIds =
                    new HashSet<>(entry.getValue().size());
            sessionsByPath.put(entry.getKey(), sessionIds);

            for (Watcher watcher : entry.getValue()) {
                sessionIds.add(sessionIdOf(watcher));
            }
        }

        return new WatchesPathReport(sessionsByPath);
    }

    @Override
    public synchronized WatchesSummary getWatchesSummary() {
        int totalWatches = 0;

        for (Map<String, WatchStats> watchedPaths : watch2Paths.values()) {
            totalWatches += watchedPaths.size();
        }

        return new WatchesSummary(
                watch2Paths.size(),
                watchTable.size(),
                totalWatches);
    }

    @Override
    public void shutdown() {
        // Intentionally left blank.
    }

    // VisibleForTesting
    synchronized int getRecursiveWatchQty() {
        return recursiveWatchQty;
    }

    private PathParentIterator getPathParentIterator(String path) {
        if (getRecursiveWatchQty() == 0) {
            return PathParentIterator.forPathOnly(path);
        }
        return PathParentIterator.forAll(path);
    }
}
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.zookeeper.server.watch.watchmanager.variant_c2;

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
 * This class manages watches. It allows watches to be associated with a string
 * and removes watchers and their watches in addition to managing triggers.
 */
public class WatchManager implements IWatchManager {

    private static final Logger LOG = LoggerFactory.getLogger(WatchManager.class);

    private static final int INITIAL_WATCHERS_PER_PATH_CAPACITY = 4;

    private final Map<String, Set<Watcher>> watchTable = new HashMap<>();
    private final Map<Watcher, Map<String, WatchStats>> watch2Paths = new HashMap<>();

    private int recursiveWatchQty = 0;

    @Override
    public synchronized int size() {
        int watchCount = 0;
        for (Set<Watcher> watchersForPath : watchTable.values()) {
            watchCount += watchersForPath.size();
        }
        return watchCount;
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

        Set<Watcher> watchersForPath = getOrCreateWatchersForPath(path);
        watchersForPath.add(watcher);

        Map<String, WatchStats> pathsForWatcher = getOrCreatePathsForWatcher(watcher);
        WatchStats currentStats = pathsForWatcher.getOrDefault(path, WatchStats.NONE);
        WatchStats updatedStats = currentStats.addMode(watcherMode);

        if (updatedStats == currentStats) {
            return false;
        }

        pathsForWatcher.put(path, updatedStats);
        incrementRecursiveWatchCountIfNecessary(watcherMode);
        return true;
    }

    private boolean isDeadWatcher(Watcher watcher) {
        return watcher instanceof ServerCnxn && ((ServerCnxn) watcher).isStale();
    }

    private Set<Watcher> getOrCreateWatchersForPath(String path) {
        Set<Watcher> watchersForPath = watchTable.get(path);
        if (watchersForPath == null) {
            /*
             * Do not waste memory if there are few watches on a node.
             * Rehash when the fourth entry is added, doubling size thereafter.
             */
            watchersForPath = new HashSet<>(INITIAL_WATCHERS_PER_PATH_CAPACITY);
            watchTable.put(path, watchersForPath);
        }
        return watchersForPath;
    }

    private Map<String, WatchStats> getOrCreatePathsForWatcher(Watcher watcher) {
        Map<String, WatchStats> pathsForWatcher = watch2Paths.get(watcher);
        if (pathsForWatcher == null) {
            /*
             * Connections typically have many watches, so use the default
             * HashMap capacity.
             */
            pathsForWatcher = new HashMap<>();
            watch2Paths.put(watcher, pathsForWatcher);
        }
        return pathsForWatcher;
    }

    private void incrementRecursiveWatchCountIfNecessary(WatcherMode watcherMode) {
        if (watcherMode.isRecursive()) {
            ++recursiveWatchQty;
        }
    }

    private void decrementRecursiveWatchCountIfNecessary(WatcherMode watcherMode) {
        if (watcherMode.isRecursive()) {
            --recursiveWatchQty;
        }
    }

    private void decrementRecursiveWatchCountIfNecessary(WatchStats watchStats) {
        if (watchStats.hasMode(WatcherMode.PERSISTENT_RECURSIVE)) {
            --recursiveWatchQty;
        }
    }

    @Override
    public synchronized void removeWatcher(Watcher watcher) {
        Map<String, WatchStats> pathsForWatcher = watch2Paths.remove(watcher);
        if (pathsForWatcher == null) {
            return;
        }

        removeWatcherFromAllPathEntries(watcher, pathsForWatcher.keySet());

        for (WatchStats stats : pathsForWatcher.values()) {
            decrementRecursiveWatchCountIfNecessary(stats);
        }
    }

    private void removeWatcherFromAllPathEntries(
            Watcher watcher,
            Set<String> watchedPaths) {

        for (String path : watchedPaths) {
            Set<Watcher> watchersForPath = watchTable.get(path);
            if (watchersForPath == null) {
                continue;
            }

            watchersForPath.remove(watcher);
            removePathEntryIfEmpty(path, watchersForPath);
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
            traceMissingWatchers(path);
            return null;
        }

        updateTriggeredWatcherMetric(type, triggeredWatchers.size());

        WatcherOrBitSet result = new WatcherOrBitSet(triggeredWatchers);
        notifyWatchers(triggeredWatchers, event, acl, suppress);
        return result;
    }

    private synchronized Set<Watcher> collectTriggeredWatchers(String path) {
        Set<Watcher> triggeredWatchers = new HashSet<>();
        PathParentIterator pathIterator = getPathParentIterator(path);

        for (String currentPath : pathIterator.asIterable()) {
            Set<Watcher> watchersForPath = watchTable.get(currentPath);
            if (watchersForPath == null || watchersForPath.isEmpty()) {
                continue;
            }

            collectWatchersForPath(
                    currentPath,
                    pathIterator,
                    watchersForPath,
                    triggeredWatchers);

            removePathEntryIfEmpty(currentPath, watchersForPath);
        }

        return triggeredWatchers;
    }

    private void collectWatchersForPath(
            String currentPath,
            PathParentIterator pathIterator,
            Set<Watcher> watchersForPath,
            Set<Watcher> triggeredWatchers) {

        Iterator<Watcher> watcherIterator = watchersForPath.iterator();

        while (watcherIterator.hasNext()) {
            Watcher watcher = watcherIterator.next();
            WatchStats stats = getWatchStats(watcher, currentPath);

            if (stats == null) {
                LOG.warn(
                        "inconsistent watch table for watcher {}, not in path list {}",
                        watcher,
                        currentPath);
                continue;
            }

            if (pathIterator.atParentPath()) {
                collectRecursiveWatcher(watcher, stats, triggeredWatchers);
            } else {
                collectDirectWatcher(
                        watcher,
                        currentPath,
                        stats,
                        watcherIterator,
                        triggeredWatchers);
            }
        }
    }

    private WatchStats getWatchStats(Watcher watcher, String path) {
        Map<String, WatchStats> pathsForWatcher =
                watch2Paths.getOrDefault(watcher, Collections.emptyMap());
        return pathsForWatcher.get(path);
    }

    private void collectRecursiveWatcher(
            Watcher watcher,
            WatchStats stats,
            Set<Watcher> triggeredWatchers) {

        if (stats.hasMode(WatcherMode.PERSISTENT_RECURSIVE)) {
            triggeredWatchers.add(watcher);
        }
    }

    private void collectDirectWatcher(
            Watcher watcher,
            String path,
            WatchStats currentStats,
            Iterator<Watcher> watcherIterator,
            Set<Watcher> triggeredWatchers) {

        triggeredWatchers.add(watcher);

        WatchStats updatedStats =
                currentStats.removeMode(WatcherMode.STANDARD);

        if (updatedStats == WatchStats.NONE) {
            watcherIterator.remove();
            removePathFromWatcher(watcher, path);
        } else if (updatedStats != currentStats) {
            watch2Paths.get(watcher).put(path, updatedStats);
        }
    }

    private void removePathFromWatcher(Watcher watcher, String path) {
        Map<String, WatchStats> pathsForWatcher = watch2Paths.get(watcher);
        pathsForWatcher.remove(path);

        if (pathsForWatcher.isEmpty()) {
            watch2Paths.remove(watcher);
        }
    }

    private void removePathEntryIfEmpty(
            String path,
            Set<Watcher> watchersForPath) {

        if (watchersForPath.isEmpty()) {
            watchTable.remove(path);
        }
    }

    private void traceMissingWatchers(String path) {
        if (LOG.isTraceEnabled()) {
            ZooTrace.logTraceMessage(
                    LOG,
                    ZooTrace.EVENT_DELIVERY_TRACE_MASK,
                    "No watchers for " + path);
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

    private void updateTriggeredWatcherMetric(
            EventType eventType,
            int watcherCount) {

        switch (eventType) {
            case NodeCreated:
                ServerMetrics.getMetrics().NODE_CREATED_WATCHER.add(watcherCount);
                break;
            case NodeDeleted:
                ServerMetrics.getMetrics().NODE_DELETED_WATCHER.add(watcherCount);
                break;
            case NodeDataChanged:
                ServerMetrics.getMetrics().NODE_CHANGED_WATCHER.add(watcherCount);
                break;
            case NodeChildrenChanged:
                ServerMetrics.getMetrics().NODE_CHILDREN_WATCHER.add(watcherCount);
                break;
            default:
                break;
        }
    }

    @Override
    public synchronized String toString() {
        StringBuilder result = new StringBuilder();

        result.append(watch2Paths.size())
                .append(" connections watching ")
                .append(watchTable.size())
                .append(" paths\n");

        for (Entry<String, Set<Watcher>> entry : watchTable.entrySet()) {
            result.append(entry.getKey())
                    .append(" -> ")
                    .append(entry.getValue())
                    .append('\n');
        }

        return result.toString();
    }

    @Override
    public synchronized void dumpWatches(PrintWriter pwriter, boolean byPath) {
        if (byPath) {
            dumpWatchesByPath(pwriter);
        } else {
            dumpWatchesByWatcher(pwriter);
        }
    }

    private void dumpWatchesByPath(PrintWriter writer) {
        for (Entry<String, Set<Watcher>> entry : watchTable.entrySet()) {
            writer.println(entry.getKey());

            for (Watcher watcher : entry.getValue()) {
                writer.print("\t0x");
                writer.print(
                        Long.toHexString(((ServerCnxn) watcher).getSessionId()));
                writer.print("\n");
            }
        }
    }

    private void dumpWatchesByWatcher(PrintWriter writer) {
        for (Entry<Watcher, Map<String, WatchStats>> entry
                : watch2Paths.entrySet()) {

            writer.print("0x");
            writer.println(
                    Long.toHexString(
                            ((ServerCnxn) entry.getKey()).getSessionId()));

            for (String path : entry.getValue().keySet()) {
                writer.print("\t");
                writer.println(path);
            }
        }
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

        Map<String, WatchStats> pathsForWatcher = watch2Paths.get(watcher);
        if (pathsForWatcher == null) {
            return false;
        }

        WatchStats stats = pathsForWatcher.get(path);
        return stats != null
                && (watcherMode == null || stats.hasMode(watcherMode));
    }

    @Override
    public synchronized boolean removeWatcher(
            String path,
            Watcher watcher,
            WatcherMode watcherMode) {

        Map<String, WatchStats> pathsForWatcher = watch2Paths.get(watcher);
        Set<Watcher> watchersForPath = watchTable.get(path);

        if (pathsForWatcher == null || watchersForPath == null) {
            return false;
        }

        WatchStats currentStats = pathsForWatcher.get(path);
        if (currentStats == null) {
            return false;
        }

        if (watcherMode == null) {
            WatchStats removedStats =
                    unwatch(path, watcher, pathsForWatcher, watchersForPath);
            decrementRecursiveWatchCountIfNecessary(removedStats);
            return true;
        }

        WatchStats updatedStats = currentStats.removeMode(watcherMode);
        if (updatedStats == currentStats) {
            return false;
        }

        if (updatedStats == WatchStats.NONE) {
            unwatch(path, watcher, pathsForWatcher, watchersForPath);
        } else {
            pathsForWatcher.put(path, updatedStats);
        }

        decrementRecursiveWatchCountIfNecessary(watcherMode);
        return true;
    }

    private WatchStats unwatch(
            String path,
            Watcher watcher,
            Map<String, WatchStats> pathsForWatcher,
            Set<Watcher> watchersForPath) {

        WatchStats removedStats = pathsForWatcher.remove(path);
        if (removedStats == null) {
            return WatchStats.NONE;
        }

        if (pathsForWatcher.isEmpty()) {
            watch2Paths.remove(watcher);
        }

        watchersForPath.remove(watcher);
        removePathEntryIfEmpty(path, watchersForPath);
        return removedStats;
    }

    @Override
    public synchronized boolean removeWatcher(
            String path,
            Watcher watcher) {

        return removeWatcher(path, watcher, null);
    }

    // VisibleForTesting
    Map<Watcher, Map<String, WatchStats>> getWatch2Paths() {
        return watch2Paths;
    }

    @Override
    public synchronized WatchesReport getWatches() {
        Map<Long, Set<String>> pathsBySessionId = new HashMap<>();

        for (Entry<Watcher, Map<String, WatchStats>> entry
                : watch2Paths.entrySet()) {

            long sessionId =
                    ((ServerCnxn) entry.getKey()).getSessionId();

            Set<String> paths =
                    new HashSet<>(entry.getValue().keySet());

            pathsBySessionId.put(sessionId, paths);
        }

        return new WatchesReport(pathsBySessionId);
    }

    @Override
    public synchronized WatchesPathReport getWatchesByPath() {
        Map<String, Set<Long>> sessionIdsByPath = new HashMap<>();

        for (Entry<String, Set<Watcher>> entry : watchTable.entrySet()) {
            Set<Long> sessionIds =
                    new HashSet<>(entry.getValue().size());

            sessionIdsByPath.put(entry.getKey(), sessionIds);

            for (Watcher watcher : entry.getValue()) {
                sessionIds.add(
                        ((ServerCnxn) watcher).getSessionId());
            }
        }

        return new WatchesPathReport(sessionIdsByPath);
    }

    @Override
    public synchronized WatchesSummary getWatchesSummary() {
        int totalWatches = 0;

        for (Map<String, WatchStats> pathsForWatcher
                : watch2Paths.values()) {
            totalWatches += pathsForWatcher.size();
        }

        return new WatchesSummary(
                watch2Paths.size(),
                watchTable.size(),
                totalWatches);
    }

    @Override
    public void shutdown() {
        // Do nothing.
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
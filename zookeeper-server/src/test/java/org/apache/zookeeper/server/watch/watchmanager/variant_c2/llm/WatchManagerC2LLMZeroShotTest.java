// ###Test START##
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0.
 */
package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.junit.Before;
import org.junit.Test;

/**
 * Zero-shot unit tests for {@link WatchManager}.
 *
 * <p>The tests use lightweight recording watchers and therefore do not require
 * a running ZooKeeper server or network connections.</p>
 */
public class WatchManagerC2LLMZeroShotTest {

    private static final String PATH = "/application/node";

    private WatchManager watchManager;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    @Test
    public void shouldStartWithNoWatches() {
        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertTrue(watchManager.getWatch2Paths().isEmpty());
        assertEquals("0 connections watching 0 paths\n", watchManager.toString());
    }

    @Test
    public void shouldAddDefaultWatchAndRejectDuplicate() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher));
        assertFalse(watchManager.addWatch(PATH, watcher));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher(PATH, watcher));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void shouldStoreMultipleModesForSameWatcherAndPathOnlyOnce() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void shouldTriggerAndRemoveOneShotWatch() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = watchManager.triggerWatch(
                PATH,
                EventType.NodeDataChanged,
                42L,
                Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.getEvents().size());

        WatchedEvent event = watcher.getEvents().get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(PATH, event.getPath());
        assertEquals(42L, event.getZxid());

        assertFalse(watchManager.containsWatcher(PATH, watcher));
        assertEquals(0, watchManager.size());
        assertTrue(watchManager.getWatch2Paths().isEmpty());
    }

    @Test
    public void shouldKeepPersistentWatchAfterRepeatedTriggers() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet firstResult = watchManager.triggerWatch(
                PATH, EventType.NodeCreated, 1L, null);
        WatcherOrBitSet secondResult = watchManager.triggerWatch(
                PATH, EventType.NodeChildrenChanged, 2L, null);

        assertNotNull(firstResult);
        assertNotNull(secondResult);
        assertTrue(firstResult.contains(watcher));
        assertTrue(secondResult.contains(watcher));
        assertEquals(2, watcher.getEvents().size());
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void shouldRemoveOnlyStandardModeWhenPersistentModeAlsoExists() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        watchManager.triggerWatch(PATH, EventType.NodeDeleted, 7L, null);

        assertEquals(1, watcher.getEvents().size());
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void shouldTriggerRecursiveWatchForDescendantPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        String parentPath = "/application";

        watchManager.addWatch(parentPath, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = watchManager.triggerWatch(
                PATH, EventType.NodeCreated, 99L, Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.getEvents().size());
        assertEquals(PATH, watcher.getEvents().get(0).getPath());
        assertTrue(watchManager.containsWatcher(
                parentPath, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void shouldNotTriggerNonRecursiveParentWatchForDescendantPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/application", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = watchManager.triggerWatch(
                PATH, EventType.NodeCreated, 1L, null);

        assertNull(result);
        assertTrue(watcher.getEvents().isEmpty());
        assertTrue(watchManager.containsWatcher(
                "/application", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void shouldNotifyDirectAndRecursiveWatcherOnlyOnceWhenSameWatcherMatchesBoth() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/application", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = watchManager.triggerWatch(
                PATH, EventType.NodeDataChanged, 5L, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.getEvents().size());
        assertEquals(2, watchManager.size());
    }

    @Test
    public void shouldSuppressNotificationButStillReturnAndConsumeOneShotWatcher() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(watcher));

        WatcherOrBitSet result = watchManager.triggerWatch(
                PATH, EventType.NodeDeleted, 12L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertTrue(watcher.getEvents().isEmpty());
        assertFalse(watchManager.containsWatcher(PATH, watcher));
        assertEquals(0, watchManager.size());
    }

    @Test
    public void shouldReturnNullWhenPathHasNoMatchingWatcher() {
        assertNull(watchManager.triggerWatch(
                "/missing", EventType.NodeCreated, 0L, null));
    }

    @Test
    public void shouldRemoveSpecificModeWithoutRemovingRemainingModes() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher(
                PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(watchManager.containsWatcher(
                PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(watchManager.containsWatcher(
                PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals(1, watchManager.size());

        assertFalse(watchManager.removeWatcher(
                PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void shouldRemoveAllModesForPathWhenModeIsNull() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher(PATH, watcher, null));

        assertFalse(watchManager.containsWatcher(PATH, watcher));
        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertTrue(watchManager.getWatch2Paths().isEmpty());
    }

    @Test
    public void shouldReturnFalseWhenRemovingUnknownWatch() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertFalse(watchManager.removeWatcher(PATH, watcher));

        watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        assertFalse(watchManager.removeWatcher(
                "/other", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void shouldRemoveWatcherFromEveryPathAndUpdateRecursiveCount() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/one", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/two", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        watchManager.addWatch("/three", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertEquals(3, watchManager.size());
        assertEquals(2, watchManager.getRecursiveWatchQty());

        watchManager.removeWatcher(watcher);

        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertTrue(watchManager.getWatch2Paths().isEmpty());

        watchManager.removeWatcher(watcher);
        assertEquals(0, watchManager.size());
    }

    @Test
    public void shouldMaintainIndependentEntriesForDifferentWatchers() {
        RecordingWatcher firstWatcher = new RecordingWatcher();
        RecordingWatcher secondWatcher = new RecordingWatcher();

        watchManager.addWatch(PATH, firstWatcher);
        watchManager.addWatch(PATH, secondWatcher);

        assertEquals(2, watchManager.size());
        assertEquals(2, watchManager.getWatch2Paths().size());

        watchManager.removeWatcher(PATH, firstWatcher);

        assertFalse(watchManager.containsWatcher(PATH, firstWatcher));
        assertTrue(watchManager.containsWatcher(PATH, secondWatcher));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void shouldExposeConsistentWatchToPathMapping() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/one", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/two", watcher, WatcherMode.PERSISTENT);

        Map<Watcher, Map<String, WatchStats>> watch2Paths =
                watchManager.getWatch2Paths();

        assertEquals(1, watch2Paths.size());
        assertNotNull(watch2Paths.get(watcher));
        assertEquals(2, watch2Paths.get(watcher).size());
        assertTrue(watch2Paths.get(watcher).containsKey("/one"));
        assertTrue(watch2Paths.get(watcher).containsKey("/two"));
    }

    @Test
    public void shouldRenderCurrentWatchInformationAsString() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher);

        String rendered = watchManager.toString();

        assertTrue(rendered.startsWith("1 connections watching 1 paths\n"));
        assertTrue(rendered.contains(PATH + " -> "));
        assertTrue(rendered.contains(watcher.toString()));
    }

    @Test
    public void shutdownShouldLeaveExistingStateUntouched() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(PATH, watcher);

        watchManager.shutdown();

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher(PATH, watcher));
    }

    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        private List<WatchedEvent> getEvents() {
            return events;
        }
    }
}
// ###Test END##
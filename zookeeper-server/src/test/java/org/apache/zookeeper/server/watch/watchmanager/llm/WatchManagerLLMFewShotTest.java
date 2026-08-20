// ###Test START##
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0.
 */
package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for {@link WatchManager}.
 *
 * <p>The suite exercises watch registration, duplicate detection, mode-specific
 * lookup and removal, one-shot delivery, persistent delivery, recursive
 * delivery, watcher-wide cleanup, and basic manager state reporting.</p>
 */
public class WatchManagerLLMFewShotTest {

    private WatchManager manager;
    private RecordingWatcher watcher1;
    private RecordingWatcher watcher2;

    @Before
    public void setUp() {
        manager = new WatchManager();
        watcher1 = new RecordingWatcher();
        watcher2 = new RecordingWatcher();
    }

    @Test
    public void testNewManagerIsEmpty() {
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
        assertEquals("0 connections watching 0 paths\nTotal watches:0", manager.toString());
    }

    @Test
    public void testAddDefaultWatchAndRejectDuplicate() {
        assertTrue(manager.addWatch("/node", watcher1));
        assertFalse(manager.addWatch("/node", watcher1));

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node", watcher1));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/missing", watcher1));
        assertFalse(manager.containsWatcher("/node", watcher2));
    }

    @Test
    public void testSameWatcherCanUseAllModesOnOnePath() {
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testRemoveSingleModePreservesRemainingModes() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", watcher1));
        assertEquals(0, manager.size());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveMismatchChangesNothing() {
        manager.addWatch("/node1", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/node1", watcher2));
        assertFalse(manager.removeWatcher("/node2", watcher1));
        assertFalse(manager.removeWatcher("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveAllModesForPath() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher1));

        assertFalse(manager.containsWatcher("/node", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
        assertFalse(manager.removeWatcher("/node", watcher1));
    }

    @Test
    public void testRemoveWatcherAcrossAllPathsDoesNotAffectOtherWatchers() {
        manager.addWatch("/a", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/b", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a", watcher2, WatcherMode.PERSISTENT);

        manager.removeWatcher(watcher1);

        assertFalse(manager.containsWatcher("/a", watcher1));
        assertFalse(manager.containsWatcher("/b", watcher1));
        assertTrue(manager.containsWatcher("/a", watcher2, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher1);
        assertEquals(1, manager.size());
    }

    @Test
    public void testStandardWatchIsDeliveredOnceAndRemoved() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);

        WatcherOrBitSet fired = manager.triggerWatch("/node", EventType.NodeCreated, 101L, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher1));
        assertEquals(1, watcher1.eventCount());
        assertEvent(watcher1.lastEvent(), "/node", EventType.NodeCreated, 101L);
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertEquals(0, manager.size());

        assertNull(manager.triggerWatch("/node", EventType.NodeDataChanged, 102L, null));
        assertEquals(1, watcher1.eventCount());
    }

    @Test
    public void testPersistentWatchSurvivesMultipleTriggers() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        WatcherOrBitSet first = manager.triggerWatch("/node", EventType.NodeCreated, 201L, null);
        WatcherOrBitSet second = manager.triggerWatch("/node", EventType.NodeDataChanged, 202L, null);

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(2, watcher1.eventCount());
        assertEvent(watcher1.events.get(0), "/node", EventType.NodeCreated, 201L);
        assertEvent(watcher1.events.get(1), "/node", EventType.NodeDataChanged, 202L);
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRecursiveWatchReceivesDescendantEvents() {
        manager.addWatch("/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/root/child/grandchild", EventType.NodeDeleted, 301L, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher1));
        assertEquals(1, watcher1.eventCount());
        assertEvent(watcher1.lastEvent(), "/root/child/grandchild", EventType.NodeDeleted, 301L);
        assertTrue(manager.containsWatcher("/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRecursiveWatchDoesNotMatchSiblingPath() {
        manager.addWatch("/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        assertNull(manager.triggerWatch("/rooted/child", EventType.NodeCreated, 401L, null));
        assertEquals(0, watcher1.eventCount());
        assertTrue(manager.containsWatcher("/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testStandardAndPersistentModesDeliverWatcherOnlyOncePerTrigger() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        WatcherOrBitSet fired = manager.triggerWatch("/node", EventType.NodeChildrenChanged, 501L, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher1));
        assertEquals(1, watcher1.eventCount());
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerNotifiesAllWatchersOnPath() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher2, WatcherMode.STANDARD);

        WatcherOrBitSet fired = manager.triggerWatch("/node", EventType.NodeCreated, 601L, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher1));
        assertTrue(fired.contains(watcher2));
        assertEquals(1, watcher1.eventCount());
        assertEquals(1, watcher2.eventCount());
        assertEquals(0, manager.size());
    }

    @Test
    public void testInternalPathMapTracksModesAndPaths() {
        manager.addWatch("/a", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/b", watcher1, WatcherMode.PERSISTENT);

        Map<Watcher, Map<String, WatchStats>> watch2Paths = manager.getWatch2Paths();

        assertEquals(1, watch2Paths.size());
        assertTrue(watch2Paths.containsKey(watcher1));
        assertEquals(2, watch2Paths.get(watcher1).size());
        assertTrue(watch2Paths.get(watcher1).get("/a").hasMode(WatcherMode.STANDARD));
        assertTrue(watch2Paths.get(watcher1).get("/b").hasMode(WatcherMode.PERSISTENT));
    }

    @Test
    public void testToStringCountsConnectionsPathsAndWatchAssociations() {
        manager.addWatch("/a", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/b", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/a", watcher2, WatcherMode.STANDARD);

        assertEquals(3, manager.size());
        assertEquals("2 connections watching 2 paths\nTotal watches:3", manager.toString());
    }

    @Test
    public void testShutdownLeavesRegisteredWatchesUntouched() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        manager.shutdown();

        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    private static void assertEvent(
            WatchedEvent event,
            String expectedPath,
            EventType expectedType,
            long expectedZxid) {
        assertNotNull(event);
        assertEquals(expectedPath, event.getPath());
        assertSame(expectedType, event.getType());
        assertSame(KeeperState.SyncConnected, event.getState());
        assertEquals(expectedZxid, event.getZxid());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        private int eventCount() {
            return events.size();
        }

        private WatchedEvent lastEvent() {
            return events.isEmpty() ? null : events.get(events.size() - 1);
        }
    }
}
// ###Test END##
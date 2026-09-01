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
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for {@link WatchManager}.
 *
 * <p>The tests cover watch registration, duplicate registration, watcher
 * modes, direct and recursive triggering, suppression, removal, internal
 * consistency, watch counts, event delivery and diagnostic output.</p>
 */
public class WatchManagerC2LLMFewShotTest {

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

        String description = manager.toString();
        assertTrue(description.contains("0 connections watching 0 paths"));
    }

    @Test
    public void testAddWatchUsingDefaultMode() {
        assertTrue(manager.addWatch("/node1", watcher1));

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.DEFAULT_WATCHER_MODE));

        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testAddingSameWatchAndModeTwiceReturnsFalse() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertFalse(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertEquals(1, manager.size());
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
    }

    @Test
    public void testContainsWatcherForAllSupportedModes() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node1", watcher1, null));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/node2", watcher1));
    }

    @Test
    public void testSamePathCanBeWatchedByMultipleWatchers() {
        assertTrue(manager.addWatch("/shared", watcher1));
        assertTrue(manager.addWatch("/shared", watcher2));

        assertEquals(2, manager.size());
        assertTrue(manager.containsWatcher("/shared", watcher1));
        assertTrue(manager.containsWatcher("/shared", watcher2));
        assertEquals(2, manager.getWatch2Paths().size());
    }

    @Test
    public void testSameWatcherCanWatchMultiplePaths() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node2", watcher1));
        assertTrue(manager.addWatch("/node3", watcher1));

        assertEquals(3, manager.size());
        assertEquals(1, manager.getWatch2Paths().size());
        assertEquals(3, manager.getWatch2Paths().get(watcher1).size());

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node2", watcher1));
        assertTrue(manager.containsWatcher("/node3", watcher1));
    }

    @Test
    public void testStandardWatchIsConsumedAfterTrigger() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeCreated,
                        101L,
                        null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/node1",
                EventType.NodeCreated,
                KeeperState.SyncConnected);

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertTrue(manager.getWatch2Paths().isEmpty());

        assertNull(
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeDataChanged,
                        102L,
                        null));

        assertEquals(1, watcher1.getEventCount());
    }

    @Test
    public void testPersistentWatchRemainsAfterMultipleTriggers() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));

        WatcherOrBitSet firstResult =
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeCreated,
                        201L,
                        null);

        WatcherOrBitSet secondResult =
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeDataChanged,
                        202L,
                        null);

        assertNotNull(firstResult);
        assertNotNull(secondResult);
        assertTrue(firstResult.contains(watcher1));
        assertTrue(secondResult.contains(watcher1));

        assertEquals(2, watcher1.getEventCount());
        assertEvent(
                watcher1.getEvent(0),
                "/node1",
                EventType.NodeCreated,
                KeeperState.SyncConnected);
        assertEvent(
                watcher1.getEvent(1),
                "/node1",
                EventType.NodeDataChanged,
                KeeperState.SyncConnected);

        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerRemovesStandardModeButKeepsPersistentMode() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));

        manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                301L,
                null);

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, watcher1.getEventCount());

        manager.triggerWatch(
                "/node1",
                EventType.NodeDeleted,
                302L,
                null);

        assertEquals(2, watcher1.getEventCount());
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
    }

    @Test
    public void testPersistentRecursiveWatchReceivesDescendantEvents() {
        assertTrue(
                manager.addWatch(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.getRecursiveWatchQty());

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/root/child/grandchild",
                        EventType.NodeCreated,
                        401L,
                        null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/root/child/grandchild",
                EventType.NodeCreated,
                KeeperState.SyncConnected);

        assertTrue(
                manager.containsWatcher(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRecursiveAndDirectWatcherAreBothTriggered() {
        assertTrue(
                manager.addWatch(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(
                manager.addWatch(
                        "/root/child",
                        watcher2,
                        WatcherMode.STANDARD));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/root/child",
                        EventType.NodeDataChanged,
                        501L,
                        null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));

        assertEquals(1, watcher1.getEventCount());
        assertEquals(1, watcher2.getEventCount());

        assertTrue(
                manager.containsWatcher(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/root/child", watcher2));
        assertEquals(1, manager.size());
    }

    @Test
    public void testStandardWatchOnParentDoesNotReceiveChildEvent() {
        assertTrue(
                manager.addWatch(
                        "/root",
                        watcher1,
                        WatcherMode.STANDARD));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/root/child",
                        EventType.NodeCreated,
                        601L,
                        null);

        assertNull(result);
        assertEquals(0, watcher1.getEventCount());
        assertTrue(
                manager.containsWatcher(
                        "/root",
                        watcher1,
                        WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerForUnwatchedPathReturnsNull() {
        assertNull(
                manager.triggerWatch(
                        "/missing",
                        EventType.NodeCreated,
                        701L,
                        null));

        assertEquals(0, watcher1.getEventCount());
        assertEquals(0, manager.size());
    }

    @Test
    public void testSuppressPreventsNotificationButWatcherIsStillCollected() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher2,
                        WatcherMode.STANDARD));

        WatcherOrBitSet suppress =
                new WatcherOrBitSet(Collections.<Watcher>singleton(watcher1));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeCreated,
                        801L,
                        null,
                        suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));

        assertEquals(0, watcher1.getEventCount());
        assertEquals(1, watcher2.getEventCount());

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertEquals(0, manager.size());
    }

    @Test
    public void testRemoveSpecificModeKeepsOtherModes() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemovePersistentRecursiveModeUpdatesRecursiveCount() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(0, manager.getRecursiveWatchQty());
        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher("/node1", watcher1));
    }

    @Test
    public void testRemoveAllModesForPathUsingNullMode() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher("/node1", watcher1, null));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveWatcherFromAllPaths() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node2",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.addWatch(
                        "/node3",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(
                manager.addWatch(
                        "/other",
                        watcher2,
                        WatcherMode.STANDARD));

        assertEquals(4, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher1);

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertFalse(manager.containsWatcher("/node3", watcher1));

        assertTrue(manager.containsWatcher("/other", watcher2));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.getWatch2Paths().containsKey(watcher1));
        assertTrue(manager.getWatch2Paths().containsKey(watcher2));
    }

    @Test
    public void testRemovingUnknownWatcherDoesNotChangeState() {
        assertTrue(manager.addWatch("/node1", watcher1));

        manager.removeWatcher(watcher2);

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertFalse(manager.containsWatcher("/node1", watcher2));
    }

    @Test
    public void testRemoveWatcherReturnsFalseForUnknownPath() {
        assertTrue(manager.addWatch("/node1", watcher1));

        assertFalse(manager.removeWatcher("/missing", watcher1));
        assertFalse(
                manager.removeWatcher(
                        "/missing",
                        watcher1,
                        WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveWatcherReturnsFalseForUnknownWatcher() {
        assertTrue(manager.addWatch("/node1", watcher1));

        assertFalse(manager.removeWatcher("/node1", watcher2));
        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher2,
                        WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveWatcherReturnsFalseForModeNotRegistered() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));

        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveOneWatchDoesNotBreakOtherPairs() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.addWatch(
                        "/node2",
                        watcher2,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.addWatch(
                        "/node2",
                        watcher2,
                        WatcherMode.PERSISTENT));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
        assertTrue(
                manager.containsWatcher(
                        "/node2",
                        watcher2,
                        WatcherMode.STANDARD));
        assertTrue(
                manager.containsWatcher(
                        "/node2",
                        watcher2,
                        WatcherMode.PERSISTENT));
    }

    @Test
    public void testEachWatcherReceivesExactlyOneEventPerTrigger() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node1", watcher2));

        manager.triggerWatch(
                "/node1",
                EventType.NodeChildrenChanged,
                901L,
                null);

        assertEquals(1, watcher1.getEventCount());
        assertEquals(1, watcher2.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/node1",
                EventType.NodeChildrenChanged,
                KeeperState.SyncConnected);
        assertEvent(
                watcher2.getLastEvent(),
                "/node1",
                EventType.NodeChildrenChanged,
                KeeperState.SyncConnected);
    }

    @Test
    public void testPersistentWatcherReceivesDifferentEventTypes() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));

        manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                1001L,
                null);
        manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                1002L,
                null);
        manager.triggerWatch(
                "/node1",
                EventType.NodeChildrenChanged,
                1003L,
                null);
        manager.triggerWatch(
                "/node1",
                EventType.NodeDeleted,
                1004L,
                null);

        assertEquals(4, watcher1.getEventCount());
        assertEquals(
                EventType.NodeCreated,
                watcher1.getEvent(0).getType());
        assertEquals(
                EventType.NodeDataChanged,
                watcher1.getEvent(1).getType());
        assertEquals(
                EventType.NodeChildrenChanged,
                watcher1.getEvent(2).getType());
        assertEquals(
                EventType.NodeDeleted,
                watcher1.getEvent(3).getType());

        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT));
    }

    @Test
    public void testToStringContainsRegisteredPaths() {
        assertTrue(manager.addWatch("/alpha", watcher1));
        assertTrue(manager.addWatch("/beta", watcher2));

        String description = manager.toString();

        assertTrue(description.contains("2 connections watching 2 paths"));
        assertTrue(description.contains("/alpha ->"));
        assertTrue(description.contains("/beta ->"));
    }

    @Test
    public void testRemovingLastWatchCleansInternalWatcherMapping() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertNotNull(manager.getWatch2Paths().get(watcher1));

        assertTrue(manager.removeWatcher("/node1", watcher1));

        assertFalse(manager.getWatch2Paths().containsKey(watcher1));
        assertTrue(manager.getWatch2Paths().isEmpty());
        assertEquals(0, manager.size());
    }

    @Test
    public void testShutdownDoesNotModifyRegisteredWatches() {
        assertTrue(manager.addWatch("/node1", watcher1));

        manager.shutdown();

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node1", watcher1));
    }

    private static void assertEvent(
            WatchedEvent event,
            String expectedPath,
            EventType expectedType,
            KeeperState expectedState) {

        assertNotNull(event);
        assertEquals(expectedPath, event.getPath());
        assertEquals(expectedType, event.getType());
        assertEquals(expectedState, event.getState());
    }

    /**
     * Simple watcher implementation that records every delivered event.
     */
    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        private int getEventCount() {
            return events.size();
        }

        private WatchedEvent getEvent(int index) {
            return events.get(index);
        }

        private WatchedEvent getLastEvent() {
            if (events.isEmpty()) {
                return null;
            }
            return events.get(events.size() - 1);
        }
    }
}
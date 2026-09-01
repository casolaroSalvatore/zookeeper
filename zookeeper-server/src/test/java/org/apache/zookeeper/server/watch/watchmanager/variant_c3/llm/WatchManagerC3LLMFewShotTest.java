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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for {@link WatchManager}.
 */
public class WatchManagerC3LLMFewShotTest {

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

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(0, summary.getNumConnections());
        assertEquals(0, summary.getNumPaths());
        assertEquals(0, summary.getTotalWatches());
    }

    @Test
    public void testAddDefaultWatchUsesStandardMode() {
        assertTrue(manager.addWatch("/node1", watcher1));

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.DEFAULT_WATCHER_MODE
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testAddingSameModeTwiceReturnsFalse() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertFalse(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testAddMultipleModesForSamePathAndWatcher() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        assertEquals(
                "The size counts watcher-path pairs rather than individual modes",
                1,
                manager.size()
        );
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node1", watcher1, null));
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testContainsWatcherReturnsFalseForMismatches() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/node2", watcher2));

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testSizeCountsWatcherPathAssociations() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node1", watcher2));
        assertTrue(manager.addWatch("/node2", watcher1));

        assertEquals(3, manager.size());

        assertFalse(manager.addWatch("/node1", watcher1));
        assertEquals(3, manager.size());

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertEquals(
                "Adding another mode must not create another watcher-path entry",
                3,
                manager.size()
        );
    }

    @Test
    public void testRemoveSpecificModePreservesOtherModes() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveLastSpecificModeRemovesWatcherPathPair() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveWatcherWithoutModeRemovesAllModesForPath() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        assertEquals(1, manager.getRecursiveWatchQty());
        assertTrue(manager.removeWatcher("/node1", watcher1));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveWatcherFromOnePathPreservesOtherPaths() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node2", watcher1));

        assertTrue(manager.removeWatcher("/node1", watcher1));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node2", watcher1));
        assertEquals(1, manager.size());

        Map<String, WatchStats> remainingPaths =
                manager.getWatch2Paths().get(watcher1);

        assertNotNull(remainingPaths);
        assertEquals(1, remainingPaths.size());
        assertTrue(remainingPaths.containsKey("/node2"));
    }

    @Test
    public void testRemoveUnknownWatcherOrPathReturnsFalse() {
        assertTrue(manager.addWatch("/node1", watcher1));

        assertFalse(manager.removeWatcher("/node1", watcher2));
        assertFalse(manager.removeWatcher("/node2", watcher1));
        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveWatcherObjectRemovesAllItsPaths() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node2", watcher1));
        assertTrue(
                manager.addWatch(
                        "/node3",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertTrue(manager.addWatch("/node1", watcher2));

        manager.removeWatcher(watcher1);

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertFalse(manager.containsWatcher("/node3", watcher1));

        assertTrue(manager.containsWatcher("/node1", watcher2));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.getWatch2Paths().containsKey(watcher1));
    }

    @Test
    public void testRemoveUnknownWatcherObjectDoesNothing() {
        manager.removeWatcher(watcher1);

        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testStandardWatchIsConsumedAfterTrigger() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                10L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/node1",
                EventType.NodeCreated,
                10L
        );

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());

        assertNull(
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeDataChanged,
                        11L,
                        null
                )
        );
        assertEquals(1, watcher1.getEventCount());
    }

    @Test
    public void testPersistentWatchSurvivesMultipleTriggers() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        WatcherOrBitSet firstResult = manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                20L,
                null
        );
        WatcherOrBitSet secondResult = manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                21L,
                null
        );

        assertNotNull(firstResult);
        assertNotNull(secondResult);
        assertTrue(firstResult.contains(watcher1));
        assertTrue(secondResult.contains(watcher1));

        assertEquals(2, watcher1.getEventCount());
        assertEvent(
                watcher1.getEvent(0),
                "/node1",
                EventType.NodeCreated,
                20L
        );
        assertEvent(
                watcher1.getEvent(1),
                "/node1",
                EventType.NodeDataChanged,
                21L
        );

        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerConsumesOnlyStandardMode() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                30L,
                null
        );

        assertEquals(1, watcher1.getEventCount());
        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                31L,
                null
        );

        assertEquals(2, watcher1.getEventCount());
        assertTrue(manager.containsWatcher("/node1", watcher1));
    }

    @Test
    public void testTriggerNotifiesAllWatchersOnExactPath() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node1", watcher2));

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeDeleted,
                40L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));

        assertEquals(1, watcher1.getEventCount());
        assertEquals(1, watcher2.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/node1",
                EventType.NodeDeleted,
                40L
        );
        assertEvent(
                watcher2.getLastEvent(),
                "/node1",
                EventType.NodeDeleted,
                40L
        );

        assertEquals(0, manager.size());
    }

    @Test
    public void testTriggerUnknownPathReturnsNull() {
        assertTrue(manager.addWatch("/node1", watcher1));

        WatcherOrBitSet result = manager.triggerWatch(
                "/unknown",
                EventType.NodeCreated,
                50L,
                null
        );

        assertNull(result);
        assertEquals(0, watcher1.getEventCount());
        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testStandardParentWatchIsNotTriggeredByChildPath() {
        assertTrue(
                manager.addWatch(
                        "/parent",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/parent/child",
                EventType.NodeCreated,
                60L,
                null
        );

        assertNull(result);
        assertEquals(0, watcher1.getEventCount());
        assertTrue(manager.containsWatcher("/parent", watcher1));
    }

    @Test
    public void testPersistentRecursiveWatchTriggersForDescendant() {
        assertTrue(
                manager.addWatch(
                        "/parent",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        assertEquals(1, manager.getRecursiveWatchQty());

        WatcherOrBitSet result = manager.triggerWatch(
                "/parent/child/grandchild",
                EventType.NodeCreated,
                70L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.getEventCount());

        assertEvent(
                watcher1.getLastEvent(),
                "/parent/child/grandchild",
                EventType.NodeCreated,
                70L
        );

        assertTrue(
                manager.containsWatcher(
                        "/parent",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testPersistentRecursiveWatchSurvivesRepeatedDescendantTriggers() {
        assertTrue(
                manager.addWatch(
                        "/parent",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        manager.triggerWatch(
                "/parent/child1",
                EventType.NodeCreated,
                80L,
                null
        );
        manager.triggerWatch(
                "/parent/child2",
                EventType.NodeDeleted,
                81L,
                null
        );

        assertEquals(2, watcher1.getEventCount());
        assertEvent(
                watcher1.getEvent(0),
                "/parent/child1",
                EventType.NodeCreated,
                80L
        );
        assertEvent(
                watcher1.getEvent(1),
                "/parent/child2",
                EventType.NodeDeleted,
                81L
        );

        assertTrue(manager.containsWatcher("/parent", watcher1));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRecursiveWatcherIsDeliveredOnlyOnceForExactPath() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                90L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.getEventCount());
        assertTrue(manager.containsWatcher("/node1", watcher1));
    }

    @Test
    public void testSameWatcherOnDirectAndRecursiveParentIsNotNotifiedTwice() {
        assertTrue(
                manager.addWatch(
                        "/parent",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertTrue(
                manager.addWatch(
                        "/parent/child",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/parent/child",
                EventType.NodeDataChanged,
                100L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(
                "A watcher collected from multiple paths must be notified once",
                1,
                watcher1.getEventCount()
        );

        assertTrue(
                manager.containsWatcher(
                        "/parent",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/parent/child",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testRecursiveWatchCountTracksDistinctRecursiveRegistrations() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node2",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher2,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );

        assertEquals(3, manager.getRecursiveWatchQty());

        assertFalse(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(3, manager.getRecursiveWatchQty());

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(2, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher1);
        assertEquals(1, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher2);
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testSummaryCountsConnectionsPathsAndWatcherPathPairs() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node2", watcher1));
        assertTrue(manager.addWatch("/node1", watcher2));

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        WatchesSummary summary = manager.getWatchesSummary();

        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
    }

    @Test
    public void testToStringReflectsSummary() {
        assertTrue(manager.addWatch("/node1", watcher1));
        assertTrue(manager.addWatch("/node2", watcher1));
        assertTrue(manager.addWatch("/node1", watcher2));

        assertEquals(
                "2 connections watching 2 paths\nTotal watches:3",
                manager.toString()
        );
    }

    @Test
    public void testGetWatch2PathsContainsExpectedMappings() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.addWatch(
                        "/node2",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        Map<Watcher, Map<String, WatchStats>> watch2Paths =
                manager.getWatch2Paths();

        assertEquals(1, watch2Paths.size());
        assertTrue(watch2Paths.containsKey(watcher1));

        Map<String, WatchStats> watchedPaths = watch2Paths.get(watcher1);
        assertEquals(2, watchedPaths.size());
        assertTrue(watchedPaths.containsKey("/node1"));
        assertTrue(watchedPaths.containsKey("/node2"));

        assertTrue(
                watchedPaths.get("/node1").hasMode(WatcherMode.STANDARD)
        );
        assertTrue(
                watchedPaths.get("/node2").hasMode(WatcherMode.PERSISTENT)
        );
    }

    @Test
    public void testShutdownDoesNotRemoveExistingWatches() {
        assertTrue(manager.addWatch("/node1", watcher1));

        manager.shutdown();

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testEventContainsExpectedStateAndPath() {
        assertTrue(manager.addWatch("/node1", watcher1));

        manager.triggerWatch(
                "/node1",
                EventType.NodeChildrenChanged,
                110L,
                null
        );

        WatchedEvent event = watcher1.getLastEvent();
        assertNotNull(event);
        assertSame(EventType.NodeChildrenChanged, event.getType());
        assertSame(
                Watcher.Event.KeeperState.SyncConnected,
                event.getState()
        );
        assertEquals("/node1", event.getPath());
        assertEquals(110L, event.getZxid());
    }

    private static void assertEvent(
            WatchedEvent event,
            String expectedPath,
            EventType expectedType,
            long expectedZxid
    ) {
        assertNotNull(event);
        assertEquals(expectedPath, event.getPath());
        assertSame(expectedType, event.getType());
        assertSame(
                Watcher.Event.KeeperState.SyncConnected,
                event.getState()
        );
        assertEquals(expectedZxid, event.getZxid());
    }

    /**
     * Minimal watcher implementation that records every delivered event.
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
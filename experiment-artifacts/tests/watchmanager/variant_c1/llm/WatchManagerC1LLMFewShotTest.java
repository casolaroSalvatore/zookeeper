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
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for {@link WatchManager}.
 */
public class WatchManagerC1LLMFewShotTest {

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
    public void testInitialState() {
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(0, summary.getNumConnections());
        assertEquals(0, summary.getNumPaths());
        assertEquals(0, summary.getTotalWatches());
    }

    @Test
    public void testAddDefaultWatch() {
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
        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testAddingDuplicateModeReturnsFalse() {
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

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.containsWatcher("/node1", watcher1));
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
    public void testContainsWatcherWithNullModeMatchesAnyMode() {
        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node1", watcher1, null));

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
    public void testContainsWatcherReturnsFalseForUnknownWatcherOrPath() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/missing", watcher1));
        assertFalse(
                manager.containsWatcher(
                        "/missing",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testRemoveSpecificModePreservesRemainingModes() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
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
    public void testRemoveLastModeRemovesWatcherAndPathAssociation() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertTrue(manager.getWatch2Paths().isEmpty());

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(0, summary.getNumConnections());
        assertEquals(0, summary.getNumPaths());
        assertEquals(0, summary.getTotalWatches());
    }

    @Test
    public void testRemoveAllModesUsingNullMode() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        assertTrue(manager.removeWatcher("/node1", watcher1, null));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveWatcherByPathDelegatesToNullModeRemoval() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        assertTrue(manager.removeWatcher("/node1", watcher1));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveMissingModeReturnsFalseAndPreservesWatch() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        assertFalse(
                manager.removeWatcher(
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
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveUnknownPathOrWatcherReturnsFalse() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        assertFalse(manager.removeWatcher("/missing", watcher1));
        assertFalse(manager.removeWatcher("/node1", watcher2));
        assertFalse(
                manager.removeWatcher(
                        "/missing",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher2,
                        WatcherMode.PERSISTENT
                )
        );

        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testRemoveWatcherFromAllPaths() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node2",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node3",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );
        manager.addWatch(
                "/node2",
                watcher2,
                WatcherMode.STANDARD
        );

        assertEquals(4, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher1);

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertFalse(manager.containsWatcher("/node3", watcher1));

        assertTrue(manager.containsWatcher("/node2", watcher2));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveUnknownWatcherDoesNothing() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );

        manager.removeWatcher(watcher2);

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertEquals(1, manager.size());
    }

    @Test
    public void testStandardWatchIsTriggeredAndRemoved() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                10L,
                null
        );

        assertNotNull(result);
        assertEquals(1, watcher1.getEvents().size());

        WatchedEvent event = watcher1.getLastEvent();
        assertEquals("/node1", event.getPath());
        assertEquals(EventType.NodeCreated, event.getType());
        assertEquals(10L, event.getZxid());

        assertFalse(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertEquals(0, manager.size());
    }

    @Test
    public void testPersistentWatchSurvivesMultipleTriggers() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        assertNotNull(
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeCreated,
                        11L,
                        null
                )
        );
        assertNotNull(
                manager.triggerWatch(
                        "/node1",
                        EventType.NodeDataChanged,
                        12L,
                        null
                )
        );

        assertEquals(2, watcher1.getEvents().size());

        assertEquals(
                EventType.NodeCreated,
                watcher1.getEvents().get(0).getType()
        );
        assertEquals(
                EventType.NodeDataChanged,
                watcher1.getEvents().get(1).getType()
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
    public void testTriggerRemovesOnlyStandardMode() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                13L,
                null
        );

        assertEquals(1, watcher1.getEvents().size());
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
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerUnknownPathReturnsNull() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/missing",
                EventType.NodeCreated,
                14L,
                null
        );

        assertNull(result);
        assertTrue(watcher1.getEvents().isEmpty());
        assertTrue(manager.containsWatcher("/node1", watcher1));
    }

    @Test
    public void testTriggerNotifiesAllWatchersOnSamePath() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher2,
                WatcherMode.STANDARD
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeDeleted,
                15L,
                null
        );

        assertNotNull(result);
        assertEquals(1, watcher1.getEvents().size());
        assertEquals(1, watcher2.getEvents().size());

        assertEquals(
                EventType.NodeDeleted,
                watcher1.getLastEvent().getType()
        );
        assertEquals(
                EventType.NodeDeleted,
                watcher2.getLastEvent().getType()
        );

        assertEquals(0, manager.size());
    }

    @Test
    public void testTriggerOnlyNotifiesWatchersForMatchingPath() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node2",
                watcher2,
                WatcherMode.STANDARD
        );

        manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                16L,
                null
        );

        assertEquals(1, watcher1.getEvents().size());
        assertTrue(watcher2.getEvents().isEmpty());

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node2", watcher2));
    }

    @Test
    public void testRecursiveWatchReceivesDescendantEvent() {
        manager.addWatch(
                "/root",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child/grandchild",
                EventType.NodeCreated,
                17L,
                null
        );

        assertNotNull(result);
        assertEquals(1, watcher1.getEvents().size());

        WatchedEvent event = watcher1.getLastEvent();
        assertEquals("/root/child/grandchild", event.getPath());
        assertEquals(EventType.NodeCreated, event.getType());
        assertEquals(17L, event.getZxid());

        assertTrue(
                manager.containsWatcher(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRecursiveWatchDoesNotMatchSiblingPath() {
        manager.addWatch(
                "/root/child",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/other",
                EventType.NodeCreated,
                18L,
                null
        );

        assertNull(result);
        assertTrue(watcher1.getEvents().isEmpty());
        assertTrue(
                manager.containsWatcher(
                        "/root/child",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testDirectAndRecursiveWatchNotifyWatcherOnlyOnce() {
        manager.addWatch(
                "/root/child",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/root",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child",
                EventType.NodeDataChanged,
                19L,
                null
        );

        assertNotNull(result);
        assertEquals(1, watcher1.getEvents().size());

        assertFalse(
                manager.containsWatcher(
                        "/root/child",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );
        assertTrue(
                manager.containsWatcher(
                        "/root",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testSuppressedWatcherIsNotNotified() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher2,
                WatcherMode.PERSISTENT
        );

        WatcherOrBitSet suppress = manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                20L,
                null
        );

        assertNotNull(suppress);
        assertEquals(1, watcher1.getEvents().size());
        assertEquals(1, watcher2.getEvents().size());

        WatcherOrBitSet secondResult = manager.triggerWatch(
                "/node1",
                EventType.NodeDataChanged,
                21L,
                null,
                suppress
        );

        assertNotNull(secondResult);
        assertEquals(1, watcher1.getEvents().size());
        assertEquals(1, watcher2.getEvents().size());

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
                        watcher2,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testWatcherOrBitSetReturnedByTriggerContainsWatchers() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher2,
                WatcherMode.PERSISTENT
        );

        WatcherOrBitSet result = manager.triggerWatch(
                "/node1",
                EventType.NodeCreated,
                22L,
                null
        );

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));
    }

    @Test
    public void testSizeCountsWatcherPathAssociations() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher2,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node2",
                watcher1,
                WatcherMode.STANDARD
        );

        assertEquals(3, manager.size());
    }

    @Test
    public void testWatchSummaryCountsUniqueWatchAssociations() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node1",
                watcher2,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node2",
                watcher1,
                WatcherMode.PERSISTENT
        );

        WatchesSummary summary = manager.getWatchesSummary();

        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
    }

    @Test
    public void testToStringContainsWatchersAndPaths() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node2",
                watcher1,
                WatcherMode.PERSISTENT
        );
        manager.addWatch(
                "/node3",
                watcher2,
                WatcherMode.STANDARD
        );

        String description = manager.toString();

        assertTrue(description.contains(watcher1.toString()));
        assertTrue(description.contains(watcher2.toString()));
        assertTrue(description.contains("/node1"));
        assertTrue(description.contains("/node2"));
        assertTrue(description.contains("/node3"));
    }

    @Test
    public void testRecursiveWatchCountTracksAddAndRemove() {
        assertEquals(0, manager.getRecursiveWatchQty());

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(1, manager.getRecursiveWatchQty());

        assertFalse(
                manager.addWatch(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
        assertEquals(1, manager.getRecursiveWatchQty());

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
    public void testRemovingNonRecursiveModeDoesNotChangeRecursiveCount() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT_RECURSIVE
        );

        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD
                )
        );

        assertEquals(1, manager.getRecursiveWatchQty());
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT_RECURSIVE
                )
        );
    }

    @Test
    public void testShutdownDoesNotAlterManagerState() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.PERSISTENT
        );

        manager.shutdown();

        assertEquals(1, manager.size());
        assertTrue(
                manager.containsWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.PERSISTENT
                )
        );
    }

    @Test
    public void testTriggeredEventInstanceIsDeliveredToWatcher() {
        manager.addWatch(
                "/node1",
                watcher1,
                WatcherMode.STANDARD
        );

        manager.triggerWatch(
                "/node1",
                EventType.NodeChildrenChanged,
                23L,
                null
        );

        WatchedEvent event = watcher1.getLastEvent();

        assertNotNull(event);
        assertSame(event, watcher1.getEvents().get(0));
        assertEquals("/node1", event.getPath());
        assertEquals(EventType.NodeChildrenChanged, event.getType());
        assertEquals(23L, event.getZxid());
    }

    /**
     * Simple watcher implementation that records delivered events without
     * depending on private test utilities from other ZooKeeper test classes.
     */
    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        private List<WatchedEvent> getEvents() {
            return events;
        }

        private WatchedEvent getLastEvent() {
            if (events.isEmpty()) {
                return null;
            }
            return events.get(events.size() - 1);
        }
    }
}
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
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for {@link WatchManager}.
 *
 * <p>The tests use an in-memory watcher so that they do not require a live
 * ZooKeeper server or a {@code ServerCnxn} instance.</p>
 */
public class WatchManagerC4LLMFewShotTest {

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
        assertTrue(manager.containsWatcher(
                "/node", watcher1, WatcherMode.DEFAULT_WATCHER_MODE));
        assertFalse(manager.containsWatcher("/missing", watcher1));
        assertFalse(manager.containsWatcher("/node", watcher2));
    }

    @Test
    public void testSameWatcherCanUseAllModesOnOnePath() {
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testSizeCountsPathWatcherRegistrationsRatherThanModes() {
        assertTrue(manager.addWatch("/a", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/a", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/a", watcher2, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/b", watcher1, WatcherMode.STANDARD));

        assertEquals(3, manager.size());
    }

    @Test
    public void testRemoveSingleModePreservesRemainingModes() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveLastModeRemovesBothIndexes() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher("/node", watcher1));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveAllModesForOnePath() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/other", watcher1, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/node", watcher1, null));

        assertFalse(manager.containsWatcher("/node", watcher1));
        assertTrue(manager.containsWatcher("/other", watcher1));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveMismatchChangesNothing() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/node", watcher2));
        assertFalse(manager.removeWatcher("/missing", watcher1));
        assertFalse(manager.removeWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveWatcherFromEveryPath() {
        manager.addWatch("/a", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/b", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher2, WatcherMode.STANDARD);

        manager.removeWatcher(watcher1);

        assertFalse(manager.containsWatcher("/a", watcher1));
        assertFalse(manager.containsWatcher("/b", watcher1));
        assertTrue(manager.containsWatcher("/b", watcher2));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher1);
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerWithNoMatchingWatcherReturnsNull() {
        manager.addWatch("/other", watcher1);

        WatcherOrBitSet result = manager.triggerWatch(
                "/missing", EventType.NodeCreated, 10L, null);

        assertNull(result);
        assertEquals(0, watcher1.eventCount());
        assertTrue(manager.containsWatcher("/other", watcher1));
    }

    @Test
    public void testStandardWatchIsTriggeredAndConsumed() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeCreated, 11L, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.eventCount());
        assertEvent(watcher1.lastEvent(), "/node", EventType.NodeCreated, 11L);
        assertFalse(manager.containsWatcher("/node", watcher1));
        assertEquals(0, manager.size());

        assertNull(manager.triggerWatch(
                "/node", EventType.NodeDeleted, 12L, null));
        assertEquals(1, watcher1.eventCount());
    }

    @Test
    public void testPersistentWatchSurvivesRepeatedTriggers() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        manager.triggerWatch("/node", EventType.NodeCreated, 20L, null);
        manager.triggerWatch("/node", EventType.NodeDataChanged, 21L, null);

        assertEquals(2, watcher1.eventCount());
        assertEvent(watcher1.lastEvent(), "/node", EventType.NodeDataChanged, 21L);
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testTriggerConsumesOnlyStandardMode() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        manager.triggerWatch("/node", EventType.NodeCreated, 30L, null);

        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, watcher1.eventCount());

        manager.triggerWatch("/node", EventType.NodeDeleted, 31L, null);
        assertEquals(2, watcher1.eventCount());
    }

    @Test
    public void testRecursiveWatchReceivesDescendantEvent() {
        manager.addWatch(
                "/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child/grandchild",
                EventType.NodeChildrenChanged,
                40L,
                null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.eventCount());
        assertEvent(
                watcher1.lastEvent(),
                "/root/child/grandchild",
                EventType.NodeChildrenChanged,
                40L);
        assertTrue(manager.containsWatcher(
                "/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testNonRecursiveParentWatchDoesNotReceiveDescendantEvent() {
        manager.addWatch("/root", watcher1, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child", EventType.NodeCreated, 41L, null);

        assertNull(result);
        assertEquals(0, watcher1.eventCount());
        assertTrue(manager.containsWatcher("/root", watcher1, WatcherMode.PERSISTENT));
    }

    @Test
    public void testDirectAndRecursiveWatchersAreTriggeredTogether() {
        manager.addWatch("/root", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/root/child", watcher2, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child", EventType.NodeCreated, 50L, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));
        assertEquals(1, watcher1.eventCount());
        assertEquals(1, watcher2.eventCount());
        assertTrue(manager.containsWatcher("/root", watcher1));
        assertFalse(manager.containsWatcher("/root/child", watcher2));
    }

    @Test
    public void testSuppressedWatcherIsReturnedButNotNotified() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher2, WatcherMode.PERSISTENT);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(watcher1));

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeCreated, 60L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));
        assertEquals(0, watcher1.eventCount());
        assertEquals(1, watcher2.eventCount());
        assertTrue(manager.containsWatcher("/node", watcher1));
        assertTrue(manager.containsWatcher("/node", watcher2));
    }

    @Test
    public void testEventPassedToWatcherHasExpectedFields() {
        manager.addWatch("/node", watcher1);

        manager.triggerWatch("/node", EventType.NodeDeleted, 77L, null);

        WatchedEvent event = watcher1.lastEvent();
        assertNotNull(event);
        assertEquals(EventType.NodeDeleted, event.getType());
        assertEquals(Watcher.Event.KeeperState.SyncConnected, event.getState());
        assertEquals("/node", event.getPath());
        assertEquals(77L, event.getZxid());
    }

    @Test
    public void testToStringReportsConnectionsPathsAndWatches() {
        manager.addWatch("/a", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/b", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher2, WatcherMode.STANDARD);

        assertEquals(
                "2 connections watching 2 paths\nTotal watches:3",
                manager.toString());
    }

    @Test
    public void testDumpWatchesOnEmptyManager() {
        StringWriter byPathBuffer = new StringWriter();
        StringWriter byConnectionBuffer = new StringWriter();

        manager.dumpWatches(new PrintWriter(byPathBuffer), true);
        manager.dumpWatches(new PrintWriter(byConnectionBuffer), false);

        assertEquals("", byPathBuffer.toString());
        assertEquals("", byConnectionBuffer.toString());
    }

    @Test
    public void testShutdownDoesNotAlterRegisteredWatches() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        manager.shutdown();

        assertTrue(manager.containsWatcher("/node", watcher1));
        assertEquals(1, manager.size());
    }

    private static void assertEvent(
            WatchedEvent event,
            String expectedPath,
            EventType expectedType,
            long expectedZxid) {
        assertNotNull(event);
        assertEquals(expectedPath, event.getPath());
        assertEquals(expectedType, event.getType());
        assertEquals(expectedZxid, event.getZxid());
    }

    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        int eventCount() {
            return events.size();
        }

        WatchedEvent lastEvent() {
            return events.isEmpty() ? null : events.get(events.size() - 1);
        }
    }
}
// ###Test END###
// ###Test START##
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0.
 */

package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class WatchManagerLLMZeroShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    @Test
    public void testInitialState() {
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
        assertEquals("0 connections watching 0 paths\nTotal watches:0", manager.toString());
    }

    @Test
    public void testAddDefaultWatchAndRejectDuplicate() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node", watcher));
        assertFalse(manager.addWatch("/node", watcher));

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node", watcher));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertEquals("1 connections watching 1 paths\nTotal watches:1", manager.toString());
    }

    @Test
    public void testSameWatcherCanWatchMultiplePaths() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", watcher));
        assertTrue(manager.addWatch("/two", watcher));

        assertEquals(2, manager.size());
        assertEquals(1, manager.getWatch2Paths().size());
        assertEquals(2, manager.getWatch2Paths().get(watcher).size());
        assertEquals("1 connections watching 2 paths\nTotal watches:2", manager.toString());
    }

    @Test
    public void testDifferentWatchersCanWatchSamePath() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/shared", first));
        assertTrue(manager.addWatch("/shared", second));

        assertEquals(2, manager.size());
        assertTrue(manager.containsWatcher("/shared", first));
        assertTrue(manager.containsWatcher("/shared", second));
        assertEquals("2 connections watching 1 paths\nTotal watches:2", manager.toString());
    }

    @Test
    public void testAddWatchIgnoresStaleServerConnection() {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(true);

        assertFalse(manager.addWatch("/closed", connection));

        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher("/closed", connection));
    }

    @Test
    public void testTriggerStandardWatchDeliversEventAndRemovesWatch() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher);

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 123L, Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        WatchedEvent event = watcher.events.iterator().next();
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals("/node", event.getPath());
        assertEquals(123L, event.getZxid());
        assertFalse(manager.containsWatcher("/node", watcher));
        assertEquals(0, manager.size());
    }

    @Test
    public void testTriggerWithoutMatchingWatchReturnsNull() {
        assertNull(manager.triggerWatch(
                "/missing", EventType.NodeCreated, 1L, Collections.emptyList()));
    }

    @Test
    public void testStandardWatchDoesNotFireForDescendant() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/parent", watcher);

        assertNull(manager.triggerWatch(
                "/parent/child", EventType.NodeCreated, 2L, Collections.emptyList()));

        assertTrue(watcher.events.isEmpty());
        assertTrue(manager.containsWatcher("/parent", watcher));
    }

    @Test
    public void testPersistentWatchSurvivesMultipleTriggers() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch("/persistent", watcher, WatcherMode.PERSISTENT));

        WatcherOrBitSet first = manager.triggerWatch(
                "/persistent", EventType.NodeCreated, 3L, Collections.emptyList());
        WatcherOrBitSet second = manager.triggerWatch(
                "/persistent", EventType.NodeDataChanged, 4L, Collections.emptyList());

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(2, watcher.events.size());
        assertTrue(manager.containsWatcher("/persistent", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRecursiveWatchReceivesEventsForPathAndDescendants() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, manager.getRecursiveWatchQty());
        assertNotNull(manager.triggerWatch(
                "/root/child/grandchild", EventType.NodeCreated, 5L, Collections.emptyList()));
        assertNotNull(manager.triggerWatch(
                "/root", EventType.NodeChildrenChanged, 6L, Collections.emptyList()));

        assertEquals(2, watcher.events.size());
        assertTrue(manager.containsWatcher(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRecursiveWatchDoesNotReceiveSiblingEvent() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertNull(manager.triggerWatch(
                "/other/child", EventType.NodeCreated, 7L, Collections.emptyList()));

        assertTrue(watcher.events.isEmpty());
        assertTrue(manager.containsWatcher("/root", watcher));
    }

    @Test
    public void testStandardAndPersistentModesAreTrackedIndependently() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT));

        manager.triggerWatch("/mixed", EventType.NodeDataChanged, 8L, Collections.emptyList());

        assertEquals(1, watcher.events.size());
        assertFalse(manager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testSuppressedWatcherIsReturnedButDoesNotReceiveEvent() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();
        manager.addWatch("/node", suppressed);
        manager.addWatch("/node", delivered);
        Set<Watcher> suppressedSet = new HashSet<>();
        suppressedSet.add(suppressed);

        WatcherOrBitSet result = manager.triggerWatch(
                "/node",
                EventType.NodeDeleted,
                9L,
                Collections.emptyList(),
                new WatcherOrBitSet(suppressedSet));

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(delivered));
        assertTrue(suppressed.events.isEmpty());
        assertEquals(1, delivered.events.size());
        assertEquals(0, manager.size());
    }

    @Test
    public void testServerWatcherReceivesAclAwareCallback() {
        ServerWatcher watcher = mock(ServerWatcher.class);
        manager.addWatch("/secure", watcher);

        manager.triggerWatch(
                "/secure", EventType.NodeDataChanged, 10L, Collections.emptyList());

        ArgumentCaptor<WatchedEvent> eventCaptor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher, times(1)).process(eventCaptor.capture(), eq(Collections.emptyList()));
        verify(watcher, never()).process(any(WatchedEvent.class));
        assertEquals("/secure", eventCaptor.getValue().getPath());
        assertEquals(10L, eventCaptor.getValue().getZxid());
    }

    @Test
    public void testRemoveWatcherByPathAndMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", watcher));
        assertEquals(0, manager.size());
        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveAllModesForPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher));

        assertFalse(manager.containsWatcher("/node", watcher));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveWatcherFromAllPaths() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/one", watcher);
        manager.addWatch("/two", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        manager.removeWatcher(watcher);

        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.containsWatcher("/one", watcher));
        assertFalse(manager.containsWatcher("/two", watcher));
        manager.removeWatcher(watcher);
        assertEquals(0, manager.size());
    }

    @Test
    public void testRemovingMissingWatchReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertFalse(manager.removeWatcher("/missing", watcher));
        manager.addWatch("/existing", watcher);
        assertFalse(manager.removeWatcher("/other", watcher));
        assertTrue(manager.containsWatcher("/existing", watcher));
    }

    @Test
    public void testWatchesSummaryAndReports() {
        ServerCnxn first = activeConnection(0x11L);
        ServerCnxn second = activeConnection(0x22L);
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());

        WatchesReport watches = manager.getWatches();
        assertEquals(2, watches.getPaths(0x11L).size());
        assertTrue(watches.getPaths(0x11L).contains("/a"));
        assertTrue(watches.getPaths(0x11L).contains("/b"));
        assertEquals(Collections.singleton("/a"), watches.getPaths(0x22L));

        WatchesPathReport byPath = manager.getWatchesByPath();
        Set<Long> expectedA = new HashSet<>();
        expectedA.add(0x11L);
        expectedA.add(0x22L);
        assertEquals(expectedA, byPath.getSessions("/a"));
        assertEquals(Collections.singleton(0x11L), byPath.getSessions("/b"));
    }

    @Test
    public void testDumpWatchesByPath() {
        ServerCnxn connection = activeConnection(0xabcL);
        manager.addWatch("/path", connection);
        StringWriter output = new StringWriter();

        manager.dumpWatches(new PrintWriter(output), true);

        assertTrue(output.toString().contains("/path"));
        assertTrue(output.toString().contains("\t0xabc"));
    }

    @Test
    public void testDumpWatchesByConnection() {
        ServerCnxn connection = activeConnection(0xdefL);
        manager.addWatch("/first", connection);
        manager.addWatch("/second", connection);
        StringWriter output = new StringWriter();

        manager.dumpWatches(new PrintWriter(output), false);

        assertTrue(output.toString().contains("0xdef"));
        assertTrue(output.toString().contains("\t/first"));
        assertTrue(output.toString().contains("\t/second"));
    }

    @Test
    public void testShutdownDoesNotModifyState() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher);

        manager.shutdown();

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node", watcher));
    }

    private static ServerCnxn activeConnection(long sessionId) {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(false);
        when(connection.getSessionId()).thenReturn(sessionId);
        return connection;
    }

    private static final class RecordingWatcher implements Watcher {
        private final Set<WatchedEvent> events = new HashSet<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}
// ###Test END##
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Before;
import org.junit.Test;

/**
 * Guided Tree-of-Thought, few-shot tests for {@link WatchManager}.
 *
 * <p>The tests exercise the public API, mode combinations, one-shot and
 * persistent behavior, recursive parent watches, suppression, reporting,
 * stale connections, removal isolation, and empty-manager behavior.</p>
 */
public class WatchManagerC2LLMGuidedToTFewShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    /** Basic coverage for size() and both addWatch overloads. */
    @Test
    public void testAddWatchAndSize() {
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertEquals(0, manager.size());
        assertTrue(manager.addWatch("/a", watcher1));
        assertEquals(1, manager.size());

        // A second mode on the same path/watcher pair is a logical watch mode,
        // but size() still counts the watcher only once in watchTable.
        assertTrue(manager.addWatch("/a", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());

        assertTrue(manager.addWatch("/a", watcher2));
        assertTrue(manager.addWatch("/b", watcher1));
        assertEquals(3, manager.size());
    }

    /** Duplicate registration in the same mode must be rejected. */
    @Test
    public void testAddWatchDuplicateModeReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
    }

    /** A stale ServerCnxn must not be registered. */
    @Test
    public void testAddWatchRejectsStaleServerConnection() {
        ServerCnxn staleConnection = serverConnection(0x11L, true);

        assertFalse(manager.addWatch("/stale", staleConnection));
        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher("/stale", staleConnection));
    }

    /** Basic coverage for both containsWatcher overloads and all modes. */
    @Test
    public void testContainsWatcherByAnyAndSpecificMode() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertFalse(manager.containsWatcher("/node", watcher));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node", watcher));
        assertTrue(manager.containsWatcher("/node", watcher, null));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/other", watcher));
        assertFalse(manager.containsWatcher("/node", new RecordingWatcher()));
    }

    /** Basic coverage for triggerWatch(path,type,zxid,acl). */
    @Test
    public void testTriggerWatchDeliversEventAndConsumesStandardWatch() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", watcher));

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeCreated, 42L, Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), "/node", EventType.NodeCreated, 42L);
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertEquals(0, manager.size());

        // The one-shot watch was consumed by the first trigger.
        assertNull(manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 43L, null));
        assertEquals(1, watcher.events.size());
    }

    /** An unobserved path returns null and delivers no event. */
    @Test
    public void testTriggerWatchOnMissingPathReturnsNull() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/watched", watcher);

        assertNull(manager.triggerWatch(
                "/missing", EventType.NodeDeleted, 1L, null));
        assertTrue(watcher.events.isEmpty());
        assertTrue(manager.containsWatcher("/watched", watcher));
    }

    /** Persistent watches survive repeated direct triggers. */
    @Test
    public void testPersistentWatchSurvivesMultipleTriggers() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        assertNotNull(manager.triggerWatch("/node", EventType.NodeCreated, 1L, null));
        assertNotNull(manager.triggerWatch("/node", EventType.NodeDataChanged, 2L, null));

        assertEquals(2, watcher.events.size());
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    /** A recursive watch on a parent fires for descendants and remains installed. */
    @Test
    public void testPersistentRecursiveWatchFiresForDescendant() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child/grandchild", EventType.NodeCreated, 7L, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), "/root/child/grandchild", EventType.NodeCreated, 7L);
        assertTrue(manager.containsWatcher(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    /** A direct standard watch and an ancestor recursive watch both fire once. */
    @Test
    public void testDirectAndRecursiveWatchersAreCollectedTogether() {
        RecordingWatcher direct = new RecordingWatcher();
        RecordingWatcher recursive = new RecordingWatcher();
        manager.addWatch("/root/child", direct, WatcherMode.STANDARD);
        manager.addWatch("/root", recursive, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child", EventType.NodeChildrenChanged, 9L, null);

        assertNotNull(result);
        assertTrue(result.contains(direct));
        assertTrue(result.contains(recursive));
        assertEquals(1, direct.events.size());
        assertEquals(1, recursive.events.size());
        assertFalse(manager.containsWatcher("/root/child", direct));
        assertTrue(manager.containsWatcher("/root", recursive));
    }

    /** Basic coverage for triggerWatch(..., suppress). */
    @Test
    public void testTriggerWatchSuppressionSkipsNotificationButReturnsWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher notified = new RecordingWatcher();
        manager.addWatch("/node", suppressed, WatcherMode.PERSISTENT);
        manager.addWatch("/node", notified, WatcherMode.PERSISTENT);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 10L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(notified));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, notified.events.size());
        assertTrue(manager.containsWatcher("/node", suppressed));
        assertTrue(manager.containsWatcher("/node", notified));
    }

    /** ServerWatcher must receive the ACL-aware process overload. */
    @Test
    public void testTriggerWatchUsesServerWatcherAclOverload() {
        ServerWatcher watcher = mock(ServerWatcher.class);
        @SuppressWarnings("unchecked")
        List<org.apache.zookeeper.data.ACL> acl = mock(List.class);
        manager.addWatch("/secure", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/secure", EventType.NodeDataChanged, 12L, acl);

        verify(watcher).process(org.mockito.ArgumentMatchers.any(WatchedEvent.class),
                org.mockito.ArgumentMatchers.same(acl));
        verify(watcher, never()).process(org.mockito.ArgumentMatchers.any(WatchedEvent.class));
    }

    /** Basic coverage for removeWatcher(Watcher). */
    @Test
    public void testRemoveWatcherFromAllPathsAndModes() {
        RecordingWatcher removed = new RecordingWatcher();
        RecordingWatcher retained = new RecordingWatcher();
        manager.addWatch("/a", removed, WatcherMode.STANDARD);
        manager.addWatch("/a", removed, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", removed, WatcherMode.PERSISTENT);
        manager.addWatch("/a", retained, WatcherMode.STANDARD);

        manager.removeWatcher(removed);

        assertFalse(manager.containsWatcher("/a", removed));
        assertFalse(manager.containsWatcher("/b", removed));
        assertTrue(manager.containsWatcher("/a", retained));
        assertEquals(1, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());

        // Removing an absent watcher is explicitly a no-op.
        manager.removeWatcher(removed);
        assertEquals(1, manager.size());
    }

    /** Basic coverage for removeWatcher(path,watcher). */
    @Test
    public void testRemoveWatcherPathAllModes() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/a", watcher));
        assertFalse(manager.containsWatcher("/a", watcher));
        assertTrue(manager.containsWatcher("/b", watcher));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.removeWatcher("/a", watcher));
    }

    /** Basic coverage for removeWatcher(path,watcher,mode). */
    @Test
    public void testRemoveOneModePreservesOtherModes() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());

        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.removeWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    /** Mismatched removal attempts must not modify existing registrations. */
    @Test
    public void testRemoveWatcherMismatchesAreNoOps() {
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/missing", watcher1));
        assertFalse(manager.removeWatcher("/node", watcher2));
        assertFalse(manager.removeWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher(
                "/node", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    /** Basic coverage for toString(). */
    @Test
    public void testToStringContainsCountsAndPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertEquals("0 connections watching 0 paths\n", manager.toString());

        manager.addWatch("/alpha", watcher);
        String text = manager.toString();

        assertTrue(text.startsWith("1 connections watching 1 paths\n"));
        assertTrue(text.contains("/alpha ->"));
    }

    /** Basic coverage for dumpWatches(writer,true). */
    @Test
    public void testDumpWatchesByPath() {
        ServerCnxn connection = serverConnection(0xabcL, false);
        manager.addWatch("/alpha", connection);

        String output = dump(true);

        assertTrue(output.contains("/alpha"));
        assertTrue(output.contains("\t0xabc"));
    }

    /** Basic coverage for dumpWatches(writer,false). */
    @Test
    public void testDumpWatchesByWatcher() {
        ServerCnxn connection = serverConnection(0xdefL, false);
        manager.addWatch("/alpha", connection);
        manager.addWatch("/beta", connection);

        String output = dump(false);

        assertTrue(output.contains("0xdef"));
        assertTrue(output.contains("\t/alpha"));
        assertTrue(output.contains("\t/beta"));
    }

    /** Empty dump output is a valid edge case. */
    @Test
    public void testDumpWatchesOnEmptyManager() {
        assertEquals("", dump(true));
        assertEquals("", dump(false));
    }

    /** Basic coverage for getWatches(). */
    @Test
    public void testGetWatchesGroupsPathsBySession() {
        ServerCnxn first = serverConnection(1L, false);
        ServerCnxn second = serverConnection(2L, false);
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        WatchesReport report = manager.getWatches();

        assertEquals(2, report.toMap().size());
        assertEquals(new java.util.HashSet<>(Arrays.asList("/a", "/b")),
                report.getPaths(1L));
        assertEquals(Collections.singleton("/a"), report.getPaths(2L));
        assertFalse(report.hasPaths(999L));
        assertNull(report.getPaths(999L));
    }

    /** Basic coverage for getWatchesByPath(). */
    @Test
    public void testGetWatchesByPathGroupsSessions() {
        ServerCnxn first = serverConnection(1L, false);
        ServerCnxn second = serverConnection(2L, false);
        manager.addWatch("/a", first);
        manager.addWatch("/a", second);
        manager.addWatch("/b", second);

        WatchesPathReport report = manager.getWatchesByPath();

        assertEquals(new java.util.HashSet<>(Arrays.asList(1L, 2L)),
                report.getSessions("/a"));
        assertEquals(Collections.singleton(2L), report.getSessions("/b"));
        assertFalse(report.hasSessions("/missing"));
        assertNull(report.getSessions("/missing"));
    }

    /** Basic and edge coverage for getWatchesSummary(). */
    @Test
    public void testGetWatchesSummaryCountsUniquePairs() {
        WatchesSummary empty = manager.getWatchesSummary();
        assertEquals(0, empty.getNumConnections());
        assertEquals(0, empty.getNumPaths());
        assertEquals(0, empty.getTotalWatches());

        ServerCnxn first = serverConnection(1L, false);
        ServerCnxn second = serverConnection(2L, false);
        manager.addWatch("/a", first, WatcherMode.STANDARD);
        manager.addWatch("/a", first, WatcherMode.PERSISTENT);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        // Modes do not create extra path/watcher pairs in this report.
        assertEquals(3, summary.getTotalWatches());
    }

    /** Package-visible testing accessor must expose current mode state. */
    @Test
    public void testGetWatch2PathsReflectsRegistrationAndRemoval() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.getWatch2Paths().containsKey(watcher));
        assertTrue(manager.getWatch2Paths().get(watcher).get("/node")
                .hasMode(WatcherMode.PERSISTENT));

        manager.removeWatcher("/node", watcher);
        assertFalse(manager.getWatch2Paths().containsKey(watcher));
    }

    /** Package-visible recursive count must track additions and removals. */
    @Test
    public void testRecursiveWatchQuantityAccounting() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.addWatch(
                "/a", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch(
                "/b", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch(
                "/a", second, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(3, manager.getRecursiveWatchQty());

        assertFalse(manager.addWatch(
                "/a", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(3, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher(
                "/a", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(2, manager.getRecursiveWatchQty());
        manager.removeWatcher(first);
        assertEquals(1, manager.getRecursiveWatchQty());
        manager.removeWatcher(second);
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    /** shutdown() is intentionally a no-op and must preserve state. */
    @Test
    public void testShutdownIsNoOp() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher);

        manager.shutdown();

        assertTrue(manager.containsWatcher("/node", watcher));
        assertEquals(1, manager.size());
    }

    /** One watcher with multiple modes must be notified only once per trigger. */
    @Test
    public void testWatcherWithMultipleModesReceivesSingleEvent() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        manager.triggerWatch("/node", EventType.NodeDataChanged, 99L, null);

        assertEquals(1, watcher.events.size());
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    private String dump(boolean byPath) {
        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer);
        manager.dumpWatches(writer, byPath);
        writer.flush();
        return buffer.toString();
    }

    private static ServerCnxn serverConnection(long sessionId, boolean stale) {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.getSessionId()).thenReturn(sessionId);
        when(connection.isStale()).thenReturn(stale);
        return connection;
    }

    private static void assertEvent(
            WatchedEvent event, String path, EventType type, long zxid) {
        assertEquals(path, event.getPath());
        assertEquals(type, event.getType());
        assertEquals(zxid, event.getZxid());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}
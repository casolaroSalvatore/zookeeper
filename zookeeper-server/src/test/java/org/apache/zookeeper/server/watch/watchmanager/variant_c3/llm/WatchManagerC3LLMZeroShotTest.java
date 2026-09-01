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
import java.util.Collections;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class WatchManagerC3LLMZeroShotTest {

    private WatchManager watchManager;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    @Test
    public void testNewManagerIsEmpty() {
        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals("0 connections watching 0 paths\nTotal watches:0", watchManager.toString());
    }

    @Test
    public void testAddStandardWatchAndRejectDuplicate() {
        Watcher watcher = mock(Watcher.class);

        assertTrue(watchManager.addWatch("/node", watcher));
        assertFalse(watchManager.addWatch("/node", watcher));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertTrue(watchManager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testAddWatchRejectsStaleServerConnection() {
        ServerCnxn watcher = serverConnection(11L, true);

        assertFalse(watchManager.addWatch("/stale", watcher));
        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher("/stale", watcher));
    }

    @Test
    public void testSameWatcherCanUseMultipleModesOnSamePath() {
        Watcher watcher = mock(Watcher.class);

        assertTrue(watchManager.addWatch("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT));
        assertFalse(watchManager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testTriggerConsumesStandardWatchAndDeliversEvent() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/node", watcher);

        WatcherOrBitSet result = watchManager.triggerWatch(
                "/node",
                EventType.NodeDataChanged,
                42L,
                Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher("/node", watcher));

        ArgumentCaptor<WatchedEvent> eventCaptor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher).process(eventCaptor.capture());
        WatchedEvent event = eventCaptor.getValue();
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals("/node", event.getPath());
        assertEquals(42L, event.getZxid());
    }

    @Test
    public void testTriggerReturnsNullWhenNoWatcherExists() {
        assertNull(watchManager.triggerWatch(
                "/missing",
                EventType.NodeCreated,
                1L,
                Collections.<ACL>emptyList()));
    }

    @Test
    public void testSuppressedWatcherIsReturnedButNotNotified() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/node", watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(Collections.singleton(watcher));

        WatcherOrBitSet result = watchManager.triggerWatch(
                "/node",
                EventType.NodeDeleted,
                7L,
                Collections.<ACL>emptyList(),
                suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        verify(watcher, never()).process(org.mockito.ArgumentMatchers.any(WatchedEvent.class));
        assertFalse(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void testPersistentWatchSurvivesRepeatedTriggers() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/persistent", watcher, WatcherMode.PERSISTENT);

        assertNotNull(watchManager.triggerWatch(
                "/persistent",
                EventType.NodeDataChanged,
                1L,
                Collections.<ACL>emptyList()));
        assertNotNull(watchManager.triggerWatch(
                "/persistent",
                EventType.NodeChildrenChanged,
                2L,
                Collections.<ACL>emptyList()));

        assertTrue(watchManager.containsWatcher(
                "/persistent", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, watchManager.size());
        verify(watcher, org.mockito.Mockito.times(2))
                .process(org.mockito.ArgumentMatchers.any(WatchedEvent.class));
    }

    @Test
    public void testRecursiveWatchReceivesDescendantEventAndSurvives() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = watchManager.triggerWatch(
                "/root/child/grandchild",
                EventType.NodeCreated,
                99L,
                Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertTrue(watchManager.containsWatcher(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());
        verify(watcher).process(org.mockito.ArgumentMatchers.any(WatchedEvent.class));
    }

    @Test
    public void testNonRecursiveParentWatchDoesNotReceiveDescendantEvent() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/root", watcher, WatcherMode.PERSISTENT);

        assertNull(watchManager.triggerWatch(
                "/root/child",
                EventType.NodeCreated,
                3L,
                Collections.<ACL>emptyList()));

        assertTrue(watchManager.containsWatcher("/root", watcher));
        verify(watcher, never()).process(org.mockito.ArgumentMatchers.any(WatchedEvent.class));
    }

    @Test
    public void testRemovingOneModePreservesOtherMode() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/mixed", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(
                "/mixed", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());

        assertTrue(watchManager.removeWatcher(
                "/mixed", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(watchManager.containsWatcher("/mixed", watcher));
        assertEquals(0, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveWatcherByPathHandlesMissingEntries() {
        Watcher watcher = mock(Watcher.class);

        assertFalse(watchManager.removeWatcher("/missing", watcher));

        watchManager.addWatch("/present", watcher);
        assertFalse(watchManager.removeWatcher("/other", watcher));
        assertTrue(watchManager.removeWatcher("/present", watcher));
        assertFalse(watchManager.removeWatcher("/present", watcher));
        assertEquals(0, watchManager.size());
    }

    @Test
    public void testRemoveWatcherFromAllPathsAndModes() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/one", watcher);
        watchManager.addWatch("/two", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        watchManager.removeWatcher(watcher);

        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertFalse(watchManager.containsWatcher("/one", watcher));
        assertFalse(watchManager.containsWatcher("/two", watcher));
        assertTrue(watchManager.getWatch2Paths().isEmpty());

        watchManager.removeWatcher(watcher);
        assertEquals(0, watchManager.size());
    }

    @Test
    public void testSummaryReportsDistinctConnectionsPathsAndWatches() {
        ServerCnxn first = serverConnection(0x11L, false);
        ServerCnxn second = serverConnection(0x22L, false);
        watchManager.addWatch("/shared", first);
        watchManager.addWatch("/shared", second);
        watchManager.addWatch("/only-first", first);

        WatchesSummary summary = watchManager.getWatchesSummary();

        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
        assertEquals(3, watchManager.size());
        assertEquals("2 connections watching 2 paths\nTotal watches:3", watchManager.toString());
    }

    @Test
    public void testReportsExposeSessionsAndPaths() {
        ServerCnxn first = serverConnection(101L, false);
        ServerCnxn second = serverConnection(202L, false);
        watchManager.addWatch("/a", first);
        watchManager.addWatch("/b", first);
        watchManager.addWatch("/a", second);

        WatchesReport bySession = watchManager.getWatches();
        WatchesPathReport byPath = watchManager.getWatchesByPath();

        assertEquals(2, bySession.getPaths(101L).size());
        assertTrue(bySession.getPaths(101L).contains("/a"));
        assertTrue(bySession.getPaths(101L).contains("/b"));
        assertEquals(Collections.singleton("/a"), bySession.getPaths(202L));

        assertEquals(2, byPath.getSessions("/a").size());
        assertTrue(byPath.getSessions("/a").contains(101L));
        assertTrue(byPath.getSessions("/a").contains(202L));
        assertEquals(Collections.singleton(101L), byPath.getSessions("/b"));
    }

    @Test
    public void testDumpWatchesGroupedByPath() {
        ServerCnxn watcher = serverConnection(0x2aL, false);
        watchManager.addWatch("/dump", watcher);
        StringWriter output = new StringWriter();

        watchManager.dumpWatches(new PrintWriter(output), true);

        String dump = output.toString();
        assertTrue(dump.contains("/dump"));
        assertTrue(dump.contains("\t0x2a"));
    }

    @Test
    public void testDumpWatchesGroupedByWatcher() {
        ServerCnxn watcher = serverConnection(0x2aL, false);
        watchManager.addWatch("/first", watcher);
        watchManager.addWatch("/second", watcher);
        StringWriter output = new StringWriter();

        watchManager.dumpWatches(new PrintWriter(output), false);

        String dump = output.toString();
        assertTrue(dump.contains("0x2a"));
        assertTrue(dump.contains("\t/first"));
        assertTrue(dump.contains("\t/second"));
    }

    @Test
    public void testShutdownLeavesExistingWatchesUnchanged() {
        Watcher watcher = mock(Watcher.class);
        watchManager.addWatch("/node", watcher);

        watchManager.shutdown();

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
    }

    private ServerCnxn serverConnection(long sessionId, boolean stale) {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.getSessionId()).thenReturn(sessionId);
        when(connection.isStale()).thenReturn(stale);
        return connection;
    }
}
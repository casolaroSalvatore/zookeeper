package org.apache.zookeeper.server.watch;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Test;

/**
 * Guided Tree-of-Thought/few-shot JUnit 4 tests for {@link WatchManager}.
 *
 * <p>The class is intentionally placed in the production package so that the
 * package-visible testing accessors can also be checked without reflection.</p>
 */
public class WatchManagerC3LLMGuidedToTFewShotTest {

    private static final String PATH = "/node";

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

    private static ServerCnxn connection(long sessionId) {
        ServerCnxn cnxn = mock(ServerCnxn.class);
        when(cnxn.getSessionId()).thenReturn(sessionId);
        when(cnxn.isStale()).thenReturn(false);
        return cnxn;
    }

    @Test
    public void testNewManagerIsEmpty() {
        WatchManager manager = new WatchManager();

        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertEquals(0, manager.getWatchesSummary().getNumConnections());
        assertEquals(0, manager.getWatchesSummary().getNumPaths());
        assertEquals(0, manager.getWatchesSummary().getTotalWatches());
        assertEquals("0 connections watching 0 paths\nTotal watches:0", manager.toString());
    }

    @Test
    public void testAddWatchDefaultModeAndDuplicate() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher));
        assertTrue(manager.containsWatcher(PATH, watcher));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.DEFAULT_WATCHER_MODE));
        assertEquals(1, manager.size());

        assertFalse("Adding the same path/watcher/mode must be idempotent",
                manager.addWatch(PATH, watcher));
        assertEquals(1, manager.size());
    }

    @Test
    public void testAddWatchSupportsAllModesOnSamePair() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals("size counts path/watcher pairs, not modes", 1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testAddWatchRejectsStaleServerConnection() {
        WatchManager manager = new WatchManager();
        ServerCnxn stale = mock(ServerCnxn.class);
        when(stale.isStale()).thenReturn(true);

        assertFalse(manager.addWatch(PATH, stale));
        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher(PATH, stale));
    }

    @Test
    public void testContainsWatcherMismatchCases() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();
        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node1", watcher1, null));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node2", watcher1));
        assertFalse(manager.containsWatcher("/node1", watcher2));
        assertFalse(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testRemoveWatcherByPathAndModePreservesOtherModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testRemoveWatcherByPathWithoutModeRemovesAllModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher));
        assertFalse(manager.containsWatcher(PATH, watcher));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveMissingWatchReturnsFalseAndChangesNothing() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();
        manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/missing", watcher1));
        assertFalse(manager.removeWatcher("/node1", watcher2));
        assertFalse(manager.removeWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRemoveWatcherFromAllPaths() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.STANDARD);
        manager.addWatch("/b", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        manager.removeWatcher(watcher);

        assertFalse(manager.containsWatcher("/a", watcher));
        assertFalse(manager.containsWatcher("/b", watcher));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());

        manager.removeWatcher(watcher); // absent watcher: must be a no-op
        assertEquals(0, manager.size());
    }

    @Test
    public void testTriggerStandardWatchDeliversEventAndConsumesWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeCreated, 42L, Collections.<ACL>emptyList());

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount());
        assertEquals(PATH, watcher.lastEvent().getPath());
        assertEquals(EventType.NodeCreated, watcher.lastEvent().getType());
        assertEquals(42L, watcher.lastEvent().getZxid());
        assertFalse(manager.containsWatcher(PATH, watcher));
        assertEquals(0, manager.size());
    }

    @Test
    public void testTriggerPersistentWatchSurvivesRepeatedEvents() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeDataChanged, 1L, null);
        manager.triggerWatch(PATH, EventType.NodeChildrenChanged, 2L, null);

        assertEquals(2, watcher.eventCount());
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void testRecursiveWatchFiresForDescendantAndSurvives() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/root/child/grandchild", EventType.NodeCreated, 7L, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount());
        assertEquals("/root/child/grandchild", watcher.lastEvent().getPath());
        assertTrue(manager.containsWatcher("/root", watcher,
                WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testTriggerMissingPathReturnsNull() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/watched", watcher);

        assertNull(manager.triggerWatch("/missing", EventType.NodeDeleted, 9L, null));
        assertEquals(0, watcher.eventCount());
        assertTrue(manager.containsWatcher("/watched", watcher));
    }

    @Test
    public void testSuppressedWatcherIsReturnedAndConsumedButNotNotified() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = new WatcherOrBitSet(Collections.<Watcher>singleton(watcher));

        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeDeleted, 10L, null, suppress);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(0, watcher.eventCount());
        assertFalse(manager.containsWatcher(PATH, watcher));
    }

    @Test
    public void testServerWatcherReceivesAclAwareCallback() {
        WatchManager manager = new WatchManager();
        ServerWatcher watcher = mock(ServerWatcher.class);
        List<ACL> acl = Collections.emptyList();
        manager.addWatch(PATH, watcher);

        manager.triggerWatch(PATH, EventType.NodeCreated, 11L, acl);

        verify(watcher, times(1)).process(any(WatchedEvent.class), eq(acl));
    }

    @Test
    public void testSummaryAndToStringCountPairsPathsAndWatchers() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();
        manager.addWatch("/a", watcher1);
        manager.addWatch("/a", watcher2);
        manager.addWatch("/b", watcher1);

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
        assertEquals(3, manager.size());
        assertEquals("2 connections watching 2 paths\nTotal watches:3", manager.toString());
    }

    @Test
    public void testGetWatchesGroupsPathsBySession() {
        WatchManager manager = new WatchManager();
        ServerCnxn cnxn1 = connection(0x11L);
        ServerCnxn cnxn2 = connection(0x22L);
        manager.addWatch("/a", cnxn1);
        manager.addWatch("/b", cnxn1);
        manager.addWatch("/b", cnxn2);

        WatchesReport report = manager.getWatches();

        /* Modified to remove the compilation error
        assertEquals(2, report.getSessionIds().size());
        assertTrue(report.getPaths(0x11L).contains("/a"));
        assertTrue(report.getPaths(0x11L).contains("/b"));
        assertEquals(Collections.singleton("/b"), report.getPaths(0x22L));
        */

        Map<Long, Set<String>> map = report.toMap();
        assertEquals(2, map.size());
        assertTrue(map.get(0x11L).contains("/a"));
        assertTrue(map.get(0x11L).contains("/b"));
        assertEquals(Collections.singleton("/b"), map.get(0x22L));
    }

    @Test
    public void testGetWatchesByPathGroupsSessionsByPath() {
        WatchManager manager = new WatchManager();
        ServerCnxn cnxn1 = connection(0x11L);
        ServerCnxn cnxn2 = connection(0x22L);
        manager.addWatch("/a", cnxn1);
        manager.addWatch("/a", cnxn2);

        WatchesPathReport report = manager.getWatchesByPath();

        /* Modified to remove the compilation error
        assertTrue(report.getPaths().contains("/a"));
        assertTrue(report.getSessions("/a").contains(0x11L));
        assertTrue(report.getSessions("/a").contains(0x22L));
        assertEquals(2, report.getSessions("/a").size());
        */

        Map<String, java.util.Set<Long>> map = report.toMap();

        assertTrue(map.containsKey("/a"));
        assertTrue(map.get("/a").contains(0x11L));
        assertTrue(map.get("/a").contains(0x22L));
        assertEquals(2, map.get("/a").size());
    }

    @Test
    public void testDumpWatchesByPath() {
        WatchManager manager = new WatchManager();
        ServerCnxn cnxn = connection(0xabcL);
        manager.addWatch("/dump", cnxn);
        StringWriter text = new StringWriter();

        manager.dumpWatches(new PrintWriter(text), true);

        assertTrue(text.toString().contains("/dump"));
        assertTrue(text.toString().contains("\t0xabc"));
    }

    @Test
    public void testDumpWatchesByWatcher() {
        WatchManager manager = new WatchManager();
        ServerCnxn cnxn = connection(0xdefL);
        manager.addWatch("/one", cnxn);
        manager.addWatch("/two", cnxn);
        StringWriter text = new StringWriter();

        manager.dumpWatches(new PrintWriter(text), false);

        assertTrue(text.toString().contains("0xdef"));
        assertTrue(text.toString().contains("\t/one"));
        assertTrue(text.toString().contains("\t/two"));
    }

    @Test
    public void testShutdownIsNoOpAndKeepsExistingWatches() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher);

        manager.shutdown();

        assertTrue(manager.containsWatcher(PATH, watcher));
        assertEquals(1, manager.size());
    }
}
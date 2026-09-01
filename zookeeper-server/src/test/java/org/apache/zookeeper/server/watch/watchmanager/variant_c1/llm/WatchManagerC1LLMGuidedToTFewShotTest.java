/*
 * Guided-ToT few-shot generated tests for WatchManager.
 * JUnit 4 + Mockito.
 */
package org.apache.zookeeper.server.watch;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class WatchManagerC1LLMGuidedToTFewShotTest {

    private static final class RecordingWatcher implements Watcher {
        private WatchedEvent lastEvent;
        private int eventCount;

        @Override
        public void process(WatchedEvent event) {
            lastEvent = event;
            eventCount++;
        }
    }

    private static ServerCnxn connection(long sessionId) {
        ServerCnxn cnxn = mock(ServerCnxn.class);
        when(cnxn.getSessionId()).thenReturn(sessionId);
        when(cnxn.isStale()).thenReturn(false);
        return cnxn;
    }

    @Test
    public void testSizeCountsDistinctPathWatcherPairs() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertEquals(0, manager.size());
        assertTrue(manager.addWatch("/a", watcher1));
        assertFalse(manager.addWatch("/a", watcher1));
        assertTrue(manager.addWatch("/a", watcher2));
        assertTrue(manager.addWatch("/b", watcher1));
        assertEquals(3, manager.size());
    }

    @Test
    public void testAddWatchDefaultAndExplicitModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node", watcher));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.DEFAULT_WATCHER_MODE));
        assertFalse(manager.addWatch("/node", watcher, WatcherMode.DEFAULT_WATCHER_MODE));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void testAddWatchRejectsStaleConnection() {
        WatchManager manager = new WatchManager();
        ServerCnxn stale = mock(ServerCnxn.class);
        when(stale.isStale()).thenReturn(true);

        assertFalse(manager.addWatch("/dead", stale));
        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher("/dead", stale));
    }

    @Test(expected = NullPointerException.class)
    public void testAddWatchRejectsNullMode() {
        new WatchManager().addWatch("/node", new RecordingWatcher(), null);
    }

    @Test
    public void testRemoveWatcherFromEveryPathAndMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertEquals(2, manager.getRecursiveWatchQty());
        manager.removeWatcher(watcher);
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.containsWatcher("/a", watcher));

        manager.removeWatcher(watcher); // absent watcher is a no-op
        assertEquals(0, manager.size());
    }

    @Test
    public void testContainsWatcherOverloadsAndModeMismatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/node", watcher));
        assertTrue(manager.containsWatcher("/node", watcher, null));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/missing", watcher));
        assertFalse(manager.containsWatcher("/node", other));
    }

    @Test
    public void testRemoveWatcherPathOverloadsAndIndividualModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertFalse(manager.removeWatcher("/node", new RecordingWatcher(), WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/missing", watcher, WatcherMode.STANDARD));
        // Remove a mode without disturbing the other two.
        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.removeWatcher("/node", watcher));
        assertFalse(manager.containsWatcher("/node", watcher));
        assertFalse(manager.removeWatcher("/node", watcher));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void testTriggerWatchReturnsNullForUnwatchedPath() {
        WatchManager manager = new WatchManager();
        assertNull(manager.triggerWatch("/missing", EventType.NodeCreated, 1L, null));
    }

    @Test
    public void testTriggerWatchFourArgumentOverloadFiresStandardOnce() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher);

        WatcherOrBitSet fired = manager.triggerWatch("/node", EventType.NodeDataChanged, 17L, null);
        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount);
        assertEquals("/node", watcher.lastEvent.getPath());
        assertEquals(EventType.NodeDataChanged, watcher.lastEvent.getType());
        assertEquals(17L, watcher.lastEvent.getZxid());
        assertFalse(manager.containsWatcher("/node", watcher));

        assertNull(manager.triggerWatch("/node", EventType.NodeDeleted, 18L, null));
        assertEquals(1, watcher.eventCount);
    }

    @Test
    public void testTriggerWatchFiveArgumentOverloadSuppressesDeliveryButConsumesStandardWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/first", watcher);
        WatcherOrBitSet suppress = manager.triggerWatch("/first", EventType.NodeCreated, 1L, null);
        assertEquals(1, watcher.eventCount);

        manager.addWatch("/second", watcher);
        WatcherOrBitSet fired = manager.triggerWatch("/second", EventType.NodeDeleted, 2L, null, suppress);
        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount);
        assertFalse(manager.containsWatcher("/second", watcher));
    }

    @Test
    public void testPersistentAndRecursiveWatchesSurviveTriggers() {
        WatchManager manager = new WatchManager();
        RecordingWatcher persistent = new RecordingWatcher();
        RecordingWatcher recursive = new RecordingWatcher();
        manager.addWatch("/root/item", persistent, WatcherMode.PERSISTENT);
        manager.addWatch("/root", recursive, WatcherMode.PERSISTENT_RECURSIVE);

        manager.triggerWatch("/root/item", EventType.NodeCreated, 3L, null);
        manager.triggerWatch("/root/item", EventType.NodeDataChanged, 4L, null);

        assertEquals(2, persistent.eventCount);
        assertEquals(2, recursive.eventCount);
        assertTrue(manager.containsWatcher("/root/item", persistent, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/root", recursive, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggerWatchPassesAclToServerWatcher() {
        WatchManager manager = new WatchManager();
        ServerWatcher watcher = mock(ServerWatcher.class);
        List<ACL> acl = Collections.singletonList(new ACL());
        manager.addWatch("/secure", watcher);

        manager.triggerWatch("/secure", EventType.NodeCreated, 9L, acl);

        ArgumentCaptor<WatchedEvent> event = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher).process(event.capture(), same(acl));
        assertEquals("/secure", event.getValue().getPath());
        assertEquals(9L, event.getValue().getZxid());
        verify(watcher, never()).process(any(WatchedEvent.class));
    }

    @Test
    public void testToStringListsWatcherAndPaths() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher);
        manager.addWatch("/b", watcher);

        String text = manager.toString();
        assertTrue(text.contains(watcher.toString()));
        assertTrue(text.contains("\t/a\n"));
        assertTrue(text.contains("\t/b\n"));
        assertEquals("", new WatchManager().toString());
    }

    @Test
    public void testDumpWatchesByPathAndByWatcher() {
        WatchManager manager = new WatchManager();
        ServerCnxn first = connection(0x12L);
        ServerCnxn second = connection(0x2aL);
        manager.addWatch("/shared", first);
        manager.addWatch("/shared", second);

        StringWriter byPathBuffer = new StringWriter();
        manager.dumpWatches(new PrintWriter(byPathBuffer), true);
        String byPath = byPathBuffer.toString();
        assertTrue(byPath.contains("/shared"));
        assertTrue(byPath.contains("\t0x12"));
        assertTrue(byPath.contains("\t0x2a"));

        StringWriter byWatcherBuffer = new StringWriter();
        manager.dumpWatches(new PrintWriter(byWatcherBuffer), false);
        String byWatcher = byWatcherBuffer.toString();
        assertTrue(byWatcher.contains("0x12"));
        assertTrue(byWatcher.contains("0x2a"));
        assertEquals(2, countOccurrences(byWatcher, "\t/shared"));
    }

    @Test(expected = ClassCastException.class)
    public void testDumpWatchesRequiresServerConnectionWatchers() {
        WatchManager manager = new WatchManager();
        manager.addWatch("/node", new RecordingWatcher());
        manager.dumpWatches(new PrintWriter(new StringWriter()), true);
    }

    @Test
    public void testGetWatchesReturnsSessionToPathsReport() {
        WatchManager manager = new WatchManager();
        ServerCnxn cnxn = connection(101L);
        manager.addWatch("/a", cnxn);
        manager.addWatch("/b", cnxn);

        WatchesReport report = manager.getWatches();
        assertTrue(report.hasPaths(101L));
        assertEquals(2, report.getPaths(101L).size());
        assertTrue(report.getPaths(101L).containsAll(Arrays.asList("/a", "/b")));
        assertFalse(report.hasPaths(999L));
        assertNull(report.getPaths(999L));
    }

    @Test
    public void testGetWatchesByPathReturnsPathToSessionsReport() {
        WatchManager manager = new WatchManager();
        ServerCnxn first = connection(11L);
        ServerCnxn second = connection(22L);
        manager.addWatch("/shared", first);
        manager.addWatch("/shared", second);

        WatchesPathReport report = manager.getWatchesByPath();
        assertTrue(report.hasSessions("/shared"));
        assertEquals(2, report.getSessions("/shared").size());
        assertTrue(report.getSessions("/shared").containsAll(Arrays.asList(11L, 22L)));
        assertFalse(report.hasSessions("/missing"));
        assertNull(report.getSessions("/missing"));
    }

    @Test
    public void testGetWatchesSummaryDistinguishesPairsFromModes() {
        WatchManager manager = new WatchManager();
        ServerCnxn first = connection(1L);
        ServerCnxn second = connection(2L);
        manager.addWatch("/same", first, WatcherMode.STANDARD);
        manager.addWatch("/same", first, WatcherMode.PERSISTENT);
        manager.addWatch("/other", first);
        manager.addWatch("/same", second);

        WatchesSummary summary = manager.getWatchesSummary();
        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
        assertEquals(3, manager.size());
    }

    @Test
    public void testShutdownIsNoOpAndStateRemainsUsable() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/before", watcher);

        manager.shutdown();

        assertTrue(manager.containsWatcher("/before", watcher));
        assertTrue(manager.addWatch("/after", watcher));
        assertEquals(2, manager.size());
    }

    private static int countOccurrences(String text, String token) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(token, index)) >= 0) {
            count++;
            index += token.length();
        }
        return count;
    }
}

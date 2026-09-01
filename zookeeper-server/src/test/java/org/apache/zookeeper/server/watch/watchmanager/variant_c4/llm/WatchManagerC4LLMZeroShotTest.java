package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Before;
import org.junit.Test;

/**
 * Zero-shot JUnit 4 tests for {@link WatchManager}.
 */
public class WatchManagerC4LLMZeroShotTest {

    private WatchManager watchManager;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    @Test
    public void testInitialState() {
        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals("0 connections watching 0 paths\nTotal watches:0", watchManager.toString());
    }

    @Test
    public void testAddDefaultWatch() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch("/node", watcher));
        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertFalse(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));
        assertEquals(0, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void testAddingSameDefaultWatchTwiceReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch("/node", watcher));
        assertFalse(watchManager.addWatch("/node", watcher));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void testSameWatcherCanWatchMultiplePaths() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch("/first", watcher));
        assertTrue(watchManager.addWatch("/second", watcher));

        assertEquals(2, watchManager.size());
        assertTrue(watchManager.containsWatcher("/first", watcher));
        assertTrue(watchManager.containsWatcher("/second", watcher));
        assertEquals(
                "1 connections watching 2 paths\nTotal watches:2",
                watchManager.toString());
    }

    @Test
    public void testMultipleWatchersCanWatchSamePath() {
        RecordingWatcher firstWatcher = new RecordingWatcher();
        RecordingWatcher secondWatcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch("/node", firstWatcher));
        assertTrue(watchManager.addWatch("/node", secondWatcher));

        assertEquals(2, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", firstWatcher));
        assertTrue(watchManager.containsWatcher("/node", secondWatcher));
        assertEquals(
                "2 connections watching 1 paths\nTotal watches:2",
                watchManager.toString());
    }

    @Test
    public void testDifferentModesCanBeAddedForSameWatcherAndPath() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(
                watchManager.addWatch(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertTrue(
                watchManager.addWatch(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));

        assertEquals(1, watchManager.size());
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));
    }

    @Test
    public void testAddPersistentRecursiveWatchIncrementsRecursiveCount() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(
                watchManager.addWatch(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, watchManager.size());
        assertEquals(1, watchManager.getRecursiveWatchQty());
        assertTrue(
                watchManager.containsWatcher(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testDuplicatePersistentRecursiveWatchDoesNotIncrementCountTwice() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(
                watchManager.addWatch(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(
                watchManager.addWatch(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, watchManager.getRecursiveWatchQty());
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testStaleServerConnectionIsRejected() {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(true);

        assertFalse(watchManager.addWatch("/node", connection));
        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher("/node", connection));
    }

    @Test
    public void testActiveServerConnectionIsAccepted() {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(false);

        assertTrue(watchManager.addWatch("/node", connection));
        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", connection));
    }

    @Test
    public void testContainsWatcherReturnsFalseForUnknownWatcher() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertFalse(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
    }

    @Test
    public void testContainsWatcherReturnsFalseForUnknownPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/registered", watcher);

        assertFalse(watchManager.containsWatcher("/unknown", watcher));
        assertFalse(
                watchManager.containsWatcher(
                        "/unknown",
                        watcher,
                        WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcherFromSpecificPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/first", watcher);
        watchManager.addWatch("/second", watcher);

        assertTrue(watchManager.removeWatcher("/first", watcher));

        assertFalse(watchManager.containsWatcher("/first", watcher));
        assertTrue(watchManager.containsWatcher("/second", watcher));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testRemoveWatcherFromUnknownPathReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/registered", watcher);

        assertFalse(watchManager.removeWatcher("/unknown", watcher));
        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/registered", watcher));
    }

    @Test
    public void testRemoveUnknownWatcherReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertFalse(watchManager.removeWatcher("/node", watcher));
        assertEquals(0, watchManager.size());
    }

    @Test
    public void testRemoveSpecificModePreservesOtherMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        assertTrue(
                watchManager.removeWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));

        assertFalse(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testRemoveMissingModeReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher, WatcherMode.STANDARD);

        assertFalse(
                watchManager.removeWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));

        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testRemoveRecursiveModeDecrementsRecursiveCount() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/root",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        assertEquals(1, watchManager.getRecursiveWatchQty());

        assertTrue(
                watchManager.removeWatcher(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher("/root", watcher));
    }

    @Test
    public void testRemoveAllModesDecrementsRecursiveCount() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/root", watcher, WatcherMode.STANDARD);
        watchManager.addWatch(
                "/root",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        assertEquals(1, watchManager.getRecursiveWatchQty());

        assertTrue(watchManager.removeWatcher("/root", watcher));

        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals(0, watchManager.size());
    }

    @Test
    public void testRemoveWatcherCompletely() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/first", watcher);
        watchManager.addWatch(
                "/second",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        watchManager.removeWatcher(watcher);

        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertFalse(watchManager.containsWatcher("/first", watcher));
        assertFalse(watchManager.containsWatcher("/second", watcher));
        assertTrue(watchManager.getWatch2Paths().isEmpty());
    }

    @Test
    public void testRemoveUnknownWatcherDoesNothing() {
        RecordingWatcher registeredWatcher = new RecordingWatcher();
        RecordingWatcher unknownWatcher = new RecordingWatcher();
        watchManager.addWatch("/node", registeredWatcher);

        watchManager.removeWatcher(unknownWatcher);

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", registeredWatcher));
    }

    @Test
    public void testTriggerStandardWatchNotifiesWatcherAndRemovesRegistration() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeDataChanged,
                        123L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());

        WatchedEvent event = watcher.events.get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals("/node", event.getPath());
        assertEquals(123L, event.getZxid());

        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertEquals(0, watchManager.size());
    }

    @Test
    public void testTriggerUnknownPathReturnsNull() {
        RecordingWatcher watcher = new RecordingWatcher();

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/missing",
                        EventType.NodeCreated,
                        1L,
                        Collections.<ACL>emptyList());

        assertNull(result);
        assertTrue(watcher.events.isEmpty());
    }

    @Test
    public void testPersistentWatchRemainsRegisteredAfterTrigger() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/node",
                watcher,
                WatcherMode.PERSISTENT);

        WatcherOrBitSet firstResult =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeDataChanged,
                        10L,
                        Collections.<ACL>emptyList());
        WatcherOrBitSet secondResult =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeChildrenChanged,
                        11L,
                        Collections.<ACL>emptyList());

        assertNotNull(firstResult);
        assertNotNull(secondResult);
        assertEquals(2, watcher.events.size());
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testStandardModeIsRemovedWhilePersistentModeRemains() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        watchManager.triggerWatch(
                "/node",
                EventType.NodeDeleted,
                20L,
                Collections.<ACL>emptyList());

        assertEquals(1, watcher.events.size());
        assertFalse(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.STANDARD));
        assertTrue(
                watchManager.containsWatcher(
                        "/node",
                        watcher,
                        WatcherMode.PERSISTENT));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testRecursiveWatcherIsTriggeredForDescendantPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/root",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/root/child/grandchild",
                        EventType.NodeCreated,
                        30L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEquals(
                "/root/child/grandchild",
                watcher.events.get(0).getPath());
        assertTrue(
                watchManager.containsWatcher(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void testNonRecursiveParentWatcherIsNotTriggeredForDescendant() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/root",
                watcher,
                WatcherMode.PERSISTENT);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/root/child",
                        EventType.NodeCreated,
                        40L,
                        Collections.<ACL>emptyList());

        assertNull(result);
        assertTrue(watcher.events.isEmpty());
        assertTrue(watchManager.containsWatcher("/root", watcher));
    }

    @Test
    public void testRecursiveWatcherAtRootIsTriggeredForNestedPath() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/a/b/c",
                        EventType.NodeDeleted,
                        50L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEquals("/a/b/c", watcher.events.get(0).getPath());
    }

    @Test
    public void testWatcherRegisteredDirectlyAndRecursivelyIsNotNotifiedTwice() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/root",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);
        watchManager.addWatch(
                "/root/child",
                watcher,
                WatcherMode.STANDARD);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/root/child",
                        EventType.NodeDataChanged,
                        60L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertFalse(
                watchManager.containsWatcher(
                        "/root/child",
                        watcher,
                        WatcherMode.STANDARD));
        assertTrue(
                watchManager.containsWatcher(
                        "/root",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testSuppressedWatcherIsReturnedButNotNotified() {
        RecordingWatcher suppressedWatcher = new RecordingWatcher();
        RecordingWatcher notifiedWatcher = new RecordingWatcher();

        watchManager.addWatch("/node", suppressedWatcher);
        watchManager.addWatch("/node", notifiedWatcher);

        WatcherOrBitSet suppress =
                new WatcherOrBitSet(
                        Collections.<Watcher>singleton(suppressedWatcher));

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeDeleted,
                        70L,
                        Collections.<ACL>emptyList(),
                        suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressedWatcher));
        assertTrue(result.contains(notifiedWatcher));
        assertTrue(suppressedWatcher.events.isEmpty());
        assertEquals(1, notifiedWatcher.events.size());

        assertFalse(watchManager.containsWatcher("/node", suppressedWatcher));
        assertFalse(watchManager.containsWatcher("/node", notifiedWatcher));
    }

    @Test
    public void testServerWatcherReceivesEventAndAclList() {
        ServerWatcher serverWatcher = mock(ServerWatcher.class);
        List<ACL> acl = Collections.emptyList();

        assertTrue(watchManager.addWatch("/node", serverWatcher));

        watchManager.triggerWatch(
                "/node",
                EventType.NodeCreated,
                80L,
                acl);

        verify(serverWatcher).process(any(WatchedEvent.class), same(acl));
        verify(serverWatcher, never()).process(any(WatchedEvent.class));
    }

    @Test
    public void testOrdinaryWatcherReceivesSingleArgumentProcessCall() {
        Watcher watcher = mock(Watcher.class);
        List<ACL> acl = Collections.emptyList();

        watchManager.addWatch("/node", watcher);

        watchManager.triggerWatch(
                "/node",
                EventType.NodeCreated,
                90L,
                acl);

        verify(watcher).process(any(WatchedEvent.class));
    }

    @Test
    public void testTriggerMultipleWatchers() {
        RecordingWatcher firstWatcher = new RecordingWatcher();
        RecordingWatcher secondWatcher = new RecordingWatcher();
        RecordingWatcher unrelatedWatcher = new RecordingWatcher();

        watchManager.addWatch("/node", firstWatcher);
        watchManager.addWatch("/node", secondWatcher);
        watchManager.addWatch("/other", unrelatedWatcher);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeChildrenChanged,
                        100L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(firstWatcher));
        assertTrue(result.contains(secondWatcher));
        assertFalse(result.contains(unrelatedWatcher));

        assertEquals(1, firstWatcher.events.size());
        assertEquals(1, secondWatcher.events.size());
        assertTrue(unrelatedWatcher.events.isEmpty());

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/other", unrelatedWatcher));
    }

    @Test
    public void testGetWatch2PathsContainsAddedRegistration() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/node",
                watcher,
                WatcherMode.PERSISTENT);

        assertTrue(watchManager.getWatch2Paths().containsKey(watcher));
        assertTrue(
                watchManager.getWatch2Paths()
                        .get(watcher)
                        .containsKey("/node"));
        assertTrue(
                watchManager.getWatch2Paths()
                        .get(watcher)
                        .get("/node")
                        .hasMode(WatcherMode.PERSISTENT));
    }

    @Test
    public void testToStringAfterAddingAndRemovingWatches() {
        RecordingWatcher firstWatcher = new RecordingWatcher();
        RecordingWatcher secondWatcher = new RecordingWatcher();

        watchManager.addWatch("/one", firstWatcher);
        watchManager.addWatch("/two", firstWatcher);
        watchManager.addWatch("/one", secondWatcher);

        assertEquals(
                "2 connections watching 2 paths\nTotal watches:3",
                watchManager.toString());

        watchManager.removeWatcher("/one", secondWatcher);

        assertEquals(
                "1 connections watching 2 paths\nTotal watches:2",
                watchManager.toString());
    }

    @Test
    public void testDumpWatchesByPath() {
        ServerCnxn firstConnection = createActiveConnection(0x11L);
        ServerCnxn secondConnection = createActiveConnection(0x22L);

        watchManager.addWatch("/first", firstConnection);
        watchManager.addWatch("/second", secondConnection);

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, true);
        writer.flush();

        String dump = output.toString();
        assertTrue(dump.contains("/first"));
        assertTrue(dump.contains("/second"));
        assertTrue(dump.contains("\t0x11"));
        assertTrue(dump.contains("\t0x22"));
    }

    @Test
    public void testDumpWatchesByConnection() {
        ServerCnxn firstConnection = createActiveConnection(0xABCL);
        ServerCnxn secondConnection = createActiveConnection(0xDEFL);

        watchManager.addWatch("/first", firstConnection);
        watchManager.addWatch("/second", secondConnection);

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, false);
        writer.flush();

        String dump = output.toString();
        assertTrue(dump.contains("0xabc"));
        assertTrue(dump.contains("0xdef"));
        assertTrue(dump.contains("\t/first"));
        assertTrue(dump.contains("\t/second"));
    }

    @Test
    public void testShutdownDoesNotAlterRegisteredWatches() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher);

        watchManager.shutdown();

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void testWatcherCanBeAddedAgainAfterStandardWatchIsTriggered() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher);

        watchManager.triggerWatch(
                "/node",
                EventType.NodeDataChanged,
                110L,
                Collections.<ACL>emptyList());

        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertTrue(watchManager.addWatch("/node", watcher));
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void testRemoveOneRecursiveWatchPreservesOtherRecursiveWatch() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch(
                "/first",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);
        watchManager.addWatch(
                "/second",
                watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        assertEquals(2, watchManager.getRecursiveWatchQty());

        assertTrue(
                watchManager.removeWatcher(
                        "/first",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, watchManager.getRecursiveWatchQty());
        assertFalse(watchManager.containsWatcher("/first", watcher));
        assertTrue(
                watchManager.containsWatcher(
                        "/second",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggeredEventObjectIsPassedToWatcher() {
        Watcher watcher = mock(Watcher.class);
        final WatchedEvent[] capturedEvent = new WatchedEvent[1];

        org.mockito.Mockito.doAnswer(
                        invocation -> {
                            capturedEvent[0] = invocation.getArgument(0);
                            return null;
                        })
                .when(watcher)
                .process(any(WatchedEvent.class));

        watchManager.addWatch("/captured", watcher);

        watchManager.triggerWatch(
                "/captured",
                EventType.NodeDeleted,
                999L,
                Collections.<ACL>emptyList());

        assertNotNull(capturedEvent[0]);
        assertEquals(EventType.NodeDeleted, capturedEvent[0].getType());
        assertEquals(KeeperState.SyncConnected, capturedEvent[0].getState());
        assertEquals("/captured", capturedEvent[0].getPath());
        assertEquals(999L, capturedEvent[0].getZxid());
    }

    @Test
    public void testResultContainsExactWatcherInstance() {
        RecordingWatcher watcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher);

        WatcherOrBitSet result =
                watchManager.triggerWatch(
                        "/node",
                        EventType.NodeCreated,
                        120L,
                        Collections.<ACL>emptyList());

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertSame(watcher, watcher.lastProcessedBy);
    }

    private ServerCnxn createActiveConnection(long sessionId) {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(false);
        when(connection.getSessionId()).thenReturn(sessionId);
        return connection;
    }

    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();
        private Watcher lastProcessedBy;

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
            lastProcessedBy = this;
        }
    }
}
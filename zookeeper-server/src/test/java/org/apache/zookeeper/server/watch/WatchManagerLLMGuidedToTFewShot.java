package org.apache.zookeeper.server.watch;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

/**
 * Guided JUnit4 tests for WatchManager focused exclusively watchers are not processed * Guided JUnit4 tests for WatchManager focused exclusively on:
 * - triggering a path with no watchers returns null
 */
public class WatchManagerLLMGuidedToTFewShot {

    private WatchManager watchManager;

    private static final String PATH = "/test_node";
    private static final String OTHER_PATH = "/other_node";

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    private ServerCnxn createMockWatcher(boolean stale) {
        ServerCnxn watcher = mock(ServerCnxn.class);
        when(watcher.isStale()).thenReturn(stale);
        return watcher;
    }

    private ServerCnxn createLiveWatcher() {
        return createMockWatcher(false);
    }

    // ----------------------------------------------------------------------
    // addWatch(String path, Watcher watcher, WatcherMode watcherMode)
    // ----------------------------------------------------------------------

    @Test
    public void testAddWatchBasicLiveWatcherStandardMode() {
        ServerCnxn watcher = createLiveWatcher();

        boolean added = watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        assertTrue("Adding a live watcher should return true", added);
        assertTrue(
                "Watcher should be stored for the given path and mode",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatchAllowsSameWatcherOnSamePathInDifferentModes() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testAddWatchDuplicateSamePathWatcherAndModeIsIdempotent() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        boolean duplicateAdded = watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        assertFalse(
                "Adding the same path/watcher/mode twice should return false",
                duplicateAdded);
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatchStaleServerCnxnIsIgnored() {
        ServerCnxn staleWatcher = createMockWatcher(true);

        boolean added = watchManager.addWatch(PATH, staleWatcher, WatcherMode.STANDARD);

        assertFalse("Stale watchers should not be added", added);
        assertFalse(watchManager.containsWatcher(PATH, staleWatcher, WatcherMode.STANDARD));
    }

    // ----------------------------------------------------------------------
    // containsWatcher(String path, Watcher watcher, WatcherMode watcherMode)
    // ----------------------------------------------------------------------

    @Test
    public void testContainsWatcherBasicPositiveAndNegativeCases() {
        ServerCnxn watcher = createLiveWatcher();
        ServerCnxn otherWatcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse("Different path should not match",
                watchManager.containsWatcher(OTHER_PATH, watcher, WatcherMode.STANDARD));
        assertFalse("Different watcher should not match",
                watchManager.containsWatcher(PATH, otherWatcher, WatcherMode.STANDARD));
    }

    @Test
    public void testContainsWatcherNullModeActsAsWildcard() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertTrue(
                "Null mode should match an existing watcher in any mode",
                watchManager.containsWatcher(PATH, watcher, null));
    }

    @Test
    public void testContainsWatcherStrictModeMismatchReturnsFalse() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        assertFalse(
                "Strict lookup should fail when stored mode differs",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(
                "Strict lookup should fail when stored mode differs",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testContainsWatcherAfterRemovingOneModeStillFindsOtherModes() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertTrue(watchManager.removeWatcher(PATH, watcher, WatcherMode.STANDARD));

        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(
                "Null mode should still find the watcher because PERSISTENT remains",
                watchManager.containsWatcher(PATH, watcher, null));
    }

    // ----------------------------------------------------------------------
    // removeWatcher(String path, Watcher watcher, WatcherMode watcherMode)
    // ----------------------------------------------------------------------

    @Test
    public void testRemoveWatcherBasicSpecificMode() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        boolean removed = watchManager.removeWatcher(PATH, watcher, WatcherMode.STANDARD);

        assertTrue("Existing watcher/mode should be removed", removed);
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcherNullModeRemovesAllModesForWatcherOnPath() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        boolean removed = watchManager.removeWatcher(PATH, watcher, null);

        assertTrue("Wildcard removal should remove all modes for the watcher/path", removed);
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(watchManager.containsWatcher(PATH, watcher, null));
    }

    @Test
    public void testRemoveWatcherPartialRemovalDoesNotBreakOtherModes() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        boolean removed = watchManager.removeWatcher(PATH, watcher, WatcherMode.STANDARD);

        assertTrue(removed);
        assertFalse(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(
                "Removing STANDARD should not remove PERSISTENT",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcherMismatchReturnsFalseAndDoesNotCorruptExistingState() {
        ServerCnxn watcher = createLiveWatcher();
        ServerCnxn otherWatcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertFalse(watchManager.removeWatcher(PATH, otherWatcher, WatcherMode.STANDARD));
        assertFalse(watchManager.removeWatcher(OTHER_PATH, watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.removeWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcherFromEmptyManagerReturnsFalse() {
        ServerCnxn watcher = createLiveWatcher();

        assertFalse(watchManager.removeWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.removeWatcher(PATH, watcher, null));
    }

    // ----------------------------------------------------------------------
    // triggerWatch(String path, EventType type, long zxid, List<ACL> acl, WatcherOrBitSet suppress)
    // ----------------------------------------------------------------------

    @Test
    public void testTriggerWatchBasicStandardWatcherProcessesEventAndIsRemoved() {
        ServerCnxn watcher = createLiveWatcher();
        List<ACL> acl = Collections.emptyList();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                PATH,
                EventType.NodeDataChanged,
                100L,
                acl,
                null);

        assertNotNull(triggered);
        assertTrue("Triggered set should contain the watcher", triggered.contains(watcher));

        ArgumentCaptor<WatchedEvent> eventCaptor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher, times(1)).process(eventCaptor.capture(), anyList());

        WatchedEvent event = eventCaptor.getValue();
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(PATH, event.getPath());
        assertEquals(100L, event.getZxid());

        assertFalse(
                "STANDARD watches are one-shot and should be removed after trigger",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchNoWatchersReturnsNullAndProcessesNobody() {
        WatcherOrBitSet triggered = watchManager.triggerWatch(
                PATH,
                EventType.NodeCreated,
                1L,
                Collections.<ACL>emptyList(),
                null);

        assertNull("Triggering a path with no watchers should return null", triggered);
    }

    @Test
    public void testTriggerWatchPersistentWatcherSurvivesAfterTrigger() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                PATH,
                EventType.NodeDataChanged,
                200L,
                Collections.<ACL>emptyList(),
                null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class), anyList());

        assertTrue(
                "PERSISTENT watches should remain after trigger",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testTriggerWatchPersistentRecursiveWatcherFiresForChildPathAndSurvives() {
        ServerCnxn watcher = createLiveWatcher();
        String parent = "/parent";
        String child = "/parent/child";

        assertTrue(watchManager.addWatch(parent, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                child,
                EventType.NodeDataChanged,
                300L,
                Collections.<ACL>emptyList(),
                null);

        assertNotNull(triggered);
        assertTrue(
                "Persistent recursive watcher on parent should trigger for child path",
                triggered.contains(watcher));

        ArgumentCaptor<WatchedEvent> eventCaptor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher, times(1)).process(eventCaptor.capture(), anyList());

        assertEquals(EventType.NodeDataChanged, eventCaptor.getValue().getType());
        assertEquals(child, eventCaptor.getValue().getPath());
        assertEquals(300L, eventCaptor.getValue().getZxid());

        assertTrue(
                "PERSISTENT_RECURSIVE watches should remain after trigger",
                watchManager.containsWatcher(parent, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggerWatchSuppressPreventsProcessing() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));

        Set<Watcher> suppressedWatchers = new HashSet<>();
        suppressedWatchers.add(watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressedWatchers);

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                PATH,
                EventType.NodeDataChanged,
                400L,
                Collections.<ACL>emptyList(),
                suppress);

        assertNotNull(
                "The watch can be selected for triggering even when processing is suppressed",
                triggered);
        assertTrue(triggered.contains(watcher));

        verify(watcher, never()).process(any(WatchedEvent.class), anyList());
    }

    @Test
    public void testTriggerWatchStandardAndPersistentTogetherOnlyStandardIsRemoved() {
        ServerCnxn watcher = createLiveWatcher();

        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                PATH,
                EventType.NodeDeleted,
                500L,
                Collections.<ACL>emptyList(),
                null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class), anyList());

        assertFalse(
                "STANDARD watch should be removed after trigger",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(
                "PERSISTENT watch should remain after trigger",
                watchManager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }
}

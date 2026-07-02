package org.apache.zookeeper.server.watch;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.server.ServerCnxn;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class WatchManagerTestMine {

    private WatchManager watchManager;
    private final String NOMINAL_PATH = "/test_node";

    @Before
    public void setUp() {
        // Initialize a clean WatchManager for each test
        watchManager = new WatchManager();
    }

    /* Utility method to create a mock Watcher (ZK Client). Uses ServerCnxn because
       WatchManager.isDeadWatcher() casts to this class. */
    private ServerCnxn createMockWatcher(boolean isStale) {
        ServerCnxn mockWatcher = mock(ServerCnxn.class);
        when(mockWatcher.isStale()).thenReturn(isStale);
        return mockWatcher;
    }

    // Testing addWatch

    @Test
    public void testAddWatch_TC1_Nominal() {

        ServerCnxn liveWatcher = createMockWatcher(false);
        boolean result = watchManager.addWatch(NOMINAL_PATH, liveWatcher, WatcherMode.STANDARD);

        assertTrue("Nominal insertion must return true", result);
        assertTrue(watchManager.containsWatcher(NOMINAL_PATH, liveWatcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatch_TC7_DeadWatcher() {

        ServerCnxn deadWatcher = createMockWatcher(true);
        boolean result = watchManager.addWatch(NOMINAL_PATH, deadWatcher, WatcherMode.STANDARD);

        assertFalse("A stale (dead) watcher must be ignored and return false", result);
        assertFalse(watchManager.containsWatcher(NOMINAL_PATH, deadWatcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatch_TC13_IdempotenceSameMode() {
        // SUT State = {same_mode_already_present}
        ServerCnxn liveWatcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, liveWatcher, WatcherMode.STANDARD);

        // Try to add the exact same combination again
        boolean result = watchManager.addWatch(NOMINAL_PATH, liveWatcher, WatcherMode.STANDARD);

        assertFalse("Adding a mode that is already present must return false (idempotence)", result);
    }


    // Testing triggerWatch

    @Test
    public void testTriggerWatch_TC1_NominalStandard() {
        // SUT State = {STANDARD, direct_match}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet triggered = watchManager.triggerWatch(NOMINAL_PATH, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull(triggered);
        assertTrue("The watcher must be among the triggered ones", triggered.contains(watcher));

        verify(watcher, times(1)).process(any(WatchedEvent.class), anyList());

        // Verify that the STANDARD watcher was removed after triggering
        assertFalse(watchManager.containsWatcher(NOMINAL_PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    @Ignore("Expected failure: Rule delegated to DataTree, WatchManager does not filter NodeChildrenChanged")
    public void testTriggerWatch_TC24_RecursiveRuleIgnoresChildrenChanged() {
        // SUT State = {PERSISTENT_RECURSIVE, parent_match}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch("/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        String childPath = "/parent/child";

        // EventType.NodeChildrenChanged (Domain exception)
        WatcherOrBitSet triggered = watchManager.triggerWatch(childPath, EventType.NodeChildrenChanged, 1L, Collections.emptyList(), null);

        assertNull("A PERSISTENT_RECURSIVE watch must ignore NodeChildrenChanged on child nodes", triggered);
        verify(watcher, never()).process(any(WatchedEvent.class), anyList());
    }

    @Test
    public void testTriggerWatch_TC23_SuppressFilter() {
        // SUT State = {PRESENT_in_suppress}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.STANDARD);

        // Create the suppress filter containing our watcher
        Set<Watcher> suppressSet = new HashSet<>();
        suppressSet.add(watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressSet);

        WatcherOrBitSet triggered = watchManager.triggerWatch(NOMINAL_PATH, EventType.NodeDataChanged, 1L, Collections.emptyList(), suppress);

        // The manager filters out watchers in suppress, therefore process must not be called
        verify(watcher, never()).process(any(WatchedEvent.class), anyList());
    }

    // Testing containsWatcher

    @Test
    public void testContainsWatcher_TC7_WildcardMode() {
        // SUT State = {PRESENT_in_memory_as_PERSISTENT}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.PERSISTENT);

        // Passing mode = null must match any mode
        assertTrue("With mode=null it must behave as a wildcard", watchManager.containsWatcher(NOMINAL_PATH, watcher, null));
    }

    @Test
    public void testContainsWatcher_TC13_StrictMismatch() {
        // SUT State = {DIFFERENT_from_input (Stored as STANDARD)}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.STANDARD);

        // Search for PERSISTENT
        assertFalse("Strict lookup: different mode must fail", watchManager.containsWatcher(NOMINAL_PATH, watcher, WatcherMode.PERSISTENT));
    }

    // Testing removeWatcher

    @Test
    public void testRemoveWatcher_TC13_PartialRemoval() {
        // SUT State = {multiple_modes_in_memory}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.STANDARD);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.PERSISTENT);

        // Remove only STANDARD
        boolean result = watchManager.removeWatcher(NOMINAL_PATH, watcher, WatcherMode.STANDARD);

        assertTrue("Partial removal must report a modification (true)", result);
        assertFalse("STANDARD must be removed", watchManager.containsWatcher(NOMINAL_PATH, watcher, WatcherMode.STANDARD));
        assertTrue("PERSISTENT must remain in memory", watchManager.containsWatcher(NOMINAL_PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcher_TC7_TotalRemovalWithNull() {
        // SUT State -> {multiple_modes_in_memory}
        ServerCnxn watcher = createMockWatcher(false);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.STANDARD);
        watchManager.addWatch(NOMINAL_PATH, watcher, WatcherMode.PERSISTENT);

        // Remove by passing null (wildcard teardown)
        boolean result = watchManager.removeWatcher(NOMINAL_PATH, watcher, null);

        assertTrue("Total removal must report a modification", result);
        assertFalse("The object must completely disappear from the map", watchManager.containsWatcher(NOMINAL_PATH, watcher, null));
    }
}
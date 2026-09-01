package org.apache.zookeeper.server.watch.watchmanager.blackbox;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.WatchesPathReport;
import org.apache.zookeeper.server.watch.WatchesReport;
import org.apache.zookeeper.server.watch.WatchesSummary;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

// Black-box tests derived from the CP, BVA and final selection for the class WatchManager
// Each test creates or receives a Mockito mock of the Watcher interface,
// matching the formal parameter type exposed by WatchManager

public class WatchManagerBlackBoxCFTest {

    private static final String P = "/a";
    private static final String P_CHILD = "/a/b";
    private static final String P_OTHER = "/b";

    private WatchManager watchManager;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    // Creates a mock of the Watcher interface, with a name used only to make Mockito diagnostics easier to read when
    // a test contains multiple watcher instances
    private Watcher createMockWatcher(String name) {
        return mock(Watcher.class, name);
    }


    // addWatch TEST

    // S1 / A0 testAddWatch_NewStandardWatch_IsRegistered
    @Test
    public void testAddWatch_NewStandardWatch_IsRegistered() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);

        assertTrue("The first registration must return true", added);
        assertTrue("The STANDARD registration must be present", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
    }

    // S2 / A8 testAddWatch_ExistingPathDifferentWatcher_PreservesBoth
    @Test
    public void testAddWatch_ExistingPathDifferentWatcher_PreservesBoth() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        boolean added = watchManager.addWatch(P, watcher2, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher2 must return true", added);

        boolean watcher1Added = watchManager.addWatch(P, watcher1, WatcherMode.STANDARD);

        assertTrue("A distinct watcher must be added to an already used path", watcher1Added);
        assertTrue("W1 must be registered", watchManager.containsWatcher(P, watcher1, WatcherMode.STANDARD));
        assertTrue("W2 must remain registered", watchManager.containsWatcher(P, watcher2, WatcherMode.STANDARD));
    }

    // S3 / A16 testAddWatch_ExistingWatcherNewMode_IsAdded
    @Test
    public void testAddWatch_ExistingWatcherNewMode_IsAdded() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration must return true", added);

        boolean persistentAdded = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);

        assertTrue("Adding a different mode to the same watcher and path must return true", persistentAdded);
        assertTrue("The original STANDARD mode must remain registered", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("The new PERSISTENT mode must be registered", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S4 / A17 testAddWatch_DuplicateSameMode_ReturnsFalse
    @Test
    public void testAddWatch_DuplicateSameMode_ReturnsFalse() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration must return true", added);

        boolean addedAgain = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);

        assertFalse("Adding the same watcher-path-mode registration must return false", addedAgain);
        assertTrue("The original STANDARD registration must remain present", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
    }


    // triggerWatch TEST

    // S5 / T0 testTriggerWatch_StandardWatch_IsNotifiedAndRemoved
    @Test
    public void testTriggerWatch_StandardWatch_IsNotifiedAndRemoved() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The result must identify the triggered watcher", triggered);
        assertTrue("The watcher must be included among triggered watchers", triggered.contains(watcher));

        // Verify that the watcher is notified exactly once
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertFalse("A STANDARD watch must be consumed after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
    }

    // S6 / T10 testTriggerWatch_ThrowingWatcher_PropagatesCallbackException
    @Test
    public void testTriggerWatch_ThrowingWatcher_PropagatesCallbackException() {
        Watcher watcher = createMockWatcher("W_ERR");
        RuntimeException expectedException = new RuntimeException("Synthetic watcher failure");

        doThrow(expectedException).when(watcher).process(any(WatchedEvent.class));

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The throwing watcher registration must return true", added);

        try {
            watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);
            fail("The callback RuntimeException was expected to be propagated");
        } catch (RuntimeException actualException) {
            assertTrue("The propagated exception must be the callback exception", actualException == expectedException);
        }

        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertTrue("The PERSISTENT registration must remain after the exceptional callback", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S7 / T11 testTriggerWatch_NonRecursiveAncestor_DoesNotReceiveDescendantEvent
    @Test
    public void testTriggerWatch_NonRecursiveAncestor_DoesNotReceiveDescendantEvent() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertTrue("A non-recursive watcher on an ancestor must not be triggered", triggered == null || !triggered.contains(watcher));

        // Verify that the watcher is never notified for descendant events
        verify(watcher, never()).process(any(WatchedEvent.class));
        assertTrue("The non-matching PERSISTENT registration must remain present", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S8 / T12 testTriggerWatch_RecursiveAncestor_ReceivesDescendantEvent
    @Test
    public void testTriggerWatch_RecursiveAncestor_ReceivesDescendantEvent() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT_RECURSIVE);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The recursive ancestor must produce a trigger result", triggered);
        assertTrue("The recursive watcher must be triggered by the descendant event", triggered.contains(watcher));

        // Verify that the watcher is notified for the descendant event
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertTrue("The recursive registration must remain after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    // S9 / T13 testTriggerWatch_SameWatcherDirectAndRecursive_IsNotifiedOnce
    @Test
    public void testTriggerWatch_SameWatcherDirectAndRecursive_IsNotifiedOnce() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT_RECURSIVE);
        assertTrue("The first registration of watcher must return true", added);

        boolean addedChild = watchManager.addWatch(P_CHILD, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher child must return true", addedChild);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The watcher must be included in a non-null trigger result", triggered);
        assertTrue("The trigger result must contain W1", triggered.contains(watcher));

        // Verify that the watcher is notified exactly once, avoiding duplicate callbacks
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertFalse("The direct STANDARD registration must be consumed", watchManager.containsWatcher(P_CHILD, watcher, WatcherMode.STANDARD));
        assertTrue("The ancestor PERSISTENT_RECURSIVE registration must remain", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    // S10 / T15 testTriggerWatch_PersistentWatch_IsNotifiedAndRetained
    @Test
    public void testTriggerWatch_PersistentWatch_IsNotifiedAndRetained() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The trigger result must not be null", triggered);
        assertTrue("The triggered set must contain W1", triggered.contains(watcher));

        // Verify that the watcher is notified exactly once
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertTrue("A PERSISTENT watch must remain after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S11 / T17 testTriggerWatch_SameWatcherMultipleModes_IsNotifiedOnceAndRetainsPersistentMode
    @Test
    public void testTriggerWatch_SameWatcherMultipleModes_IsNotifiedOnceAndRetainsPersistentMode() {
        Watcher watcher = createMockWatcher("W1");

        boolean addedStandard = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first STANDARD registration must return true", addedStandard);

        boolean addedPersistent = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The additional PERSISTENT registration must return true", addedPersistent);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The trigger result must not be null", triggered);
        assertTrue("The trigger result must contain W1", triggered.contains(watcher));

        // The same watcher is selected by two modes but must receive only one callback
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertFalse("The STANDARD mode must be consumed after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("The PERSISTENT mode must remain after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S12 / T37 testTriggerWatch_PartialSuppress_NotifiesOnlyUnsuppressedWatcher
    @Test
    public void testTriggerWatch_PartialSuppress_NotifiesOnlyUnsuppressedWatcher() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        boolean addedW1 = watchManager.addWatch(P, watcher1, WatcherMode.PERSISTENT);
        assertTrue("The first registration of watcher1 must return true", addedW1);

        boolean addedW2 = watchManager.addWatch(P, watcher2, WatcherMode.PERSISTENT);
        assertTrue("The first registration of watcher2 must return true", addedW2);

        // Create suppresed watcher set
        Set<Watcher> suppressedWatchers = new HashSet<>();
        suppressedWatchers.add(watcher1);

        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressedWatchers);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), suppress);

        // W1 is a candidate, but suppress prevents its callback.
        verify(watcher1, never()).process(any(WatchedEvent.class));

        // W2 is a candidate and receives the event
        verify(watcher2, times(1)).process(any(WatchedEvent.class));

        assertNotNull("The trigger result must contain the candidate watchers",triggered);
        assertTrue("W1 remains a candidate even though its notification is suppressed", triggered.contains(watcher1));
        assertTrue("W2 must be included among the candidate watchers", triggered.contains(watcher2));
        assertTrue("W1 must remain registered as PERSISTENT", watchManager.containsWatcher(P, watcher1, WatcherMode.PERSISTENT));
        assertTrue("W2 must remain registered as PERSISTENT", watchManager.containsWatcher(P, watcher2, WatcherMode.PERSISTENT));
    }


    // containsWatcher TEST

    // S13 / C13 testContainsWatcher_RegisteredOnlyOnOtherPath_ReturnsFalse
    @Test
    public void testContainsWatcher_RegisteredOnlyOnOtherPath_ReturnsFalse() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P_OTHER, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        assertFalse("A watcher registered only on another path must not match P", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("The registration on P_OTHER must remain valid", watchManager.containsWatcher(P_OTHER, watcher, WatcherMode.STANDARD));
    }

    // S14 / C15 testContainsWatcher_NullMode_MatchesAnyRegisteredMode
    @Test
    public void testContainsWatcher_NullMode_MatchesAnyRegisteredMode() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The first registration of watcher must return true", added);

        assertTrue("A null mode must match any registered mode", watchManager.containsWatcher(P, watcher, null));
    }

    // S15 / C18 testContainsWatcher_DifferentMode_ReturnsFalse
    @Test
    public void testContainsWatcher_DifferentMode_ReturnsFalse() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        assertFalse("A strict lookup with a different mode must return false", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
        assertTrue("The original STANDARD mode must remain registered", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
    }


    // removeWatcher TEST

    // S16 / R9 testRemoveWatcher_WithMultipleWatchers_PreservesOtherWatcher
    @Test
    public void testRemoveWatcher_WithMultipleWatchers_PreservesOtherWatcher() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        boolean addedW1 = watchManager.addWatch(P, watcher1, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher1 must return true", addedW1);
        boolean addedW2 = watchManager.addWatch(P, watcher2, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher2 must return true", addedW2);

        boolean removed = watchManager.removeWatcher(P, watcher1, WatcherMode.STANDARD);

        assertTrue("Removing W1 must report a modification", removed);
        assertFalse("W1 must be removed", watchManager.containsWatcher(P, watcher1, WatcherMode.STANDARD));
        assertTrue("W2 must remain registered on the same path", watchManager.containsWatcher(P, watcher2, WatcherMode.STANDARD));
    }

    // S17 / R13 testRemoveWatcher_RegisteredOnlyOnOtherPath_DoesNotModifyState
    @Test
    public void testRemoveWatcher_RegisteredOnlyOnOtherPath_DoesNotModifyState() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P_OTHER, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration on another path of watcher must return true", added);

        boolean removed = watchManager.removeWatcher(P, watcher, WatcherMode.STANDARD);

        assertFalse("Removing from a path without the watcher must return false", removed);
        assertFalse("The watcher must remain absent from P", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("The registration on P_OTHER must remain unchanged", watchManager.containsWatcher(P_OTHER, watcher, WatcherMode.STANDARD));
    }

    // S18 / R14 testRemoveWatcher_RegisteredOnMultiplePaths_RemovesOnlyRequestedPath
    @Test
    public void testRemoveWatcher_RegisteredOnMultiplePaths_RemovesOnlyRequestedPath() {
        Watcher watcher = createMockWatcher("W1");

        boolean addedOnP = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The registration on P must return true", addedOnP);

        boolean addedOnOtherPath = watchManager.addWatch(P_OTHER, watcher, WatcherMode.STANDARD);
        assertTrue("The registration on P_OTHER must return true", addedOnOtherPath);

        boolean removed = watchManager.removeWatcher(P, watcher, WatcherMode.STANDARD);

        assertTrue("Removing the registration from P must return true", removed);
        assertFalse("W1 must no longer be registered on P", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("W1 must remain registered on P_OTHER", watchManager.containsWatcher(P_OTHER, watcher, WatcherMode.STANDARD));
    }

    // S19 / R15 testRemoveWatcher_NullMode_RemovesAllModesForPath
    @Test
    public void testRemoveWatcher_NullMode_RemovesAllModesForPath() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        boolean addedNewMode = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The second registration of watcher in another mode must return true", addedNewMode);

        boolean removed = watchManager.removeWatcher(P, watcher, null);

        assertTrue("Removing with a null mode must report a modification", removed);
        assertFalse("No mode must remain for the watcher-path pair", watchManager.containsWatcher(P, watcher, null));
        assertFalse("STANDARD must no longer be registered", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertFalse("PERSISTENT must no longer be registered", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // S20 / R22 testRemoveWatcher_OneOfMultipleModes_RemovesOnlyRequestedMode
    @Test
    public void testRemoveWatcher_OneOfMultipleModes_RemovesOnlyRequestedMode() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        boolean addedNewMode = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The second registration of watcher in another mode must return true", addedNewMode);

        boolean removed = watchManager.removeWatcher(P, watcher, WatcherMode.STANDARD);

        assertTrue("Removing one registered mode must return true", removed);
        assertFalse("STANDARD must be removed", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertTrue("PERSISTENT must remain registered", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }


    // triggerWatch Sequences (TS) TEST

    // S21 / TS1 testTriggerWatch_StandardWatch_SecondTriggerDoesNotNotifyAgain
    @Test
    public void testTriggerWatch_StandardWatch_SecondTriggerDoesNotNotifyAgain() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first STANDARD registration must return true", added);

        WatcherOrBitSet firstTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The first trigger result must not be null", firstTriggered);
        assertTrue("The first trigger result must contain W1", firstTriggered.contains(watcher));
        assertFalse("The STANDARD mode must be consumed after the first trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));

        WatcherOrBitSet secondTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 2L, Collections.emptyList(), null);

        assertTrue("The second trigger must not contain W1", secondTriggered == null || !secondTriggered.contains(watcher));

        // Two trigger operations must produce only one callback in total
        verify(watcher, times(1)).process(any(WatchedEvent.class));

        assertFalse("The STANDARD mode must remain absent after the second trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
    }

    // S22 / TS2 testTriggerWatch_PersistentWatch_TwoTriggersNotifyTwice
    @Test
    public void testTriggerWatch_PersistentWatch_TwoTriggersNotifyTwice() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The first PERSISTENT registration must return true", added);

        WatcherOrBitSet firstTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        assertNotNull("The first trigger result must not be null", firstTriggered);
        assertTrue("The first trigger result must contain W1", firstTriggered.contains(watcher));
        assertTrue("PERSISTENT must remain registered after the first trigger", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));

        WatcherOrBitSet secondTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 2L, Collections.emptyList(), null);

        assertNotNull("The second trigger result must not be null", secondTriggered);
        assertTrue("The second trigger result must contain W1", secondTriggered.contains(watcher));

        // A persistent watcher must receive both events
        verify(watcher, times(2)).process(any(WatchedEvent.class));

        assertTrue("PERSISTENT must remain registered after the second trigger", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
    }

    // ADDED IN ORDER TO IMPROVE METRICS

    // TEST size()
    @Test
    public void testSize_EmptyManagerReturnsZero() {
        assertEquals("A new manager must contain no watches", 0, watchManager.size());
    }

    @Test
    public void testSize_CountsWatcherRegistrationsAcrossPaths() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        assertTrue(watchManager.addWatch(P, watcher1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, watcher2, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, watcher1, WatcherMode.STANDARD));

        assertEquals("Size must count watcher registrations stored in the path table", 3, watchManager.size());
    }

    // TEST addWatch(String, Watcher)

    @Test
    public void testAddWatch_DefaultOverloadRegistersStandardWatch() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher);

        assertTrue(added);
        assertTrue(watchManager.containsWatcher(P, watcher, WatcherMode.DEFAULT_WATCHER_MODE));
    }

    // TEST containsWatcher(String, Watcher)

    @Test
    public void testContainsWatcherOverload_DefaultOverloadMatchesRegisteredWatcher() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT));

        assertTrue("The overload without mode must match any registered mode", watchManager.containsWatcher(P, watcher));
    }

    // TEST removeWatcher(String, Watcher)

    @Test
    public void testRemoveWatcher_DefaultOverloadRemovesAllModesForPath() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.removeWatcher(P, watcher));
        assertFalse(watchManager.containsWatcher(P, watcher, null));
    }

    // TEST triggerWatch without suppres

    @Test
    public void testTriggerWatch_DefaultOverloadNotifiesWatcher() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));
        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList());

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class));
    }

    // TEST removeWatcher(Watcher)

    @Test
    public void testRemoveWatcherGlobally_UnregisteredWatcherDoesNothing() {
        Watcher watcher = createMockWatcher("W1");

        watchManager.removeWatcher(watcher);

        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher(P, watcher, null));
    }

    @Test
    public void testRemoveWatcherGlobally_RemovesAllPathsAndPreservesOtherWatcher() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        assertTrue(watchManager.addWatch(P, watcher1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, watcher1, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(P, watcher2, WatcherMode.STANDARD));
        assertEquals("The initial state must contain three path-watcher registrations", 3, watchManager.size());

        watchManager.removeWatcher(watcher1);

        assertFalse("W1 must be removed from P", watchManager.containsWatcher(P, watcher1, null));
        assertFalse("W1 must be removed from P_OTHER", watchManager.containsWatcher(P_OTHER, watcher1, null));

        assertTrue("W2 must remain registered on P",
                watchManager.containsWatcher(P, watcher2, WatcherMode.STANDARD));

        assertEquals("Only the W2 registration must remain", 1, watchManager.size());
    }

    @Test
    public void testRemoveWatcherGlobally_RemovesRecursiveRegistration() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        watchManager.removeWatcher(watcher);

        assertFalse(watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged,
                1L, Collections.emptyList(), null);

        assertNull(triggered);
        verify(watcher, never()).process(any(WatchedEvent.class));
    }


    // Covers stale Watcher
    @Test
    public void testAddWatch_StaleServerConnectionIsRejected() {
        ServerCnxn staleConnection = mock(ServerCnxn.class, "STALE_CONNECTION");
        when(staleConnection.isStale()).thenReturn(true);
        boolean added = watchManager.addWatch(P, staleConnection, WatcherMode.STANDARD);

        assertFalse("A stale ServerCnxn must not be registered", added);
        assertFalse(watchManager.containsWatcher(P, staleConnection, WatcherMode.STANDARD));
        assertEquals(0, watchManager.size());
    }

    // Covers non stale Watcher
    @Test
    public void testAddWatch_ActiveServerConnectionIsRegistered() {
        ServerCnxn activeConnection = createMockServerCnxn("ACTIVE_CONNECTION", 0x40L);
        boolean added = watchManager.addWatch(P, activeConnection, WatcherMode.STANDARD);

        assertTrue(added);
        assertTrue(watchManager.containsWatcher(P, activeConnection, WatcherMode.STANDARD));
    }

    // Cover the switch on the events
    @Test
    public void testTriggerWatch_NodeCreatedUpdatesEventPath() {
        assertStandardWatcherTriggeredBy(EventType.NodeCreated);
    }

    @Test
    public void testTriggerWatch_NodeDeletedUpdatesEventPath() {
        assertStandardWatcherTriggeredBy(EventType.NodeDeleted);
    }

    @Test
    public void testTriggerWatch_NodeChildrenChangedUpdatesEventPath() {
        assertStandardWatcherTriggeredBy(EventType.NodeChildrenChanged);
    }

    @Test
    public void testTriggerWatch_UnloggedEventTypeStillNotifiesWatcher() {
        assertStandardWatcherTriggeredBy(EventType.DataWatchRemoved);
    }

    // Covers serverWatcher
    @Test
    public void testTriggerWatch_ServerWatcherReceivesEventAndAcl() {
        ServerWatcher serverWatcher = mock(ServerWatcher.class, "SERVER_WATCHER");
        List<ACL> acl = Collections.emptyList();
        assertTrue(watchManager.addWatch(P, serverWatcher, WatcherMode.PERSISTENT));
        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, acl, null);
        assertNotNull(triggered);

        assertTrue(triggered.contains(serverWatcher));
        verify(serverWatcher, times(1)).process(any(WatchedEvent.class), same(acl));
    }

    // Covers getWatchesSummary()
    @Test
    public void testGetWatchesSummary_ReportsConnectionsPathsAndWatches() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        assertTrue(watchManager.addWatch(P, watcher1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, watcher1, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(P, watcher2, WatcherMode.STANDARD));

        WatchesSummary summary = watchManager.getWatchesSummary();
        assertEquals(2, summary.getNumConnections());
        assertEquals(2, summary.getNumPaths());
        assertEquals(3, summary.getTotalWatches());
    }

    // Covers toString()
    @Test
    public void testToString_ReportsConnectionsPathsAndTotalWatches() {
        Watcher watcher1 = createMockWatcher("W1");
        Watcher watcher2 = createMockWatcher("W2");

        assertTrue(watchManager.addWatch(P, watcher1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, watcher1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, watcher2, WatcherMode.STANDARD));
        String description = watchManager.toString();

        assertTrue(description.contains("2 connections watching 2 paths"));
        assertTrue(description.contains("Total watches:3")
        );
    }

    // Covers getWatches()
    @Test
    public void testGetWatches_ReportsPathsGroupedBySession() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);

        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));

        WatchesReport report = watchManager.getWatches();
        assertNotNull(report);
    }

    // Covers getWatcherByPath
    @Test
    public void testGetWatchesByPath_ReportsSessionsGroupedByPath() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);

        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));

        WatchesPathReport report = watchManager.getWatchesByPath();
        assertNotNull(report);
    }

    // Covers dumpWatches()
    @Test
    public void testDumpWatches_ByPathReportsPathAndSession() {
        ServerCnxn connection = createMockServerCnxn("C1", 0x40L);
        assertTrue(watchManager.addWatch(P, connection, WatcherMode.STANDARD));

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, true);
        writer.flush();

        String dump = output.toString();

        assertTrue(dump.contains(P));
        assertTrue(dump.contains("0x40"));
    }

    @Test
    public void testDumpWatches() {
        ServerCnxn connection = createMockServerCnxn("C1", 0x40L);

        assertTrue(watchManager.addWatch(P, connection, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection, WatcherMode.PERSISTENT));

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, false);
        writer.flush();

        String dump = output.toString();

        assertTrue(dump.contains("0x40"));
        assertTrue(dump.contains(P));
        assertTrue(dump.contains(P_OTHER));
    }

    // Covers shutdown()
    @Test
    public void testShutdown_CompletesWithoutChangingRegistrations() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT));
        watchManager.shutdown();

        assertTrue("The no-op shutdown must not alter current registrations",
                watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT)
        );
    }

    // Complete removeWatcher(path, watcher, mode) by recoursive decrement
    @Test
    public void testRemoveWatcher_RecursiveModeDisablesAncestorNotification() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(watchManager.removeWatcher(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged,
                1L, Collections.emptyList(), null);

        assertNull(triggered);
        verify(watcher, never()).process(any(WatchedEvent.class));
    }



    // HELPER & UTILITY METHODS
    private ServerCnxn createMockServerCnxn(String name, long sessionId) {
        ServerCnxn connection = mock(ServerCnxn.class, name);
        when(connection.getSessionId()).thenReturn(sessionId);
        when(connection.isStale()).thenReturn(false);
        return connection;
    }

    private void assertStandardWatcherTriggeredBy(EventType eventType) {
        Watcher watcher = createMockWatcher("W_" + eventType);
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));
        WatcherOrBitSet triggered = watchManager.triggerWatch(P, eventType, 1L, Collections.emptyList(), null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class));
    }

}
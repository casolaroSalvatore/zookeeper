package org.apache.zookeeper.server.watch.watchmanager.blackbox;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doThrow;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Test;

// Black-box tests derived from the CP, BVA and final selection for the class WatchManager
// Each test creates or receives a Mockito mock of the Watcher interface,
// matching the formal parameter type exposed by WatchManager

public class WatchManagerBlackBoxTest {

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
}
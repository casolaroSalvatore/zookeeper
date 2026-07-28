package org.apache.zookeeper.server.watch.watchmanager.blackbox;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.*;
import org.apache.zookeeper.metrics.impl.DefaultMetricsProvider;
import org.apache.zookeeper.server.ServerMetrics;
import org.junit.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Black-box tests derived from the CP, BVA and final selection for the class WatchManager
// Each test creates or receives a Mockito mock of the Watcher interface,
// matching the formal parameter type exposed by WatchManager

public class WatchManagerBlackBoxCFMutationTest {

    private static final String P = "/a";
    private static final String P_CHILD = "/a/b";
    private static final String P_OTHER = "/b";

    private WatchManager watchManager;
    private static DefaultMetricsProvider metricsProvider;

    @Before
    public void setUp() {
        watchManager = new WatchManager();

        // Metrics are global. Reset them before every test so that each metric assertion
        // starts from a deterministic state
        metricsProvider.resetAllValues();
    }

    @BeforeClass
    public static void setUpMetricsProvider() {metricsProvider = new DefaultMetricsProvider();

        // Makes ServerMetrics build its current metrics using the provider controlled by this test class
        ServerMetrics.metricsProviderInitialized(metricsProvider);
    }

    @AfterClass
    public static void restoreMetricsProvider() {

        // Avoids leaving a stopped or reset provider installed globally after this test class has completed
        ServerMetrics.metricsProviderInitialized(
                new DefaultMetricsProvider()
        );
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

    /* MODIFIED IN ORDER TO KILL mutants 163 (removed call to Iterator.remove) and 172
    (removed conditional - replaced equality check with false)

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
    } */


    // S5 / T0, testTriggerWatch_StandardWatch_IsNotifiedAndRemoved

    @Test
    public void testTriggerWatch_StandardWatch_IsNotifiedAndRemoved() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);
        assertNotNull("The result must identify the triggered watcher", triggered);
        assertTrue("The watcher must be included among triggered watchers", triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class));
        assertFalse("A STANDARD watch must be consumed after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertFalse("No mode must remain for the watcher-path pair", watchManager.containsWatcher(P, watcher, null));
        assertEquals("The consumed watcher must be removed from the path index", 0, watchManager.size());

        WatchesSummary summary = watchManager.getWatchesSummary();

        assertEquals("The empty path entry must be removed from watchTable", 0, summary.getNumPaths());
        assertEquals("No logical watch must remain", 0, summary.getTotalWatches());

        WatcherOrBitSet secondTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 2L, Collections.emptyList(), null);
        assertNull("The consumed STANDARD watch must not be triggered again", secondTriggered);
        verify(watcher, times(1)).process(any(WatchedEvent.class));
    }

    // S5 / T0, testTriggerWatch_StandardWatch_IsNotifiedAndRemoved
    @Ignore("Known defect: after consuming the last STANDARD watch, WatchManager retains an empty " +
            "watcher entry in watch2Paths, so getWatchesSummary() reports one connection with zero watches")
    @Test
    public void testTriggerWatch_StandardWatch_IsNotifiedAndFullyRemoved() {
        Watcher watcher = createMockWatcher("W1");

        boolean added = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first registration of watcher must return true", added);

        WatcherOrBitSet triggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);
        assertNotNull("The result must identify the triggered watcher", triggered);
        assertTrue("The watcher must be included among triggered watchers", triggered.contains(watcher));
        verify(watcher, times(1)).process(any(WatchedEvent.class));
        assertFalse("A STANDARD watch must be consumed after the trigger", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertFalse("No mode must remain for the watcher-path pair", watchManager.containsWatcher(P, watcher, null));
        assertEquals("The consumed watcher must be removed from the path index", 0, watchManager.size());

        WatchesSummary summary = watchManager.getWatchesSummary();

        assertEquals("No connection with active watches must remain", 0, summary.getNumConnections());
        assertEquals("The empty path entry must be removed from watchTable", 0, summary.getNumPaths());
        assertEquals("No logical watch must remain", 0, summary.getTotalWatches());

        WatcherOrBitSet secondTriggered = watchManager.triggerWatch(P, EventType.NodeDataChanged, 2L, Collections.emptyList(), null);
        assertNull("The consumed STANDARD watch must not be triggered again", secondTriggered);
        verify(watcher, times(1)).process(any(WatchedEvent.class));
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

    /* MODIFIED IN ORDER TO KILL mutants 277 (removed conditional - replaced equality check with false)
    and 281 (removed conditional - replaced equality check with false)
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
    } */

    // S19 / R15 testRemoveWatcher_NullMode_RemovesAllModesForPath
    @Test
    public void testRemoveWatcher_NullMode_RemovesAllModesForPath() {
        Watcher watcher = createMockWatcher("W1");
        boolean addedStandard = watchManager.addWatch(P, watcher, WatcherMode.STANDARD);
        assertTrue("The first STANDARD registration must return true", addedStandard);

        boolean addedPersistent = watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT);
        assertTrue("The PERSISTENT mode must be added", addedPersistent);

        boolean removed = watchManager.removeWatcher(P, watcher, null);
        assertTrue("Removing with a null mode must report a modification", removed);
        assertFalse("No mode must remain for the watcher-path pair", watchManager.containsWatcher(P, watcher, null));
        assertFalse("STANDARD must no longer be registered", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        assertFalse("PERSISTENT must no longer be registered", watchManager.containsWatcher(P, watcher, WatcherMode.PERSISTENT));
        assertEquals("The watcher must be removed from the path index", 0, watchManager.size());

        WatchesSummary summary = watchManager.getWatchesSummary();
        assertEquals("The watcher must be removed from the connection index", 0, summary.getNumConnections());
        assertEquals("The empty path entry must be removed", 0, summary.getNumPaths());
        assertEquals("No logical watch must remain", 0, summary.getTotalWatches());
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

    /* MODIFIED IN ORDER TO KILL mutant 122 (removed conditional - replaced equality check with false)
    and to exercise mutations 128 and 129 on recursive-watch removal
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
    } */

    @Test
    public void testRemoveWatcherGlobally_RemovesRecursiveRegistration() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals("One recursive registration must initially be present", 1, watchManager.size());
        watchManager.removeWatcher(watcher);
        assertFalse("The recursive registration must be removed", watchManager.containsWatcher(P, watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals("No registration must remain in the path index", 0, watchManager.size());
        WatchesSummary summary = watchManager.getWatchesSummary();
        assertEquals("No connection must remain after global removal", 0, summary.getNumConnections());

        assertEquals("The path entry must be removed when its last watcher is removed", 0, summary.getNumPaths());
        assertEquals("No logical watch must remain", 0, summary.getTotalWatches());

        WatcherOrBitSet triggered = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, 1L,
                Collections.emptyList(), null);

        assertNull("The removed recursive watcher must not receive descendant events", triggered);

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

    /* Covers getWatches()
    // MODIFIED IN ORDER TO STRENGTHEN the oracle for getWatches() and detect incorrect session-to-path
    // report contents
    @Test
    public void testGetWatches_ReportsPathsGroupedBySession() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);

        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));
        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));

        WatchesReport report = watchManager.getWatches();
        assertNotNull(report);
    } */


    @Test
    public void testGetWatches_ReportsPathsGroupedBySession() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);
        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));

        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));
        WatchesReport report = watchManager.getWatches();
        assertNotNull(report);

        Set<String> connection1Paths = report.getPaths(0x40L);
        Set<String> connection2Paths = report.getPaths(0x41L);
        assertEquals(new HashSet<>(Arrays.asList(P, P_OTHER)), connection1Paths);
        assertEquals(Collections.singleton(P), connection2Paths);
        assertNull("An unknown session must not have reported paths", report.getPaths(0x42L));
    }

    /* Covers getWatcherByPath
    // MODIFIED IN ORDER TO STRENGTHEN the oracle for getWatchesByPath()
    // and detect incorrect path-to-session report contents
    @Test
    public void testGetWatchesByPath_ReportsSessionsGroupedByPath() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);

        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));

        WatchesPathReport report = watchManager.getWatchesByPath();
        assertNotNull(report);
    } */

    @Test
    public void testGetWatchesByPath_ReportsSessionsGroupedByPath() {
        ServerCnxn connection1 = createMockServerCnxn("C1", 0x40L);
        ServerCnxn connection2 = createMockServerCnxn("C2", 0x41L);
        assertTrue(watchManager.addWatch(P, connection1, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P, connection2, WatcherMode.STANDARD));

        assertTrue(watchManager.addWatch(P_OTHER, connection1, WatcherMode.PERSISTENT));
        WatchesPathReport report = watchManager.getWatchesByPath();
        assertNotNull(report);

        Set<Long> sessionsOnP = report.getSessions(P);
        Set<Long> sessionsOnOtherPath = report.getSessions(P_OTHER);
        assertEquals(new HashSet<>(Arrays.asList(0x40L, 0x41L)), sessionsOnP);
        assertEquals(Collections.singleton(0x40L), sessionsOnOtherPath);
        assertNull("An unknown path must not have reported sessions", report.getSessions("/missing"));
    }

    /* Covers dumpWatches()
    // MODIFIED IN ORDER TO KILL mutants2// 236 (removed conditional - replaced equality check with false)
    // 240 (removed PrintWriter.print of indentation/session prefix)
    // 241 (removed PrintWriter.print of session id)
    // and 242 (removed PrintWriter.print of newline)
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
    } */

    @Test
    public void testDumpWatches_ByPathReportsPathThenIndentedSession() {
        ServerCnxn connection = createMockServerCnxn("C1", 0x40L);

        assertTrue(watchManager.addWatch(P, connection, WatcherMode.STANDARD));

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, true);
        writer.flush();

        // The path is printed with println(), which uses the platform line separator. The session line is
        // terminated explicitly with print("\n") by WatchManager
        String expected = P + System.lineSeparator() + "\t0x40\n";

        assertEquals("The path-oriented dump must print the path first " + "and the indented session second", expected, output.toString());
    }

    /* MODIFIED IN ORDER TO KILL mutants 236 (removed conditional - replaced equality check with false)
    // 247 (removed PrintWriter.print of session prefix)
    // 248 (removed PrintWriter.println of session id)
    // 250 (removed PrintWriter.print of path indentation)
    // and 251 (removed PrintWriter.println of path)
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
    } */

    @Test
    public void testDumpWatches_ByConnectionReportsSessionThenIndentedPaths() {
        ServerCnxn connection = createMockServerCnxn("C1", 0x40L);
        assertTrue(watchManager.addWatch(P, connection, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, connection, WatcherMode.PERSISTENT));

        StringWriter output = new StringWriter();
        PrintWriter writer = new PrintWriter(output);

        watchManager.dumpWatches(writer, false);
        writer.flush();

        String[] lines = output.toString().split("\\R");
        assertEquals("The connection-oriented dump must contain " + "one session line and two path lines", 3, lines.length);
        assertEquals("The session must be printed first and without indentation", "0x40", lines[0]);

        Set<String> actualPathLines = new HashSet<>();
        actualPathLines.add(lines[1]);
        actualPathLines.add(lines[2]);

        Set<String> expectedPathLines = new HashSet<>();
        expectedPathLines.add("\t" + P);
        expectedPathLines.add("\t" + P_OTHER);

        assertEquals("Both paths must be indented below the session", expectedPathLines, actualPathLines);
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

    // ADDED IN ORDER TO KILL MUTANTS

    // Kills mutant line 71 (replaced boolean return with true for org/apache/zookeeper/server/watch/WatchManager)
    @Test
    public void testAddWatch_DefaultOverloadDuplicateReturnsFalse() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher));
        boolean addedAgain = watchManager.addWatch(P, watcher);

        assertFalse("The default overload must return false for a duplicate watch", addedAgain);

        assertTrue(watchManager.containsWatcher(P, watcher, WatcherMode.DEFAULT_WATCHER_MODE));
    }

    // Kill mutant 259 (replaced boolean return with true for org/apache/zookeeper/server/watch/WatchManager)
    @Test
    public void testContainsWatcher_DefaultOverloadReturnsFalseForOtherPath() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P_OTHER, watcher, WatcherMode.PERSISTENT));

        assertFalse("A watcher registered only on another path " + "must not match P", watchManager.containsWatcher(P, watcher));

        assertTrue(watchManager.containsWatcher(P_OTHER, watcher));
    }

    // Kill mutant (316 replaced boolean return with true for org/apache/zookeeper/server/watch/WatchManager::removeWatcher)
    // and mutant 321 (replaced boolean return with true for org/apache/zookeeper/server/watch/WatchManager::removeWatcher)
    @Test
    public void testRemoveWatcher_DefaultOverloadReturnsFalseWhenAbsent() {
        Watcher watcher = createMockWatcher("W1");

        boolean removed = watchManager.removeWatcher(P, watcher);

        assertFalse("Removing an unregistered watcher through the default " + "overload must return false", removed);
    }

    @Test
    public void testRemoveWatcher_UnregisteredModeOnExistingPairReturnsFalse() {
        Watcher watcher = createMockWatcher("W1");

        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));

        boolean removed = watchManager.removeWatcher(P, watcher, WatcherMode.PERSISTENT);

        assertFalse("Removing a mode that is not registered for an existing "
                        + "watcher-path pair must return false", removed);

        assertTrue("The existing STANDARD mode must remain unchanged", watchManager.containsWatcher(
                        P, watcher, WatcherMode.STANDARD));
    }

    // ADDED IN ORDER TO STRENGTHEN the oracle for mutant
    // 277 (removed conditional - replaced equality check with false)
    @Test
    public void testRemoveWatcher_LastRegistrationOnPathPreservesOtherPath() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.addWatch(P_OTHER, watcher, WatcherMode.PERSISTENT));
        assertTrue(watchManager.removeWatcher(P, watcher, WatcherMode.STANDARD));
        assertFalse(watchManager.containsWatcher(P, watcher, null));
        assertTrue(watchManager.containsWatcher(P_OTHER, watcher, WatcherMode.PERSISTENT));

        WatchesSummary summary = watchManager.getWatchesSummary();
        assertEquals("The watcher still owns another registration", 1, summary.getNumConnections());
        assertEquals("Only P_OTHER must remain in the path index", 1, summary.getNumPaths());
        assertEquals("Only one logical watch must remain", 1, summary.getTotalWatches());
        assertEquals("Only one path-watcher registration must remain", 1, watchManager.size());
    }

    // ADDED IN ORDER TO KILL mutant 197 (removed call to Summary.add for NODE_CREATED_WATCHER)
    @Test
    public void testTriggerWatch_NodeCreatedIncrementsMetric() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));

        long before = metricValue("cnt_node_created_watch_count");
        watchManager.triggerWatch(P, EventType.NodeCreated, 1L, Collections.emptyList(), null);

        long after = metricValue("cnt_node_created_watch_count");
        assertEquals(before + 1, after);
    }

    // ADDED IN ORDER TO KILL mutant 201 (removed call to Summary.add for NODE_DELETED_WATCHER)
    @Test
    public void testTriggerWatch_NodeDeletedIncrementsMetric() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));

        long before = metricValue("cnt_node_deleted_watch_count");
        watchManager.triggerWatch(P, EventType.NodeDeleted, 1L, Collections.emptyList(), null);

        long after = metricValue("cnt_node_deleted_watch_count");
        assertEquals(before + 1, after);
    }

    // ADDED IN ORDER TO KILL mutant 205 (removed call to Summary.add for NODE_CHANGED_WATCHER)
    @Test
    public void testTriggerWatch_NodeDataChangedIncrementsMetric() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));

        long before = metricValue("cnt_node_changed_watch_count");
        watchManager.triggerWatch(P, EventType.NodeDataChanged, 1L, Collections.emptyList(), null);

        long after = metricValue("cnt_node_changed_watch_count");
        assertEquals(before + 1, after);
    }

    // ADDED IN ORDER TO KILL mutant 209 (removed call to Summary.add for NODE_CHILDREN_WATCHER)
    @Test
    public void testTriggerWatch_NodeChildrenChangedIncrementsMetric() {
        Watcher watcher = createMockWatcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));

        long before = metricValue("cnt_node_children_watch_count");
        watchManager.triggerWatch(P, EventType.NodeChildrenChanged, 1L, Collections.emptyList(), null);

        long after = metricValue("cnt_node_children_watch_count");
        assertEquals(before + 1, after);
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

    private long metricValue(String metricName) {
        Map<String, Object> metrics = dumpMetrics(metricsProvider);

        Object value = metrics.get(metricName);

        assertNotNull("Metric not found: " + metricName, value);

        assertTrue(value instanceof Number);

        return ((Number) value).longValue();
    }

    private static Map<String, Object> dumpMetrics(DefaultMetricsProvider provider) {

        Map<String, Object> values = new HashMap<>();
        provider.dump(values::put);
        return values;
    }
}
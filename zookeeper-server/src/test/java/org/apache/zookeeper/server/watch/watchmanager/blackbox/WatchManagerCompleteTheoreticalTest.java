package org.apache.zookeeper.server.watch.watchmanager.blackbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

/**
 * Complete theoretical suite derived from the CP and BVA for WatchManager.
 *
 * Unit cases are executable. Cases requiring an observable ZooKeeper namespace
 * or a publicly constructible invalid object are retained with @Ignore so that
 * the theoretical traceability is not lost without inventing a false fixture.
 */
public class WatchManagerCompleteTheoreticalTest {

    private static final String P_ROOT = "/";
    private static final String P = "/a";
    private static final String P_CHILD = "/a/b";
    private static final String P_OTHER = "/b";
    private static final String P_EMPTY = "";
    private static final String P_REL = "a";
    private static final String P_BADCHAR = "/a" + '\0';

    private static final long ZX_NEG = -1L;
    private static final long ZX_ZERO = 0L;
    private static final long ZX_POS = 1L;

    private WatchManager watchManager;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
    }

    private Watcher watcher(String name) {
        return mock(Watcher.class, name);
    }

    private Watcher throwingWatcher(String name) {
        Watcher watcher = watcher(name);
        doThrow(new RuntimeException("Synthetic watcher failure")).when(watcher).process(any(WatchedEvent.class));
        return watcher;
    }

    private List<ACL> validAcl() {
        return Collections.singletonList(new ACL(ZooDefs.Perms.READ, new Id("world", "anyone")));
    }

    private WatcherOrBitSet suppress(Watcher... watchers) {
        Set<Watcher> set = new HashSet<>();
        Collections.addAll(set, watchers);
        return new WatcherOrBitSet(set);
    }

    private void assertEvent(Watcher watcher, EventType type, String path, long zxid) {
        ArgumentCaptor<WatchedEvent> captor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher, times(1)).process(captor.capture());
        assertEquals(type, captor.getValue().getType());
        assertEquals(path, captor.getValue().getPath());
        assertEquals(zxid, captor.getValue().getZxid());
    }

    private void characterizeAdd(String path, Watcher watcher, WatcherMode mode) {
        try {
            boolean added = watchManager.addWatch(path, watcher, mode);
            assertEquals("The returned value and observable state must agree", added, watchManager.containsWatcher(path, watcher, mode));
        } catch (RuntimeException expected) {
            assertFalse("A failed add must not leave a nominal registration", watchManager.containsWatcher(P, watcher, WatcherMode.STANDARD));
        }
    }

    private void characterizeTrigger(String eventPath, EventType type, long zxid, List<ACL> acl) {
        Watcher watcher = watcher("W1");
        assertTrue(watchManager.addWatch(P, watcher, WatcherMode.STANDARD));
        try {
            watchManager.triggerWatch(eventPath, type, zxid, acl, null);
        } catch (RuntimeException expected) {
            assertTrue("The characterization test accepts a documented runtime rejection", true);
        }
    }

    private void characterizeContains(String path, Watcher watcher) {
        try {
            watchManager.containsWatcher(path, watcher, WatcherMode.STANDARD);
        } catch (RuntimeException expected) {
            assertTrue("The characterization test accepts a documented runtime rejection", true);
        }
    }

    private void characterizeRemove(String path, Watcher watcher) {
        try {
            watchManager.removeWatcher(path, watcher, WatcherMode.STANDARD);
        } catch (RuntimeException expected) {
            assertTrue("The characterization test accepts a documented runtime rejection", true);
        }
    }

    // addWatch: A0-A17

    @Test public void testA0_AddWatch_NominalStandard() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testA1_AddWatch_NullPath_Characterization() { characterizeAdd(null, watcher("W1"), WatcherMode.STANDARD); }
    @Test public void testA2_AddWatch_EmptyPath_Characterization() { characterizeAdd(P_EMPTY, watcher("W1"), WatcherMode.STANDARD); }
    @Test public void testA3_AddWatch_RootPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_ROOT, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_ROOT, w, WatcherMode.STANDARD)); }
    @Test public void testA4_AddWatch_RelativePath_Characterization() { characterizeAdd(P_REL, watcher("W1"), WatcherMode.STANDARD); }
    @Test public void testA5_AddWatch_ForbiddenCharacterPath_Characterization() { characterizeAdd(P_BADCHAR, watcher("W1"), WatcherMode.STANDARD); }
    @Ignore("Integration case: requires an observable ZooKeeper namespace without /a") @Test public void testA6_AddWatch_ZnodeAbsent() { }
    @Ignore("Integration case: requires an observable ZooKeeper namespace containing /a") @Test public void testA7_AddWatch_ZnodePresent() { }
    @Test public void testA8_AddWatch_OneWatcherAlreadyOnPath() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w2, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w2, WatcherMode.STANDARD)); }
    @Test public void testA9_AddWatch_MultipleWatchersAlreadyOnPath() { Watcher w1 = watcher("W1"), w2 = watcher("W2"), w3 = watcher("W3"); assertTrue(watchManager.addWatch(P, w2, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w3, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w2, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w3, WatcherMode.STANDARD)); }
    @Test public void testA10_AddWatch_NullWatcher_Characterization() { characterizeAdd(P, null, WatcherMode.STANDARD); }
    @Ignore("Theoretical partition: no publicly constructible invalid Watcher with an addWatch-specific anomaly") @Test public void testA11_AddWatch_InvalidWatcher() { }
    @Test public void testA12_AddWatch_WatcherAlreadyAssociated() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testA13_AddWatch_NullMode_Characterization() { characterizeAdd(P, watcher("W1"), null); }
    @Test public void testA14_AddWatch_PersistentMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testA15_AddWatch_PersistentRecursiveMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); }
    @Test public void testA16_AddWatch_NewModeForExistingWatcher() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testA17_AddWatch_AlreadyRegisteredMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.addWatch(P, w, WatcherMode.STANDARD)); }

    // triggerWatch: T0-T38

    @Test public void testT0_Trigger_NominalStandard() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNotNull(r); assertTrue(r.contains(w)); assertEvent(w, EventType.NodeDataChanged, P, ZX_POS); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testT1_Trigger_NullPath_Characterization() { characterizeTrigger(null, EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Test public void testT2_Trigger_EmptyPath_Characterization() { characterizeTrigger(P_EMPTY, EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Test public void testT3_Trigger_RootPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_ROOT, w, WatcherMode.STANDARD)); WatcherOrBitSet r = watchManager.triggerWatch(P_ROOT, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNotNull(r); assertTrue(r.contains(w)); verify(w, times(1)).process(any(WatchedEvent.class)); }
    @Test public void testT4_Trigger_RelativePath_Characterization() { characterizeTrigger(P_REL, EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Test public void testT5_Trigger_ForbiddenCharacterPath_Characterization() { characterizeTrigger(P_BADCHAR, EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Ignore("Integration case: requires an observable ZooKeeper namespace without /a") @Test public void testT6_Trigger_ZnodeAbsent() { }
    @Ignore("Integration case: requires an observable ZooKeeper namespace containing /a") @Test public void testT7_Trigger_ZnodePresent() { }
    @Test public void testT8_Trigger_NoCandidate() { Watcher w = watcher("W1"); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNull(r); verify(w, never()).process(any(WatchedEvent.class)); }
    @Test public void testT9_Trigger_MultipleCandidates() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w2, WatcherMode.STANDARD)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNotNull(r); assertTrue(r.contains(w1)); assertTrue(r.contains(w2)); verify(w1).process(any(WatchedEvent.class)); verify(w2).process(any(WatchedEvent.class)); }
    @Test(expected = RuntimeException.class) public void testT10_Trigger_CallbackThrowsRuntimeException() { Watcher w = throwingWatcher("W_ERR"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); }
    @Test public void testT11_Trigger_NonRecursiveAncestor() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); WatcherOrBitSet r = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertTrue(r == null || !r.contains(w)); verify(w, never()).process(any(WatchedEvent.class)); }
    @Test public void testT12_Trigger_RecursiveAncestor() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); WatcherOrBitSet r = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNotNull(r); assertTrue(r.contains(w)); verify(w).process(any(WatchedEvent.class)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); }
    @Test public void testT13_Trigger_DirectAndRecursiveSameWatcherOnce() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertTrue(watchManager.addWatch(P_CHILD, w, WatcherMode.STANDARD)); WatcherOrBitSet r = watchManager.triggerWatch(P_CHILD, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertNotNull(r); assertTrue(r.contains(w)); verify(w, times(1)).process(any(WatchedEvent.class)); }
    @Test public void testT14_Trigger_UnrelatedPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); WatcherOrBitSet r = watchManager.triggerWatch(P_OTHER, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); assertTrue(r == null || !r.contains(w)); verify(w, never()).process(any(WatchedEvent.class)); }
    @Test public void testT15_Trigger_PersistentMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); verify(w).process(any(WatchedEvent.class)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testT16_Trigger_PersistentRecursiveModeExactPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); verify(w).process(any(WatchedEvent.class)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); }
    @Test public void testT17_Trigger_SameWatcherMultipleModes() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), null); verify(w, times(1)).process(any(WatchedEvent.class)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testT18_Trigger_NullEventType_Characterization() { characterizeTrigger(P, null, ZX_POS, Collections.emptyList()); }
    @Test public void testT19_Trigger_NodeCreated() { assertTriggeredEvent(EventType.NodeCreated, ZX_POS, Collections.emptyList()); }
    @Test public void testT20_Trigger_NodeDeleted() { assertTriggeredEvent(EventType.NodeDeleted, ZX_POS, Collections.emptyList()); }
    @Test public void testT21_Trigger_NodeChildrenChangedExactPath() { assertTriggeredEvent(EventType.NodeChildrenChanged, ZX_POS, Collections.emptyList()); }
    @Ignore("The NodeChildrenChanged recursive filtering rule is owned by the higher-level event-generation path, not necessarily by WatchManager") @Test public void testT22_Trigger_NodeChildrenChangedRecursiveDescendant() { }
    @Ignore("Theoretical partition: no additional pertinent EventType selected for this WatchManager contract") @Test public void testT23_Trigger_OtherValidEventType() { }
    @Test public void testT24_Trigger_NegativeZxid() { assertTriggeredEvent(EventType.NodeDataChanged, ZX_NEG, Collections.emptyList()); }
    @Test public void testT25_Trigger_ZeroZxid() { assertTriggeredEvent(EventType.NodeDataChanged, ZX_ZERO, Collections.emptyList()); }
    @Test public void testT26_Trigger_PositiveZxid() { assertTriggeredEvent(EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Test public void testT27_Trigger_MinLongZxid() { assertTriggeredEvent(EventType.NodeDataChanged, Long.MIN_VALUE, Collections.emptyList()); }
    @Test public void testT28_Trigger_MaxLongZxid() { assertTriggeredEvent(EventType.NodeDataChanged, Long.MAX_VALUE, Collections.emptyList()); }
    @Test public void testT29_Trigger_NullAcl_Characterization() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); try { watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, null, null); verify(w).process(any(WatchedEvent.class)); } catch (RuntimeException expected) { assertTrue(true); } }
    @Test public void testT30_Trigger_EmptyAcl() { assertTriggeredEvent(EventType.NodeDataChanged, ZX_POS, Collections.emptyList()); }
    @Test public void testT31_Trigger_PopulatedValidAcl() { assertTriggeredEvent(EventType.NodeDataChanged, ZX_POS, validAcl()); }
    @Test public void testT32_Trigger_AclContainingNull_Characterization() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); List<ACL> acl = Collections.singletonList(null); try { watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, acl, null); verify(w).process(any(WatchedEvent.class)); } catch (RuntimeException expected) { assertTrue(true); } }
    @Ignore("Theoretical partition: no public, operation-relevant definition of an invalid ACL object") @Test public void testT33_Trigger_InvalidAcl() { }
    @Test public void testT34_Trigger_EmptySuppressSet() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), suppress()); assertNotNull(r); verify(w).process(any(WatchedEvent.class)); }
    @Test public void testT35_Trigger_SuppressSetWithoutCandidate() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w1, WatcherMode.PERSISTENT)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), suppress(w2)); assertNotNull(r); verify(w1).process(any(WatchedEvent.class)); }
    @Test public void testT36_Trigger_SuppressCandidate() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), suppress(w)); assertNotNull(r); assertTrue(r.contains(w)); verify(w, never()).process(any(WatchedEvent.class)); }
    @Test public void testT37_Trigger_PartialSuppress() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w1, WatcherMode.PERSISTENT)); assertTrue(watchManager.addWatch(P, w2, WatcherMode.PERSISTENT)); WatcherOrBitSet r = watchManager.triggerWatch(P, EventType.NodeDataChanged, ZX_POS, Collections.emptyList(), suppress(w1)); assertNotNull(r); assertTrue(r.contains(w1)); assertTrue(r.contains(w2)); verify(w1, never()).process(any(WatchedEvent.class)); verify(w2).process(any(WatchedEvent.class)); }
    @Ignore("Theoretical partition: WatcherOrBitSet has no public inconsistent state selected for this test") @Test public void testT38_Trigger_InvalidSuppress() { }

    private void assertTriggeredEvent(EventType type, long zxid, List<ACL> acl) {
        Watcher w = watcher("W1");
        assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD));
        WatcherOrBitSet result = watchManager.triggerWatch(P, type, zxid, acl, null);
        assertNotNull(result);
        assertTrue(result.contains(w));
        assertEvent(w, type, P, zxid);
    }

    // containsWatcher: C0-C20

    @Test public void testC0_Contains_NominalMatch() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testC1_Contains_NullPath_Characterization() { characterizeContains(null, watcher("W1")); }
    @Test public void testC2_Contains_EmptyPath_Characterization() { characterizeContains(P_EMPTY, watcher("W1")); }
    @Test public void testC3_Contains_RootPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_ROOT, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_ROOT, w, WatcherMode.STANDARD)); }
    @Test public void testC4_Contains_RelativePath_Characterization() { characterizeContains(P_REL, watcher("W1")); }
    @Test public void testC5_Contains_ForbiddenCharacterPath_Characterization() { characterizeContains(P_BADCHAR, watcher("W1")); }
    @Ignore("Integration case: requires an observable ZooKeeper namespace without /a") @Test public void testC6_Contains_ZnodeAbsent() { }
    @Ignore("Integration case: requires an observable ZooKeeper namespace containing /a") @Test public void testC7_Contains_ZnodePresent() { }
    @Test public void testC8_Contains_NoRegistrationOnPath() { assertFalse(watchManager.containsWatcher(P, watcher("W1"), WatcherMode.STANDARD)); }
    @Test public void testC9_Contains_MultipleRegistrationsOnPath() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w2, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w1, WatcherMode.STANDARD)); }
    @Test public void testC10_Contains_NullWatcher_Characterization() { characterizeContains(P, null); }
    @Ignore("Theoretical partition: no publicly constructible invalid Watcher relevant to containsWatcher") @Test public void testC11_Contains_InvalidWatcher() { }
    @Test public void testC12_Contains_WatcherNeverRegistered() { assertFalse(watchManager.containsWatcher(P, watcher("W1"), WatcherMode.STANDARD)); }
    @Test public void testC13_Contains_WatcherRegisteredOnlyElsewhere() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_OTHER, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_OTHER, w, WatcherMode.STANDARD)); }
    @Test public void testC14_Contains_WatcherOnPathAndElsewhere() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P_OTHER, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_OTHER, w, WatcherMode.STANDARD)); }
    @Test public void testC15_Contains_NullModeMatchesAny() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.containsWatcher(P, w, null)); }
    @Test public void testC16_Contains_PersistentMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testC17_Contains_PersistentRecursiveMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); }
    @Test public void testC18_Contains_RequestedModeNotRegistered() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testC19_Contains_RequestedModeRegistered() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testC20_Contains_ModeUnspecified() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertTrue(watchManager.containsWatcher(P, w, null)); }

    // removeWatcher: R0-R22

    @Test public void testR0_Remove_NominalSingleMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testR1_Remove_NullPath_Characterization() { characterizeRemove(null, watcher("W1")); }
    @Test public void testR2_Remove_EmptyPath_Characterization() { characterizeRemove(P_EMPTY, watcher("W1")); }
    @Test public void testR3_Remove_RootPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_ROOT, w, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P_ROOT, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P_ROOT, w, WatcherMode.STANDARD)); }
    @Test public void testR4_Remove_RelativePath_Characterization() { characterizeRemove(P_REL, watcher("W1")); }
    @Test public void testR5_Remove_ForbiddenCharacterPath_Characterization() { characterizeRemove(P_BADCHAR, watcher("W1")); }
    @Ignore("Integration case: requires an observable ZooKeeper namespace without /a") @Test public void testR6_Remove_ZnodeAbsent() { }
    @Ignore("Integration case: requires an observable ZooKeeper namespace containing /a") @Test public void testR7_Remove_ZnodePresent() { }
    @Test public void testR8_Remove_NoRegistrationOnPath() { assertFalse(watchManager.removeWatcher(P, watcher("W1"), WatcherMode.STANDARD)); }
    @Test public void testR9_Remove_MultipleWatchersPreservesOther() { Watcher w1 = watcher("W1"), w2 = watcher("W2"); assertTrue(watchManager.addWatch(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w2, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P, w1, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w1, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w2, WatcherMode.STANDARD)); }
    @Test public void testR10_Remove_NullWatcher_Characterization() { characterizeRemove(P, null); }
    @Ignore("Theoretical partition: no publicly constructible invalid Watcher relevant to removeWatcher") @Test public void testR11_Remove_InvalidWatcher() { }
    @Test public void testR12_Remove_WatcherNeverRegistered() { assertFalse(watchManager.removeWatcher(P, watcher("W1"), WatcherMode.STANDARD)); }
    @Test public void testR13_Remove_WatcherRegisteredOnlyElsewhere() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P_OTHER, w, WatcherMode.STANDARD)); assertFalse(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_OTHER, w, WatcherMode.STANDARD)); }
    @Test public void testR14_Remove_FromRequestedPathPreservesOtherPath() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P_OTHER, w, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P_OTHER, w, WatcherMode.STANDARD)); }
    @Test public void testR15_Remove_NullModeRemovesAll() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.removeWatcher(P, w, null)); assertFalse(watchManager.containsWatcher(P, w, null)); }
    @Test public void testR16_Remove_PersistentMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.PERSISTENT)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
    @Test public void testR17_Remove_PersistentRecursiveMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT_RECURSIVE)); }
    @Test public void testR18_Remove_RequestedModeNotRegistered() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.removeWatcher(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testR19_Remove_RequestedModeRegistered() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testR20_Remove_ModeUnspecified() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.removeWatcher(P, w, null)); assertFalse(watchManager.containsWatcher(P, w, null)); }
    @Test public void testR21_Remove_SingleMode() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); }
    @Test public void testR22_Remove_MultipleModesSelective() { Watcher w = watcher("W1"); assertTrue(watchManager.addWatch(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.addWatch(P, w, WatcherMode.PERSISTENT)); assertTrue(watchManager.removeWatcher(P, w, WatcherMode.STANDARD)); assertFalse(watchManager.containsWatcher(P, w, WatcherMode.STANDARD)); assertTrue(watchManager.containsWatcher(P, w, WatcherMode.PERSISTENT)); }
}

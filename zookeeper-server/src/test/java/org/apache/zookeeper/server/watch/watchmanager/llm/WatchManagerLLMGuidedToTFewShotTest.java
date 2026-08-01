/*
 * Comprehensive JUnit 4 tests for the four requested WatchManager operations.
 */
package org.apache.zookeeper.server.watch.watchmanager.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Test;

/**
 * Guided tests for:
 * <ul>
 *   <li>{@link WatchManager#addWatch(String, Watcher, WatcherMode)}</li>
 *   <li>{@link WatchManager#triggerWatch(String, EventType, long, List, WatcherOrBitSet)}</li>
 *   <li>{@link WatchManager#containsWatcher(String, Watcher, WatcherMode)}</li>
 *   <li>{@link WatchManager#removeWatcher(String, Watcher, WatcherMode)}</li>
 * </ul>
 */
public class WatchManagerLLMGuidedToTFewShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    // ---------------------------------------------------------------------
    // addWatch(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void testAddWatchRegistersRequestedMode() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/basic", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/basic", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatchReturnsFalseForDuplicateMode() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/duplicate", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/duplicate", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/duplicate", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testAddWatchAllowsSameWatcherPathInAllModes() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testAddWatchKeepsWatchersAndPathsIndependent() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", first, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/one", second, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/two", first, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/one", first, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/one", second, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/two", first, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/two", second, WatcherMode.STANDARD));
    }

    // ---------------------------------------------------------------------
    // containsWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void testContainsWatcherWithNullModeMeansAnyMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/any", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/any", watcher, null));
    }

    @Test
    public void testContainsWatcherRejectsWrongModePathAndWatcher() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/right", registered, WatcherMode.PERSISTENT);

        assertFalse(manager.containsWatcher("/right", registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/wrong", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/right", other, WatcherMode.PERSISTENT));
    }

    @Test
    public void testContainsWatcherOnEmptyManagerReturnsFalse() {
        assertFalse(manager.containsWatcher("/missing", new RecordingWatcher(), null));
    }

    // ---------------------------------------------------------------------
    // triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
    // ---------------------------------------------------------------------

    @Test
    public void testTriggerWatchDeliversCompleteEventAndReturnsTriggeredSet() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/event", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/event", EventType.NodeDataChanged, 42L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), "/event", EventType.NodeDataChanged, 42L);
    }

    @Test
    public void testTriggerWatchOnUnwatchedPathReturnsNull() {
        WatcherOrBitSet result = manager.triggerWatch(
                "/unwatched", EventType.NodeCreated, 1L, null, null);

        assertNull(result);
    }

    @Test
    public void testTriggerWatchConsumesStandardButRetainsPersistentMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/mixed", watcher, WatcherMode.STANDARD);
        manager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/mixed", EventType.NodeCreated, 1L, null, null);

        assertFalse(manager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));

        manager.triggerWatch("/mixed", EventType.NodeDeleted, 2L, null, null);
        assertEquals(2, watcher.events.size());
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testTriggerWatchConsumesPureStandardWatchOnlyOnce() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/once", watcher, WatcherMode.STANDARD);

        assertNotNull(manager.triggerWatch("/once", EventType.NodeCreated, 1L, null, null));
        assertNull(manager.triggerWatch("/once", EventType.NodeDeleted, 2L, null, null));
        assertEquals(1, watcher.events.size());
        assertFalse(manager.containsWatcher("/once", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchFiresRecursiveAncestorAndDirectWatcherOnceEach() {
        RecordingWatcher recursive = new RecordingWatcher();
        RecordingWatcher direct = new RecordingWatcher();
        manager.addWatch("/a", recursive, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a/b", direct, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b", EventType.NodeChildrenChanged, 7L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(recursive));
        assertTrue(result.contains(direct));
        assertEquals(1, recursive.events.size());
        assertEquals(1, direct.events.size());
        assertTrue(manager.containsWatcher("/a", recursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/a/b", direct, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchDeduplicatesWatcherRegisteredDirectlyAndRecursively() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/root/child", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child", EventType.NodeDataChanged, 9L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void testTriggerWatchSuppressesNotificationButStillReturnsAndConsumesWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();
        manager.addWatch("/suppress", suppressed, WatcherMode.STANDARD);
        manager.addWatch("/suppress", delivered, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet result = manager.triggerWatch(
                "/suppress", EventType.NodeCreated, 11L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(delivered));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, delivered.events.size());
        assertFalse(manager.containsWatcher("/suppress", suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/suppress", delivered, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchPassesAclToServerWatcher() {
        RecordingServerWatcher watcher = new RecordingServerWatcher();
        List<ACL> acl = Collections.singletonList(
                new ACL(31, new Id("world", "anyone")));
        manager.addWatch("/acl", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/acl", EventType.NodeCreated, 12L, acl, null);

        assertEquals(1, watcher.serverEvents.size());
        assertSame(acl, watcher.lastAcl);
        assertEvent(watcher.serverEvents.get(0), "/acl", EventType.NodeCreated, 12L);
    }

    // ---------------------------------------------------------------------
    // removeWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void testRemoveWatcherRemovesOnlyRequestedMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/remove-one", watcher, WatcherMode.STANDARD);
        manager.addWatch("/remove-one", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/remove-one", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/remove-one", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/remove-one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/remove-one", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/remove-one", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testRemoveWatcherWithNullModeRemovesAllModesForPair() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/remove-all", watcher, WatcherMode.STANDARD);
        manager.addWatch("/remove-all", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/remove-all", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/remove-all", watcher, null));
        assertFalse(manager.containsWatcher("/remove-all", watcher, null));
        assertNull(manager.triggerWatch(
                "/remove-all", EventType.NodeCreated, 1L, null, null));
    }

    @Test
    public void testRemoveWatcherReturnsFalseForMissingModePathOrWatcher() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/registered", registered, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/registered", registered, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/absent", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher("/registered", other, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/registered", registered, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcherReturnsFalseWhenRepeated() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/repeat-remove", watcher, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/repeat-remove", watcher, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/repeat-remove", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcherDoesNotDisturbOtherPairs() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();
        manager.addWatch("/shared", first, WatcherMode.PERSISTENT);
        manager.addWatch("/shared", second, WatcherMode.PERSISTENT);
        manager.addWatch("/other", first, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/shared", first, WatcherMode.PERSISTENT));

        assertFalse(manager.containsWatcher("/shared", first, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/shared", second, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/other", first, WatcherMode.PERSISTENT));
    }

    private static void assertEvent(
            WatchedEvent event, String path, EventType type, long zxid) {
        assertEquals(path, event.getPath());
        assertEquals(type, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(zxid, event.getZxid());
    }

    private static class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }

    private static final class RecordingServerWatcher implements ServerWatcher {
        private final List<WatchedEvent> serverEvents = new ArrayList<>();
        private List<ACL> lastAcl;

        @Override
        public void process(WatchedEvent event) {
            // The WatchManager should use the ACL-aware overload for ServerWatcher.
            throw new AssertionError("ACL-unaware process method was called");
        }

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            serverEvents.add(event);
            lastAcl = acl;
        }
    }
}

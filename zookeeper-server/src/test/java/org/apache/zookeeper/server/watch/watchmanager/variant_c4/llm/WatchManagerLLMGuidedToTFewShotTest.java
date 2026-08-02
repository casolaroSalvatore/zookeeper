/*
 * Comprehensive JUnit 4 tests for the four guided WatchManager operations.
 */
package org.apache.zookeeper.server.watch.watchmanager.variant_c4.llm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Test;

public class WatchManagerLLMGuidedToTFewShotTest {

    private static final String PATH = "/node";

    private static class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        int eventCount() {
            return events.size();
        }

        WatchedEvent lastEvent() {
            return events.get(events.size() - 1);
        }
    }

    private static class RecordingServerWatcher implements ServerWatcher {
        private final List<WatchedEvent> events = new ArrayList<>();
        private List<ACL> lastAcl;

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            events.add(event);
            lastAcl = acl;
        }
    }

    // ---------------------------------------------------------------------
    // addWatch(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void addWatchRegistersEachModeAndRejectsDuplicateMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertFalse("the same path/watcher/mode is idempotent",
                manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals("one watcher is present in the path index", 1, manager.size());
    }

    @Test
    public void addWatchKeepsDifferentPathsAndWatchersIndependent() {
        WatchManager manager = new WatchManager();
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/a", first, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/b", first, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/a", second, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/a", first, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/b", first, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/a", second, WatcherMode.STANDARD));
        assertEquals(3, manager.size());
    }

    @Test(expected = NullPointerException.class)
    public void addWatchRejectsNullMode() {
        new WatchManager().addWatch(PATH, new RecordingWatcher(), null);
    }

    // ---------------------------------------------------------------------
    // triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
    // ---------------------------------------------------------------------

    @Test
    public void triggerWatchDeliversCompleteEventAndConsumesStandardWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeDataChanged, 42L, null, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount());
        assertEvent(watcher.lastEvent(), PATH, EventType.NodeDataChanged, 42L);
        assertFalse("standard watches are one-shot",
                manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertNull("a consumed standard watch must not fire twice",
                manager.triggerWatch(PATH, EventType.NodeDataChanged, 43L, null, null));
        assertEquals(1, watcher.eventCount());
    }

    @Test
    public void triggerWatchReturnsNullWhenNothingMatches() {
        WatchManager manager = new WatchManager();
        assertNull(manager.triggerWatch(
                "/unwatched", EventType.NodeCreated, 1L, null, null));
    }

    @Test
    public void triggerWatchKeepsPersistentWatchForSubsequentEvents() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeCreated, 1L, null, null);
        manager.triggerWatch(PATH, EventType.NodeDeleted, 2L, null, null);

        assertEquals(2, watcher.eventCount());
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEvent(watcher.lastEvent(), PATH, EventType.NodeDeleted, 2L);
    }

    @Test
    public void triggerWatchFiresRecursiveWatchFromAncestorButNotSibling() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/root/child/grandchild", EventType.NodeCreated, 7L, null, null);
        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.eventCount());
        assertEvent(watcher.lastEvent(), "/root/child/grandchild", EventType.NodeCreated, 7L);
        assertTrue(manager.containsWatcher("/root", watcher,
                WatcherMode.PERSISTENT_RECURSIVE));

        assertNull(manager.triggerWatch(
                "/other/child", EventType.NodeCreated, 8L, null, null));
        assertEquals(1, watcher.eventCount());
    }

    @Test
    public void triggerWatchNotifiesWatcherOnlyOnceWhenDirectAndAncestorRegistrationsMatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/root/child", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/root/child", EventType.NodeDataChanged, 9L, null, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals("the trigger result is a set and must de-duplicate the watcher",
                1, watcher.eventCount());
    }

    @Test
    public void triggerWatchSuppressesDeliveryButStillReturnsAndConsumesMatchedWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();
        manager.addWatch(PATH, suppressed, WatcherMode.STANDARD);
        manager.addWatch(PATH, delivered, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeDeleted, 10L, null, suppress);

        assertNotNull(fired);
        assertTrue(fired.contains(suppressed));
        assertTrue(fired.contains(delivered));
        assertEquals(0, suppressed.eventCount());
        assertEquals(1, delivered.eventCount());
        assertFalse(manager.containsWatcher(PATH, suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, delivered, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchPassesAclToServerWatcher() {
        WatchManager manager = new WatchManager();
        RecordingServerWatcher watcher = new RecordingServerWatcher();
        List<ACL> acl = Collections.singletonList(new ACL());
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeChildrenChanged, 11L, acl, null);

        assertEquals(1, watcher.events.size());
        assertSame("WatchManager must forward the original ACL list", acl, watcher.lastAcl);
        assertEvent(watcher.events.get(0), PATH, EventType.NodeChildrenChanged, 11L);
    }

    // ---------------------------------------------------------------------
    // containsWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void containsWatcherSupportsAnyModeAndExactModeQueries() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher(PATH, watcher));
        assertTrue(manager.containsWatcher(PATH, watcher, null));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher,
                WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void containsWatcherReturnsFalseForUnknownPathWatcherAndRemovedPair() {
        WatchManager manager = new WatchManager();
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.STANDARD);

        assertFalse(manager.containsWatcher("/missing", registered, null));
        assertFalse(manager.containsWatcher(PATH, unknown, null));
        assertTrue(manager.removeWatcher(PATH, registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, registered, null));
    }

    // ---------------------------------------------------------------------
    // removeWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void removeWatcherRemovesOnlyRequestedMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher,
                WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForPairOnly() {
        WatchManager manager = new WatchManager();
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();
        manager.addWatch(PATH, first, WatcherMode.STANDARD);
        manager.addWatch(PATH, first, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch(PATH, second, WatcherMode.PERSISTENT);
        manager.addWatch("/other", first, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher(PATH, first, null));

        assertFalse(manager.containsWatcher(PATH, first, null));
        assertTrue(manager.containsWatcher(PATH, second, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/other", first, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherMismatchIsNoOpAndRepeatedRemovalReturnsFalse() {
        WatchManager manager = new WatchManager();
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.STANDARD);

        assertFalse(manager.removeWatcher("/missing", registered, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher(PATH, other, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher(PATH, registered, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, registered, WatcherMode.STANDARD));

        assertTrue(manager.removeWatcher(PATH, registered, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher(PATH, registered, WatcherMode.STANDARD));
    }

    @Test
    public void removingRecursiveWatchStopsDescendantTriggers() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertNull(manager.triggerWatch(
                "/root/child", EventType.NodeCreated, 12L, null, null));
        assertEquals(0, watcher.eventCount());
    }

    private static void assertEvent(
            WatchedEvent event, String path, EventType type, long zxid) {
        assertEquals(path, event.getPath());
        assertEquals(type, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(zxid, event.getZxid());
    }
}
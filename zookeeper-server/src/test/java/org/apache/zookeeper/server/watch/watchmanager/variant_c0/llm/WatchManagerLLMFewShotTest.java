package org.apache.zookeeper.server.watch.watchmanager.variant_c0.llm;

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
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Test;

public class WatchManagerLLMFewShotTest {
    private static final List<ACL> NO_ACL = Collections.emptyList();

    private static final class RecordingWatcher implements Watcher {

        private final String name;
        private final List<WatchedEvent> events = new ArrayList<>();

        private RecordingWatcher(String name) {
            this.name = name;
        }

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        int eventCount() {
            return events.size();
        }

        WatchedEvent lastEvent() {
            assertFalse("Expected at least one event for " + name, events.isEmpty());
            return events.get(events.size() - 1);
        }

        void assertNoEvents() {
            assertTrue("Expected no events for " + name, events.isEmpty());
        }

        @Override
        public String toString() {
            return "RecordingWatcher{" + name + '}';
        }
    }

    @Test
    public void testAddWatchReturnsTrueOnlyForNewPathWatcherModeCombinationAndContainsByMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher("watcher1");
        RecordingWatcher watcher2 = new RecordingWatcher("watcher2");

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.STANDARD));
        assertFalse("Adding the same watcher/path/mode twice must not create a new watch",
                manager.addWatch("/node1", watcher1, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher1, null));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node1", watcher1, null));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher("/node1", watcher2, null));
        assertFalse(manager.containsWatcher("/node1", watcher2, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/missing", watcher1, null));
        assertFalse(manager.containsWatcher("/missing", watcher1, WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcherBySpecificModeDoesNotRemoveOtherModesOrOtherWatchers() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher("watcher1");
        RecordingWatcher watcher2 = new RecordingWatcher("watcher2");

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/node1", watcher2, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node2", watcher1, WatcherMode.STANDARD));

        assertTrue(manager.removeWatcher("/node1", watcher1, WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/node1", watcher2, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node2", watcher1, WatcherMode.STANDARD));

        assertFalse("Removing an already removed mode must return false",
                manager.removeWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/node1", watcher2, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher("/missing", watcher1, WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcherWithNullModeRemovesAllModesForOnlyThatPath() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher("watcher");

        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/node2", watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.removeWatcher("/node1", watcher, null));

        assertFalse(manager.containsWatcher("/node1", watcher, null));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue("Removing one path must not remove the same watcher from another path",
                manager.containsWatcher("/node2", watcher, WatcherMode.PERSISTENT));

        assertFalse(manager.removeWatcher("/node1", watcher, null));
        assertTrue(manager.removeWatcher("/node2", watcher, null));
        assertFalse(manager.containsWatcher("/node2", watcher, null));
    }

    @Test
    public void testRemoveWatcherMismatchDoesNotBreakExistingWatches() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher("watcher1");
        RecordingWatcher watcher2 = new RecordingWatcher("watcher2");

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node2", watcher2, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.removeWatcher("/node1", watcher2, null));
        assertFalse(manager.removeWatcher("/node1", watcher2, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/node2", watcher1, null));
        assertFalse(manager.removeWatcher("/node2", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.removeWatcher("/missing", watcher1, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node2", watcher2, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggerStandardWatchFiresOnceAndRemovesOnlyStandardMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher standardOnly = new RecordingWatcher("standardOnly");
        RecordingWatcher standardAndPersistent = new RecordingWatcher("standardAndPersistent");

        assertTrue(manager.addWatch("/node", standardOnly, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", standardAndPersistent, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", standardAndPersistent, WatcherMode.PERSISTENT));

        WatcherOrBitSet fired = manager.triggerWatch("/node", EventType.NodeCreated, 10L, NO_ACL, null);

        assertNotNull(fired);
        assertTrue(fired.contains(standardOnly));
        assertTrue(fired.contains(standardAndPersistent));
        assertWatchedEvent(standardOnly.lastEvent(), "/node", EventType.NodeCreated, 10L);
        assertWatchedEvent(standardAndPersistent.lastEvent(), "/node", EventType.NodeCreated, 10L);

        assertFalse(manager.containsWatcher("/node", standardOnly, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", standardOnly, null));

        assertFalse(manager.containsWatcher("/node", standardAndPersistent, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", standardAndPersistent, WatcherMode.PERSISTENT));

        WatcherOrBitSet secondFire = manager.triggerWatch("/node", EventType.NodeDataChanged, 11L, NO_ACL, null);

        assertNotNull(secondFire);
        assertFalse(secondFire.contains(standardOnly));
        assertTrue(secondFire.contains(standardAndPersistent));
        assertEquals("Standard-only watcher must not fire a second time", 1, standardOnly.eventCount());
        assertEquals(2, standardAndPersistent.eventCount());
        assertWatchedEvent(standardAndPersistent.lastEvent(), "/node", EventType.NodeDataChanged, 11L);
        assertTrue(manager.containsWatcher("/node", standardAndPersistent, WatcherMode.PERSISTENT));
    }

    @Test
    public void testTriggerPersistentAndPersistentRecursiveWatchesAreNotRemovedByTrigger() {
        WatchManager manager = new WatchManager();
        RecordingWatcher persistent = new RecordingWatcher("persistent");
        RecordingWatcher recursive = new RecordingWatcher("recursive");

        assertTrue(manager.addWatch("/node", persistent, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", recursive, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet first = manager.triggerWatch("/node", EventType.NodeCreated, 1L, NO_ACL, null);
        WatcherOrBitSet second = manager.triggerWatch("/node", EventType.NodeDeleted, 2L, NO_ACL, null);

        assertNotNull(first);
        assertNotNull(second);
        assertTrue(first.contains(persistent));
        assertTrue(first.contains(recursive));
        assertTrue(second.contains(persistent));
        assertTrue(second.contains(recursive));

        assertEquals(2, persistent.eventCount());
        assertEquals(2, recursive.eventCount());
        assertWatchedEvent(persistent.lastEvent(), "/node", EventType.NodeDeleted, 2L);
        assertWatchedEvent(recursive.lastEvent(), "/node", EventType.NodeDeleted, 2L);

        assertTrue(manager.containsWatcher("/node", persistent, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", recursive, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggerRecursiveParentWatchFiresForDescendantButNonRecursiveParentDoesNot() {
        WatchManager manager = new WatchManager();
        RecordingWatcher parentStandard = new RecordingWatcher("parentStandard");
        RecordingWatcher parentRecursive = new RecordingWatcher("parentRecursive");
        RecordingWatcher childStandard = new RecordingWatcher("childStandard");

        assertTrue(manager.addWatch("/root", parentStandard, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/root", parentRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/root/child", childStandard, WatcherMode.STANDARD));

        WatcherOrBitSet fired = manager.triggerWatch("/root/child", EventType.NodeChildrenChanged, 20L, NO_ACL, null);

        assertNotNull(fired);
        assertFalse("A standard watch on the parent path must not fire for a child path",
                fired.contains(parentStandard));
        assertTrue(fired.contains(parentRecursive));
        assertTrue(fired.contains(childStandard));

        parentStandard.assertNoEvents();
        assertWatchedEvent(parentRecursive.lastEvent(), "/root/child", EventType.NodeChildrenChanged, 20L);
        assertWatchedEvent(childStandard.lastEvent(), "/root/child", EventType.NodeChildrenChanged, 20L);

        assertTrue("Recursive watch must remain after firing for a descendant",
                manager.containsWatcher("/root", parentRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue("Parent standard watch was not triggered, so it must remain",
                manager.containsWatcher("/root", parentStandard, WatcherMode.STANDARD));
        assertFalse("Direct child standard watch must be removed after firing",
                manager.containsWatcher("/root/child", childStandard, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchReturnsNullWhenNoWatchersMatchPathOrParentRecursiveWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher("watcher");

        assertTrue(manager.addWatch("/other", watcher, WatcherMode.STANDARD));

        assertNull(manager.triggerWatch("/missing", EventType.NodeCreated, 30L, NO_ACL, null));
        watcher.assertNoEvents();

        assertTrue(manager.containsWatcher("/other", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchSuppressSkipsProcessingButReturnedSetStillContainsWatcherAndStandardWatchIsConsumed() {
        WatchManager manager = new WatchManager();
        RecordingWatcher suppressed = new RecordingWatcher("suppressed");
        RecordingWatcher delivered = new RecordingWatcher("delivered");

        assertTrue(manager.addWatch("/suppress-source", suppressed, WatcherMode.PERSISTENT));
        WatcherOrBitSet suppress = manager.triggerWatch("/suppress-source", EventType.NodeCreated, 100L, NO_ACL, null);
        assertNotNull(suppress);
        assertTrue(suppress.contains(suppressed));
        assertEquals(1, suppressed.eventCount());

        assertTrue(manager.addWatch("/target", suppressed, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/target", delivered, WatcherMode.STANDARD));

        WatcherOrBitSet fired = manager.triggerWatch("/target", EventType.NodeDataChanged, 101L, NO_ACL, suppress);

        assertNotNull(fired);
        assertTrue(fired.contains(suppressed));
        assertTrue(fired.contains(delivered));

        assertEquals("Suppressed watcher must be in the fired set but must not receive the target event",
                1, suppressed.eventCount());
        assertEquals(1, delivered.eventCount());
        assertWatchedEvent(delivered.lastEvent(), "/target", EventType.NodeDataChanged, 101L);

        assertFalse("Suppressed standard watches are still consumed by triggerWatch",
                manager.containsWatcher("/target", suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/target", delivered, WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerDirectPathWithMultipleWatchersDeliversSameEventToEachWatcherOnce() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher1 = new RecordingWatcher("watcher1");
        RecordingWatcher watcher2 = new RecordingWatcher("watcher2");
        RecordingWatcher watcher3 = new RecordingWatcher("watcher3");

        assertTrue(manager.addWatch("/multi", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/multi", watcher2, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/multi", watcher3, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet fired = manager.triggerWatch("/multi", EventType.NodeDeleted, 77L, NO_ACL, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher1));
        assertTrue(fired.contains(watcher2));
        assertTrue(fired.contains(watcher3));

        assertEquals(1, watcher1.eventCount());
        assertEquals(1, watcher2.eventCount());
        assertEquals(1, watcher3.eventCount());
        assertWatchedEvent(watcher1.lastEvent(), "/multi", EventType.NodeDeleted, 77L);
        assertWatchedEvent(watcher2.lastEvent(), "/multi", EventType.NodeDeleted, 77L);
        assertWatchedEvent(watcher3.lastEvent(), "/multi", EventType.NodeDeleted, 77L);

        assertFalse(manager.containsWatcher("/multi", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/multi", watcher2, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/multi", watcher3, WatcherMode.PERSISTENT_RECURSIVE));
    }

    private static void assertWatchedEvent(WatchedEvent event, String path, EventType type, long zxid) {
        assertEquals(path, event.getPath());
        assertSame(type, event.getType());
        assertSame(KeeperState.SyncConnected, event.getState());
        assertEquals(zxid, event.getZxid());
    }
}


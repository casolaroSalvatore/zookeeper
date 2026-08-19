package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
 * Focused JUnit 4 tests for the mode-aware WatchManager operations.
 */
public class WatchManagerC3LLMFewShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    @Test
    public void addWatchTracksEachModeIndependentlyAndRejectsDuplicates() {
        RecordingWatcher watcher = new RecordingWatcher();
        String path = "/node";

        assertTrue(manager.addWatch(path, watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchKeepsPathsAndWatchersIndependent() {
        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/one", watcher2, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/two", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/one", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/one", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/one", watcher2, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/one", watcher2, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/two", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/two", watcher2, null));
    }

    @Test
    public void containsWatcherSupportsAnyModeAndDetectsMismatches() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/node", registered, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/node", registered, null));
        assertTrue(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/other", registered, null));
        assertFalse(manager.containsWatcher("/node", other, null));
    }

    @Test
    public void removeWatcherRemovesOnlyRequestedModeUntilLastMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        String path = "/node";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(path, watcher, null));
        assertFalse(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForOnlyThatPair() {
        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher unaffected = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/other", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/node", unaffected, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/node", watcher, null));

        assertFalse(manager.containsWatcher("/node", watcher, null));
        assertTrue(manager.containsWatcher("/other", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", unaffected, WatcherMode.STANDARD));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void removeWatcherMismatchChangesNothing() {
        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertFalse(manager.removeWatcher("/missing", watcher, null));
        assertFalse(manager.removeWatcher("/node", other, null));
        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void triggerWatchReturnsNullAndNotifiesNobodyWhenNoWatchMatches() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/other", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/missing", EventType.NodeCreated, 7L, null, null);

        assertNull(result);
        assertEquals(0, watcher.events.size());
        assertTrue(manager.containsWatcher("/other", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchConsumesStandardButPreservesPersistentModes() {
        RecordingWatcher standard = new RecordingWatcher();
        RecordingWatcher persistent = new RecordingWatcher();
        RecordingWatcher both = new RecordingWatcher();
        String path = "/node";
        manager.addWatch(path, standard, WatcherMode.STANDARD);
        manager.addWatch(path, persistent, WatcherMode.PERSISTENT);
        manager.addWatch(path, both, WatcherMode.STANDARD);
        manager.addWatch(path, both, WatcherMode.PERSISTENT);

        WatcherOrBitSet first = manager.triggerWatch(
                path, EventType.NodeDataChanged, 41L, null, null);

        assertNotNull(first);
        assertTrue(first.contains(standard));
        assertTrue(first.contains(persistent));
        assertTrue(first.contains(both));
        assertEvent(standard, 0, path, EventType.NodeDataChanged, 41L);
        assertEvent(persistent, 0, path, EventType.NodeDataChanged, 41L);
        assertEvent(both, 0, path, EventType.NodeDataChanged, 41L);
        assertFalse(manager.containsWatcher(path, standard, null));
        assertTrue(manager.containsWatcher(path, persistent, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(path, both, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, both, WatcherMode.PERSISTENT));

        WatcherOrBitSet second = manager.triggerWatch(
                path, EventType.NodeDeleted, 42L, null, null);
        assertNotNull(second);
        assertFalse(second.contains(standard));
        assertTrue(second.contains(persistent));
        assertTrue(second.contains(both));
        assertEquals(1, standard.events.size());
        assertEquals(2, persistent.events.size());
        assertEquals(2, both.events.size());
    }

    @Test
    public void triggerWatchIncludesRecursiveAncestorAndDirectWatcherOnlyOnce() {
        RecordingWatcher recursive = new RecordingWatcher();
        manager.addWatch("/a", recursive, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a/b", recursive, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b", EventType.NodeCreated, 99L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(recursive));
        assertEquals(1, recursive.events.size());
        assertEvent(recursive, 0, "/a/b", EventType.NodeCreated, 99L);
        assertTrue(manager.containsWatcher("/a", recursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/a/b", recursive, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchSuppressesNotificationButStillReturnsAndConsumesWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher notified = new RecordingWatcher();
        String path = "/node";
        manager.addWatch(path, suppressed, WatcherMode.STANDARD);
        manager.addWatch(path, notified, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                new HashSet<Watcher>(Collections.<Watcher>singleton(suppressed)));

        WatcherOrBitSet result = manager.triggerWatch(
                path, EventType.NodeChildrenChanged, 123L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(notified));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, notified.events.size());
        assertFalse(manager.containsWatcher(path, suppressed, null));
        assertFalse(manager.containsWatcher(path, notified, null));
    }

    @Test
    public void triggerWatchPassesAclOnlyToServerWatcher() {
        RecordingServerWatcher watcher = new RecordingServerWatcher();
        List<ACL> acl = Arrays.asList(new ACL(31, new Id("world", "anyone")));
        manager.addWatch("/secure", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/secure", EventType.NodeDataChanged, 77L, acl, null);

        assertEquals(1, watcher.getEvents().size());
        assertSame(acl, watcher.lastAcl);
        assertEvent(watcher, 0, "/secure", EventType.NodeDataChanged, 77L);
    }

    private static void assertEvent(
            RecordingWatcher watcher,
            int index,
            String path,
            EventType type,
            long zxid) {
        WatchedEvent event = watcher.events.get(index);
        assertEquals(path, event.getPath());
        assertEquals(type, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(zxid, event.getZxid());
    }

    /* Modified to solve the compilation error
    private static class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new java.util.ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
     */

    private static class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events =
                new java.util.ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        List<WatchedEvent> getEvents() {
            return events;
        }
    }

    private static final class RecordingServerWatcher
            extends RecordingWatcher implements ServerWatcher {
        private List<ACL> lastAcl;

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            lastAcl = acl;
            super.process(event);
        }
    }
}

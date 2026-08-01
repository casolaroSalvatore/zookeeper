package org.apache.zookeeper.server.watch.watchmanager.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.junit.Before;
import org.junit.Test;

/**
 * Focused JUnit 4 tests for the mode-aware add, trigger, contains, and remove
 * operations of {@link WatchManager}.
 */
public class WatchManagerLLMFewShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    @Test
    public void addWatchRegistersEveryModeAndRejectsDuplicateMode() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void addWatchKeepsWatchersAndPathsIndependent() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", first, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/one", second, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/two", first, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/one", first, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/one", second, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/two", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/two", second, null));
    }

    @Test
    public void containsWatcherSupportsAnyModeAndRejectsMismatches() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", registered, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher("/node", registered, null));
        assertTrue(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/other", registered, null));
        assertFalse(manager.containsWatcher("/node", other, null));
    }

    @Test
    public void removeWatcherByModeLeavesOtherModesIntact() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/node", watcher, null));
        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForOnlyThatPair() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", first, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/node", second, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/other", first, WatcherMode.PERSISTENT));

        assertTrue(manager.removeWatcher("/node", first, null));

        assertFalse(manager.containsWatcher("/node", first, null));
        assertTrue(manager.containsWatcher("/node", second, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/other", first, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherRejectsMissingPathWatcherAndModeWithoutMutation() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", registered, WatcherMode.PERSISTENT));

        assertFalse(manager.removeWatcher("/missing", registered, null));
        assertFalse(manager.removeWatcher("/node", other, null));
        assertFalse(manager.removeWatcher("/node", registered, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchReturnsNullWhenNothingMatches() {
        assertNull(manager.triggerWatch(
                "/unwatched", EventType.NodeCreated, 11L,
                Collections.<ACL>emptyList(), null));
    }

    @Test
    public void triggerWatchDeliversEventAndConsumesOnlyStandardMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));

        WatcherOrBitSet fired = manager.triggerWatch(
                "/node", EventType.NodeCreated, 12L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), "/node", EventType.NodeCreated, 12L);
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));

        assertNull(manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 13L,
                Collections.<ACL>emptyList(), null));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchKeepsPersistentModesAndDeduplicatesDelivery() {
        RecordingWatcher watcher = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet first = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 21L,
                Collections.<ACL>emptyList(), null);
        WatcherOrBitSet second = manager.triggerWatch(
                "/node", EventType.NodeDeleted, 22L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(2, watcher.events.size());
        assertEvent(watcher.events.get(0), "/node", EventType.NodeDataChanged, 21L);
        assertEvent(watcher.events.get(1), "/node", EventType.NodeDeleted, 22L);
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchFiresRecursiveAncestorsButNotPersistentAncestors() {
        RecordingWatcher rootRecursive = new RecordingWatcher();
        RecordingWatcher parentRecursive = new RecordingWatcher();
        RecordingWatcher parentPersistent = new RecordingWatcher();
        RecordingWatcher direct = new RecordingWatcher();

        assertTrue(manager.addWatch("/", rootRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/a", parentRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.addWatch("/a", parentPersistent, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/a/b", direct, WatcherMode.STANDARD));

        WatcherOrBitSet fired = manager.triggerWatch(
                "/a/b", EventType.NodeChildrenChanged, 31L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(fired);
        assertTrue(fired.contains(rootRecursive));
        assertTrue(fired.contains(parentRecursive));
        assertTrue(fired.contains(direct));
        assertFalse(fired.contains(parentPersistent));
        assertEquals(1, rootRecursive.events.size());
        assertEquals(1, parentRecursive.events.size());
        assertEquals(0, parentPersistent.events.size());
        assertEquals(1, direct.events.size());
        assertTrue(manager.containsWatcher("/", rootRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/a", parentRecursive, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/a/b", direct, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchSuppressesNotificationButStillReturnsAndConsumesWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();
        assertTrue(manager.addWatch("/node", suppressed, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", delivered, WatcherMode.STANDARD));
        WatcherOrBitSet suppress = new WatcherOrBitSet(Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet fired = manager.triggerWatch(
                "/node", EventType.NodeCreated, 41L,
                Collections.<ACL>emptyList(), suppress);

        assertNotNull(fired);
        assertTrue(fired.contains(suppressed));
        assertTrue(fired.contains(delivered));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, delivered.events.size());
        assertFalse(manager.containsWatcher("/node", suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", delivered, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchPassesAclOnlyToServerWatcher() {
        RecordingServerWatcher serverWatcher = new RecordingServerWatcher();
        RecordingWatcher ordinaryWatcher = new RecordingWatcher();
        List<ACL> acl = Arrays.asList(new ACL(), new ACL());
        assertTrue(manager.addWatch("/node", serverWatcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", ordinaryWatcher, WatcherMode.PERSISTENT));

        manager.triggerWatch("/node", EventType.NodeDeleted, 51L, acl, null);

        assertEquals(1, serverWatcher.events.size());
        assertSame(acl, serverWatcher.lastAcl);
        assertEquals(1, ordinaryWatcher.events.size());
        assertEvent(serverWatcher.events.get(0), "/node", EventType.NodeDeleted, 51L);
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
}

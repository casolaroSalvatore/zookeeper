package org.apache.zookeeper.server.watch.watchmanager.variant_c1.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit 4 tests for the mode-aware add, trigger, contains, and remove operations
 * of {@link WatchManager}.
 */
public class WatchManagerLLMZeroShotTest {

    private WatchManager manager;
    private RecordingWatcher watcher;

    @Before
    public void setUp() {
        manager = new WatchManager();
        watcher = new RecordingWatcher();
    }

    // addWatch(String, Watcher, WatcherMode)

    @Test
    public void addWatchAddsEachSupportedModeAndContainsReportsIt() {
        for (WatcherMode mode : new WatcherMode[] {
                WatcherMode.STANDARD,
                WatcherMode.PERSISTENT,
                WatcherMode.PERSISTENT_RECURSIVE}) {
            String path = "/add/" + mode.name();

            assertTrue(manager.addWatch(path, watcher, mode));
            assertTrue(manager.containsWatcher(path, watcher, mode));
            assertTrue(manager.containsWatcher(path, watcher, null));
        }
    }

    @Test
    public void addWatchReturnsFalseForDuplicateMode() {
        assertTrue(manager.addWatch("/duplicate", watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/duplicate", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/duplicate", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void addWatchAllowsDifferentModesForSameWatcherAndPath() {
        String path = "/mixed";

        assertTrue(manager.addWatch(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void addWatchKeepsDifferentWatchersAndPathsIndependent() {
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/one", second, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/two", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/one", second, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/two", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/two", second, null));
    }

    // containsWatcher(String, Watcher, WatcherMode)

    @Test
    public void containsWatcherReturnsFalseForUnknownWatcherPathAndMode() {
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch("/known", watcher, WatcherMode.PERSISTENT);

        assertFalse(manager.containsWatcher("/known", unknown, null));
        assertFalse(manager.containsWatcher("/unknown", watcher, null));
        assertFalse(manager.containsWatcher("/known", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/known", watcher, WatcherMode.PERSISTENT));
    }

    // triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)

    @Test
    public void triggerWatchReturnsNullWhenNoWatcherMatches() {
        assertNull(manager.triggerWatch(
                "/missing", EventType.NodeDataChanged, 11L,
                Collections.<ACL>emptyList(), null));
    }

    @Test
    public void triggerWatchDeliversCompleteEventAndReturnsTriggeredWatcher() {
        String path = "/node";
        long zxid = 987654321L;
        List<ACL> acl = Collections.emptyList();
        manager.addWatch(path, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                path, EventType.NodeDataChanged, zxid, acl, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        WatchedEvent event = watcher.events.get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(path, event.getPath());
        assertEquals(zxid, event.getZxid());
    }

    @Test
    public void triggerWatchConsumesStandardWatchButRetainsPersistentWatch() {
        String path = "/lifetime";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet first = manager.triggerWatch(
                path, EventType.NodeDataChanged, 1L,
                Collections.<ACL>emptyList(), null);
        WatcherOrBitSet second = manager.triggerWatch(
                path, EventType.NodeDataChanged, 2L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(first);
        assertNotNull(second);
        assertEquals(2, watcher.events.size());
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchConsumesSoleStandardWatch() {
        String path = "/one-shot";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);

        assertNotNull(manager.triggerWatch(
                path, EventType.NodeDeleted, 1L,
                Collections.<ACL>emptyList(), null));
        assertFalse(manager.containsWatcher(path, watcher, null));
        assertNull(manager.triggerWatch(
                path, EventType.NodeDeleted, 2L,
                Collections.<ACL>emptyList(), null));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchIncludesRecursiveWatchersOnAncestors() {
        RecordingWatcher direct = new RecordingWatcher();
        RecordingWatcher recursiveParent = new RecordingWatcher();
        RecordingWatcher nonRecursiveParent = new RecordingWatcher();
        manager.addWatch("/a/b/c", direct, WatcherMode.STANDARD);
        manager.addWatch("/a", recursiveParent, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a", nonRecursiveParent, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b/c", EventType.NodeCreated, 77L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(direct));
        assertTrue(result.contains(recursiveParent));
        assertFalse(result.contains(nonRecursiveParent));
        assertEquals(1, direct.events.size());
        assertEquals(1, recursiveParent.events.size());
        assertEquals("/a/b/c", recursiveParent.events.get(0).getPath());
        assertEquals(0, nonRecursiveParent.events.size());
        assertTrue(manager.containsWatcher(
                "/a", recursiveParent, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchDeduplicatesWatcherRegisteredDirectlyAndRecursively() {
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/root/child", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/root/child", EventType.NodeDataChanged, 5L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchSuppressesDeliveryButStillReturnsAndConsumesWatcher() {
        String path = "/suppressed";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        Set<Watcher> suppressed = new HashSet<>();
        suppressed.add(watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressed);

        WatcherOrBitSet result = manager.triggerWatch(
                path, EventType.NodeChildrenChanged, 9L,
                Collections.<ACL>emptyList(), suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertTrue(watcher.events.isEmpty());
        assertFalse(manager.containsWatcher(path, watcher, null));
    }

    @Test
    public void triggerWatchSuppressesOnlySelectedWatcher() {
        RecordingWatcher delivered = new RecordingWatcher();
        String path = "/partial-suppression";
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, delivered, WatcherMode.PERSISTENT);
        Set<Watcher> suppressed = new HashSet<>();
        suppressed.add(watcher);

        WatcherOrBitSet result = manager.triggerWatch(
                path, EventType.NodeDataChanged, 10L,
                Collections.<ACL>emptyList(), new WatcherOrBitSet(suppressed));

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertTrue(result.contains(delivered));
        assertEquals(0, watcher.events.size());
        assertEquals(1, delivered.events.size());
    }

    // removeWatcher(String, Watcher, WatcherMode)

    @Test
    public void removeWatcherReturnsFalseWhenWatcherPathOrModeIsAbsent() {
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch("/known", watcher, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/known", unknown, null));
        assertFalse(manager.removeWatcher("/unknown", watcher, null));
        assertFalse(manager.removeWatcher("/known", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/known", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherByModePreservesOtherModesOnSamePath() {
        String path = "/selective";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void removeWatcherByModeRemovesFinalModeAndEntireRegistration() {
        String path = "/final-mode";
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(path, watcher, null));
        assertFalse(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesOnlyAtRequestedPath() {
        manager.addWatch("/target", watcher, WatcherMode.STANDARD);
        manager.addWatch("/target", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/target", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/other", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/target", watcher, null));

        assertFalse(manager.containsWatcher("/target", watcher, null));
        assertTrue(manager.containsWatcher("/other", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherDoesNotAffectOtherWatchersOnSamePath() {
        RecordingWatcher second = new RecordingWatcher();
        String path = "/shared";
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, second, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher(path, watcher, null));

        assertFalse(manager.containsWatcher(path, watcher, null));
        assertTrue(manager.containsWatcher(path, second, WatcherMode.PERSISTENT));
        manager.triggerWatch(
                path, EventType.NodeDataChanged, 100L,
                Collections.<ACL>emptyList(), null);
        assertEquals(0, watcher.events.size());
        assertEquals(1, second.events.size());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}
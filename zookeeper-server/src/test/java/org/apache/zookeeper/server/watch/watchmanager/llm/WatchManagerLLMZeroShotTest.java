package org.apache.zookeeper.server.watch.watchmanager.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
 * Focused JUnit 4 tests for WatchManager's mode-aware add, trigger,
 * contains, and remove operations.
 */
public class WatchManagerLLMZeroShotTest {

    private WatchManager manager;
    private RecordingWatcher watcher;
    private final List<ACL> acl = Collections.emptyList();

    @Before
    public void setUp() {
        manager = new WatchManager();
        watcher = new RecordingWatcher();
    }

    // ---------------------------------------------------------------------
    // addWatch(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void addWatchAddsEachSupportedModeAndReportsDuplicates() {
        String path = "/node";

        assertTrue(manager.addWatch(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.STANDARD));

        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals("One watcher/path pair is stored in the path index", 1, manager.size());
        assertEquals("Only one recursive mode was newly added", 1, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchKeepsWatchersAndPathsIndependent() {
        RecordingWatcher secondWatcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/two", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/one", secondWatcher, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/two", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/one", secondWatcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/two", secondWatcher, null));
        assertEquals(3, manager.size());
    }

    // ---------------------------------------------------------------------
    // containsWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void containsWatcherSupportsAnyModeQueryAndRejectsMissingEntries() {
        manager.addWatch("/mixed", watcher, WatcherMode.STANDARD);
        manager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT);
        RecordingWatcher unknownWatcher = new RecordingWatcher();

        assertTrue(manager.containsWatcher("/mixed", watcher, null));
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/missing", watcher, null));
        assertFalse(manager.containsWatcher("/mixed", unknownWatcher, null));
    }

    // ---------------------------------------------------------------------
    // removeWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    @Test
    public void removeWatcherRemovesOnlyRequestedModeWhenOtherModesRemain() {
        String path = "/mixed";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertEquals(1, manager.size());
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForPath() {
        String path = "/all";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(path, watcher, null));

        assertFalse(manager.containsWatcher(path, watcher, null));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.getWatch2Paths().containsKey(watcher));
    }

    @Test
    public void removeWatcherRemovesLastSpecificModeAndCleansIndexes() {
        String path = "/single";
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher(path, watcher, null));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.getWatch2Paths().containsKey(watcher));
    }

    @Test
    public void removeWatcherReturnsFalseForMissingWatcherPathOrMode() {
        RecordingWatcher unknownWatcher = new RecordingWatcher();
        manager.addWatch("/known", watcher, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/known", unknownWatcher, null));
        assertFalse(manager.removeWatcher("/missing", watcher, null));
        assertFalse(manager.removeWatcher("/known", watcher, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/known", watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    // ---------------------------------------------------------------------
    // triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
    // ---------------------------------------------------------------------

    @Test
    public void triggerWatchReturnsNullWhenNoWatchMatches() {
        assertNull(manager.triggerWatch("/missing", EventType.NodeDataChanged, 7L, acl, null));
        assertEquals(0, watcher.events.size());
    }

    @Test
    public void triggerWatchDeliversCompleteEventAndConsumesStandardWatch() {
        String path = "/standard";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet triggered = manager.triggerWatch(
                path, EventType.NodeDataChanged, 123L, acl, null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.events.size());
        WatchedEvent event = watcher.events.get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(path, event.getPath());
        assertEquals(123L, event.getZxid());
        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertEquals(0, manager.size());

        assertNull(manager.triggerWatch(path, EventType.NodeDataChanged, 124L, acl, null));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchKeepsPersistentWatchAcrossRepeatedTriggers() {
        String path = "/persistent";
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet first = manager.triggerWatch(
                path, EventType.NodeCreated, 1L, acl, null);
        WatcherOrBitSet second = manager.triggerWatch(
                path, EventType.NodeDeleted, 2L, acl, null);

        assertNotNull(first);
        assertNotNull(second);
        assertTrue(first.contains(watcher));
        assertTrue(second.contains(watcher));
        assertEquals(2, watcher.events.size());
        assertEquals(EventType.NodeCreated, watcher.events.get(0).getType());
        assertEquals(EventType.NodeDeleted, watcher.events.get(1).getType());
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    @Test
    public void triggerWatchFiresRecursiveWatchFromAncestorAndRetainsIt() {
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet triggered = manager.triggerWatch(
                "/root/child/grandchild",
                EventType.NodeChildrenChanged,
                55L,
                acl,
                null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEquals("/root/child/grandchild", watcher.events.get(0).getPath());
        assertTrue(manager.containsWatcher("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void triggerWatchDoesNotFireNonRecursiveAncestorWatch() {
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT);

        assertNull(manager.triggerWatch(
                "/root/child", EventType.NodeDataChanged, 9L, acl, null));

        assertEquals(0, watcher.events.size());
        assertTrue(manager.containsWatcher("/root", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchSuppressesNotificationButStillReturnsAndConsumesWatcher() {
        String path = "/suppressed";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        Set<Watcher> suppressedWatchers = new HashSet<>();
        suppressedWatchers.add(watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressedWatchers);

        WatcherOrBitSet triggered = manager.triggerWatch(
                path, EventType.NodeDeleted, 77L, acl, suppress);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals("Suppression prevents callback delivery", 0, watcher.events.size());
        assertFalse("A standard watch is consumed even when suppressed",
                manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchNotifiesUnsuppressedWatcherOnly() {
        String path = "/two-watchers";
        RecordingWatcher suppressedWatcher = new RecordingWatcher();
        RecordingWatcher deliveredWatcher = new RecordingWatcher();
        manager.addWatch(path, suppressedWatcher, WatcherMode.PERSISTENT);
        manager.addWatch(path, deliveredWatcher, WatcherMode.PERSISTENT);
        Set<Watcher> suppressedWatchers = new HashSet<>();
        suppressedWatchers.add(suppressedWatcher);

        WatcherOrBitSet triggered = manager.triggerWatch(
                path,
                EventType.NodeDataChanged,
                88L,
                acl,
                new WatcherOrBitSet(suppressedWatchers));

        assertNotNull(triggered);
        assertTrue(triggered.contains(suppressedWatcher));
        assertTrue(triggered.contains(deliveredWatcher));
        assertEquals(0, suppressedWatcher.events.size());
        assertEquals(1, deliveredWatcher.events.size());
    }

    @Test
    public void triggerWatchDeduplicatesWatcherRegisteredDirectlyAndRecursively() {
        String path = "/root/child";
        manager.addWatch("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet triggered = manager.triggerWatch(
                path, EventType.NodeDataChanged, 99L, acl, null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals("A watcher must receive one callback per trigger", 1, watcher.events.size());
        assertTrue(manager.containsWatcher("/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchConsumesOnlyStandardModeWhenModesAreCombined() {
        String path = "/combined";
        manager.addWatch(path, watcher, WatcherMode.STANDARD);
        manager.addWatch(path, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(path, EventType.NodeDataChanged, 100L, acl, null);

        assertFalse(manager.containsWatcher(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(path, watcher, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());

        manager.triggerWatch(path, EventType.NodeDataChanged, 101L, acl, null);
        assertEquals(2, watcher.events.size());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}

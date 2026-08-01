package org.apache.zookeeper.server.watch.watchmanager.llm;

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
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Test;

/**
 * Focused JUnit 4 tests for WatchManager's mode-aware add, trigger, contains,
 * and remove operations.
 */
public class WatchManagerLLMZeroShotTest {

    private WatchManager manager;
    private RecordingWatcher watcher;

    @Before
    public void setUp() {
        manager = new WatchManager();
        watcher = new RecordingWatcher();
    }

    @Test
    public void addWatchAddsEachSupportedModeAndContainsWatcherFindsIt() {
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/node", watcher, null));
    }

    @Test
    public void addWatchReturnsFalseForDuplicateModeWithoutDamagingRegistration() {
        assertTrue(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));

        assertFalse(manager.addWatch("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void addWatchTreatsSameWatcherOnDifferentPathsAsDistinctRegistrations() {
        assertTrue(manager.addWatch("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/two", watcher, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/one", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/two", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/three", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void containsWatcherReturnsFalseForUnknownWatcherPathAndMode() {
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);

        assertFalse(manager.containsWatcher("/node", other, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/missing", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchReturnsNullAndDoesNotNotifyWhenNoWatchMatches() {
        assertNull(manager.triggerWatch(
                "/missing", EventType.NodeCreated, 10L,
                Collections.<ACL>emptyList(), null));
        assertEquals(0, watcher.events.size());
    }

    @Test
    public void triggerWatchNotifiesStandardWatcherWithCompleteEventAndConsumesIt() {
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet triggered = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 1234L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.events.size());
        WatchedEvent event = watcher.events.get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals("/node", event.getPath());
        assertEquals(1234L, event.getZxid());
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));

        assertNull(manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 1235L,
                Collections.<ACL>emptyList(), null));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchKeepsPersistentWatcherAcrossMultipleEvents() {
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet first = manager.triggerWatch(
                "/node", EventType.NodeCreated, 1L,
                Collections.<ACL>emptyList(), null);
        WatcherOrBitSet second = manager.triggerWatch(
                "/node", EventType.NodeChildrenChanged, 2L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(first);
        assertNotNull(second);
        assertTrue(first.contains(watcher));
        assertTrue(second.contains(watcher));
        assertEquals(2, watcher.events.size());
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchRemovesOnlyStandardModeFromMixedRegistration() {
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(
                "/node", EventType.NodeDeleted, 20L,
                Collections.<ACL>emptyList(), null);

        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));

        manager.triggerWatch(
                "/node", EventType.NodeCreated, 21L,
                Collections.<ACL>emptyList(), null);
        assertEquals(2, watcher.events.size());
    }

    @Test
    public void triggerWatchNotifiesRecursiveWatcherRegisteredOnAncestor() {
        manager.addWatch("/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet triggered = manager.triggerWatch(
                "/parent/child/grandchild", EventType.NodeCreated, 30L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEquals("/parent/child/grandchild", watcher.events.get(0).getPath());
        assertTrue(manager.containsWatcher(
                "/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchDoesNotNotifyNonRecursiveWatcherOnAncestor() {
        manager.addWatch("/parent", watcher, WatcherMode.PERSISTENT);

        assertNull(manager.triggerWatch(
                "/parent/child", EventType.NodeCreated, 40L,
                Collections.<ACL>emptyList(), null));
        assertEquals(0, watcher.events.size());
        assertTrue(manager.containsWatcher("/parent", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchDeduplicatesWatcherRegisteredDirectlyAndRecursively() {
        manager.addWatch("/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/parent/child", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet triggered = manager.triggerWatch(
                "/parent/child", EventType.NodeDataChanged, 50L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.events.size());
    }

    @Test
    public void triggerWatchSuppressesNotificationButReturnsAndConsumesMatchedWatcher() {
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        Set<Watcher> suppressedWatchers = new HashSet<Watcher>();
        suppressedWatchers.add(watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressedWatchers);

        WatcherOrBitSet triggered = manager.triggerWatch(
                "/node", EventType.NodeDeleted, 60L,
                Collections.<ACL>emptyList(), suppress);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(0, watcher.events.size());
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchUsesServerWatcherOverloadAndPassesAclListByIdentity() {
        RecordingServerWatcher serverWatcher = new RecordingServerWatcher();
        List<ACL> acl = new ArrayList<ACL>();
        manager.addWatch("/secure", serverWatcher, WatcherMode.STANDARD);

        manager.triggerWatch(
                "/secure", EventType.NodeCreated, 70L, acl, null);

        assertEquals(1, serverWatcher.serverEvents.size());
        assertEquals(0, serverWatcher.regularEvents.size());
        assertSame(acl, serverWatcher.aclLists.get(0));
        assertEquals(70L, serverWatcher.serverEvents.get(0).getZxid());
    }

    @Test
    public void removeWatcherRemovesOnlyRequestedModeFromMixedRegistration() {
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForPathOnly() {
        manager.addWatch("/one", watcher, WatcherMode.STANDARD);
        manager.addWatch("/one", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/two", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/one", watcher, null));

        assertFalse(manager.containsWatcher("/one", watcher, null));
        assertTrue(manager.containsWatcher("/two", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherReturnsFalseWhenPathWatcherOrModeIsAbsent() {
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);

        assertFalse(manager.removeWatcher("/missing", watcher, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/node", other, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/node", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void removeLastModeMakesSubsequentTriggerReturnNull() {
        manager.addWatch("/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertNull(manager.triggerWatch(
                "/node/child", EventType.NodeCreated, 80L,
                Collections.<ACL>emptyList(), null));
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<WatchedEvent>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }

    private static final class RecordingServerWatcher implements ServerWatcher {
        private final List<WatchedEvent> regularEvents = new ArrayList<WatchedEvent>();
        private final List<WatchedEvent> serverEvents = new ArrayList<WatchedEvent>();
        private final List<List<ACL>> aclLists = new ArrayList<List<ACL>>();

        @Override
        public void process(WatchedEvent event) {
            regularEvents.add(event);
        }

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            serverEvents.add(event);
            aclLists.add(acl);
        }
    }
}

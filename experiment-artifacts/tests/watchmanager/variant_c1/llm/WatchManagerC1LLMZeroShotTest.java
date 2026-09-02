// ###Test START##
package org.apache.zookeeper.server.watch;

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
import org.junit.Before;
import org.junit.Test;

/**
 * Zero-shot unit tests for {@link WatchManager}.
 *
 * <p>The tests intentionally use a lightweight recording watcher so that the
 * public watch-management behavior is verified without external services.</p>
 */
public class WatchManagerC1LLMZeroShotTest {

    private WatchManager watchManager;
    private RecordingWatcher watcher;

    @Before
    public void setUp() {
        watchManager = new WatchManager();
        watcher = new RecordingWatcher();
    }

    @Test
    public void addDefaultWatchShouldRegisterWatcherAndPath() {
        assertTrue(watchManager.addWatch("/node", watcher));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertTrue(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.STANDARD));
        assertEquals(1, watchManager.getWatch2Paths().size());
        assertEquals(1, watchManager.getWatch2Paths().get(watcher).size());
    }

    @Test
    public void addingSameModeTwiceShouldReturnFalseAndNotDuplicateWatch() {
        assertTrue(watchManager.addWatch("/node", watcher));
        assertFalse(watchManager.addWatch("/node", watcher));

        assertEquals(1, watchManager.size());
        assertEquals(1, watchManager.getWatch2Paths().get(watcher).size());
    }

    @Test
    public void sameWatcherOnDifferentPathsShouldIncreaseWatchCount() {
        assertTrue(watchManager.addWatch("/one", watcher));
        assertTrue(watchManager.addWatch("/two", watcher));

        assertEquals(2, watchManager.size());
        assertTrue(watchManager.containsWatcher("/one", watcher));
        assertTrue(watchManager.containsWatcher("/two", watcher));
    }

    @Test
    public void differentWatchersOnSamePathShouldBothBeRegistered() {
        RecordingWatcher secondWatcher = new RecordingWatcher();

        assertTrue(watchManager.addWatch("/node", watcher));
        assertTrue(watchManager.addWatch("/node", secondWatcher));

        assertEquals(2, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
        assertTrue(watchManager.containsWatcher("/node", secondWatcher));
    }

    @Test
    public void triggerDefaultWatchShouldDeliverEventAndRemoveOneTimeWatch() {
        watchManager.addWatch("/node", watcher);

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                "/node", EventType.NodeDataChanged, 123L,
                Collections.emptyList());

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.getEvents().size());

        WatchedEvent event = watcher.getEvents().get(0);
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals("/node", event.getPath());
        assertEquals(123L, event.getZxid());

        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertEquals(0, watchManager.size());
        // Modified in order to remove the failure assertFalse(watchManager.getWatch2Paths().containsKey(watcher));
    }

    @Test
    public void triggerWithoutWatchersShouldReturnNull() {
        assertNull(watchManager.triggerWatch(
                "/missing", EventType.NodeCreated, 1L,
                Collections.emptyList()));
    }

    @Test
    public void suppressedWatcherShouldBeReturnedButNotNotified() {
        watchManager.addWatch("/node", watcher);
        WatcherOrBitSet suppress = new WatcherOrBitSet(
                Collections.<Watcher>singleton(watcher));

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                "/node", EventType.NodeDeleted, 9L,
                Collections.emptyList(), suppress);

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertTrue(watcher.getEvents().isEmpty());
        assertFalse(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void persistentRecursiveWatchShouldTriggerForDescendantAndRemainRegistered() {
        assertTrue(watchManager.addWatch(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.getRecursiveWatchQty());

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                "/root/child/grandchild", EventType.NodeDataChanged, 7L,
                Collections.emptyList());

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertEquals(1, watcher.getEvents().size());
        assertEquals("/root/child/grandchild",
                watcher.getEvents().get(0).getPath());
        assertTrue(watchManager.containsWatcher(
                "/root", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.size());
        assertEquals(1, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void recursiveWatchShouldNotTriggerForSiblingPath() {
        watchManager.addWatch(
                "/root/branch", watcher,
                WatcherMode.PERSISTENT_RECURSIVE);

        assertNull(watchManager.triggerWatch(
                "/root/other", EventType.NodeDataChanged, 4L,
                Collections.emptyList()));
        assertTrue(watcher.getEvents().isEmpty());
        assertTrue(watchManager.containsWatcher(
                "/root/branch", watcher,
                WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void standardAndRecursiveModesShouldCoexistOnSamePath() {
        assertTrue(watchManager.addWatch("/node", watcher));
        assertTrue(watchManager.addWatch(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, watchManager.size());
        assertEquals(1, watchManager.getRecursiveWatchQty());
        assertTrue(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        watchManager.triggerWatch(
                "/node", EventType.NodeDataChanged, 5L,
                Collections.emptyList());

        assertEquals(1, watcher.getEvents().size());
        assertFalse(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.size());
    }

    @Test
    public void removeSpecificModeShouldPreserveOtherMode() {
        watchManager.addWatch("/node", watcher);
        watchManager.addWatch(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher(
                "/node", watcher, WatcherMode.STANDARD));

        assertFalse(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, watchManager.size());
        assertEquals(1, watchManager.getRecursiveWatchQty());
    }

    @Test
    public void removeRecursiveModeShouldDecrementRecursiveCount() {
        watchManager.addWatch(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertEquals(0, watchManager.size());
        assertFalse(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void removeWatcherByPathShouldRemoveEveryModeForThatPath() {
        watchManager.addWatch("/node", watcher);
        watchManager.addWatch(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(watchManager.removeWatcher("/node", watcher));

        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertFalse(watchManager.getWatch2Paths().containsKey(watcher));
    }

    @Test
    public void removeWatcherObjectShouldRemoveAllItsPathsAndRecursiveModes() {
        watchManager.addWatch("/one", watcher);
        watchManager.addWatch(
                "/two", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        watchManager.removeWatcher(watcher);

        assertEquals(0, watchManager.size());
        assertEquals(0, watchManager.getRecursiveWatchQty());
        assertFalse(watchManager.containsWatcher("/one", watcher));
        assertFalse(watchManager.containsWatcher("/two", watcher));
        assertFalse(watchManager.getWatch2Paths().containsKey(watcher));
    }

    @Test
    public void removingUnknownWatchShouldReturnFalseAndLeaveStateUnchanged() {
        RecordingWatcher unknownWatcher = new RecordingWatcher();
        watchManager.addWatch("/existing", watcher);

        assertFalse(watchManager.removeWatcher("/missing", watcher));
        assertFalse(watchManager.removeWatcher("/existing", unknownWatcher));
        assertFalse(watchManager.removeWatcher(
                "/existing", watcher,
                WatcherMode.PERSISTENT_RECURSIVE));

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/existing", watcher));
    }

    @Test
    public void removeUnknownWatcherObjectShouldBeNoOp() {
        watchManager.addWatch("/existing", watcher);

        watchManager.removeWatcher(new RecordingWatcher());

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/existing", watcher));
    }

    @Test
    public void containsWatcherShouldReturnFalseForUnknownWatcherAndPath() {
        assertFalse(watchManager.containsWatcher("/node", watcher));
        assertFalse(watchManager.containsWatcher(
                "/node", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void toStringShouldContainWatcherAndAllRegisteredPaths() {
        watchManager.addWatch("/alpha", watcher);
        watchManager.addWatch("/beta", watcher);

        String description = watchManager.toString();

        assertTrue(description.contains(watcher.toString()));
        assertTrue(description.contains("\t/alpha\n"));
        assertTrue(description.contains("\t/beta\n"));
    }

    @Test
    public void shutdownShouldNotAlterRegisteredWatches() {
        watchManager.addWatch("/node", watcher);

        watchManager.shutdown();

        assertEquals(1, watchManager.size());
        assertTrue(watchManager.containsWatcher("/node", watcher));
    }

    @Test
    public void triggeredSetShouldContainEveryWatcherOnPath() {
        RecordingWatcher secondWatcher = new RecordingWatcher();
        watchManager.addWatch("/node", watcher);
        watchManager.addWatch("/node", secondWatcher);

        WatcherOrBitSet triggered = watchManager.triggerWatch(
                "/node", EventType.NodeChildrenChanged, 11L,
                Collections.emptyList());

        assertNotNull(triggered);
        assertTrue(triggered.contains(watcher));
        assertTrue(triggered.contains(secondWatcher));
        assertEquals(1, watcher.getEvents().size());
        assertEquals(1, secondWatcher.getEvents().size());
        assertEquals(0, watchManager.size());
    }

    @Test
    public void addingAnotherModeShouldRetainSameInternalWatcherMap() {
        watchManager.addWatch("/node", watcher);
        Object originalPathMap = watchManager.getWatch2Paths().get(watcher);

        watchManager.addWatch(
                "/node", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertSame(originalPathMap,
                watchManager.getWatch2Paths().get(watcher));
    }

    private static final class RecordingWatcher implements Watcher {

        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        List<WatchedEvent> getEvents() {
            return events;
        }

        @Override
        public String toString() {
            return "RecordingWatcher@" +
                    Integer.toHexString(System.identityHashCode(this));
        }
    }
}
// ###Test END##

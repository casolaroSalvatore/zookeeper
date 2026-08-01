/*
 * Focused JUnit 4 tests for WatchManager.
 *
 * These tests intentionally exercise only:
 *   addWatch(String, Watcher, WatcherMode)
 *   triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
 *   containsWatcher(String, Watcher, WatcherMode)
 *   removeWatcher(String, Watcher, WatcherMode)
 */
package org.apache.zookeeper.server.watch.watchmanager.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerWatcher;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Test;

public class WatchManagerGuidedToTFewShotTest {

    private static final String PATH = "/node";

    private static final class RecordingWatcher implements Watcher {
        private int invocationCount;
        private WatchedEvent lastEvent;

        @Override
        public void process(WatchedEvent event) {
            invocationCount++;
            lastEvent = event;
        }
    }

    private static final class RecordingServerWatcher implements ServerWatcher {
        private int invocationCount;
        private WatchedEvent lastEvent;
        private List<ACL> lastAcl;

        @Override
        public void process(WatchedEvent event) {
            fail("WatchManager must use ServerWatcher.process(event, acl)");
        }

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            invocationCount++;
            lastEvent = event;
            lastAcl = acl;
        }
    }

    /* ---------------------------------------------------------------------
     * addWatch(String, Watcher, WatcherMode)
     * ------------------------------------------------------------------ */

    @Test
    public void addWatchRegistersEveryModeAndRejectsDuplicateMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void addWatchKeepsWatchersAndPathsIndependent() {
        WatchManager manager = new WatchManager();
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch("/a", first, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/a", second, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/b", first, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/a", first, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/a", second, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/b", first, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/b", second, null));
    }

    @Test(expected = NullPointerException.class)
    public void addWatchRejectsNullMode() {
        WatchManager manager = new WatchManager();
        manager.addWatch(PATH, new RecordingWatcher(), null);
    }

    /* ---------------------------------------------------------------------
     * containsWatcher(String, Watcher, WatcherMode)
     * ------------------------------------------------------------------ */

    @Test
    public void containsWatcherSupportsExactModeAndAnyModeQueries() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();

        assertFalse(manager.containsWatcher(PATH, watcher, null));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher(PATH, watcher, null));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/other", watcher, null));
        assertFalse(manager.containsWatcher(PATH, other, null));
    }

    @Test
    public void containsWatcherReflectsOneShotConsumption() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        manager.triggerWatch(PATH, EventType.NodeDataChanged, 11L, null, null);

        assertFalse(manager.containsWatcher(PATH, watcher, null));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    /* ---------------------------------------------------------------------
     * removeWatcher(String, Watcher, WatcherMode)
     * ------------------------------------------------------------------ */

    @Test
    public void removeWatcherRemovesOnlyTheRequestedMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.removeWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForOnlyThatPair() {
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
        assertFalse(manager.removeWatcher(PATH, first, null));
    }

    @Test
    public void removeWatcherMismatchChangesNothing() {
        WatchManager manager = new WatchManager();
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/missing", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher(PATH, unknown, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher(PATH, registered, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher(PATH, registered, WatcherMode.PERSISTENT));
    }

    /* ---------------------------------------------------------------------
     * triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
     * ------------------------------------------------------------------ */

    @Test
    public void triggerWatchReturnsNullWhenNoWatcherMatches() {
        WatchManager manager = new WatchManager();
        assertNull(manager.triggerWatch("/unwatched", EventType.NodeCreated, 1L, null, null));
    }

    @Test
    public void triggerWatchDeliversEventFieldsAndConsumesOnlyStandardMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher oneShot = new RecordingWatcher();
        RecordingWatcher persistent = new RecordingWatcher();
        manager.addWatch(PATH, oneShot, WatcherMode.STANDARD);
        manager.addWatch(PATH, persistent, WatcherMode.PERSISTENT);

        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeDataChanged, 42L, null, null);

        assertNotNull(fired);
        assertTrue(fired.contains(oneShot));
        assertTrue(fired.contains(persistent));
        assertEquals(1, oneShot.invocationCount);
        assertEquals(1, persistent.invocationCount);
        assertEquals(PATH, oneShot.lastEvent.getPath());
        assertEquals(EventType.NodeDataChanged, oneShot.lastEvent.getType());
        assertEquals(42L, oneShot.lastEvent.getZxid());
        assertFalse(manager.containsWatcher(PATH, oneShot, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, persistent, WatcherMode.PERSISTENT));

        manager.triggerWatch(PATH, EventType.NodeDeleted, 43L, null, null);
        assertEquals(1, oneShot.invocationCount);
        assertEquals(2, persistent.invocationCount);
    }

    @Test
    public void triggerWatchFiresRecursiveAncestorButNotDirectParentPersistentWatch() {
        WatchManager manager = new WatchManager();
        RecordingWatcher recursive = new RecordingWatcher();
        RecordingWatcher parentPersistent = new RecordingWatcher();
        RecordingWatcher direct = new RecordingWatcher();
        manager.addWatch("/a", recursive, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a", parentPersistent, WatcherMode.PERSISTENT);
        manager.addWatch("/a/b", direct, WatcherMode.STANDARD);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/a/b", EventType.NodeCreated, 7L, null, null);

        assertNotNull(fired);
        assertTrue(fired.contains(recursive));
        assertTrue(fired.contains(direct));
        assertFalse(fired.contains(parentPersistent));
        assertEquals(1, recursive.invocationCount);
        assertEquals(0, parentPersistent.invocationCount);
        assertEquals(1, direct.invocationCount);
        assertTrue(manager.containsWatcher("/a", recursive,
                WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/a/b", direct, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchSuppressesDeliveryButStillReturnsAndConsumesWatcher() {
        WatchManager manager = new WatchManager();
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();

        manager.addWatch("/seed", suppressed, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = manager.triggerWatch(
                "/seed", EventType.NodeCreated, 1L, null, null);
        assertNotNull(suppress);
        assertEquals(1, suppressed.invocationCount);

        manager.addWatch(PATH, suppressed, WatcherMode.STANDARD);
        manager.addWatch(PATH, delivered, WatcherMode.STANDARD);
        WatcherOrBitSet fired = manager.triggerWatch(
                PATH, EventType.NodeDeleted, 2L, null, suppress);

        assertNotNull(fired);
        assertTrue(fired.contains(suppressed));
        assertTrue(fired.contains(delivered));
        assertEquals(1, suppressed.invocationCount);
        assertEquals(1, delivered.invocationCount);
        assertFalse(manager.containsWatcher(PATH, suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, delivered, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchPassesAclToServerWatcher() {
        WatchManager manager = new WatchManager();
        RecordingServerWatcher watcher = new RecordingServerWatcher();
        List<ACL> acl = Collections.singletonList(new ACL());
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeCreated, 99L, acl, null);

        assertEquals(1, watcher.invocationCount);
        assertSame(acl, watcher.lastAcl);
        assertEquals(PATH, watcher.lastEvent.getPath());
        assertEquals(99L, watcher.lastEvent.getZxid());
    }

    @Test
    public void watcherRegisteredInMultipleMatchingModesIsDeliveredOnlyOnce() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a/b", watcher, WatcherMode.STANDARD);
        manager.addWatch("/a/b", watcher, WatcherMode.PERSISTENT);

        WatcherOrBitSet fired = manager.triggerWatch(
                "/a/b", EventType.NodeDataChanged, 5L, null, null);

        assertNotNull(fired);
        assertTrue(fired.contains(watcher));
        assertEquals(1, watcher.invocationCount);
        assertFalse(manager.containsWatcher("/a/b", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/a/b", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/a", watcher,
                WatcherMode.PERSISTENT_RECURSIVE));
    }
}

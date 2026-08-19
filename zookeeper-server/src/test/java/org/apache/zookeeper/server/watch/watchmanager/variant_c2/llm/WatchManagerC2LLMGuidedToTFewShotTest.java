/*
 * Comprehensive JUnit 4 tests for the four requested WatchManager operations.
 *
 * Place this file under:
 *   zookeeper-server/src/test/java/org/apache/zookeeper/server/watch/
 */
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
import org.apache.zookeeper.data.ACL;
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
public class WatchManagerC2LLMGuidedToTFewShotTest {

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    // ---------------------------------------------------------------------
    // addWatch(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    /** Expert 1: adding a new path/watcher/mode tuple succeeds. */
    @Test
    public void testAddWatchBasic() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/basic", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/basic", watcher, WatcherMode.STANDARD));
    }

    /** Expert 2: an exact duplicate is idempotent and reports no state change. */
    @Test
    public void testAddWatchDuplicateReturnsFalse() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/duplicate", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/duplicate", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/duplicate", watcher, WatcherMode.PERSISTENT));
    }

    /** Expert 3: the same watcher/path can independently hold every supported mode. */
    @Test
    public void testAddWatchCombinesModesWithoutDuplicatingPathEntry() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/multi", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/multi", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals("watchTable stores one watcher for the path", 1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    /** A recursive-watch duplicate must not inflate the recursive-watch counter. */
    @Test
    public void testAddDuplicateRecursiveWatchDoesNotInflateCounter() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/recursive", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.addWatch("/recursive", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    // ---------------------------------------------------------------------
    // triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
    // ---------------------------------------------------------------------

    /** Expert 1: a standard watch receives the exact event data and is one-shot. */
    @Test
    public void testTriggerWatchBasicStandardWatchIsConsumed() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/node", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 42L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), "/node", EventType.NodeDataChanged, 42L);
        assertFalse(manager.containsWatcher("/node", watcher, WatcherMode.STANDARD));

        assertNull(manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 43L, null, null));
        assertEquals(1, watcher.events.size());
    }

    /** Expert 2: suppression prevents delivery but does not remove the watcher from the result. */
    @Test
    public void testTriggerWatchSuppressesDeliveryButStillCollectsWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher delivered = new RecordingWatcher();
        manager.addWatch("/node", suppressed, WatcherMode.PERSISTENT);
        manager.addWatch("/node", delivered, WatcherMode.PERSISTENT);


        /* Modified to resolve the compilation error
        WatcherOrBitSet suppress = new WatcherOrBitSet(suppressed);
        */

        WatcherOrBitSet suppress = new WatcherOrBitSet(Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet result = manager.triggerWatch(
                "/node", EventType.NodeCreated, 7L, Collections.<ACL>emptyList(), suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(delivered));
        assertTrue(suppressed.events.isEmpty());
        assertEquals(1, delivered.events.size());
        assertTrue(manager.containsWatcher("/node", suppressed, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", delivered, WatcherMode.PERSISTENT));
    }

    /** Expert 3: a persistent-recursive watch fires for a descendant and remains installed. */
    @Test
    public void testTriggerWatchIncludesPersistentRecursiveAncestor() {
        RecordingWatcher ancestor = new RecordingWatcher();
        RecordingWatcher unrelated = new RecordingWatcher();
        manager.addWatch("/a", ancestor, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/other", unrelated, WatcherMode.PERSISTENT_RECURSIVE);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b/c", EventType.NodeChildrenChanged, 99L, null, null);

        assertNotNull(result);
        assertTrue(result.contains(ancestor));
        assertFalse(result.contains(unrelated));
        assertEquals(1, ancestor.events.size());
        assertEvent(ancestor.events.get(0), "/a/b/c", EventType.NodeChildrenChanged, 99L);
        assertTrue(manager.containsWatcher("/a", ancestor, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(unrelated.events.isEmpty());
    }

    /** No matching direct or recursive watch produces null and no callbacks. */
    @Test
    public void testTriggerWatchOnUnwatchedPathReturnsNull() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/watched", watcher, WatcherMode.PERSISTENT);

        assertNull(manager.triggerWatch(
                "/unwatched", EventType.NodeDeleted, Long.MAX_VALUE, null, null));
        assertTrue(watcher.events.isEmpty());
        assertTrue(manager.containsWatcher("/watched", watcher, WatcherMode.PERSISTENT));
    }

    /** WatchManager does not swallow runtime failures raised by a watcher callback. */
    @Test(expected = IllegalStateException.class)
    public void testTriggerWatchPropagatesWatcherCallbackException() {
        Watcher failingWatcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                throw new IllegalStateException("callback failure");
            }
        };
        manager.addWatch("/failure", failingWatcher, WatcherMode.STANDARD);

        manager.triggerWatch("/failure", EventType.NodeCreated, 5L, null, null);
    }

    /** A direct watcher with STANDARD and PERSISTENT loses only STANDARD when fired. */
    @Test
    public void testTriggerWatchConsumesOnlyStandardMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/mixed", watcher, WatcherMode.STANDARD);
        manager.addWatch("/mixed", watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/mixed", EventType.NodeCreated, 1L, null, null);

        assertFalse(manager.containsWatcher("/mixed", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/mixed", watcher, WatcherMode.PERSISTENT));

        manager.triggerWatch("/mixed", EventType.NodeDeleted, 2L, null, null);
        assertEquals(2, watcher.events.size());
    }

    // ---------------------------------------------------------------------
    // containsWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    /** Expert 1: containsWatcher recognizes an existing exact tuple. */
    @Test
    public void testContainsWatcherBasic() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/contains", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/contains", watcher, WatcherMode.PERSISTENT));
    }

    /** Expert 2: null mode means any mode, while mismatched modes return false. */
    @Test
    public void testContainsWatcherAnyModeAndModeMismatch() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/contains", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/contains", watcher, null));
        assertTrue(manager.containsWatcher("/contains", watcher));
        assertFalse(manager.containsWatcher("/contains", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(
                "/contains", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    /** Expert 3: watcher identity and path must both match. */
    @Test
    public void testContainsWatcherRejectsMissingPathAndDifferentWatcher() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher different = new RecordingWatcher();
        manager.addWatch("/one", registered, WatcherMode.STANDARD);

        assertFalse(manager.containsWatcher("/missing", registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/one", different, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/one", different, null));
    }

    // ---------------------------------------------------------------------
    // removeWatcher(String, Watcher, WatcherMode)
    // ---------------------------------------------------------------------

    /** Expert 1: removing one mode preserves the other modes for the tuple. */
    @Test
    public void testRemoveWatcherBasicSingleMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/remove", watcher, WatcherMode.STANDARD);
        manager.addWatch("/remove", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/remove", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/remove", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/remove", watcher, WatcherMode.PERSISTENT));
    }

    /** Expert 2: null mode removes all modes for only the selected path/watcher tuple. */
    @Test
    public void testRemoveWatcherNullModeRemovesAllModesOnlyForTargetTuple() {
        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch("/target", watcher, WatcherMode.STANDARD);
        manager.addWatch("/target", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/kept", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/target", other, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/target", watcher, null));

        assertFalse(manager.containsWatcher("/target", watcher, null));
        assertTrue(manager.containsWatcher("/kept", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/target", other, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    /** Expert 3: mismatched removals are no-ops and return false. */
    @Test
    public void testRemoveWatcherMismatchDoesNotMutateState() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher different = new RecordingWatcher();
        manager.addWatch("/node", registered, WatcherMode.PERSISTENT);

        assertFalse(manager.removeWatcher("/missing", registered, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher("/node", different, WatcherMode.PERSISTENT));
        assertFalse(manager.removeWatcher("/node", registered, WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node", registered, WatcherMode.PERSISTENT));
        assertEquals(1, manager.size());
    }

    /** Removing the final mode deletes the tuple and a repeated removal returns false. */
    @Test
    public void testRemoveWatcherFinalModeAndRepeatedRemoval() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/final", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(
                "/final", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/final", watcher, null));
        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.removeWatcher(
                "/final", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    private static void assertEvent(
            WatchedEvent event, String path, EventType type, long zxid) {
        assertEquals(path, event.getPath());
        assertSame(type, event.getType());
        assertSame(KeeperState.SyncConnected, event.getState());
        assertEquals(zxid, event.getZxid());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}

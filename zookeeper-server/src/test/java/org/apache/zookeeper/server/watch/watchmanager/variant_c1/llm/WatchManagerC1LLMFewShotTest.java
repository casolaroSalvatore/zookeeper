package org.apache.zookeeper.server.watch.watchmanager.variant_c1.llm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Test;

/**
 * Focused tests for:
 * - addWatch(String, Watcher, WatcherMode)
 * - triggerWatch(String, EventType, long, List<ACL>, WatcherOrBitSet)
 * - containsWatcher(String, Watcher, WatcherMode)
 * - removeWatcher(String, Watcher, WatcherMode)
 */
public class WatchManagerC1LLMFewShotTest {

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
            return events.isEmpty() ? null : events.get(events.size() - 1);
        }
    }

    @Test
    public void testAddWatchContainsAndDuplicateModes() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher = new RecordingWatcher();
        RecordingWatcher otherWatcher = new RecordingWatcher();

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher,
                        WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher));
        assertTrue(manager.containsWatcher("/node1", watcher, null));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher("/node2", watcher));
        assertFalse(manager.containsWatcher("/node2", watcher, WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node1", otherWatcher));
        assertFalse(manager.containsWatcher("/node1", otherWatcher, WatcherMode.STANDARD));

        assertFalse(
                manager.addWatch(
                        "/node1",
                        watcher,
                        WatcherMode.STANDARD));

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher,
                        WatcherMode.PERSISTENT));

        assertTrue(
                manager.addWatch(
                        "/node1",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testRemoveWatcherBySpecificMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher,
                        WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher,
                        WatcherMode.PERSISTENT));

        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher("/node1", watcher));
        assertFalse(manager.containsWatcher("/node1", watcher, null));
    }

    @Test
    public void testRemoveWatcherMismatchCases() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.PERSISTENT));

        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher2,
                        WatcherMode.PERSISTENT));

        assertFalse(
                manager.removeWatcher(
                        "/another",
                        watcher1,
                        WatcherMode.PERSISTENT));

        assertFalse(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertTrue(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node1", watcher1, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcherWithoutModeRemovesAllModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.removeWatcher("/node1", watcher, null));

        assertFalse(manager.containsWatcher("/node1", watcher));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node1", watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.removeWatcher("/node1", watcher, null));
    }

    @Test
    public void testTriggerWatchConsumesStandardWatch() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/path", watcher, WatcherMode.STANDARD));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/path",
                        EventType.NodeCreated,
                        10L,
                        Collections.<ACL>emptyList(),
                        null);

        assertNotNull(result);
        assertEquals(1, watcher.eventCount());

        WatchedEvent event = watcher.lastEvent();
        assertEquals(EventType.NodeCreated, event.getType());
        assertEquals("/path", event.getPath());
        assertEquals(10L, event.getZxid());

        assertFalse(
                "Standard watches should be removed after trigger",
                manager.containsWatcher(
                        "/path",
                        watcher,
                        WatcherMode.STANDARD));
    }

    @Test
    public void testTriggerWatchKeepsPersistentWatch() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch("/persistent", watcher, WatcherMode.PERSISTENT));

        manager.triggerWatch(
                "/persistent",
                EventType.NodeDataChanged,
                1L,
                null,
                null);

        manager.triggerWatch(
                "/persistent",
                EventType.NodeDataChanged,
                2L,
                null,
                null);

        assertEquals(2, watcher.eventCount());
        assertTrue(
                manager.containsWatcher(
                        "/persistent",
                        watcher,
                        WatcherMode.PERSISTENT));
    }

    @Test
    public void testTriggerWatchFiresRecursiveWatchOnChildPath() {
        WatchManager manager = new WatchManager();

        RecordingWatcher recursiveWatcher = new RecordingWatcher();

        assertTrue(
                manager.addWatch(
                        "/root",
                        recursiveWatcher,
                        WatcherMode.PERSISTENT_RECURSIVE));

        manager.triggerWatch(
                "/root/child",
                EventType.NodeCreated,
                100L,
                null,
                null);

        assertEquals(1, recursiveWatcher.eventCount());
        assertEquals("/root/child", recursiveWatcher.lastEvent().getPath());

        assertTrue(
                manager.containsWatcher(
                        "/root",
                        recursiveWatcher,
                        WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void testTriggerWatchWithSuppressDoesNotNotifySuppressedWatcher() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher2, WatcherMode.PERSISTENT));

        WatcherOrBitSet suppress =
                new WatcherOrBitSet(Collections.<Watcher>singleton(watcher1));

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/node",
                        EventType.NodeDeleted,
                        20L,
                        null,
                        suppress);

        assertNotNull(result);

        assertEquals(0, watcher1.eventCount());
        assertEquals(1, watcher2.eventCount());
    }

    @Test
    public void testTriggerWatchWithoutRegisteredWatcherReturnsNull() {
        WatchManager manager = new WatchManager();

        WatcherOrBitSet result =
                manager.triggerWatch(
                        "/missing",
                        EventType.NodeCreated,
                        5L,
                        null,
                        null);

        assertNull(result);
    }

    @Test
    public void testIndependentPathsAndWatchersRemainUnaffected() {
        WatchManager manager = new WatchManager();

        RecordingWatcher watcher1 = new RecordingWatcher();
        RecordingWatcher watcher2 = new RecordingWatcher();

        assertTrue(manager.addWatch("/node1", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/node2", watcher2, WatcherMode.PERSISTENT));

        assertTrue(
                manager.removeWatcher(
                        "/node1",
                        watcher1,
                        WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node1", watcher1));
        assertTrue(manager.containsWatcher("/node2", watcher2));
        assertTrue(manager.containsWatcher("/node2", watcher2, WatcherMode.PERSISTENT));

        manager.triggerWatch(
                "/node2",
                EventType.NodeDataChanged,
                8L,
                null,
                null);

        assertEquals(1, watcher2.eventCount());
    }
}
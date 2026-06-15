package org.apache.zookeeper.server.watch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.watch.WatchManager;
import org.apache.zookeeper.server.watch.WatcherMode;
import org.apache.zookeeper.server.watch.WatcherOrBitSet;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.Assert.*;

public class WatchManagerTestLLMZeroShot {
    private WatchManager watchManager;
    private RecordingWatcher watcher;

    private static class RecordingWatcher implements Watcher {
        private AtomicInteger eventCount = new AtomicInteger(0);
        private WatchedEvent lastEvent;

        @Override
        public void process(WatchedEvent event) {
            eventCount.incrementAndGet();
            lastEvent = event;
        }

        public int getEventCount() {
            return eventCount.get();
        }

        public WatchedEvent getLastEvent() {
            return lastEvent;
        }
    }

    @Before
    public void setUp() {
        watchManager = new WatchManager();
        watcher = new RecordingWatcher();
    }

// ========================= addWatch =========================

    @Test
    public void testAddWatch_NewWatcher() {
        boolean result = watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);
        assertTrue(result);
        assertTrue(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testAddWatch_DuplicateWatcherSameMode() {
        assertTrue(watchManager.addWatch("/test", watcher, WatcherMode.STANDARD));
        boolean result = watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        // Should not add duplicate mode
        assertFalse(result);
    }

    @Test
    public void testAddWatch_DifferentModes() {
        assertTrue(watchManager.addWatch("/test", watcher, WatcherMode.STANDARD));
        boolean result = watchManager.addWatch("/test", watcher, WatcherMode.PERSISTENT);

        assertTrue(result);
        assertTrue(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher("/test", watcher, WatcherMode.PERSISTENT));
    }

// ========================= containsWatcher =========================

    @Test
    public void testContainsWatcher_ExactMode() {
        watchManager.addWatch("/test", watcher, WatcherMode.PERSISTENT);

        assertTrue(watchManager.containsWatcher("/test", watcher, WatcherMode.PERSISTENT));
        assertFalse(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testContainsWatcher_NullMode() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        assertTrue(watchManager.containsWatcher("/test", watcher, null));
    }

    @Test
    public void testContainsWatcher_NotPresent() {
        assertFalse(watchManager.containsWatcher("/unknown", watcher, WatcherMode.STANDARD));
    }

// ========================= removeWatcher =========================

    @Test
    public void testRemoveWatcher_ByMode() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        boolean result = watchManager.removeWatcher("/test", watcher, WatcherMode.STANDARD);
        assertTrue(result);
        assertFalse(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
    }

    @Test
    public void testRemoveWatcher_PartialModeRemoval() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);
        watchManager.addWatch("/test", watcher, WatcherMode.PERSISTENT);

        boolean result = watchManager.removeWatcher("/test", watcher, WatcherMode.STANDARD);

        assertTrue(result);
        assertFalse(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
        assertTrue(watchManager.containsWatcher("/test", watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void testRemoveWatcher_RemoveAllModes() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        boolean result = watchManager.removeWatcher("/test", watcher, null);

        assertTrue(result);
        assertFalse(watchManager.containsWatcher("/test", watcher, null));
    }

    @Test
    public void testRemoveWatcher_NotExisting() {
        boolean result = watchManager.removeWatcher("/test", watcher, WatcherMode.STANDARD);
        assertFalse(result);
    }

// ========================= triggerWatch =========================

    @Test
    public void testTriggerWatch_SingleWatcher() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = watchManager.triggerWatch(
                "/test",
                EventType.NodeCreated,
                1L,
                new ArrayList<ACL>(),
                null
        );

        assertNotNull(result);
        assertEquals(1, watcher.getEventCount());
        assertEquals(EventType.NodeCreated, watcher.getLastEvent().getType());
    }

    @Test
    public void testTriggerWatch_NoWatcher() {
        WatcherOrBitSet result = watchManager.triggerWatch(
                "/test",
                EventType.NodeCreated,
                1L,
                new ArrayList<ACL>(),
                null
        );

        assertNull(result);
    }

    @Test
    public void testTriggerWatch_SuppressWatcher() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        WatcherOrBitSet suppress = new WatcherOrBitSet(watcher);

        WatcherOrBitSet result = watchManager.triggerWatch(
                "/test",
                EventType.NodeDeleted,
                2L,
                new ArrayList<ACL>(),
                suppress
        );

        assertNotNull(result);
        // watcher should not be triggered due to suppression
        assertEquals(0, watcher.getEventCount());
    }

    @Test
    public void testTriggerWatch_RemovesStandardWatcherAfterTrigger() {
        watchManager.addWatch("/test", watcher, WatcherMode.STANDARD);

        watchManager.triggerWatch(
                "/test",
                EventType.NodeDataChanged,
                3L,
                new ArrayList<ACL>(),
                null
        );

        // STANDARD watchers should be removed after trigger
        assertFalse(watchManager.containsWatcher("/test", watcher, WatcherMode.STANDARD));
    }
}

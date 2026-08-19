
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 */
package org.apache.zookeeper.server.watch;

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
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
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
public class WatchManagerC2LLMFewShotTest {

    private WatchManager manager;
    private RecordingWatcher watcher1;
    private RecordingWatcher watcher2;

    @Before
    public void setUp() {
        manager = new WatchManager();
        watcher1 = new RecordingWatcher();
        watcher2 = new RecordingWatcher();
    }

    @Test
    public void addWatchStoresEveryModeAndRejectsDuplicateMode() {
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.STANDARD));

        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));

        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchKeepsPathsAndWatchersIndependent() {
        assertTrue(manager.addWatch("/one", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/two", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/one", watcher2, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher("/one", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/two", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/one", watcher2, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/two", watcher2, null));
        assertFalse(manager.containsWatcher("/one", watcher1, WatcherMode.STANDARD));
    }

    @Test
    public void containsWatcherSupportsAnyModeAndRejectsMismatches() {
        manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher("/node", watcher1, null));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/other", watcher1, null));
        assertFalse(manager.containsWatcher("/node", watcher2, null));
    }

    @Test
    public void removeWatcherByModeRemovesOnlyRequestedMode() {
        addAllModes("/node", watcher1);

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));

        assertTrue(manager.removeWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher("/node", watcher1, null));
        assertFalse(manager.removeWatcher("/node", watcher1, WatcherMode.PERSISTENT));
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForOnlyThatPair() {
        addAllModes("/node", watcher1);
        manager.addWatch("/other", watcher1, WatcherMode.PERSISTENT);
        manager.addWatch("/node", watcher2, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher("/node", watcher1, null));

        assertFalse(manager.containsWatcher("/node", watcher1, null));
        assertTrue(manager.containsWatcher("/other", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher2, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void removeWatcherMismatchChangesNothing() {
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.removeWatcher("/missing", watcher1, null));
        assertFalse(manager.removeWatcher("/node", watcher2, null));
        assertFalse(manager.removeWatcher("/node", watcher1, WatcherMode.STANDARD));

        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void triggerWatchReturnsNullAndDoesNotNotifyWhenNothingMatches() {
        assertNull(manager.triggerWatch(
                "/missing", EventType.NodeCreated, 11L, Collections.<ACL>emptyList(), null));
        assertEquals(0, watcher1.events.size());
    }

    @Test
    public void triggerWatchConsumesStandardButRetainsPersistentModes() {
        addAllModes("/node", watcher1);

        WatcherOrBitSet first = manager.triggerWatch(
                "/node", EventType.NodeDataChanged, 21L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(first);
        assertTrue(first.contains(watcher1));
        assertEvent(watcher1.lastEvent(), "/node", EventType.NodeDataChanged, 21L);
        assertFalse(manager.containsWatcher("/node", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/node", watcher1, WatcherMode.PERSISTENT_RECURSIVE));

        WatcherOrBitSet second = manager.triggerWatch(
                "/node", EventType.NodeDeleted, 22L,
                Collections.<ACL>emptyList(), null);
        assertNotNull(second);
        assertEquals(2, watcher1.events.size());
        assertEvent(watcher1.lastEvent(), "/node", EventType.NodeDeleted, 22L);
    }

    @Test
    public void triggerWatchConsumesAStandardOnlyWatch() {
        manager.addWatch("/node", watcher1, WatcherMode.STANDARD);

        assertNotNull(manager.triggerWatch(
                "/node", EventType.NodeCreated, 31L,
                Collections.<ACL>emptyList(), null));
        assertFalse(manager.containsWatcher("/node", watcher1, null));

        assertNull(manager.triggerWatch(
                "/node", EventType.NodeCreated, 32L,
                Collections.<ACL>emptyList(), null));
        assertEquals(1, watcher1.events.size());
    }

    @Test
    public void triggerWatchNotifiesRecursiveAncestorsButNotNonRecursiveAncestors() {
        manager.addWatch("/a", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a", watcher2, WatcherMode.PERSISTENT);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b/c", EventType.NodeChildrenChanged, 41L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertFalse(result.contains(watcher2));
        assertEvent(watcher1.lastEvent(), "/a/b/c", EventType.NodeChildrenChanged, 41L);
        assertEquals(0, watcher2.events.size());
        assertTrue(manager.containsWatcher("/a", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchDeduplicatesWatcherRegisteredDirectlyAndRecursively() {
        manager.addWatch("/a", watcher1, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/a/b", watcher1, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                "/a/b", EventType.NodeCreated, 51L,
                Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertEquals(1, watcher1.events.size());
        assertFalse(manager.containsWatcher("/a/b", watcher1, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/a", watcher1, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchSuppressesNotificationButStillReturnsAndConsumesWatch() {
        manager.addWatch("/seed", watcher1, WatcherMode.PERSISTENT);
        WatcherOrBitSet suppress = manager.triggerWatch(
                "/seed", EventType.NodeCreated, 60L,
                Collections.<ACL>emptyList(), null);
        watcher1.events.clear();

        manager.addWatch("/target", watcher1, WatcherMode.STANDARD);
        manager.addWatch("/target", watcher2, WatcherMode.STANDARD);
        WatcherOrBitSet result = manager.triggerWatch(
                "/target", EventType.NodeDeleted, 61L,
                Collections.<ACL>emptyList(), suppress);

        assertNotNull(result);
        assertTrue(result.contains(watcher1));
        assertTrue(result.contains(watcher2));
        assertEquals(0, watcher1.events.size());
        assertEquals(1, watcher2.events.size());
        assertFalse(manager.containsWatcher("/target", watcher1, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/target", watcher2, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchPassesAclOnlyToServerWatcher() {
        RecordingServerWatcher serverWatcher = new RecordingServerWatcher();
        RecordingWatcher ordinaryWatcher = new RecordingWatcher();
        List<ACL> acl = Arrays.asList(new ACL(31, new Id("world", "anyone")));
        manager.addWatch("/secure", serverWatcher, WatcherMode.PERSISTENT);
        manager.addWatch("/secure", ordinaryWatcher, WatcherMode.PERSISTENT);

        manager.triggerWatch("/secure", EventType.NodeDataChanged, 71L, acl, null);

        assertEquals(1, serverWatcher.events.size());
        assertSame(acl, serverWatcher.lastAcl);
        assertEquals(1, ordinaryWatcher.events.size());
        assertEvent(serverWatcher.lastEvent(), "/secure", EventType.NodeDataChanged, 71L);
    }

    private void addAllModes(String path, Watcher watcher) {
        assertTrue(manager.addWatch(path, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(path, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    private static void assertEvent(
            WatchedEvent event, String path, EventType type, long zxid) {
        assertNotNull(event);
        assertEquals(path, event.getPath());
        assertEquals(type, event.getType());
        assertEquals(zxid, event.getZxid());
    }

    private static class RecordingWatcher implements Watcher {
        protected final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }

        WatchedEvent lastEvent() {
            return events.get(events.size() - 1);
        }
    }

    private static final class RecordingServerWatcher extends RecordingWatcher
            implements ServerWatcher {
        private List<ACL> lastAcl;

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            events.add(event);
            lastAcl = acl;
        }
    }
}

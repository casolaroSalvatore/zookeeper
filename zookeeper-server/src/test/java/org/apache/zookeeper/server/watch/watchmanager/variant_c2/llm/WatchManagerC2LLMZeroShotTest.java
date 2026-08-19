
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0.
 */
package org.apache.zookeeper.server.watch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.junit.Test;

/**
 * Focused unit tests for WatchManager's mode-aware add, trigger, contains,
 * and remove operations.
 */
public class WatchManagerC2LLMZeroShotTest {

    private static final String PATH = "/app/node";

    private WatchManager manager;

    @Before
    public void setUp() {
        manager = new WatchManager();
    }

    @Test
    public void addWatchReturnsTrueForNewStandardWatchAndContainsIt() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, null));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchReturnsFalseForDuplicateMode() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertFalse(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchCombinesDifferentModesForSameWatcherAndPath() {
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void addWatchAllowsSameWatcherOnDifferentPathsAndDifferentWatchersOnSamePath() {
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, first, WatcherMode.STANDARD));
        assertTrue(manager.addWatch("/app/other", first, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, second, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher(PATH, first, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/app/other", first, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, second, WatcherMode.PERSISTENT));
    }

    @Test
    public void containsWatcherReturnsFalseForUnknownWatcherPathAndMode() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.STANDARD);

        assertFalse(manager.containsWatcher(PATH, unknown, null));
        assertFalse(manager.containsWatcher("/missing", registered, null));
        assertFalse(manager.containsWatcher(PATH, registered, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchReturnsNullAndDoesNotNotifyWhenNoWatchMatches() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        assertNull(manager.triggerWatch("/different", EventType.NodeCreated, 11L,
                Collections.<ACL>emptyList(), null));
        assertEquals(0, watcher.events.size());
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void triggerWatchNotifiesStandardWatcherAndConsumesStandardMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                PATH, EventType.NodeDataChanged, 42L, Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        assertEvent(watcher.events.get(0), EventType.NodeDataChanged, PATH, 42L);
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertNull(manager.triggerWatch(
                PATH, EventType.NodeDataChanged, 43L, Collections.<ACL>emptyList(), null));
    }

    @Test
    public void triggerWatchKeepsPersistentModeButConsumesStandardMode() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeChildrenChanged, 7L,
                Collections.<ACL>emptyList(), null);
        manager.triggerWatch(PATH, EventType.NodeChildrenChanged, 8L,
                Collections.<ACL>emptyList(), null);

        assertEquals(2, watcher.events.size());
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchNotifiesRecursiveWatchersOnAncestorsAndLeavesThemInstalled() {
        RecordingWatcher root = new RecordingWatcher();
        RecordingWatcher parent = new RecordingWatcher();
        RecordingWatcher direct = new RecordingWatcher();
        manager.addWatch("/", root, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/app", parent, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch(PATH, direct, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                PATH, EventType.NodeCreated, 100L, Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertTrue(result.contains(root));
        assertTrue(result.contains(parent));
        assertTrue(result.contains(direct));
        assertEquals(1, root.events.size());
        assertEquals(1, parent.events.size());
        assertEquals(1, direct.events.size());
        assertTrue(manager.containsWatcher("/", root, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/app", parent, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher(PATH, direct, WatcherMode.STANDARD));
        assertEquals(2, manager.getRecursiveWatchQty());
    }

    @Test
    public void triggerWatchDoesNotTriggerNonRecursiveParentWatch() {
        RecordingWatcher parent = new RecordingWatcher();
        RecordingWatcher direct = new RecordingWatcher();
        manager.addWatch("/app", parent, WatcherMode.PERSISTENT);
        manager.addWatch(PATH, direct, WatcherMode.STANDARD);

        WatcherOrBitSet result = manager.triggerWatch(
                PATH, EventType.NodeDeleted, 9L, Collections.<ACL>emptyList(), null);

        assertNotNull(result);
        assertFalse(result.contains(parent));
        assertTrue(result.contains(direct));
        assertEquals(0, parent.events.size());
        assertEquals(1, direct.events.size());
        assertTrue(manager.containsWatcher("/app", parent, WatcherMode.PERSISTENT));
    }

    @Test
    public void triggerWatchHonorsSuppressButStillReturnsAndConsumesSuppressedWatcher() {
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher notified = new RecordingWatcher();
        manager.addWatch(PATH, suppressed, WatcherMode.STANDARD);
        manager.addWatch(PATH, notified, WatcherMode.STANDARD);
        WatcherOrBitSet suppress = mock(WatcherOrBitSet.class);
        when(suppress.contains(suppressed)).thenReturn(true);
        when(suppress.contains(notified)).thenReturn(false);

        WatcherOrBitSet result = manager.triggerWatch(
                PATH, EventType.NodeDeleted, 17L, Collections.<ACL>emptyList(), suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(notified));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, notified.events.size());
        assertFalse(manager.containsWatcher(PATH, suppressed, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, notified, WatcherMode.STANDARD));
        verify(suppress).contains(suppressed);
        verify(suppress).contains(notified);
    }

    @Test
    public void triggerWatchPassesAclToServerWatcher() {
        ServerWatcher watcher = mock(ServerWatcher.class);
        List<ACL> acl = Arrays.asList(new ACL(), new ACL());
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeDataChanged, 23L, acl, null);

        ArgumentCaptor<WatchedEvent> eventCaptor = ArgumentCaptor.forClass(WatchedEvent.class);
        verify(watcher).process(eventCaptor.capture(), same(acl));
        assertEvent(eventCaptor.getValue(), EventType.NodeDataChanged, PATH, 23L);
    }

    @Test
    public void removeWatcherWithNullModeRemovesAllModesForThatPathOnly() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/other", watcher, WatcherMode.PERSISTENT);

        assertTrue(manager.removeWatcher(PATH, watcher, null));

        assertFalse(manager.containsWatcher(PATH, watcher, null));
        assertTrue(manager.containsWatcher("/other", watcher, WatcherMode.PERSISTENT));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.removeWatcher(PATH, watcher, null));
    }

    @Test
    public void removeWatcherRemovesOnlyRequestedModeWhenOthersRemain() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher, WatcherMode.PERSISTENT));

        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertEquals(1, manager.getRecursiveWatchQty());
    }

    @Test
    public void removeWatcherRemovesLastModeAndCleansRegistration() {
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE);

        assertTrue(manager.removeWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));

        assertFalse(manager.containsWatcher(PATH, watcher, null));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertNull(manager.triggerWatch(
                PATH, EventType.NodeDeleted, 1L, Collections.<ACL>emptyList(), null));
    }

    @Test
    public void removeWatcherReturnsFalseForMissingWatcherPathOrModeWithoutChangingState() {
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher unknown = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.STANDARD);

        assertFalse(manager.removeWatcher(PATH, unknown, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher("/missing", registered, WatcherMode.STANDARD));
        assertFalse(manager.removeWatcher(PATH, registered, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, registered, WatcherMode.STANDARD));
    }

    private static void assertEvent(
            WatchedEvent event, EventType type, String path, long zxid) {
        assertEquals(type, event.getType());
        assertEquals(KeeperState.SyncConnected, event.getState());
        assertEquals(path, event.getPath());
        assertEquals(zxid, event.getZxid());
    }

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new java.util.ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }
}

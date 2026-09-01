package org.apache.zookeeper.server.watch;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.server.ServerCnxn;
import org.apache.zookeeper.server.ServerWatcher;
import org.junit.Test;

/**
 * Guided Tree-of-Thought/few-shot JUnit 4 tests for {@link WatchManager}.
 *
 * <p>The tests intentionally exercise the class only through public methods,
 * except for package-visible counters that the production class explicitly
 * marks VisibleForTesting.</p>
 */
public class WatchManagerC4LLMGuidedToTFewShotTest {

    private static final String PATH = "/node";

    private static final class RecordingWatcher implements Watcher {
        private final List<WatchedEvent> events = new ArrayList<>();

        @Override
        public void process(WatchedEvent event) {
            events.add(event);
        }
    }

    private static final class RecordingServerWatcher implements ServerWatcher {
        private WatchedEvent event;
        private List<ACL> acl;

        @Override
        public void process(WatchedEvent event) {
            this.event = event;
        }

        @Override
        public void process(WatchedEvent event, List<ACL> acl) {
            this.event = event;
            this.acl = acl;
        }
    }

    @Test
    public void sizeCountsRegistrationsButNotAdditionalModes() {
        WatchManager manager = new WatchManager();
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();

        assertEquals(0, manager.size());
        assertTrue(manager.addWatch("/a", first));
        assertTrue(manager.addWatch("/b", first));
        assertTrue(manager.addWatch("/a", second));
        assertTrue(manager.addWatch("/a", first, WatcherMode.PERSISTENT));

        assertEquals(3, manager.size());
    }

    @Test
    public void addWatchDefaultModeIsOneShotAndDuplicateReturnsFalse() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher));
        assertFalse(manager.addWatch(PATH, watcher));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.DEFAULT_WATCHER_MODE));

        manager.triggerWatch(PATH, EventType.NodeCreated, 11L, null);

        assertEquals(1, watcher.events.size());
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
    }

    @Test
    public void addWatchSupportsAllModesWithoutIncreasingRegistrationSize() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();

        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT));

        assertEquals(1, manager.size());
        assertEquals(1, manager.getRecursiveWatchQty());
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void addWatchRejectsStaleServerConnection() {
        WatchManager manager = new WatchManager();
        ServerCnxn staleConnection = mock(ServerCnxn.class);
        when(staleConnection.isStale()).thenReturn(true);

        assertFalse(manager.addWatch(PATH, staleConnection));
        assertEquals(0, manager.size());
        assertFalse(manager.containsWatcher(PATH, staleConnection));
    }

    @Test(expected = NullPointerException.class)
    public void addWatchRejectsNullMode() {
        new WatchManager().addWatch(PATH, new RecordingWatcher(), null);
    }

    @Test
    public void removeWatcherRemovesEveryPathAndEveryMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        manager.removeWatcher(watcher);

        assertEquals(0, manager.size());
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.containsWatcher("/a", watcher));
        assertFalse(manager.containsWatcher("/b", watcher));

        manager.removeWatcher(watcher); // absent watcher is a no-op
        assertEquals(0, manager.size());
    }

    @Test
    public void triggerWatchNotifiesDirectWatcherAndReturnsTriggeredSet() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher);

        WatcherOrBitSet result = manager.triggerWatch(PATH, EventType.NodeDataChanged, 42L, null);

        assertNotNull(result);
        assertTrue(result.contains(watcher));
        assertEquals(1, watcher.events.size());
        WatchedEvent event = watcher.events.get(0);
        assertEquals(PATH, event.getPath());
        assertEquals(EventType.NodeDataChanged, event.getType());
        assertEquals(42L, event.getZxid());
    }

    @Test
    public void triggerWatchReturnsNullWhenNoWatcherExists() {
        assertNull(new WatchManager().triggerWatch("/missing", EventType.NodeCreated, 1L, null));
    }

    @Test
    public void triggerWatchPreservesPersistentAndConsumesStandardMode() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher, WatcherMode.STANDARD);
        manager.addWatch(PATH, watcher, WatcherMode.PERSISTENT);

        manager.triggerWatch(PATH, EventType.NodeCreated, 1L, null);
        manager.triggerWatch(PATH, EventType.NodeDeleted, 2L, null);

        assertEquals(2, watcher.events.size());
        assertFalse(manager.containsWatcher(PATH, watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher(PATH, watcher, WatcherMode.PERSISTENT));
    }

    @Test
    public void recursiveWatcherOnParentReceivesDescendantEvent() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE);

        manager.triggerWatch("/parent/child/grandchild", EventType.NodeCreated, 7L, null);

        assertEquals(1, watcher.events.size());
        assertEquals("/parent/child/grandchild", watcher.events.get(0).getPath());
        assertTrue(manager.containsWatcher("/parent", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void triggerWatchWithSuppressReturnsWatcherButDoesNotNotifyIt() {
        WatchManager manager = new WatchManager();
        RecordingWatcher suppressed = new RecordingWatcher();
        RecordingWatcher notified = new RecordingWatcher();
        manager.addWatch(PATH, suppressed);
        manager.addWatch(PATH, notified);
        WatcherOrBitSet suppress = new WatcherOrBitSet(Collections.<Watcher>singleton(suppressed));

        WatcherOrBitSet result = manager.triggerWatch(PATH, EventType.NodeChildrenChanged, 9L, null, suppress);

        assertNotNull(result);
        assertTrue(result.contains(suppressed));
        assertTrue(result.contains(notified));
        assertEquals(0, suppressed.events.size());
        assertEquals(1, notified.events.size());
    }

    @Test
    public void triggerWatchPassesAclToServerWatcher() {
        WatchManager manager = new WatchManager();
        RecordingServerWatcher watcher = new RecordingServerWatcher();
        List<ACL> acl = Collections.singletonList(new ACL());
        manager.addWatch(PATH, watcher);

        manager.triggerWatch(PATH, EventType.NodeCreated, 3L, acl);

        assertNotNull(watcher.event);
        assertSame(acl, watcher.acl);
    }

    @Test
    public void toStringDescribesConnectionsPathsAndUniqueWatchPairs() {
        WatchManager manager = new WatchManager();
        RecordingWatcher first = new RecordingWatcher();
        RecordingWatcher second = new RecordingWatcher();
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);
        manager.addWatch("/a", first, WatcherMode.PERSISTENT);

        assertEquals("2 connections watching 2 paths\nTotal watches:3", manager.toString());
    }

    @Test
    public void dumpWatchesCanGroupByPathOrConnection() {
        WatchManager manager = new WatchManager();
        ServerCnxn first = liveConnection(0x11L);
        ServerCnxn second = liveConnection(0x22L);
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        String byPath = dump(manager, true);
        assertTrue(byPath.contains("/a\n"));
        assertTrue(byPath.contains("/b\n"));
        assertTrue(byPath.contains("\t0x11\n"));
        assertTrue(byPath.contains("\t0x22\n"));

        String byConnection = dump(manager, false);
        assertTrue(byConnection.contains("0x11\n"));
        assertTrue(byConnection.contains("0x22\n"));
        assertTrue(byConnection.contains("\t/a\n"));
        assertTrue(byConnection.contains("\t/b\n"));
    }

    @Test(expected = ClassCastException.class)
    public void dumpWatchesRejectsNonServerConnectionWatcher() {
        WatchManager manager = new WatchManager();
        manager.addWatch(PATH, new RecordingWatcher());
        dump(manager, true);
    }

    @Test
    public void containsWatcherHandlesModesAndMismatches() {
        WatchManager manager = new WatchManager();
        RecordingWatcher registered = new RecordingWatcher();
        RecordingWatcher other = new RecordingWatcher();
        manager.addWatch(PATH, registered, WatcherMode.PERSISTENT);

        assertTrue(manager.containsWatcher(PATH, registered));
        assertTrue(manager.containsWatcher(PATH, registered, null));
        assertTrue(manager.containsWatcher(PATH, registered, WatcherMode.PERSISTENT));
        assertFalse(manager.containsWatcher(PATH, registered, WatcherMode.STANDARD));
        assertFalse(manager.containsWatcher("/other", registered));
        assertFalse(manager.containsWatcher(PATH, other));
    }

    @Test
    public void removeWatcherByPathWithoutModeRemovesAllModesOnlyForThatPair() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/a", watcher));

        assertFalse(manager.containsWatcher("/a", watcher));
        assertTrue(manager.containsWatcher("/b", watcher));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.removeWatcher("/a", watcher));
    }

    @Test
    public void removeWatcherByPathAndModeLeavesOtherModesAndPairsIntact() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch("/a", watcher, WatcherMode.STANDARD);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT);
        manager.addWatch("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE);
        manager.addWatch("/b", watcher, WatcherMode.STANDARD);

        assertTrue(manager.removeWatcher("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertFalse(manager.containsWatcher("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE));
        assertTrue(manager.containsWatcher("/a", watcher, WatcherMode.STANDARD));
        assertTrue(manager.containsWatcher("/a", watcher, WatcherMode.PERSISTENT));
        assertTrue(manager.containsWatcher("/b", watcher));
        assertEquals(0, manager.getRecursiveWatchQty());
        assertFalse(manager.removeWatcher("/a", watcher, WatcherMode.PERSISTENT_RECURSIVE));
    }

    @Test
    public void reportsContainExpectedSessionAndPathMappings() throws Exception {
        WatchManager manager = new WatchManager();
        ServerCnxn first = liveConnection(101L);
        ServerCnxn second = liveConnection(202L);
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        Map<?, ?> watches = extractOnlyMap(manager.getWatches());
        assertEquals(new HashSet<>(Arrays.asList("/a", "/b")), watches.get(101L));
        assertEquals(Collections.singleton("/a"), watches.get(202L));

        Map<?, ?> byPath = extractOnlyMap(manager.getWatchesByPath());
        assertEquals(new HashSet<>(Arrays.asList(101L, 202L)), byPath.get("/a"));
        assertEquals(Collections.singleton(101L), byPath.get("/b"));
    }

    @Test
    public void watchesSummaryReportsConnectionsPathsAndWatches() throws Exception {
        WatchManager manager = new WatchManager();
        ServerCnxn first = liveConnection(1L);
        ServerCnxn second = liveConnection(2L);
        manager.addWatch("/a", first);
        manager.addWatch("/b", first);
        manager.addWatch("/a", second);

        List<Integer> values = extractIntFields(manager.getWatchesSummary());
        Collections.sort(values);
        assertEquals(Arrays.asList(2, 2, 3), values);
    }

    @Test
    public void shutdownIsAStatePreservingNoOp() {
        WatchManager manager = new WatchManager();
        RecordingWatcher watcher = new RecordingWatcher();
        manager.addWatch(PATH, watcher);

        manager.shutdown();

        assertEquals(1, manager.size());
        assertTrue(manager.containsWatcher(PATH, watcher));
    }

    private static ServerCnxn liveConnection(long sessionId) {
        ServerCnxn connection = mock(ServerCnxn.class);
        when(connection.isStale()).thenReturn(false);
        when(connection.getSessionId()).thenReturn(sessionId);
        return connection;
    }

    private static String dump(WatchManager manager, boolean byPath) {
        StringWriter buffer = new StringWriter();
        PrintWriter writer = new PrintWriter(buffer);
        manager.dumpWatches(writer, byPath);
        writer.flush();
        return buffer.toString().replace("\r\n", "\n");
    }

    private static Map<?, ?> extractOnlyMap(Object report) throws Exception {
        for (Class<?> type = report.getClass(); type != null; type = type.getSuperclass()) {
            for (Field field : type.getDeclaredFields()) {
                if (Map.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    return (Map<?, ?>) field.get(report);
                }
            }
        }
        fail("No Map field found in " + report.getClass().getName());
        return null;
    }

    private static List<Integer> extractIntFields(Object value) throws Exception {
        List<Integer> result = new ArrayList<>();
        for (Class<?> type = value.getClass(); type != null; type = type.getSuperclass()) {
            for (Field field : type.getDeclaredFields()) {
                if (field.getType() == int.class) {
                    field.setAccessible(true);
                    result.add(field.getInt(value));
                }
            }
        }
        return result;
    }
}
package org.apache.zookeeper.server.snapshotcomparer.variant_c4.llm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.DataTree;
import org.apache.zookeeper.server.SnapshotComparer;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.apache.zookeeper.txn.CreateTxn;
import org.apache.zookeeper.txn.TxnHeader;
import org.apache.zookeeper.util.ServiceUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>The tests exercise the class exclusively through its public
 * {@link SnapshotComparer#main(String[])} entry point and verify observable
 * standard-output, standard-error, exception, and exit-request behavior.
 * They do not use reflection, Unsafe, or private implementation details.</p>
 */
public class SnapshotComparerLLMZeroShotTest {

    private static final long SESSION_ID = 1L;
    private static final int CXID = 1;
    private static final long ZXID = 1L;
    private static final long TIME = 1L;

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private PrintStream originalOut;
    private PrintStream originalErr;
    private InputStream originalIn;

    private ByteArrayOutputStream capturedOut;
    private ByteArrayOutputStream capturedErr;

    @Before
    public void setUp() throws Exception {
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;

        capturedOut = new ByteArrayOutputStream();
        capturedErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(capturedOut, true, StandardCharsets.UTF_8.name()));
        System.setErr(new PrintStream(capturedErr, true, StandardCharsets.UTF_8.name()));
        System.setIn(new ByteArrayInputStream(new byte[0]));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);

        /*
         * Restore the production exit behavior in case a command-line parsing
         * test replaced it.
         */
        ServiceUtils.setSystemExitProcedure(System::exit);
    }

    @Test
    public void identicalSnapshotsProduceNoNodeDeltaInNormalMode() throws Exception {
        File left = createSnapshot(
                "identical-left",
                node("/application", bytes(3)),
                node("/application/config", bytes(5)),
                node("/application/workers", bytes(2)));

        File right = createSnapshot(
                "identical-right",
                node("/application", bytes(3)),
                node("/application/config", bytes(5)),
                node("/application/workers", bytes(2)));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Deserialized snapshot in " + left.getName()));
        assertTrue(output.contains("Deserialized snapshot in " + right.getName()));
        assertTrue(output.contains(
                "Printing analysis for nodes difference larger than 0 bytes "
                        + "or node count difference larger than 0."));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("All layers compared."));

        assertFalse(output.contains("found only in left tree"));
        assertFalse(output.contains("found only in right tree"));
        assertFalse(output.contains("found in both trees. Delta:"));
        assertFalse(output.contains("Filtered node"));
    }

    @Test
    public void reportsNodesPresentOnlyOnEachSide() throws Exception {
        File left = createSnapshot(
                "left-only",
                node("/common", bytes(1)),
                node("/leftOnly", bytes(4)),
                node("/leftOnly/child", bytes(3)));

        File right = createSnapshot(
                "right-only",
                node("/common", bytes(1)),
                node("/rightOnly", bytes(6)),
                node("/rightOnly/child", bytes(2)));

        SnapshotComparer.main(arguments(left, right, "-1", "-1"));

        String output = stdout();

        assertTrue(output.contains(
                "Node /leftOnly found only in left tree. "
                        + "Descendant size: 7. Descendant count: 1"));
        assertTrue(output.contains(
                "Node /rightOnly found only in right tree. "
                        + "Descendant size: 8. Descendant count: 1"));
        assertTrue(output.contains(
                "Node /leftOnly/child found only in left tree. "
                        + "Descendant size: 3. Descendant count: 0"));
        assertTrue(output.contains(
                "Node /rightOnly/child found only in right tree. "
                        + "Descendant size: 2. Descendant count: 0"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void reportsPositiveDataSizeDeltaForNodeFoundInBothTrees() throws Exception {
        File left = createSnapshot(
                "updated-left",
                node("/common", bytes(2)));

        File right = createSnapshot(
                "updated-right",
                node("/common", bytes(9)));

        SnapshotComparer.main(arguments(left, right, "6", "100"));

        String output = stdout();

        assertTrue(output.contains(
                "Node /common found in both trees. Delta: 7 bytes, 0 descendants"));
    }

    @Test
    public void reportsNegativeDataSizeDeltaForNodeFoundInBothTrees() throws Exception {
        File left = createSnapshot(
                "shrunk-left",
                node("/common", bytes(10)));

        File right = createSnapshot(
                "shrunk-right",
                node("/common", bytes(3)));

        SnapshotComparer.main(arguments(left, right, "6", "100"));

        String output = stdout();

        assertTrue(output.contains(
                "Node /common found in both trees. Delta: -7 bytes, 0 descendants"));
    }

    @Test
    public void reportsDescendantCountDeltaIndependentlyOfByteDelta() throws Exception {
        File left = createSnapshot(
                "count-left",
                node("/common", bytes(0)),
                node("/common/one", bytes(0)));

        File right = createSnapshot(
                "count-right",
                node("/common", bytes(0)),
                node("/common/one", bytes(0)),
                node("/common/two", bytes(0)),
                node("/common/three", bytes(0)));

        SnapshotComparer.main(arguments(left, right, "100", "1"));

        String output = stdout();

        assertTrue(output.contains(
                "Node /common found in both trees. Delta: 0 bytes, 2 descendants"));
    }

    @Test
    public void thresholdComparisonIsStrictlyGreaterThan() throws Exception {
        File left = createSnapshot(
                "boundary-left",
                node("/common", bytes(2)));

        File right = createSnapshot(
                "boundary-right",
                node("/common", bytes(7)));

        SnapshotComparer.main(arguments(left, right, "5", "0"));

        String output = stdout();

        assertFalse(output.contains(
                "Node /common found in both trees. Delta: 5 bytes, 0 descendants"));
        assertFalse(output.contains("Filtered node /common"));
    }

    @Test
    public void debugModePrintsFilteredNodesAndComparisonDiagnostics() throws Exception {
        File left = createSnapshot(
                "debug-left",
                node("/common", bytes(2)),
                node("/leftOnly", bytes(1)));

        File right = createSnapshot(
                "debug-right",
                node("/common", bytes(2)),
                node("/rightOnly", bytes(1)));

        SnapshotComparer.main(arguments(left, right, "100", "100", "--debug"));

        String output = stdout();

        assertTrue(output.contains("Comparing "));
        assertTrue(output.contains("same"));
        assertTrue(output.contains("left is less")
                || output.contains("right is less"));

        assertTrue(output.contains(
                "Filtered node /common of left size 2, right size 2"));
        assertTrue(output.contains(
                "Filtered left node /leftOnly of size 1"));
        assertTrue(output.contains(
                "Filtered right node /rightOnly of size 1"));

        assertFalse(output.contains("Node /leftOnly found only in left tree"));
        assertFalse(output.contains("Node /rightOnly found only in right tree"));
    }

    @Test
    public void interactiveEnterPrintsCurrentDepthAndAdvancesUntilComplete()
            throws Exception {
        File left = createSnapshot(
                "interactive-left",
                node("/a", bytes(1)));

        File right = createSnapshot(
                "interactive-right",
                node("/a", bytes(1)));

        /* Modified in order to solve the failure
        System.setIn(new ByteArrayInputStream(
                "\n\n".getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                repeatedNewlines(32)
                        .getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "100",
                "100",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Current depth is 0"));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Current depth is 1"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Filtered node /a of left size 1, right size 1"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveAbsolutePathComparesImmediateSubtree() throws Exception {
        File left = createSnapshot(
                "subtree-left",
                node("/parent", bytes(0)),
                node("/parent/common", bytes(1)),
                node("/parent/leftChild", bytes(4)));

        File right = createSnapshot(
                "subtree-right",
                node("/parent", bytes(0)),
                node("/parent/common", bytes(1)),
                node("/parent/rightChild", bytes(5)));

        System.setIn(new ByteArrayInputStream(
                ("/parent\n\n\n\n").getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "-1",
                "-1",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for node /parent"));
        assertTrue(output.contains(
                "Node /parent/leftChild found only in left tree. "
                        + "Descendant size: 4. Descendant count: 0"));
        assertTrue(output.contains(
                "Node /parent/rightChild found only in right tree. "
                        + "Descendant size: 5. Descendant count: 0"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveUnknownPathPrintsNotFoundMessage() throws Exception {
        File left = createSnapshot(
                "missing-path-left",
                node("/known", bytes(1)));

        File right = createSnapshot(
                "missing-path-right",
                node("/known", bytes(1)));

        /* Modified in order to solve the failure
        System.setIn(new ByteArrayInputStream(
                ("/missing\n\n\n").getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                ("/missing\n" + repeatedNewlines(32))
                        .getBytes(StandardCharsets.UTF_8)));



        SnapshotComparer.main(arguments(
                left,
                right,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for node /missing"));
        assertTrue(output.contains(
                "Path /missing is neither found in left tree nor right tree."));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveOutOfRangeDepthPrintsRangeAndKeepsCurrentDepth()
            throws Exception {
        File left = createSnapshot(
                "range-left",
                node("/a", bytes(1)));

        File right = createSnapshot(
                "range-right",
                node("/a", bytes(1)));

        /* Modified in order to solve the failure
        System.setIn(new ByteArrayInputStream(
                ("99\n\n\n").getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                ("99\n" + repeatedNewlines(32)).getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        // assertTrue(output.contains("Depth must be in range [0, 1]"));
        assertTrue(output.contains("Depth must be in range [0, 2]"));
        assertTrue(countOccurrences(output, "Current depth is 0") >= 2);
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveNegativeDepthPrintsRangeError() throws Exception {
        File left = createSnapshot(
                "negative-depth-left",
                node("/a", bytes(1)));

        File right = createSnapshot(
                "negative-depth-right",
                node("/a", bytes(1)));

        /* Modified in order to resolve the failure
        System.setIn(new ByteArrayInputStream(
                ("-1\n\n\n").getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                ("-1\n" + repeatedNewlines(32))
                        .getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "0",
                "0",
                "--interactive"));

        // assertTrue(stdout().contains("Depth must be in range [0, 1]"));
        assertTrue(stdout().contains("Depth must be in range [0, 2]"));
    }

    @Test
    public void interactiveNonNumericNonPathInputPrintsValidationMessage()
            throws Exception {
        File left = createSnapshot(
                "invalid-input-left",
                node("/a", bytes(1)));

        File right = createSnapshot(
                "invalid-input-right",
                node("/a", bytes(1)));

        /* Modified in order to solve the failure
        System.setIn(new ByteArrayInputStream(
                ("not-a-depth\n\n\n").getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                ("not-a-depth\n" + repeatedNewlines(32))
                        .getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        /* assertTrue(output.contains(
                "Input not-a-depth is not valid. Depth must be in range [0, 1]. "
                        + "Path must be an absolute path which starts with '/'.")); */

        assertTrue(output.contains(
                "Input not-a-depth is not valid. Depth must be in range [0, 2]. "
                        + "Path must be an absolute path which starts with '/'."));

        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveValidDepthJumpPrintsRequestedDepth() throws Exception {
        File left = createSnapshot(
                "jump-left",
                node("/a", bytes(1)),
                node("/a/b", bytes(2)));

        File right = createSnapshot(
                "jump-right",
                node("/a", bytes(1)),
                node("/a/b", bytes(2)));

        System.setIn(new ByteArrayInputStream(
                ("2\n\n").getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(
                left,
                right,
                "100",
                "100",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for depth 2"));
        assertTrue(output.contains(
                "Filtered node /a/b of left size 2, right size 2"));
        assertTrue(output.contains("Current depth is 2"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void missingRequiredArgumentsPrintsErrorAndUsageAndRequestsInvalidExit()
            throws Exception {
        final int[] requestedExitCode = {Integer.MIN_VALUE};

        ServiceUtils.setSystemExitProcedure(code -> requestedExitCode[0] = code);

        SnapshotComparer.main(new String[0]);

        String error = stderr();
        String output = stdout();

        assertTrue(error.contains("Missing required option"));
        assertTrue(output.contains("usage:"));
        assertTrue(output.contains("--left"));
        assertTrue(output.contains("--right"));
        assertTrue(output.contains("--bytes"));
        assertTrue(output.contains("--nodes"));
        assertTrue(output.contains("--debug"));
        assertTrue(output.contains("--interactive"));
        assertTrue(requestedExitCode[0] != Integer.MIN_VALUE);
        assertFalse(output.contains("Successfully parsed options!"));
    }

    @Test
    public void unknownOptionPrintsErrorAndRequestsInvalidExit() throws Exception {
        final int[] requestedExitCode = {Integer.MIN_VALUE};

        ServiceUtils.setSystemExitProcedure(code -> requestedExitCode[0] = code);

        SnapshotComparer.main(new String[] {"--unknown"});

        assertTrue(stderr().contains("Unrecognized option: --unknown"));
        assertTrue(stdout().contains("usage:"));
        assertTrue(requestedExitCode[0] != Integer.MIN_VALUE);
        assertFalse(stdout().contains("Successfully parsed options!"));
    }

    @Test
    public void nonIntegerByteThresholdPropagatesNumberFormatException()
            throws Exception {
        File left = createSnapshot("bad-byte-left", node("/a", bytes(1)));
        File right = createSnapshot("bad-byte-right", node("/a", bytes(1)));

        assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(arguments(
                        left,
                        right,
                        "not-an-integer",
                        "0")));

        assertFalse(stdout().contains("Successfully parsed options!"));
    }

    @Test
    public void nonIntegerNodeThresholdPropagatesNumberFormatException()
            throws Exception {
        File left = createSnapshot("bad-node-left", node("/a", bytes(1)));
        File right = createSnapshot("bad-node-right", node("/a", bytes(1)));

        assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(arguments(
                        left,
                        right,
                        "0",
                        "not-an-integer")));

        assertFalse(stdout().contains("Successfully parsed options!"));
    }

    @Test
    public void nonexistentSnapshotPropagatesReadFailure() throws Exception {
        File valid = createSnapshot(
                "valid-snapshot",
                node("/a", bytes(1)));

        File nonexistent = new File(
                temporaryFolder.getRoot(),
                "snapshot-that-does-not-exist");

        assertThrows(
                Exception.class,
                () -> SnapshotComparer.main(arguments(
                        nonexistent,
                        valid,
                        "0",
                        "0")));

        assertTrue(stdout().contains("Successfully parsed options!"));
        assertFalse(stdout().contains("All layers compared."));
    }

    @Test
    public void corruptSnapshotPropagatesDeserializationFailure() throws Exception {
        File corrupt = temporaryFolder.newFile("corrupt-snapshot");
        java.nio.file.Files.write(
                corrupt.toPath(),
                "not a ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));

        File valid = createSnapshot(
                "valid-for-corrupt-test",
                node("/a", bytes(1)));

        assertThrows(
                Exception.class,
                () -> SnapshotComparer.main(arguments(
                        corrupt,
                        valid,
                        "0",
                        "0")));

        assertTrue(stdout().contains("Successfully parsed options!"));
        assertFalse(stdout().contains("All layers compared."));
    }

    private File createSnapshot(String directoryName, NodeSpec... nodes)
            throws Exception {
        File directory = temporaryFolder.newFolder(directoryName);
        File snapshot = new File(directory, "snapshot.1");

        DataTree tree = new DataTree();
        long zxid = ZXID;

        for (NodeSpec node : nodes) {
            createNode(tree, node.path, node.data, zxid++);
        }

        tree.lastProcessedZxid = Math.max(ZXID, zxid - 1);

        Map<Long, Integer> sessions = new HashMap<>();
        FileSnap fileSnap = new FileSnap(directory);
        try {
            fileSnap.serialize(tree, sessions, snapshot, false);
        } finally {
            fileSnap.close();
        }

        assertTrue("Snapshot should have been created", snapshot.isFile());
        return snapshot;
    }

    private static void createNode(
            DataTree tree,
            String path,
            byte[] data,
            long zxid) {
        TxnHeader header = new TxnHeader(
                SESSION_ID,
                CXID,
                zxid,
                TIME,
                ZooDefs.OpCode.create);

        CreateTxn transaction = new CreateTxn(
                path,
                data,
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                false,
                0);

        tree.processTxn(header, transaction);
    }

    private static String[] arguments(
            File left,
            File right,
            String byteThreshold,
            String nodeThreshold,
            String... additionalOptions) {
        String[] arguments = new String[8 + additionalOptions.length];

        arguments[0] = "--left";
        arguments[1] = left.getAbsolutePath();
        arguments[2] = "--right";
        arguments[3] = right.getAbsolutePath();
        arguments[4] = "--bytes";
        arguments[5] = byteThreshold;
        arguments[6] = "--nodes";
        arguments[7] = nodeThreshold;

        System.arraycopy(
                additionalOptions,
                0,
                arguments,
                8,
                additionalOptions.length);

        return arguments;
    }

    private String stdout() {
        return new String(capturedOut.toByteArray(), StandardCharsets.UTF_8);
    }

    private String stderr() {
        return new String(capturedErr.toByteArray(), StandardCharsets.UTF_8);
    }

    private static int countOccurrences(String text, String fragment) {
        int count = 0;
        int position = 0;

        while ((position = text.indexOf(fragment, position)) >= 0) {
            count++;
            position += fragment.length();
        }

        return count;
    }

    private static byte[] bytes(int length) {
        return new byte[length];
    }

    private static NodeSpec node(String path, byte[] data) {
        return new NodeSpec(path, data);
    }

    private static final class NodeSpec {

        private final String path;
        private final byte[] data;

        private NodeSpec(String path, byte[] data) {
            this.path = path;
            this.data = data;
        }
    }

    // Added in order to solve the failures
    private static String repeatedNewlines(int count) {
        StringBuilder input = new StringBuilder(count);

        for (int index = 0; index < count; index++) {
            input.append('\n');
        }

        return input.toString();
    }
}
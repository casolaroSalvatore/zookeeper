package org.apache.zookeeper.server.snapshotcomparer.variant_c1.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.zookeeper.ZooDefs;
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
 * <p>These tests exercise the publicly observable command-line behavior through
 * {@link SnapshotComparer#main(String[])}. They intentionally avoid reflection,
 * Unsafe, and dependencies on private implementation details.
 */
public class SnapshotComparerLLMZeroShotTest {

    private static final long NO_EPHEMERAL_OWNER = 0L;

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private PrintStream originalOut;
    private PrintStream originalErr;
    private java.io.InputStream originalIn;

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

        /*
         * SnapshotComparer requests a process exit for invalid command lines.
         * Replace the process-level action with ZooKeeper's documented no-op
         * strategy so the JVM running the test suite is not terminated.
         */
        ServiceUtils.setSystemExitProcedure(ServiceUtils.LOG_ONLY);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
        ServiceUtils.setSystemExitProcedure(ServiceUtils.SYSTEM_EXIT);
    }

    @Test
    public void missingRequiredOptionsPrintsErrorAndUsage() throws Exception {
        final AtomicInteger requestedExitCode = new AtomicInteger(Integer.MIN_VALUE);
        ServiceUtils.setSystemExitProcedure(requestedExitCode::set);

        SnapshotComparer.main(new String[0]);

        String stderr = stderr();
        String stdout = stdout();
        String combined = stderr + stdout;

        assertEquals(
                "An invalid invocation must request the documented exit code",
                ExitCode.INVALID_INVOCATION.getValue(),
                requestedExitCode.get());

        assertTrue(
                "The missing-options diagnostic should be printed",
                combined.contains("Missing required option")
                        || combined.contains("Missing required options"));

        assertTrue(
                "Usage should identify the SnapshotComparer entry point",
                combined.contains(SnapshotComparer.class.getName()));

        assertTrue(combined.contains("-l"));
        assertTrue(combined.contains("--left"));
        assertTrue(combined.contains("-r"));
        assertTrue(combined.contains("--right"));
        assertTrue(combined.contains("-b"));
        assertTrue(combined.contains("--bytes"));
        assertTrue(combined.contains("-n"));
        assertTrue(combined.contains("--nodes"));
        assertTrue(combined.contains("-d"));
        assertTrue(combined.contains("--debug"));
        assertTrue(combined.contains("-i"));
        assertTrue(combined.contains("--interactive"));
    }

    @Test
    public void unknownOptionPrintsErrorAndRequestsInvalidInvocationExit() throws Exception {
        final AtomicInteger requestedExitCode = new AtomicInteger(Integer.MIN_VALUE);
        ServiceUtils.setSystemExitProcedure(requestedExitCode::set);

        SnapshotComparer.main(new String[] {"--not-a-real-option"});

        String combined = stdout() + stderr();

        assertEquals(
                ExitCode.INVALID_INVOCATION.getValue(),
                requestedExitCode.get());
        assertTrue(combined.contains("not-a-real-option"));
        assertTrue(combined.contains(SnapshotComparer.class.getName()));
    }

    @Test(expected = NumberFormatException.class)
    public void nonIntegerByteThresholdIsRejectedBeforeSnapshotsAreRead() throws Exception {
        SnapshotComparer.main(
                new String[] {
                    "--left", new File(temporaryFolder.getRoot(), "left").getAbsolutePath(),
                    "--right", new File(temporaryFolder.getRoot(), "right").getAbsolutePath(),
                    "--bytes", "not-an-integer",
                    "--nodes", "0"
                });
    }

    @Test(expected = NumberFormatException.class)
    public void nonIntegerNodeThresholdIsRejectedBeforeSnapshotsAreRead() throws Exception {
        SnapshotComparer.main(
                new String[] {
                    "--left", new File(temporaryFolder.getRoot(), "left").getAbsolutePath(),
                    "--right", new File(temporaryFolder.getRoot(), "right").getAbsolutePath(),
                    "--bytes", "0",
                    "--nodes", "NaN"
                });
    }

    @Test
    public void identicalSnapshotsProduceNoAddedDeletedOrChangedNodes() throws Exception {
        DataTree tree = new DataTree();
        createPersistentNode(tree, "/application", bytes("abc"), 1L);
        createPersistentNode(tree, "/application/config", bytes("value"), 2L);

        File left = writeSnapshot("identical-left", tree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("identical-right", tree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Node count:"));
        assertTrue(output.contains("Total size:"));
        assertTrue(output.contains("Max depth:"));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("All layers compared."));

        assertFalse(output.contains("found only in left tree"));
        assertFalse(output.contains("found only in right tree"));
        assertFalse(output.contains("found in both trees. Delta:"));
    }

    @Test
    public void reportsNodesPresentOnlyInLeftAndOnlyInRightSnapshots() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/left-only", bytes("left payload"), 1L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/right-only", bytes("right payload"), 1L);

        File left = writeSnapshot("left-only-tree", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("right-only-tree", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        String output = stdout();

        assertTrue(output.contains("Node /left-only found only in left tree."));
        assertTrue(output.contains("Node /right-only found only in right tree."));
        assertTrue(output.contains("Descendant size: 12. Descendant count: 0"));
        assertTrue(output.contains("Descendant size: 13. Descendant count: 0"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void reportsPositiveDataSizeDeltaForNodeFoundInBothTrees() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/changed", bytes("ab"), 1L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/changed", bytes("abcdef"), 1L);

        File left = writeSnapshot("changed-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("changed-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        assertTrue(
                stdout().contains(
                        "Node /changed found in both trees. Delta: 4 bytes, 0 descendants"));
    }

    @Test
    public void reportsNegativeDataSizeDeltaWhenRightSnapshotIsSmaller() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/changed", bytes("12345678"), 1L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/changed", bytes("12"), 1L);

        File left = writeSnapshot("shrinking-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("shrinking-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        assertTrue(
                stdout().contains(
                        "Node /changed found in both trees. Delta: -6 bytes, 0 descendants"));
    }

    @Test
    public void reportsDescendantCountAndAggregateSizeDelta() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/parent", bytes("p"), 1L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/parent", bytes("p"), 1L);
        createPersistentNode(rightTree, "/parent/child", bytes("child"), 2L);
        createPersistentNode(rightTree, "/parent/child/grandchild", bytes("g"), 3L);

        File left = writeSnapshot("descendants-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("descendants-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        String output = stdout();

        assertTrue(
                output.contains(
                        "Node /parent found in both trees. Delta: 6 bytes, 2 descendants"));
        assertTrue(output.contains("Node /parent/child found only in right tree."));
        assertTrue(output.contains("Descendant size: 6. Descendant count: 1"));
        assertTrue(output.contains("Node /parent/child/grandchild found only in right tree."));
    }

    @Test
    public void thresholdsAreStrictAndEqualDeltasAreFiltered() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/changed", bytes("ab"), 1L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/changed", bytes("abcdef"), 1L);

        File left = writeSnapshot("threshold-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("threshold-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 4, 0);

        String output = stdout();

        assertTrue(
                output.contains(
                        "Printing analysis for nodes difference larger than 4 bytes "
                                + "or node count difference larger than 0."));
        assertFalse(output.contains("Node /changed found in both trees. Delta:"));
        assertFalse(output.contains("Filtered node /changed"));
    }

    @Test
    public void debugModeExplainsFilteredAndComparisonResults() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/alpha", bytes("same"), 1L);
        createPersistentNode(leftTree, "/left", bytes("x"), 2L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/alpha", bytes("same"), 1L);
        createPersistentNode(rightTree, "/right", bytes("y"), 2L);

        File left = writeSnapshot("debug-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("debug-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 100, 100, "--debug");

        String output = stdout();

        assertTrue(output.contains("Comparing /alpha to /alpha"));
        assertTrue(output.contains("same"));
        assertTrue(output.contains("Filtered node /alpha of left size 4, right size 4"));

        assertTrue(output.contains("Comparing /left to /right"));
        assertTrue(output.contains("left is less"));
        assertTrue(output.contains("Filtered left node /left of size 1"));
        assertTrue(output.contains("Filtered right node /right of size 1"));

        assertFalse(output.contains("Node /left found only in left tree."));
        assertFalse(output.contains("Node /right found only in right tree."));
    }

    @Test
    public void outputIsAlphabeticallyOrderedRegardlessOfInsertionOrder() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/zulu", bytes("z"), 1L);
        createPersistentNode(leftTree, "/alpha", bytes("a"), 2L);
        createPersistentNode(leftTree, "/middle", bytes("m"), 3L);

        DataTree rightTree = new DataTree();

        File left = writeSnapshot("ordering-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("ordering-right", rightTree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, 0, 0);

        String output = stdout();
        int alphaIndex = output.indexOf("Node /alpha found only in left tree.");
        int middleIndex = output.indexOf("Node /middle found only in left tree.");
        int zuluIndex = output.indexOf("Node /zulu found only in left tree.");

        assertTrue(alphaIndex >= 0);
        assertTrue(middleIndex > alphaIndex);
        assertTrue(zuluIndex > middleIndex);
    }

    @Test
    public void negativeThresholdsCauseEvenZeroDeltasToBePrinted() throws Exception {
        DataTree tree = new DataTree();
        createPersistentNode(tree, "/same", bytes("same"), 1L);

        File left = writeSnapshot("negative-threshold-left", tree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("negative-threshold-right", tree, Collections.<Long, Integer>emptyMap());

        runComparer(left, right, -1, -1);

        assertTrue(
                stdout().contains(
                        "Node /same found in both trees. Delta: 0 bytes, 0 descendants"));
    }

    @Test
    public void interactiveModeSupportsSubtreeQueriesAndMissingPaths() throws Exception {
        DataTree leftTree = new DataTree();
        createPersistentNode(leftTree, "/parent", bytes("p"), 1L);
        createPersistentNode(leftTree, "/parent/left-child", bytes("l"), 2L);

        DataTree rightTree = new DataTree();
        createPersistentNode(rightTree, "/parent", bytes("p"), 1L);
        createPersistentNode(rightTree, "/parent/right-child", bytes("r"), 2L);

        File left = writeSnapshot("interactive-left", leftTree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("interactive-right", rightTree, Collections.<Long, Integer>emptyMap());

        /*
         * Query a valid subtree, query a missing subtree, then provide enough
         * empty lines to advance through every depth and terminate naturally.
         */
        setInput("/parent\n/missing\n\n\n\n\n\n");

        runComparer(left, right, 0, 0, "--interactive");

        String output = stdout();

        assertTrue(output.contains("Current depth is 0"));
        assertTrue(output.contains("Analysis for node /parent"));
        assertTrue(output.contains("Node /parent/left-child found only in left tree."));
        assertTrue(output.contains("Node /parent/right-child found only in right tree."));
        assertTrue(output.contains("Analysis for node /missing"));
        assertTrue(
                output.contains(
                        "Path /missing is neither found in left tree nor right tree."));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeRejectsMalformedAndOutOfRangeDepths() throws Exception {
        DataTree tree = new DataTree();
        createPersistentNode(tree, "/node", bytes("data"), 1L);

        File left = writeSnapshot("interactive-validation-left", tree,
                Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("interactive-validation-right", tree,
                Collections.<Long, Integer>emptyMap());

        setInput("not-a-depth\n-1\n999\n\n\n\n\n");

        runComparer(left, right, 100, 100, "--interactive");

        String output = stdout();

        assertTrue(output.contains("Input not-a-depth is not valid."));
        assertTrue(output.contains("Path must be an absolute path which starts with '/'."));
        assertTrue(output.contains("Depth must be in range [0,"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveNumericInputPrintsRequestedDepth() throws Exception {
        DataTree tree = new DataTree();
        createPersistentNode(tree, "/parent", bytes("p"), 1L);
        createPersistentNode(tree, "/parent/child", bytes("c"), 2L);

        File left = writeSnapshot("interactive-jump-left", tree,
                Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("interactive-jump-right", tree,
                Collections.<Long, Integer>emptyMap());

        /*
         * Jump to depth 1, after which empty lines advance through the
         * remaining depths.
         */
        setInput("1\n\n\n\n\n");

        runComparer(left, right, 100, 100, "--interactive");

        String output = stdout();

        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Filtered node /parent"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void longAndShortOptionFormsHaveEquivalentObservableBehavior() throws Exception {
        DataTree tree = new DataTree();
        createPersistentNode(tree, "/node", bytes("data"), 1L);

        File left = writeSnapshot("option-left", tree, Collections.<Long, Integer>emptyMap());
        File right = writeSnapshot("option-right", tree, Collections.<Long, Integer>emptyMap());

        SnapshotComparer.main(
                new String[] {
                    "-l", left.getAbsolutePath(),
                    "-r", right.getAbsolutePath(),
                    "-b", "100",
                    "-n", "100",
                    "-d"
                });

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Filtered node /node"));
        assertTrue(output.contains("All layers compared."));
    }

    private void runComparer(
            File left,
            File right,
            int byteThreshold,
            int nodeThreshold,
            String... additionalArguments) throws Exception {

        String[] arguments = new String[8 + additionalArguments.length];
        arguments[0] = "--left";
        arguments[1] = left.getAbsolutePath();
        arguments[2] = "--right";
        arguments[3] = right.getAbsolutePath();
        arguments[4] = "--bytes";
        arguments[5] = Integer.toString(byteThreshold);
        arguments[6] = "--nodes";
        arguments[7] = Integer.toString(nodeThreshold);

        System.arraycopy(
                additionalArguments,
                0,
                arguments,
                8,
                additionalArguments.length);

        SnapshotComparer.main(arguments);
    }

    private File writeSnapshot(
            String directoryName,
            DataTree tree,
            Map<Long, Integer> sessions) throws Exception {

        File directory = temporaryFolder.newFolder(directoryName);
        File snapshot = new File(directory, "snapshot.1");

        FileSnap fileSnap = new FileSnap(directory);
        try {
            fileSnap.serialize(tree, sessions, snapshot, false);
        } finally {
            fileSnap.close();
        }

        assertTrue("Snapshot should have been created", snapshot.isFile());
        assertTrue("Snapshot should not be empty", snapshot.length() > 0L);
        return snapshot;
    }

    private void createPersistentNode(
            DataTree tree,
            String path,
            byte[] data,
            long zxid) {

        TxnHeader header = new TxnHeader(
                1L,
                (int) zxid,
                zxid,
                System.currentTimeMillis(),
                ZooDefs.OpCode.create);

        CreateTxn transaction = new CreateTxn(
                path,
                data,
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                false,
                0);

        tree.processTxn(header, transaction);
    }

    private void setInput(String text) {
        System.setIn(
                new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)));
    }

    private String stdout() throws Exception {
        System.out.flush();
        return capturedOut.toString(StandardCharsets.UTF_8.name());
    }

    private String stderr() throws Exception {
        System.err.flush();
        return capturedErr.toString(StandardCharsets.UTF_8.name());
    }

    private static byte[] bytes(String value) {
        return value.getBytes(StandardCharsets.UTF_8);
    }
}
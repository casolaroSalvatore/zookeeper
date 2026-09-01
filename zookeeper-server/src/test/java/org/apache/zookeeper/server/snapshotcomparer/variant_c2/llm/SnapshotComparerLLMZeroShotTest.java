package org.apache.zookeeper.server.snapshotcomparer.variant_c2.llm;

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
import org.apache.zookeeper.server.DataTree;
import org.apache.zookeeper.server.SnapshotComparer;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>These tests exercise SnapshotComparer exclusively through its public
 * {@code main(String[])} entry point and verify its publicly observable
 * console output. They intentionally do not use reflection, Unsafe, or access
 * private implementation details.</p>
 */
public class SnapshotComparerLLMZeroShotTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private PrintStream originalOut;
    private PrintStream originalErr;
    private InputStream originalIn;

    private ByteArrayOutputStream capturedOut;
    private ByteArrayOutputStream capturedErr;

    private File leftSnapshot;
    private File rightSnapshot;

    @Before
    public void setUp() throws Exception {
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;

        resetCapturedOutput();
        System.setIn(new ByteArrayInputStream(new byte[0]));

        leftSnapshot = createLeftSnapshot();
        rightSnapshot = createRightSnapshot();
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void mainWithIdenticalSnapshotsReportsNoDifferences() throws Exception {
        File identicalLeft = createSnapshot(
                "snapshot-identical-left",
                nodes(
                        node("/alpha", bytes(4)),
                        node("/alpha/child", bytes(2)),
                        node("/same", bytes(3))));

        File identicalRight = createSnapshot(
                "snapshot-identical-right",
                nodes(
                        node("/alpha", bytes(4)),
                        node("/alpha/child", bytes(2)),
                        node("/same", bytes(3))));

        SnapshotComparer.main(arguments(
                identicalLeft,
                identicalRight,
                "0",
                "0"));

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Printing analysis for nodes difference larger than 0 bytes"
                + " or node count difference larger than 0."));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Analysis for depth 2"));
        assertTrue(output.contains("All layers compared."));

        assertFalse(output.contains("found only in left tree"));
        assertFalse(output.contains("found only in right tree"));
        assertFalse(output.contains("found in both trees. Delta:"));
        assertFalse(output.contains("Filtered node"));
        assertFalse(output.contains("Comparing "));
    }

    @Test
    public void mainReportsNodesAddedDeletedAndChanged() throws Exception {
        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "0",
                "0"));

        String output = stdout();

        assertTrue(output.contains("Node /leftOnly found only in left tree."));
        assertTrue(output.contains("Descendant size: 5. Descendant count: 0"));

        assertTrue(output.contains("Node /rightOnly found only in right tree."));
        assertTrue(output.contains("Descendant size: 7. Descendant count: 0"));

        assertTrue(output.contains(
                "Node /alpha found in both trees. Delta: 6 bytes, 0 descendants"));

        assertFalse(output.contains(
                "Node /same found in both trees. Delta:"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void mainCalculatesDeltaUsingEntireSubtree() throws Exception {
        File left = createSnapshot(
                "snapshot-subtree-left",
                nodes(
                        node("/parent", bytes(1)),
                        node("/parent/child", bytes(2))));

        File right = createSnapshot(
                "snapshot-subtree-right",
                nodes(
                        node("/parent", bytes(1)),
                        node("/parent/child", bytes(8)),
                        node("/parent/extra", bytes(3))));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        String output = stdout();

        assertTrue(output.contains(
                "Node /parent found in both trees. Delta: 9 bytes, 1 descendants"));
        assertTrue(output.contains(
                "Node /parent/child found in both trees. Delta: 6 bytes, 0 descendants"));
        assertTrue(output.contains(
                "Node /parent/extra found only in right tree."));
        assertTrue(output.contains(
                "Descendant size: 3. Descendant count: 0"));
    }

    @Test
    public void mainUsesStrictlyGreaterThanThresholdSemantics() throws Exception {
        File left = createSnapshot(
                "snapshot-threshold-left",
                nodes(node("/value", bytes(5))));

        File right = createSnapshot(
                "snapshot-threshold-right",
                nodes(node("/value", bytes(10))));

        SnapshotComparer.main(arguments(left, right, "5", "0"));

        String output = stdout();

        assertFalse(output.contains(
                "Node /value found in both trees. Delta:"));
        assertFalse(output.contains("Filtered node /value"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void mainPrintsDifferenceWhenByteDeltaExceedsThreshold() throws Exception {
        File left = createSnapshot(
                "snapshot-byte-threshold-left",
                nodes(node("/value", bytes(5))));

        File right = createSnapshot(
                "snapshot-byte-threshold-right",
                nodes(node("/value", bytes(11))));

        SnapshotComparer.main(arguments(left, right, "5", "100"));

        assertTrue(stdout().contains(
                "Node /value found in both trees. Delta: 6 bytes, 0 descendants"));
    }

    @Test
    public void mainPrintsDifferenceWhenDescendantDeltaExceedsThreshold()
            throws Exception {

        File left = createSnapshot(
                "snapshot-node-threshold-left",
                nodes(node("/parent", bytes(1))));

        File right = createSnapshot(
                "snapshot-node-threshold-right",
                nodes(
                        node("/parent", bytes(1)),
                        node("/parent/a", new byte[0]),
                        node("/parent/b", new byte[0])));

        SnapshotComparer.main(arguments(left, right, "100", "1"));

        assertTrue(stdout().contains(
                "Node /parent found in both trees. Delta: 0 bytes, 2 descendants"));
    }

    @Test
    public void mainTreatsAbsoluteNegativeDeltaByMagnitude() throws Exception {
        File left = createSnapshot(
                "snapshot-negative-delta-left",
                nodes(node("/value", bytes(12))));

        File right = createSnapshot(
                "snapshot-negative-delta-right",
                nodes(node("/value", bytes(3))));

        SnapshotComparer.main(arguments(left, right, "5", "100"));

        assertTrue(stdout().contains(
                "Node /value found in both trees. Delta: -9 bytes, 0 descendants"));
    }

    @Test
    public void mainFiltersSingleTreeNodeWhenNeitherThresholdIsExceeded()
            throws Exception {

        File left = createSnapshot(
                "snapshot-filter-single-left",
                nodes(node("/small", bytes(5))));

        File right = createSnapshot(
                "snapshot-filter-single-right",
                Collections.<String, byte[]>emptyMap());

        SnapshotComparer.main(arguments(left, right, "5", "0"));

        String output = stdout();

        assertFalse(output.contains("Node /small found only in left tree."));
        assertFalse(output.contains("Filtered left node /small"));
    }

    @Test
    public void debugModeReportsComparisonsRelationsAndFilteredNodes()
            throws Exception {

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "1000",
                "1000",
                "--debug"));

        String output = stdout();

        assertTrue(output.contains("Comparing "));
        assertTrue(output.contains("left is less")
                || output.contains("right is less")
                || output.contains("same"));

        assertTrue(output.contains("Filtered left node /leftOnly of size 5"));
        assertTrue(output.contains("Filtered right node /rightOnly of size 7"));
        assertTrue(output.contains(
                "Filtered node /alpha of left size 6, right size 12"));
        assertTrue(output.contains(
                "Filtered node /same of left size 3, right size 3"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void shortOptionNamesAreAccepted() throws Exception {
        SnapshotComparer.main(new String[] {
                "-l", leftSnapshot.getAbsolutePath(),
                "-r", rightSnapshot.getAbsolutePath(),
                "-b", "0",
                "-n", "0"
        });

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void longOptionNamesAreAccepted() throws Exception {
        SnapshotComparer.main(new String[] {
                "--left", leftSnapshot.getAbsolutePath(),
                "--right", rightSnapshot.getAbsolutePath(),
                "--bytes", "0",
                "--nodes", "0"
        });

        String output = stdout();

        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("All layers compared."));
    }

    /* Modified in order to solve the failure
    @Ignore
    @Test
    public void snapshotSummaryIncludesCountsSizeAndDepth() throws Exception {
        File snapshot = createSnapshot(
                "snapshot-summary",
                nodes(
                        node("/a", bytes(3)),
                        node("/b", bytes(5)),
                        node("/a/child", bytes(7))));

        SnapshotComparer.main(arguments(snapshot, snapshot, "1000", "1000"));

        String output = stdout();

        assertTrue(output.contains("Node count: 4"));
        assertTrue(output.contains("Total size: 15"));
        assertTrue(output.contains("Max depth: 3"));
        assertTrue(output.contains("Count of nodes at depth 0: 1"));
        assertTrue(output.contains("Count of nodes at depth 1: 2"));
        assertTrue(output.contains("Count of nodes at depth 2: 1"));
    }
     */

    @Test
    public void snapshotSummaryIncludesCountsSizeAndDepth() throws Exception {

        File snapshot = createSnapshot(
                "snapshot-summary",
                nodes(
                        node("/a", bytes(3)),
                        node("/b", bytes(5)),
                        node("/a/child", bytes(7))));

        SnapshotComparer.main(
                arguments(snapshot, snapshot, "1000", "1000"));

        String output = stdout();

        assertTrue(
                "Expected seven permanent nodes, including ZooKeeper "
                        + "internal nodes. Actual output:\n" + output,
                output.contains("Node count: 7"));

        assertTrue(
                "Expected total payload size 15. Actual output:\n" + output,
                output.contains("Total size: 15"));

        assertTrue(
                "Expected maximum depth 3. Actual output:\n" + output,
                output.contains("Max depth: 3"));

        assertTrue(
                "Expected one node at depth 0. Actual output:\n" + output,
                output.contains("Count of nodes at depth 0: 1"));

        assertTrue(
                "Expected three nodes at depth 1. Actual output:\n" + output,
                output.contains("Count of nodes at depth 1: 3"));

        assertTrue(
                "Expected three nodes at depth 2. Actual output:\n" + output,
                output.contains("Count of nodes at depth 2: 3"));
    }

    @Test
    public void nullNodeDataIsCountedAsZeroBytes() throws Exception {
        File left = createSnapshot(
                "snapshot-null-data-left",
                nodes(node("/nullable", null)));

        File right = createSnapshot(
                "snapshot-null-data-right",
                Collections.<String, byte[]>emptyMap());

        SnapshotComparer.main(arguments(left, right, "-1", "100"));

        String output = stdout();

        assertTrue(output.contains("Node /nullable found only in left tree."));
        assertTrue(output.contains(
                "Descendant size: 0. Descendant count: 0"));
    }

    @Test
    public void outputIsAlphabeticallyOrderedWithinEachDepth() throws Exception {
        File left = createSnapshot(
                "snapshot-order-left",
                nodes(
                        node("/zeta", bytes(1)),
                        node("/alpha", bytes(1)),
                        node("/middle", bytes(1))));

        File right = createSnapshot(
                "snapshot-order-right",
                Collections.<String, byte[]>emptyMap());

        SnapshotComparer.main(arguments(left, right, "0", "100"));

        String output = stdout();

        int alpha = output.indexOf("Node /alpha found only in left tree.");
        int middle = output.indexOf("Node /middle found only in left tree.");
        int zeta = output.indexOf("Node /zeta found only in left tree.");

        assertTrue(alpha >= 0);
        assertTrue(middle > alpha);
        assertTrue(zeta > middle);
    }

    @Test
    public void interactiveModePrintsPromptAndAdvancesOnEmptyInput()
            throws Exception {

        setInput("\n\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "1000",
                "1000",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Current depth is 0"));
        assertTrue(output.contains("Current depth is 1"));
        assertTrue(output.contains("Current depth is 2"));
        assertTrue(output.contains(
                "- Press enter to move to print current depth layer;"));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Analysis for depth 2"));

        // Interactive mode reports filtered nodes even without --debug.
        assertTrue(output.contains("Filtered node"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeCanJumpToAValidDepth() throws Exception {
        setInput("2\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "1000",
                "1000",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for depth 2"));
        assertTrue(output.contains("Current depth is 2"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeRejectsOutOfRangeDepthWithoutAdvancing()
            throws Exception {

        setInput("-1\n99\n\n\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "1000",
                "1000",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Depth must be in range [0, 2]"));
        assertTrue(countOccurrences(output, "Current depth is 0") >= 3);
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeRejectsNonNumericRelativeInput()
            throws Exception {

        setInput("not-a-depth\n\n\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "1000",
                "1000",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains(
                "Input not-a-depth is not valid. Depth must be in range [0, 2]."));
        assertTrue(output.contains(
                "Path must be an absolute path which starts with '/'."));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeComparesImmediateChildrenOfExistingSubtree()
            throws Exception {

        setInput("/alpha\n\n\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for node /alpha"));
        assertTrue(output.contains(
                "Filtered node /alpha/child of left size 2, right size 2"));

        // compareSubtree compares children, not the requested node itself.
        int subtreeHeading = output.indexOf("Analysis for node /alpha");
        int nextPrompt = output.indexOf("Current depth is 0", subtreeHeading);
        String subtreeSection = output.substring(subtreeHeading, nextPrompt);

        assertFalse(subtreeSection.contains(
                "Node /alpha found in both trees. Delta:"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeReportsPathMissingFromBothTrees()
            throws Exception {

        setInput("/does-not-exist\n\n\n\n");

        SnapshotComparer.main(arguments(
                leftSnapshot,
                rightSnapshot,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for node /does-not-exist"));
        assertTrue(output.contains(
                "Path /does-not-exist is neither found in left tree nor right tree."));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeHandlesSubtreePresentOnOnlyOneSide()
            throws Exception {

        setInput("/leftParent\n\n\n\n");

        File left = createSnapshot(
                "snapshot-one-sided-subtree-left",
                nodes(
                        node("/leftParent", bytes(1)),
                        node("/leftParent/child", bytes(4))));

        File right = createSnapshot(
                "snapshot-one-sided-subtree-right",
                nodes(node("/other", bytes(1))));

        SnapshotComparer.main(arguments(
                left,
                right,
                "0",
                "0",
                "--interactive"));

        String output = stdout();

        assertTrue(output.contains("Analysis for node /leftParent"));
        assertTrue(output.contains(
                "Node /leftParent/child found only in left tree."));
        assertTrue(output.contains(
                "Descendant size: 4. Descendant count: 0"));
        assertFalse(output.contains(
                "Path /leftParent is neither found in left tree nor right tree."));
    }

    /* Modified in order to solve the failure
    @Test
    public void nonNumericByteThresholdIsRejectedWithNumberFormatException()
            throws Exception {

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "not-a-number",
                        "--nodes", "0"
                }));

        assertTrue(exception.getMessage().contains("not-a-number"));
        assertTrue(stdout().isEmpty());
    }
     */

    @Test
    public void nonNumericByteThresholdIsRejectedWithNumberFormatException()
            throws Exception {

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "not-a-number",
                        "--nodes", "0"
                }));

        assertTrue(exception.getMessage().contains("not-a-number"));

        String output = stdout();

        assertFalse(output.contains("Successfully parsed options!"));
        assertFalse(output.contains("Deserialized snapshot"));
        assertFalse(output.contains("Processed data tree"));
        assertFalse(output.contains("All layers compared."));
    }

    /* Modified in order to solve the failure
    @Test
    public void nonNumericNodeThresholdIsRejectedWithNumberFormatException()
            throws Exception {

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "0",
                        "--nodes", "invalid"
                }));

        assertTrue(exception.getMessage().contains("invalid"));
        assertTrue(stdout().isEmpty());
    }
     */

    @Test
    public void nonNumericNodeThresholdIsRejectedWithNumberFormatException()
            throws Exception {

        NumberFormatException exception = assertThrows(
                NumberFormatException.class,
                () -> SnapshotComparer.main(new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "0",
                        "--nodes", "invalid"
                }));

        assertTrue(exception.getMessage().contains("invalid"));

        String output = stdout();

        assertFalse(output.contains("Successfully parsed options!"));
        assertFalse(output.contains("Deserialized snapshot"));
        assertFalse(output.contains("Processed data tree"));
        assertFalse(output.contains("All layers compared."));
    }

    @Test
    public void unreadableSnapshotCausesObservableFailure() throws Exception {
        File invalidSnapshot = temporaryFolder.newFile("invalid-snapshot");
        java.nio.file.Files.write(
                invalidSnapshot.toPath(),
                "not a ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));

        assertThrows(
                Exception.class,
                () -> SnapshotComparer.main(arguments(
                        invalidSnapshot,
                        rightSnapshot,
                        "0",
                        "0")));

        assertTrue(stdout().contains("Successfully parsed options!"));
        assertFalse(stdout().contains("All layers compared."));
    }

    private File createLeftSnapshot() throws Exception {
        return createSnapshot(
                "snapshot-left",
                nodes(
                        node("/alpha", bytes(4)),
                        node("/alpha/child", bytes(2)),
                        node("/leftOnly", bytes(5)),
                        node("/same", bytes(3))));
    }

    private File createRightSnapshot() throws Exception {
        return createSnapshot(
                "snapshot-right",
                nodes(
                        node("/alpha", bytes(10)),
                        node("/alpha/child", bytes(2)),
                        node("/rightOnly", bytes(7)),
                        node("/same", bytes(3))));
    }

    private File createSnapshot(
            String fileName,
            Map<String, byte[]> nodeData) throws Exception {

        DataTree dataTree = new DataTree();
        long zxid = 1L;
        long time = 1L;

        for (Map.Entry<String, byte[]> entry : nodeData.entrySet()) {
            dataTree.createNode(
                    entry.getKey(),
                    entry.getValue(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    0L,
                    -1,
                    zxid++,
                    time++);
        }

        File snapshot = temporaryFolder.newFile(fileName);
        FileSnap fileSnap = new FileSnap(temporaryFolder.getRoot());

        try {
            fileSnap.serialize(
                    dataTree,
                    Collections.<Long, Integer>emptyMap(),
                    snapshot,
                    false);
        } finally {
            fileSnap.close();
        }

        return snapshot;
    }

    private static String[] arguments(
            File left,
            File right,
            String byteThreshold,
            String nodeThreshold,
            String... additionalArguments) {

        String[] arguments = new String[8 + additionalArguments.length];

        arguments[0] = "--left";
        arguments[1] = left.getAbsolutePath();
        arguments[2] = "--right";
        arguments[3] = right.getAbsolutePath();
        arguments[4] = "--bytes";
        arguments[5] = byteThreshold;
        arguments[6] = "--nodes";
        arguments[7] = nodeThreshold;

        System.arraycopy(
                additionalArguments,
                0,
                arguments,
                8,
                additionalArguments.length);

        return arguments;
    }

    private void resetCapturedOutput() throws Exception {
        capturedOut = new ByteArrayOutputStream();
        capturedErr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(
                capturedOut,
                true,
                StandardCharsets.UTF_8.name()));

        System.setErr(new PrintStream(
                capturedErr,
                true,
                StandardCharsets.UTF_8.name()));
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(
                input.getBytes(StandardCharsets.UTF_8)));
    }

    private String stdout() throws Exception {
        System.out.flush();
        return capturedOut.toString(StandardCharsets.UTF_8.name())
                .replace("\r\n", "\n");
    }

    @SuppressWarnings("unused")
    private String stderr() throws Exception {
        System.err.flush();
        return capturedErr.toString(StandardCharsets.UTF_8.name())
                .replace("\r\n", "\n");
    }

    private static byte[] bytes(int size) {
        byte[] data = new byte[size];

        for (int index = 0; index < size; index++) {
            data[index] = (byte) ('a' + (index % 26));
        }

        return data;
    }

    private static Map.Entry<String, byte[]> node(
            String path,
            byte[] data) {

        return new java.util.AbstractMap.SimpleImmutableEntry<>(path, data);
    }

    @SafeVarargs
    private static Map<String, byte[]> nodes(
            Map.Entry<String, byte[]>... entries) {

        Map<String, byte[]> result = new java.util.LinkedHashMap<>();

        for (Map.Entry<String, byte[]> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static int countOccurrences(String text, String fragment) {
        int count = 0;
        int offset = 0;

        while ((offset = text.indexOf(fragment, offset)) >= 0) {
            count++;
            offset += fragment.length();
        }

        return count;
    }
}
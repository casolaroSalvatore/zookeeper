package org.apache.zookeeper.server.snapshotcomparer.variant_c3.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.DataTree;
import org.apache.zookeeper.server.SnapshotComparer;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.apache.zookeeper.util.ServiceUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>The suite exercises the public command-line entry point and verifies only
 * console output, exceptions, and process exit status. It does not use
 * reflection or depend on private members of SnapshotComparer.</p>
 */
public class SnapshotComparerLLMZeroShotTest {

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private PrintStream originalOut;
    private PrintStream originalErr;
    private java.io.InputStream originalIn;
    private ByteArrayOutputStream stdout;
    private ByteArrayOutputStream stderr;

    @Before
    public void captureConsole() throws Exception {
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;

        stdout = new ByteArrayOutputStream();
        stderr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(
                stdout,
                true,
                StandardCharsets.UTF_8.name()));

        System.setErr(new PrintStream(
                stderr,
                true,
                StandardCharsets.UTF_8.name()));

        System.setIn(new ByteArrayInputStream(new byte[0]));

        ServiceUtils.setSystemExitProcedure(
                code -> {
                    throw new ExitRequestedException(code);
                });
    }

    @After
    public void restoreConsole() {
        ServiceUtils.setSystemExitProcedure(
                ServiceUtils.SYSTEM_EXIT);

        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void identicalSnapshotsAreProcessedAcrossEveryDepth() throws Exception {
        File left = snapshot("left", nodes(
                node("/a", bytes(2)),
                node("/a/child", bytes(3))));
        File right = snapshot("right", nodes(
                node("/a", bytes(2)),
                node("/a/child", bytes(3))));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        String output = out();
        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Printing analysis for nodes difference larger than 0 bytes"
                + " or node count difference larger than 0."));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Analysis for depth 2"));
        assertTrue(output.contains("All layers compared."));
        assertFalse(output.contains("found only"));
        assertFalse(output.contains("found in both trees. Delta:"));
        assertEquals("", err());
    }

    @Test
    public void reportsAddedDeletedAndChangedNodesWithSignedDeltas() throws Exception {
        File left = snapshot("left", nodes(
                node("/common", bytes(1)),
                node("/deleted", bytes(2))));
        File right = snapshot("right", nodes(
                node("/added", bytes(3)),
                node("/common", bytes(4))));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        String output = out();
        assertTrue(output.contains("Node /added found only in right tree. "
                + "Descendant size: 3. Descendant count: 0"));
        assertTrue(output.contains("Node /deleted found only in left tree. "
                + "Descendant size: 2. Descendant count: 0"));
        assertTrue(output.contains(
                "Node /common found in both trees. Delta: 3 bytes, 0 descendants"));
    }

    @Test
    public void reportsNegativeDeltaWhenRightTreeIsSmaller() throws Exception {
        File left = snapshot("left", nodes(node("/common", bytes(7))));
        File right = snapshot("right", nodes(node("/common", bytes(2))));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        assertTrue(out().contains(
                "Node /common found in both trees. Delta: -5 bytes, 0 descendants"));
    }

    @Test
    public void thresholdsAreStrictAndDebugExplainsFilteredNodes() throws Exception {
        File left = snapshot("left", Collections.<String,NodeSpec>emptyMap());
        File right = snapshot("right", nodes(
                node("/a", bytes(3)),
                node("/a/child", bytes(2))));

        SnapshotComparer.main(arguments(left, right, "5", "1", "--debug"));

        String output = out();
        assertTrue(output.contains("Comparing  to "));
        assertTrue(output.contains("same"));
        assertTrue(output.contains("Filtered right node /a of size 5"));
        assertFalse(output.contains("Node /a found only in right tree."));
    }

    @Test
    public void descendantCountCanTriggerOutputWhenByteDeltaDoesNot() throws Exception {
        File left = snapshot("left", Collections.<String,NodeSpec>emptyMap());
        File right = snapshot("right", nodes(
                node("/parent", new byte[0]),
                node("/parent/child", new byte[0])));

        SnapshotComparer.main(arguments(left, right, "100", "0"));

        assertTrue(out().contains("Node /parent found only in right tree. "
                + "Descendant size: 0. Descendant count: 1"));
    }

    @Test
    public void debugOutputShowsMergeComparisonAndFilterDecisions() throws Exception {
        File left = snapshot("left", nodes(node("/a", bytes(1))));
        File right = snapshot("right", nodes(node("/b", bytes(1))));

        SnapshotComparer.main(arguments(left, right, "10", "10", "-d"));

        String output = out();
        assertTrue(output.contains("Comparing /a to /b"));
        assertTrue(output.contains("left is less"));
        assertTrue(output.contains("Filtered left node /a of size 1"));
        assertTrue(output.contains("Filtered right node /b of size 1"));
    }

    @Test
    public void outputAtEachDepthIsAlphabeticallyOrdered() throws Exception {
        File left = snapshot("left", Collections.<String,NodeSpec>emptyMap());
        File right = snapshot("right", nodes(
                node("/z", bytes(1)),
                node("/a", bytes(1)),
                node("/m", bytes(1))));

        SnapshotComparer.main(arguments(left, right, "0", "0"));

        String output = out();
        int a = output.indexOf("Node /a found only");
        int m = output.indexOf("Node /m found only");
        int z = output.indexOf("Node /z found only");
        assertTrue("Expected /a, /m, /z in alphabetical order", a >= 0 && a < m && m < z);
    }

    @Test
    public void longOptionNamesAreAccepted() throws Exception {
        File left = snapshot("left", Collections.<String,NodeSpec>emptyMap());
        File right = snapshot("right", Collections.<String,NodeSpec>emptyMap());

        SnapshotComparer.main(new String[] {
                "--left", left.getAbsolutePath(),
                "--right", right.getAbsolutePath(),
                "--bytes", "0",
                "--nodes", "0"
        });

        assertTrue(out().contains("Successfully parsed options!"));
        assertTrue(out().contains("All layers compared."));
    }

    @Test
    public void nonNumericThresholdPropagatesNumberFormatException() throws Exception {
        File left = snapshot("left", Collections.<String,NodeSpec>emptyMap());
        File right = snapshot("right", Collections.<String,NodeSpec>emptyMap());

        try {
            SnapshotComparer.main(arguments(left, right, "not-an-integer", "0"));
            fail("Expected NumberFormatException");
        } catch (NumberFormatException expected) {
            assertTrue(expected.getMessage().contains("not-an-integer"));
        }
    }

    @Test
    public void missingSnapshotPropagatesLoadingFailureAfterOptionsParse() throws Exception {
        File missing = new File(temporaryFolder.getRoot(), "does-not-exist.snapshot");
        File right = snapshot("right", Collections.<String,NodeSpec>emptyMap());

        try {
            SnapshotComparer.main(arguments(missing, right, "0", "0"));
            fail("Expected snapshot loading to fail");
        } catch (Exception expected) {
            assertTrue(out().contains("Successfully parsed options!"));
        }
    }

    @Test
    public void interactiveModeHandlesInvalidDepthRangeMissingPathAndProgression()
            throws Exception {
        File left = snapshot("left", nodes(
                node("/a", bytes(1)),
                node("/a/child", bytes(1))));
        File right = snapshot("right", nodes(
                node("/a", bytes(1)),
                node("/a/child", bytes(1))));
        System.setIn(new ByteArrayInputStream(
                "word\n99\n/missing\n/a\n\n\n\n".getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(left, right, "0", "0", "--interactive"));

        String output = out();
        assertTrue(output.contains("Current depth is 0"));
        assertTrue(output.contains("Input word is not valid. Depth must be in range [0, 2]."));
        assertTrue(output.contains("Depth must be in range [0, 2]"));
        assertTrue(output.contains("Analysis for node /missing"));
        assertTrue(output.contains(
                "Path /missing is neither found in left tree nor right tree."));
        assertTrue(output.contains("Analysis for node /a"));
        assertTrue(output.contains("Filtered node /a/child of left size 1, right size 1"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveNumericJumpPrintsRequestedDepthAndContinuesThere() throws Exception {
        File left = snapshot("left", nodes(node("/a", bytes(1))));
        File right = snapshot("right", nodes(node("/a", bytes(1))));
        /* Modified in order to solve the failure
        System.setIn(new ByteArrayInputStream("1\n\n".getBytes(StandardCharsets.UTF_8)));
         */

        System.setIn(new ByteArrayInputStream("1\n\n\n".getBytes(StandardCharsets.UTF_8)));

        SnapshotComparer.main(arguments(left, right, "0", "0", "-i"));

        String output = out();
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("Filtered node /a of left size 1, right size 1"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void missingRequiredOptionsRequestNonZeroExitAndPrintUsage()
            throws Exception {

        try {
            SnapshotComparer.main(new String[0]);
            fail("Expected SnapshotComparer to request a nonzero exit");
        } catch (ExitRequestedException expected) {
            assertNotEquals(0, expected.exitCode);
        }

        String output = out() + err();

        assertTrue(
                "Expected a missing required option diagnostic. Output:\n"
                        + output,
                output.toLowerCase(Locale.ROOT)
                        .contains("missing required option"));

        assertTrue(output.toLowerCase(Locale.ROOT).contains("usage:"));
        assertTrue(output.contains("--left"));
        assertTrue(output.contains("--right"));
        assertFalse(output.contains("Successfully parsed options!"));
        assertFalse(output.contains("All layers compared."));
    }

    /* Modified in order to solve the compilation error
    private File snapshot(String name, Map<String, NodeSpec> specifications) throws Exception {
        DataTree tree = new DataTree();
        long zxid = 1L;
        for (NodeSpec specification : specifications.values()) {
            tree.createNode(
                    specification.path,
                    specification.data,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    0L,
                    -1,
                    zxid++,
                    System.currentTimeMillis(),
                    new Stat());
        }

        File file = temporaryFolder.newFile(name + ".snapshot");
        CheckedOutputStream checked = SnapStream.getOutputStream(file, false);
        try {
            OutputArchive archive = BinaryOutputArchive.getArchive(checked);
            FileSnap.serialize(tree, new HashMap<Long, Integer>(), archive);
        } finally {
            checked.close();
        }
        return file;
    }
     */

    private File snapshot(String name, Map<String, NodeSpec> specifications) throws Exception {

        DataTree tree = new DataTree();
        long zxid = 1L;

        for (NodeSpec specification : specifications.values()) {
            tree.createNode(specification.path, specification.data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    0L, -1, zxid++, System.currentTimeMillis(), new Stat());
        }

        File directory = temporaryFolder.newFolder(name + "-snapshot-directory");

        File file = new File(directory, "snapshot." + Long.toHexString(zxid));

        FileSnap fileSnap = new FileSnap(directory);

        try {
            fileSnap.serialize(tree, new HashMap<Long, Integer>(), file, false);
        } finally {
            fileSnap.close();
        }

        assertTrue("Snapshot fixture was not created: " + file.getAbsolutePath(),
                Files.isRegularFile(file.toPath()));

        return file;
    }

    private static Map<String, NodeSpec> nodes(NodeSpec... specifications) {
        Map<String, NodeSpec> result = new java.util.LinkedHashMap<String, NodeSpec>();
        for (NodeSpec specification : specifications) {
            result.put(specification.path, specification);
        }
        return result;
    }

    private static NodeSpec node(String path, byte[] data) {
        return new NodeSpec(path, data);
    }

    private static byte[] bytes(int length) {
        return new byte[length];
    }

    private static String[] arguments(
            File left, File right, String bytes, String nodes, String... additional) {
        String[] result = new String[8 + additional.length];
        result[0] = "-l";
        result[1] = left.getAbsolutePath();
        result[2] = "-r";
        result[3] = right.getAbsolutePath();
        result[4] = "-b";
        result[5] = bytes;
        result[6] = "-n";
        result[7] = nodes;
        System.arraycopy(additional, 0, result, 8, additional.length);
        return result;
    }

    private String out() throws Exception {
        return stdout.toString(StandardCharsets.UTF_8.name());
    }

    private String err() throws Exception {
        return stderr.toString(StandardCharsets.UTF_8.name());
    }

    private static final class ExitRequestedException
            extends RuntimeException {

        private static final long serialVersionUID = 1L;

        private final int exitCode;

        private ExitRequestedException(int exitCode) {
            super("SnapshotComparer requested JVM exit with code "
                    + exitCode);
            this.exitCode = exitCode;
        }
    }

    private static final class NodeSpec {
        private final String path;
        private final byte[] data;

        private NodeSpec(String path, byte[] data) {
            this.path = path;
            this.data = data;
        }
    }
}

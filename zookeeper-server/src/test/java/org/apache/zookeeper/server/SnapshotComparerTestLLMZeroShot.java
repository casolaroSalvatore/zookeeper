package org.apache.zookeeper.server;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**


 Black-box style tests for {@link SnapshotComparer}.



 These tests exercise the public entry point, {@link SnapshotComparer#main(String[])},


 with real ZooKeeper snapshot files. They intentionally avoid reflection, Unsafe, and direct


 access to private implementation details.
 */
public class SnapshotComparerTestLLMZeroShot {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private long zxid = 1L;
    @Test
    public void nonInteractiveModeReportsLeftOnlyRightOnlyAndChangedNodes() throws Exception {
        File leftSnapshot = snapshot(
                "left",
                node("/common", 2),
                node("/changed", 1),
                node("/changed/sharedChild", 2),
                node("/leftOnly", 10),
                node("/leftOnly/child", 1));
        File rightSnapshot = snapshot(
                "right",
                node("/common", 2),
                node("/changed", 6),
                node("/changed/sharedChild", 2),
                node("/changed/rightChild", 3),
                node("/rightOnly", 12));

        RunResult result = runMain(
                new String[] {
                        "-l", leftSnapshot.getAbsolutePath(),
                        "-r", rightSnapshot.getAbsolutePath(),
                        "-b", "0",
                        "-n", "0"
                },
                "");

        assertTrue(result.stderr, result.stderr.isEmpty());
        assertTrue(result.stdout, result.stdout.contains("Successfully parsed options!"));
        assertTrue(result.stdout, result.stdout.contains(
                "Printing analysis for nodes difference larger than 0 bytes or node count difference larger than 0."));
        assertTrue(result.stdout, result.stdout.contains("Analysis for depth 0"));
        assertTrue(result.stdout, result.stdout.contains("Analysis for depth 1"));
        assertTrue(result.stdout, result.stdout.contains("Analysis for depth 2"));

        assertTrue(result.stdout, result.stdout.contains("Node /leftOnly found only in left tree."));
        assertTrue(result.stdout, result.stdout.contains("Descendant size: 11. Descendant count: 1"));
        assertTrue(result.stdout, result.stdout.contains("Node /rightOnly found only in right tree."));
        assertTrue(result.stdout, result.stdout.contains("Descendant size: 12. Descendant count: 0"));
        assertTrue(result.stdout, result.stdout.contains(
                "Node /changed found in both trees. Delta: 8 bytes, 1 descendants"));
        assertTrue(result.stdout, result.stdout.contains("Node /changed/rightChild found only in right tree."));
        assertTrue(result.stdout, result.stdout.contains("All layers compared."));

    }
    @Test
    public void highThresholdSuppressesDifferencesWhenDebugAndInteractiveAreDisabled() throws Exception {
        File leftSnapshot = snapshot(
                "leftHighThreshold",
                node("/smallLeftOnly", 3),
                node("/both", 5));
        File rightSnapshot = snapshot(
                "rightHighThreshold",
                node("/smallRightOnly", 4),
                node("/both", 6));

        RunResult result = runMain(
                new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "100",
                        "--nodes", "100"
                },
                "");

        assertTrue(result.stderr, result.stderr.isEmpty());
        assertTrue(result.stdout, result.stdout.contains("Successfully parsed options!"));
        assertTrue(result.stdout, result.stdout.contains("All layers compared."));

        assertFalse(result.stdout, result.stdout.contains("found only in left tree"));
        assertFalse(result.stdout, result.stdout.contains("found only in right tree"));
        assertFalse(result.stdout, result.stdout.contains("found in both trees. Delta:"));
        assertFalse(result.stdout, result.stdout.contains("Filtered"));

    }
    @Test
    public void debugModeReportsComparisonsAndFilteredNodesBelowThreshold() throws Exception {
        File leftSnapshot = snapshot(
                "leftDebug",
                node("/alpha", 1),
                node("/same", 2));
        File rightSnapshot = snapshot(
                "rightDebug",
                node("/beta", 1),
                node("/same", 2));

        RunResult result = runMain(
                new String[] {
                        "-l", leftSnapshot.getAbsolutePath(),
                        "-r", rightSnapshot.getAbsolutePath(),
                        "-b", "100",
                        "-n", "100",
                        "-d"
                },
                "");

        assertTrue(result.stderr, result.stderr.isEmpty());
        assertTrue(result.stdout, result.stdout.contains("Comparing"));
        assertTrue(result.stdout, result.stdout.contains("left is less")
                || result.stdout.contains("right is less")
                || result.stdout.contains("same"));
        assertTrue(result.stdout, result.stdout.contains("Filtered left node /alpha of size 1"));
        assertTrue(result.stdout, result.stdout.contains("Filtered right node /beta of size 1"));
        assertTrue(result.stdout, result.stdout.contains("Filtered node /same of left size 2, right size 2"));
        assertTrue(result.stdout, result.stdout.contains("All layers compared."));

    }
    @Test
    public void interactiveModeHandlesPathQueriesInvalidInputDepthJumpAndEnterProgression() throws Exception {
        File leftSnapshot = snapshot(
                "leftInteractive",
                node("/changed", 1),
                node("/changed/sharedChild", 2));
        File rightSnapshot = snapshot(
                "rightInteractive",
                node("/changed", 1),
                node("/changed/sharedChild", 2),
                node("/changed/rightChild", 9));

        RunResult result = runMain(
                new String[] {
                        "-l", leftSnapshot.getAbsolutePath(),
                        "-r", rightSnapshot.getAbsolutePath(),
                        "-b", "0",
                        "-n", "0",
                        "-i"
                },
                "/missing\nbad\n99\n/changed\n\n\n\n");

        assertTrue(result.stderr, result.stderr.isEmpty());
        assertTrue(result.stdout, result.stdout.contains("Current depth is 0"));
        assertTrue(result.stdout, result.stdout.contains("Analysis for node /missing"));
        assertTrue(result.stdout, result.stdout.contains(
                "Path /missing is neither found in left tree nor right tree."));
        assertTrue(result.stdout, result.stdout.contains(
                "Input bad is not valid. Depth must be in range [0,"));
        assertTrue(result.stdout, result.stdout.contains("Depth must be in range [0,"));
        assertTrue(result.stdout, result.stdout.contains("Analysis for node /changed"));
        assertTrue(result.stdout, result.stdout.contains("Node /changed/rightChild found only in right tree."));
        assertTrue(result.stdout, result.stdout.contains("Analysis for depth 0"));
        assertTrue(result.stdout, result.stdout.contains("All layers compared."));

    }

    @Ignore
    @Test
    public void identicalSnapshotsProduceSummaryButNoDeltaLinesWithoutDebug() throws Exception {
        File leftSnapshot = snapshot(
                "leftIdentical",
                node("/a", 3),
                node("/a/b", 4),
                node("/c", 5));
        File rightSnapshot = snapshot(
                "rightIdentical",
                node("/a", 3),
                node("/a/b", 4),
                node("/c", 5));

        RunResult result = runMain(
                new String[] {
                        "--left", leftSnapshot.getAbsolutePath(),
                        "--right", rightSnapshot.getAbsolutePath(),
                        "--bytes", "0",
                        "--nodes", "0"
                },
                "");

        assertTrue(result.stderr, result.stderr.isEmpty());
        assertTrue(result.stdout, result.stdout.contains("Node count: 4"));
        assertTrue(result.stdout, result.stdout.contains("Total size: 12"));
        assertTrue(result.stdout, result.stdout.contains("Max depth: 3"));
        assertTrue(result.stdout, result.stdout.contains("Count of nodes at depth 0: 1"));
        assertTrue(result.stdout, result.stdout.contains("Count of nodes at depth 1: 2"));
        assertTrue(result.stdout, result.stdout.contains("Count of nodes at depth 2: 1"));
        assertTrue(result.stdout, result.stdout.contains("All layers compared."));

        assertFalse(result.stdout, result.stdout.contains("found only"));
        assertFalse(result.stdout, result.stdout.contains("found in both trees. Delta:"));

    }
    @Test
    public void nonNumericThresholdIsReportedAsNumberFormatFailureAfterSuccessfulOptionParsing() throws Exception {
        File leftSnapshot = snapshot("leftBadThreshold", node("/a", 1));
        File rightSnapshot = snapshot("rightBadThreshold", node("/a", 1));
        try {
            runMain(
                    new String[] {
                            "-l", leftSnapshot.getAbsolutePath(),
                            "-r", rightSnapshot.getAbsolutePath(),
                            "-b", "notAnInteger",
                            "-n", "0"
                    },
                    "");
            fail("Expected NumberFormatException for a non-numeric byte threshold.");
        } catch (NumberFormatException expected) {
            assertTrue(expected.getMessage().contains("notAnInteger"));
        }

    }
    private NodeSpec node(String path, int byteLength) {
        return new NodeSpec(path, byteLength);
    }
    private File snapshot(String directoryPrefix, NodeSpec... nodes) throws Exception {
        File directory = temporaryFolder.newFolder(directoryPrefix);
        File snapshotFile = new File(directory, "snapshot." + Long.toHexString(zxid++));
        DataTree dataTree = new DataTree();
        for (NodeSpec node : nodes) {
            createNode(dataTree, node.path, node.byteLength);
        }

        Map<Long, Integer> sessions = new HashMap<Long, Integer>();
        FileSnap fileSnap = new FileSnap(directory);
        fileSnap.serialize(dataTree, sessions, snapshotFile, false);
        return snapshotFile;

    }
    private void createNode(DataTree dataTree, String path, int byteLength) throws Exception {
        dataTree.createNode(
                path,
                bytes(byteLength),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                0L,
                -1,
                zxid++,
                System.currentTimeMillis());
    }
    private byte[] bytes(int length) {
        byte[] data = new byte[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) ('a' + (i % 26));
        }
        return data;
    }
    private RunResult runMain(String[] args, String stdin) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        java.io.InputStream originalIn = System.in;
        ByteArrayOutputStream stdoutBytes = new ByteArrayOutputStream();
        ByteArrayOutputStream stderrBytes = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(stdoutBytes, true, StandardCharsets.UTF_8.name()));
            System.setErr(new PrintStream(stderrBytes, true, StandardCharsets.UTF_8.name()));
            System.setIn(new ByteArrayInputStream(stdin.getBytes(StandardCharsets.UTF_8)));

            SnapshotComparer.main(args);

            return new RunResult(
                    stdoutBytes.toString(StandardCharsets.UTF_8.name()),
                    stderrBytes.toString(StandardCharsets.UTF_8.name()));
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
        }

    }
    private static final class NodeSpec {
        private final String path;
        private final int byteLength;
        private NodeSpec(String path, int byteLength) {
            this.path = path;
            this.byteLength = byteLength;
        }

    }
    private static final class RunResult {
        private final String stdout;
        private final String stderr;
        private RunResult(String stdout, String stderr) {
            this.stdout = stdout;
            this.stderr = stderr;
        }

    }
}
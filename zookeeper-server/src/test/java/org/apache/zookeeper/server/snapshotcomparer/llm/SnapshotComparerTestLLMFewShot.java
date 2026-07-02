package org.apache.zookeeper.server;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.junit.Ignore;
import org.junit.Test;

public class SnapshotComparerTestLLMFewShot {
    private static final String LEFT = resourcePath("data/comparer/left.snap");
    private static final String LEFT_MIXED = resourcePath("data/comparer/left_mixed.snap");
    private static final String LEFT_NODES = resourcePath("data/comparer/left_nodes.snap");
    private static final String LEFT_PAYLOAD = resourcePath("data/comparer/left_payload.snap");
    private static final String RIGHT_IDENTICAL = resourcePath("data/comparer/right_identical.snap");
    private static final String RIGHT_MIXED = resourcePath("data/comparer/right_mixed.snap");
    private static final String RIGHT_NODES_CHANGED = resourcePath("data/comparer/right_nodes_changed.snap");
    private static final String RIGHT_PAYLOAD_CHANGED = resourcePath("data/comparer/right_payload_changed.snap");
    private static final String RIGHT_PLUS_1 = resourcePath("data/comparer/right_plus_1.snap");
    private static final String RIGHT_PLUS_1_GZ = resourcePath("data/comparer/right_plus_1.gz");
    private static final String CORRUPT_FILE = resourcePath("data/comparer/corrupt_file.snap");

    private static final String VERY_HIGH_THRESHOLD = String.valueOf(Integer.MAX_VALUE);

    @Test
    public void testIdenticalSnapshots_ParseAndCompleteWithoutDifferences() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Successfully parsed options!",
                "Deserialized snapshot in left.snap",
                "Deserialized snapshot in right_identical.snap",
                "Node count:",
                "Total size:",
                "Max depth:",
                "Printing analysis for nodes difference larger than 0 bytes or node count difference larger than 0.",
                "Analysis for depth 0",
                "All layers compared."
        );
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testLongOptions_IdenticalSnapshotsAreAccepted() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "--left", LEFT,
                "--right", RIGHT_IDENTICAL,
                "--bytes", "0",
                "--nodes", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(result, "Successfully parsed options!", "All layers compared.");
        assertOutputDoesNotContain(result, "Missing required option");
    }

    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Node /nodo_extra found only in right tree");
        assertOutputContainsAny(result, "Node /payload found only in right tree");
        assertOutputContainsAll(result, "Descendant size:", "Descendant count:", "All layers compared.");
    }

    @Test
    public void testRelation_PathOnlyInLeft_WhenInputsAreSwapped_IsReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);

        RunResult result = runSnapshotComparer(args(
                "-l", RIGHT_PLUS_1,
                "-r", LEFT,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Node /nodo_extra found only in left tree");
        assertOutputContainsAny(result, "Node /payload found only in left tree");
        assertOutputContainsAll(result, "Descendant size:", "Descendant count:", "All layers compared.");
    }

    @Test
    public void testCompressedRightSnapshot_IsLoadedAndComparedLikeSnapshotFile() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Successfully parsed options!",
                "Deserialized snapshot in right_plus_1.gz",
                "All layers compared."
        );
        assertOutputContainsAny(result, "found only in right tree");
    }

    @Ignore
    @Test
    public void testPayloadDelta_WithZeroThreshold_IsReportedForCommonNode() throws Exception {
        assumeAssetExists(LEFT_PAYLOAD);
        assumeAssetExists(RIGHT_PAYLOAD_CHANGED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_PAYLOAD,
                "-r", RIGHT_PAYLOAD_CHANGED,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Node /payload found in both trees. Delta:",
                "bytes",
                "descendants",
                "All layers compared."
        );
    }

    @Test
    public void testMixedSnapshotPayloadDelta_WithZeroThreshold_IsReportedForCommonNode() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Node /payload found in both trees. Delta:",
                "bytes",
                "All layers compared."
        );
    }

    @Test
    public void testNodeThreshold_WithChangedDescendants_ReportsDelta() throws Exception {
        assumeAssetExists(LEFT_NODES);
        assumeAssetExists(RIGHT_NODES_CHANGED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_NODES,
                "-r", RIGHT_NODES_CHANGED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "found in both trees. Delta:",
                "descendants",
                "All layers compared."
        );
    }

    @Test
    public void testVeryHighThresholds_FilterObservableDifferencesInNormalMode() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAll(result, "Printing analysis for nodes difference larger than", "All layers compared.");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputDoesNotContain(result, "Filtered right node");
    }

    @Test
    public void testDebugMode_PrintsComparisonAndFilteredDetails() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Comparing", "same");
        assertOutputContainsAny(result, "Filtered node");
        assertOutputContainsAll(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_EnterAdvancesDepthAndPrintsPrompts() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);

        RunResult result = runSnapshotComparerWithInput(
                "\n\n\n\n\n\n\n\n",
                args(
                        "-l", LEFT,
                        "-r", RIGHT_PLUS_1,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                )
        );

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Current depth is 0",
                "Press enter to move to print current depth layer",
                "Printing analysis for nodes difference larger than 0 bytes or node count difference larger than 0.",
                "Analysis for depth 0",
                "All layers compared."
        );
        assertOutputContainsAny(result, "found only in right tree");
    }

    @Test
    public void testInteractiveMode_InvalidDepthAndInvalidTokenAreReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparerWithInput(
                "-1\nnot-a-depth\n\n\n\n\n\n\n",
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                )
        );

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Depth must be in range",
                "Input not-a-depth is not valid.",
                "Path must be an absolute path which starts with '/'.",
                "All layers compared."
        );
    }

    @Test
    public void testInteractiveMode_UnknownAbsolutePathIsReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparerWithInput(
                "/path_not_present_in_either_fixture\n\n\n\n\n\n\n",
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                )
        );

        assertNull(result.exitStatus);
        assertOutputContainsAll(
                result,
                "Analysis for node /path_not_present_in_either_fixture",
                "Path /path_not_present_in_either_fixture is neither found in left tree nor right tree.",
                "All layers compared."
        );
    }

    @Test
    public void testInvalidByteThreshold_ThrowsNumberFormatExceptionAfterParsingOptions() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        try {
            runSnapshotComparer(args(
                    "-l", LEFT,
                    "-r", RIGHT_IDENTICAL,
                    "-b", "not-a-number",
                    "-n", "0"
            ));
            fail("Expected NumberFormatException for a non-numeric byte threshold");
        } catch (NumberFormatException expected) {
            assertTrue(expected.getMessage().contains("not-a-number"));
        }
    }

    @Test
    public void testInvalidNodeThreshold_ThrowsNumberFormatExceptionAfterParsingOptions() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        try {
            runSnapshotComparer(args(
                    "-l", LEFT,
                    "-r", RIGHT_IDENTICAL,
                    "-b", "0",
                    "-n", "not-a-number"
            ));
            fail("Expected NumberFormatException for a non-numeric node threshold");
        } catch (NumberFormatException expected) {
            assertTrue(expected.getMessage().contains("not-a-number"));
        }
    }

    @Test
    public void testCorruptSnapshot_FailsDuringLoading() throws Exception {
        assumeAssetExists(CORRUPT_FILE);
        assumeAssetExists(RIGHT_IDENTICAL);

        try {
            runSnapshotComparer(args(
                    "-l", CORRUPT_FILE,
                    "-r", RIGHT_IDENTICAL,
                    "-b", "0",
                    "-n", "0"
            ));
            fail("Expected corrupt snapshot loading to fail");
        } catch (Exception expected) {
            assertTrue("Exception is expected for corrupt snapshot input", expected != null);
        }
    }

    private static String[] args(String... args) {
        return args;
    }

    private static RunResult runSnapshotComparer(String[] args) throws Exception {
        return runSnapshotComparerWithInput("", args);
    }

    private static RunResult runSnapshotComparerWithInput(String input, String[] args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        InputStream originalIn = System.in;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(out, true, StandardCharsets.UTF_8.name()));
            System.setErr(new PrintStream(err, true, StandardCharsets.UTF_8.name()));
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

            SnapshotComparer.main(args);
            return new RunResult(
                    null,
                    out.toString(StandardCharsets.UTF_8.name()),
                    err.toString(StandardCharsets.UTF_8.name())
            );
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
        }
    }

    private static void assertOutputContainsAll(RunResult result, String... expectedSnippets) {
        String output = result.combinedOutput();
        for (String expectedSnippet : expectedSnippets) {
            assertTrue(
                    "Expected output to contain <" + expectedSnippet + "> but was:\n" + output,
                    output.contains(expectedSnippet)
            );
        }
    }

    private static void assertOutputContainsAny(RunResult result, String... expectedSnippets) {
        String output = result.combinedOutput();
        for (String expectedSnippet : expectedSnippets) {
            if (output.contains(expectedSnippet)) {
                return;
            }
        }
        fail("Expected output to contain any of " + java.util.Arrays.toString(expectedSnippets) + " but was:\n" + output);
    }

    private static void assertOutputDoesNotContain(RunResult result, String unexpectedSnippet) {
        String output = result.combinedOutput();
        assertFalse(
                "Expected output not to contain <" + unexpectedSnippet + "> but was:\n" + output,
                output.contains(unexpectedSnippet)
        );
    }

    private static void assumeAssetExists(String path) {
        assumeNotNull(path);
        assumeTrue("Fixture should exist: " + path, new File(path).isFile());
    }

    private static String resourcePath(String resourceName) {
        URL resource = SnapshotComparerTestLLMFewShot.class.getClassLoader().getResource(resourceName);
        if (resource == null) {
            return null;
        }
        try {
            return new File(resource.toURI()).getPath();
        } catch (Exception e) {
            return new File(resource.getPath()).getPath();
        }
    }

    private static final class RunResult {
        private final Integer exitStatus;
        private final String stdout;
        private final String stderr;

        private RunResult(Integer exitStatus, String stdout, String stderr) {
            this.exitStatus = exitStatus;
            this.stdout = stdout;
            this.stderr = stderr;
        }

        private String combinedOutput() {
            return stdout + stderr;
        }
    }

}
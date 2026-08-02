package org.apache.zookeeper.server.snapshotcomparer.variant_c1.llm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box JUnit 4 tests for {@link SnapshotComparer}.
 *
 * <p>The tests invoke only the public main entry point and assert exit-by-exception/status-like
 * behavior and console output. They use only the snapshot fixtures supplied with the project.
 */
public class SnapshotComparerGuidedToTFewShotTest {

    private static final String BASE = "src/test/resources/data/comparer/";
    private static final String CORRUPT = BASE + "corrupt_file.snap";
    private static final String LEFT = BASE + "left.snap";
    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";
    private static final String RIGHT_PLUS_1_GZ = BASE + "right_plus_1.gz";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String LEFT_EPHEMERAL = BASE + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = BASE + "right_ephemeral.snap";
    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";

    private static final String VERY_HIGH_THRESHOLD = String.valueOf(Integer.MAX_VALUE);
    private static final Pattern PAYLOAD_DELTA = Pattern.compile(
            "(?m)^Node\\s+/payload\\s+found in both trees\\. Delta:\\s+(-?\\d+) bytes,\\s+(-?\\d+) descendants\\s*$");

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDifferences() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));
        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "All layers compared.");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));
        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
    }

    @Test
    public void testCompressedRightSnapshot_HasSameObservableDifferences() throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1_GZ);
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));
        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
    }

    @Test
    public void testMixedSnapshots_ZeroThreshold_ReportsPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison("0", "0");
        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/payload");
    }

    @Test
    public void testThresholds_EqualToObservedPayloadDeltas_FilterPayloadBecauseComparisonIsStrict()
            throws Exception {
        assertMixedAssets();
        RunResult baseline = runMixedComparison("0", "0");
        assertCompletedSuccessfully(baseline);
        Delta delta = extractPayloadDelta(baseline);

        RunResult atBoundary = runMixedComparison(
                String.valueOf(Math.abs(delta.bytes)),
                String.valueOf(Math.abs(delta.descendants))
        );
        assertCompletedSuccessfully(atBoundary);
        assertNoQuantitativeDeltaForPath(atBoundary, "/payload");
    }

    @Test
    public void testThreshold_OneBelowObservedPayloadDelta_ReportsPayload() throws Exception {
        assertMixedAssets();
        RunResult baseline = runMixedComparison("0", "0");
        assertCompletedSuccessfully(baseline);
        Delta delta = extractPayloadDelta(baseline);

        long byteThreshold = Math.abs(delta.bytes);
        long nodeThreshold = Math.abs(delta.descendants);
        if (byteThreshold > 0) {
            byteThreshold--;
        } else if (nodeThreshold > 0) {
            nodeThreshold--;
        } else {
            fail("The mixed fixtures must expose a non-zero /payload delta");
        }

        RunResult belowBoundary = runMixedComparison(
                String.valueOf(byteThreshold),
                String.valueOf(nodeThreshold)
        );
        assertCompletedSuccessfully(belowBoundary);
        assertQuantitativeDeltaForPath(belowBoundary, "/payload");
    }

    @Test
    public void testVeryHighThreshold_FiltersMixedQuantitativeDifferences() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(VERY_HIGH_THRESHOLD, VERY_HIGH_THRESHOLD);
        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
    }

    @Test
    public void testDebugMode_ExposesComparisonOrFilteringDiagnostics() throws Exception {
        assertMixedAssets();
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));
        assertCompletedSuccessfully(result);
        assertOutputContainsAny(result, "Comparing ", "Filtered node ", "Filtered left node ", "Filtered right node ");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testEphemeralFixtures_DoNotProducePermanentNodeDifferences() throws Exception {
        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_EPHEMERAL,
                "-r", RIGHT_EPHEMERAL,
                "-b", "0",
                "-n", "0"
        ));
        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testInteractiveMode_UnknownAbsolutePath_IsReportedAndComparisonCanFinish()
            throws Exception {
        assertCoreAssets();
        StringBuilder input = new StringBuilder("/path-not-present-in-either-fixture\n");
        for (int i = 0; i < 256; i++) {
            input.append('\n');
        }
        RunResult result = runSnapshotComparer(
                args("-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i"),
                input.toString()
        );
        assertCompletedSuccessfully(result);
        assertOutputContains(result,
                "Path /path-not-present-in-either-fixture is neither found in left tree nor right tree.");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testLongOptionNames_AreAccepted() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args(
                "--left", LEFT,
                "--right", RIGHT_IDENTICAL,
                "--bytes", "0",
                "--nodes", "0"
        ));
        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading() throws Exception {
        assertAssetExists(LEFT);
        assertFalse("Ghost file must not exist for this test", new File(GHOST_RIGHT).exists());
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0"));
        assertFailed(result);
        assertOutputContainsAny(result, "no such file", "file not found", "filenotfoundexception", "cannot find");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testCorruptSnapshot_FailsDeserialization() throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(CORRUPT);
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", CORRUPT,
                "-b", "0",
                "-n", "0"
        ));
        assertFailed(result);
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testNonNumericByteThreshold_FailsBeforeSnapshotsAreLoaded() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number",
                "-n", "0"
        ));
        assertFailed(result);
        assertOutputContainsAny(result, "numberformatexception", "for input string", "not-a-number");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    private static RunResult runMixedComparison(String bytes, String nodes) throws Exception {
        return runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", bytes,
                "-n", nodes
        ));
    }

    private static String[] args(String... values) {
        return values;
    }

    private static RunResult runSnapshotComparer(String[] arguments) throws Exception {
        return runSnapshotComparer(arguments, "");
    }

    private static RunResult runSnapshotComparer(String[] arguments, String standardInput) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        InputStream originalIn = System.in;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        Throwable failure = null;
        try (PrintStream capture = new PrintStream(captured, true, StandardCharsets.UTF_8.name())) {
            System.setOut(capture);
            System.setErr(capture);
            System.setIn(new ByteArrayInputStream(standardInput.getBytes(StandardCharsets.UTF_8)));
            try {
                SnapshotComparer.main(arguments);
            } catch (Throwable thrown) {
                failure = thrown;
                thrown.printStackTrace(capture);
            }
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
        return new RunResult(captured.toString(StandardCharsets.UTF_8.name()), failure);
    }

    private static void assertCoreAssets() {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_IDENTICAL);
        assertAssetExists(RIGHT_PLUS_1);
    }

    private static void assertMixedAssets() {
        assertAssetExists(LEFT_MIXED);
        assertAssetExists(RIGHT_MIXED);
    }

    private static void assertAssetExists(String path) {
        assertTrue("Required fixture does not exist: " + path, new File(path).isFile());
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        if (result.failure != null) {
            fail("SnapshotComparer failed unexpectedly with " + result.failure + "\nOutput:\n" + result.output);
        }
    }

    private static void assertFailed(RunResult result) {
        assertNotNull("Expected SnapshotComparer to fail. Output:\n" + result.output, result.failure);
    }

    private static void assertOutputContains(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> but was:\n" + result.output,
                result.output.contains(expected));
    }

    private static void assertOutputDoesNotContain(RunResult result, String unexpected) {
        assertFalse("Expected output not to contain <" + unexpected + "> but was:\n" + result.output,
                result.output.contains(unexpected));
    }

    private static void assertOutputContainsAny(RunResult result, String... alternatives) {
        String lowerOutput = result.output.toLowerCase(Locale.ROOT);
        for (String alternative : alternatives) {
            if (lowerOutput.contains(alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }
        fail("Expected output to contain one of " + java.util.Arrays.toString(alternatives)
                + " but was:\n" + result.output);
    }

    private static void assertQuantitativeDeltaForPath(RunResult result, String path) {
        Pattern pattern = Pattern.compile("(?m)^Node\\s+" + Pattern.quote(path)
                + "\\s+found in both trees\\. Delta:\\s+-?\\d+ bytes,\\s+-?\\d+ descendants\\s*$");
        assertTrue("Expected a quantitative delta for " + path + " but output was:\n" + result.output,
                pattern.matcher(result.output).find());
    }

    private static void assertNoQuantitativeDeltaForPath(RunResult result, String path) {
        Pattern pattern = Pattern.compile("(?m)^Node\\s+" + Pattern.quote(path)
                + "\\s+found in both trees\\. Delta:");
        assertFalse("Did not expect a quantitative delta for " + path + " but output was:\n" + result.output,
                pattern.matcher(result.output).find());
    }

    private static Delta extractPayloadDelta(RunResult result) {
        Matcher matcher = PAYLOAD_DELTA.matcher(result.output);
        assertTrue("Expected /payload delta in baseline output:\n" + result.output, matcher.find());
        return new Delta(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)));
    }

    private static final class Delta {
        final long bytes;
        final long descendants;

        Delta(long bytes, long descendants) {
            this.bytes = bytes;
            this.descendants = descendants;
        }
    }

    private static final class RunResult {
        final String output;
        final Throwable failure;

        RunResult(String output, Throwable failure) {
            this.output = output;
            this.failure = failure;
        }
    }
}
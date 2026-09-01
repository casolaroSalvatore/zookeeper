package org.apache.zookeeper.server.snapshotcomparer.variant_c2.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.zookeeper.util.ServiceUtils;
import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;


/**
 * Public-behavior tests for {@link SnapshotComparer}.
 *
 * <p>The tests invoke SnapshotComparer through the public main method in the
 * current JUnit JVM. The ZooKeeper system-exit procedure is temporarily
 * replaced so invalid invocations cannot terminate Surefire or PIT.
 *
 * <p>In-process execution allows JaCoCo and PIT to observe the production
 * code exercised by the tests.
 */

public class SnapshotComparerGuidedToTFewShotTest {

    private static final String CORRUPT =
            "src/test/resources/data/comparer/corrupt_file.snap";
    private static final String LEFT =
            "src/test/resources/data/comparer/left.snap";
    private static final String LEFT_MIXED =
            "src/test/resources/data/comparer/left_mixed.snap";
    private static final String RIGHT_IDENTICAL =
            "src/test/resources/data/comparer/right_identical.snap";
    private static final String RIGHT_MIXED =
            "src/test/resources/data/comparer/right_mixed.snap";
    private static final String RIGHT_PLUS_1_GZ =
            "src/test/resources/data/comparer/right_plus_1.gz";
    private static final String RIGHT_PLUS_1 =
            "src/test/resources/data/comparer/right_plus_1.snap";
    private static final String LEFT_EPHEMERAL =
            "src/test/resources/data/comparer/left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL =
            "src/test/resources/data/comparer/right_ephemeral.snap";
    private static final String GHOST_RIGHT =
            "src/test/resources/data/comparer/ghost_right.snap";

    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    private static final Pattern PAYLOAD_DELTA_PATTERN = Pattern.compile(
            "Node\\s+/payload\\s+found in both trees\\.\\s+"
                    + "Delta:\\s+(-?\\d+)\\s+bytes,\\s+"
                    + "(-?\\d+)\\s+descendants",
            Pattern.CASE_INSENSITIVE);

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDifferences()
            throws Exception {

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
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "Node count:");
        assertOutputContains(result, "Total size:");
        assertOutputContains(result, "Max depth:");

        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testLongOptions_IdenticalSnapshots_AreAccepted()
            throws Exception {

        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "--left", LEFT,
                "--right", RIGHT_IDENTICAL,
                "--bytes", "0",
                "--nodes", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result,
                "Printing analysis for nodes difference larger than 0 bytes "
                        + "or node count difference larger than 0.");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        assertCoreAssets();
        assertAssetExists(RIGHT_PLUS_1);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Node /nodo_extra found only in right tree");
        assertOutputContains(
                result,
                "Node /payload found only in right tree");
    }

    @Test
    public void testGzipSnapshot_MatchesEquivalentUncompressedSnapshot()
            throws Exception {

        assertAssetExists(RIGHT_PLUS_1);
        assertAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", RIGHT_PLUS_1,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "right_plus_1.snap");
        assertOutputContains(result, "right_plus_1.gz");
        assertOutputContains(result, "All layers compared.");

        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testMixedSnapshots_ZeroThreshold_ReportsPayloadDelta()
            throws Exception {

        assertMixedAssets();

        RunResult result = runMixedComparison("0", "0");

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/payload");
    }

    @Test
    public void testByteThreshold_BelowObservedDelta_ReportsPayloadDelta()
            throws Exception {

        assertMixedAssets();

        RunResult baseline = runMixedComparison("0", VERY_HIGH_THRESHOLD);
        assertCompletedSuccessfully(baseline);

        long byteDelta = absolutePayloadByteDelta(baseline);
        assertTrue(
                "The mixed fixtures must expose a non-zero /payload byte delta."
                        + "\nOutput:\n" + baseline.output,
                byteDelta > 0L);
        assertTrue(
                "Observed byte delta must fit the CLI's int threshold.",
                byteDelta <= Integer.MAX_VALUE);

        RunResult result = runMixedComparison(
                String.valueOf(byteDelta - 1L),
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(
                result,
                "/payload",
                byteDelta + " bytes");
    }

    @Test
    public void testByteThreshold_EqualToObservedDelta_FiltersPayloadDelta()
            throws Exception {

        assertMixedAssets();

        RunResult baseline = runMixedComparison("0", VERY_HIGH_THRESHOLD);
        assertCompletedSuccessfully(baseline);

        long byteDelta = absolutePayloadByteDelta(baseline);
        assertTrue(
                "The mixed fixtures must expose a non-zero /payload byte delta."
                        + "\nOutput:\n" + baseline.output,
                byteDelta > 0L);
        assertTrue(
                "Observed byte delta must fit the CLI's int threshold.",
                byteDelta <= Integer.MAX_VALUE);

        RunResult result = runMixedComparison(
                String.valueOf(byteDelta),
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(
                result,
                "Node /payload found in both trees. Delta:");
    }

    @Test
    public void testVeryHighThresholds_SuppressOrdinaryDifferenceReports()
            throws Exception {

        assertMixedAssets();

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "All layers compared.");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testDebugMode_ExposesComparisonDiagnostics()
            throws Exception {

        assertMixedAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContainsAny(
                result,
                "Comparing ",
                "Filtered node ",
                "Filtered left node ",
                "Filtered right node ");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_AbsolutePayloadPath_IsAccepted()
            throws Exception {

        assertMixedAssets();

        RunResult result = runSnapshotComparerWithInput(
                args(
                        "-l", LEFT_MIXED,
                        "-r", RIGHT_MIXED,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                ),
                interactiveInput("/payload", 64));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Current depth is 0");
        assertOutputContains(result, "Analysis for node /payload");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testEphemeralFixtures_LoadAndComparisonCompletes()
            throws Exception {

        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_EPHEMERAL,
                "-r", RIGHT_EPHEMERAL,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "left_ephemeral.snap");
        assertOutputContains(result, "right_ephemeral.snap");
        assertOutputContains(result, "Node count:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading()
            throws Exception {

        assertAssetExists(LEFT);
        assertFalse(
                "Ghost file must not exist for this test",
                new File(GHOST_RIGHT).exists());

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", GHOST_RIGHT,
                "-b", "0",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "no such file",
                "file not found",
                "filenotfoundexception",
                "cannot find");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testCorruptSnapshot_FailsDeserialization()
            throws Exception {

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
        assertOutputContainsAny(
                result,
                "exception",
                "error",
                "corrupt",
                "checksum",
                "eof");
    }

    @Test
    public void testMissingRequiredRightOption_FailsWithUsage()
            throws Exception {

        assertAssetExists(LEFT);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-b", "0",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "missing required option",
                "missing required options",
                "required");
        assertOutputContains(result, "SnapshotComparer");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testUnknownOption_FailsWithUsage() throws Exception {
        RunResult result = runSnapshotComparer(args("--unknown"));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "unrecognized option",
                "unknown option",
                "--unknown");
        assertOutputContains(result, "SnapshotComparer");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testNonNumericByteThreshold_FailsBeforeSnapshotLoading()
            throws Exception {

        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "Deserialized snapshot");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    private static RunResult runMixedComparison(
            String byteThreshold,
            String nodeThreshold) throws Exception {

        return runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", byteThreshold,
                "-n", nodeThreshold
        ));
    }

    private static RunResult runSnapshotComparer(String[] comparerArgs)
            throws Exception {

        return runSnapshotComparerWithInput(comparerArgs, "");
    }

    private static RunResult runSnapshotComparerWithInput(
            String[] comparerArgs,
            String standardInput) throws Exception {

        synchronized (ServiceUtils.class) {
            PrintStream originalOut = System.out;
            PrintStream originalErr = System.err;
            InputStream originalIn = System.in;

            ByteArrayOutputStream capturedOutput =
                    new ByteArrayOutputStream();

            PrintStream capturedStream = new PrintStream(
                    capturedOutput,
                    true,
                    StandardCharsets.UTF_8.name());

            String effectiveInput =
                    standardInput == null ? "" : standardInput;

            int exitCode = 0;

            try {
                System.setIn(new ByteArrayInputStream(
                        effectiveInput.getBytes(StandardCharsets.UTF_8)));

                System.setOut(capturedStream);
                System.setErr(capturedStream);

                ServiceUtils.setSystemExitProcedure(
                        code -> {
                            throw new ExitRequestedException(code);
                        });

                SnapshotComparer.main(comparerArgs);

            } catch (ExitRequestedException exitRequested) {
                exitCode = exitRequested.exitCode;

            } catch (Exception failure) {
                exitCode = 1;
                failure.printStackTrace(capturedStream);

            } finally {
                capturedStream.flush();

                ServiceUtils.setSystemExitProcedure(
                        ServiceUtils.SYSTEM_EXIT);

                System.setIn(originalIn);
                System.setOut(originalOut);
                System.setErr(originalErr);
            }

            String output = new String(
                    capturedOutput.toByteArray(),
                    StandardCharsets.UTF_8);

            capturedStream.close();

            return new RunResult(
                    exitCode,
                    output,
                    Collections.unmodifiableList(
                            Arrays.asList(comparerArgs.clone())));
        }
    }

    private static String interactiveInput(
            String firstCommand,
            int followingBlankLines) {

        StringBuilder input = new StringBuilder();
        input.append(firstCommand).append('\n');

        for (int index = 0; index < followingBlankLines; index++) {
            input.append('\n');
        }

        return input.toString();
    }

    private static String[] args(String... values) {
        return values;
    }

    private static void assertCoreAssets() {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_IDENTICAL);
    }

    private static void assertMixedAssets() {
        assertAssetExists(LEFT_MIXED);
        assertAssetExists(RIGHT_MIXED);
    }

    private static void assertAssetExists(String path) {
        File asset = new File(path);

        assertTrue(
                "Required fixture does not exist: "
                        + asset.getAbsolutePath(),
                asset.isFile());
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals(
                "Expected SnapshotComparer to complete successfully."
                        + "\nCommand: " + result.command
                        + "\nOutput:\n" + result.output,
                0,
                result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals(
                "Expected SnapshotComparer to fail."
                        + "\nCommand: " + result.command
                        + "\nOutput:\n" + result.output,
                0,
                result.exitCode);
    }

    private static void assertOutputContains(
            RunResult result,
            String expectedText) {

        assertTrue(
                "Expected output to contain: " + expectedText
                        + "\nCommand: " + result.command
                        + "\nOutput:\n" + result.output,
                result.output.contains(expectedText));
    }

    private static void assertOutputContainsAny(
            RunResult result,
            String... expectedAlternatives) {

        String normalizedOutput =
                result.output.toLowerCase(Locale.ROOT);

        for (String alternative : expectedAlternatives) {
            if (normalizedOutput.contains(
                    alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }

        fail("Expected output to contain at least one of "
                + Arrays.toString(expectedAlternatives)
                + "\nCommand: " + result.command
                + "\nOutput:\n" + result.output);
    }

    private static void assertOutputDoesNotContain(
            RunResult result,
            String unexpectedText) {

        assertFalse(
                "Expected output not to contain: " + unexpectedText
                        + "\nCommand: " + result.command
                        + "\nOutput:\n" + result.output,
                result.output.contains(unexpectedText));
    }

    private static void assertQuantitativeDeltaForPath(
            RunResult result,
            String path) {

        Pattern pattern = Pattern.compile(
                "Node\\s+"
                        + Pattern.quote(path)
                        + "\\s+found in both trees\\.\\s+"
                        + "Delta:\\s+-?\\d+\\s+bytes,\\s+"
                        + "-?\\d+\\s+descendants",
                Pattern.CASE_INSENSITIVE);

        assertTrue(
                "Expected a quantitative delta for path " + path
                        + "\nOutput:\n" + result.output,
                pattern.matcher(result.output).find());
    }

    private static void assertQuantitativeDeltaForPath(
            RunResult result,
            String path,
            String expectedByteDelta) {

        Pattern pattern = Pattern.compile(
                "Node\\s+"
                        + Pattern.quote(path)
                        + "\\s+found in both trees\\.\\s+"
                        + "Delta:\\s+-?"
                        + Pattern.quote(expectedByteDelta)
                        + ",\\s+-?\\d+\\s+descendants",
                Pattern.CASE_INSENSITIVE);

        assertTrue(
                "Expected a quantitative delta for path "
                        + path
                        + " containing "
                        + expectedByteDelta
                        + "\nOutput:\n"
                        + result.output,
                pattern.matcher(result.output).find());
    }

    private static long absolutePayloadByteDelta(RunResult result) {
        Matcher matcher = PAYLOAD_DELTA_PATTERN.matcher(result.output);

        assertTrue(
                "Expected the mixed fixtures to report a /payload delta."
                        + "\nOutput:\n" + result.output,
                matcher.find());

        long signedDelta = Long.parseLong(matcher.group(1));

        assertTrue(
                "Cannot safely take the absolute value of Long.MIN_VALUE.",
                signedDelta != Long.MIN_VALUE);

        return Math.abs(signedDelta);
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

    private static final class RunResult {
        private final int exitCode;
        private final String output;
        private final List<String> command;

        private RunResult(
                int exitCode,
                String output,
                List<String> command) {

            this.exitCode = exitCode;
            this.output = output;
            this.command = command;
        }
    }
}
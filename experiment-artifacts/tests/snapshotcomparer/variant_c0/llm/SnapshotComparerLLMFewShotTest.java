package org.apache.zookeeper.server.snapshotcomparer.llm;

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
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.apache.zookeeper.server.SnapshotComparer;
import org.apache.zookeeper.util.ServiceUtils;

public class SnapshotComparerLLMFewShotTest {

    private static final String LEFT =
            "src/test/resources/data/comparer/left.snap";
    private static final String RIGHT_PLUS_1 =
            "src/test/resources/data/comparer/right_plus_1.snap";
    private static final String RIGHT_IDENTICAL =
            "src/test/resources/data/comparer/right_identical.snap";
    private static final String CORRUPT_FILE =
            "src/test/resources/data/comparer/corrupt_file.snap";
    private static final String RIGHT_PLUS_1_GZ =
            "src/test/resources/data/comparer/right_plus_1.gz";
    private static final String LEFT_MIXED =
            "src/test/resources/data/comparer/left_mixed.snap";
    private static final String RIGHT_MIXED =
            "src/test/resources/data/comparer/right_mixed.snap";
    private static final String GHOST_RIGHT =
            "src/test/resources/data/comparer/ghost_right.snap";
    private static final String LEFT_EPHEMERAL =
            "src/test/resources/data/comparer/left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL =
            "src/test/resources/data/comparer/right_ephemeral.snap";

    @BeforeClass
    public static void assertRequiredFixturesAreAvailable() {
        assertFixtureExists(LEFT);
        assertFixtureExists(RIGHT_PLUS_1);
        assertFixtureExists(RIGHT_IDENTICAL);
        assertFixtureExists(CORRUPT_FILE);
        assertFixtureExists(RIGHT_PLUS_1_GZ);
        assertFixtureExists(LEFT_MIXED);
        assertFixtureExists(RIGHT_MIXED);
        assertFixtureExists(LEFT_EPHEMERAL);
        assertFixtureExists(RIGHT_EPHEMERAL);
    }

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportingDifferences() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "Printing analysis for nodes difference larger than 0 bytes");
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "All layers compared.");

        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testLongOptions_AreAccepted() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "--left", LEFT,
                "--right", RIGHT_IDENTICAL,
                "--bytes", "0",
                "--nodes", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "All layers compared.");
        assertOutputDoesNotContain(result, "found only in");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
        assertOutputContains(result, "Descendant size:");
        assertOutputContains(result, "Descendant count:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testRelation_ReversingSnapshots_ReportsPathsOnlyInLeft() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", RIGHT_PLUS_1,
                "-r", LEFT,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in left tree");
        assertOutputContains(result, "Node /payload found only in left tree");
        assertOutputDoesNotContain(result, "Node /nodo_extra found only in right tree");
        assertOutputDoesNotContain(result, "Node /payload found only in right tree");
    }

    @Test
    public void testGzipSnapshot_IsAutomaticallyDecompressedAndCompared() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Deserialized snapshot in right_plus_1.gz");
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testVeryHighThresholds_FilterAllObservableDifferences() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", String.valueOf(Integer.MAX_VALUE),
                "-n", String.valueOf(Integer.MAX_VALUE)
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Printing analysis for nodes difference larger than "
                        + Integer.MAX_VALUE
                        + " bytes");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testByteThreshold_IsStrictlyGreaterThanConfiguredValue() throws Exception {
        RunResult unfiltered = runMixedComparison("-1", String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(unfiltered);
        int payloadDelta = absolutePayloadByteDelta(unfiltered);
        assertTrue("Mixed fixtures must expose a non-zero /payload byte delta", payloadDelta > 0);

        RunResult belowDelta = runMixedComparison(
                String.valueOf(payloadDelta - 1),
                String.valueOf(Integer.MAX_VALUE));
        RunResult exactlyAtDelta = runMixedComparison(
                String.valueOf(payloadDelta),
                String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(belowDelta);
        assertCompletedSuccessfully(exactlyAtDelta);
        assertQuantitativeDeltaForPath(belowDelta, "/payload", payloadDelta + " bytes");
        assertNoQuantitativeDeltaForPath(exactlyAtDelta, "/payload");
    }

    @Test
    public void testNegativeThresholds_CauseOtherwiseEqualNodesToBePrinted() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "-1",
                "-n", "-1"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "found in both trees. Delta: 0 bytes, 0 descendants");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testDebugMode_ReportsComparisonsAndFilteredNodes() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", String.valueOf(Integer.MAX_VALUE),
                "-n", String.valueOf(Integer.MAX_VALUE),
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Comparing ");
        assertOutputContains(result, "same");
        assertOutputContains(result, "Filtered node ");
        assertOutputContains(result, "left size");
        assertOutputContains(result, "right size");
        assertOutputContains(result, "All layers compared.");
    }

    @Ignore
    @Test
    public void testEphemeralNodes_AreNotReportedAsSnapshotDifferences() throws Exception {
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
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_EmptyInputPrintsCurrentDepthAndCompletes()
            throws Exception {
        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"),
                repeatedNewLines(64));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Current depth is 0");
        assertOutputContains(result, "Press enter to move to print current depth layer");
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_InvalidInputPrintsGuidanceAndContinues()
            throws Exception {
        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"),
                "not-a-depth\n" + repeatedNewLines(64));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Input not-a-depth is not valid.");
        assertOutputContains(result, "Path must be an absolute path which starts with '/'.");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_OutOfRangeDepthPrintsAllowedRange()
            throws Exception {
        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"),
                "2147483647\n" + repeatedNewLines(64));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Depth must be in range [0,");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_UnknownAbsolutePathIsReported()
            throws Exception {
        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"),
                "/path-that-does-not-exist\n" + repeatedNewLines(64));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Analysis for node /path-that-does-not-exist");
        assertOutputContains(
                result,
                "Path /path-that-does-not-exist is neither found in left tree nor right tree.");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRequiredOption_FailsWithUsageInformation() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "missing required option",
                "missing required options",
                "required option");
        assertOutputContains(result, "java -cp");
        assertOutputContains(result, "--left");
        assertOutputContains(result, "--right");
        assertOutputContains(result, "--bytes");
        assertOutputContains(result, "--nodes");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testUnknownOption_FailsWithUsageInformation() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0",
                "--unknown-option"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "unrecognized option",
                "unknown option",
                "unexpected option");
        assertOutputContains(result, "java -cp");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    /* Allucination by LLM
    @Test
    public void testNonNumericByteThreshold_FailsBeforeSnapshotsAreLoaded()
            throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "All layers compared.");
    } */

    @Test
    public void testNonNumericByteThreshold_FailsBeforeSnapshotsAreLoaded()
            throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number",
                "-n", "0"
        ));

        assertFailed(result);
        // Correction: the program does not have to print this message if parsing fails
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    /* Allucination by LLM
    @Test
    public void testNonNumericNodeThreshold_FailsBeforeSnapshotsAreLoaded()
            throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "not-a-number"
        ));

        assertFailed(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "All layers compared.");
    } */


    @Test
    public void testNonNumericNodeThreshold_FailsBeforeSnapshotsAreLoaded()
            throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "not-a-number"
        ));

        assertFailed(result);
        // Correction: the program does not have to print this message if parsing fails
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testMissingSnapshot_FailsLoading() throws Exception {
        assertFalse(
                "The ghost fixture path must remain absent so it can represent a missing file",
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
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testCorruptSnapshot_FailsDeserialization() throws Exception {
        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", CORRUPT_FILE,
                "-b", "0",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    private static RunResult runMixedComparison(String byteThreshold, String nodeThreshold)
            throws Exception {
        return runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", byteThreshold,
                "-n", nodeThreshold
        ));
    }

    private static String[] args(String... args) {
        return args;
    }

    private static RunResult runSnapshotComparer(String[] comparerArguments)
            throws Exception {
        return runSnapshotComparer(comparerArguments, "");
    }

    private static RunResult runSnapshotComparer(
            String[] comparerArguments,
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

                SnapshotComparer.main(comparerArguments);

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

                capturedStream.close();
            }

            return new RunResult(
                    exitCode,
                    new String(
                            capturedOutput.toByteArray(),
                            StandardCharsets.UTF_8));
        }
    }

    private static int absolutePayloadByteDelta(RunResult result) {
        Pattern pattern = Pattern.compile(
                "Node\\s+/payload\\s+found in both trees\\.\\s+Delta:\\s+(-?\\d+)\\s+bytes",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(result.output);

        if (!matcher.find()) {
            fail("No quantitative /payload delta was present in output:\n" + result.output);
        }

        long signedDelta = Long.parseLong(matcher.group(1));
        long absoluteDelta = Math.abs(signedDelta);
        assertTrue("Payload delta is too large for an integer threshold",
                absoluteDelta <= Integer.MAX_VALUE);
        return (int) absoluteDelta;
    }

    private static void assertQuantitativeDeltaForPath(
            RunResult result,
            String path,
            String expectedByteDelta) {
        Pattern pattern = Pattern.compile(
                "Node\\s+"
                        + Pattern.quote(path)
                        + "\\s+found in both trees\\.\\s+Delta:\\s+-?"
                        + Pattern.quote(expectedByteDelta),
                Pattern.CASE_INSENSITIVE);
        assertTrue(
                "Expected a quantitative delta for " + path + " in output:\n" + result.output,
                pattern.matcher(result.output).find());
    }

    private static void assertNoQuantitativeDeltaForPath(
            RunResult result,
            String path) {
        Pattern pattern = Pattern.compile(
                "Node\\s+"
                        + Pattern.quote(path)
                        + "\\s+found in both trees\\.\\s+Delta:",
                Pattern.CASE_INSENSITIVE);
        assertFalse(
                "Did not expect a quantitative delta for " + path + " in output:\n"
                        + result.output,
                pattern.matcher(result.output).find());
    }

    private static void assertFixtureExists(String path) {
        File fixture = new File(path);
        assertTrue("Required fixture does not exist: " + fixture.getAbsolutePath(),
                fixture.isFile());
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals(
                "Expected SnapshotComparer to succeed, but output was:\n" + result.output,
                0,
                result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals(
                "Expected SnapshotComparer to fail, but output was:\n" + result.output,
                0,
                result.exitCode);
    }

    private static void assertOutputContains(RunResult result, String expected) {
        assertTrue(
                "Expected output to contain <" + expected + ">, but output was:\n"
                        + result.output,
                result.output.contains(expected));
    }

    private static void assertOutputDoesNotContain(RunResult result, String unexpected) {
        assertFalse(
                "Expected output not to contain <" + unexpected + ">, but output was:\n"
                        + result.output,
                result.output.contains(unexpected));
    }

    private static void assertOutputContainsAny(
            RunResult result,
            String... expectedAlternatives) {
        String normalizedOutput = result.output.toLowerCase(Locale.ROOT);
        for (String alternative : expectedAlternatives) {
            if (normalizedOutput.contains(alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }

        fail("Expected output to contain at least one of "
                + java.util.Arrays.toString(expectedAlternatives)
                + ", but output was:\n"
                + result.output);
    }

    private static String repeatedNewLines(int count) {
        StringBuilder input = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            input.append('\n');
        }
        return input.toString();
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

        private RunResult(int exitCode, String output) {
            this.exitCode = exitCode;
            this.output = output;
        }
    }
}
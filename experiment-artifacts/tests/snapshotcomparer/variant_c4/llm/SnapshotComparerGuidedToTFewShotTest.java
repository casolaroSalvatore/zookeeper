package org.apache.zookeeper.server.snapshotcomparer.variant_c4.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.zookeeper.util.ServiceUtils;
import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box JUnit 4 tests for {@link SnapshotComparer}.
 *
 * <p>The tests invoke the public main entry point directly in the current
 * JUnit JVM. The ZooKeeper system-exit procedure is temporarily replaced so
 * command-line failures cannot terminate Surefire or PIT.
 *
 * <p>Executing SnapshotComparer in-process allows JaCoCo and PIT to observe
 * the production code exercised by these tests.
 */

public class SnapshotComparerGuidedToTFewShotTest {

    private static final String RESOURCE_ROOT =
            "src/test/resources/data/comparer/";

    private static final String CORRUPT_FILE =
            RESOURCE_ROOT + "corrupt_file.snap";
    private static final String LEFT =
            RESOURCE_ROOT + "left.snap";
    private static final String LEFT_MIXED =
            RESOURCE_ROOT + "left_mixed.snap";
    private static final String RIGHT_IDENTICAL =
            RESOURCE_ROOT + "right_identical.snap";
    private static final String RIGHT_MIXED =
            RESOURCE_ROOT + "right_mixed.snap";
    private static final String RIGHT_PLUS_1_GZ =
            RESOURCE_ROOT + "right_plus_1.gz";
    private static final String RIGHT_PLUS_1 =
            RESOURCE_ROOT + "right_plus_1.snap";
    private static final String LEFT_EPHEMERAL =
            RESOURCE_ROOT + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL =
            RESOURCE_ROOT + "right_ephemeral.snap";
    private static final String GHOST_RIGHT =
            RESOURCE_ROOT + "ghost_right.snap";

    private static final String VERY_HIGH_THRESHOLD =
            String.valueOf(Integer.MAX_VALUE);


    @Test
    public void testRelation_IdenticalSnapshots_ReportNoDifferences()
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
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "Delta:");
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
        assertOutputContains(
                result,
                "Node /nodo_extra found only in right tree"
        );
        assertOutputContains(
                result,
                "Node /payload found only in right tree"
        );
    }

    @Test
    public void testCompressedSnapshot_GzipRightSnapshot_IsAccepted()
            throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Deserialized snapshot in right_plus_1.gz");
        assertOutputContains(
                result,
                "Node /nodo_extra found only in right tree"
        );
        assertOutputContains(
                result,
                "Node /payload found only in right tree"
        );
    }

    @Test
    public void testByteThreshold_Zero_ReportsMixedPayloadDelta()
            throws Exception {
        assertMixedAssets();

        RunResult result = runMixedComparison("0", VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/payload");
    }

    @Test
    public void testThresholds_MaximumValues_FilterMixedComparison()
            throws Exception {
        assertMixedAssets();

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                VERY_HIGH_THRESHOLD
        );

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Printing analysis for nodes difference larger than "
                        + VERY_HIGH_THRESHOLD
                        + " bytes or node count difference larger than "
                        + VERY_HIGH_THRESHOLD
                        + "."
        );
        assertOutputDoesNotContain(result, "Delta:");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
    }

    @Test
    public void testDebug_IdenticalSnapshots_ExposeDiagnosticOutput()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0",
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContainsAny(
                result,
                "Comparing ",
                "Filtered node ",
                "Filtered left node ",
                "Filtered right node "
        );
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
        assertOutputDoesNotContain(result, "Delta:");
    }

    @Test
    public void testEphemeralSnapshots_CanBeLoadedAndCompared()
            throws Exception {
        assertEphemeralAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_EPHEMERAL,
                "-r", RIGHT_EPHEMERAL,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Deserialized snapshot in left_ephemeral.snap"
        );
        assertOutputContains(
                result,
                "Deserialized snapshot in right_ephemeral.snap"
        );
    }

    @Test
    public void testValidFixtures_SelfComparison_HasNoDifferences()
            throws Exception {
        String[] fixtures = {
                LEFT,
                LEFT_MIXED,
                RIGHT_IDENTICAL,
                RIGHT_MIXED,
                RIGHT_PLUS_1_GZ,
                RIGHT_PLUS_1,
                LEFT_EPHEMERAL,
                RIGHT_EPHEMERAL
        };

        for (String fixture : fixtures) {
            assertAssetExists(fixture);

            RunResult result = runSnapshotComparer(args(
                    "-l", fixture,
                    "-r", fixture,
                    "-b", "0",
                    "-n", "0"
            ));

            assertCompletedSuccessfully(
                    "Self-comparison failed for " + fixture,
                    result
            );
            assertOutputDoesNotContain(result, "found only in left tree");
            assertOutputDoesNotContain(result, "found only in right tree");
            assertOutputDoesNotContain(result, "Delta:");
        }
    }

    @Test
    public void testInteractive_EmptyInput_AdvancesUntilCompletion()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(
                repeatedNewlines(128),
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                )
        );

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Current depth is 0");
        assertOutputContains(
                result,
                "Press enter to move to print current depth layer"
        );
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractive_InvalidDepthInput_IsReportedAndCanContinue()
            throws Exception {
        assertCoreAssets();

        String input = "not-a-depth\n" + repeatedNewlines(128);
        RunResult result = runSnapshotComparer(
                input,
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                )
        );

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Input not-a-depth is not valid."
        );
        assertOutputContains(
                result,
                "Path must be an absolute path which starts with '/'."
        );
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading()
            throws Exception {
        assertAssetExists(LEFT);
        assertFalse(
                "Ghost file must not exist for this test",
                new File(GHOST_RIGHT).exists()
        );

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
                "cannot find"
        );
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testFileLeft_CorruptSnapshot_FailsDeserialization()
            throws Exception {
        assertAssetExists(CORRUPT_FILE);
        assertAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", CORRUPT_FILE,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testOptions_MissingRequiredRightOption_FailsWithUsage()
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
                "missing required options"
        );
        assertOutputContains(result, "java -cp <classPath>");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testByteThreshold_NonIntegerValue_FailsBeforeLoadingSnapshots()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-an-integer",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputDoesNotContain(result, "All layers compared.");
        assertOutputDoesNotContain(result, "Deserialized snapshot");
    }

    @Test
    public void testNodeThreshold_NonIntegerValue_FailsBeforeLoadingSnapshots()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "not-an-integer"
        ));

        assertFailed(result);
        assertOutputDoesNotContain(result, "All layers compared.");
        assertOutputDoesNotContain(result, "Deserialized snapshot");
    }

    @Test
    public void testOptions_UnknownOption_FailsWithUsage()
            throws Exception {
        assertCoreAssets();

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
                "unknown option"
        );
        assertOutputContains(result, "java -cp <classPath>");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    private static RunResult runMixedComparison(
            String byteThreshold,
            String nodeThreshold
    ) throws Exception {
        return runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", byteThreshold,
                "-n", nodeThreshold
        ));
    }

    private static RunResult runSnapshotComparer(String[] arguments)
            throws Exception {
        return runSnapshotComparer("", arguments);
    }

    private static RunResult runSnapshotComparer(
            String standardInput,
            String[] arguments) throws Exception {

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

                SnapshotComparer.main(arguments);

            } catch (ExitRequestedException requestedExit) {
                exitCode = requestedExit.exitCode;

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

            return new RunResult(exitCode, output);
        }
    }

    private static String repeatedNewlines(int count) {
        StringBuilder input = new StringBuilder(count);

        for (int index = 0; index < count; index++) {
            input.append('\n');
        }

        return input.toString();
    }

    private static String[] args(String... arguments) {
        return arguments;
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

    private static void assertEphemeralAssets() {
        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);
    }

    private static void assertAssetExists(String path) {
        File asset = new File(path);
        assertTrue(
                "Required snapshot fixture does not exist: "
                        + asset.getAbsolutePath(),
                asset.isFile()
        );
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertCompletedSuccessfully(
                "SnapshotComparer was expected to complete successfully",
                result
        );
    }

    private static void assertCompletedSuccessfully(
            String message,
            RunResult result
    ) {
        assertNotNull(message + ": result was null", result);
        assertEquals(
                message + ". Output:\n" + result.output,
                0,
                result.exitCode
        );
        assertOutputContains(result, "All layers compared.");
    }

    private static void assertFailed(RunResult result) {
        assertNotNull("Run result must not be null", result);
        assertNotEquals(
                "SnapshotComparer was expected to fail. Output:\n"
                        + result.output,
                0,
                result.exitCode
        );
    }

    private static void assertOutputContains(
            RunResult result,
            String expected
    ) {
        assertTrue(
                "Expected output to contain:\n"
                        + expected
                        + "\nActual output:\n"
                        + result.output,
                result.output.contains(expected)
        );
    }

    private static void assertOutputContainsAny(
            RunResult result,
            String... expectedAlternatives
    ) {
        String normalizedOutput =
                result.output.toLowerCase(Locale.ROOT);

        for (String alternative : expectedAlternatives) {
            if (normalizedOutput.contains(
                    alternative.toLowerCase(Locale.ROOT)
            )) {
                return;
            }
        }

        fail(
                "Expected output to contain at least one of "
                        + Arrays.toString(expectedAlternatives)
                        + "\nActual output:\n"
                        + result.output
        );
    }

    private static void assertOutputDoesNotContain(
            RunResult result,
            String unexpected
    ) {
        assertFalse(
                "Expected output not to contain:\n"
                        + unexpected
                        + "\nActual output:\n"
                        + result.output,
                result.output.contains(unexpected)
        );
    }

    private static void assertQuantitativeDeltaForPath(
            RunResult result,
            String path
    ) {
        Pattern deltaPattern = Pattern.compile(
                "(?m)^Node "
                        + Pattern.quote(path)
                        + " found in both trees\\. Delta: "
                        + "-?\\d+ bytes, -?\\d+ descendants\\s*$"
        );

        assertTrue(
                "Expected a quantitative delta for path "
                        + path
                        + ". Actual output:\n"
                        + result.output,
                deltaPattern.matcher(result.output).find()
        );
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
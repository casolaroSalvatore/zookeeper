package org.apache.zookeeper.server.snapshotcomparer.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box JUnit 4 tests for {@link SnapshotComparer}.
 *
 * <p>The tests invoke only the public main entry point. A separate JVM is used
 * so that command-line exit behavior cannot terminate the JUnit process.</p>
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

    private static final long PROCESS_TIMEOUT_SECONDS = 60L;

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
            String[] arguments
    ) throws Exception {
        List<String> command = new ArrayList<String>();
        command.add(javaExecutable());
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(SnapshotComparer.class.getName());
        command.addAll(Arrays.asList(arguments));

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        try (OutputStream input = process.getOutputStream()) {
            if (standardInput != null && !standardInput.isEmpty()) {
                input.write(standardInput.getBytes(StandardCharsets.UTF_8));
                input.flush();
            }
        }

        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        Thread outputReader = createOutputReader(
                process.getInputStream(),
                capturedOutput
        );
        outputReader.start();

        boolean completed = process.waitFor(
                PROCESS_TIMEOUT_SECONDS,
                TimeUnit.SECONDS
        );

        if (!completed) {
            process.destroyForcibly();
            process.waitFor(10L, TimeUnit.SECONDS);
        }

        outputReader.join(TimeUnit.SECONDS.toMillis(10L));

        String output = new String(
                capturedOutput.toByteArray(),
                StandardCharsets.UTF_8
        );

        if (!completed) {
            fail(
                    "SnapshotComparer did not terminate within "
                            + PROCESS_TIMEOUT_SECONDS
                            + " seconds. Output:\n"
                            + output
            );
        }

        return new RunResult(process.exitValue(), output);
    }

    private static Thread createOutputReader(
            final InputStream source,
            final ByteArrayOutputStream destination
    ) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] buffer = new byte[4096];
                int count;

                try {
                    while ((count = source.read(buffer)) != -1) {
                        destination.write(buffer, 0, count);
                    }
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                } finally {
                    try {
                        source.close();
                    } catch (IOException ignored) {
                        // The process may already have closed its output.
                    }
                }
            }
        }, "snapshot-comparer-output-reader");

        thread.setDaemon(true);
        return thread;
    }

    private static String javaExecutable() {
        String executableName = isWindows() ? "java.exe" : "java";
        return new File(
                new File(System.getProperty("java.home"), "bin"),
                executableName
        ).getAbsolutePath();
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "")
                .toLowerCase(Locale.ROOT)
                .contains("win");
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

    private static final class RunResult {

        private final int exitCode;
        private final String output;

        private RunResult(int exitCode, String output) {
            this.exitCode = exitCode;
            this.output = output;
        }
    }
}
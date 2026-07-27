package org.apache.zookeeper.server.snapshotcomparer.blackbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Black-box tests for SnapshotComparer derived from Category Partition,
 * Boundary Value Analysis and the final selected test suite.
 *
 * SnapshotComparer is executed in a separate JVM. This preserves the real CLI
 * behavior, isolates System.in/System.out/System.err and allows System.exit to
 * be observed through the child-process exit code without SecurityManager.
 *
 * Required folder:
 *   src/test/resources/data/comparer/
 *
 * Required assets:
 *   left.snap
 *   right_plus_1.snap
 *   right_identical.snap
 *   right_plus_1.gz
 *   left_mixed.snap
 *   right_mixed.snap
 *
 * Additional assets required by the ephemeral-node test:
 *   left_ephemeral.snap
 *   right_ephemeral.snap
 *
 * The ephemeral pair must differ only, or at least observably, at the calibrated
 * ephemeral path /ephemeral_test. SnapshotComparer must not report that path.
 */

public class SnapshotComparerBlackBoxTest {

    private static final String BASE = "src/test/resources/data/comparer/";

    private static final String LEFT = BASE + "left.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String RIGHT_GZ = BASE + "right_plus_1.gz";
    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";
    private static final String LEFT_EPHEMERAL = BASE + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = BASE + "right_ephemeral.snap";
    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";

    private static final String LEFT_EPHEMERAL_PATH = "/effimero_sinistro";
    private static final String RIGHT_EPHEMERAL_PATH = "/ephemeral_test";

    // These calibrated values must match LEFT_MIXED and RIGHT_MIXED.
    // D_BYTES = 8 is observed on /payload and D_NODES = 1 is observed on /parent.
    private static final int D_BYTES = 8;
    private static final int D_NODES = 1;

    private static final String VERY_HIGH_THRESHOLD = "2147483647";
    private static final int INTERACTIVE_COMPLETION_NEWLINES = 10;
    private static final long PROCESS_TIMEOUT_SECONDS = 30L;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    // TEST

    // T0, testT0_BaseChoice_HappyPath
    @Test
    public void testT0_BaseChoice_HappyPath() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
        assertOutputDoesNotContainAny(result, "Exception in thread", "failed to deserialize");
    }

    // T1, testConfig_MissingNodeThreshold_PrintsUsageOrFailsGracefully
    @Test
    public void testConfig_MissingNodeThreshold_PrintsUsageOrFailsGracefully() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0"));

        assertFailed(result);
        assertOutputContainsAny(result, "usage", "missing", "required", "parse", "option");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    // T3, testConfig_DuplicateLeftFlag_DeterministicParserBehavior
    @Test
    public void testConfig_DuplicateLeftFlag_DeterministicParserBehavior() throws Exception {
        assertCoreAssets();
        assertAssetExists(RIGHT_IDENTICAL);

        String[] arguments = args("-l", LEFT, "-l", RIGHT_IDENTICAL, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");

        RunResult firstResult = runSnapshotComparer(arguments);
        RunResult secondResult = runSnapshotComparer(arguments);

        assertEquals("Repeated executions must have the same exit behavior", firstResult.exitStatus,
                secondResult.exitStatus);

        assertEquals("Repeated executions must have the same semantic behavior", semanticOutput(firstResult.output),
                semanticOutput(secondResult.output));

        assertTrue("Duplicate-option behavior must be controlled", firstResult.exitStatus != 0
                || firstResult.output.contains("All layers compared")
        );
    }

    // T4, testConfig_FlagWithoutArgument_FailsParsing
    @Test
    public void testConfig_FlagWithoutArgument_FailsParsing() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n"));

        assertFailed(result);
        assertOutputContainsAny(result, "usage", "missing", "argument", "parse", "option");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    // T7, testThreshold_IntegerOverflow_FailsParsing
    @Test
    public void testThreshold_IntegerOverflow_FailsParsing() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "2147483648", "-n", "0"));

        assertFailed(result);
        assertOutputContainsAny(result, "numberformatexception", "for input string", "integer", "parse");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    // T10, testFileLeft_CorruptedSnapshot_FailsDeserialization
    @Test
    public void testFileLeft_CorruptedSnapshot_FailsDeserialization() throws Exception {
        assertAssetExists(RIGHT_PLUS_1);
        File corruptFile = temporaryFolder.newFile("corrupt_file.snap");
        Files.write(corruptFile.toPath(), "this is not a valid ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));

        RunResult result = runSnapshotComparer(args("-l", corruptFile.getAbsolutePath(), "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

        assertFailed(result);
        assertOutputContainsAny(result, "snapshot", "magic", "checksum", "deserialize", "exception", "eof");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    // T17, testContent_EphemeralNodes_AreIgnored
    @Ignore("Defect: SnapshotComparer reports zNodes whose ephemeralOwner is non-zero")
    @Test
    public void testContent_EphemeralNodes_AreIgnored() throws Exception {
        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);

        RunResult result = runSnapshotComparer(args("-l", LEFT_EPHEMERAL, "-r", RIGHT_EPHEMERAL, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);

        assertOutputDoesNotContain(result, LEFT_EPHEMERAL_PATH);
        assertOutputDoesNotContain(result, RIGHT_EPHEMERAL_PATH);
    }

    // T18, testFileRight_MissingSnapshot_FailsLoading
    @Test
    public void testFileRight_MissingSnapshot_FailsLoading() throws Exception {
        assertAssetExists(LEFT);
        assertFalse("Ghost file must not exist for this test", new File(GHOST_RIGHT).exists());

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0"));

        assertFailed(result);
        assertOutputContainsAny(result, "no such file", "file not found", "filenotfoundexception", "cannot find");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    // T22, testFormats_GzSnapshot_IsSupported
    @Test
    public void testFormats_GzSnapshot_IsSupported() throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1);
        assertAssetExists(RIGHT_GZ);

        RunResult plainResult = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));
        RunResult gzipResult = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_GZ, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(plainResult);
        assertCompletedSuccessfully(gzipResult);
        assertOutputContains(gzipResult, "Node /nodo_extra found only in right tree");
        assertOutputContains(gzipResult, "Node /payload found only in right tree");
    }

    // T28, testRelation_SamePhysicalFile_ProducesNoDelta
    @Test
    public void testRelation_SamePhysicalFile_ProducesNoDelta() throws Exception {
        assertAssetExists(LEFT);
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", LEFT, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContainAny(result, "found only in right tree", "found only in left tree", "Delta:");
    }

    // T29, testRelation_DifferentFilesSameTree_ProducesNoDelta
    @Test
    public void testRelation_DifferentFilesSameTree_ProducesNoDelta() throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_IDENTICAL);
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContainAny(result, "found only in right tree", "found only in left tree", "Delta:");
    }

    // T30, testRelation_CommonPathByteDelta_IsReported
    @Test
    public void testRelation_CommonPathByteDelta_IsReported() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison("0", "0");

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/payload", D_BYTES + " bytes");
    }

    // T31, testRelation_PathOnlyInRight_IsReported
    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "Node /payload found only in right tree");
    }

    // T32, testRelation_PathOnlyInLeft_IsReported
    @Test
    public void testRelation_PathOnlyInLeft_IsReported() throws Exception {
        assertCoreAssets();
        RunResult result = runSnapshotComparer(args("-l", RIGHT_PLUS_1, "-r", LEFT, "-b", "0", "-n", "0"));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /nodo_extra found only in left tree");
        assertOutputContains(result, "Node /payload found only in left tree");
    }

    // T33, testRelation_MixedDifferences_AreReported
    @Test
    public void testRelation_MixedDifferences_AreReported() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison("0", "0");

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Node /new found only in right tree");
        assertOutputContains(result, "Node /old found only in left tree");
        assertQuantitativeDeltaForPath(result, "/payload", D_BYTES + " bytes");
        assertQuantitativeDeltaForPath(result, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    // T35, testByteThreshold_BelowDelta_ReportsPayloadDelta
    @Test
    public void testByteThreshold_BelowDelta_ReportsPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(String.valueOf(D_BYTES - 1), VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/payload", D_BYTES + " bytes");
    }

    // T36, testByteThreshold_EqualToDelta_FiltersPayloadDelta
    @Test
    public void testByteThreshold_EqualToDelta_FiltersPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(String.valueOf(D_BYTES), VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertNoQuantitativeDeltaForPath(result, "/payload");
    }

    // T37, testByteThreshold_AboveDelta_FiltersPayloadDelta
    @Test
    public void testByteThreshold_AboveDelta_FiltersPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(String.valueOf(D_BYTES + 1), VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertNoQuantitativeDeltaForPath(result, "/payload");
    }

    // T39, testNodeThreshold_BelowDelta_ReportsParentDelta
    @Test
    public void testNodeThreshold_BelowDelta_ReportsParentDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(VERY_HIGH_THRESHOLD, String.valueOf(D_NODES - 1));

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(result, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    // T40, testNodeThreshold_EqualToDelta_FiltersParentDelta
    @Test
    public void testNodeThreshold_EqualToDelta_FiltersParentDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(VERY_HIGH_THRESHOLD, String.valueOf(D_NODES));

        assertCompletedSuccessfully(result);
        assertNoQuantitativeDeltaForPath(result, "/parent");
    }

    // T41, testNodeThreshold_AboveDelta_FiltersParentDelta
    @Test
    public void testNodeThreshold_AboveDelta_FiltersParentDelta() throws Exception {
        assertMixedAssets();
        RunResult result = runMixedComparison(VERY_HIGH_THRESHOLD, String.valueOf(D_NODES + 1));

        assertCompletedSuccessfully(result);
        assertNoQuantitativeDeltaForPath(result, "/parent");
    }

    // T50, testInteractive_DepthBelowMinimum_PrintsRangeError
    @Test
    public void testInteractive_DepthBelowMinimum_PrintsRangeError() throws Exception {
        assertCoreAssets();
        String stdin = interactiveInput("-1", INTERACTIVE_COMPLETION_NEWLINES);
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i"), stdin);

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Depth must be in range [0, 2]");
    }

    // T54, testInteractive_InvalidAbsolutePath_PrintsError
    @Test
    public void testInteractive_InvalidAbsolutePath_PrintsError() throws Exception {
        assertCoreAssets();
        String stdin = interactiveInput("/nodo_inesistente", INTERACTIVE_COMPLETION_NEWLINES);
        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i"), stdin);

        assertCompletedSuccessfully(result);
        assertOutputContainsAny(result,
                "Path /nodo_inesistente is neither found in left tree nor right tree",
                "not found in either tree",
                "absent from both trees");
    }


    // HELPER METHODS & INNER CLASSES

    // Verifies that a required test file exists and is readable.
    private static void assertAssetExists(String file) {
        File asset = new File(file);
        assertTrue("Required test asset is missing: " + file, asset.isFile());
        assertTrue("Required test asset is not readable: " + file, asset.canRead());
    }

    // Asserts the presence of the fundamental baseline snapshots.
    private static void assertCoreAssets() {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1);
    }

    // Asserts the presence of snapshots used for mixed difference testing.
    private static void assertMixedAssets() {
        assertAssetExists(LEFT_MIXED);
        assertAssetExists(RIGHT_MIXED);
    }

    // Convenience method to create a String array of CLI arguments.
    private static String[] args(String... arguments) {
        return arguments;
    }

    // Executes the SnapshotComparer CLI with the given arguments and no standard input.
    private RunResult runSnapshotComparer(String[] arguments) throws Exception {
        return runSnapshotComparer(arguments, null);
    }

    // Executes SnapshotComparer in a separate JVM process. It is used ProcessBuilder instead of SnapshotComparer.main()
    // for 3 reasons:
    // 1. The SUT uses System.exit() for invalid configurations. Calling it directly would kill our JUnit test runner;
    // 2. It isolates System.in and System.out, avoiding stream pollution when running multiple tests in parallel;
    // 3. The child process exit code gives a clean, sandbox-safe Pass/Fail metric.

    private RunResult runSnapshotComparer(String[] arguments, String stdin) throws Exception {
        String javaExecutable = Paths.get(System.getProperty("java.home"), "bin", "java").toString();
        List<String> command = new ArrayList<>();
        command.add(javaExecutable);
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(SnapshotComparer.class.getName());
        Collections.addAll(command, arguments);

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        // Merge stderr into stdout. This prevents deadlocks if the child process writes too many error logs
        // and fills up the stderr OS buffer
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        if (stdin != null) {
            try (OutputStream processInput = process.getOutputStream()) {
                processInput.write(stdin.getBytes(StandardCharsets.UTF_8));
            }
        } else {
            process.getOutputStream().close();
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();

         // Asynchronous Stream Reading. It is not possible wait for the process to finish before reading its output.
         // If the SUT prints a lot of data, the OS output buffer fills up, and the child process pauses.
         // If wait for it to finish, it becomes a deadlock. It is used a separate Thread to constantly drain the buffer
        Thread outputReader = new Thread(() -> {
            try (InputStream processOutput = process.getInputStream()) {
                copy(processOutput, output);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }, "snapshot-comparer-output-reader");
        outputReader.start();

        // Safety timeout to prevent infinite loops (e.g. interactive mode stuck)
        boolean completed = process.waitFor(PROCESS_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (!completed) {
            process.destroyForcibly();
            outputReader.join();
            fail("SnapshotComparer did not terminate within " + PROCESS_TIMEOUT_SECONDS + " seconds. Output:\n" + output.toString(StandardCharsets.UTF_8.name()));
        }

        outputReader.join();
        return new RunResult(output.toString(StandardCharsets.UTF_8.name()), process.exitValue());
    }

    // Executes a comparison using the mixed snapshot assets with specific threshold values.
    private RunResult runMixedComparison(String byteThreshold, String nodeThreshold) throws Exception {
        return runSnapshotComparer(args("-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", byteThreshold, "-n", nodeThreshold));
    }

    // Utility method to copy data from an InputStream to an OutputStream.
    private static void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[8192];
        int count;
        while ((count = input.read(buffer)) != -1) {
            output.write(buffer, 0, count);
        }
    }

    // Asserts that the execution finished with a zero exit code and reached the end of the comparison.
    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals("SnapshotComparer must terminate successfully. Output:\n" + result.output, 0, result.exitStatus);
        assertOutputContains(result, "All layers compared");
    }

    // Asserts that the console output contains a specific case-insensitive string.
    private static void assertOutputContains(RunResult result, String needle) {
        assertTrue("Expected output to contain: " + needle + "\nActual output:\n" + result.output,
                result.output.toLowerCase().contains(needle.toLowerCase()));
    }

    // Asserts that the console output contains at least one of the provided case-insensitive strings.
    private static void assertOutputContainsAny(RunResult result, String... needles) {
        String normalized = result.output.toLowerCase();
        for (String needle : needles) {
            if (normalized.contains(needle.toLowerCase())) {
                return;
            }
        }
        fail("Expected output to contain one of " + Arrays.toString(needles) + "\nActual output:\n" + result.output);
    }

    // Asserts that the console output does NOT contain a specific case-insensitive string.
    private static void assertOutputDoesNotContain(RunResult result, String needle) {
        assertFalse("Output must not contain: " + needle + "\nActual output:\n" + result.output,
                result.output.toLowerCase().contains(needle.toLowerCase()));
    }

    // Asserts that the console output does NOT contain any of the provided case-insensitive strings.
    private static void assertOutputDoesNotContainAny(RunResult result, String... needles) {
        for (String needle : needles) {
            assertOutputDoesNotContain(result, needle);
        }
    }

    // Asserts that the execution failed, producing a non-zero exit code.
    private static void assertFailed(RunResult result) {
        assertNotEquals("Invalid input must not terminate successfully. Output:\n" + result.output, 0, result.exitStatus);
    }

    // Asserts that no quantitative delta information is printed for the specified node path.
    private static void assertNoQuantitativeDeltaForPath(RunResult result, String path) {
        for (String line : result.output.split("\\R")) {
            boolean pathLine = line.contains("Node " + path + " found in both trees");
            boolean deltaLine = line.contains("Delta:");
            assertFalse("No quantitative delta must be reported for " + path + ". Unexpected line: " + line,
                    pathLine && deltaLine);
        }
    }

    // Asserts that a specific quantitative delta is printed for the specified node path.
    private static void assertQuantitativeDeltaForPath(RunResult result, String path, String expectedDelta) {
        assertOutputContains(result, "Node " + path + " found in both trees. Delta: " + expectedDelta);
    }

    // Constructs an input string for interactive mode. The interactive mode uses a while(currentDepth < maxDepth) loop,
    // calling Scanner.nextLine() on each iteration. If it is only sent a single command (e.g., "/node\n"), the next
    // iteration will throw NoSuchElementException because the simulated input stream is exhausted.
    // By appending multiple newlines, we allow the loop to safely advance and exit gracefully.
    private static String interactiveInput(String command, int trailingNewlines) {
        StringBuilder input = new StringBuilder(command).append('\n');
        for (int index = 0; index < trailingNewlines; index++) {
            input.append('\n');
        }
        return input.toString();
    }

    // Filters the raw output to retain only semantically meaningful lines. ZooKeeper prints many infrastructural
    // logs on startup (e.g., JVM memory stats, timestamps, environment variables).
    // To reliably compare outputs across different executions (e.g. testing flag duplication),
    // we strip away this "noise" and keep only the business logic lines printed directly by the SUT's algorithm.
    private static String semanticOutput(String output) {
        StringBuilder semantic = new StringBuilder();

        for (String line : output.replace("\r\n", "\n").split("\n")) {
            String trimmed = line.trim();

            if (trimmed.startsWith("Node count:")
                    || trimmed.startsWith("Total size:")
                    || trimmed.startsWith("Max depth:")
                    || trimmed.startsWith("Count of nodes at depth")
                    || trimmed.startsWith("Node ")
                    || trimmed.startsWith("Filtered node ")
                    || trimmed.startsWith("Analysis for depth")
                    || trimmed.startsWith("All layers compared")
                    || trimmed.startsWith("Usage:")
                    || trimmed.toLowerCase().contains("unrecognized option")
                    || trimmed.toLowerCase().contains("missing argument")) {

                semantic.append(trimmed).append('\n');
            }
        }

        return semantic.toString().trim();
    }

    // Container class to hold the captured console output and the exit status of the executed process.
    private static final class RunResult {
        final String output;
        final int exitStatus;

        RunResult(String output, int exitStatus) {
            this.output = output;
            this.exitStatus = exitStatus;
        }
    }
}
package org.apache.zookeeper.server.snapshotcomparer.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box tests for {@link SnapshotComparer}. The production main method is
 * executed in a child JVM so invalid invocations and loading failures cannot
 * terminate the JUnit runner through ServiceUtils.requestSystemExit.
 */
public class SnapshotComparerLLMFewShotTest {

    private static final String FIXTURES = "src/test/resources/data/comparer/";
    private static final String CORRUPT = FIXTURES + "corrupt_file.snap";
    private static final String LEFT = FIXTURES + "left.snap";
    private static final String LEFT_MIXED = FIXTURES + "left_mixed.snap";
    private static final String RIGHT_IDENTICAL = FIXTURES + "right_identical.snap";
    private static final String RIGHT_MIXED = FIXTURES + "right_mixed.snap";
    private static final String RIGHT_PLUS_1_GZ = FIXTURES + "right_plus_1.gz";
    private static final String RIGHT_PLUS_1 = FIXTURES + "right_plus_1.snap";
    private static final String LEFT_EPHEMERAL = FIXTURES + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = FIXTURES + "right_ephemeral.snap";
    private static final String GHOST_RIGHT = FIXTURES + "ghost_right.snap";

    private static final long PROCESS_TIMEOUT_SECONDS = 30;
    private static final String MAX_THRESHOLD = String.valueOf(Integer.MAX_VALUE);

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDelta() throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!");
        assertContains(result, "Printing analysis for nodes difference larger than 0 bytes");
        assertContains(result, "Analysis for depth 0");
        assertContains(result, "All layers compared.");
        assertNotContains(result, "found only in");
        assertNotContains(result, "found in both trees. Delta:");
    }

    @Test
    public void testRightOnlyNodes_AreReportedForUncompressedSnapshot() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in right tree.");
        assertContains(result, "Node /payload found only in right tree.");
        assertContains(result, "Descendant size:");
        assertContains(result, "Descendant count:");
    }

    @Test
    public void testGzipSnapshot_ProducesSameObservableNodeRelations() throws Exception {
        assertAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_PLUS_1_GZ, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Deserialized snapshot in right_plus_1.gz");
        assertContains(result, "Node /nodo_extra found only in right tree.");
        assertContains(result, "Node /payload found only in right tree.");
    }

    @Test
    public void testReversedInputs_ReportNodesOnlyInLeftTree() throws Exception {
        RunResult result = run("", "-l", RIGHT_PLUS_1, "-r", LEFT, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in left tree.");
        assertContains(result, "Node /payload found only in left tree.");
        assertNotContains(result, "Node /nodo_extra found only in right tree.");
    }

    @Test
    public void testMixedSnapshots_ZeroThresholdReportsQuantitativeDelta() throws Exception {
        assertAssetExists(LEFT_MIXED);
        assertAssetExists(RIGHT_MIXED);

        RunResult result = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /payload found in both trees. Delta:");
        assertContains(result, " bytes, ");
        assertContains(result, " descendants");
    }

    @Test
    public void testMaximumThreshold_FiltersAllFiniteSnapshotDifferences() throws Exception {
        RunResult result = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", MAX_THRESHOLD, "-n", MAX_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertNotContains(result, "found only in");
        assertNotContains(result, "found in both trees. Delta:");
        assertNotContains(result, "Filtered node");
    }

    @Test
    public void testDebugMode_ExposesComparisonsRelationsAndFilteredNodes() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", MAX_THRESHOLD, "-n", MAX_THRESHOLD, "-d");

        assertCompletedSuccessfully(result);
        assertContains(result, "Comparing ");
        assertContains(result, "same");
        assertContains(result, "Filtered node ");
        assertContains(result, "left size ");
        assertContains(result, "right size ");
    }

    @Test
    public void testEphemeralFixtures_CanBeLoadedAndCompared() throws Exception {
        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);

        RunResult result = run("", "--left", LEFT_EPHEMERAL, "--right", RIGHT_EPHEMERAL,
                "--bytes", "0", "--nodes", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Deserialized snapshot in left_ephemeral.snap");
        assertContains(result, "Deserialized snapshot in right_ephemeral.snap");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testLongOptionNames_AreAccepted() throws Exception {
        RunResult result = run("", "--left", LEFT, "--right", RIGHT_IDENTICAL,
                "--bytes", "0", "--nodes", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRequiredOption_IsRejectedWithUsage() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0");

        assertFailed(result);
        assertContainsIgnoreCase(result, "missing required option");
        assertContains(result, "java -cp <classPath> org.apache.zookeeper.server.SnapshotComparer");
        assertNotContains(result, "Successfully parsed options!");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testUnknownOption_IsRejectedWithUsage() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "0", "--not-a-real-option");

        assertFailed(result);
        assertContainsIgnoreCase(result, "unrecognized option");
        assertContains(result, "usage:");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testNonNumericByteThreshold_FailsAfterParsing() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number", "-n", "0");

        assertFailed(result);
        assertContainsIgnoreCase(result, "numberformatexception");
        assertNotContains(result, "Successfully parsed options!");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRightSnapshot_FailsLoading() throws Exception {
        assertAssetExists(LEFT);
        assertFalse("Ghost fixture must intentionally be absent", new File(GHOST_RIGHT).exists());

        RunResult result = run("", "-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContainsAnyIgnoreCase(result, "no such file", "file not found",
                "filenotfoundexception", "cannot find");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testCorruptSnapshot_FailsDeserialization() throws Exception {
        assertAssetExists(CORRUPT);

        RunResult result = run("", "-l", LEFT, "-r", CORRUPT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContains(result, "Successfully parsed options!");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_EmptyLinesAdvanceThroughEveryDepth() throws Exception {
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            input.append('\n');
        }

        RunResult result = run(input.toString(), "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", MAX_THRESHOLD, "-n", MAX_THRESHOLD, "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Current depth is 0");
        assertContains(result, "Press enter to move to print current depth layer");
        assertContains(result, "Analysis for depth 0");
        assertContains(result, "Filtered node ");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_InvalidDepthAndPathInputsAreHandled() throws Exception {
        StringBuilder input = new StringBuilder("-1\nnot-a-depth\n/path-that-does-not-exist\n");
        for (int i = 0; i < 128; i++) {
            input.append('\n');
        }

        RunResult result = run(input.toString(), "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Depth must be in range [0,");
        assertContains(result, "Input not-a-depth is not valid.");
        assertContains(result, "Analysis for node /path-that-does-not-exist");
        assertContains(result, "Path /path-that-does-not-exist is neither found in left tree nor right tree.");
        assertContains(result, "All layers compared.");
    }

    private static RunResult run(String standardInput, String... arguments) throws Exception {
        List<String> command = new ArrayList<>();
        command.add(javaExecutable());
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(SnapshotComparer.class.getName());
        command.addAll(Arrays.asList(arguments));

        Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
        try (OutputStream stdin = process.getOutputStream()) {
            stdin.write(standardInput.getBytes(StandardCharsets.UTF_8));
        }

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        Thread reader = new Thread(() -> copy(process.getInputStream(), captured),
                "snapshot-comparer-output-reader");
        reader.setDaemon(true);
        reader.start();

        boolean finished = process.waitFor(PROCESS_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (!finished) {
            process.destroyForcibly();
            reader.join(TimeUnit.SECONDS.toMillis(2));
            throw new AssertionError("SnapshotComparer process timed out. Output:\n" + captured);
        }
        reader.join(TimeUnit.SECONDS.toMillis(2));
        return new RunResult(process.exitValue(), new String(captured.toByteArray(), StandardCharsets.UTF_8));
    }

    private static void copy(InputStream source, ByteArrayOutputStream target) {
        byte[] buffer = new byte[4096];
        int read;
        try (InputStream input = source) {
            while ((read = input.read(buffer)) != -1) {
                target.write(buffer, 0, read);
            }
        } catch (IOException e) {
            throw new AssertionError("Could not capture child-process output", e);
        }
    }

    private static String javaExecutable() {
        return new File(new File(System.getProperty("java.home"), "bin"),
                isWindows() ? "java.exe" : "java").getPath();
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
    }

    private static void assertAssetExists(String path) {
        assertTrue("Required fixture does not exist: " + path, new File(path).isFile());
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals("Expected success but got output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals("Expected failure but got output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertContains(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> but was:\n" + result.output,
                result.output.contains(expected));
    }

    private static void assertContainsIgnoreCase(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> ignoring case but was:\n" + result.output,
                result.output.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    private static void assertContainsAnyIgnoreCase(RunResult result, String... alternatives) {
        String lowerOutput = result.output.toLowerCase(Locale.ROOT);
        for (String alternative : alternatives) {
            if (lowerOutput.contains(alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }
        throw new AssertionError("Expected one of " + Arrays.toString(alternatives)
                + " in output:\n" + result.output);
    }

    private static void assertNotContains(RunResult result, String unexpected) {
        assertFalse("Did not expect output to contain <" + unexpected + "> but was:\n" + result.output,
                result.output.contains(unexpected));
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
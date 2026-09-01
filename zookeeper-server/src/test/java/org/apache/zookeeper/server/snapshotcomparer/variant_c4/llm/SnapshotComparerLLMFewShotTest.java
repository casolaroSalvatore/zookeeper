package org.apache.zookeeper.server.snapshotcomparer.variant_c4.llm;

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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.zookeeper.util.ServiceUtils;
import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box JUnit 4 tests for {@link SnapshotComparer}.
 *
 * <p>The command-line entry point is invoked directly in the current JUnit
 * JVM. The ZooKeeper system-exit procedure is temporarily replaced so invalid
 * invocations cannot terminate Surefire or PIT.
 *
 * <p>In-process execution allows JaCoCo and PIT to observe the production code
 * exercised through the public main entry point.
 */

public class SnapshotComparerLLMFewShotTest {

    private static final String FIXTURE_DIR = "src/test/resources/data/comparer/";
    private static final String LEFT = FIXTURE_DIR + "left.snap";
    private static final String RIGHT_IDENTICAL = FIXTURE_DIR + "right_identical.snap";
    private static final String RIGHT_PLUS_1 = FIXTURE_DIR + "right_plus_1.snap";
    private static final String RIGHT_PLUS_1_GZ = FIXTURE_DIR + "right_plus_1.gz";
    private static final String LEFT_MIXED = FIXTURE_DIR + "left_mixed.snap";
    private static final String RIGHT_MIXED = FIXTURE_DIR + "right_mixed.snap";
    private static final String LEFT_EPHEMERAL = FIXTURE_DIR + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = FIXTURE_DIR + "right_ephemeral.snap";
    private static final String CORRUPT = FIXTURE_DIR + "corrupt_file.snap";
    private static final String GHOST_RIGHT = FIXTURE_DIR + "ghost_right.snap";

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDelta() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

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
    public void testRightOnlyNodes_AreReportedAtZeroThresholds() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in right tree.");
        assertContains(result, "Node /payload found only in right tree.");
        assertContains(result, "Descendant size:");
        assertContains(result, "Descendant count:");
    }

    @Test
    public void testGzipSnapshot_IsAcceptedAndComparedLikeUncompressedSnapshot() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1, RIGHT_PLUS_1_GZ);

        RunResult plain = run("", "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
        RunResult gzip = run("", "-l", LEFT, "-r", RIGHT_PLUS_1_GZ, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(plain);
        assertCompletedSuccessfully(gzip);
        assertContains(gzip, "Deserialized snapshot in right_plus_1.gz");
        assertContains(gzip, "Node /nodo_extra found only in right tree.");
        assertContains(gzip, "Node /payload found only in right tree.");
        assertEquals(deltaLines(plain.output), deltaLines(gzip.output));
    }

    @Test
    public void testMixedSnapshots_ZeroThresholds_ReportQuantitativeDelta() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);

        RunResult result = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /payload found in both trees. Delta:");
        assertContains(result, " bytes, ");
        assertContains(result, " descendants");
    }

    @Test
    public void testVeryHighThresholds_SuppressAllDeltaLines() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);

        RunResult result = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(Integer.MAX_VALUE),
                "-n", String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(result);
        assertContains(result, "All layers compared.");
        assertNotContains(result, "found only in");
        assertNotContains(result, "found in both trees. Delta:");
        assertNotContains(result, "Filtered node");
    }

    @Test
    public void testThresholdBoundary_IsStrictAndDebugExposesFiltering() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);
        RunResult baseline = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", "0", "-n", "0");
        long payloadDelta = absoluteByteDeltaForPath(baseline.output, "/payload");
        assertTrue("Fixture must contain a non-zero /payload byte delta", payloadDelta > 0);

        RunResult below = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(payloadDelta - 1), "-n", String.valueOf(Integer.MAX_VALUE));
        RunResult atBoundaryDebug = run("", "-d", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(payloadDelta), "-n", String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(below);
        assertContains(below, "Node /payload found in both trees. Delta:");
        assertCompletedSuccessfully(atBoundaryDebug);
        assertNotContains(atBoundaryDebug, "Node /payload found in both trees. Delta:");
        assertContains(atBoundaryDebug, "Filtered node /payload of left size");
        assertContains(atBoundaryDebug, "Comparing ");
    }

    @Test
    public void testEphemeralFixtures_AreReadableAndComparisonCompletes() throws Exception {
        assertFixturesExist(LEFT_EPHEMERAL, RIGHT_EPHEMERAL);

        RunResult result = run("", "-l", LEFT_EPHEMERAL, "-r", RIGHT_EPHEMERAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Deserialized snapshot in left_ephemeral.snap");
        assertContains(result, "Deserialized snapshot in right_ephemeral.snap");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_EmptyInputAdvancesThroughEveryDepth() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run(repeatNewlines(64), "-i", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Current depth is 0");
        assertContains(result, "Press enter to move to print current depth layer");
        assertContains(result, "Analysis for depth 0");
        assertContains(result, "Filtered node ");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_UnknownAbsolutePathIsExplained() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("/definitely-not-present\n" + repeatNewlines(64),
                "-i", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Analysis for node /definitely-not-present");
        assertContains(result, "Path /definitely-not-present is neither found in left tree nor right tree.");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_InvalidTextInputIsExplainedAndDoesNotAbort() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("not-a-depth\n" + repeatNewlines(64),
                "-i", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Input not-a-depth is not valid.");
        assertContains(result, "Path must be an absolute path which starts with '/'.");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRequiredOption_PrintsUsageAndFails() throws Exception {
        assertFixturesExist(LEFT);

        RunResult result = run("", "-l", LEFT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContainsIgnoringCase(result, "missing required option");
        assertContains(result, "java -cp <classPath> org.apache.zookeeper.server.SnapshotComparer");
        assertContains(result, "-r,--right <RIGHT>");
        assertNotContains(result, "Successfully parsed options!");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testUnknownOption_PrintsUsageAndFails() throws Exception {
        RunResult result = run("", "--not-a-real-option");

        assertFailed(result);
        assertContainsIgnoringCase(result, "unrecognized option");
        assertContains(result, "--left <LEFT>");
        assertNotContains(result, "Successfully parsed options!");
    }

    @Test
    public void testNonNumericByteThreshold_FailsBeforeSnapshotsAreLoaded() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "NaN", "-n", "0");

        assertFailed(result);
        assertContainsIgnoringCase(result, "numberformatexception");
        assertNotContains(result, "Successfully parsed options!");
        assertNotContains(result, "Deserialized snapshot");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testNonNumericNodeThreshold_FailsBeforeSnapshotsAreLoaded() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "NaN");

        assertFailed(result);
        assertContainsIgnoringCase(result, "numberformatexception");
        assertNotContains(result, "Successfully parsed options!");
        assertNotContains(result, "Deserialized snapshot");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRightSnapshot_FailsDuringLoading() throws Exception {
        assertFixturesExist(LEFT);
        assertFalse("Ghost fixture must intentionally be absent", Files.exists(Paths.get(GHOST_RIGHT)));

        RunResult result = run("", "-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContainsAnyIgnoringCase(result, "no such file", "file not found", "filenotfoundexception", "cannot find");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testCorruptSnapshot_FailsAndNeverClaimsCompletion() throws Exception {
        assertFixturesExist(LEFT, CORRUPT);

        RunResult result = run("", "-l", LEFT, "-r", CORRUPT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContains(result, "Successfully parsed options!");
        assertNotContains(result, "All layers compared.");
    }

    @Test
    public void testLongOptionNames_AreSupported() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "--left", LEFT, "--right", RIGHT_IDENTICAL,
                "--bytes", "0", "--nodes", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testNegativeThresholds_CauseEvenIdenticalNodesToBeReported() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "-1", "-n", "-1");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node  found in both trees. Delta: 0 bytes, 0 descendants");
        assertContains(result, "All layers compared.");
    }

    private static RunResult run(
            String standardInput,
            String... arguments) throws Exception {

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

    private static String repeatNewlines(int count) {
        char[] newlines = new char[count];
        Arrays.fill(newlines, '\n');
        return new String(newlines);
    }

    private static List<String> deltaLines(String output) {
        List<String> lines = new ArrayList<String>();
        for (String line : output.split("\\R")) {
            if (line.contains("found only in") || line.contains("found in both trees. Delta:")) {
                lines.add(line.trim());
            }
        }
        return lines;
    }

    private static long absoluteByteDeltaForPath(String output, String path) {
        String prefix = "Node " + path + " found in both trees. Delta: ";
        for (String line : output.split("\\R")) {
            if (line.startsWith(prefix)) {
                int bytesAt = line.indexOf(" bytes", prefix.length());
                return Math.abs(Long.parseLong(line.substring(prefix.length(), bytesAt).trim()));
            }
        }
        fail("No quantitative delta line found for " + path + ". Output:\n" + output);
        return -1;
    }

    private static void assertFixturesExist(String... fixturePaths) {
        for (String fixturePath : fixturePaths) {
            assertTrue("Required fixture is missing: " + fixturePath, new File(fixturePath).isFile());
        }
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals("Expected successful exit. Output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals("Expected non-zero exit. Output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertContains(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> but was:\n" + result.output,
                result.output.contains(expected));
    }

    private static void assertContainsIgnoringCase(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> (case-insensitive) but was:\n" + result.output,
                result.output.toLowerCase(Locale.ROOT).contains(expected.toLowerCase(Locale.ROOT)));
    }

    private static void assertContainsAnyIgnoringCase(RunResult result, String... alternatives) {
        String lower = result.output.toLowerCase(Locale.ROOT);
        for (String alternative : alternatives) {
            if (lower.contains(alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }
        fail("Expected one of " + Arrays.toString(alternatives) + " but output was:\n" + result.output);
    }

    private static void assertNotContains(RunResult result, String unexpected) {
        assertFalse("Did not expect output to contain <" + unexpected + "> but was:\n" + result.output,
                result.output.contains(unexpected));
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

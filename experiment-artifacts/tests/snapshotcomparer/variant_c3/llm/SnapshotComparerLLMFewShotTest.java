package org.apache.zookeeper.server.snapshotcomparer.variant_c3.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

import org.apache.zookeeper.util.ServiceUtils;
import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Test;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>The production entry point is invoked directly in the current JUnit JVM.
 * The ZooKeeper system-exit procedure is temporarily replaced so invalid
 * invocations cannot terminate Surefire or PIT.
 *
 * <p>In-process execution allows JaCoCo and PIT to observe execution of the
 * production class without accessing private implementation details.
 */

public class SnapshotComparerLLMFewShotTest {

    private static final String FIXTURE_DIR = "src/test/resources/data/comparer/";
    private static final String LEFT = FIXTURE_DIR + "left.snap";
    private static final String LEFT_MIXED = FIXTURE_DIR + "left_mixed.snap";
    private static final String RIGHT_IDENTICAL = FIXTURE_DIR + "right_identical.snap";
    private static final String RIGHT_MIXED = FIXTURE_DIR + "right_mixed.snap";
    private static final String RIGHT_PLUS_1 = FIXTURE_DIR + "right_plus_1.snap";
    private static final String RIGHT_PLUS_1_GZ = FIXTURE_DIR + "right_plus_1.gz";
    private static final String LEFT_EPHEMERAL = FIXTURE_DIR + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = FIXTURE_DIR + "right_ephemeral.snap";
    private static final String CORRUPT = FIXTURE_DIR + "corrupt_file.snap";
    private static final String GHOST_RIGHT = FIXTURE_DIR + "ghost_right.snap";

    private static final String COMPLETION = "All layers compared.";

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDifferences() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(null,
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!");
        assertContains(result, "Printing analysis for nodes difference larger than 0 bytes");
        assertContains(result, "Analysis for depth 0");
        assertDoesNotContain(result, "found only in left tree");
        assertDoesNotContain(result, "found only in right tree");
        assertDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testLongOptionNames_AreAccepted() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(null,
                "--left", LEFT, "--right", RIGHT_IDENTICAL,
                "--bytes", "0", "--nodes", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!");
    }

    @Test
    public void testRightOnlyNodes_AreReportedAtZeroThresholds() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1);

        RunResult result = compare(LEFT, RIGHT_PLUS_1, "0", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in right tree.");
        assertContains(result, "Node /payload found only in right tree.");
        assertContains(result, "Descendant size:");
        assertContains(result, "Descendant count:");
    }

    @Test
    public void testGzipSnapshot_IsAutomaticallyReadAndCompared() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1_GZ);

        RunResult result = compare(LEFT, RIGHT_PLUS_1_GZ, "0", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Deserialized snapshot in right_plus_1.gz");
        assertContains(result, "Node /nodo_extra found only in right tree.");
        assertContains(result, "Node /payload found only in right tree.");
    }

    @Test
    public void testReversedInputs_ReportExclusiveNodesOnLeft() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1);

        RunResult result = compare(RIGHT_PLUS_1, LEFT, "0", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in left tree.");
        assertContains(result, "Node /payload found only in left tree.");
        assertDoesNotContain(result, "Node /nodo_extra found only in right tree.");
    }

    @Test
    public void testMixedSnapshots_ReportQuantitativeDeltaAtZeroThresholds() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);

        RunResult result = compare(LEFT_MIXED, RIGHT_MIXED, "0", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /payload found in both trees. Delta:");
        assertContains(result, " bytes, ");
        assertContains(result, " descendants");
    }

    @Test
    public void testVeryHighThresholds_FilterAllDifferencesInNormalMode() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);

        RunResult result = compare(LEFT_MIXED, RIGHT_MIXED,
                String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(result);
        assertDoesNotContain(result, "found only in left tree");
        assertDoesNotContain(result, "found only in right tree");
        assertDoesNotContain(result, "found in both trees. Delta:");
        assertDoesNotContain(result, "Filtered node");
    }

    @Test
    public void testThresholdComparison_IsStrictlyGreaterThan() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1);
        RunResult baseline = compare(LEFT, RIGHT_PLUS_1, "0", "0");
        long payloadSize = exclusiveDescendantSize(baseline, "/payload", "right");

        RunResult equalThreshold = compare(
                LEFT, RIGHT_PLUS_1, String.valueOf(payloadSize), String.valueOf(Integer.MAX_VALUE));

        assertCompletedSuccessfully(equalThreshold);
        assertDoesNotContain(equalThreshold, "Node /payload found only in right tree.");
    }

    @Test
    public void testDebugMode_ExposesComparisonsAndFilteredNodes() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(null,
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-d");

        assertCompletedSuccessfully(result);
        assertContains(result, "Comparing ");
        assertContains(result, "same");
        assertContains(result, "Filtered node ");
        assertContains(result, "left size");
        assertContains(result, "right size");
    }

    @Test
    public void testEphemeralFixtures_CanBeLoadedAndCompared() throws Exception {
        assertFixturesExist(LEFT_EPHEMERAL, RIGHT_EPHEMERAL);

        RunResult result = compare(LEFT_EPHEMERAL, RIGHT_EPHEMERAL, "0", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Deserialized snapshot in left_ephemeral.snap");
        assertContains(result, "Deserialized snapshot in right_ephemeral.snap");
        assertContains(result, "Node count:");
        assertContains(result, "Total size:");
        assertContains(result, "Max depth:");
    }

    @Test
    public void testMissingRequiredOption_ExitsAsInvalidInvocationAndPrintsUsage() throws Exception {
        assertFixturesExist(LEFT);

        RunResult result = runSnapshotComparer(null,
                "-l", LEFT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContainsIgnoringCase(result, "missing required option");
        assertContains(result, "java -cp <classPath> " + SnapshotComparer.class.getName());
        assertDoesNotContain(result, "Successfully parsed options!");
        assertDoesNotContain(result, COMPLETION);
    }

    @Test
    public void testUnknownOption_ExitsAsInvalidInvocationAndPrintsUsage() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(null,
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "--unknown");

        assertFailed(result);
        assertContainsIgnoringCase(result, "unrecognized option");
        assertContains(result, "usage:");
        assertDoesNotContain(result, COMPLETION);
    }

    @Test
    public void testNonNumericByteThreshold_FailsBeforeLoadingSnapshots() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = compare(LEFT, RIGHT_IDENTICAL, "not-a-number", "0");

        assertFailed(result);
        assertContainsIgnoringCase(result, "numberformatexception");
        assertDoesNotContain(result, "Successfully parsed options!");
        assertDoesNotContain(result, "Deserialized snapshot");
        assertDoesNotContain(result, COMPLETION);
    }

    @Test
    public void testNonNumericNodeThreshold_FailsBeforeLoadingSnapshots() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = compare(LEFT, RIGHT_IDENTICAL, "0", "not-a-number");

        assertFailed(result);
        assertContainsIgnoringCase(result, "numberformatexception");
        assertDoesNotContain(result, "Successfully parsed options!");
        assertDoesNotContain(result, COMPLETION);
    }

    @Test
    public void testMissingRightSnapshot_FailsLoading() throws Exception {
        assertFixturesExist(LEFT);
        assertFalse("The supplied ghost fixture must represent a missing file",
                new File(GHOST_RIGHT).exists());

        RunResult result = compare(LEFT, GHOST_RIGHT, "0", "0");

        assertFailed(result);
        assertContainsAnyIgnoringCase(result,
                "no such file", "file not found", "filenotfoundexception", "cannot find");
        assertDoesNotContain(result, COMPLETION);
    }

    @Test
    public void testCorruptSnapshot_FailsDeserialization() throws Exception {
        assertFixturesExist(LEFT, CORRUPT);

        RunResult result = compare(LEFT, CORRUPT, "0", "0");

        assertFailed(result);
        assertDoesNotContain(result, COMPLETION);
        assertFalse("A corrupt snapshot failure must emit a diagnostic. Output was:\n" + result.output,
                result.output.trim().isEmpty());
    }

    @Test
    public void testInteractiveEmptyLines_AdvanceThroughEveryDepth() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            input.append('\n');
        }

        RunResult result = runSnapshotComparer(input.toString(),
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Current depth is 0");
        assertContains(result, "Press enter to move to print current depth layer");
        assertContains(result, "Analysis for depth 0");
        assertContains(result, "Filtered node ");
    }

    @Test
    public void testInteractiveUnknownAbsolutePath_IsReportedThenComparisonCanFinish() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);
        String input = "/definitely_not_present\n" + repeat("\n", 128);

        RunResult result = runSnapshotComparer(input,
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Analysis for node /definitely_not_present");
        assertContains(result,
                "Path /definitely_not_present is neither found in left tree nor right tree.");
    }

    @Test
    public void testInteractiveInvalidTextAndOutOfRangeDepth_AreRejected() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);
        String input = "abc\n-1\n999999\n" + repeat("\n", 128);

        RunResult result = runSnapshotComparer(input,
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Input abc is not valid. Depth must be in range");
        assertContains(result, "Path must be an absolute path which starts with '/'.");
        assertContains(result, "Depth must be in range [0,");
    }

    private static RunResult compare(String left, String right, String bytes, String nodes)
            throws Exception {
        return runSnapshotComparer(null,
                "-l", left, "-r", right, "-b", bytes, "-n", nodes);
    }

    private static RunResult runSnapshotComparer(
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

    private static long exclusiveDescendantSize(
            RunResult result, String path, String side) {
        String prefix = "Node " + path + " found only in " + side
                + " tree. Descendant size: ";
        int start = result.output.indexOf(prefix);
        assertTrue("Expected exclusive-node output beginning with: " + prefix
                + "\nActual output:\n" + result.output, start >= 0);
        start += prefix.length();
        int end = result.output.indexOf('.', start);
        assertTrue("Expected descendant-size terminator in output:\n" + result.output,
                end > start);
        return Long.parseLong(result.output.substring(start, end));
    }

    private static void assertFixturesExist(String... paths) {
        for (String path : paths) {
            assertTrue("Required fixture does not exist: " + path, new File(path).isFile());
        }
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals("Unexpected process exit. Output:\n" + result.output, 0, result.exitCode);
        assertContains(result, COMPLETION);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals("Expected process failure. Output:\n" + result.output,
                0, result.exitCode);
    }

    private static void assertContains(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + ">. Actual output:\n"
                + result.output, result.output.contains(expected));
    }

    private static void assertContainsIgnoringCase(RunResult result, String expected) {
        assertTrue("Expected output to contain <" + expected + "> ignoring case. Actual output:\n"
                        + result.output,
                result.output.toLowerCase(Locale.ROOT)
                        .contains(expected.toLowerCase(Locale.ROOT)));
    }

    private static void assertContainsAnyIgnoringCase(RunResult result, String... alternatives) {
        String lower = result.output.toLowerCase(Locale.ROOT);
        for (String alternative : alternatives) {
            if (lower.contains(alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }
        throw new AssertionError("Expected one of " + Arrays.toString(alternatives)
                + ". Actual output:\n" + result.output);
    }

    private static void assertDoesNotContain(RunResult result, String forbidden) {
        assertFalse("Expected output not to contain <" + forbidden + ">. Actual output:\n"
                + result.output, result.output.contains(forbidden));
    }

    private static String repeat(String value, int count) {
        StringBuilder builder = new StringBuilder(value.length() * count);
        for (int i = 0; i < count; i++) {
            builder.append(value);
        }
        return builder.toString();
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

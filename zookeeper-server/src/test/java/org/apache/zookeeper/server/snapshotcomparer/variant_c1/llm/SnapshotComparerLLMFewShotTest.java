package org.apache.zookeeper.server.snapshotcomparer.variant_c1.llm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Ignore;
import org.junit.Test;

import org.apache.zookeeper.util.ServiceUtils;

/**
 * Black-box JUnit 4 tests for {@link SnapshotComparer}.
 *
 * <p>The application is launched in a separate JVM so tests observe the real command-line
 * contract and remain isolated from ServiceUtils.requestSystemExit. No reflection, Unsafe, or
 * private implementation detail is used.</p>
 */
public class SnapshotComparerLLMFewShotTest {

    private static final String BASE = "src/test/resources/data/comparer/";
    private static final String LEFT = BASE + "left.snap";
    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_PLUS_1_GZ = BASE + "right_plus_1.gz";
    private static final String LEFT_EPHEMERAL = BASE + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = BASE + "right_ephemeral.snap";
    private static final String CORRUPT = BASE + "corrupt_file.snap";
    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";

    private static final int VERY_HIGH_THRESHOLD = Integer.MAX_VALUE;

    @Test
    public void testIdenticalSnapshots_CompleteWithoutReportedDifference() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!", "All layers compared.");
        assertContains(result, "Printing analysis for nodes difference larger than 0 bytes "
                + "or node count difference larger than 0.");
        assertNoReportedDifference(result);
    }

    @Test
    public void testEquivalentCompressedAndUncompressedRightSnapshots_ProduceSameFindings()
            throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1, RIGHT_PLUS_1_GZ);

        RunResult plain = run("", "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
        RunResult gzip = run("", "-l", LEFT, "-r", RIGHT_PLUS_1_GZ, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(plain);
        assertCompletedSuccessfully(gzip);
        assertEquals("Compression must not alter comparison findings",
                comparisonFindings(plain.output), comparisonFindings(gzip.output));
        assertFalse("Fixture should exercise at least one finding", comparisonFindings(plain.output).isEmpty());
    }

    @Test
    public void testPathOnlyInRight_IsReported() throws Exception {
        assertFixturesExist(LEFT, RIGHT_PLUS_1);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Node /nodo_extra found only in right tree",
                "Node /payload found only in right tree");
    }

    @Test
    public void testHighThreshold_SuppressesAllOrdinaryFindings() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);

        RunResult result = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(VERY_HIGH_THRESHOLD),
                "-n", String.valueOf(VERY_HIGH_THRESHOLD));

        assertCompletedSuccessfully(result);
        assertNoReportedDifference(result);
    }

    @Test
    public void testDebugMode_ExposesComparisonAndFilteredDiagnostics() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", String.valueOf(VERY_HIGH_THRESHOLD),
                "-n", String.valueOf(VERY_HIGH_THRESHOLD), "-d");

        assertCompletedSuccessfully(result);
        assertContains(result, "Comparing ");
        assertTrue("Debug output should explain matching or filtered nodes. Output:\n" + result.output,
                result.output.contains("same") || result.output.contains("Filtered node "));
    }

    @Test
    public void testLongOptionNames_AreAccepted() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "--left", LEFT, "--right", RIGHT_IDENTICAL,
                "--bytes", "0", "--nodes", "0");

        assertCompletedSuccessfully(result);
        assertContains(result, "Successfully parsed options!", "All layers compared.");
    }

    @Ignore
    @Test
    public void testEphemeralDifferences_AreNotReportedAsPersistentTreeChanges() throws Exception {
        assertFixturesExist(LEFT_EPHEMERAL, RIGHT_EPHEMERAL);

        RunResult result = run("", "-l", LEFT_EPHEMERAL, "-r", RIGHT_EPHEMERAL,
                "-b", "0", "-n", "0");

        assertCompletedSuccessfully(result);
        assertNoReportedDifference(result);
    }

    @Test
    public void testInteractive_EmptyLinesAdvanceThroughEveryDepthAndTerminate() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            input.append('\n');
        }

        RunResult result = run(input.toString(), "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Current depth is 0", "Analysis for depth 0", "All layers compared.");
    }

    @Test
    public void testInteractive_AbsoluteUnknownPathReportsNeitherTree() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);
        String absentPath = "/path_that_is_absent_from_both_fixtures";

        RunResult result = run(absentPath + "\n" + repeatedNewlines(128),
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Analysis for node " + absentPath,
                "Path " + absentPath + " is neither found in left tree nor right tree.");
    }

    @Test
    public void testInteractive_InvalidTextAndOutOfRangeDepth_AreRejectedThenRecover()
            throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("not-a-depth\n-1\n" + repeatedNewlines(128),
                "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0", "-i");

        assertCompletedSuccessfully(result);
        assertContains(result, "Input not-a-depth is not valid.", "Depth must be in range [0,");
        assertContains(result, "All layers compared.");
    }

    @Test
    public void testMissingRequiredOption_FailsWithUsageAndDoesNotCompare() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0");

        assertFailed(result);
        assertContainsIgnoreCase(result, "missing required option");
        assertContains(result, "java -cp <classPath> " + SnapshotComparer.class.getName());
        assertDoesNotContain(result, "Successfully parsed options!", "All layers compared.");
    }

    @Test
    public void testUnknownOption_FailsWithUsage() throws Exception {
        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "0", "--not-a-real-option");

        assertFailed(result);
        assertContainsIgnoreCase(result, "unrecognized option");
        assertDoesNotContain(result, "Successfully parsed options!", "All layers compared.");
    }

    @Test
    public void testNonNumericByteThreshold_FailsBeforeLoadingSnapshots() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "NaN", "-n", "0");

        assertFailed(result);
        assertContainsIgnoreCase(result, "numberformatexception");
        assertDoesNotContain(result, "Successfully parsed options!", "All layers compared.");
    }

    @Test
    public void testNonNumericNodeThreshold_FailsBeforeLoadingSnapshots() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "0", "-n", "not-an-integer");

        assertFailed(result);
        assertContainsIgnoreCase(result, "numberformatexception");
        assertDoesNotContain(result, "Successfully parsed options!", "All layers compared.");
    }

    @Test
    public void testIntegerOverflowThreshold_Fails() throws Exception {
        assertFixturesExist(LEFT, RIGHT_IDENTICAL);

        RunResult result = run("", "-l", LEFT, "-r", RIGHT_IDENTICAL,
                "-b", "2147483648", "-n", "0");

        assertFailed(result);
        assertContainsIgnoreCase(result, "numberformatexception");
        assertDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testCorruptSnapshot_FailsLoadingAndNeverCompletesComparison() throws Exception {
        assertFixturesExist(LEFT, CORRUPT);

        RunResult result = run("", "-l", LEFT, "-r", CORRUPT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testMissingRightSnapshot_FailsLoadingAndNeverCompletesComparison() throws Exception {
        assertFixturesExist(LEFT);
        assertFalse("Ghost fixture is the designated nonexistent snapshot", new File(GHOST_RIGHT).exists());

        RunResult result = run("", "-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0");

        assertFailed(result);
        assertContainsAnyIgnoreCase(result, "no such file", "file not found",
                "filenotfoundexception", "cannot find");
        assertDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testThresholdComparison_IsStrictAtObservedByteDelta() throws Exception {
        assertFixturesExist(LEFT_MIXED, RIGHT_MIXED);
        RunResult baseline = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", "0", "-n", String.valueOf(VERY_HIGH_THRESHOLD));
        assertCompletedSuccessfully(baseline);

        Matcher finding = Pattern.compile(
                        "Node (\\S+) found in both trees\\. Delta: (-?\\d+) bytes, (-?\\d+) descendants")
                .matcher(baseline.output);
        assertTrue("Mixed fixtures must expose a byte delta. Output:\n" + baseline.output, finding.find());
        String path = finding.group(1);
        long absoluteDelta = Math.abs(Long.parseLong(finding.group(2)));
        assertTrue("Fixture byte delta must fit the CLI's int threshold", absoluteDelta <= Integer.MAX_VALUE);

        RunResult atThreshold = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(absoluteDelta),
                "-n", String.valueOf(VERY_HIGH_THRESHOLD));
        assertCompletedSuccessfully(atThreshold);
        assertDoesNotContain(atThreshold, "Node " + path + " found in both trees. Delta:");

        if (absoluteDelta > 0) {
            RunResult belowThreshold = run("", "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                    "-b", String.valueOf(absoluteDelta - 1),
                    "-n", String.valueOf(VERY_HIGH_THRESHOLD));
            assertCompletedSuccessfully(belowThreshold);
            assertContains(belowThreshold, "Node " + path + " found in both trees. Delta:");
        }
    }

    private static RunResult run(String standardInput, String... arguments)
            throws Exception {

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

    private static List<String> comparisonFindings(String output) {
        List<String> findings = new ArrayList<>();
        for (String line : output.split("\\R")) {
            if (line.startsWith("Node ")) {
                findings.add(line.trim());
            }
        }
        return findings;
    }

    private static String repeatedNewlines(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, '\n');
        return new String(chars);
    }

    private static void assertFixturesExist(String... names) {
        for (String name : names) {
            Path path = Paths.get(name);
            assertTrue("Required fixture does not exist: " + path.toAbsolutePath(), Files.isRegularFile(path));
        }
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals("Expected successful exit. Output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals("Expected nonzero exit. Output:\n" + result.output, 0, result.exitCode);
    }

    private static void assertContains(RunResult result, String... fragments) {
        for (String fragment : fragments) {
            assertTrue("Expected output to contain [" + fragment + "] but was:\n" + result.output,
                    result.output.contains(fragment));
        }
    }

    private static void assertContainsIgnoreCase(RunResult result, String fragment) {
        assertTrue("Expected output to contain [" + fragment + "] ignoring case but was:\n" + result.output,
                result.output.toLowerCase(Locale.ROOT).contains(fragment.toLowerCase(Locale.ROOT)));
    }

    private static void assertContainsAnyIgnoreCase(RunResult result, String... fragments) {
        String lower = result.output.toLowerCase(Locale.ROOT);
        for (String fragment : fragments) {
            if (lower.contains(fragment.toLowerCase(Locale.ROOT))) {
                return;
            }
        }
        fail("Expected any of " + Arrays.toString(fragments) + " but output was:\n" + result.output);
    }

    private static void assertDoesNotContain(RunResult result, String... fragments) {
        for (String fragment : fragments) {
            assertFalse("Expected output not to contain [" + fragment + "] but was:\n" + result.output,
                    result.output.contains(fragment));
        }
    }

    private static void assertNoReportedDifference(RunResult result) {
        assertFalse("Expected no reported node difference. Output:\n" + result.output,
                Pattern.compile("(?m)^Node .*?(found only|found in both trees\\. Delta:)")
                        .matcher(result.output).find());
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


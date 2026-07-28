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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>These tests exercise only publicly observable behavior through the public
 * {@code main(String[])} entry point. Each invocation runs in a separate JVM so
 * invalid command lines can request a system exit without terminating JUnit.
 *
 * <p>The tests intentionally do not use reflection, Unsafe, private nested
 * classes, or assumptions about snapshot serialization internals.
 */
public class SnapshotComparerGuidedToTFewShotTest {

    private static final String FIXTURE_DIRECTORY =
            "src/test/resources/data/comparer";

    private static final String LEFT =
            FIXTURE_DIRECTORY + "/left.snap";
    private static final String RIGHT_PLUS_1 =
            FIXTURE_DIRECTORY + "/right_plus_1.snap";
    private static final String RIGHT_IDENTICAL =
            FIXTURE_DIRECTORY + "/right_identical.snap";
    private static final String CORRUPT_FILE =
            FIXTURE_DIRECTORY + "/corrupt_file.snap";
    private static final String RIGHT_PLUS_1_GZIP =
            FIXTURE_DIRECTORY + "/right_plus_1.gz";
    private static final String LEFT_MIXED =
            FIXTURE_DIRECTORY + "/left_mixed.snap";
    private static final String RIGHT_MIXED =
            FIXTURE_DIRECTORY + "/right_mixed.snap";
    private static final String GHOST_RIGHT =
            FIXTURE_DIRECTORY + "/ghost_right.snap";
    private static final String LEFT_EPHEMERAL =
            FIXTURE_DIRECTORY + "/left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL =
            FIXTURE_DIRECTORY + "/right_ephemeral.snap";

    /*
     * Large enough to suppress the other threshold dimension for the supplied
     * fixtures without depending on their exact contents.
     */
    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    private static final long PROCESS_TIMEOUT_SECONDS = 30L;

    private static final Pattern DELTA_LINE = Pattern.compile(
            "Node (.+?) found in both trees\\. Delta: (-?\\d+) bytes, "
                    + "(-?\\d+) descendants");

    /*
     * ----------------------------------------------------------------------
     * Typical comparison behavior
     * ----------------------------------------------------------------------
     */

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
        assertOutputContains(result, "Node count:");
        assertOutputContains(result, "Total size:");
        assertOutputContains(result, "Max depth:");
        assertOutputContains(result, "Printing analysis for nodes difference");
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
        assertOutputContains(
                result,
                "Node /nodo_extra found only in right tree");
        assertOutputContains(
                result,
                "Node /payload found only in right tree");
        assertOutputContains(result, "Descendant size:");
        assertOutputContains(result, "Descendant count:");
    }

    @Test
    public void testReverseComparison_AddedNodesBecomeLeftOnly()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", RIGHT_PLUS_1,
                "-r", LEFT,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Node /nodo_extra found only in left tree");
        assertOutputContains(
                result,
                "Node /payload found only in left tree");
        assertOutputDoesNotContain(
                result,
                "Node /nodo_extra found only in right tree");
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
    public void testGzipSnapshot_IsReadAndComparedSuccessfully()
            throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1_GZIP);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZIP,
                "-b", "0",
                "-n", "0"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "right_plus_1.gz");
        assertOutputContains(
                result,
                "Node /nodo_extra found only in right tree");
        assertOutputContains(result, "All layers compared.");
    }

    /*
     * ----------------------------------------------------------------------
     * Threshold behavior and strict boundary semantics
     * ----------------------------------------------------------------------
     */

    @Test
    public void testByteThreshold_BelowDelta_ReportsMixedSnapshotDelta()
            throws Exception {
        assertMixedAssets();

        DeltaObservation observation = findByteDeltaObservation();
        int belowThreshold = observation.absoluteByteDelta - 1;

        RunResult result = runMixedComparison(
                String.valueOf(belowThreshold),
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertDeltaForPath(
                result,
                observation.path,
                observation.signedByteDelta,
                observation.signedNodeDelta);
    }

    @Test
    public void testByteThreshold_EqualToDelta_FiltersMixedSnapshotDelta()
            throws Exception {
        assertMixedAssets();

        DeltaObservation observation = findByteDeltaObservation();

        RunResult result = runMixedComparison(
                String.valueOf(observation.absoluteByteDelta),
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertNoDeltaForPath(result, observation.path);
    }

    @Test
    public void testNodeThreshold_BelowDelta_ReportsMixedSnapshotDelta()
            throws Exception {
        assertMixedAssets();

        DeltaObservation observation = findNodeDeltaObservation();
        int belowThreshold = observation.absoluteNodeDelta - 1;

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                String.valueOf(belowThreshold));

        assertCompletedSuccessfully(result);
        assertDeltaForPath(
                result,
                observation.path,
                observation.signedByteDelta,
                observation.signedNodeDelta);
    }

    @Test
    public void testNodeThreshold_EqualToDelta_FiltersMixedSnapshotDelta()
            throws Exception {
        assertMixedAssets();

        DeltaObservation observation = findNodeDeltaObservation();

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                String.valueOf(observation.absoluteNodeDelta));

        assertCompletedSuccessfully(result);
        assertNoDeltaForPath(result, observation.path);
    }

    @Test
    public void testVeryHighThresholds_SuppressOrdinaryDifferences()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testThresholdComparison_IsStrictlyGreaterThan()
            throws Exception {
        assertCoreAssets();

        RunResult baseline = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));
        assertCompletedSuccessfully(baseline);

        long payloadSize = extractRightOnlyDescendantSize(
                baseline,
                "/payload");

        RunResult equalThreshold = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", String.valueOf(payloadSize),
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertCompletedSuccessfully(equalThreshold);
        assertOutputDoesNotContain(
                equalThreshold,
                "Node /payload found only in right tree");
    }

    @Test
    public void testNegativeThresholds_AreAcceptedAndExposeZeroDeltaNodes()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "-1",
                "-n", "-1"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "found in both trees. Delta: 0 bytes");
        assertOutputContains(result, "All layers compared.");
    }

    /*
     * ----------------------------------------------------------------------
     * Debug and filtering behavior
     * ----------------------------------------------------------------------
     */

    @Test
    public void testDebugMode_PrintsComparisonAndFilteredDiagnostics()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Comparing ");
        assertOutputContains(result, "same");
        assertOutputContains(result, "Filtered node ");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testWithoutDebug_FilteredDiagnosticsAreNotPrinted()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(result, "Comparing ");
        assertOutputDoesNotContain(result, "Filtered node ");
        assertOutputContains(result, "All layers compared.");
    }

    /*
     * ----------------------------------------------------------------------
     * Interactive behavior
     * ----------------------------------------------------------------------
     */

    @Test
    public void testInteractiveMode_EnterAdvancesThroughDepths()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                ),
                repeatedNewlines(128));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Current depth is 0");
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "Filtered node ");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_ValidDepthJumpPrintsRequestedDepth()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                ),
                "1\n" + repeatedNewlines(128));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Analysis for depth 1");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_OutOfRangeDepthPrintsRangeError()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                ),
                "-1\n" + repeatedNewlines(128));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Depth must be in range [");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_NonnumericRelativePathIsRejected()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                ),
                "not-a-depth-or-path\n" + repeatedNewlines(128));

        assertCompletedSuccessfully(result);
        assertOutputContains(
                result,
                "Input not-a-depth-or-path is not valid.");
        assertOutputContains(
                result,
                "Path must be an absolute path which starts with '/'");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_MissingAbsolutePathIsReported()
            throws Exception {
        assertCoreAssets();

        String missingPath = "/path-that-does-not-exist";

        RunResult result = runSnapshotComparer(
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", VERY_HIGH_THRESHOLD,
                        "-n", VERY_HIGH_THRESHOLD,
                        "-i"
                ),
                missingPath + "\n" + repeatedNewlines(128));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Analysis for node " + missingPath);
        assertOutputContains(
                result,
                "Path " + missingPath
                        + " is neither found in left tree nor right tree.");
        assertOutputContains(result, "All layers compared.");
    }

    /*
     * ----------------------------------------------------------------------
     * Ephemeral-node behavior
     * ----------------------------------------------------------------------
     */

    @Ignore
    @Test
    public void testEphemeralDifferences_AreNotReportedAsSnapshotDifferences()
            throws Exception {
        assertEphemeralAssets();

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

    /*
     * ----------------------------------------------------------------------
     * Invalid invocation and loading failures
     * ----------------------------------------------------------------------
     */

    @Test
    public void testInvocation_NoArguments_FailsAndPrintsUsage()
            throws Exception {
        RunResult result = runSnapshotComparer(new String[0]);

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "missing required",
                "required option",
                "missing option");
        assertOutputContains(result, "usage:");
        assertOutputContains(result, "--left");
        assertOutputContains(result, "--right");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testInvocation_MissingRequiredRightOption_Fails()
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
                "missing required",
                "required option",
                "missing option");
        assertOutputContains(result, "usage:");
        assertOutputDoesNotContain(result, "Successfully parsed options!");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testInvocation_UnknownOption_FailsAndPrintsUsage()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0",
                "--not-a-real-option"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "unrecognized option",
                "not-a-real-option");
        assertOutputContains(result, "usage:");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testInvocation_NonnumericByteThreshold_Fails()
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
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testInvocation_NonnumericNodeThreshold_Fails()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "not-a-number"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "not-a-number");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testInvocation_OverflowingThreshold_Fails()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "2147483648",
                "-n", "0"
        ));

        assertFailed(result);
        assertOutputContainsAny(
                result,
                "numberformatexception",
                "for input string",
                "2147483648");
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading()
            throws Exception {
        assertAssetExists(LEFT);
        assertFalse(
                "Ghost file must not exist for this test: " + GHOST_RIGHT,
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
    public void testFileLeft_MissingSnapshot_FailsBeforeComparison()
            throws Exception {
        assertAssetExists(RIGHT_IDENTICAL);

        File missing = new File(
                FIXTURE_DIRECTORY,
                "missing-left-" + System.nanoTime() + ".snap");
        assertFalse(
                "Generated missing path unexpectedly exists",
                missing.exists());

        RunResult result = runSnapshotComparer(args(
                "-l", missing.getPath(),
                "-r", RIGHT_IDENTICAL,
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
    public void testFile_CorruptSnapshot_FailsDeserialization()
            throws Exception {
        assertAssetExists(LEFT);
        assertAssetExists(CORRUPT_FILE);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", CORRUPT_FILE,
                "-b", "0",
                "-n", "0"
        ));

        assertFailed(result);
        assertFalse(
                "A corrupt snapshot failure should provide diagnostics",
                result.output.trim().isEmpty());
        assertOutputDoesNotContain(result, "All layers compared.");
    }

    /*
     * ----------------------------------------------------------------------
     * Fixture validation
     * ----------------------------------------------------------------------
     */

    private static void assertCoreAssets() {
        assertAssetExists(LEFT);
        assertAssetExists(RIGHT_PLUS_1);
        assertAssetExists(RIGHT_IDENTICAL);
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
        File file = new File(path);
        assertTrue("Required fixture does not exist: " + path, file.isFile());
        assertTrue("Required fixture is not readable: " + path, file.canRead());
    }

    /*
     * ----------------------------------------------------------------------
     * Dynamic threshold observations
     * ----------------------------------------------------------------------
     */

    private static DeltaObservation findByteDeltaObservation()
            throws Exception {
        RunResult baseline = runMixedComparison("0", VERY_HIGH_THRESHOLD);
        assertCompletedSuccessfully(baseline);

        Matcher matcher = DELTA_LINE.matcher(baseline.output);
        while (matcher.find()) {
            int signedByteDelta = Integer.parseInt(matcher.group(2));
            int signedNodeDelta = Integer.parseInt(matcher.group(3));

            if (signedByteDelta != 0) {
                return new DeltaObservation(
                        matcher.group(1),
                        signedByteDelta,
                        signedNodeDelta);
            }
        }

        fail("Mixed fixtures did not expose a nonzero byte delta when "
                + "node deltas were suppressed.\nOutput:\n"
                + baseline.output);
        return null;
    }

    private static DeltaObservation findNodeDeltaObservation()
            throws Exception {
        RunResult baseline = runMixedComparison(VERY_HIGH_THRESHOLD, "0");
        assertCompletedSuccessfully(baseline);

        Matcher matcher = DELTA_LINE.matcher(baseline.output);
        while (matcher.find()) {
            int signedByteDelta = Integer.parseInt(matcher.group(2));
            int signedNodeDelta = Integer.parseInt(matcher.group(3));

            if (signedNodeDelta != 0) {
                return new DeltaObservation(
                        matcher.group(1),
                        signedByteDelta,
                        signedNodeDelta);
            }
        }

        fail("Mixed fixtures did not expose a nonzero descendant-count delta "
                + "when byte deltas were suppressed.\nOutput:\n"
                + baseline.output);
        return null;
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

    private static void assertDeltaForPath(
            RunResult result,
            String path,
            int signedByteDelta,
            int signedNodeDelta) {
        assertOutputContains(
                result,
                "Node " + path
                        + " found in both trees. Delta: "
                        + signedByteDelta
                        + " bytes, "
                        + signedNodeDelta
                        + " descendants");
    }

    private static void assertNoDeltaForPath(
            RunResult result,
            String path) {
        assertOutputDoesNotContain(
                result,
                "Node " + path + " found in both trees. Delta:");
    }

    private static long extractRightOnlyDescendantSize(
            RunResult result,
            String path) {
        Pattern pattern = Pattern.compile(
                "Node "
                        + Pattern.quote(path)
                        + " found only in right tree\\. "
                        + "Descendant size: (\\d+)\\. "
                        + "Descendant count: \\d+");

        Matcher matcher = pattern.matcher(result.output);
        assertTrue(
                "Could not find right-only details for "
                        + path
                        + ".\nOutput:\n"
                        + result.output,
                matcher.find());

        return Long.parseLong(matcher.group(1));
    }

    /*
     * ----------------------------------------------------------------------
     * Subprocess execution
     * ----------------------------------------------------------------------
     */

    private static RunResult runSnapshotComparer(String[] applicationArgs)
            throws Exception {
        return runSnapshotComparer(applicationArgs, "");
    }

    private static RunResult runSnapshotComparer(
            String[] applicationArgs,
            String standardInput) throws Exception {
        List<String> command = new ArrayList<>();
        command.add(javaExecutable());
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(SnapshotComparer.class.getName());
        command.addAll(Arrays.asList(applicationArgs));

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);

        Process process = builder.start();

        try (OutputStream input = process.getOutputStream()) {
            if (standardInput != null && !standardInput.isEmpty()) {
                input.write(standardInput.getBytes(StandardCharsets.UTF_8));
                input.flush();
            }
        }

        OutputCollector collector = new OutputCollector(
                process.getInputStream());
        Thread collectorThread = new Thread(
                collector,
                "snapshot-comparer-output");
        collectorThread.setDaemon(true);
        collectorThread.start();

        boolean completed = process.waitFor(
                PROCESS_TIMEOUT_SECONDS,
                TimeUnit.SECONDS);

        if (!completed) {
            process.destroyForcibly();
            process.waitFor(5, TimeUnit.SECONDS);
            collectorThread.join(TimeUnit.SECONDS.toMillis(5));
            fail("SnapshotComparer process timed out.\nCommand: " + command);
        }

        collectorThread.join(TimeUnit.SECONDS.toMillis(5));
        assertFalse(
                "Output collector did not terminate",
                collectorThread.isAlive());

        if (collector.failure != null) {
            throw collector.failure;
        }

        return new RunResult(process.exitValue(), collector.output());
    }

    private static String javaExecutable() {
        String executableName = isWindows() ? "java.exe" : "java";
        File executable = new File(
                new File(System.getProperty("java.home"), "bin"),
                executableName);

        assertTrue(
                "Java executable does not exist: " + executable,
                executable.isFile());

        return executable.getAbsolutePath();
    }

    private static boolean isWindows() {
        return System.getProperty("os.name", "")
                .toLowerCase(Locale.ROOT)
                .contains("win");
    }

    private static String[] args(String... values) {
        return values;
    }

    private static String repeatedNewlines(int count) {
        StringBuilder builder = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            builder.append('\n');
        }
        return builder.toString();
    }

    /*
     * ----------------------------------------------------------------------
     * Assertions
     * ----------------------------------------------------------------------
     */

    private static void assertCompletedSuccessfully(RunResult result) {
        assertNotNull(result);
        assertEquals(
                "Expected successful process completion.\nOutput:\n"
                        + result.output,
                0,
                result.exitCode);
    }

    private static void assertFailed(RunResult result) {
        assertNotNull(result);
        assertNotEquals(
                "Expected process failure, but exit code was zero.\nOutput:\n"
                        + result.output,
                0,
                result.exitCode);
    }

    private static void assertOutputContains(
            RunResult result,
            String expected) {
        assertNotNull(result);
        assertTrue(
                "Expected output to contain:\n"
                        + expected
                        + "\nActual output:\n"
                        + result.output,
                result.output.contains(expected));
    }

    private static void assertOutputDoesNotContain(
            RunResult result,
            String unexpected) {
        assertNotNull(result);
        assertFalse(
                "Expected output not to contain:\n"
                        + unexpected
                        + "\nActual output:\n"
                        + result.output,
                result.output.contains(unexpected));
    }

    private static void assertOutputContainsAny(
            RunResult result,
            String... candidates) {
        assertNotNull(result);

        String normalizedOutput =
                result.output.toLowerCase(Locale.ROOT);

        for (String candidate : candidates) {
            if (normalizedOutput.contains(
                    candidate.toLowerCase(Locale.ROOT))) {
                return;
            }
        }

        fail("Expected output to contain at least one of "
                + Arrays.toString(candidates)
                + ".\nActual output:\n"
                + result.output);
    }

    /*
     * ----------------------------------------------------------------------
     * Value objects and stream collection
     * ----------------------------------------------------------------------
     */

    private static final class RunResult {
        private final int exitCode;
        private final String output;

        private RunResult(int exitCode, String output) {
            this.exitCode = exitCode;
            this.output = output;
        }
    }

    private static final class DeltaObservation {
        private final String path;
        private final int signedByteDelta;
        private final int signedNodeDelta;
        private final int absoluteByteDelta;
        private final int absoluteNodeDelta;

        private DeltaObservation(
                String path,
                int signedByteDelta,
                int signedNodeDelta) {
            this.path = path;
            this.signedByteDelta = signedByteDelta;
            this.signedNodeDelta = signedNodeDelta;
            this.absoluteByteDelta = Math.abs(signedByteDelta);
            this.absoluteNodeDelta = Math.abs(signedNodeDelta);
        }
    }

    private static final class OutputCollector implements Runnable {
        private final InputStream input;
        private final ByteArrayOutputStream bytes =
                new ByteArrayOutputStream();
        private volatile IOException failure;

        private OutputCollector(InputStream input) {
            this.input = input;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[4096];

            try (InputStream stream = input) {
                int count;
                while ((count = stream.read(buffer)) != -1) {
                    bytes.write(buffer, 0, count);
                }
            } catch (IOException e) {
                failure = e;
            }
        }

        private String output() {
            return new String(
                    bytes.toByteArray(),
                    StandardCharsets.UTF_8);
        }
    }
}
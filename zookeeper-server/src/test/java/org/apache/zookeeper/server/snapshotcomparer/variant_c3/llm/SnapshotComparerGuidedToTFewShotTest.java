package org.apache.zookeeper.server.snapshotcomparer.variant_c3.llm;

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
import org.junit.Test;

/**
 * Black-box tests for {@link SnapshotComparer}.
 *
 * <p>The tests invoke only the public main method, through a child JVM. They
 * observe process completion, exit status, and console output. No reflection,
 * Unsafe access, or private implementation detail is used.
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

    private static final long PROCESS_TIMEOUT_SECONDS = 30L;

    private static final Pattern DELTA_PATTERN = Pattern.compile(
            "Node (.*?) found in both trees\\. Delta: "
                    + "(-?\\d+) bytes, (-?\\d+) descendants");

    @Test
    public void testFixtures_ExpectedAssetsAreAvailable() {
        assertCoreAssets();
        assertMixedAssets();
        assertAssetExists(CORRUPT_FILE);
        assertAssetExists(RIGHT_PLUS_1_GZ);
        assertAssetExists(LEFT_EPHEMERAL);
        assertAssetExists(RIGHT_EPHEMERAL);

        assertFalse(
                "Ghost file must not exist for missing-file tests: "
                        + new File(GHOST_RIGHT).getAbsolutePath(),
                new File(GHOST_RIGHT).exists());
    }

    @Test
    public void testRelation_IdenticalSnapshots_ReportsNoDifferences()
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
    }

    @Test
    public void testRelation_ReversedSnapshots_ReportsPathsOnlyInLeft()
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
    }

    @Test
    public void testCompressedSnapshot_RightPlusOne_ReportsExpectedPaths()
            throws Exception {
        assertCoreAssets();
        assertAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
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
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testCompressedAndUncompressedSnapshots_AreEquivalent()
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
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testMixedComparison_ReportsPayloadQuantitativeDelta()
            throws Exception {
        assertMixedAssets();

        RunResult result = runMixedComparison("-1", VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);

        ObservedDelta payload = findDeltaForPath(result, "/payload");
        assertNotNull(
                "Expected a publicly reported delta for /payload.\n"
                        + result.describe(),
                payload);
        assertTrue(
                "Expected /payload to have a non-zero byte delta.\n"
                        + result.describe(),
                Math.abs(payload.byteDelta) > 0L);
    }

    @Test
    public void testByteThreshold_BelowDelta_ReportsPayloadDelta()
            throws Exception {
        assertMixedAssets();

        ObservedDelta payload = observeDeltaForPath("/payload");
        long magnitude = Math.abs(payload.byteDelta);
        assertTrue("The /payload byte delta must be non-zero", magnitude > 0L);

        RunResult result = runMixedComparison(
                String.valueOf(magnitude - 1L),
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(
                result,
                "/payload",
                payload.byteDelta + " bytes");
    }

    @Test
    public void testByteThreshold_EqualToDelta_FiltersPayloadDelta()
            throws Exception {
        assertMixedAssets();

        ObservedDelta payload = observeDeltaForPath("/payload");
        long magnitude = Math.abs(payload.byteDelta);
        assertTrue("The /payload byte delta must be non-zero", magnitude > 0L);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(magnitude),
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(
                result,
                "Node /payload found in both trees. Delta:");
        assertOutputContains(result, "Filtered node /payload");
    }

    @Test
    public void testNodeThreshold_BelowDelta_ReportsDescendantDelta()
            throws Exception {
        assertMixedAssets();

        ObservedDelta observed = observeNonZeroDescendantDelta();
        long magnitude = Math.abs(observed.descendantDelta);
        assertTrue("Expected a non-zero descendant delta", magnitude > 0L);

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                String.valueOf(magnitude - 1L));

        assertCompletedSuccessfully(result);
        assertQuantitativeDeltaForPath(
                result,
                observed.path,
                observed.descendantDelta + " descendants");
    }

    @Test
    public void testNodeThreshold_EqualToDelta_FiltersDescendantDelta()
            throws Exception {
        assertMixedAssets();

        ObservedDelta observed = observeNonZeroDescendantDelta();
        long magnitude = Math.abs(observed.descendantDelta);
        assertTrue("Expected a non-zero descendant delta", magnitude > 0L);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(magnitude),
                "-d"
        ));

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(
                result,
                "Node " + observed.path
                        + " found in both trees. Delta:");
        assertOutputContains(
                result,
                "Filtered node " + observed.path);
    }

    @Test
    public void testThresholds_VeryHighValuesSuppressDifferenceReports()
            throws Exception {
        assertMixedAssets();

        RunResult result = runMixedComparison(
                VERY_HIGH_THRESHOLD,
                VERY_HIGH_THRESHOLD);

        assertCompletedSuccessfully(result);
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testThresholds_NegativeValuesExposeZeroDeltaNodes()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "-1",
                "-n", "-1"
        ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "found in both trees. Delta: 0 bytes");
        assertOutputContains(result, "0 descendants");
    }

    @Test
    public void testDebugMode_PrintsComparisonDiagnostics()
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
        assertOutputContains(result, "Comparing ");
        assertOutputContains(result, "same");
        assertOutputContains(result, "Filtered node ");
    }

    @Test
    public void testLongOptions_AreAccepted() throws Exception {
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
    public void testEphemeralFixtures_LoadAndCompleteComparison()
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
        assertOutputContains(result, "Successfully parsed options!");
        assertOutputContains(result, "Deserialized snapshot");
        assertOutputContains(result, "Node count:");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractive_EmptyInputAdvancesAndCompletes()
            throws Exception {
        assertCoreAssets();

        RunResult result = runSnapshotComparerWithInput(
                repeatedNewLines(64),
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Current depth is 0");
        assertOutputContains(result, "Press enter to move");
        assertOutputContains(result, "Analysis for depth 0");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractive_AbsolutePathAnalyzesRequestedSubtree()
            throws Exception {
        assertMixedAssets();

        String input = "/payload\n" + repeatedNewLines(64);
        RunResult result = runSnapshotComparerWithInput(
                input,
                args(
                        "-l", LEFT_MIXED,
                        "-r", RIGHT_MIXED,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Analysis for node /payload");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractive_OutOfRangeDepthReportsRangeError()
            throws Exception {
        assertCoreAssets();

        String input = "999999\n" + repeatedNewLines(64);
        RunResult result = runSnapshotComparerWithInput(
                input,
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Depth must be in range [0,");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testInteractive_InvalidTextReportsValidationGuidance()
            throws Exception {
        assertCoreAssets();

        String input = "not-a-depth\n" + repeatedNewLines(64);
        RunResult result = runSnapshotComparerWithInput(
                input,
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                ));

        assertCompletedSuccessfully(result);
        assertOutputContains(result, "Input not-a-depth is not valid.");
        assertOutputContains(result, "Path must be an absolute path");
        assertOutputContains(result, "All layers compared.");
    }

    @Test
    public void testOptions_MissingRequiredRightOption_Fails()
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
                "required option");
        assertOutputContainsIgnoreCase(result, "usage:");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testOptions_UnknownOption_Fails() throws Exception {
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
                "unknown option",
                "not-a-real-option");
        assertOutputContainsIgnoreCase(result, "usage:");
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testByteThreshold_NonNumericValue_Fails()
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
        assertOutputDoesNotContain(result, "All layers compared");
    }

    @Test
    public void testNodeThreshold_NonNumericValue_Fails()
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
        assertOutputDoesNotContain(result, "All layers compared");
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
        assertOutputDoesNotContain(result, "All layers compared");
        assertOutputContainsAny(
                result,
                "exception",
                "error",
                "eof",
                "checksum",
                "corrupt",
                "deserialize",
                "snapshot");
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

    private static ObservedDelta observeDeltaForPath(String path)
            throws Exception {
        RunResult probe = runMixedComparison("-1", "-1");
        assertCompletedSuccessfully(probe);

        ObservedDelta delta = findDeltaForPath(probe, path);
        assertNotNull(
                "No quantitative delta was reported for " + path + ".\n"
                        + probe.describe(),
                delta);
        return delta;
    }

    private static ObservedDelta observeNonZeroDescendantDelta()
            throws Exception {
        RunResult probe = runMixedComparison("-1", "-1");
        assertCompletedSuccessfully(probe);

        Matcher matcher = DELTA_PATTERN.matcher(probe.output);
        while (matcher.find()) {
            long descendants = Long.parseLong(matcher.group(3));
            if (descendants != 0L) {
                return new ObservedDelta(
                        matcher.group(1),
                        Long.parseLong(matcher.group(2)),
                        descendants);
            }
        }

        fail("Expected the mixed fixtures to expose at least one non-zero "
                + "descendant delta.\n" + probe.describe());
        return null;
    }

    private static ObservedDelta findDeltaForPath(
            RunResult result,
            String expectedPath
    ) {
        Matcher matcher = DELTA_PATTERN.matcher(result.output);
        while (matcher.find()) {
            if (expectedPath.equals(matcher.group(1))) {
                return new ObservedDelta(
                        matcher.group(1),
                        Long.parseLong(matcher.group(2)),
                        Long.parseLong(matcher.group(3)));
            }
        }
        return null;
    }

    private static RunResult runSnapshotComparer(String... arguments)
            throws Exception {
        return runSnapshotComparerWithInput("", arguments);
    }

    private static RunResult runSnapshotComparerWithInput(
            String standardInput,
            String... arguments
    ) throws Exception {
        List<String> command = new ArrayList<String>();
        command.add(javaExecutable());
        command.add("-cp");
        command.add(absoluteClassPath());
        command.add(SnapshotComparer.class.getName());
        command.addAll(Arrays.asList(arguments));

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File(System.getProperty("user.dir")));
        builder.redirectErrorStream(true);

        Process process = builder.start();

        try (OutputStream input = process.getOutputStream()) {
            input.write(standardInput.getBytes(StandardCharsets.UTF_8));
            input.flush();
        }

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        Thread reader = new Thread(new StreamCollector(
                process.getInputStream(),
                captured));
        reader.setDaemon(true);
        reader.start();

        boolean finished = process.waitFor(
                PROCESS_TIMEOUT_SECONDS,
                TimeUnit.SECONDS);

        if (!finished) {
            process.destroyForcibly();
            process.waitFor(5L, TimeUnit.SECONDS);
            reader.join(5000L);
            fail("SnapshotComparer did not finish within "
                    + PROCESS_TIMEOUT_SECONDS + " seconds.\nOutput:\n"
                    + new String(
                    captured.toByteArray(),
                    StandardCharsets.UTF_8));
        }

        reader.join(5000L);
        assertFalse(
                "Output collector did not terminate",
                reader.isAlive());

        return new RunResult(
                process.exitValue(),
                new String(
                        captured.toByteArray(),
                        StandardCharsets.UTF_8),
                command);
    }

    private static String javaExecutable() {
        String executable = isWindows() ? "java.exe" : "java";
        File java = new File(
                new File(System.getProperty("java.home"), "bin"),
                executable);
        assertTrue(
                "Java executable does not exist: "
                        + java.getAbsolutePath(),
                java.isFile());
        return java.getAbsolutePath();
    }

    private static String absoluteClassPath() {
        String[] entries = System.getProperty("java.class.path")
                .split(Pattern.quote(File.pathSeparator));
        StringBuilder result = new StringBuilder();

        for (String entry : entries) {
            if (result.length() > 0) {
                result.append(File.pathSeparator);
            }

            File file = new File(entry);
            result.append(file.isAbsolute()
                    ? file.getPath()
                    : file.getAbsolutePath());
        }

        return result.toString();
    }

    private static boolean isWindows() {
        return System.getProperty("os.name")
                .toLowerCase(Locale.ROOT)
                .contains("win");
    }

    private static String repeatedNewLines(int count) {
        StringBuilder input = new StringBuilder(count);
        for (int index = 0; index < count; index++) {
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
        assertAssetExists(RIGHT_PLUS_1);
    }

    private static void assertMixedAssets() {
        assertAssetExists(LEFT_MIXED);
        assertAssetExists(RIGHT_MIXED);
    }

    private static void assertAssetExists(String path) {
        File asset = new File(path);
        assertTrue(
                "Required snapshot fixture does not exist: "
                        + asset.getAbsolutePath(),
                asset.isFile());
    }

    private static void assertCompletedSuccessfully(RunResult result) {
        assertEquals(
                "Expected SnapshotComparer to complete successfully.\n"
                        + result.describe(),
                0,
                result.exitCode);
        assertOutputContains(result, "All layers compared.");
    }

    private static void assertFailed(RunResult result) {
        assertNotEquals(
                "Expected SnapshotComparer to fail.\n"
                        + result.describe(),
                0,
                result.exitCode);
    }

    private static void assertOutputContains(
            RunResult result,
            String expected
    ) {
        assertTrue(
                "Expected output to contain:\n" + expected + "\n\n"
                        + result.describe(),
                result.output.contains(expected));
    }

    private static void assertOutputContainsIgnoreCase(
            RunResult result,
            String expected
    ) {
        assertTrue(
                "Expected output to contain, ignoring case:\n"
                        + expected + "\n\n" + result.describe(),
                result.output.toLowerCase(Locale.ROOT)
                        .contains(expected.toLowerCase(Locale.ROOT)));
    }

    private static void assertOutputContainsAny(
            RunResult result,
            String... alternatives
    ) {
        String normalized = result.output.toLowerCase(Locale.ROOT);

        for (String alternative : alternatives) {
            if (normalized.contains(
                    alternative.toLowerCase(Locale.ROOT))) {
                return;
            }
        }

        fail("Expected output to contain at least one of "
                + Arrays.toString(alternatives) + ".\n"
                + result.describe());
    }

    private static void assertOutputDoesNotContain(
            RunResult result,
            String unexpected
    ) {
        assertFalse(
                "Expected output not to contain:\n" + unexpected + "\n\n"
                        + result.describe(),
                result.output.contains(unexpected));
    }

    private static void assertQuantitativeDeltaForPath(
            RunResult result,
            String path,
            String expectedQuantity
    ) {
        String prefix = "Node " + path
                + " found in both trees. Delta:";

        assertOutputContains(result, prefix);

        Pattern linePattern = Pattern.compile(
                "(?m)^" + Pattern.quote(prefix) + ".*"
                        + Pattern.quote(expectedQuantity) + ".*$");

        assertTrue(
                "Expected the delta line for " + path
                        + " to contain " + expectedQuantity + ".\n"
                        + result.describe(),
                linePattern.matcher(result.output).find());
    }

    private static final class StreamCollector implements Runnable {
        private final InputStream source;
        private final ByteArrayOutputStream destination;

        private StreamCollector(
                InputStream source,
                ByteArrayOutputStream destination
        ) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[4096];
            int count;

            try (InputStream input = source) {
                while ((count = input.read(buffer)) != -1) {
                    destination.write(buffer, 0, count);
                }
            } catch (IOException exception) {
                try {
                    destination.write(
                            ("\nOutput collection failed: " + exception)
                                    .getBytes(StandardCharsets.UTF_8));
                } catch (IOException ignored) {
                    // ByteArrayOutputStream does not normally throw here.
                }
            }
        }
    }

    private static final class ObservedDelta {
        private final String path;
        private final long byteDelta;
        private final long descendantDelta;

        private ObservedDelta(
                String path,
                long byteDelta,
                long descendantDelta
        ) {
            this.path = path;
            this.byteDelta = byteDelta;
            this.descendantDelta = descendantDelta;
        }
    }

    private static final class RunResult {
        private final int exitCode;
        private final String output;
        private final List<String> command;

        private RunResult(
                int exitCode,
                String output,
                List<String> command
        ) {
            this.exitCode = exitCode;
            this.output = output;
            this.command = new ArrayList<String>(command);
        }

        private String describe() {
            return "Exit code: " + exitCode
                    + "\nCommand: " + command
                    + "\nOutput:\n" + output;
        }
    }
}
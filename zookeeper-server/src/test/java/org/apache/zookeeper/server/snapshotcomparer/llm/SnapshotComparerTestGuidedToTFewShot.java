package org.apache.zookeeper.server;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Guided black-box tests for SnapshotComparer.
 *
 * These tests exercise only publicly observable behavior through SnapshotComparer.main:
 * command-line parsing, snapshot loading, output reporting, thresholds, debug mode,
 * interactive mode, compressed input, and error handling.
 */
public class SnapshotComparerTestGuidedToTFewShot {

    private static final String BASE = "src/test/resources/data/comparer/";

    private static final String LEFT = BASE + "left.snap";
    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String LEFT_NODES = BASE + "left_nodes.snap";
    private static final String LEFT_PAYLOAD = BASE + "left_payload.snap";

    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";
    private static final String RIGHT_NODES_CHANGED = BASE + "right_nodes_changed.snap";
    private static final String RIGHT_PAYLOAD_CHANGED = BASE + "right_payload_changed.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_PLUS_1_GZ = BASE + "right_plus_1.gz";

    private static final String CORRUPT = BASE + "corrupt_file.snap";
    private static final String GHOST_RIGHT = BASE + "ghost_right_does_not_exist.snap";

    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    @Test
    public void testIdenticalSnapshots_NoDifferencesReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Successfully parsed options!", "All layers compared.");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
    }

    @Test
    public void testRelation_PathOnlyInRight_IsReported() throws Exception {
        assumeCoreAssets();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Node /nodo_extra found only in right tree");
        assertOutputContainsAny(result, "Node /payload found only in right tree");
    }

    @Test
    public void testCompressedRightSnapshot_LoadsAndCompares() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Deserialized snapshot in right_plus_1.gz");
        assertOutputContainsAny(result, "found only in right tree");
    }

    @Ignore
    @Test
    public void testPayloadDifference_WithLowThreshold_IsReported() throws Exception {
        assumeAssetExists(LEFT_PAYLOAD);
        assumeAssetExists(RIGHT_PAYLOAD_CHANGED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_PAYLOAD,
                "-r", RIGHT_PAYLOAD_CHANGED,
                "-b", "0",
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "found in both trees. Delta:");
        assertOutputContainsAny(result, "bytes");
    }

    @Test
    public void testPayloadDifference_WithVeryHighThreshold_IsFiltered() throws Exception {
        assumeAssetExists(LEFT_PAYLOAD);
        assumeAssetExists(RIGHT_PAYLOAD_CHANGED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_PAYLOAD,
                "-r", RIGHT_PAYLOAD_CHANGED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertSuccessfulRun(result);
        assertOutputDoesNotContain(result, "found in both trees. Delta:");
        assertOutputDoesNotContain(result, "found only in left tree");
        assertOutputDoesNotContain(result, "found only in right tree");
    }

    @Test
    public void testMixedSnapshots_LowThreshold_ReportsObservableDifferences() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(
                result,
                "found in both trees. Delta:",
                "found only in left tree",
                "found only in right tree"
        );
    }

    @Test
    public void testNodeCountDifference_WithLowNodeThreshold_IsReported() throws Exception {
        assumeAssetExists(LEFT_NODES);
        assumeAssetExists(RIGHT_NODES_CHANGED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_NODES,
                "-r", RIGHT_NODES_CHANGED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "descendants", "found only in right tree", "found only in left tree");
    }

    @Test
    public void testThresholdBoundary_ZeroThresholdStillFiltersZeroDeltaIdenticalNodes() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertSuccessfulRun(result);
        assertOutputDoesNotContain(result, "Delta: 0 bytes, 0 descendants");
    }

    @Test
    public void testDebugMode_PrintsComparisonOrFilteringDetails() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", VERY_HIGH_THRESHOLD,
                "-d"
        ));

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Comparing", "same", "Filtered node");
    }

    @Test
    public void testInteractiveMode_EnterAdvancesThroughLayersAndCompletes() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparerWithInput(
                "\n\n\n\n\n\n\n\n\n\n",
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                )
        );

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Current depth is 0");
        assertOutputContainsAny(result, "Analysis for depth 0");
        assertOutputContainsAny(result, "All layers compared.");
    }

    @Test
    public void testInteractiveMode_InvalidInputAndUnknownPath_AreReported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparerWithInput(
                "not-a-depth\n/definitely_not_present_in_either_snapshot\n\n\n\n\n\n\n\n\n",
                args(
                        "-l", LEFT,
                        "-r", RIGHT_IDENTICAL,
                        "-b", "0",
                        "-n", "0",
                        "-i"
                )
        );

        assertSuccessfulRun(result);
        assertOutputContainsAny(result, "Input not-a-depth is not valid");
        assertOutputContainsAny(result, "Path /definitely_not_present_in_either_snapshot is neither found in left tree nor right tree.");
    }

    @Test
    public void testCommandLine_MissingRequiredOption_ExitsWithUsage() throws Exception {
        assumeSecurityManagerCanInterceptExit();

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-b", "0",
                "-n", "0"
        ));

        assertNotNull("Missing required option should request system exit", result.exitStatus);
        assertTrue("Exit status should indicate invalid invocation", result.exitStatus.intValue() != 0);
        assertOutputContainsAny(result, "Missing required option", "usage:", "right");
    }

    @Test
    public void testCommandLine_InvalidNumericThreshold_FailsBeforeComparisonCompletes() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "not-a-number",
                "-n", "0"
        ));

        assertNotNull("Invalid numeric threshold should fail", result.throwable);
        assertTrue(result.throwable instanceof NumberFormatException
                || result.throwable.getCause() instanceof NumberFormatException);
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading() throws Exception {
        assumeAssetExists(LEFT);
        assertFalse("Ghost file must not exist for this test", new File(GHOST_RIGHT).exists());

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", GHOST_RIGHT,
                "-b", "0",
                "-n", "0"
        ));

        assertTrue("Missing snapshot should throw or print an error",
                result.throwable != null
                        || outputLower(result).contains("no such")
                        || outputLower(result).contains("not found")
                        || outputLower(result).contains("filenotfound")
                        || outputLower(result).contains("error")
                        || outputLower(result).contains("exception"));
    }

    @Test
    public void testCorruptSnapshot_FailsLoading() throws Exception {
        assumeAssetExists(CORRUPT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", CORRUPT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertTrue("Corrupt snapshot should throw or print an error",
                result.throwable != null
                        || outputLower(result).contains("error")
                        || outputLower(result).contains("exception")
                        || outputLower(result).contains("corrupt")
                        || outputLower(result).contains("crc")
                        || outputLower(result).contains("eof"));
    }

    private static void assumeCoreAssets() {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);
    }

    private static void assumeAssetExists(String path) {
        assumeTrue("Required fixture not found: " + path, new File(path).isFile());
    }

    private static String[] args(String... args) {
        return args;
    }

    private static void assertSuccessfulRun(RunResult result) {
        if (result.throwable != null) {
            result.throwable.printStackTrace();
        }
        assertNull("No System.exit expected", result.exitStatus);
        assertNull("No exception expected", result.throwable);
    }

    private static void assertOutputContainsAny(RunResult result, String... expectedFragments) {
        String output = result.allOutput();
        for (String expected : expectedFragments) {
            if (output.contains(expected)) {
                return;
            }
        }
        fail("Expected output to contain one of "
                + java.util.Arrays.toString(expectedFragments)
                + " but was:\n"
                + output);
    }

    private static void assertOutputDoesNotContain(RunResult result, String unexpected) {
        assertFalse("Output should not contain <" + unexpected + "> but was:\n" + result.allOutput(),
                result.allOutput().contains(unexpected));
    }

    private static String outputLower(RunResult result) {
        return result.allOutput().toLowerCase(java.util.Locale.ROOT);
    }

    private static RunResult runSnapshotComparer(String[] args) throws Exception {
        return runSnapshotComparerWithInput("", args);
    }

    private static RunResult runSnapshotComparerWithInput(String stdin, String[] args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        java.io.InputStream originalIn = System.in;
        SecurityManager originalSecurityManager = System.getSecurityManager();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        RunResult result = new RunResult();

        try {
            System.setOut(new PrintStream(out, true, "UTF-8"));
            System.setErr(new PrintStream(err, true, "UTF-8"));
            System.setIn(new ByteArrayInputStream(stdin.getBytes("UTF-8")));

            try {
                System.setSecurityManager(new NoExitSecurityManager());
            } catch (UnsupportedOperationException securityManagerDisabled) {
                result.throwable = securityManagerDisabled;
                return result;
            }

            try {
                SnapshotComparer.main(args);
            } catch (ExitException exit) {
                result.exitStatus = exit.status;
            } catch (Throwable throwable) {
                result.throwable = throwable;
            }
        } finally {
            result.stdout = out.toString("UTF-8");
            result.stderr = err.toString("UTF-8");

            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
            try {
                System.setSecurityManager(originalSecurityManager);
            } catch (UnsupportedOperationException ignored) {
                // Some modern JVMs may disable SecurityManager restoration.
            }
        }

        return result;
    }

    private static void assumeSecurityManagerCanInterceptExit() {
        SecurityManager original = System.getSecurityManager();
        try {
            System.setSecurityManager(new NoExitSecurityManager());
            System.setSecurityManager(original);
        } catch (UnsupportedOperationException ex) {
            org.junit.Assume.assumeNoException("SecurityManager cannot intercept System.exit on this JVM", ex);
        } catch (SecurityException ex) {
            org.junit.Assume.assumeNoException("SecurityManager cannot intercept System.exit on this JVM", ex);
        }
    }

    private static final class RunResult {
        private String stdout = "";
        private String stderr = "";
        private Integer exitStatus;
        private Throwable throwable;

        private String allOutput() {
            return stdout + "\n" + stderr;
        }
    }

    private static final class ExitException extends SecurityException {
        private static final long serialVersionUID = 1L;

        private final int status;

        private ExitException(int status) {
            super("Intercepted System.exit(" + status + ")");
            this.status = status;
        }
    }

    private static final class NoExitSecurityManager extends SecurityManager {
        @Override
        public void checkPermission(Permission permission) {
            // Allow everything except System.exit.
        }

        @Override
        public void checkPermission(Permission permission, Object context) {
            // Allow everything except System.exit.
        }

        @Override
        public void checkExit(int status) {
            throw new ExitException(status);
        }
    }
}
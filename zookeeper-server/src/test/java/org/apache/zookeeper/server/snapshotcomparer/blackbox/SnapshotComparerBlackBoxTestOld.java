package org.apache.zookeeper.server;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Permission;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Manual black-box tests for SnapshotComparer generated from Category Partition + BVA.
 *
 * Expected resource folder:
 *   src/test/resources/data/comparer/
 *
 * Required assets:
 *   left.snap
 *   right_plus_1.snap
 *   right_identical.snap
 *   corrupt_file.snap
 *   left_mixed.snap
 *   right_mixed.snap
 *
 * Optional/compression assets:
 *   right_plus_1.gz
 *
 * Notes:
 *   - corrupt_file.snap is created automatically if absent.
 *   - left_mixed.snap and right_mixed.snap are used for mixed deltas,
 *     payload deltas and threshold boundary tests.
 */

// E' VECCHIA, DA ELIMINARE IN SEGUITO
public class SnapshotComparerBlackBoxTestOld {

    private static final String BASE = "src/test/resources/data/comparer/";

    private static final String LEFT = BASE + "left.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String CORRUPT = BASE + "corrupt_file.snap";

    private static final String RIGHT_GZ = BASE + "right_plus_1.gz";

    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";

    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";

    // These calibrated values must match LEFT_MIXED and RIGHT_MIXED.
    // D_BYTES = 8 is observed on /payload and D_NODES = 1 is observed on /parent.

    private static final int D_BYTES = 8;
    private static final int D_NODES = 1;

    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    private static final int INTERACTIVE_COMPLETION_NEWLINES = 10;
    private static PrintStream originalOut;
    private static PrintStream originalErr;
    private static InputStream originalIn;
    private static SecurityManager originalSecurityManager;

    @BeforeClass
    public static void prepareBasicAssets() throws IOException {
        Path base = Paths.get(BASE);
        if (!Files.exists(base)) {
            Files.createDirectories(base);
        }
        Path corrupt = Paths.get(CORRUPT);
        if (!Files.exists(corrupt)) {
            Files.write(corrupt, "this is not a valid ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));
        }
    }

    // -------------------------------------------------------------------------
    // Infrastructure helpers
    // -------------------------------------------------------------------------

    private static void assumeAssetExists(String file) {
        assumeTrue("Required test asset is missing: " + file, new File(file).exists());
    }

    private static void assumeCoreAssets() {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_PLUS_1);
    }

    private static String[] args(String... args) {
        return args;
    }

    private RunResult runSnapshotComparer(String[] args) throws Exception {
        return runSnapshotComparer(args, null, true);
    }

    private RunResult runSnapshotComparer(String[] args, String stdin) throws Exception {
        return runSnapshotComparer(args, stdin, true);
    }

    private RunResult runSnapshotComparer(String[] args, String stdin, boolean trapSystemExit) throws Exception {
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;
        originalSecurityManager = System.getSecurityManager();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(out, true, "UTF-8"));
            System.setErr(new PrintStream(err, true, "UTF-8"));
            if (stdin != null) {
                System.setIn(new ByteArrayInputStream(stdin.getBytes(StandardCharsets.UTF_8)));
            }
            if (trapSystemExit) {
                System.setSecurityManager(new NoExitSecurityManager(originalSecurityManager));
            }

            try {
                SnapshotComparer.main(args);
                return new RunResult(out.toString("UTF-8"), err.toString("UTF-8"), null, null);
            } catch (ExitException exit) {
                return new RunResult(out.toString("UTF-8"), err.toString("UTF-8"), exit, exit.status);
            }
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
            if (trapSystemExit) {
                System.setSecurityManager(originalSecurityManager);
            }
        }
    }

    private void assertOutputContainsAny(RunResult result, String... needles) {
        String combined = (result.stdout + "\n" + result.stderr).toLowerCase();
        for (String needle : needles) {
            if (combined.contains(needle.toLowerCase())) {
                return;
            }
        }
        fail("Expected output to contain one of " + java.util.Arrays.toString(needles)
                + " but output was:\nSTDOUT:\n" + result.stdout + "\nSTDERR:\n" + result.stderr);
    }

    private void assertOutputDoesNotContainAny(RunResult result, String... needles) {
        String combined = (result.stdout + "\n" + result.stderr).toLowerCase();
        for (String needle : needles) {
            assertFalse("Output must not contain: " + needle + "\nActual output:\n" + combined,
                    combined.contains(needle.toLowerCase()));
        }
    }

    private void assertExitedOrFailed(RunResult result) {
        if (result.exitStatus != null) {
            assertTrue("Exit status should be non-zero", result.exitStatus.intValue() != 0);
            return;
        }
        assertOutputContainsAny(result, "usage", "error", "missing", "required", "parse", "exception");
    }

    // -------------------------------------------------------------------------
    // Group 1 - CLI configuration
    // -------------------------------------------------------------------------

    @Test
    public void testT0_BaseChoice_HappyPath() throws Exception {
        assumeCoreAssets();

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

        assertNull("Baseline configuration must not call System.exit", result.exitStatus);
        assertOutputContainsAny(result, "Analysis", "Delta", "right tree", "left tree", "Deserialized");
    }

    @Test
    public void testConfig_MissingNodeThreshold_PrintsUsageOrFailsGracefully() throws Exception {
        assumeCoreAssets();

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0"));

        assertExitedOrFailed(result);
    }

    @Test
    public void testConfig_DuplicateLeftFlag_DeterministicParserBehavior() throws Exception {
        assumeCoreAssets();
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-l", RIGHT_IDENTICAL, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

        // The exact policy is parser-dependent. The test documents that the behavior is deterministic and non-crashing.
        assertOutputContainsAny(result, "Analysis", "Delta", "usage", "error", "Deserialized");
    }

    // -------------------------------------------------------------------------
    // Group 2 - Snapshot loading robustness
    // -------------------------------------------------------------------------

    @Test
    public void testFileLeft_CorruptedSnapshot_FailsDeserialization() throws Exception {
        assumeAssetExists(RIGHT_PLUS_1);
        assumeAssetExists(CORRUPT);

        try {
            RunResult result = runSnapshotComparer(
                    args("-l", CORRUPT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0"));

            assertOutputContainsAny(result, "error", "exception", "invalid",
                    "corrupt", "magic", "snapshot", "checksum", "deserialize");
        } catch (Exception expected) {
            assertExpectedFileOrSnapshotException("corrupted snapshot", expected);
        }
    }

    @Test
    public void testFileRight_MissingSnapshot_FailsLoading() throws Exception {
        assumeAssetExists(LEFT);

        assertFalse("Ghost file must not exist for this test", new File(GHOST_RIGHT).exists());

        try {
            RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0"));

            assertOutputContainsAny(result, "no such", "not found", "filenotfound", "error", "exception");
        } catch (Exception expected) {
            assertExpectedFileOrSnapshotException("missing snapshot", expected);
        }
    }

    @Test
    public void testFormats_GzSnapshot_IsSupported() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_GZ);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_GZ,
                "-b", "0",
                "-n", "0"
        ));

        assertNull("Supported gz format should not trigger System.exit", result.exitStatus);
        assertOutputContainsAny(result, "Successfully parsed options", "Deserialized snapshot", "All layers compared");
    }

    // -------------------------------------------------------------------------
    // Group 3 - Semantic relation between snapshots
    // -------------------------------------------------------------------------

    @Test
    public void testRelation_SamePhysicalFile_ProducesNoDelta() throws Exception {
        assumeAssetExists(LEFT);

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", LEFT, "-b", "0", "-n", "0"));

        assertNull("Comparison of the same physical file must not call System.exit", result.exitStatus);

        assertOutputDoesNotContainAny(result, "found only in right tree", "found only in left tree", "Delta:");

        assertOutputContainsAny(result, "All layers compared");
    }

    @Test
    public void testRelation_DifferentFilesSameTree_ProducesNoDelta() throws Exception {
        assumeAssetExists(LEFT);
        assumeAssetExists(RIGHT_IDENTICAL);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(
                result,
                "found only in right tree",
                "found only in left tree",
                "Delta:"
        );
        assertOutputContainsAny(result, "All layers compared");
    }

    @Test
    public void testRelation_CommonPathByteDelta_IsReported() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(
                result,
                "Node /payload found in both trees. Delta: " + D_BYTES + " bytes"
        );
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

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Node /nodo_extra found only in right tree");
        assertOutputContainsAny(result, "Node /payload found only in right tree");
    }

    @Test
    public void testRelation_PathOnlyInLeft_IsReported() throws Exception {
        assumeCoreAssets();

        RunResult result = runSnapshotComparer(args("-l", RIGHT_PLUS_1, "-r", LEFT, "-b", "0", "-n", "0"));

        assertNull("Inverse comparison must not call System.exit", result.exitStatus);

        assertOutputContainsAny(result, "Node /nodo_extra found only in left tree");

        assertOutputContainsAny(result, "Node /payload found only in left tree");
    }

    @Test
    public void testRelation_MixedDifferences_AreReported() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", "0"
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Node /new found only in right tree");
        assertOutputContainsAny(result, "Node /old found only in left tree");
        assertOutputContainsAny(result, "Node /payload found in both trees. Delta: " + D_BYTES + " bytes");
        assertOutputContainsAny(result, "Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants");
    }

    // -------------------------------------------------------------------------
    // Group 4 - Threshold BVA
    // -------------------------------------------------------------------------

    @Test
    public void testByteThreshold_EqualToDelta_FiltersPayloadDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES),
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(
                result,
                "Node /payload found in both trees. Delta: " + D_BYTES + " bytes"
        );
    }

    // NUOVO
    @Test
    public void testByteThreshold_AboveDelta_FiltersPayloadDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES + 1),
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(
                result,
                "Node /payload found in both trees. Delta: " + D_BYTES + " bytes"
        );
    }

    // NUOVO
    @Test
    public void testByteThreshold_BelowDelta_ReportsPayloadDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES - 1),
                "-n", VERY_HIGH_THRESHOLD
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(
                result,
                "Node /payload found in both trees. Delta: " + D_BYTES + " bytes"
        );
    }

    /* RIMOSSO dato che usa LEFT_PAYLOAD e RIGHT_PAYLOAD_CHANGED che non producono alcuna differenza
    @Test
    public void testByteThreshold_AboveDelta_FiltersQuantitativeDelta() throws Exception {
        assumeAssetExists(LEFT_PAYLOAD);
        assumeAssetExists(RIGHT_PAYLOAD_CHANGED);

        RunResult result = runSnapshotComparer(args("-l", LEFT_PAYLOAD, "-r", RIGHT_PAYLOAD_CHANGED, "-b", String.valueOf(D_BYTES + 1), "-n", "0"));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(result, "Delta: " + D_BYTES);
    } */

    /* RIMOSSO dato che usa ancora LEFT_NODES e RIGHT_NODES_CHANGED ma dagli output /parent risulta
    “found only in right tree”, quindi è una differenza strutturale, non una differenza quantitativa su nodo comune.
    @Test
    public void testNodeThreshold_EqualToDelta_BoundaryBehavior() throws Exception {
        assumeAssetExists(LEFT_NODES);
        assumeAssetExists(RIGHT_NODES_CHANGED);

        RunResult result = runSnapshotComparer(args("-l", LEFT_NODES, "-r", RIGHT_NODES_CHANGED, "-b", "0", "-n", String.valueOf(D_NODES)));

        assertNull(result.exitStatus);
        assertOutputContainsAny(result, "Analysis", "Delta", "descendant", "both trees", "All layers compared");
    }
    */

    // NUOVO
    @Test
    public void testNodeThreshold_EqualToDelta_FiltersParentDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES)
        ));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(
                result,
                "Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants"
        );
    }

    // NUOVO
    @Test
    public void testNodeThreshold_AboveDelta_FiltersParentDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES + 1)
        ));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(
                result,
                "Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants"
        );
    }

    /* RIMOSSO dato che usa ancora LEFT_NODES e RIGHT_NODES_CHANGED ma dagli output /parent risulta
    “found only in right tree”, quindi è una differenza strutturale, non una differenza quantitativa su nodo comune.
    @Test
    public void testNodeThreshold_AboveDelta_FiltersQuantitativeDelta() throws Exception {
        assumeAssetExists(LEFT_NODES);
        assumeAssetExists(RIGHT_NODES_CHANGED);

        RunResult result = runSnapshotComparer(args("-l", LEFT_NODES, "-r", RIGHT_NODES_CHANGED, "-b", "0", "-n", String.valueOf(D_NODES + 1)));

        assertNull(result.exitStatus);
        assertOutputDoesNotContainAny(result, "descendant count: " + D_NODES, "descendants: " + D_NODES);
    } */

    // NUOVO
    @Test
    public void testNodeThreshold_BelowDelta_ReportsParentDelta() throws Exception {
        assumeAssetExists(LEFT_MIXED);
        assumeAssetExists(RIGHT_MIXED);

        RunResult result = runSnapshotComparer(args(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES - 1)
        ));

        assertNull(result.exitStatus);
        assertOutputContainsAny(
                result,
                "Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants"
        );
    }

    @Test
    public void testThreshold_IntegerOverflow_FailsParsing() throws Exception {
        assumeCoreAssets();

        try {
            RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "2147483648", "-n", "0"));
            assertExitedOrFailed(result);
        } catch (NumberFormatException expected) {
            // Expected boundary failure: Integer.MAX_VALUE + 1.
        }
    }

    // -------------------------------------------------------------------------
    // Group 5 - Interactive mode
    // -------------------------------------------------------------------------


    @Ignore
    @Test
    public void testInteractive_InvalidAbsolutePath_PrintsErrorOld() throws Exception {
        assumeCoreAssets();

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i"), "/nodo_inesistente\n");

        // Some versions keep reading after the first command and can throw EOF-related exceptions.
        assertOutputContainsAny(result, "not", "found", "left tree", "right tree", "non-exist", "nodo_inesistente");
    }

    @Test
    public void testInteractive_InvalidAbsolutePath_PrintsError() throws Exception {
        assumeCoreAssets();

        String stdin = interactiveInput("/nodo_inesistente", INTERACTIVE_COMPLETION_NEWLINES);

        RunResult result = runSnapshotComparer(args("-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i"), stdin);

        assertNull("Interactive execution must complete without System.exit", result.exitStatus);

        assertOutputContainsAny(result, "Path /nodo_inesistente is neither found in left tree nor right tree",
                "Analysis for node /nodo_inesistente");

        assertOutputContainsAny(result, "All layers compared");
    }

    // -------------------------------------------------------------------------
    // Internal classes
    // -------------------------------------------------------------------------

    private static final class RunResult {
        final String stdout;
        final String stderr;
        final Throwable throwable;
        final Integer exitStatus;

        RunResult(String stdout, String stderr, Throwable throwable, Integer exitStatus) {
            this.stdout = stdout;
            this.stderr = stderr;
            this.throwable = throwable;
            this.exitStatus = exitStatus;
        }
    }

    private static final class ExitException extends SecurityException {
        final int status;

        ExitException(int status) {
            super("System.exit(" + status + ") trapped during test");
            this.status = status;
        }
    }

    private static final class NoExitSecurityManager extends SecurityManager {
        private final SecurityManager delegate;

        NoExitSecurityManager(SecurityManager delegate) {
            this.delegate = delegate;
        }

        @Override
        public void checkPermission(Permission perm) {
            if (delegate != null) {
                delegate.checkPermission(perm);
            }
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            if (delegate != null) {
                delegate.checkPermission(perm, context);
            }
        }

        @Override
        public void checkExit(int status) {
            throw new ExitException(status);
        }
    }

    // Helper
    private static String interactiveInput(String command, int trailingNewlines) {
        StringBuilder input = new StringBuilder();

        input.append(command).append('\n');

        for (int i = 0; i < trailingNewlines; i++) {
            input.append('\n');
        }

        return input.toString();
    }

    private static void assertExpectedFileOrSnapshotException(String scenario, Exception exception) {
        if (exception instanceof IOException) {
            return;
        }

        String message = exception.getMessage();
        String normalizedMessage = message == null ? "" : message.toLowerCase();

        assertTrue("Unexpected exception for " + scenario + ": " + exception,
                normalizedMessage.contains("snapshot")
                        || normalizedMessage.contains("file")
                        || normalizedMessage.contains("corrupt")
                        || normalizedMessage.contains("magic")
                        || normalizedMessage.contains("checksum")
                        || normalizedMessage.contains("deserialize")
        );
    }
}

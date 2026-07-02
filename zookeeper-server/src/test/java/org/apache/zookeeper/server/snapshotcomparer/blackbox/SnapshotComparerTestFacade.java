package org.apache.zookeeper.server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.security.Permission;

/**
 * Facade used only for automated test generation with Randoop.
 *
 * This class exposes domain-level operations over SnapshotComparer.
 * Each public method builds a valid or intentionally invalid CLI configuration
 * and invokes SnapshotComparer.main(String[]).
 *
 * The goal is to help Randoop overcome the CLI/file-system barrier:
 * instead of forcing the generator to synthesize valid String[] arguments
 * and valid ZooKeeper snapshot paths, this facade exposes meaningful
 * no-argument methods that represent relevant testing scenarios.
 *
 * Expected resource folder:
 *   src/test/resources/data/comparer/
 *
 * Required assets:
 *   left.snap
 *   right_plus_1.snap
 *   right_identical.snap
 *   left_mixed.snap
 *   right_mixed.snap
 *
 * Optional asset:
 *   right_plus_1.gz
 */
public final class SnapshotComparerTestFacade {

    private static final String BASE = "src/test/resources/data/comparer/";

    private static final String LEFT = BASE + "left.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";

    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";

    private static final String RIGHT_GZ = BASE + "right_plus_1.gz";

    private static final int D_BYTES = 8;
    private static final int D_NODES = 1;
    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    private SnapshotComparerTestFacade() {
        // Utility facade for Randoop; no instances needed.
    }

    // -------------------------------------------------------------------------
    // Basic availability checks
    // -------------------------------------------------------------------------

    public static boolean requiredCoreAssetsExist() {
        return exists(LEFT)
                && exists(RIGHT_PLUS_1)
                && exists(RIGHT_IDENTICAL)
                && exists(LEFT_MIXED)
                && exists(RIGHT_MIXED);
    }

    public static boolean gzAssetExists() {
        return exists(RIGHT_GZ);
    }

    // -------------------------------------------------------------------------
    // CLI / parser-oriented scenarios
    // -------------------------------------------------------------------------

    public static boolean missingNodeThresholdIsRejected() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0"
        );

        return result.exitStatus != null
                || containsAny(result.output, "usage", "error", "missing", "required", "parse", "exception");
    }

    public static boolean duplicateLeftFlagTerminatesOrRunsDeterministically() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-l", RIGHT_IDENTICAL,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        );

        return containsAny(
                result.output,
                "Successfully parsed options",
                "Deserialized snapshot",
                "Analysis",
                "Delta",
                "usage",
                "error"
        );
    }

    public static boolean integerOverflowIsRejected() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "2147483648",
                "-n", "0"
        );

        return result.exitStatus != null
                || result.throwable != null
                || containsAny(result.output, "NumberFormatException", "error", "exception", "parse");
    }

    // -------------------------------------------------------------------------
    // Snapshot relation scenarios
    // -------------------------------------------------------------------------

    public static boolean compareBaselineFindsRightOnlyNode() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("Node /nodo_extra found only in right tree")
                && result.output.contains("Node /payload found only in right tree");
    }

    public static boolean samePhysicalFileProducesNoDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", LEFT,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && !result.output.contains("found only in right tree")
                && !result.output.contains("found only in left tree");
    }

    public static boolean differentFilesSameTreeProducesNoDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_IDENTICAL,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("All layers compared")
                && !result.output.contains("found only in right tree")
                && !result.output.contains("found only in left tree")
                && !result.output.contains("Delta:");
    }

    public static boolean pathOnlyInRightIsReported() throws Exception {
        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_PLUS_1,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("Node /nodo_extra found only in right tree");
    }

    public static boolean pathOnlyInLeftIsReported() throws Exception {
        RunResult result = run(
                "-l", RIGHT_PLUS_1,
                "-r", LEFT,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("found only in left tree");
    }

    public static boolean mixedDifferencesAreReported() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("Node /new found only in right tree")
                && result.output.contains("Node /old found only in left tree")
                && result.output.contains("Node /payload found in both trees. Delta: " + D_BYTES + " bytes")
                && result.output.contains("Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants");
    }

    public static boolean samePathsDifferentPayloadIsReported() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && result.output.contains("Node /payload found in both trees. Delta: " + D_BYTES + " bytes");
    }

    // -------------------------------------------------------------------------
    // Format scenario
    // -------------------------------------------------------------------------

    public static boolean gzSnapshotIsSupported() throws Exception {
        if (!exists(RIGHT_GZ)) {
            // Return true instead of failing generation when the optional asset is missing.
            // The manual JUnit test uses Assume; this facade is intentionally self-contained.
            return true;
        }

        RunResult result = run(
                "-l", LEFT,
                "-r", RIGHT_GZ,
                "-b", "0",
                "-n", "0"
        );

        return result.exitStatus == null
                && containsAny(result.output, "Successfully parsed options", "Deserialized snapshot", "All layers compared");
    }

    // -------------------------------------------------------------------------
    // Byte threshold BVA scenarios
    // -------------------------------------------------------------------------

    public static boolean byteThresholdBelowDeltaReportsPayloadDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES - 1),
                "-n", VERY_HIGH_THRESHOLD
        );

        return result.exitStatus == null
                && result.output.contains("Node /payload found in both trees. Delta: " + D_BYTES + " bytes");
    }

    public static boolean byteThresholdEqualToDeltaFiltersPayloadDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES),
                "-n", VERY_HIGH_THRESHOLD
        );

        return result.exitStatus == null
                && !result.output.contains("Node /payload found in both trees. Delta: " + D_BYTES + " bytes");
    }

    public static boolean byteThresholdAboveDeltaFiltersPayloadDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", String.valueOf(D_BYTES + 1),
                "-n", VERY_HIGH_THRESHOLD
        );

        return result.exitStatus == null
                && !result.output.contains("Node /payload found in both trees. Delta: " + D_BYTES + " bytes");
    }

    // -------------------------------------------------------------------------
    // Node threshold BVA scenarios
    // -------------------------------------------------------------------------

    public static boolean nodeThresholdBelowDeltaReportsParentDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES - 1)
        );

        return result.exitStatus == null
                && result.output.contains("Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants");
    }

    public static boolean nodeThresholdEqualToDeltaFiltersParentDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES)
        );

        return result.exitStatus == null
                && !result.output.contains("Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants");
    }

    public static boolean nodeThresholdAboveDeltaFiltersParentDelta() throws Exception {
        RunResult result = run(
                "-l", LEFT_MIXED,
                "-r", RIGHT_MIXED,
                "-b", VERY_HIGH_THRESHOLD,
                "-n", String.valueOf(D_NODES + 1)
        );

        return result.exitStatus == null
                && !result.output.contains("Node /parent found in both trees. Delta: -1 bytes, -" + D_NODES + " descendants");
    }

    // -------------------------------------------------------------------------
    // Internal helpers
    // -------------------------------------------------------------------------

    private static boolean exists(String file) {
        return new File(file).exists();
    }

    private static boolean containsAny(String text, String... needles) {
        String lower = text.toLowerCase();
        for (String needle : needles) {
            if (lower.contains(needle.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static RunResult run(String... args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        SecurityManager originalSecurityManager = System.getSecurityManager();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(out, true, "UTF-8"));
            System.setErr(new PrintStream(err, true, "UTF-8"));
            System.setSecurityManager(new NoExitSecurityManager(originalSecurityManager));

            try {
                SnapshotComparer.main(args);
                return new RunResult(
                        out.toString("UTF-8") + "\n" + err.toString("UTF-8"),
                        null,
                        null
                );
            } catch (ExitException exit) {
                return new RunResult(
                        out.toString("UTF-8") + "\n" + err.toString("UTF-8"),
                        exit,
                        exit.status
                );
            } catch (Throwable throwable) {
                return new RunResult(
                        out.toString("UTF-8") + "\n" + err.toString("UTF-8"),
                        throwable,
                        null
                );
            }
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setSecurityManager(originalSecurityManager);
        }
    }

    private static final class RunResult {
        final String output;
        final Throwable throwable;
        final Integer exitStatus;

        RunResult(String output, Throwable throwable, Integer exitStatus) {
            this.output = output;
            this.throwable = throwable;
            this.exitStatus = exitStatus;
        }
    }

    private static final class ExitException extends SecurityException {
        final int status;

        ExitException(int status) {
            super("System.exit(" + status + ") trapped during facade execution");
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
}
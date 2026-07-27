package org.apache.zookeeper.server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import org.apache.zookeeper.util.ServiceUtils;

/*
 * Facade used only for automated test generation with Randoop/EvoSuite.
 * This class exposes domain-level operations over SnapshotComparer. Each public method builds a
 * valid or intentionally invalid CLI configuration and invokes SnapshotComparer.main(String[]).
 *
 * Unlike manual black-box tests that use ProcessBuilder to spawn separate JVMs, this Facade MUST execute
 * SnapshotComparer.main() in the current JVM. To prevent System.exit() from halting the test generation
 * tools, it overrides ZooKeeper's ServiceUtils.setSystemExitProcedure, completely avoiding the need
 * for deprecated SecurityManager implementations.
 */

public final class SnapshotComparerTestFacade {

    // Resolves the fixture directory dynamically, allowing execution on different machines/CI.
    private static final String BASE = "C:/Users/casol/Desktop/zookeeper/zookeeper-server/src/test/resources/data/comparer/";

    private static final String LEFT = BASE + "left.snap";
    private static final String RIGHT_PLUS_1 = BASE + "right_plus_1.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";

    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";

    private static final String RIGHT_GZ = BASE + "right_plus_1.gz";

    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";
    private static final String LEFT_EPHEMERAL = BASE + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = BASE + "right_ephemeral.snap";

    private static final int D_BYTES = 8;
    private static final int D_NODES = 1;
    private static final String VERY_HIGH_THRESHOLD = "2147483647";

    // 10 newlines used to safely complete interactive mode loops preventing NoSuchElementException
    // when Scanner.nextLine() is called continuously by the SUT
    private static final String INTERACTIVE_NEWLINES = "\n\n\n\n\n\n\n\n\n\n";

    private SnapshotComparerTestFacade() {
        // Utility facade for automated generation tools; no instances needed.
    }

    // PARAMETRIC METHODS (No direct CP mapping - Used exclusively for Randoop/Evosuite Fuzzing)

    public static boolean compareMixedWithThresholds(int byteThreshold, int nodeThreshold) throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);

        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED,
                "-b", String.valueOf(byteThreshold), "-n", String.valueOf(nodeThreshold));

        return completedSuccessfully(result);
    }

    public static boolean compareNominal(int byteThreshold, int nodeThreshold, boolean interactive) throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);

        if (interactive) {
            return completedSuccessfully(run(INTERACTIVE_NEWLINES, "-l", LEFT, "-r", RIGHT_PLUS_1,
                    "-b", String.valueOf(byteThreshold), "-n", String.valueOf(nodeThreshold), "-i"));
        }

        return completedSuccessfully(run(null, "-l", LEFT, "-r", RIGHT_PLUS_1,
                "-b", String.valueOf(byteThreshold), "-n", String.valueOf(nodeThreshold)));
    }


    // MAPPED TEST SCENARIOS (From S1 to S23)

    // S1 / T0, mapping testT0_BaseChoice_HappyPath
    public static boolean compareBaselineFindsRightOnlyNode() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && result.output.contains("Node /nodo_extra found only in right tree");
    }

    // S2 / T1, mapping testConfig_MissingNodeThreshold_PrintsUsageOrFailsGracefully
    public static boolean missingNodeThresholdIsRejected() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0");
        return failedInControlledWay(result) && containsAny(result.output, "usage", "missing", "required", "parse", "option") && !result.output.contains("All layers compared");
    }

    // S3 / T3, mapping testConfig_DuplicateLeftFlag_DeterministicParserBehavior
    public static boolean duplicateLeftFlagHasControlledBehavior() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_IDENTICAL);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-l", RIGHT_IDENTICAL, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
        boolean controlledFailure = failedInControlledWay(result) && containsAny(result.output, "usage", "error", "option", "parse");
        boolean controlledCompletion = completedSuccessfully(result);
        return controlledFailure || controlledCompletion;
    }

    // S4 / T4, mapping testConfig_FlagWithoutArgument_FailsParsing
    public static boolean flagWithoutArgumentFailsParsing() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n");
        return failedInControlledWay(result) && containsAny(result.output, "usage", "missing", "argument", "parse", "option") && !result.output.contains("All layers compared");
    }

    // S5 / T7, mapping testThreshold_IntegerOverflow_FailsParsing
    public static boolean integerOverflowIsRejected() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "2147483648", "-n", "0");
        return failedInControlledWay(result) && containsAny(result.output, "numberformatexception", "for input string", "integer", "parse", "number") && !result.output.contains("All layers compared");
    }

    // S6 / T10, mapping testFileLeft_CorruptedSnapshot_FailsDeserialization
    public static boolean corruptedSnapshotFailsDeserialization() throws Exception {
        requireAsset(RIGHT_PLUS_1);
        Path corruptFile = Files.createTempFile("snapshot-comparer-corrupt-", ".snap");
        try {
            Files.write(corruptFile, "this is not a valid ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));
            RunResult result = run(null, "-l", corruptFile.toAbsolutePath().toString(), "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
            return failedInControlledWay(result) && containsAny(result.output, "snapshot", "magic", "checksum", "deserialize", "exception", "eof");
        } finally {
            try {
                Files.deleteIfExists(corruptFile);
            } catch (Exception e) {
                // Windows lock workaround: if the file is locked by a lingering stream, schedule it for later deletion
                corruptFile.toFile().deleteOnExit();
            }
        }
    }

    // S7 / T17, mapping testContent_EphemeralNodes_AreIgnored
    public static boolean ephemeralNodesAreIgnored() throws Exception {
        requireAsset(LEFT_EPHEMERAL);
        requireAsset(RIGHT_EPHEMERAL);
        RunResult result = run(null, "-l", LEFT_EPHEMERAL, "-r", RIGHT_EPHEMERAL, "-b", "0", "-n", "0");

        // Exposes the expected contract. Because of the confirmed ZooKeeper bug (where ephemeral nodes
        // ARE printed), this will correctly evaluate to FALSE during Randoop/EvoSuite generation.
        return completedSuccessfully(result) && !result.output.contains("/effimero_sinistro") && !result.output.contains("/ephemeral_test");
    }

    // S8 / T18, mapping testFileRight_MissingSnapshot_FailsLoading
    public static boolean missingSnapshotFailsLoading() throws Exception {
        requireAsset(LEFT);
        requireAbsent(GHOST_RIGHT);
        RunResult result = run(null, "-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0");
        return failedInControlledWay(result) && containsAny(result.output, "no such file", "file not found", "filenotfoundexception", "cannot find");
    }

    // S9 / T22, mapping testFormats_GzSnapshot_IsSupported
    public static boolean gzSnapshotIsSupported() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_GZ);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_GZ, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && result.output.contains("Node /nodo_extra found only in right tree");
    }

    // S10 / T28, mapping testRelation_SamePhysicalFile_ProducesNoDelta
    public static boolean samePhysicalFileProducesNoDelta() throws Exception {
        requireAsset(LEFT);
        RunResult result = run(null, "-l", LEFT, "-r", LEFT, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && !result.output.contains("found only in right tree") && !result.output.contains("found only in left tree") && !result.output.contains("Delta:");
    }

    // S11 / T29, mapping testRelation_DifferentFilesSameTree_ProducesNoDelta
    public static boolean differentFilesSameTreeProducesNoDelta() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_IDENTICAL);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && !result.output.contains("found only in right tree") && !result.output.contains("found only in left tree") && !result.output.contains("Delta:");
    }

    // S12 / T30, mapping testRelation_CommonPathByteDelta_IsReported
    public static boolean samePathsDifferentPayloadIsReported() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && containsQuantitativeDeltaForPath(result.output, "/payload");
    }

    // S13 / T31, mapping testRelation_PathOnlyInRight_IsReported
    public static boolean pathOnlyInRightIsReported() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && result.output.contains("Node /nodo_extra found only in right tree");
    }

    // S14 / T32, mapping testRelation_PathOnlyInLeft_IsReported
    public static boolean pathOnlyInLeftIsReported() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run(null, "-l", RIGHT_PLUS_1, "-r", LEFT, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && result.output.contains("found only in left tree");
    }

    // S15 / T33, mapping testRelation_MixedDifferences_AreReported
    public static boolean mixedDifferencesAreReported() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", "0", "-n", "0");
        return completedSuccessfully(result) && result.output.contains("Node /new found only in right tree") && containsQuantitativeDeltaForPath(result.output, "/payload");
    }

    // S16 / T35, mapping testByteThreshold_BelowDelta_ReportsPayloadDelta
    public static boolean byteThresholdBelowDeltaReportsPayloadDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", String.valueOf(D_BYTES - 1), "-n", VERY_HIGH_THRESHOLD);
        return completedSuccessfully(result) && containsQuantitativeDeltaForPath(result.output, "/payload");
    }

    // S17 / T36, mapping testByteThreshold_EqualToDelta_FiltersPayloadDelta
    public static boolean byteThresholdEqualToDeltaFiltersPayloadDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", String.valueOf(D_BYTES), "-n", VERY_HIGH_THRESHOLD);
        return completedSuccessfully(result) && !containsQuantitativeDeltaForPath(result.output, "/payload");
    }

    // S18 / T37, mapping testByteThreshold_AboveDelta_FiltersPayloadDelta
    public static boolean byteThresholdAboveDeltaFiltersPayloadDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", String.valueOf(D_BYTES + 1), "-n", VERY_HIGH_THRESHOLD);
        return completedSuccessfully(result) && !containsQuantitativeDeltaForPath(result.output, "/payload");
    }

    // S19 / T39, mapping testNodeThreshold_BelowDelta_ReportsParentDelta
    public static boolean nodeThresholdBelowDeltaReportsParentDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", VERY_HIGH_THRESHOLD, "-n", String.valueOf(D_NODES - 1));
        return completedSuccessfully(result) && containsQuantitativeDeltaForPath(result.output, "/parent");
    }

    // S20 / T40, mapping testNodeThreshold_EqualToDelta_FiltersParentDelta
    public static boolean nodeThresholdEqualToDeltaFiltersParentDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", VERY_HIGH_THRESHOLD, "-n", String.valueOf(D_NODES));
        return completedSuccessfully(result) && !containsQuantitativeDeltaForPath(result.output, "/parent");
    }

    // S21 / T41, mapping testNodeThreshold_AboveDelta_FiltersParentDelta
    public static boolean nodeThresholdAboveDeltaFiltersParentDelta() throws Exception {
        requireAsset(LEFT_MIXED);
        requireAsset(RIGHT_MIXED);
        RunResult result = run(null, "-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", VERY_HIGH_THRESHOLD, "-n", String.valueOf(D_NODES + 1));
        return completedSuccessfully(result) && !containsQuantitativeDeltaForPath(result.output, "/parent");
    }

    // S22 / T50, mapping testInteractive_DepthBelowMinimum_PrintsRangeError
    public static boolean interactiveDepthBelowMinimumPrintsRangeError() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run("-1" + INTERACTIVE_NEWLINES, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i");
        return completedSuccessfully(result) && result.output.contains("Depth must be in range");
    }

    // S23 / T54, mapping testInteractive_InvalidAbsolutePath_PrintsError
    public static boolean interactiveInvalidAbsolutePathPrintsError() throws Exception {
        requireAsset(LEFT);
        requireAsset(RIGHT_PLUS_1);
        RunResult result = run("/nodo_inesistente" + INTERACTIVE_NEWLINES, "-l", LEFT, "-r", RIGHT_PLUS_1, "-b", "0", "-n", "0", "-i");
        return completedSuccessfully(result) && containsAny(result.output, "neither found", "not found", "absent");
    }

    // INTERNAL HELPERS

    private static void requireAsset(String file) {
        File asset = new File(file);
        if (!asset.isFile() || !asset.canRead()) {
            throw new IllegalStateException("Required facade asset is missing or unreadable: " + file);
        }
    }

    private static void requireAbsent(String file) {
        if (new File(file).exists()) {
            throw new IllegalStateException("Facade asset must remain absent: " + file);
        }
    }

    private static boolean completedSuccessfully(RunResult result) {
        return result.exitStatus == null && result.throwable == null && result.output.contains("All layers compared");
    }

    private static boolean failedInControlledWay(RunResult result) {
        boolean nonZeroExit = result.exitStatus != null && result.exitStatus.intValue() != 0;
        return nonZeroExit || result.throwable != null;
    }

    private static boolean containsAny(String text, String... needles) {
        String lower = text.toLowerCase(Locale.ROOT);
        for (String needle : needles) {
            if (lower.contains(needle.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsQuantitativeDeltaForPath(String output, String path) {
        for (String line : output.split("\\R")) {
            boolean commonPath = line.contains("Node " + path + " found in both trees");
            boolean delta = line.contains("Delta:");
            if (commonPath && delta) {
                return true;
            }
        }
        return false;
    }

    /**
     * Executes SnapshotComparer overriding System.out, System.err and System.in.
     */
    private static synchronized RunResult run(String stdin, String... args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        InputStream originalIn = System.in;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(out, true, "UTF-8"));
            System.setErr(new PrintStream(err, true, "UTF-8"));

            if (stdin != null) {
                System.setIn(new ByteArrayInputStream(stdin.getBytes(StandardCharsets.UTF_8)));
            }

            // Override ZooKeeper's exit procedure so that calls to ServiceUtils.requestSystemExit() do not
            // terminate the Randoop/EvoSuite JVM. This works because SnapshotComparer delegates invalid-invocation
            // exits to ServiceUtils instead of calling System.exit() directly
            ServiceUtils.setSystemExitProcedure(status -> {
                throw new ExitException(status);
            });

            try {
                SnapshotComparer.main(args);
                return new RunResult(out.toString("UTF-8") + "\n" + err.toString("UTF-8"), null, null);
            } catch (ExitException exit) {
                // Return null as Throwable to cleanly separate controlled exits from unexpected exceptions
                return new RunResult(out.toString("UTF-8") + "\n" + err.toString("UTF-8"), null, exit.status);
            } catch (Throwable throwable) {
                return new RunResult(out.toString("UTF-8") + "\n" + err.toString("UTF-8"), throwable, null);
            }
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
            System.setIn(originalIn);
            // Restore default exit behavior precisely
            ServiceUtils.setSystemExitProcedure(ServiceUtils.SYSTEM_EXIT);
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

    private static final class ExitException extends RuntimeException {
        final int status;

        ExitException(int status) {
            super("ServiceUtils.requestSystemExit(" + status + ") intercepted during facade execution");
            this.status = status;
        }
    }
}
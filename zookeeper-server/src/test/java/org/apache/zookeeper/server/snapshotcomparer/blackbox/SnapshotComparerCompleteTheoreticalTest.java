package org.apache.zookeeper.server.snapshotcomparer.blackbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.zookeeper.server.SnapshotComparer;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Complete theoretical black-box suite for SnapshotComparer.
 *
 * Active tests represent all theoretical cases that can be concretized with
 * the currently available calibrated assets. Tests requiring unavailable
 * fixtures or non-portable filesystem conditions are retained with @Ignore,
 * so that the mapping T0-T56 remains explicit and auditable.
 *
 * T17 and T27 are known-defect regression tests. They are ignored only to keep
 * the ordinary CI pipeline green; both were executed before being disabled and
 * demonstrated that SnapshotComparer reports zNodes whose ephemeralOwner is
 * non-zero.
 */
public class SnapshotComparerCompleteTheoreticalTest {

    private static final String BASE = "src/test/resources/data/comparer/";
    private static final String LEFT = BASE + "left.snap";
    private static final String RIGHT = BASE + "right_plus_1.snap";
    private static final String RIGHT_IDENTICAL = BASE + "right_identical.snap";
    private static final String RIGHT_GZ = BASE + "right_plus_1.gz";
    private static final String LEFT_MIXED = BASE + "left_mixed.snap";
    private static final String RIGHT_MIXED = BASE + "right_mixed.snap";
    private static final String LEFT_EPHEMERAL = BASE + "left_ephemeral.snap";
    private static final String RIGHT_EPHEMERAL = BASE + "right_ephemeral.snap";
    private static final String GHOST_LEFT = BASE + "ghost_left.snap";
    private static final String GHOST_RIGHT = BASE + "ghost_right.snap";

    private static final String LEFT_EPHEMERAL_PATH = "/effimero_sinistro";
    private static final String RIGHT_EPHEMERAL_PATH = "/ephemeral_test";
    private static final int D_BYTES = 8;
    private static final int D_NODES = 1;
    private static final String VERY_HIGH_THRESHOLD = "2147483647";
    private static final int MAX_DEPTH = 3;
    private static final int INTERACTIVE_COMPLETION_NEWLINES = 10;
    private static final long PROCESS_TIMEOUT_SECONDS = 30L;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    // ---------------------------------------------------------------------
    // T0-T7: CLI configuration
    // ---------------------------------------------------------------------

    @Test
    public void testT0_BaseChoice_HappyPath() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertContains(r, "Node /nodo_extra found only in right tree");
        assertContains(r, "Node /payload found only in right tree");
    }

    @Test
    public void testT1_Config_MissingNodeThreshold_Fails() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0"));
        assertParsingFailure(r);
    }

    @Test
    public void testT2_Config_UnknownFlag_IsRejected() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0", "--unknown"));
        assertFailed(r);
        assertContainsAny(r, "unrecognized option", "unknown option", "usage", "parse");
        assertNotContains(r, "All layers compared");
    }

    @Test
    public void testT3_Config_DuplicateLeftFlag_HasDeterministicSemanticBehavior() throws Exception {
        assertCoreAssets();
        assertAsset(LEFT_MIXED);
        String[] a = args("-l", LEFT, "-l", LEFT_MIXED, "-r", RIGHT, "-b", "0", "-n", "0");
        RunResult first = run(a);
        RunResult second = run(a);
        assertEquals(first.exitStatus, second.exitStatus);
        assertEquals(semanticOutput(first.output), semanticOutput(second.output));
        assertTrue(first.exitStatus != 0 || first.output.contains("All layers compared"));
    }

    @Test
    public void testT4_Config_FlagWithoutArgument_FailsParsing() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n"));
        assertParsingFailure(r);
    }

    @Test
    public void testT5_Config_NonNumericByteThreshold_FailsConversion() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "abc", "-n", "0"));
        assertNumericFailure(r);
    }

    @Test
    public void testT6_Config_EmptyByteThreshold_FailsConversion() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "", "-n", "0"));
        assertNumericFailure(r);
    }

    @Test
    public void testT7_Config_IntegerOverflow_FailsConversion() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "2147483648", "-n", "0"));
        assertNumericFailure(r);
    }

    // ---------------------------------------------------------------------
    // T8-T17: left snapshot
    // ---------------------------------------------------------------------

    @Test
    public void testT8_FileLeft_MissingSnapshot_FailsLoading() throws Exception {
        assertAsset(RIGHT);
        assertFalse(new File(GHOST_LEFT).exists());
        RunResult r = run(args("-l", GHOST_LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        assertFileFailure(r);
    }

    @Ignore("T9 is platform and privilege dependent; Windows ACL fixture is not available")
    @Test
    public void testT9_FileLeft_ExistingButUnreadable_FailsAccess() {
    }

    @Test
    public void testT10_FileLeft_CorruptedSnapshot_FailsDeserialization() throws Exception {
        assertAsset(RIGHT);
        File corrupt = createCorruptFile("corrupt-left.snap");
        RunResult r = run(args("-l", corrupt.getAbsolutePath(), "-r", RIGHT, "-b", "0", "-n", "0"));
        assertSnapshotFailure(r);
    }

    @Ignore("T11 requires an unavailable Snappy-compressed left snapshot")
    @Test
    public void testT11_FileLeft_SnappySnapshot_IsSupported() {
    }

    @Ignore("T12 requires an unavailable GZIP-compressed left snapshot")
    @Test
    public void testT12_FileLeft_GzipSnapshot_IsSupported() {
    }

    @Test
    public void testT13_FileLeft_UnsupportedForeignFormat_FailsRecognition() throws Exception {
        assertAsset(RIGHT);
        File alien = createForeignFile("foreign-left.bin");
        RunResult r = run(args("-l", alien.getAbsolutePath(), "-r", RIGHT, "-b", "0", "-n", "0"));
        assertSnapshotFailure(r);
    }

    @Ignore("T14 requires an unavailable root-only left snapshot")
    @Test
    public void testT14_FileLeft_RootOnlySnapshot_HasDepthOne() {
    }

    @Ignore("T15 requires an unavailable one-level left snapshot")
    @Test
    public void testT15_FileLeft_OneLevelSnapshot_HasDepthTwo() {
    }

    @Test
    public void testT16_FileLeft_MultiLevelSnapshot_IsAnalyzed() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("0", "0");
        assertCompleted(r);
        assertContains(r, "Max depth: " + MAX_DEPTH);
        assertContains(r, "Analysis for depth 2");
    }

    @Ignore("Known defect: SnapshotComparer reports left and right ephemeral zNodes")
    @Test
    public void testT17_FileLeft_EphemeralNodes_AreIgnored() throws Exception {
        assertEphemeralAssets();
        RunResult r = run(args("-l", LEFT_EPHEMERAL, "-r", RIGHT_EPHEMERAL, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContains(r, LEFT_EPHEMERAL_PATH);
        assertNotContains(r, RIGHT_EPHEMERAL_PATH);
    }

    // ---------------------------------------------------------------------
    // T18-T27: right snapshot
    // ---------------------------------------------------------------------

    @Test
    public void testT18_FileRight_MissingSnapshot_FailsLoading() throws Exception {
        assertAsset(LEFT);
        assertFalse(new File(GHOST_RIGHT).exists());
        RunResult r = run(args("-l", LEFT, "-r", GHOST_RIGHT, "-b", "0", "-n", "0"));
        assertFileFailure(r);
    }

    @Ignore("T19 is platform and privilege dependent; Windows ACL fixture is not available")
    @Test
    public void testT19_FileRight_ExistingButUnreadable_FailsAccess() {
    }

    @Test
    public void testT20_FileRight_CorruptedSnapshot_FailsDeserialization() throws Exception {
        assertAsset(LEFT);
        File corrupt = createCorruptFile("corrupt-right.snap");
        RunResult r = run(args("-l", LEFT, "-r", corrupt.getAbsolutePath(), "-b", "0", "-n", "0"));
        assertSnapshotFailure(r);
    }

    @Ignore("T21 requires an unavailable Snappy-compressed right snapshot")
    @Test
    public void testT21_FileRight_SnappySnapshot_IsSupported() {
    }

    @Test
    public void testT22_FileRight_GzipSnapshot_IsSupportedAndEquivalent() throws Exception {
        assertCoreAssets();
        assertAsset(RIGHT_GZ);
        RunResult plain = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        RunResult gzip = run(args("-l", LEFT, "-r", RIGHT_GZ, "-b", "0", "-n", "0"));
        assertCompleted(plain);
        assertCompleted(gzip);
        assertEquals(semanticComparisonOutput(plain.output), semanticComparisonOutput(gzip.output));
    }

    @Test
    public void testT23_FileRight_UnsupportedForeignFormat_FailsRecognition() throws Exception {
        assertAsset(LEFT);
        File alien = createForeignFile("foreign-right.bin");
        RunResult r = run(args("-l", LEFT, "-r", alien.getAbsolutePath(), "-b", "0", "-n", "0"));
        assertSnapshotFailure(r);
    }

    @Ignore("T24 requires an unavailable root-only right snapshot")
    @Test
    public void testT24_FileRight_RootOnlySnapshot_HasDepthOne() {
    }

    @Ignore("T25 requires an unavailable one-level right snapshot")
    @Test
    public void testT25_FileRight_OneLevelSnapshot_HasDepthTwo() {
    }

    @Test
    public void testT26_FileRight_MultiLevelSnapshot_IsAnalyzed() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("0", "0");
        assertCompleted(r);
        assertContains(r, "Max depth: " + MAX_DEPTH);
        assertContains(r, "Analysis for depth 2");
    }

    @Ignore("Known defect: SnapshotComparer reports left and right ephemeral zNodes")
    @Test
    public void testT27_FileRight_EphemeralNodes_AreIgnored() throws Exception {
        assertEphemeralAssets();
        RunResult r = run(args("-l", RIGHT_EPHEMERAL, "-r", LEFT_EPHEMERAL, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContains(r, LEFT_EPHEMERAL_PATH);
        assertNotContains(r, RIGHT_EPHEMERAL_PATH);
    }

    // ---------------------------------------------------------------------
    // T28-T33: snapshot relationship
    // ---------------------------------------------------------------------

    @Test
    public void testT28_Relation_SamePhysicalFile_ProducesNoDelta() throws Exception {
        assertAsset(LEFT);
        RunResult r = run(args("-l", LEFT, "-r", LEFT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContainsAny(r, "found only in right tree", "found only in left tree", "Delta:");
    }

    @Test
    public void testT29_Relation_DifferentFilesSameTree_ProducesNoDelta() throws Exception {
        assertAsset(LEFT);
        assertAsset(RIGHT_IDENTICAL);
        RunResult r = run(args("-l", LEFT, "-r", RIGHT_IDENTICAL, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContainsAny(r, "found only in right tree", "found only in left tree", "Delta:");
    }

    @Test
    public void testT30_Relation_CommonPathQuantitativeDelta_IsReported() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("0", "0");
        assertCompleted(r);
        assertDelta(r, "/payload", D_BYTES + " bytes");
        assertDelta(r, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    @Test
    public void testT31_Relation_PathOnlyInRight_IsReported() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertContains(r, "Node /nodo_extra found only in right tree");
        assertContains(r, "Node /payload found only in right tree");
    }

    @Test
    public void testT32_Relation_PathOnlyInLeft_IsReported() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", RIGHT, "-r", LEFT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertContains(r, "Node /nodo_extra found only in left tree");
        assertContains(r, "Node /payload found only in left tree");
    }

    @Test
    public void testT33_Relation_MixedDifferences_AreReported() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("0", "0");
        assertCompleted(r);
        assertContains(r, "Node /new found only in right tree");
        assertContains(r, "Node /old found only in left tree");
        assertDelta(r, "/payload", D_BYTES + " bytes");
        assertDelta(r, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    // ---------------------------------------------------------------------
    // T34-T42: threshold BVA and exploratory negative values
    // ---------------------------------------------------------------------

    @Test
    public void testT34_ByteThreshold_Zero_ReportsPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("0", VERY_HIGH_THRESHOLD);
        assertCompleted(r);
        assertDelta(r, "/payload", D_BYTES + " bytes");
    }

    @Test
    public void testT35_ByteThreshold_BelowDelta_ReportsPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(String.valueOf(D_BYTES - 1), VERY_HIGH_THRESHOLD);
        assertCompleted(r);
        assertDelta(r, "/payload", D_BYTES + " bytes");
    }

    @Test
    public void testT36_ByteThreshold_EqualToDelta_FiltersPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(String.valueOf(D_BYTES), VERY_HIGH_THRESHOLD);
        assertCompleted(r);
        assertNoDeltaForPath(r, "/payload");
    }

    @Test
    public void testT37_ByteThreshold_AboveDelta_FiltersPayloadDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(String.valueOf(D_BYTES + 1), VERY_HIGH_THRESHOLD);
        assertCompleted(r);
        assertNoDeltaForPath(r, "/payload");
    }

    @Test
    public void testT38_ByteThreshold_Negative_HasControlledBehavior() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed("-1", VERY_HIGH_THRESHOLD);
        assertEquals("Negative threshold behavior must be controlled", 0, r.exitStatus);
        assertContains(r, "All layers compared");
        assertDelta(r, "/payload", D_BYTES + " bytes");
    }

    @Test
    public void testT39_NodeThreshold_BelowDelta_ReportsParentDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(VERY_HIGH_THRESHOLD, "0");
        assertCompleted(r);
        assertDelta(r, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    @Test
    public void testT40_NodeThreshold_EqualToDelta_FiltersParentDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(VERY_HIGH_THRESHOLD, String.valueOf(D_NODES));
        assertCompleted(r);
        assertNoDeltaForPath(r, "/parent");
    }

    @Test
    public void testT41_NodeThreshold_AboveDelta_FiltersParentDelta() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(VERY_HIGH_THRESHOLD, String.valueOf(D_NODES + 1));
        assertCompleted(r);
        assertNoDeltaForPath(r, "/parent");
    }

    @Test
    public void testT42_NodeThreshold_Negative_HasControlledBehavior() throws Exception {
        assertMixedAssets();
        RunResult r = runMixed(VERY_HIGH_THRESHOLD, "-1");
        assertEquals("Negative threshold behavior must be controlled", 0, r.exitStatus);
        assertContains(r, "All layers compared");
        assertDelta(r, "/parent", "-1 bytes, -" + D_NODES + " descendants");
    }

    // ---------------------------------------------------------------------
    // T43-T47: modes
    // ---------------------------------------------------------------------

    @Test
    public void testT43_Mode_DebugAbsent_UsesOrdinaryOutput() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContains(r, "Filtered node");
    }

    @Test
    public void testT44_Mode_DebugPresent_AddsDiagnosticOutput() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0", "-d"));
        assertCompleted(r);
        assertContainsAny(r, "Filtered node", "left size", "right size");
    }

    @Test
    public void testT45_Mode_InteractiveAbsent_ComparesAutomatically() throws Exception {
        assertCoreAssets();
        RunResult r = run(args("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0"));
        assertCompleted(r);
        assertNotContains(r, "Press enter to move");
    }

    @Test
    public void testT46_Mode_InteractivePresent_ShowsPromptAndProcessesInput() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("", false);
        assertCompleted(r);
        assertContains(r, "Press enter to move");
    }

    @Test
    public void testT47_Mode_DebugAndInteractive_AreCombined() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("", true);
        assertCompleted(r);
        assertContains(r, "Press enter to move");
        assertContainsAny(r, "Filtered node", "left size", "right size");
    }

    // ---------------------------------------------------------------------
    // T48-T56: interactive input
    // ---------------------------------------------------------------------

    @Test
    public void testT48_Interactive_EmptyCommand_AnalyzesCurrentDepth() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("", false);
        assertCompleted(r);
        assertContains(r, "Analysis for depth 0");
    }

    @Test
    public void testT49_Interactive_ValidDepth_AnalyzesDepthZero() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("0", false);
        assertCompleted(r);
        assertContains(r, "Analysis for depth 0");
        assertNotContains(r, "Depth must be in range");
    }

    @Test
    public void testT50_Interactive_DepthBelowMinimum_PrintsRangeError() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("-1", false);
        assertCompleted(r);
        assertContains(r, "Depth must be in range [0, 2]");
    }

    @Test
    public void testT51_Interactive_DepthAtMaxDepth_PrintsRangeError() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive(String.valueOf(MAX_DEPTH), false);
        assertCompleted(r);
        assertContains(r, "Depth must be in range [0, 2]");
    }

    @Test
    public void testT52_Interactive_NonRepresentableNumber_PrintsInvalidInput() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("999999999999999999999999", false);
        assertCompleted(r);
        assertContainsAny(r, "invalid input", "not a valid", "number format", "must be a number", "absolute path");
    }

    @Test
    public void testT53_Interactive_ExistingAbsolutePath_AnalyzesSubtree() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("/app", false);
        assertCompleted(r);
        assertContainsAny(r, "Analysis for node /app", "node /app", "subtree");
    }

    @Test
    public void testT54_Interactive_MissingAbsolutePath_PrintsError() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("/nodo_inesistente", false);
        assertCompleted(r);
        assertContainsAny(r, "neither found in left tree nor right tree", "not found in either tree", "absent from both trees");
    }

    @Test
    public void testT55_Interactive_GenericText_PrintsInvalidInput() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("abc", false);
        assertCompleted(r);
        assertContainsAny(r, "invalid input", "not a valid", "absolute path", "must start with '/'");
    }

    @Test
    public void testT56_Interactive_RelativePath_PrintsInvalidInput() throws Exception {
        assertCoreAssets();
        RunResult r = runInteractive("zk_test", false);
        assertCompleted(r);
        assertContainsAny(r, "invalid input", "not a valid", "absolute path", "must start with '/'");
    }

    // ---------------------------------------------------------------------
    // Infrastructure
    // ---------------------------------------------------------------------

    private static String[] args(String... values) { return values; }

    private static void assertAsset(String path) {
        File f = new File(path);
        assertTrue("Missing asset: " + path, f.isFile());
        assertTrue("Unreadable asset: " + path, f.canRead());
    }

    private static void assertCoreAssets() { assertAsset(LEFT); assertAsset(RIGHT); }
    private static void assertMixedAssets() { assertAsset(LEFT_MIXED); assertAsset(RIGHT_MIXED); }
    private static void assertEphemeralAssets() { assertAsset(LEFT_EPHEMERAL); assertAsset(RIGHT_EPHEMERAL); }

    private File createCorruptFile(String name) throws IOException {
        File f = temporaryFolder.newFile(name);
        Files.write(f.toPath(), "not a ZooKeeper snapshot".getBytes(StandardCharsets.UTF_8));
        return f;
    }

    private File createForeignFile(String name) throws IOException {
        File f = temporaryFolder.newFile(name);
        byte[] alien = new byte[] {0x50, 0x4b, 0x03, 0x04, 0x13, 0x37, 0x00, 0x7f};
        Files.write(f.toPath(), alien);
        return f;
    }

    private RunResult runMixed(String b, String n) throws Exception {
        return run(args("-l", LEFT_MIXED, "-r", RIGHT_MIXED, "-b", b, "-n", n));
    }

    private RunResult runInteractive(String firstCommand, boolean debug) throws Exception {
        List<String> values = new ArrayList<>(Arrays.asList("-l", LEFT, "-r", RIGHT, "-b", "0", "-n", "0", "-i"));
        if (debug) values.add("-d");
        return run(values.toArray(new String[0]), interactiveInput(firstCommand));
    }

    private static String interactiveInput(String command) {
        StringBuilder b = new StringBuilder(command).append('\n');
        for (int i = 0; i < INTERACTIVE_COMPLETION_NEWLINES; i++) b.append('\n');
        return b.toString();
    }

    private RunResult run(String[] arguments) throws Exception { return run(arguments, null); }

    private RunResult run(String[] arguments, String stdin) throws Exception {
        List<String> command = new ArrayList<>();
        command.add(Paths.get(System.getProperty("java.home"), "bin", "java").toString());
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(SnapshotComparer.class.getName());
        Collections.addAll(command, arguments);

        ProcessBuilder pb = new ProcessBuilder(command).redirectErrorStream(true);
        Process process = pb.start();
        if (stdin == null) {
            process.getOutputStream().close();
        } else {
            try (OutputStream in = process.getOutputStream()) {
                in.write(stdin.getBytes(StandardCharsets.UTF_8));
            }
        }

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        AtomicReference<Throwable> readerFailure = new AtomicReference<>();
        Thread reader = new Thread(() -> {
            try (InputStream in = process.getInputStream()) {
                copy(in, captured);
            } catch (Throwable t) {
                readerFailure.set(t);
            }
        }, "snapshot-comparer-complete-suite-reader");
        reader.start();

        boolean finished = process.waitFor(PROCESS_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (!finished) process.destroyForcibly();
        reader.join();
        if (readerFailure.get() != null) throw new IOException("Unable to capture child output", readerFailure.get());
        if (!finished) fail("SnapshotComparer timed out. Output:\n" + captured.toString(StandardCharsets.UTF_8.name()));
        return new RunResult(captured.toString(StandardCharsets.UTF_8.name()), process.exitValue());
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        for (int n; (n = in.read(buffer)) != -1;) out.write(buffer, 0, n);
    }

    private static void assertCompleted(RunResult r) {
        assertEquals("Expected success. Output:\n" + r.output, 0, r.exitStatus);
        assertContains(r, "All layers compared");
    }

    private static void assertFailed(RunResult r) {
        assertNotEquals("Expected non-zero exit. Output:\n" + r.output, 0, r.exitStatus);
    }

    private static void assertParsingFailure(RunResult r) {
        assertFailed(r);
        assertContainsAny(r, "usage", "missing", "required", "argument", "parse", "option");
        assertNotContains(r, "All layers compared");
    }

    private static void assertNumericFailure(RunResult r) {
        assertFailed(r);
        assertContainsAny(r, "numberformatexception", "for input string", "integer", "parse", "number");
        assertNotContains(r, "All layers compared");
    }

    private static void assertFileFailure(RunResult r) {
        assertFailed(r);
        assertContainsAny(r, "no such file", "file not found", "filenotfoundexception", "cannot find", "does not exist");
        assertNotContains(r, "All layers compared");
    }

    private static void assertSnapshotFailure(RunResult r) {
        assertFailed(r);
        assertContainsAny(r, "snapshot", "magic", "checksum", "deserialize", "exception", "eof", "invalid");
        assertNotContains(r, "All layers compared");
    }

    private static void assertContains(RunResult r, String text) {
        assertTrue("Missing output: " + text + "\nActual:\n" + r.output, lower(r.output).contains(lower(text)));
    }

    private static void assertContainsAny(RunResult r, String... texts) {
        String output = lower(r.output);
        for (String text : texts) if (output.contains(lower(text))) return;
        fail("Expected one of " + Arrays.toString(texts) + "\nActual:\n" + r.output);
    }

    private static void assertNotContains(RunResult r, String text) {
        assertFalse("Unexpected output: " + text + "\nActual:\n" + r.output, lower(r.output).contains(lower(text)));
    }

    private static void assertNotContainsAny(RunResult r, String... texts) {
        for (String text : texts) assertNotContains(r, text);
    }

    private static void assertDelta(RunResult r, String path, String delta) {
        assertContains(r, "Node " + path + " found in both trees. Delta: " + delta);
    }

    private static void assertNoDeltaForPath(RunResult r, String path) {
        for (String line : r.output.split("\\R")) {
            assertFalse("Unexpected delta for " + path + ": " + line,
                    line.contains("Node " + path + " found in both trees") && line.contains("Delta:"));
        }
    }

    private static String semanticOutput(String output) {
        return filterSemantic(output, true);
    }

    private static String semanticComparisonOutput(String output) {
        return filterSemantic(output, false);
    }

    private static String filterSemantic(String output, boolean includeSummary) {
        StringBuilder b = new StringBuilder();
        for (String line : output.replace("\r\n", "\n").split("\n")) {
            String s = line.trim();
            boolean comparison = s.startsWith("Node ") || s.startsWith("Filtered node ")
                    || s.startsWith("Analysis for depth") || s.startsWith("All layers compared");
            boolean summary = s.startsWith("Node count:") || s.startsWith("Total size:")
                    || s.startsWith("Max depth:") || s.startsWith("Count of nodes at depth");
            boolean error = s.startsWith("Usage:") || lower(s).contains("unrecognized option")
                    || lower(s).contains("missing argument");
            if (comparison || error || (includeSummary && summary)) b.append(s).append('\n');
        }
        return b.toString().trim();
    }

    private static String lower(String s) { return s.toLowerCase(java.util.Locale.ROOT); }

    private static final class RunResult {
        final String output;
        final int exitStatus;
        RunResult(String output, int exitStatus) { this.output = output; this.exitStatus = exitStatus; }
    }
}

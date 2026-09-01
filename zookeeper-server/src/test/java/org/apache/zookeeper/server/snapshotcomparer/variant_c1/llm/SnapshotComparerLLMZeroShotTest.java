package org.apache.zookeeper.server.snapshotcomparer.variant_c1.llm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.DataTree;
import org.apache.zookeeper.server.SnapshotComparer;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Black-box tests for {@link SnapshotComparer}. The tests exercise only the
 * command-line entry point and validate text written to stdout/stderr.
 */
public class SnapshotComparerLLMZeroShotTest {

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    private PrintStream originalOut;
    private PrintStream originalErr;
    private java.io.InputStream originalIn;
    private ByteArrayOutputStream stdout;
    private ByteArrayOutputStream stderr;

    @Before
    public void redirectProcessStreams() throws Exception {
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;
        stdout = new ByteArrayOutputStream();
        stderr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout, true, "UTF-8"));
        System.setErr(new PrintStream(stderr, true, "UTF-8"));
        System.setIn(new ByteArrayInputStream(new byte[0]));
    }

    @After
    public void restoreProcessStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void identicalSnapshotsReportNoNodeDelta() throws Exception {
        File left = snapshot("left", mapOf("/a", bytes(3), "/a/child", bytes(2)));
        File right = snapshot("right", mapOf("/a", bytes(3), "/a/child", bytes(2)));

        run(left, right, 0, 0);

        String output = out();
        assertTrue(output.contains("Successfully parsed options!"));
        assertTrue(output.contains("Printing analysis for nodes difference larger than 0 bytes or node count difference larger than 0."));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("All layers compared."));
        assertFalse(output.contains("found only in"));
        assertFalse(output.contains("found in both trees. Delta:"));
    }

    @Test
    public void reportsAddedDeletedAndChangedNodesInAlphabeticOrder() throws Exception {
        File left = snapshot("left", mapOf("/deleted", bytes(4), "/same", bytes(2)));
        File right = snapshot("right", mapOf("/added", bytes(5), "/same", bytes(9)));

        run(left, right, 0, 0);

        String output = out();
        String added = "Node /added found only in right tree. Descendant size: 5. Descendant count: 0";
        String deleted = "Node /deleted found only in left tree. Descendant size: 4. Descendant count: 0";
        String changed = "Node /same found in both trees. Delta: 7 bytes, 0 descendants";
        assertTrue(output.contains(added));
        assertTrue(output.contains(deleted));
        assertTrue(output.contains(changed));
        assertTrue("merge comparison must emit paths alphabetically", output.indexOf(added) < output.indexOf(deleted));
        assertTrue("merge comparison must emit paths alphabetically", output.indexOf(deleted) < output.indexOf(changed));
    }

    @Test
    public void thresholdsAreStrictAndFilteredNodesAreSilentNormally() throws Exception {
        File empty = snapshot("empty", Collections.<String, byte[]>emptyMap());
        File right = snapshot("right", mapOf("/equal", bytes(5), "/over", bytes(6)));

        run(empty, right, 5, 0);

        String output = out();
        assertFalse("a value equal to the byte threshold is filtered", output.contains("Node /equal found only"));
        assertTrue("a value greater than the byte threshold is printed", output.contains("Node /over found only in right tree"));
        assertFalse(output.contains("Filtered right node /equal"));
    }

    @Test
    public void descendantCountCanTriggerOutputWhenByteDeltaDoesNot() throws Exception {
        File empty = snapshot("empty", Collections.<String, byte[]>emptyMap());
        File right = snapshot("right", mapOf("/parent", bytes(0), "/parent/c1", bytes(0), "/parent/c2", bytes(0)));

        run(empty, right, 100, 1);

        assertTrue(out().contains(
                "Node /parent found only in right tree. Descendant size: 0. Descendant count: 2"));
    }

    @Test
    public void debugModeExplainsComparisonsAndFiltering() throws Exception {
        File left = snapshot("left", mapOf("/a", bytes(1), "/both", bytes(2)));
        File right = snapshot("right", mapOf("/both", bytes(2), "/z", bytes(1)));

        run(left, right, 100, 100, "--debug");

        String output = out();
        assertTrue(output.contains("Comparing /a to /both"));
        assertTrue(output.contains("left is less"));
        assertTrue(output.contains("same"));
        assertTrue(output.contains("Filtered left node /a of size 1"));
        assertTrue(output.contains("Filtered node /both of left size 2, right size 2"));
        assertTrue(output.contains("Filtered right node /z of size 1"));
    }

    @Test
    public void longOptionNamesAreAccepted() throws Exception {
        File left = snapshot("left", Collections.<String, byte[]>emptyMap());
        File right = snapshot("right", Collections.<String, byte[]>emptyMap());

        SnapshotComparer.main(new String[] {
                "--left", left.getAbsolutePath(),
                "--right", right.getAbsolutePath(),
                "--bytes", "0",
                "--nodes", "0"
        });

        assertTrue(out().contains("Successfully parsed options!"));
        assertTrue(out().contains("All layers compared."));
    }

    @Test
    public void invalidIntegerIsPropagatedAndSnapshotsAreNotOpened() throws Exception {
        File nonexistentLeft = new File(temporaryFolder.getRoot(), "does-not-exist-left");
        File nonexistentRight = new File(temporaryFolder.getRoot(), "does-not-exist-right");

        try {
            SnapshotComparer.main(new String[] {
                    "-l", nonexistentLeft.getAbsolutePath(),
                    "-r", nonexistentRight.getAbsolutePath(),
                    "-b", "not-an-integer",
                    "-n", "0"
            });
            fail("Expected NumberFormatException");
        } catch (NumberFormatException expected) {
            assertTrue(expected.getMessage().contains("not-an-integer"));
        }
        assertFalse(out().contains("Successfully parsed options!"));
    }

    @Test
    public void negativeThresholdsMakeEvenZeroSizedNodesObservable() throws Exception {
        File left = snapshot("left", Collections.<String, byte[]>emptyMap());
        File right = snapshot("right", mapOf("/zero", bytes(0)));

        run(left, right, -1, -1);

        assertTrue(out().contains(
                "Node /zero found only in right tree. Descendant size: 0. Descendant count: 0"));
    }

    @Test
    public void interactiveModeSupportsPathLookupInvalidInputAndDepthAdvance() throws Exception {
        File left = snapshot("left", mapOf("/p", bytes(0), "/p/old", bytes(1)));
        File right = snapshot("right", mapOf("/p", bytes(0), "/p/new", bytes(1)));
        /* Bugged, modified in order to solve the problem
        System.setIn(new ByteArrayInputStream("/p\nmissing\n99\n\n\n".getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(
                ("/p\nmissing\n99\n" + repeatedNewlines(128))
                        .getBytes(StandardCharsets.UTF_8)));

        run(left, right, 100, 100, "--interactive");

        String output = out();
        assertTrue(output.contains("Current depth is 0"));
        assertTrue(output.contains("Analysis for node /p"));
        assertTrue(output.contains("Filtered right node /p/new of size 1"));
        assertTrue(output.contains("Filtered left node /p/old of size 1"));
        assertTrue(output.contains("Input missing is not valid."));
        assertTrue(output.contains("Depth must be in range [0, 2]"));
        assertTrue(output.contains("Analysis for depth 0"));
        assertTrue(output.contains("Analysis for depth 1"));
        assertTrue(output.contains("All layers compared."));
    }

    @Test
    public void interactiveModeReportsUnknownAbsolutePath() throws Exception {
        File left = snapshot("left", Collections.<String, byte[]>emptyMap());
        File right = snapshot("right", Collections.<String, byte[]>emptyMap());
        /* Bugged, modified in order to solve the problem
        System.setIn(new ByteArrayInputStream("/absent\n\n".getBytes(StandardCharsets.UTF_8))); */

        System.setIn(new ByteArrayInputStream(("/absent\n" + repeatedNewlines(128)).getBytes(StandardCharsets.UTF_8)));

        run(left, right, 0, 0, "-i");

        assertTrue(out().contains("Path /absent is neither found in left tree nor right tree."));
    }

    private void run(File left, File right, int bytes, int nodes, String... extra) throws Exception {
        String[] args = new String[8 + extra.length];
        args[0] = "-l";
        args[1] = left.getAbsolutePath();
        args[2] = "-r";
        args[3] = right.getAbsolutePath();
        args[4] = "-b";
        args[5] = Integer.toString(bytes);
        args[6] = "-n";
        args[7] = Integer.toString(nodes);
        System.arraycopy(extra, 0, args, 8, extra.length);
        SnapshotComparer.main(args);
    }

    private File snapshot(String name, Map<String, byte[]> nodes) throws Exception {
        File directory = temporaryFolder.newFolder(name);
        DataTree tree = new DataTree();
        long zxid = 1L;
        for (Map.Entry<String, byte[]> entry : nodes.entrySet()) {
            tree.createNode(entry.getKey(), entry.getValue(), null, 0L, -1, zxid, 1L, new Stat());
            zxid++;
        }
        File file = new File(directory, "snapshot." + Long.toHexString(zxid));
        new FileSnap(directory).serialize(tree, new HashMap<Long, Integer>(), file, false);
        assertTrue("snapshot fixture was not created", Files.isRegularFile(file.toPath()));
        return file;
    }

    private static Map<String, byte[]> mapOf(Object... keyValues) {
        Map<String, byte[]> result = new java.util.LinkedHashMap<String, byte[]>();
        for (int i = 0; i < keyValues.length; i += 2) {
            result.put((String) keyValues[i], (byte[]) keyValues[i + 1]);
        }
        return result;
    }

    private static byte[] bytes(int count) {
        return new byte[count];
    }

    private String out() throws Exception {
        System.out.flush();
        return stdout.toString("UTF-8").replace("\r\n", "\n");
    }

    // Added in order to solve the 2 errors
    private static String repeatedNewlines(int count) {
        StringBuilder input = new StringBuilder(count);
        for (int index = 0; index < count; index++) {
            input.append('\n');
        }
        return input.toString();
    }
}

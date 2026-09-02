/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zookeeper.server.snapshotcomparer.variant_c3;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.jute.BinaryInputArchive;
import org.apache.jute.InputArchive;
import org.apache.zookeeper.server.DataNode;
import org.apache.zookeeper.server.DataTree;
import org.apache.zookeeper.server.ExitCode;
import org.apache.zookeeper.server.persistence.FileSnap;
import org.apache.zookeeper.server.persistence.SnapStream;
import org.apache.zookeeper.util.ServiceUtils;

/**
 * SnapshotComparer is a tool that loads and compares two snapshots with
 * configurable thresholds and filters, and outputs information about their
 * differences.
 *
 * <p>The reported delta includes znode paths added, updated, or deleted between
 * the snapshots. The tool is useful for offline consistency checking and data
 * trend analysis.
 */
public class SnapshotComparer {

    private static final String LEFT_OPTION = "left";
    private static final String RIGHT_OPTION = "right";
    private static final String BYTE_THRESHOLD_OPTION = "bytes";
    private static final String NODE_THRESHOLD_OPTION = "nodes";
    private static final String DEBUG_OPTION = "debug";
    private static final String INTERACTIVE_OPTION = "interactive";

    private static final int ROOT_DEPTH = 1;
    private static final double NANOSECONDS_PER_SECOND = 1_000_000_000.0;

    private final Options options;

    private SnapshotComparer() {
        options = createOptions();
    }

    private static Options createOptions() {
        Options configuredOptions = new Options();

        configuredOptions.addOption(
                requiredOption(
                        "l",
                        LEFT_OPTION,
                        "(Required) The left snapshot file.",
                        "LEFT",
                        File.class));

        configuredOptions.addOption(
                requiredOption(
                        "r",
                        RIGHT_OPTION,
                        "(Required) The right snapshot file.",
                        "RIGHT",
                        File.class));

        configuredOptions.addOption(
                requiredOption(
                        "b",
                        BYTE_THRESHOLD_OPTION,
                        "(Required) The node data delta size threshold, in bytes, for printing the node.",
                        "BYTETHRESHOLD",
                        String.class));

        configuredOptions.addOption(
                requiredOption(
                        "n",
                        NODE_THRESHOLD_OPTION,
                        "(Required) The descendant node delta size threshold, in nodes, for printing the node.",
                        "NODETHRESHOLD",
                        String.class));

        configuredOptions.addOption("d", DEBUG_OPTION, false, "Use debug output.");
        configuredOptions.addOption("i", INTERACTIVE_OPTION, false, "Enter interactive mode.");

        return configuredOptions;
    }

    private static Option requiredOption(
            String shortName,
            String longName,
            String description,
            String argumentName,
            Class<?> type
    ) {
        return Option.builder(shortName)
                .hasArg()
                .required(true)
                .longOpt(longName)
                .desc(description)
                .argName(argumentName)
                .type(type)
                .build();
    }

    private void usage() {
        HelpFormatter help = new HelpFormatter();
        help.printHelp(
                120,
                "java -cp <classPath> " + SnapshotComparer.class.getName(),
                "",
                options,
                "");
    }

    public static void main(String[] args) throws Exception {
        SnapshotComparer app = new SnapshotComparer();
        app.compareSnapshots(args);
    }

    private void compareSnapshots(String[] args) throws Exception {
        CommandLine parsedOptions = parseOptions(args);
        if (parsedOptions == null) {
            return;
        }

        File leftSnapshot = (File) parsedOptions.getParsedOptionValue(LEFT_OPTION);
        File rightSnapshot = (File) parsedOptions.getParsedOptionValue(RIGHT_OPTION);
        int byteThreshold = parseThreshold(parsedOptions, BYTE_THRESHOLD_OPTION);
        int nodeThreshold = parseThreshold(parsedOptions, NODE_THRESHOLD_OPTION);
        boolean debug = parsedOptions.hasOption(DEBUG_OPTION);
        boolean interactive = parsedOptions.hasOption(INTERACTIVE_OPTION);

        System.out.println("Successfully parsed options!");

        TreeInfo leftTree = new TreeInfo(leftSnapshot);
        TreeInfo rightTree = new TreeInfo(rightSnapshot);

        System.out.println(leftTree.toString());
        System.out.println(rightTree.toString());

        compareTrees(
                leftTree,
                rightTree,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
    }

    private CommandLine parseOptions(String[] args) {
        try {
            return new DefaultParser().parse(options, args);
        } catch (ParseException exception) {
            System.err.println(exception.getMessage());
            usage();
            ServiceUtils.requestSystemExit(ExitCode.INVALID_INVOCATION.getValue());
            return null;
        }
    }

    private static int parseThreshold(CommandLine parsedOptions, String optionName)
            throws ParseException {
        return Integer.parseInt(
                (String) parsedOptions.getParsedOptionValue(optionName));
    }

    private static final class TreeInfo {

        private static final class TreeNode {

            private final String label;
            private final long size;
            private final List<TreeNode> children;

            private long descendantSize;
            private long descendantCount;

            private TreeNode(String label, long size) {
                this.label = label;
                this.size = size;
                this.children = new ArrayList<>();
            }

            private void populateChildren(
                    String path,
                    DataTree dataTree,
                    TreeInfo treeInfo
            ) throws Exception {
                populateChildren(path, dataTree, treeInfo, ROOT_DEPTH);
            }

            private void populateChildren(
                    String path,
                    DataTree dataTree,
                    TreeInfo treeInfo,
                    int currentDepth
            ) throws Exception {
                List<String> childLabels = dataTree.getChildren(path, null, null);

                if (childLabels != null && !childLabels.isEmpty()) {
                    for (String childName : childLabels) {
                        TreeNode child = createChildNode(path, childName, dataTree);
                        child.populateChildren(
                                child.label,
                                dataTree,
                                treeInfo,
                                currentDepth + 1);
                        children.add(child);
                    }
                }

                calculateDescendantStatistics();
                treeInfo.registerNode(this, currentDepth);
            }

            private static TreeNode createChildNode(
                    String parentPath,
                    String childName,
                    DataTree dataTree
            ) {
                String childPath = parentPath + "/" + childName;
                DataNode dataNode = dataTree.getNode(childPath);
                long childSize;

                synchronized (dataNode) {
                    childSize = dataNode.data == null ? 0 : dataNode.data.length;
                }

                return new TreeNode(childPath, childSize);
            }

            private void calculateDescendantStatistics() {
                descendantSize = size;
                descendantCount = children.size();

                for (TreeNode child : children) {
                    descendantSize += child.descendantSize;
                    descendantCount += child.descendantCount;
                }
            }

            private static final class AlphabeticComparator
                    implements Comparator<TreeNode>, Serializable {

                private static final long serialVersionUID = 2601197766392565593L;

                @Override
                public int compare(TreeNode left, TreeNode right) {
                    if (left == right) {
                        return 0;
                    }
                    if (left == null) {
                        return -1;
                    }
                    if (right == null) {
                        return 1;
                    }
                    return left.label.compareTo(right.label);
                }
            }
        }

        private final TreeNode root;
        private final List<ArrayList<TreeNode>> nodesAtDepths;
        private final Map<String, TreeNode> nodesByName;

        private long count;

        private TreeInfo(File snapshot) throws Exception {
            nodesAtDepths = new ArrayList<>();
            nodesByName = new HashMap<>();

            DataTree dataTree = getSnapshot(snapshot);
            count = 0;

            long beginning = System.nanoTime();

            DataNode rootDataNode = dataTree.getNode("");
            long rootSize = rootDataNode.data == null ? 0 : rootDataNode.data.length;
            root = new TreeNode("", rootSize);
            root.populateChildren("", dataTree, this);

            long end = System.nanoTime();
            System.out.println(String.format(
                    "Processed data tree in %f seconds",
                    elapsedSeconds(beginning, end)));
        }

        private void registerNode(TreeNode node, int depth) {
            while (depth > nodesAtDepths.size()) {
                nodesAtDepths.add(new ArrayList<>());
            }

            nodesAtDepths.get(depth - 1).add(node);
            nodesByName.put(node.label, node);
            count++;
        }

        private static Comparator<TreeNode> makeAlphabeticComparator() {
            return new TreeNode.AlphabeticComparator();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("Node count: %d%n", count));
            builder.append(String.format(
                    "Total size: %d%n",
                    root.descendantSize));
            builder.append(String.format(
                    "Max depth: %d%n",
                    nodesAtDepths.size()));

            for (int depth = 0; depth < nodesAtDepths.size(); depth++) {
                builder.append(String.format(
                        "Count of nodes at depth %d: %d%n",
                        depth,
                        nodesAtDepths.get(depth).size()));
            }

            return builder.toString();
        }
    }

    /**
     * Parses a ZooKeeper snapshot file into a DataTree.
     *
     * @param file snapshot file
     * @return deserialized data tree
     * @throws Exception if the snapshot cannot be loaded or deserialized
     */
    private static DataTree getSnapshot(File file) throws Exception {
        DataTree dataTree = new DataTree();
        Map<Long, Integer> sessions = new HashMap<>();
        CheckedInputStream snapshotInputStream = SnapStream.getInputStream(file);

        long beginning = System.nanoTime();

        InputArchive inputArchive =
                BinaryInputArchive.getArchive(snapshotInputStream);
        FileSnap.deserialize(dataTree, sessions, inputArchive);

        long end = System.nanoTime();

        System.out.println(String.format(
                "Deserialized snapshot in %s in %f seconds",
                file.getName(),
                elapsedSeconds(beginning, end)));

        return dataTree;
    }

    private static double elapsedSeconds(long beginning, long end) {
        return (end - beginning) / NANOSECONDS_PER_SECOND;
    }

    private static void printThresholdInfo(
            int byteThreshold,
            int nodeThreshold
    ) {
        System.out.println(String.format(
                "Printing analysis for nodes difference larger than %d bytes or node count difference larger than %d.",
                byteThreshold,
                nodeThreshold));
    }

    private static void compareTrees(
            TreeInfo left,
            TreeInfo right,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        int maxDepth = Math.max(
                left.nodesAtDepths.size(),
                right.nodesAtDepths.size());

        if (interactive) {
            compareInteractively(
                    left,
                    right,
                    maxDepth,
                    byteThreshold,
                    nodeThreshold,
                    debug);
        } else {
            compareAllDepths(
                    left,
                    right,
                    maxDepth,
                    byteThreshold,
                    nodeThreshold,
                    debug);
        }

        System.out.println("All layers compared.");
    }

    private static void compareAllDepths(
            TreeInfo left,
            TreeInfo right,
            int maxDepth,
            int byteThreshold,
            int nodeThreshold,
            boolean debug
    ) {
        printThresholdInfo(byteThreshold, nodeThreshold);

        for (int depth = 0; depth < maxDepth; depth++) {
            printDepthHeading(depth);
            compareLine(
                    left,
                    right,
                    depth,
                    byteThreshold,
                    nodeThreshold,
                    debug,
                    false);
        }
    }

    private static void compareInteractively(
            TreeInfo left,
            TreeInfo right,
            int maxDepth,
            int byteThreshold,
            int nodeThreshold,
            boolean debug
    ) {
        Scanner scanner = new Scanner(System.in);
        int currentDepth = 0;

        while (currentDepth < maxDepth) {
            printInteractivePrompt(currentDepth);
            String input = scanner.nextLine();
            printThresholdInfo(byteThreshold, nodeThreshold);

            if (input.isEmpty()) {
                printDepthHeading(currentDepth);
                compareLine(
                        left,
                        right,
                        currentDepth,
                        byteThreshold,
                        nodeThreshold,
                        debug,
                        true);
                currentDepth++;
            } else if (input.startsWith("/")) {
                compareRequestedSubtree(
                        left,
                        right,
                        input,
                        byteThreshold,
                        nodeThreshold,
                        debug);
            } else {
                currentDepth = processDepthInput(
                        left,
                        right,
                        input,
                        currentDepth,
                        maxDepth,
                        byteThreshold,
                        nodeThreshold,
                        debug);
            }

            System.out.println("");
        }
    }

    private static void printInteractivePrompt(int currentDepth) {
        System.out.println(String.format(
                "Current depth is %d",
                currentDepth));
        System.out.println(
                "- Press enter to move to print current depth layer;\n"
                        + "- Type a number to jump to and print all nodes at a given depth;\n"
                        + "- Enter an ABSOLUTE path to print the immediate subtree of a node. "
                        + "Path must start with '/'.");
    }

    private static void compareRequestedSubtree(
            TreeInfo left,
            TreeInfo right,
            String path,
            int byteThreshold,
            int nodeThreshold,
            boolean debug
    ) {
        System.out.println(String.format("Analysis for node %s", path));
        compareSubtree(
                left,
                right,
                path,
                byteThreshold,
                nodeThreshold,
                debug,
                true);
    }

    private static int processDepthInput(
            TreeInfo left,
            TreeInfo right,
            String input,
            int currentDepth,
            int maxDepth,
            int byteThreshold,
            int nodeThreshold,
            boolean debug
    ) {
        try {
            int requestedDepth = Integer.parseInt(input);

            if (requestedDepth < 0 || requestedDepth >= maxDepth) {
                printDepthRangeError(maxDepth);
                return currentDepth;
            }

            printDepthHeading(requestedDepth);
            compareLine(
                    left,
                    right,
                    requestedDepth,
                    byteThreshold,
                    nodeThreshold,
                    debug,
                    true);
            return requestedDepth;
        } catch (NumberFormatException exception) {
            System.out.println(String.format(
                    "Input %s is not valid. Depth must be in range [%d, %d]. "
                            + "Path must be an absolute path which starts with '/'.",
                    input,
                    0,
                    maxDepth - 1));
            return currentDepth;
        }
    }

    private static void printDepthHeading(int depth) {
        System.out.println(String.format("Analysis for depth %d", depth));
    }

    private static void printDepthRangeError(int maxDepth) {
        System.out.println(String.format(
                "Depth must be in range [%d, %d]",
                0,
                maxDepth - 1));
    }

    private static void compareSubtree(
            TreeInfo left,
            TreeInfo right,
            String path,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        TreeInfo.TreeNode leftRoot = left.nodesByName.get(path);
        TreeInfo.TreeNode rightRoot = right.nodesByName.get(path);

        List<TreeInfo.TreeNode> leftChildren =
                childrenOrEmptyList(leftRoot);
        List<TreeInfo.TreeNode> rightChildren =
                childrenOrEmptyList(rightRoot);

        if (leftRoot == null && rightRoot == null) {
            System.out.println(String.format(
                    "Path %s is neither found in left tree nor right tree.",
                    path));
            return;
        }

        compareNodes(
                leftChildren,
                rightChildren,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
    }

    private static List<TreeInfo.TreeNode> childrenOrEmptyList(
            TreeInfo.TreeNode node
    ) {
        return node == null
                ? new ArrayList<TreeInfo.TreeNode>()
                : node.children;
    }

    /**
     * Compares the nodes from the left and right trees at the same depth.
     *
     * @param left left data tree
     * @param right right data tree
     * @param depth depth to compare
     * @param byteThreshold node-data delta threshold
     * @param nodeThreshold descendant-count delta threshold
     * @param debug whether detailed diagnostics are enabled
     * @param interactive whether interactive output is enabled
     */
    private static void compareLine(
            TreeInfo left,
            TreeInfo right,
            int depth,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        List<TreeInfo.TreeNode> leftNodes =
                nodesAtDepth(left, depth);
        List<TreeInfo.TreeNode> rightNodes =
                nodesAtDepth(right, depth);

        compareNodes(
                leftNodes,
                rightNodes,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
    }

    private static List<TreeInfo.TreeNode> nodesAtDepth(
            TreeInfo tree,
            int depth
    ) {
        return depth >= tree.nodesAtDepths.size()
                ? new ArrayList<TreeInfo.TreeNode>()
                : tree.nodesAtDepths.get(depth);
    }

    private static void compareNodes(
            List<TreeInfo.TreeNode> leftNodes,
            List<TreeInfo.TreeNode> rightNodes,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        Comparator<TreeInfo.TreeNode> comparator =
                TreeInfo.makeAlphabeticComparator();

        Collections.sort(leftNodes, comparator);
        Collections.sort(rightNodes, comparator);

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftNodes.size()
                || rightIndex < rightNodes.size()) {

            TreeInfo.TreeNode leftNode =
                    nodeAt(leftNodes, leftIndex);
            TreeInfo.TreeNode rightNode =
                    nodeAt(rightNodes, rightIndex);

            if (leftNode == null) {
                printRightOnly(
                        rightNode,
                        byteThreshold,
                        nodeThreshold,
                        debug,
                        interactive);
                rightIndex++;
            } else if (rightNode == null) {
                printLeftOnly(
                        leftNode,
                        byteThreshold,
                        nodeThreshold,
                        debug,
                        interactive);
                leftIndex++;
            } else {
                int comparison = compareNodePair(
                        leftNode,
                        rightNode,
                        byteThreshold,
                        nodeThreshold,
                        debug,
                        interactive);

                if (comparison <= 0) {
                    leftIndex++;
                }
                if (comparison >= 0) {
                    rightIndex++;
                }
            }
        }
    }

    private static TreeInfo.TreeNode nodeAt(
            List<TreeInfo.TreeNode> nodes,
            int index
    ) {
        return index < nodes.size() ? nodes.get(index) : null;
    }

    private static int compareNodePair(
            TreeInfo.TreeNode leftNode,
            TreeInfo.TreeNode rightNode,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        if (debug) {
            System.out.println(String.format(
                    "Comparing %s to %s",
                    leftNode.label,
                    rightNode.label));
        }

        int comparison = leftNode.label.compareTo(rightNode.label);

        if (comparison < 0) {
            printDebugComparisonResult(debug, "left is less");
            printLeftOnly(
                    leftNode,
                    byteThreshold,
                    nodeThreshold,
                    debug,
                    interactive);
        } else if (comparison > 0) {
            printDebugComparisonResult(debug, "right is less");
            printRightOnly(
                    rightNode,
                    byteThreshold,
                    nodeThreshold,
                    debug,
                    interactive);
        } else {
            printDebugComparisonResult(debug, "same");
            printBoth(
                    leftNode,
                    rightNode,
                    byteThreshold,
                    nodeThreshold,
                    debug,
                    interactive);
        }

        return comparison;
    }

    private static void printDebugComparisonResult(
            boolean debug,
            String result
    ) {
        if (debug) {
            System.out.println(result);
        }
    }

    static void printLeftOnly(
            TreeInfo.TreeNode node,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        printExclusiveNode(
                node,
                "left",
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
    }

    static void printRightOnly(
            TreeInfo.TreeNode node,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        printExclusiveNode(
                node,
                "right",
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
    }

    private static void printExclusiveNode(
            TreeInfo.TreeNode node,
            String side,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        if (exceedsThreshold(node, byteThreshold, nodeThreshold)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format(
                    "Node %s found only in %s tree. ",
                    node.label,
                    side));
            printNode(node, builder);
            System.out.println(builder.toString());
        } else if (debug || interactive) {
            System.out.println(String.format(
                    "Filtered %s node %s of size %d",
                    side,
                    node.label,
                    node.descendantSize));
        }
    }

    private static boolean exceedsThreshold(
            TreeInfo.TreeNode node,
            int byteThreshold,
            int nodeThreshold
    ) {
        return node.descendantSize > byteThreshold
                || node.descendantCount > nodeThreshold;
    }

    static void printBoth(
            TreeInfo.TreeNode leftNode,
            TreeInfo.TreeNode rightNode,
            int byteThreshold,
            int nodeThreshold,
            boolean debug,
            boolean interactive
    ) {
        long sizeDelta =
                rightNode.descendantSize - leftNode.descendantSize;
        long countDelta =
                rightNode.descendantCount - leftNode.descendantCount;

        if (Math.abs(sizeDelta) > byteThreshold
                || Math.abs(countDelta) > nodeThreshold) {

            System.out.println(String.format(
                    "Node %s found in both trees. Delta: %d bytes, %d descendants",
                    leftNode.label,
                    sizeDelta,
                    countDelta));
        } else if (debug || interactive) {
            System.out.println(String.format(
                    "Filtered node %s of left size %d, right size %d",
                    leftNode.label,
                    leftNode.descendantSize,
                    rightNode.descendantSize));
        }
    }

    static void printNode(
            TreeInfo.TreeNode node,
            StringBuilder builder
    ) {
        builder.append(String.format(
                "Descendant size: %d. Descendant count: %d",
                node.descendantSize,
                node.descendantCount));
    }
}
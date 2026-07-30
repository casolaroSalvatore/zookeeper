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

package org.apache.zookeeper.server;

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
import org.apache.zookeeper.server.persistence.FileSnap;
import org.apache.zookeeper.server.persistence.SnapStream;
import org.apache.zookeeper.util.ServiceUtils;

/**
 * SnapshotComparer is a tool that loads and compares two snapshots with
 * configurable threshold and various filters, and outputs information about
 * the delta.
 *
 * <p>The delta includes specific znode paths added, updated, deleted comparing
 * one snapshot to another.
 *
 * <p>It's useful in use cases that involve snapshot analysis, such as offline
 * data consistency checking, and data trending analysis (e.g. what's growing
 * under which zNode path during when).
 *
 * <p>Only outputs information about permanent nodes, ignoring both sessions
 * and ephemeral nodes.
 */
public class SnapshotComparer {

  private static final String LEFT_OPTION = "left";
  private static final String RIGHT_OPTION = "right";
  private static final String BYTE_THRESHOLD_OPTION = "bytes";
  private static final String NODE_THRESHOLD_OPTION = "nodes";
  private static final String DEBUG_OPTION = "debug";
  private static final String INTERACTIVE_OPTION = "interactive";

  private final Options options;

  private SnapshotComparer() {
    options = createOptions();
  }

  private static Options createOptions() {
    Options options = new Options();

    options.addOption(
            createRequiredOption(
                    "l",
                    LEFT_OPTION,
                    "(Required) The left snapshot file.",
                    "LEFT",
                    File.class));

    options.addOption(
            createRequiredOption(
                    "r",
                    RIGHT_OPTION,
                    "(Required) The right snapshot file.",
                    "RIGHT",
                    File.class));

    options.addOption(
            createRequiredOption(
                    "b",
                    BYTE_THRESHOLD_OPTION,
                    "(Required) The node data delta size threshold, in bytes, for printing the node.",
                    "BYTETHRESHOLD",
                    String.class));

    options.addOption(
            createRequiredOption(
                    "n",
                    NODE_THRESHOLD_OPTION,
                    "(Required) The descendant node delta size threshold, in nodes, for printing the node.",
                    "NODETHRESHOLD",
                    String.class));

    options.addOption("d", DEBUG_OPTION, false, "Use debug output.");
    options.addOption("i", INTERACTIVE_OPTION, false, "Enter interactive mode.");

    return options;
  }

  private static Option createRequiredOption(
          String shortName,
          String longName,
          String description,
          String argumentName,
          Class<?> type) {

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
    int byteThreshold = parseIntegerOption(parsedOptions, BYTE_THRESHOLD_OPTION);
    int nodeThreshold = parseIntegerOption(parsedOptions, NODE_THRESHOLD_OPTION);
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
    } catch (ParseException e) {
      System.err.println(e.getMessage());
      usage();
      ServiceUtils.requestSystemExit(ExitCode.INVALID_INVOCATION.getValue());
      return null;
    }
  }

  private static int parseIntegerOption(
          CommandLine parsedOptions,
          String optionName) throws ParseException {

    return Integer.parseInt(
            (String) parsedOptions.getParsedOptionValue(optionName));
  }

  private static class TreeInfo {

    public static class TreeNode {

      final String label;
      final long size;
      final List<TreeNode> children;
      long descendantSize;
      long descendantCount;

      public static class AlphabeticComparator
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

      public TreeNode(String label, long size) {
        this.label = label;
        this.size = size;
        this.children = new ArrayList<>();
      }

      void populateChildren(
              String path,
              DataTree dataTree,
              TreeInfo treeInfo) throws Exception {

        populateChildren(path, dataTree, treeInfo, 1);
      }

      void populateChildren(
              String path,
              DataTree dataTree,
              TreeInfo treeInfo,
              int currentDepth) throws Exception {

        List<String> childLabels = dataTree.getChildren(path, null, null);

        if (childLabels != null && !childLabels.isEmpty()) {
          for (String childName : childLabels) {
            TreeNode child = createChildNode(
                    path,
                    childName,
                    dataTree,
                    treeInfo,
                    currentDepth);
            children.add(child);
          }
        }

        calculateDescendantStatistics();
        treeInfo.registerNode(this, currentDepth);
      }

      private static TreeNode createChildNode(
              String parentPath,
              String childName,
              DataTree dataTree,
              TreeInfo treeInfo,
              int currentDepth) throws Exception {

        String childPath = parentPath + "/" + childName;
        DataNode dataNode = dataTree.getNode(childPath);
        long childSize = getDataSize(dataNode);

        TreeNode child = new TreeNode(childPath, childSize);
        child.populateChildren(
                childPath,
                dataTree,
                treeInfo,
                currentDepth + 1);

        return child;
      }

      private static long getDataSize(DataNode node) {
        synchronized (node) {
          return node.data == null ? 0 : node.data.length;
        }
      }

      private void calculateDescendantStatistics() {
        descendantSize = 0;
        descendantCount = 0;

        for (TreeNode child : children) {
          descendantSize += child.descendantSize;
          descendantCount += child.descendantCount;
        }

        descendantSize += size;
        descendantCount += children.size();
      }
    }

    final TreeNode root;
    long count;
    List<ArrayList<TreeNode>> nodesAtDepths = new ArrayList<>();
    Map<String, TreeNode> nodesByName = new HashMap<>();

    TreeInfo(File snapshot) throws Exception {
      DataTree dataTree = getSnapshot(snapshot);

      count = 0;
      long beginning = System.nanoTime();

      DataNode rootNode = dataTree.getNode("");
      long rootSize = rootNode.data == null ? 0 : rootNode.data.length;
      root = new TreeNode("", rootSize);

      root.populateChildren("", dataTree, this);

      long end = System.nanoTime();
      System.out.println(String.format(
              "Processed data tree in %f seconds",
              toSeconds(beginning, end)));
    }

    void registerNode(TreeNode node, int depth) {
      ensureDepthExists(depth);
      nodesAtDepths.get(depth - 1).add(node);
      nodesByName.put(node.label, node);
      count++;
    }

    private void ensureDepthExists(int depth) {
      while (depth > nodesAtDepths.size()) {
        nodesAtDepths.add(new ArrayList<>());
      }
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

    public static Comparator<TreeNode> MakeAlphabeticComparator() {
      return new TreeNode.AlphabeticComparator();
    }
  }

  /**
   * Parse a Zookeeper snapshot file to DataTree.
   *
   * @param file the snapshot file
   * @return the deserialized data tree
   * @throws Exception if the snapshot cannot be read
   */
  private static DataTree getSnapshot(File file) throws Exception {
    DataTree dataTree = new DataTree();
    Map<Long, Integer> sessions = new HashMap<>();
    CheckedInputStream snapIS = SnapStream.getInputStream(file);

    long beginning = System.nanoTime();
    InputArchive inputArchive = BinaryInputArchive.getArchive(snapIS);
    FileSnap.deserialize(dataTree, sessions, inputArchive);
    long end = System.nanoTime();

    System.out.println(String.format(
            "Deserialized snapshot in %s in %f seconds",
            file.getName(),
            toSeconds(beginning, end)));

    return dataTree;
  }

  private static double toSeconds(long beginning, long end) {
    return (((double) (end - beginning) / 1000000)) / 1000;
  }

  private static void printThresholdInfo(
          int byteThreshold,
          int nodeThreshold) {

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
          boolean interactive) {

    int maxDepth = Math.max(
            left.nodesAtDepths.size(),
            right.nodesAtDepths.size());

    if (interactive) {
      compareTreesInteractively(
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
          boolean debug) {

    printThresholdInfo(byteThreshold, nodeThreshold);

    for (int depth = 0; depth < maxDepth; depth++) {
      System.out.println(String.format(
              "Analysis for depth %d",
              depth));

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

  private static void compareTreesInteractively(
          TreeInfo left,
          TreeInfo right,
          int maxDepth,
          int byteThreshold,
          int nodeThreshold,
          boolean debug) {

    Scanner scanner = new Scanner(System.in);
    int currentDepth = 0;

    while (currentDepth < maxDepth) {
      printInteractivePrompt(currentDepth);
      String input = scanner.nextLine();
      printThresholdInfo(byteThreshold, nodeThreshold);

      if (input.isEmpty()) {
        compareInteractiveDepth(
                left,
                right,
                currentDepth,
                byteThreshold,
                nodeThreshold,
                debug);
        currentDepth++;
      } else if (input.startsWith("/")) {
        compareInteractiveSubtree(
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

  private static void compareInteractiveDepth(
          TreeInfo left,
          TreeInfo right,
          int depth,
          int byteThreshold,
          int nodeThreshold,
          boolean debug) {

    System.out.println(String.format(
            "Analysis for depth %d",
            depth));

    compareLine(
            left,
            right,
            depth,
            byteThreshold,
            nodeThreshold,
            debug,
            true);
  }

  private static void compareInteractiveSubtree(
          TreeInfo left,
          TreeInfo right,
          String path,
          int byteThreshold,
          int nodeThreshold,
          boolean debug) {

    System.out.println(String.format(
            "Analysis for node %s",
            path));

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
          boolean debug) {

    try {
      int requestedDepth = Integer.parseInt(input);

      if (requestedDepth < 0 || requestedDepth >= maxDepth) {
        System.out.println(String.format(
                "Depth must be in range [%d, %d]",
                0,
                maxDepth - 1));
        return currentDepth;
      }

      compareInteractiveDepth(
              left,
              right,
              requestedDepth,
              byteThreshold,
              nodeThreshold,
              debug);

      return requestedDepth;
    } catch (NumberFormatException ex) {
      System.out.println(String.format(
              "Input %s is not valid. Depth must be in range [%d, %d]. "
                      + "Path must be an absolute path which starts with '/'.",
              input,
              0,
              maxDepth - 1));

      return currentDepth;
    }
  }

  private static void compareSubtree(
          TreeInfo left,
          TreeInfo right,
          String path,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

    TreeInfo.TreeNode leftRoot = left.nodesByName.get(path);
    TreeInfo.TreeNode rightRoot = right.nodesByName.get(path);

    List<TreeInfo.TreeNode> leftChildren =
            leftRoot == null
                    ? new ArrayList<TreeInfo.TreeNode>()
                    : leftRoot.children;

    List<TreeInfo.TreeNode> rightChildren =
            rightRoot == null
                    ? new ArrayList<TreeInfo.TreeNode>()
                    : rightRoot.children;

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

  /**
   * Compare left tree and right tree at the same depth.
   *
   * @param left the left data tree
   * @param right the right data tree
   * @param depth the depth of the data tree to be compared at
   * @param byteThreshold the node data delta size threshold, in bytes, for
   *     printing the node
   * @param nodeThreshold the descendant node delta size threshold, in nodes,
   *     for printing the node
   * @param debug if true, print more detailed debug information
   * @param interactive if true, enter interactive mode
   */
  private static void compareLine(
          TreeInfo left,
          TreeInfo right,
          int depth,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

    List<TreeInfo.TreeNode> leftNodes =
            getNodesAtDepth(left, depth);

    List<TreeInfo.TreeNode> rightNodes =
            getNodesAtDepth(right, depth);

    compareNodes(
            leftNodes,
            rightNodes,
            byteThreshold,
            nodeThreshold,
            debug,
            interactive);
  }

  private static List<TreeInfo.TreeNode> getNodesAtDepth(
          TreeInfo tree,
          int depth) {

    return depth >= tree.nodesAtDepths.size()
            ? new ArrayList<TreeInfo.TreeNode>()
            : tree.nodesAtDepths.get(depth);
  }

  private static void compareNodes(
          List<TreeInfo.TreeNode> leftList,
          List<TreeInfo.TreeNode> rightList,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

    Comparator<TreeInfo.TreeNode> comparator =
            TreeInfo.MakeAlphabeticComparator();

    Collections.sort(leftList, comparator);
    Collections.sort(rightList, comparator);

    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < leftList.size()
            || rightIndex < rightList.size()) {

      if (leftIndex >= leftList.size()) {
        printRightOnly(
                rightList.get(rightIndex),
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
        rightIndex++;
        continue;
      }

      if (rightIndex >= rightList.size()) {
        printLeftOnly(
                leftList.get(leftIndex),
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
        leftIndex++;
        continue;
      }

      TreeInfo.TreeNode leftNode = leftList.get(leftIndex);
      TreeInfo.TreeNode rightNode = rightList.get(rightIndex);

      if (debug) {
        System.out.println(String.format(
                "Comparing %s to %s",
                leftNode.label,
                rightNode.label));
      }

      int comparison = leftNode.label.compareTo(rightNode.label);

      if (comparison < 0) {
        if (debug) {
          System.out.println("left is less");
        }

        printLeftOnly(
                leftNode,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
        leftIndex++;
      } else if (comparison > 0) {
        if (debug) {
          System.out.println("right is less");
        }

        printRightOnly(
                rightNode,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
        rightIndex++;
      } else {
        if (debug) {
          System.out.println("same");
        }

        printBoth(
                leftNode,
                rightNode,
                byteThreshold,
                nodeThreshold,
                debug,
                interactive);
        leftIndex++;
        rightIndex++;
      }
    }
  }

  static void printLeftOnly(
          TreeInfo.TreeNode node,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

    printSingleTreeNode(
            node,
            byteThreshold,
            nodeThreshold,
            debug,
            interactive,
            "left");
  }

  static void printRightOnly(
          TreeInfo.TreeNode node,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

    printSingleTreeNode(
            node,
            byteThreshold,
            nodeThreshold,
            debug,
            interactive,
            "right");
  }

  private static void printSingleTreeNode(
          TreeInfo.TreeNode node,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive,
          String treeName) {

    if (exceedsThreshold(node, byteThreshold, nodeThreshold)) {
      StringBuilder builder = new StringBuilder();
      builder.append(String.format(
              "Node %s found only in %s tree. ",
              node.label,
              treeName));
      printNode(node, builder);
      System.out.println(builder.toString());
    } else if (debug || interactive) {
      System.out.println(String.format(
              "Filtered %s node %s of size %d",
              treeName,
              node.label,
              node.descendantSize));
    }
  }

  private static boolean exceedsThreshold(
          TreeInfo.TreeNode node,
          int byteThreshold,
          int nodeThreshold) {

    return node.descendantSize > byteThreshold
            || node.descendantCount > nodeThreshold;
  }

  static void printBoth(
          TreeInfo.TreeNode leftNode,
          TreeInfo.TreeNode rightNode,
          int byteThreshold,
          int nodeThreshold,
          boolean debug,
          boolean interactive) {

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
          StringBuilder builder) {

    builder.append(String.format(
            "Descendant size: %d. Descendant count: %d",
            node.descendantSize,
            node.descendantCount));
  }
}
package com.qhy.insist.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/3 11:53 AM
 * @Description [Hard]   Topics: [Tree Depth-first-Search]  companies: [Microsoft Baidu]
 *
 * Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
    the parent-child connections. The path must contain at least one node and does not need to go through the root.

    Example 1:

    Input: [1,2,3]

     1
    / \
    2   3

    Output: 6
    Example 2:

    Input: [-10,9,20,null,null,15,7]

    -10
    / \
    9  20
      /  \
     15   7

    Output: 42
 */
public class BinaryTreeMaximumPathSum_124 {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    public int maxPathDown(TreeNode node) {
        if (null == node)
            return 0;
        int left = Math.max(0,maxPathDown(node.left));
        int right = Math.max(0,maxPathDown(node.right));
        /**
         * maxValue is the value which recording whether this current root is the final root, so we use
         * left + right + node.val. But to the upper layer(after return statement), we cannot choose both left and right
         * brunches, so we need to select the larger one, so we use max(left, right) + node.val to prune the lower brunch.
         */
        maxValue = Math.max(maxValue, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}

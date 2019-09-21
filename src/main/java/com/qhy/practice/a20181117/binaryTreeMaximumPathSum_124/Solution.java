package com.qhy.practice.a20181117.binaryTreeMaximumPathSum_124;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

/**
 * Created by dream on 2018/11/19.
 *
 * Given a binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node to
 any node in the tree along the parent-child connections. The path must contain at least
 one node and does not need to go through the root.

 For example:
     Given the below binary tree,
     1 /\ 23
     Return 6.
 Companies
    Microsoft Baidu
 Topics
    Tree Depth-ThreeSum Search
 */
public class Solution {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    public int maxPathDown(TreeNode node) {
        if (null == node)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0,maxPathDown(node.right));
        maxValue = Math.max(maxValue, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}

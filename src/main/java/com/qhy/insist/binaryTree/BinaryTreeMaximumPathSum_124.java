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
    public int maxPathSum(TreeNode root) {
        if (null == root)
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        TreeNode cur = root;
        while (null != root || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
    }
}

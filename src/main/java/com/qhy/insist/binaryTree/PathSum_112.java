package com.qhy.insist.binaryTree;

import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/9 10:39 PM
 * @Description [Easy]   Topics: [Tree Depth-first Search]  companies: [Microsoft]
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

     5
    / \
    4   8
    /   / \
   11 13  4
  / \      \
  7 2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root)
            return false;
        if (null == root.left && null == root.right)
            return sum == root.val;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    //迭代法
    public boolean hasPathSum_iter(TreeNode root, int target) {
        if (null == root)
            return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (null == node.left && null == node.right && target == node.val)
                return true;
            if (null != node.left) {
                node.left.val += node.val;
                stack.push(node.left);
            }
            if (null != node.right) {
                node.right.val += node.val;
                stack.push(node.right);
            }
        }
        return false;
    }
}

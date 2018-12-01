package com.qhy.practice.a20181027.balancedBinaryTree_110;

/**
 * Created by dream on 2018/10/29.
 *
 *
 Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as a binary tree in which
 the depth of the two subtrees of every node never differ by more than 1.
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (null == root)
            return true;
        if (root.left == null && root.right == null)
            return true;
        return Math.abs(depth(root.left)-depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (null == root)
            return 0;
        return Math.max(depth(root.left), depth(root.right));
    }

}

package com.qhy.insist.nine;

/**
 * @Author houyingqi
 * @Date 2019-10-05 23:57
 * @Description [Easy] Topics: [Tree] [Depth-first Search]
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the
 * depth of the two subtrees of every node never differ by more than 1
 **/
public class Balanced_Binary_Tree_110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBlanced(TreeNode root) {
        if (null == root)
            return true;
        return Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1 && isBlanced(root.left) && isBlanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (null == node)
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right))+1;
    }

}

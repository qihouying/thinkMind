package com.qhy.practice.a20181108.binaryTreeUpSideDown_156;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

/**
 * Created by dream on 2018/11/13.
 */
public class Solution2 {
    public TreeNode sideDown(TreeNode root) {
        if (null == root || null == root.left && null == root.right) {
            return root;
        }
        TreeNode newRoot = sideDown(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.sideDown(treeNode).val);
    }
}

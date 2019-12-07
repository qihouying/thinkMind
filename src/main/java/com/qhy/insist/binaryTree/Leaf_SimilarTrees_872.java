package com.qhy.insist.binaryTree;

import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/26 7:41 AM
 * @Description [Easy]   Topics: [Tree] [Depth-first-Search]  companies: []
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



    Note:

    Both of the given trees will have between 1 and 100 nodes.
 */
public class Leaf_SimilarTrees_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2))
                return false;
        }
        return s2.isEmpty() && s2.isEmpty();
    }

    public int dfs(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null == node.left && null == node.right)
                return node.val;
        }
    }
}

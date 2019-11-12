package com.qhy.insist.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/11/12 8:27 AM
 * @Description [Medium]   Topics: [Tree Stack]  companies: []
 *
 *Given a binary tree, return the preorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
    1
    \
    2
    /
    3

    Output: [1,2,3]
    Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (null == root)
            return result;
        TreeNode p = root;
        while (!stack.isEmpty() || null != p) {
            if (null != p) {
                result.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }
}

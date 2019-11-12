package com.qhy.insist.binaryTree;

import java.util.*;

/**
 * @Author dream
 * @Date 2019/11/12 8:17 AM
 * @Description [Hard]   Topics: [Tree Stack]  companies: []
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
    1
    \
    2
    /
    3

    Output: [3,2,1]
    Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || null != p) {
            if (null != p) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
}

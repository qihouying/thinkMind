package com.qhy.insist.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/3 10:25 AM
 * @Description [Medium]   Topics: [Hash Table Stack Tree]  companies: [Microsoft]
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
    1
    \
    2
    /
    3

    Output: [1,3,2]
    Follow up: Recursive solution is trivial, could you do it iteratively?


 */
public class BinaryTreeInorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}

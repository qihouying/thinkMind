package com.qhy.practice.a20181107.BinaryTreePostOrdertraversal_145;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2018/11/8.
 *
 * Given a binary tree, return the postorder traversal of its nodes' values. For example:
     Given binary tree {1,#,2,3},
     1 \
     2 /
     3
     return [3,2,1].
     Note: Recursive solution is trivial, could you do it iteratively?
     Companies Topics
     Stack Tree

 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while(!stack.isEmpty() || null != p) {
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(treeNode));
    }
}

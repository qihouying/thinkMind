package com.qhy.practice.a20181107.binaryTreePreOrderTraversal_144;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.*;

/**
 * Created by dream on 2018/11/8.
 *
 * Given a binary tree, return the preorder traversal of its nodes' values. For example:
     Given binary tree [1,null,2,3],
     1 \
     2 /
     3
     return [1,2,3].
     Note: Recursive solution is trivial, could you do it iteratively?
     Companies Topics
     Stack Tree

 */
public class Solution {
    public List<Integer> binaryTreePreOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;

        while(!stack.isEmpty() || null != p) {
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePreOrderTraversal(treeNode));
    }
}

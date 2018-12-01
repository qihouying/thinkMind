package com.qhy.practice.a20181120.closestBinarySearchTreeValueII_272;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dream on 2018/11/14.
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 Note:
     Given target value is a floating point.
     You may assume k is always valid, that is: k ≤ total nodes.
     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 Follow up:
    Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 Companies
    Google
 Topics
    Stack Tree

 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        inorder(root, target, false, s1);
        inorder(root, target, true, s2);

        while (k-- > 0) {
            if (s1.isEmpty()) {
                result.add(s2.pop());
            } else if (s2.isEmpty()) {
                result.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() -  target)) {
                result.add(s1.pop());
            } else {
                result.add(s2.pop());
            }
        }
        return result;
    }

    public void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if (null == root)
            return;

        inorder(reverse ? root.right : root.left, target, reverse, stack);
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }
}

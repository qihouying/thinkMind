package com.qhy.insist.binaryTree;

import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/23 8:21 AM
 * @Description [Medium]   Topics: [Binary Search] [Tree]  companies: []
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
     3
    / \
    1   4
    \
    2
    Output: 1
    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
     5
    / \
    3   6
    / \
    2   4
    /
    1
    Output: 3
    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How
    would you optimize the kthSmallest routine?


 */
public class KthSmallestElementInABST_230 {

    int count = 1;
    int target = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return target;
    }

    public boolean inOrder(TreeNode root, int k) {
        if (null == root || k <= 0)
            return false;
        if (inOrder(root.left, k))
            return true;
        if (count == k) {
            target = root.val;
            return true;
        }
        count++;
        return inOrder(root.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        if (null == root || k <= 0)
            return Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while (null != p || !stack.isEmpty()) {
            if (null != p) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                if (++count == k)
                    return node.val;
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}

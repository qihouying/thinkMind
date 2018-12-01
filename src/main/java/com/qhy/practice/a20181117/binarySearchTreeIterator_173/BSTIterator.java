package com.qhy.practice.a20181117.binarySearchTreeIterator_173;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.Stack;

/**
 * Created by dream on 2018/11/19.
 *
 * Binary Search Tree Iterator
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with
 the root node of a BST.

 Calling next() will return the next smallest number in the BST.
 Note: next() and hasNext() should run in average O(1) time and uses O(h)
 memory, where h is the height of the tree.
 Credits:
 Special thanks to @ts for adding this problem and creating all test cases
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        putAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode treeNode = stack.pop();
        putAll(treeNode.right);
        return treeNode.val;
    }

    public void putAll(TreeNode node) {
        while(null != node) {
            stack.push(node);
            node = node.left;
        }
    }
}

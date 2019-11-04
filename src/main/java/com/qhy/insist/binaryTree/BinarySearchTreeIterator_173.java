package com.qhy.insist.binaryTree;

import java.util.Stack;

/**
 * @Author dream
 * @Date 2019/11/3 10:03 AM
 * @Description [Medium]   Topics: [Stack Tree Design]  companies: [Google Facebook Microsoft LinkedIn]
 *
 *Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.


    Example:

    BSTIterator iterator = new BSTIterator(root);
    iterator.next();    // return 3
    iterator.next();    // return 7
    iterator.hasNext(); // return true
    iterator.next();    // return 9
    iterator.hasNext(); // return true
    iterator.next();    // return 15
    iterator.hasNext(); // return true
    iterator.next();    // return 20
    iterator.hasNext(); // return false

    Note:

    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the
    BST when next() is called.
 */
public class BinarySearchTreeIterator_173 {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BinarySearchTreeIterator_173(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    }


}

package com.qhy.insist.binaryTree;

/**
 * @Author dream
 * @Date 2019/11/22 6:59 AM
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
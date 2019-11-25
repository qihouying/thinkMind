package com.qhy.insist.binaryTree;

/**
 * @Author dream
 * @Date 2019/11/22 6:43 AM
 * @Description [Medium]   Topics: [Tree]  companies: [Depth-first Search]
 *
 * Given a binary tree

    struct Node {
    int val;
    Node *left;
    Node *right;
    Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
    be set to NULL.

    Initially, all next pointers are set to NULL.



    Example:



    Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":
    {"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,
    "right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

    Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5",
    "left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,
    "next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its
    next right node, just like in Figure B.


    Note:

    You may only use constant extra space.
    Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersinEachNodeII_117 {
    public void connect(Node root) {
        if (null == root)
            return;
        if (null != root.left) {
            root.left.next = root.right;
            if (null != root.next) {
                root.right.next = root.next.left == null ? root.next.right : root.next.left;
            } else {
                root.right.next = root.next;
            }
        } else if (null != root.right) {
            if (null != root.next) {
                root.right.next = root.next.left == null ? root.next.right : root.next.left;
            } else {
                root.right.next = root.next;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    public void connect2(Node root) {
        Node head = null;
        Node pre = null;
        Node cur = root;

        while (null != cur) {
            while (null != cur) {
                //left
                if (null != cur.left) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (null != cur.right) {
                    if (null != pre) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            //move to next level
            cur = head;
            head = null;
            pre = null;
        }
    }
}

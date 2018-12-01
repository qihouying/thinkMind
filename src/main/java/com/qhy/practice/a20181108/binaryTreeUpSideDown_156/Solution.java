package com.qhy.practice.a20181108.binaryTreeUpSideDown_156;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

/**
 * Created by dream on 2018/11/9.
 *
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
     For example:
         Given a binary tree {1,2,3,4,5},
         1 /\ 23
         /\ 45
         return the root of the binary tree [4,5,2,#,#,3,1].
         4 /\ 52
         /\ 31
         OJ's Binary T ree Serialization:
         The serialization of a binary tree follows a level order traversal, where '#' signifies a
         path terminator where no node exists below.

     Here's an example:
         1 /\ 23
         / 4
         \ 5
         The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}" . Companies
         LinkedIn
         Topics Tree
 */
public class Solution {
    public TreeNode sideDown(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode temp = null;
        while (null != curr) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.sideDown(treeNode).val);
    }

}


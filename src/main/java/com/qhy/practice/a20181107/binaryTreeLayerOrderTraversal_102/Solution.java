package com.qhy.practice.a20181107.binaryTreeLayerOrderTraversal_102;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dream on 2018/11/8.
 *
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     For example:
     Given binary tree {3,9,20,#,#,15,7} ,
     3 /\ 9 20
     /\ 15 7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7] ]
     confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
     OJ's Binary Tree Serialization:
     The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
     Here's an example:
     1 /\ 23
     / 4
     \ 5
     The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}" .

 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (null == root)
            return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(treeNode));
    }
}

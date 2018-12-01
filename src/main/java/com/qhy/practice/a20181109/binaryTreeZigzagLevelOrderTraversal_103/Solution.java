package com.qhy.practice.a20181109.binaryTreeZigzagLevelOrderTraversal_103;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2018/11/9.
 *
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
     For example:
         Given binary tree [3,9,20,null,null,15,7],
             3 /\ 9 20
             /\ 15 7
        return its zigzag level order traversal as:
             [
             [3],
             [20,9],
             [15,7] ]
     Companies
        Microsoft Bloomberg
     LinkedIn Stack Tree Breadth-first Search
     Topics

 */
public class Solution {
    public List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }

    public void travel(TreeNode node, List<List<Integer>> list, int level) {
        if (null == node)
            return;
        if (list.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            list.add(newLevel);
        }

        List<Integer> collection = list.get(level);
        if (level % 2 == 0) {
            collection.add(node.val);
        } else {
            collection.add(0, node.val);
        }
        travel(node.left, list, level+1);
        travel(node.right, list, level +1);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.zigZagLevelOrderTraversal(treeNode));
    }

}


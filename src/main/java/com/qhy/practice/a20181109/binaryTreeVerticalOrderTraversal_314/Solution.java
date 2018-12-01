package com.qhy.practice.a20181109.binaryTreeVerticalOrderTraversal_314;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.*;

/**
 * Created by dream on 2018/11/9.
 *
 * Given a binary tree, return the vertical order traversal of its nodes' values.
 * (ie, from top to bottom, column by column).
 If two nodes are in the same row and column, the order should be from left to right . Examples:
 1. Given binary tree [3,9,20,null,null,15,7],
     3 /\
     /\ 9 20 /\
     /\ 15 7
 return its vertical order traversal as:
     [
     [9],
     [3,15],
     [20],
     [7]
     ]
 2. Given binary tree [3,9,8,4,0,1,7],
     3 /\
     /\
     98 /\ /\
     / \/ \ 4 01 7

 return its vertical order traversal as:
     [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
     ]
 3. Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's
 left child is 5),
     3 /\
     /\
     98 /\ /\
     / \/ \ 4 01 7
     /\ /\
     52
 return its vertical order traversal as:
     [
     [4],
     [9,5],
     [3,0,1],
     [8,2],
     [7]
     ]
 Companies
 Google Facebook Snapchat
 Topics

 Hash Table
 */
public class Solution {
    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root)
            return result;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = 0, max = 0;
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (null != node.left) {
                queue.add(node.left);
                cols.add(col-1);
                if (col <= min) {
                    min = col-1;
                }
            }
            if (null != node.right) {
                queue.add(node.right);
                cols.add(col+1);
                if (col >= max) {
                    max = col +1;
                }
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.verticalOrderTraversal(treeNode));
    }
}

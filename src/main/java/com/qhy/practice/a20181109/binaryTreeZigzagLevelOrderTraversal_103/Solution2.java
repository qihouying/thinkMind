package com.qhy.practice.a20181109.binaryTreeZigzagLevelOrderTraversal_103;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dream on 2018/11/13.
 */
public class Solution2 {
    public List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root ) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;
        int size = 1;

        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    tmp.add(node.val);
                } else {
                    tmp.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmp);
            size = queue.size();
            order = order ? false : true;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);


        Solution2 solution2 = new Solution2();
        System.out.println(solution2.zigZagLevelOrderTraversal(treeNode));
    }
}

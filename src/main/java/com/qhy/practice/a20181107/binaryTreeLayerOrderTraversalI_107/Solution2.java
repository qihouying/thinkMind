package com.qhy.practice.a20181107.binaryTreeLayerOrderTraversalI_107;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.*;

/**
 * Created by dream on 2018/11/9.
 *
 *  DFS solution
 */
public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p = root;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                subList.add(node.val);
            }
            result.addFirst(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        Solution2 solution = new Solution2();
        System.out.println(solution.levelOrderBottom(treeNode));
    }
}

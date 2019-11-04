package com.qhy.insist.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author dream
 * @Date 2019/11/3 10:40 AM
 * @Description [Medium]   Topics: [Tree Breadth-first Search]  companies: []
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
    3
    / \
    9  20
    /  \
    15   7
    return its level order traversal as:
    [
    [3],
    [9,20],
    [15,7]
    ]
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (null == root)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<Integer>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.peek();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;

    }

    //DFS solution
    public List<List<Integer>> levelOrderBottom2(TreeNode root){
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        helper(result, root, 0);
        return result;
    }
    public void helper( List<List<Integer>> result, TreeNode node, int level) {
        if (null == node)
            return;
        if (level >= result.size()) {
            result.add(new LinkedList<Integer>());
        }
        result.get(level).add(node.val);
        helper(result, node.left, level+1);
        helper(result, node.right, level+1);
    }
}

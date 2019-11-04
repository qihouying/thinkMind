package com.qhy.insist.dynamicPrograming.class_01;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/10/29 12:37 PM
 * @Description [Medium]   Topics: [Tree]  [Depth-first Search]
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the
 * given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

5
/ \
4   8
/   / \
11  13  4
/  \    / \
7    2  5   1
Return:

[
[5,4,11,2],
[5,8,4,5]
]
 */
public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        pathSum(root, target, cur, result);
        return result;
    }

    private void pathSum(TreeNode node, int target, List<Integer> cur, List<List<Integer>> result) {
        if (null == node)
            return;
        cur.add(new Integer(node.val));
        if (null == node.left && null == node.right && target == node.val) {
            result.add(new LinkedList(cur));
        }
        pathSum(node.left, target-node.val, cur, result);
        pathSum(node.right, target-node.val, cur, result);
        cur.remove(cur.size()-1);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

}

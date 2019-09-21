package com.qhy.practice.a20181108.binaryTreeRightSideView_199;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2018/11/9.
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
     For example:
     Given the following binary tree,
     1 <--- /\
     2 3 <--- \\
     5 4 <--- You should return [1, 3, 4].
     Companies Amazon
     Topics
     Tree Depth-ThreeSum Search Breadth-ThreeSum Search
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode node, List<Integer> result, int curDepth) {
        if (null == node)
            return;
        if (result.size() == curDepth) {
            result.add(node.val);
        }
        rightView(node.right, result, curDepth+1);
        rightView(node.left, result, curDepth+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.rightSideView(treeNode));
    }
}

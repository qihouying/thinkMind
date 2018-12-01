package com.qhy.practice.a20181107.BinaryTreePaths_257;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2018/11/8.
 *
 * 257. Binary Tree Paths (Easy)
     Given a binary tree, return all root-to-leaf paths. For example, given the following binary tree:
     1 /\ 23
     \ 5
     All root-to-leaf paths are:
     ["1->2->5", "1->3"]
     Companies
     Google Facebook Apple
     Topics
     Tree Depth-first Search

 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (null != root) {
            searchBT(root, "", result);
        }
        return result;
    }
    public void searchBT(TreeNode root, String path, List<String> result) {
        if (null == root.left && null == root.right) {
            result.add(path+root.val);
        }
        if (null != root.left) {
            searchBT(root.left, path+root.val+"->", result);
        }
        if (null != root.right) {
            searchBT(root.right, path+root.val+"->", result);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(treeNode));
    }
}

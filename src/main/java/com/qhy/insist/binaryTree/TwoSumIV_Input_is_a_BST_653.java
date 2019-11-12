package com.qhy.insist.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/11/12 7:33 AM
 * @Description [Easy]   Topics: [Tree]  companies: []
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their
 * sum is equal to the given target.

    Example 1:

    Input:
    5
    / \
    3   6
    / \   \
    2   4   7

    Target = 9

    Output: True


    Example 2:

    Input:
    5
    / \
    3   6
    / \   \
    2   4   7

    Target = 28

    Output: False
 */
public class TwoSumIV_Input_is_a_BST_653 {
    /**
     * 由于输入是一棵二叉搜索树，那么我们可以先用中序遍历得到一个有序数组，然后在有序数组中找两数之和就很简单了，直接用双指针进行遍历即可
     */
    public boolean findTarget(TreeNode root, int k) {
        if (null == root)
            return false;
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        for (int i = 0, j = nums.size()-1; i < j;) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public void inorder(TreeNode node, List<Integer> nums) {
        if (null == node)
            return;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }

}

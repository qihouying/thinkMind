package com.qhy.practice.a20181120.closestBinarySearchTreeValueII_272;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2018/11/22.
 */
public class Solution1 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        closetKValuesHelper(list, root, target, k);
        return list;
    }

    private boolean closetKValuesHelper(LinkedList<Integer> list, TreeNode root, double target, int k) {
        if (null == root)
            return false;

        if (closetKValuesHelper(list, root.left, target, k)) {
            return true;
        }

        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return true;
            } else {
                list.removeFirst();
            }
        }
        list.addLast(root.val);
        return closetKValuesHelper(list, root.right, target, k);
    }
}

package com.qhy.practice_01.ReversePairs;

/**
 * Created by dream on 2018/10/21.
 */
public class Solution {
    public int reversePairs(int[] nums) {
        TreeNode head = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = search(head, 2*nums[i]+1);
            head = insert(head, nums[i]);
        }
        return count;
    }

    public int search(TreeNode head, int target) {
        if (null == head)
            return 0;
        else if (target == head.val) {
            return head.count;
        } else if (target < head.val) {
            return head.count + search(head.left, target);
        } else {
            return search(head.right, target);
        }
    }

    public TreeNode insert(TreeNode head, int val) {
        if (null == head) {
            return new TreeNode(val);
        } else if (val == head.val) {
            head.count++;
        } else if (val > head.val) {
            head.count++;
            head.right = insert(head.right, val);
        } else {
            head.left = insert(head.left, val);
        }
        return head;
    }

    private class TreeNode{
        private int count;
        private TreeNode left;
        private TreeNode right;
        private int val;

        private TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.count = 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};

        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
    }
}

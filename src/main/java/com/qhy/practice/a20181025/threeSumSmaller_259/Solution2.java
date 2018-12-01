package com.qhy.practice.a20181025.threeSumSmaller_259;

/**
 * Desc: leetcode259
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 that satisfy the
 * condition nums[i] + nums[j] + nums[k] .
 For example, given nums = [-2, 0, 1, 3] , and target = 2. Return 2. Because there are two triplets which sums are less than 2:
 [-2, 0, 1]
 [-2, 0, 3]
 Follow up:
 Could you solve it in O(n2) runtime?

 * O(n^2)
 * author: qihouying@meituan.com
 * Date:   10 25, 2018 22:29
 */
public class Solution2 {
    public int threeSumSmaller(int[] nums, int target) {
        if (null == nums || 3 > nums.length)
            return 0;
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int left = i+1, right = len-1;
            while (left < right) {
                if (nums[i]+nums[left]+nums[right] < target) {
                    count = right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.threeSumSmaller(nums, 2));
    }
}

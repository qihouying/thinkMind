package com.qhy.practice.a20181025.threeSumSmaller_259;

import java.util.Arrays;

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

 O(n^3)
 * author: qihouying@meituan.com
 * Date:   10 25, 2018 21:39
 */
public class Solution1 {
    public int threeSumSmaller(int[] nums, int target) {
        if (null == nums || 3 > nums.length)
            return 0;
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int start = i+1, end = len-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                while(start < end && sum >= target) {
                    end--;
                }
                while(start < end && sum < target) {
                    start++;
                    count++;
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

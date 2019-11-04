package com.qhy.practice.a20190215.threeSumClosest_16;

import java.util.Arrays;

/**
 * Created by dream on 2019/2/15.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Companies
    Bloomberg
 Topics
    Array Two Pointers

 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || 3 > nums.length)
            return 0;
        Arrays.sort(nums);
        int m = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int s = nums[i] + nums[left] + nums[right];
                if (Math.abs(m-target) > Math.abs(s-target)) {
                    m = s;
                }
                if (s > target) {
                    right--;
                } else if (s < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }
}

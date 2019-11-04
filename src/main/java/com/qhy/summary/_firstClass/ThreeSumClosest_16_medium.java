package com.qhy.summary._firstClass;

import java.util.Arrays;

/**
 * Created by dream on 2019/2/24.
 *
 * 16. 3Sum Closest (Medium)
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 Companies Bloomberg
 Topics
 Array Two Pointers

 *
 *
 */
public class ThreeSumClosest_16_medium {
    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(result-target) > Math.abs(sum-target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        ThreeSumClosest_16_medium threeSumClosest_16_medium = new ThreeSumClosest_16_medium();
        System.out.println(threeSumClosest_16_medium.threeSumClosest(nums, 1));
    }
}

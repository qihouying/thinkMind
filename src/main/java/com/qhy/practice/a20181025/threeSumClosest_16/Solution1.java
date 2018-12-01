package com.qhy.practice.a20181025.threeSumClosest_16;

import java.util.Arrays;

/**
 * Desc: leetcode 16
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
     For example, given array S = {-1 2 1 -4}, and target = 1.
     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * author: qihouying@meituan.com
 * Date:   10 25, 2018 14:04
 */
public class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if (null == nums || 3 > nums.length)
            return 0;
        int len = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[len-1];
        for (int i = 0; i < len-2; i++) {
            int start = i+1, end = len-1;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (target == sum) {
                    return sum;
                }
                if (Math.abs(target-result) > Math.abs(target-sum)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.threeSumClosest(nums, target));
    }
}

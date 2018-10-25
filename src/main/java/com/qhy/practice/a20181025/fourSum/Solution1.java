package com.qhy.practice.a20181025.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc:
 *
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
    Note:
        Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
        The solution set must not contain duplicate quadruplets.
         For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
         A solution set is:
             (-1,  0, 0, 1)
             (-2, -1, 1, 2)
             (-2,  0, 0, 2)

 * author: qihouying@meituan.com
 * Date:   10 25, 2018 22:36
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4)
            return result;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int targetThree = target-nums[i];
            
        }
    }

    public List<List<Integer>> threeSum(int[] nums, int left, int tar) {
        List<List<Integer>> elements = new ArrayList<>();
        if (null == nums || 3 > nums.length)
            return elements;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = left; i < len; i++) {

            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = tar - nums[i];
            int start = i+1, end = len-1;
            while (start < end) {
                if (target == nums[start] + nums[end]) {
                    elements.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start > i+1 && start < end && nums[start] == nums[start-1]) {
                        start++;
                    }
                    while (end < len-1 && start < end && nums[end] == nums[end+1]) {
                        end--;
                    }
                } else if (target > nums[start] + nums[end]) {
                    start++;
                } else {
                    end--;
                }

            }
        }
        return elements;
}

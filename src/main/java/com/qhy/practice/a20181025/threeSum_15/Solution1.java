package com.qhy.practice.a20181025.threeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Desc: leetcode 15
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 Note:
     Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     The solution set must not contain duplicate triplets.

     For example,
        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
         [
             [-1, 0, 1],
             [-1, -1, 2]
         ]

 * author: qihouying@meituan.com
 * Date:   10 25, 2018 13:12
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> elements = new ArrayList<>();
        if (null == nums || 3 > nums.length)
            return elements;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {

            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int target = 0 - nums[i];
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

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.threeSum(nums));
    }
}

package com.qhy.insist.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author houyingqi
 * @Date 2019-09-21 14:44
 * @Description  [medium] Topics: [Array] [Two Pointers]
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 **/
public class ThreeSum_15 {
    public static List<List<Integer>> method1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(ThreeSum_15.method1(nums, 0));
    }
}

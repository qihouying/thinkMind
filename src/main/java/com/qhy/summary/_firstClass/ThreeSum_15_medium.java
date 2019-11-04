package com.qhy.summary._firstClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2019/3/2.
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 Note: The solution set must not contain duplicate triplets.

 For example,
     given array S = [-1, 0, 1, 2, -1, -4],
     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2] ]
 Companies
    Facebook Microsoft Amazon Bloomberg Adobe Works Applications
 Topics
    Array Two Pointers

 */
public class ThreeSum_15_medium {
    public List<List<Integer>> threeSum(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    while ((left < right && nums[left] == nums[left+1])) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum_15_medium threeSum_15_medium = new ThreeSum_15_medium();
        System.out.println(threeSum_15_medium.threeSum(nums, 0));
    }
}

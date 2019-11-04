package com.qhy.practice.a20181121.combinationSumIV_377;

import java.util.Arrays;

/**
 * Created by dream on 2018/11/26.
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible
 * combinations that add up to a positive integer target.
 Example:
     nums = [1, 2, 3]
     target = 4
     The possible combination ways are:
     (1, 1, 1, 1)
     (1, 1, 2)
     (1, 2, 1)
     (1, 3)
     (2, 1, 1)
     (2, 2)
     (3, 1)
 Note that different sequences are counted as different combinations.
    Therefore the output is 7.

 Follow up:
 What if negative numbers are allowed in the given array?
 How does it change the problem?
 What limitation we need to add to the question to allow negative numbers?
 Companies
    Google Facebook Snapchat
 Topics
    Dynamic Programming

 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] result = new int[target+1];
        for (int i = 1; i < result.length; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    result[i] += 1;
                } else {
                    result[i] += result[i-num];
                }
            }
        }
        return result[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(nums, target));
    }

}

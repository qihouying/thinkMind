package com.qhy.insist.Array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author houyingqi
 * @Date 2019-09-21 15:42
 * @Description  [medium]  Topics: [Array] [HashTable] [Two Pointers]
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 **/
public class FourSum_18 {
    public static List<List<Integer>> method1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4)
            return result;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len-3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < len-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2] > target)
                    break;
                if (nums[i]+nums[j]+nums[len-1]+nums[len-2] < target)
                    continue;
                int m = j+1;
                int n = len-1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[m+1]) m++;
                        while (m < n && nums[n] == nums[n-1]) n--;
                        m++;
                        n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(FourSum_18.method1(nums, 0));
    }
}

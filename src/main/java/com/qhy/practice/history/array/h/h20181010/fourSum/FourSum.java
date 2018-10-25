package com.qhy.practice.history.array.h.h20181010.fourSum;

import java.util.*;

/**
 * Desc:
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 *
 * author: qihouying@meituan.com
 * Date:   10 10, 2018 17:28
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (null == nums)
            return null;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            result.addAll(threeSum(nums, i+1, target-nums[i]));
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums, int start, int target) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = start; i < nums.length-2; i++) {
            if (start > 1 && nums[start] == nums[start-1])
                continue;
            int value = target-nums[i];
            int s = i+1;
            int e = nums.length-1;
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }
            while (s < e) {
                if (value == nums[s] + nums[e]) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    list.add(nums[start-1]);
                    set.add(list);
                    s++;
                    e--;
                    while (s < e && nums[s] == nums[s-1]) {
                        s++;
                    }
                    while (s < e && nums[e] == nums[e+1]) {
                        e--;
                    }
                } else if (value > nums[s] + nums[e]) {
                    s++;
                    while(s < e && nums[s] == nums[s-1]){
                        s++;
                    }
                } else {
                    e--;
                    while(s < e && nums[e] == nums[e+1]) {
                        e--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(FourSum.fourSum(nums, 0));
    }
}

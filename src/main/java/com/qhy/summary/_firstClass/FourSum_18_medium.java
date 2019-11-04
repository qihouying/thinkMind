package com.qhy.summary._firstClass;

import java.util.*;

/**
 * Created by dream on 2019/3/2.
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 Note: The solution set must not contain duplicate quadruplets.
 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 Companies Topics
 Array Hash Table Two Pointers

 *
 */
public class FourSum_18_medium {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            result.addAll(threeSum(nums, target-nums[i], i+1, nums.length-1));
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int start, int end) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = start; i < nums.length-2; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            int left= i+1, right = end;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (target == sum) {
                    result.add(Arrays.asList(nums[start-1], nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (target > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int z = j+1; z < nums.length; z++) {
                    int threeSum = nums[i] + nums[j] + nums[z];
                    if (map.get(target-threeSum) != null) {
                        int fourNum = target - threeSum;
                        int fourthNumIndex = map.get(target-threeSum);
                        if (fourthNumIndex != i && fourthNumIndex != j && fourthNumIndex != z) {
                            List<Integer> oneResult = new ArrayList<>();
                            oneResult.add(nums[i]);
                            oneResult.add(nums[j]);
                            oneResult.add(nums[z]);
                            oneResult.add(fourNum);
                            oneResult.sort(null);
                            if (!result.contains(oneResult)) {
                                result.add(oneResult);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum_18_medium fourSum_18_medium = new FourSum_18_medium();
        System.out.println(fourSum_18_medium.fourSum(nums, 0));
        System.out.println(fourSum_18_medium.fourSum2(nums, 0));
    }
}

package com.qhy.practice.a20181025.twoSum_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc: leetcode 1
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
 * author: qihouying@meituan.com
 * Date:   10 25, 2018 22:36
 */
public class Solution1 {
    public List<Integer> twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0)
            return result;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            if (map.containsKey(diff)) {
                result.add(map.get(diff));
                result.add(i);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.twoSum(nums, 9));
    }

}

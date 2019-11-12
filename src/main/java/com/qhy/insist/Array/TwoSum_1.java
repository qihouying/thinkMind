package com.qhy.insist.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dream
 * @Date 2019/11/12 7:07 AM
 * @Description [Easy]   Topics: [Array HashMap]  companies: []
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have  exactly  one solution, and you may not use the  same  element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 *
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum_1 twoSum = new TwoSum_1();
        System.out.println(twoSum.twoSum(nums, target)[0]+ "," + twoSum.twoSum(nums, target)[1]);
    }
}

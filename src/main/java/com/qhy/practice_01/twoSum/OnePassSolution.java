package com.qhy.practice_01.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2017/9/22.
 */
public class OnePassSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int remainNum = target - nums[i];
            if (map.containsKey(remainNum))
                return new int[] {i, map.get(remainNum)};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        OnePassSolution onePassSolution = new OnePassSolution();
        System.out.println(Arrays.toString(onePassSolution.twoSum(nums, target)));
    }
}

package com.qhy.practice.a20181121.combinationSumIV_377;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2018/12/2.
 */
public class Solution2 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int combinationSum4(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        for (int num : nums) {
            count += combinationSum4(nums, target-num);
        }
        map.put(target, count);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.combinationSum4(nums, target));
    }
}

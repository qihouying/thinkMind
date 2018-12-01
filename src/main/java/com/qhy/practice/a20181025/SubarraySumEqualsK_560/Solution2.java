package com.qhy.practice.a20181025.SubarraySumEqualsK_560;

import java.util.HashMap;
import java.util.Map;

/**
 * too amazing!!!
 *
 * Created by dream on 2018/10/26.
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        if (null == nums || 0 == nums.length)
            return 0;
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {28,54,7,-70,22,65,-6};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subarraySum(nums, 100));
    }
}

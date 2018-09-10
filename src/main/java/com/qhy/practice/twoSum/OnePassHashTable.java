package com.qhy.practice.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 10, 2018 11:02
 */
public class OnePassHashTable {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int remind = target - nums[i];
            if (data.containsKey(remind) && i != data.get(remind)) {
                return new int[]{i, data.get(remind)};
            }
            data.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such sum solution");
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 2, 6};
        int target = 8;
        int[] result = OnePassHashTable.twoSum(array, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

package com.qhy.practice.history.twoSum;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 10, 2018 10:32
 */
public class BruteForce {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException(" no two sum solution");
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 5};
        int target = 9;
        int[] result = BruteForce.twoSum(array, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

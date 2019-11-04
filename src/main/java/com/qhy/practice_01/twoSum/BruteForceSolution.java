package com.qhy.practice_01.twoSum;

import java.util.Arrays;

/**
 * Created by dream on 2017/9/22.
 */
public class BruteForceSolution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++)
            for (int j = i+1; j < length; j++) {
                if (target == nums[i] + nums[j])
                    return new int[] {i, j};
            }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        System.out.println(Arrays.toString(bruteForceSolution.twoSum(nums, target)));
    }
}

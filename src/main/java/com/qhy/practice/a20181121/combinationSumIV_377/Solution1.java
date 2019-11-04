package com.qhy.practice.a20181121.combinationSumIV_377;

/**
 * Created by dream on 2018/12/2.
 */
public class Solution1 {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += combinationSum4(nums, target-nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.combinationSum4(nums, target));
    }
}

package com.qhy.insist.first;

/**
 * @Author houyingqi
 * @Date 2019-09-21 14:08
 * @Description [medium]
 * Given an array of n integers nums and a target, find the number of index triplets i, j,
 * k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] <
 * target .
 * For example, given nums = [-2, 0, 1, 3] , and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 **/
public class TreeSumSmaller_259 {
    static int errorNum = 0;

    public static int method1(int[] nums, int target) {
        if (null == nums || nums.length < 3)
            return errorNum;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    count += k-j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(TreeSumSmaller_259.method1(nums, 2));
    }
}

package com.qhy.insist.dynamicPrograming.class_05;

/**
 * @Author houyingqi
 * @Date 2019-10-04 20:42
 * @Description [Easy] Topics: [Dynamic Programming]
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 **/
public class RangeSumQuery_Immutable_303 {

    int[] sum;
    public RangeSumQuery_Immutable_303(int[] nums) {
        sum = nums;
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sum[j];
        return sum[j] - sum[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery_Immutable_303 rangeSumQuery_immutable = new RangeSumQuery_Immutable_303(nums);
        System.out.println(rangeSumQuery_immutable.sumRange(0, 2));
        System.out.println(rangeSumQuery_immutable.sumRange(2, 5));
        System.out.println(rangeSumQuery_immutable.sumRange(0, 5));
    }
}

package com.qhy.insist.dynamicPrograming.class_03;

/**
 * @Author dream
 * @Date 2019/11/3 2:13 AM
 * @Description [Easy]   Topics: [Array] [Divide and Conquer] [Dynamic Programming]
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:

    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
    is more subtle.
 *
 */
public class MaximumSubarray_53 {

    //减小空间，用两个变量代替一个数组，类似EditDistance_72中的方法3
    public int maxSubArray(int[] nums) {
        int maxSumCur = 0, maxSumSofar = 0;
        for (int i = 1; i < nums.length; i++) {
            maxSumCur = Math.max(0, maxSumCur += nums[i]);
            maxSumSofar = Math.max(maxSumCur, maxSumSofar);
        }
        return maxSumSofar;
    }

    public int maxSubArray_dp(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < m; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_53 maximumSubarray = new MaximumSubarray_53();
        System.out.println(maximumSubarray.maxSubArray(nums));
        System.out.println(maximumSubarray.maxSubArray_dp(nums));
    }
}

package com.qhy.insist.seven;

/**
 * @Author houyingqi
 * @Date 2019-10-03 20:08
 * @Description [Easy] Topics: [Array] [Divide and Conquer] [Dynamic Programming]
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 *
 *
 **/
public class MaximumSubarray_53 {

    //Method1：关键找出递推公式：maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int max = nums[0];
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];

        for (int i = 1; i < n; i++) {
            f[i] = (f[i-1] > 0 ? f[i-1] : 0) + nums[i];
            max = Math.max(max, f[i]);
        }
        return max;
    }

    //Method2：并不需要数组，只需要一个中间变量即可，更节省空间
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int sum(int[] nums, int m, int n) {
        int sum = 0;
        for (int i = m; i <=n; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_53 maximumSubarray = new MaximumSubarray_53();
        System.out.println(maximumSubarray.maxSubArray(nums));
        System.out.println(maximumSubarray.maxSubArray1(nums));
    }
}

package com.qhy.practice.a20181025.SubarraySumEqualsK_560;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** brute force
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.

     Example 1:
         Input:nums = [1,1,1], k = 2
         Output: 2
     Note:
         The length of the array is in range [1, 20,000].
         The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 * Created by dream on 2018/10/26.
 */
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0)
            return 0;
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i+1; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {28,54,7,-70,22,65,-6};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.subarraySum(nums, 100));
    }
}

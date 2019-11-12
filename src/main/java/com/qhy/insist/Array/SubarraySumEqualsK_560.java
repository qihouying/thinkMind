package com.qhy.insist.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dream
 * @Date 2019/11/12 6:41 AM
 * @Description [Medium]   Topics: [Array HashMap]  companies: []
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2

    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK_560 {

    /**
     * Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k. Time complexity O(n^2), Space
     * complexity O(1). I bet this solution will TLE.

     Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and
     SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we just need to go through the array, calculate the
     current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
     */
    public int subArraySum(int[] nums, int k) {
        if (null == nums || nums.length == 0)
            return 0;
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //just for sum == k, the count must be 1
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k) + 1;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

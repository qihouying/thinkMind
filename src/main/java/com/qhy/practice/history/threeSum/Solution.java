package com.qhy.practice.history.threeSum;

import java.util.*;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 09, 2018 10:47
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int value = -nums[i];
            int s = i+1;
            int e = nums.length-1;
            if (nums[i] == Integer.MAX_VALUE) {
                continue;
            }
            while (s < e) {
                if (value == nums[s] + nums[e]) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(value);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    set.add(list);
                    s++;
                    e--;
                } else if (value > nums[s] + nums[e]) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(Solution.threeSum(nums));
    }
}

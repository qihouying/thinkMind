package com.qhy.insist.Array.sum;

import java.util.Arrays;

/**
 * @Author houyingqi
 * @Date 2019-09-21 12:48
 * @Description [medium] Topics: [Array] [Two Pointers]
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a
 * given number, target. Return the sum of the three integers. You may assume that each
 * input would have exactly one solution.
 **/
public class ThreeSumClosed_16 {
    static int errorNum = 0;

    public static int method1(int[] s, int target) {
        if (null == s || s.length < 3)
            return errorNum;
        Arrays.sort(s);
        int result = s[0] + s[1] + s[2];
        for (int i = 0; i < s.length-2; i++) {
            //重复元素可以直接跳过
            if (i > 0 && s[i] == s[i-1])
                continue;
            int j = i+1;
            int k = s.length-1;
            while(j < k) {
                int sum = s[i] + s[j] + s[k];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
                if (target-sum == 0) {
                    return sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {-1,2,1,-4};
        System.out.println(ThreeSumClosed_16.method1(s, 1));
    }
}

package com.qhy.practice.a20181027.arithmeticSlices_413;

/**
 * Created by dream on 2018/10/29.
 */
public class Solution3 {

    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = 1+dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.numberOfArithmeticSlices(A));
    }
}

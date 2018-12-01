package com.qhy.practice.a20181027.arithmeticSlices_413;

/**
 * Created by dream on 2018/10/29.
 */
public class Solution4 {
    public int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp = 1+dp;
                count += dp;
            } else {
                dp = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.numberOfArithmeticSlices(A));
    }
}

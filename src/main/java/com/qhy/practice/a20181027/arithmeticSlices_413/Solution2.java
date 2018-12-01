package com.qhy.practice.a20181027.arithmeticSlices_413;

/**
 * Created by dream on 2018/10/29.
 */
public class Solution2 {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        slice(A, A.length-1);
        return sum;

    }
    public int slice(int[] A, int m) {
        if (m < 2)
            return 0;
        int count = 0;
        if (A[m] - A[m-1] == A[m-1] - A[m-2]) {
            count = 1+slice(A, m-1);
            sum += count;
        } else {
            slice(A, m-1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numberOfArithmeticSlices(A));
    }
}

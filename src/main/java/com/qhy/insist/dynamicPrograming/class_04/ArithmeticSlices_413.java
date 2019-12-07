package com.qhy.insist.dynamicPrograming.class_04;

/**
 * @Author houyingqi
 * @Date 2019-10-02 16:24
 * @Description [Medium] Topics: [Math] [Dynamic Programming]
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequence:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 *
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q)
 * such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 **/
//注意:条件必须是连续的，如果不一定是连续的，则与LengthOfLongestFibonacciSubsequence_873类似了
public class ArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (null == A || A.length < 3)
            return 0;
        int n = A.length;
        int res = 0;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            if (((long)A[i]-A[i-1]) == ((long)A[i-1]-A[i-2])) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        int[] A1 = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 1};
        ArithmeticSlices_413 arithmeticSlices = new ArithmeticSlices_413();
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(A));
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(A1));
    }
}

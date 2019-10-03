package com.qhy.insist.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author houyingqi
 * @Date 2019-10-02 17:50
 * @Description [Hard] Topics: [Dynamic Programming]
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 *
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers
 * (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 *
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk]
 * is arithmetic. In particular, this means that k ≥ 2.
 *
 * The function should return the number of arithmetic subsequence slices in the array A.
 *
 * The input contains N integers. Every integer is in the range of -2^31 and 2^31-1 and 0 ≤ N ≤ 1000. The output is guaranteed
 * to be less than 2^31-1.
 *
 *
 * Example:
 *
 * Input: [2, 4, 6, 8, 10]
 *
 * Output: 7
 *
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
  **/
//注意[重点回顾，不一定能再复现]:与LengthOfLongestFibonacciSubsequence_873类似了,暴力求解法可以得到结果，但是超时了
public class ArithmeticSlicesII_Subsequence_446 {

    public int numberOfArithmeticSlices(int[] A) {
        if (null == A || A.length < 3)
            return 0;
        int n = A.length;
        int res = 0;
        Map<Integer, Integer>[] maps = new Map[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;
                int d = (int)diff;
                int m1 = maps[i].getOrDefault(d, 0);
                int m2 = maps[j].getOrDefault(d, 0);
                res += m2;
                maps[i].put(d, m1+m2+1);
                System.out.println("i=" +i+", j="+j+", d="+d + ", m1="+m1+", m2="+m2+", maps[" +i+"]="+maps[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]A = {2, 4, 6, 8, 10};
        ArithmeticSlicesII_Subsequence_446 arithmeticSlicesII_subsequence = new ArithmeticSlicesII_Subsequence_446();
        System.out.println(arithmeticSlicesII_subsequence.numberOfArithmeticSlices(A));
    }
}

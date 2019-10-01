package com.qhy.insist.Fourth;

/**
 * @Author houyingqi
 * @Date 2019-10-01 21:08
 * @Description [Easy]
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 **/
public class NthtribonacciNumber_1137 {
    public int tribonacci(int n) {
        if (n == 1)
            return n;
        if (n == 2)
            return 1;
        int sum = 0, a = 0, b = 1, c = 1;
        for (int i = 2; i  < n; i++) {
            sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        NthtribonacciNumber_1137 nthtribonacciNumber = new NthtribonacciNumber_1137();
        System.out.println(nthtribonacciNumber.tribonacci(25));
    }
}

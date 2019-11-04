package com.qhy.practice.a20190215.pow_50;

/**
 * Created by dream on 2019/2/17.
 */
public class Solution1 {
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        while (n != 0) {
            if ((n & 0x01) == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.myPow(1.2, 2));
    }
}

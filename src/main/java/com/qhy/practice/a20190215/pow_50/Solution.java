package com.qhy.practice.a20190215.pow_50;

/**
 * Created by dream on 2019/2/17.
 */
public class Solution {
    public double myPow(double x, int n) {
        return n < 0 ? 1.0/(n == Integer.MIN_VALUE ?
                recurse(x, -(n+1)) : recurse(x, -n)) : recurse(x, n);
    }

    public double recurse(double x, int n) {
        double result = 1;
        if (0 == n) {
            return result;
        }
        result = recurse(x, n>>1);
        if (n % 2 == 1) {
            result = result * result * x;
        } else {
            result = result * result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, 2));
    }
}

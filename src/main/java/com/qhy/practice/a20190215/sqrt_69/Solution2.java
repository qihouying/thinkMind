package com.qhy.practice.a20190215.sqrt_69;

/**
 * Created by dream on 2019/2/15.
 */
public class Solution2 {
    public int sqrt_newton(int x) {
        if (1 == x)
            return x;
        float temp = 1;
        float old = 0;
        while ((int) (old - temp) != 0) {
            old = temp;
            temp = (temp + x*1.0f/temp)*0.5f;
        }
        int result = (int) temp;
        return result*result > x ? result-1 : result;
    }

    //may overflow ?
    public double sqrt_newton_f(int x, double accuracy) {
        if (0 == x)
            return 0;
        double result = x/2.0;
        while (result * result - x > accuracy) {
            result = (result + x/result)/2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.sqrt_newton(5));
        System.out.println(solution.sqrt_newton_f(5, 0.1));
    }
}

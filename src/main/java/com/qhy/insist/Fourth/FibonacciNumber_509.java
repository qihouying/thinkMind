package com.qhy.insist.Fourth;

/**
 * @Author houyingqi
 * @Date 2019-10-01 19:37
 * @Description [Easy]
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
 * the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 **/
public class FibonacciNumber_509 {
    //Method1:递归，耗时太长2^n
    public int fib1(int n) {
        int sum = 0;
        if (n < 0)
            return -1;
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
    //Method2:循环迭代法 best Method
    public int fib2(int n) {
        int sum = 0;
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }
    //Method3: 动态规划 Top Down Approach
    public int fib3(int n) {
        int[] cache = new int[31];
        if (n <= 1)
            return n;
        if (0 != cache[n])
            return cache[n];
        return cache[n] = fib3(n-1) + fib3(n-2);
    }

    //Method4: 动态规划 Bottom Up Approach
    public int fib4(int n) {
        int[] cache = new int[n+1];
        if (n <= 1)
            return n;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        FibonacciNumber_509 fibNum = new FibonacciNumber_509();
        System.out.println(fibNum.fib1(4));
        System.out.println(fibNum.fib2(4));
        System.out.println(fibNum.fib3(4));
        System.out.println(fibNum.fib4(4));
    }
}

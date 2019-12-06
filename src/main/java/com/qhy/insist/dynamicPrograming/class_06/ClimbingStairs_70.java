package com.qhy.insist.dynamicPrograming.class_06;

/**
 * @Author houyingqi
 * @Date 2019-10-01 20:49
 * @Description [Easy] Topics: [Dynamic Programming]
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 **/
//注意：与fibonacciNumber不同的是，f(2)=2，而不是 f(2) = f(1) + f(1)

public class ClimbingStairs_70 {
    //采用迭代法解决，还有递归，动态规划的两种解法
    public int climbSteps(int n) {
        int sum = 0, a = 1, b = 2;
        if (n <= 2)
            return n;
        for (int i = 2; i < n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        ClimbingStairs_70 climbingStairs = new ClimbingStairs_70();
        System.out.println(climbingStairs.climbSteps(3));
    }
}

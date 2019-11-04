package com.qhy.practice.a20181120.climbingStairs_70;

/**
 * Created by dream on 2018/11/14.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.
 Example 1:
     Input: 2
     Output:  2
     Explanation:  There are two ways to climb to the top.
     1. 1 step + 1 step
     2. 2 steps
 Example 2:
     Input: 3
     Output:  3
     Explanation:  There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step
 Companies
    Apple Adobe
 Topics
    Dynamic Programming

 */
public class Solution {
    public int climbingStairs(int n) {
        if (0 == n || 1 == n || 2 == n)
            return n;
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbingStairs(4));
    }

}

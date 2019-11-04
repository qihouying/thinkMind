package com.qhy.practice.a20190215.validPerfectSquare_367;

/**
 * Created by dream on 2019/2/18.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == Integer.MAX_VALUE) {
            return false;
        }
        int sqrt = 0;
        while(++sqrt*sqrt < num) {
        }
        return sqrt*sqrt == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(16));
    }
}

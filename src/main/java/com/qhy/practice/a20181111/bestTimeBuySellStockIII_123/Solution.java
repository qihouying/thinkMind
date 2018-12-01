package com.qhy.practice.a20181111.bestTimeBuySellStockIII_123;

/**
 * Created by dream on 2018/11/14.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before
 you buy again).

 Companies Topics
 Array Dynamic Programming

 */
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int price : prices) {
            release2 = Math.max(release2, hold2+price);
            hold2 = Math.max(hold2, release1-price);
            release1 = Math.max(release1, hold1+price);
            hold1 = Math.max(hold1, -price);
        }
        return release2;
    }

    public static void main(String[] args) {
        int[] prices = {6, 1, 3, 5, 4, 9, 20};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

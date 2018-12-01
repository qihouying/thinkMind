package com.qhy.practice.a20181111.bestTimeBuySellStockII_122;

/**
 * Created by dream on 2018/11/14.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
   Design an algorithm to find the maximum profit. You may complete as many transactions as
   you like (ie, buy one and sell one share of the stock multiple times). However, you may
   not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
   Companies
    Bloomberg
   Topics
    Array Greedy
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxPro += prices[i] - prices[i-1];
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

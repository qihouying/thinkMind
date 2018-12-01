package com.qhy.practice.a20181111.bestTimeBuySellStockII_122;

/**
 * Created by dream on 2018/11/14.
 *
 * The greedy pair-wise approach mentioned in other posts is great for this problem indeed, but if we're not allowed to
 * buy and sell stocks within the same day it can't be applied (logically, of course; the answer will be the same).
 * Actually, the straight- forward way of finding next local minimum and next local maximum is not much more complicated,
 * so, just for the sake of having an alternative I share the code in Java for such case.
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int i = 0;
        while (i < prices.length) {
            while (i < prices.length-1 && prices[i+1] <= prices[i]) {
                i++;
            }
            int min = prices[i++];
            while ( i < prices.length-1 && prices[i+1] >= prices[i]) {
                i++;
            }
            maxPro += i < prices.length ? prices[i++] - min : 0;
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6};
        Solution3 solution = new Solution3();
        System.out.println(solution.maxProfit(prices));
    }
}

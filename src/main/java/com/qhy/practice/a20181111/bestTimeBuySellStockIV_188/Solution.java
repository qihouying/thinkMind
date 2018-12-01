package com.qhy.practice.a20181111.bestTimeBuySellStockIV_188;

/**
 * Created by dream on 2018/11/14.
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers
 * in this range, inclusive.
     For example, given the range [5, 7], you should return 4.
     Companies Topics
     Bit Manipulation
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len/2)
            return quickSolve(prices);
        int[][] tmp = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                tmp[i][j] = Math.max(tmp[i][j-1], prices[j]+tmpMax);
                tmpMax = Math.max(tmpMax, tmp[i-1][j-1]-prices[j]);
            }
        }
        return tmp[k][len-1];
    }

    public int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {

    }
}

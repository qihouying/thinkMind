package com.qhy.practice.a20181111.bestTimeBuySellStock_121;

/**
 * Created by dream on 2018/11/14.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of
 the stock), design an algorithm to find the maximum profit.
 Example 1:
     Input: [7, 1, 5, 3, 6, 4]
     Output: 5
     max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be
     larger than buying price)
 Example 2:
     Input: [7, 6, 4, 3, 1]
     Output: 0
     In this case, no transaction is done, i.e. max profit = 0.
 Companies
     Facebook Microsoft Amazon Bloomberg Uber
 Topics
     Array Dynamic Programming

 */
public class Solution {
    /**
     * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm .
     * Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
     All the straight forward solution should work, but if the interviewer twists the question slightly
     by giving the difference array of prices, Ex: for {1, 7, 4, 11} , if he gives {0, 6, -3, 7} , you might end up being confused.
     Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i- 1] ) of the original array, and find a contiguous
     subarray giving maximum profit. If the difference falls below 0, reset it to zer

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

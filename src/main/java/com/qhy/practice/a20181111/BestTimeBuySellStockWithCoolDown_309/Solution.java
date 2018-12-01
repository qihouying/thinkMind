package com.qhy.practice.a20181111.BestTimeBuySellStockWithCoolDown_309;

/**
 * Created by dream on 2018/11/18.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as
 you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:
     prices = [1, 2, 3, 0, 2]
     maxProfit = 3
     transactions = [buy, sell, cooldown, buy, sell]
 Companies
    Google
 Topics
    Dynamic Programming
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy, sell = 0, preSell = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell-price, preBuy);
            preSell = sell;
            sell = Math.max(preBuy+price, preSell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

package com.qhy.insist.dynamicPrograming.class_03;

/**
 * @Author dream
 * @Date 2019/11/3 9:22 AM
 * @Description [Medium]   Topics: [Array] [Dynamic Programming]  companies: []
 *
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and
 * a non-negative integer fee representing a transaction fee.

    You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You
    may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

    Return the maximum profit you can make.

    Example 1:
    Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
    Output: 8
    Explanation: The maximum profit can be achieved by:
    Buying at prices[0] = 1
    Selling at prices[3] = 8
    Buying at prices[4] = 4
    Selling at prices[5] = 9
    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
    Note:

    0 < prices.length <= 50000.
    0 < prices[i] < 50000.
    0 <= fee < 50000.
 */
public class BestTimetoBuyandSellStockWithTransactionFee_714 {
    /**
     *   (1) buy status:
         buy[i] represents the max profit at day i in buy status, given that the last action you took is a buy action at day K, where K<=i. And you have the right to sell at day i+1, or do nothing.
         (2) sell status:
         sell[i] represents the max profit at day i in sell status, given that the last action you took is a sell action at day K, where K<=i. And you have the right to buy at day i+1, or do nothing.

         Let's walk through from base case.

         Base case:
         We can start from buy status, which means we buy stock at day 0.
         buy[0]=-prices[0];
         Or we can start from sell status, which means we sell stock at day 0.
         Given that we don't have any stock at hand in day 0, we set sell status to be 0.
         sell[0]=0;

         Status transformation:
         At day i, we may buy stock (from previous sell status) or do nothing (from previous buy status):
         buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
         Or
         At day i, we may sell stock (from previous buy status) or keep holding (from previous sell status):
         sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

         Finally:
         We will return sell[last_day] as our result, which represents the max profit at the last day, given that you took sell action at any day before the last day.

         We can apply transaction fee at either buy status or sell status.
     */

    //Solution I -- pay the fee when buying the stock:
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (null == prices || n < 2)
            return 0;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]-fee);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);

        }
        return sell[n-1];
    }
    //Solution I基础上 -- 继续优化空间复杂度
    public int maxProfit_1(int[] prices, int fee) {
        int n = prices.length;
        if (null == prices || n < 2)
            return 0;
        long buy = Integer.MIN_VALUE, sell = 0;
        for (int price : prices) {
            long preSell = sell;
            sell = Math.max(preSell, buy+price);
            buy = Math.max(buy, preSell-price-fee);
        }
        return (int)sell;
    }


    //Solution II -- pay the fee when selling the stock:
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        if (null == prices || n < 2)
            return 0;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]-fee);

        }
        return sell[n-1];
    }

    //Solution II基础上 -- 继续优化空间复杂度
    public int maxProfit2_1(int[] prices, int fee) {
        int n = prices.length;
        if (null == prices || n < 2)
            return 0;
        long buy = Integer.MIN_VALUE, sell = 0;
        for (int price : prices) {
            long preSell = sell;
            sell = Math.max(sell, buy+price-fee);
            buy = Math.max(buy, preSell-price);
        }
        return (int)sell;
    }



    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        BestTimetoBuyandSellStockWithTransactionFee_714 bestTimetoBuyandSellStockWithTransactionFee = new BestTimetoBuyandSellStockWithTransactionFee_714();
        System.out.println(bestTimetoBuyandSellStockWithTransactionFee.maxProfit(prices, fee));
        System.out.println(bestTimetoBuyandSellStockWithTransactionFee.maxProfit_1(prices, fee));
        System.out.println(bestTimetoBuyandSellStockWithTransactionFee.maxProfit2(prices, fee));
        System.out.println(bestTimetoBuyandSellStockWithTransactionFee.maxProfit2_1(prices, fee));
    }
}

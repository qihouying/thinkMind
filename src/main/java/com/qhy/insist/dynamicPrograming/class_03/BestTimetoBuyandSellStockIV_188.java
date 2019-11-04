package com.qhy.insist.dynamicPrograming.class_03;

/**
 * @Author dream
 * @Date 2019/11/3 1:43 AM
 * @Description [Hard]   Topics: [Array] [Dynamic Programming]
 *
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most k transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

    Example 1:

    Input: [2,4,1], k = 2
    Output: 2
    Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

    Example 2:

    Input: [3,2,6,5,0,3], k = 2
    Output: 7
    Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
    Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimetoBuyandSellStockIV_188 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                total += prices[i] - prices[i-1];
            }
        }
        return total;
    }
    //Method1:需要较多的空间复杂度

    /**
     * The basic idea is to create two tables. hold and unhold.

     hold[i][j] means the maximum profit with at most i transaction for 0 to j-th day. hold means you have a stock in
     your hand.

     unhold[i][j] means the maximum profit with at most i transaction for 0 to j-th day. unhold means you don't have a
     stock in your hand.

     The equation is

     hold[i][j] = Math.max(unhold[i][j-1]-prices[j],hold[i][j-1]);

     unhold[i][j] = Math.max(hold[i-1][j-1]+prices[j],unhold[i][j-1]);

     when you sell your stock this is a transaction but when you buy a stock, it is not considered as a full transaction.
     so this is why the two equation look a little different.

     And we have to initiate hold table when k = 0.

     When the situation is you can not buy a new stock at the same day when you sell it. For example you can only buy a
     new stock after one day you sell it. The same idea. Another situation is when you have to pay a transaction fee for
     each transaction, just make a modification when you sell it, So just change the unhold equation a little.
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || null == prices || n < 2)
            return 0;
        //k非常大的情况，退化为BestTimetoBuyandSellStockII_122的情况，即可以交易无限次
        if (k > n/2)
            return maxProfit(prices);
        //hold[i][k]  ith day k transaction have stock and maximum profit
        //unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
        int[][] hold = new int[k+1][n];
        int[][] unhold = new int[k+1][n];

        for (int i = 1; i <= k; i++) {
            hold[i][0] = -prices[0];
            unhold[i][0] = 0;
            for (int j = 1; j < n; j++) {
                unhold[i][j] = Math.max(hold[i][j-1]+prices[j], unhold[i][j-1]);//sell or not sell
                hold[i][j] = Math.max(unhold[i-1][j-1]-prices[j], hold[i][j-1]);//buy or not buy
            }
        }
        return Math.max(0, unhold[k][n-1]);
    }

    //

    /**
     * Method2:减小空间复杂度，hold[][]可以用一个临时变量来代替
     * The general idea is DP, while I had to add a "quickSolve" function to tackle some corner cases to avoid TLE.
        DP: t(i,j) is the max profit for up to i transactions by time j (0<=i<=K, 0<=j<=T).
     */
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || null == prices || n < 2)
            return 0;
        //k非常大的情况，退化为BestTimetoBuyandSellStockII_122的情况，即可以交易无限次
        if (k > n / 2)
            return maxProfit(prices);
        int[][] unhold = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int holdMax = -prices[0];
            for (int j = 1; j < n; j++) {
                unhold[i][j] = Math.max(unhold[i][j-1], holdMax+prices[j]);
                holdMax = Math.max(holdMax, unhold[i-1][j-1]-prices[j]);
            }
        }
        return unhold[k][n-1];
    }




    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        BestTimetoBuyandSellStockIV_188 bestTimetoBuyandSellStock = new BestTimetoBuyandSellStockIV_188();
        System.out.println(bestTimetoBuyandSellStock.maxProfit(k, prices));
        System.out.println(bestTimetoBuyandSellStock.maxProfit2(k, prices));
    }
}

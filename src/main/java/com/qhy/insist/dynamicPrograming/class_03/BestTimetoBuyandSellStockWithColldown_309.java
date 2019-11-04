package com.qhy.insist.dynamicPrograming.class_03;

/**
 * @Author dream
 * @Date 2019/11/3 8:22 AM
 * @Description [Medium]   Topics: [Array] [Dynamic Programming] companies: [Google]
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
    Example:

    Input: [1,2,3,0,2]
    Output: 3
    Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockWithColldown_309 {

    /**
     *
     * The series of problems are typical dp. The key for dp is to find the variables to represent the states and deduce
     * the transition function.

         Of course one may come up with a O(1) space solution directly, but I think it is better to be generous when you
         think and be greedy when you implement.

         The natural states for this problem is the 3 possible transactions : buy, sell, rest. Here rest means no
         transaction on that day (aka cooldown).

         Then the transaction sequences can end with any of these three states.

         For each of them we make an array, buy[n], sell[n] and rest[n].

         buy[i] means before day i what is the maxProfit for any sequence end with buy.

         sell[i] means before day i what is the maxProfit for any sequence end with sell.

         rest[i] means before day i what is the maxProfit for any sequence end with rest.

         Then we want to deduce the transition functions for buy sell and rest. By definition we have:

         buy[i]  = max(rest[i-1]-price, buy[i-1])
         sell[i] = max(buy[i-1]+price, sell[i-1])
         rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
         Where price is the price of day i. All of these are very straightforward. They simply represents :

         (1) We have to `rest` before we `buy` and
         (2) we have to `buy` before we `sell`
         One tricky point is how do you make sure you sell before you buy, since from the equations it seems that
         [buy, rest, buy] is entirely possible.

         Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]).
         That made sure [buy, rest, buy] is never occurred.

         A further observation is that and rest[i] <= sell[i] is also true therefore

         rest[i] = sell[i-1]
         Substitute this in to buy[i] we now have 2 functions instead of 3:

         buy[i] = max(sell[i-2]-price, buy[i-1])
         sell[i] = max(buy[i-1]+price, sell[i-1])
         This is better than 3, but

         we can do even better

         Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our
         final solution:
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2)
            return 0;
        int sell = 0, pre_sell = 0, buy = Integer.MIN_VALUE, pre_buy;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell-price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy+price, pre_sell);
        }
        return sell;
    }

    /**
     * Method2: state Machine Thinking 容易理解，但是空间复杂度会高一些
     *
     *      s0(rest)
          /         \
        buy        rest
        /            \
        s1(rest)-sell->s2（rest）

         There are three states, according to the action that you can take.

         Hence, from there, you can now the profit at a state at time i as:

         s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
         s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
         s2[i] = s1[i - 1] + prices[i]; // Only one way from s1
         Then, you just find the maximum of s0[n] and s2[n], since they will be the maximum profit we need (No one can buy stock and left with more profit that sell right :) )

         Define base case:

         s0[0] = 0; // At the start, you don't have any stock if you just rest
         s1[0] = -prices[0]; // After buy, you should have -prices[0] profit. Be positive!
         s2[0] = INT_MIN; // Lower base case
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (null == prices || n < 2)
            return 0;
        int[] s0 = new int[n], s1 = new int[n], s2 = new int[n];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i <n; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]);
            s2[i] = Math.max(s2[i-1], s1[i-1]+prices[i]);
        }
        return Math.max(s0[n-1], s2[n-1]);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        BestTimetoBuyandSellStockWithColldown_309 bestTimetoBuyandSellStockWithColldown = new BestTimetoBuyandSellStockWithColldown_309();
        System.out.println(bestTimetoBuyandSellStockWithColldown.maxProfit(prices));
        System.out.println(bestTimetoBuyandSellStockWithColldown.maxProfit2(prices));
    }

}

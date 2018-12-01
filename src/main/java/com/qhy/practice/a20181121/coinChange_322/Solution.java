package com.qhy.practice.a20181121.coinChange_322;

/**
 * Created by dream on 2018/11/14.
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1 .
 Example 1:
    coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 Example 2:
    coins = [2] , amount = 3 return -1 .
 Note:
    You may assume that you have an infinite number of each kind of coin.

 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0)
            return -1;
        if (amount <= 0)
            return 0;
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int sub = dp[i-coins[j]];
                    if (sub != Integer.MAX_VALUE) {
                        dp[i] = Math.min(sub+1, dp[i]);
                    }
                }
            }
        }
        return dp[dp.length-1] == Integer.MAX_VALUE ? -1 : dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }

}

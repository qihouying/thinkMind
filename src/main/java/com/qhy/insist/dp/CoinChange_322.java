package com.qhy.insist.dp;

import java.util.Arrays;

/**
 * @Author houyingqi
 * @Date 2019-10-30 10:41
 * @Description [Medium] Topics: [Dynamic Programming]
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3 return -1.
 * Note :
 * You may assume that you have an infinite number of each kind of coin.
 * Companies Topics
 * Dynamic Programming
 **/

//理解上有点难度
public class CoinChange_322 {

    /**
     * Recursive Method:
     * The idea is very classic dynamic programming: think of the last step we take. Suppose we have already found out
     * the best way to sum up to amount a, then for the last step, we can choose any coin type which gives us a remainder
     * r where r = a-coins[i] for all i's. For every remainder, go through exactly the same process as before until either
     * the remainder is 0 or less than 0 (meaning not a valid solution). With this idea, the only remaining detail is to
     * store the minimum number of coins needed to sum up to r so that we don't need to recompute it over and over again.
     *
     */
    public int coinChange(int[] coins, int amount) {
        if (null == coins)
            return 0;
        Arrays.sort(coins);
        return helper(coins, amount, new int[amount]);

    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (rem < 0) // not valid
            return -1;
        if (rem == 0) // completed
            return 0;
        if (count[rem-1] != 0) // already computed, so reuse
            return count[rem-1];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res >= 0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    /**
     * Iterative Method:
     * For the iterative solution, we think in bottom-up manner. Suppose we have already computed all the minimum counts
     * up to sum, what would be the minimum count for sum+1?
     *
     */

    public int coinChange_iter(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        CoinChange_322 coinChange = new CoinChange_322();
        int[] coins = {1, 2, 5};
        System.out.println(coinChange.coinChange(coins, 11));
        System.out.println(coinChange.coinChange_iter(coins, 11));

    }



}

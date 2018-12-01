package com.qhy.practice.a20181121.coinChange_322;

/**
 * Created by dream on 2018/11/26.
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] dp = new int[amount+1];
        int sum = 0;

        while(++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum-coin] != -1) {
                    int temp = dp[sum-coin]+1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.coinChange(coins, amount));
    }
}

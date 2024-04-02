package com.crazy.leetcode;

import java.util.Arrays;

public class LeetCode322_2 {
    public static void main(String[] args) {
        LeetCode322_2 leetCode322_2 = new LeetCode322_2();
        System.out.println(leetCode322_2.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(leetCode322_2.coinChange(new int[]{1}, 0));
    }

    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount < 0) {
            return -1;
        }

        this.coins = coins;

        // dp[i]表示: 金额为i时，最少需要dp[i]个硬币
        int[] dp = new int[amount + 1];
        // dp[i]的值不可能 > amount + 1，最差情况下全都用面值为1的硬币，dp[i] = amount
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int k: coins) {
                if (i < k) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - k]);
            }
        }

        // 如果dp[amount] = amount + 1，说明无法找到硬币组合
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

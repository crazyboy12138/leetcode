package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author lintingmin
 * @date 2020-08-23
 */
public class LeetCode322 {
    public static void main(String[] args) {
        System.out.println(new LeetCode322().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new LeetCode322().coinChange(new int[]{2}, 3));
        System.out.println(new LeetCode322().coinChange(new int[]{1, 2}, 6));
        System.out.println(new LeetCode322().coinChange(new int[]{1}, 0));
        System.out.println(new LeetCode322().coinChange(new int[]{1, 2, 5}, 100));
        System.out.println(new LeetCode322().coinChange(new int[]{186,419,83,408}, 6249));
    }

    private int[] coins;

    /**
     * record[i]用于记录min(i)的计算结果
     */
    private int[] record;

    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0) {
            return -1;
        }
        // 题目表达有问题，需要特殊处理amount == 0的情况
        if (amount == 0) {
            return 0;
        }
        this.coins = coins;
        record = new int[amount + 1];
        return min(amount);
    }

    /**
     * 组成amount需要的最少硬币数
     * @param amount
     * @return 返回-1代表找不到
     */
    public int min(int amount) {
        if (record[amount] != 0) {
            return record[amount];
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount == coins[i]) {
                return 1;
            }
            if (amount > coins[i]) {
                // 状态转移方程式: min(amount) = min(amount - coins[i]) + 1
                int count = min(amount - coins[i]);
                if (count != -1) {
                    minCount = minCount < count + 1 ? minCount : count + 1;
                }
            }
        }
        int min = minCount == Integer.MAX_VALUE ? - 1 : minCount;
        record[amount] = min;
        return min;
    }


}

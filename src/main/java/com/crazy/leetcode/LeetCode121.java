package com.crazy.leetcode;

import java.util.Objects;

/**
 * 买卖股票的最佳时机
 *
 * @author lintingmin
 * @date 2020-01-23
 */
public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = new int[] {4,8};
        System.out.println(new LeetCode121().maxProfit(prices));
    }

    /**
     * 思路: 用minNum维护当前最低的价格，用maxDistance维护当前最大的利润
     * 遍历prices数组，如果出现了更低的价格，则上一个最低价格可以丢弃，因为用更低的价格来算，利润肯定更高
     * 但是上一个最大利润不能丢弃，比如5,16,1,3这种情况，虽然后面出现了更低的价格1，但是最大利润还是16-5=11
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length == 0) {
            return 0;
        }

        int minNum = prices[0];
        int maxDistance = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            }
            if (prices[i] - minNum > maxDistance) {
                maxDistance = prices[i] - minNum;
            }
        }

        return maxDistance;
    }
}

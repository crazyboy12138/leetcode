package com.crazy.leetcode;

/**
 * 避免重复字母的最小删除成本
 *
 * @author lintingmin
 * @date 2020-09-19
 */
public class LeetCode1578 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1578().minCost("abaac", new int[]{1,2,3,4,5}));
        System.out.println(new LeetCode1578().minCost("abc", new int[]{1,2,3}));
        System.out.println(new LeetCode1578().minCost("aabaa", new int[]{1,2,3,4,1}));
    }

    public int minCost(String s, int[] cost) {
        if(null == s || null == cost || s.length() == 0) {
            return 0;
        }

        // 题目答案
        int minCost = 0;
        // 一段连续字符串中最大的代价
        int tempMaxCost;
        // 一段连续字符串的总代价
        int tempSumCost;

        tempMaxCost = cost[0];
        tempSumCost = cost[0];
        for (int i = 1; i < s.length(); i++) {
            // 当前字符与上一个字符相同，更新tempMaxCost和tempSumCost
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempMaxCost = tempMaxCost < cost[i] ? cost[i] : tempMaxCost;
                tempSumCost += cost[i];

                // 末尾特殊处理
                if (i == s.length() - 1) {
                    minCost += tempSumCost - tempMaxCost;
                    return minCost;
                }
            }
            // 当前字符与上一个字符不同，根据tempSumCost - tempMaxCost算出上一段连续字符串去重需要的最小代价
            else {
                minCost += tempSumCost - tempMaxCost;
                tempMaxCost = cost[i];
                tempSumCost = cost[i];
            }
        }

        return minCost;
    }
}

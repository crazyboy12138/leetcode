package com.crazy.leetcode;

/**
 * 跑楼梯
 *
 * @author lintingmin
 * @date 2020-02-23
 */
public class LeetCode70 {
    public static void main(String[] args) {
        System.out.println(new LeetCode70().climbStairs(6));
    }


    public int climbStairs(int n) {
        int curStep = n;
        // 到达上一级台阶的可能数
        int lastOneStep = 2;
        // 到达上两级台阶的可能数
        int lastTwoStep = 1;
        for (int i = 3; i <= n; i++) {
            curStep = lastOneStep + lastTwoStep;
            lastTwoStep = lastOneStep;
            lastOneStep = curStep;
        }
        return curStep;
    }
}

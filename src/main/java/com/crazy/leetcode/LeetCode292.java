package com.crazy.leetcode;

/**
 * Nim游戏
 *
 * @author lintingmin
 * @date 2020-05-03
 */
public class LeetCode292 {
    public static void main(String[] args) {
        System.out.println(new LeetCode292().canWinNim(5));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

package com.crazy.leetcode;

/**
 * 整数反转
 *
 * @author lintingmin
 * @date 2020-02-27
 */
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(new LeetCode7().reverse(-1230));
        System.out.println(new LeetCode7().reverse(Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        // 正负符号
        int symbol = x > 0 ? 1 : -1;
        // 取绝对值
        x = Math.abs(x);

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String reverse = sb.reverse().toString();

        long num = Long.valueOf(reverse);
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) num * symbol;
    }
}

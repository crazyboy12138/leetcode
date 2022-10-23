package com.crazy.leetcode;

/**
 * 二进制求和
 *
 * @author lintingmin
 * @date 2020-06-13
 */
public class LeetCode67 {
    public static void main(String[] args) {
        System.out.println(new LeetCode67().addBinary("101", "11"));
        System.out.println(new LeetCode67().addBinary("11", "101"));
        System.out.println(new LeetCode67().addBinary("11", "11"));
        System.out.println(new LeetCode67().addBinary("1010", "1011"));
        System.out.println(new LeetCode67().addBinary("0", "0"));
    }

    public String addBinary(String a, String b) {
        // 保证a长度不小于b
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        // 两位之和
        int sum;
        // 进位
        int overBit = 0;
        // 最终结果
        StringBuilder result = new StringBuilder();

        for (int i = b.length() - 1, j = a.length() - 1; i >= 0; i--, j--) {
            sum = a.charAt(j) - '0' + b.charAt(i) - '0' + overBit;
            overBit = sum / 2;
            result.append(sum % 2);
        }
        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            sum = a.charAt(i) - '0' + overBit;
            overBit = sum / 2;
            result.append(sum % 2);
        }
        // 最后的进位
        if (overBit != 0) {
            result.append(overBit);
        }

        return result.reverse().toString();
    }
}

package com.crazy.leetcode;

/**
 * 统计一个字符串的回文子串数量
 */
public class LeetCode647 {
    public static void main(String[] args) {
        System.out.println(new LeetCode647().countSubstrings("abc"));
        System.out.println(new LeetCode647().countSubstrings("aaa"));
        System.out.println(new LeetCode647().countSubstrings("aba"));
        System.out.println(new LeetCode647().countSubstrings("abba"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        // dp[i][j]表示左闭右闭区间[i, j]是否为回文子串
        boolean dp[][] = new boolean[length][length];

        // 子串长度为1
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            count++;
        }

        // 子串长度为2
        for (int i = 0; i < length - 1; i++) {
            dp[i][i + 1] = chars[i] == chars[i + 1];
            if (dp[i][i + 1]) {
                count++;
            }
        }

        // 子串长度>=3
        for (int subLen = 3; subLen <= length; subLen++) {
            for (int i = 0; i < length; i++) {
                int j = i + subLen - 1;
                if (j >= length) {
                    break;
                }
                // 状态转移
                dp[i][j] = dp[i + 1][j - 1] && chars[i] == chars[j];
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

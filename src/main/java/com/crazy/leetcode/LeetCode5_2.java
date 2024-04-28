package com.crazy.leetcode;

/**
 * 最长回文子串
 */
public class LeetCode5_2 {
    public static void main(String[] args) {
        System.out.println(new LeetCode5_2().longestPalindrome("cbbd"));
        System.out.println(new LeetCode5_2().longestPalindrome("babab"));
        System.out.println(new LeetCode5_2().longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLen = 1;
        int beginIndex = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        // dp[i][j]表示s[i]到s[j]是回文子串
        boolean dp[][] = new boolean[length][length];

        // 初始化dp数组，长度为1一定是回文子串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= length; len++) {
            for (int left = 0; left < length; left++) {
                int right = left + len - 1;

                if (right >= length) {
                    break;
                }

                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 3) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }

                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    beginIndex = left;
                }
            }
        }

        return s.substring(beginIndex, beginIndex + maxLen);
    }
}

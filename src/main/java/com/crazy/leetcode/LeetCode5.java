package com.crazy.leetcode;

/**
 * 最长回文子串
 *
 * @author lintingmin
 * @date 2020-07-12
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("babad"));
        System.out.println(new LeetCode5().longestPalindrome("cbbd"));
        System.out.println(new LeetCode5().longestPalindrome("cb"));
        System.out.println(new LeetCode5().longestPalindrome("cbbc"));
        System.out.println(new LeetCode5().longestPalindrome("babadabaf"));
        System.out.println(new LeetCode5().longestPalindrome("a"));
        System.out.println(new LeetCode5().longestPalindrome("abcdbbfcba"));
    }

    /**
     * 遍历s的每一个字符，从后往前找从该字符开始的回文子串，发现更长的回文子串就更新结果
     * 剪枝：借鉴KMP算法的思想，以abcdecba为例，第一次查找时，a与a比较，b与b比较，c与c比较，然后退出，第二次查找时，b与b比较，c与c比较，然后退出，实际上与第一次的比较是重复的
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }

        String result = "";
        char[] chars = s.toCharArray();
        int length = chars.length;
        int lastI = -1, lastJ = -1, lastCount = -1;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                // 本次遍历与上一次遍历有重复
                // 如果上一次遍历构成回文子串，本次遍历一定更短，可以跳过
                // 如果上一次遍历不构成回文，本次遍历也不构成回文，也可以跳过
                if (chars[i] == chars[j] && i - lastI == lastJ - j && i <= lastI + lastCount) {
                    continue;
                }

                int count = 0;
                while (i + count < length && j - count >= 0 && chars[i + count] == chars[j - count] && i + count <= j - count) {
                    count ++;
                }
                count --;
                if (i + count == j - count || i + count + 1 == j - count) {
                    if (j - i + 1 > result.length()) {
                        result = s.substring(i, j + 1);
                    }
                    break;
                }
                // count > 0表示头尾有部分是相同的，把i、j存起来给后面用
                if (count > 0) {
                    lastI = i;
                    lastJ = j;
                    lastCount = count;
                }
            }
        }
        return result;
    }
}

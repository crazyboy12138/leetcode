package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 实现 strStr()
 * 备注: KMP算法
 *
 * @author lintingmin
 * @date 2021-02-17
 */
public class LeetCode28 {
    public static void main(String[] args) {
        System.out.println(new LeetCode28().strStr("abababc", "abc"));
        System.out.println(new LeetCode28().strStr("hello", "ll"));
        System.out.println(new LeetCode28().strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = getNext(needle);
//        System.out.println(Arrays.toString(next));

        int i = 0, j = 0;

        while (i < haystack.length()) {
//            System.out.println("i: " + i + ", j: " + j);
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return -1;
    }

    /**
     * 返回next数组，next[i]表示str[0]到str[i-1]子串的最长公共前后缀长度
     * @param str
     * @return
     */
    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}

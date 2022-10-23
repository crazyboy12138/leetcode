package com.crazy.leetcode;

import java.util.Objects;

/**
 * 最长公共前缀
 *
 * @author lintingmin
 * @date 2020-01-28
 */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(new LeetCode14().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        // 字符串数组中，最短的字符串的长度
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength = strs[i].length() < minLength ? strs[i].length() : minLength;
        }

        // index: 当前公共前缀的长度
        for (int index = 0; index < minLength; index++) {
            for (int i = 0; i < strs.length; i++) {
                // 相同下标，如果字符不相等，就返回当前公共前缀
                if (strs[i].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }

        // 最长公共前缀长度，刚好是minLength
        return strs[0].substring(0, minLength);
    }
}

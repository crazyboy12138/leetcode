package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class LeetCode567 {
    public static void main(String[] args) {
        System.out.println(new LeetCode567().checkInclusion("ab", "a"));
//        System.out.println(new LeetCode567().checkInclusion("ab", "eidbaooo"));
//        System.out.println(new LeetCode567().checkInclusion("ab", "eidboaoo"));
    }

    /**
     * key是目标数组的字符，value是该字符在目标属组中出现次数
     */
    private Map<Character, Integer> need = new HashMap<>();

    /**
     * key是滑动窗口内的字符，value是该字符在滑动窗口内出现次数
     */
    private Map<Character, Integer> window = new HashMap<>();

    private int valid = 0;

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        // 初始化need数据
        char[] s1Chars = s1.toCharArray();
        for (char ch: s1Chars) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // 左闭右闭区间，初始状态[0, -1]表示窗口内空数据
        int left = 0, right = -1;

        // 初始化滑动窗口
        for (int i = 0; i < s1.length(); i++) {
            right++;
            char rightChar = s2.charAt(right);
            if (!need.containsKey(rightChar)) {
                continue;
            }
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            // 如果rightChar的数量满足要求，valid++
            if (window.get(rightChar).equals(need.get(rightChar))) {
                valid++;
            }
        }
        if (valid == need.size()) {
            return true;
        }

        while (right < s2.length() - 1) {
            // 滑动窗口右移
            right++;
            left++;

            // 本次放入窗口的字符
            char rightChar = s2.charAt(right);
            // 本次移出窗口的字符
            char leftChar = s2.charAt(left - 1);

            if (need.containsKey(rightChar)) {
                // 更新window计数器
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                // 更新window计数器后，更新valid
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    valid++;
                }
            }

            if (need.containsKey(leftChar)) {
                // 更新window计数器前，更新valid
                if (window.get(leftChar).equals(need.get(leftChar))) {
                    valid--;
                }
                // 更新window计数器
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
            }

            // 如果valid数量等于目标字符数，return true
            if (valid == need.size()) {
                return true;
            }
        }

        return false;
    }
}

package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 分割回文串
 *
 * @author lintingmin
 * @date 2020-12-13
 */
public class LeetCode131 {
    public static void main(String[] args) {
//        System.out.println(new LeetCode131().partition("aab"));
        System.out.println(new LeetCode131().partition("bb"));
    }

    /**
     * 存已计算过的结果，key/value分别为partition函数的入参/结果
     */
    private HashMap<String, List<List<String>>> map = new HashMap<>(16);

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>(0);
        }
        if (s.length() == 1) {
            return Arrays.asList(Arrays.asList(s));
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<List<String>> result = new ArrayList<>(16);
        /*
        截取s的前缀，若前缀是回文字符串，把前缀加入result，把partition(前缀)得到的结果，一一与前缀组合
        以aab为例
        取前缀a，partition(ab)的结果只有一个[[a,b]]，所以该前缀的结果是[[a, a, b]]
        取前缀aa，partition(b)的结果只有一个[[b]]，所以该前缀的结果是[[aa, b]]
         */

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (isPalindrome(prefix)) {
                if (i == s.length()) {
                    result.add(Arrays.asList(s));
                } else {
                    List<List<String>> partitions = partition(s.substring(i, s.length()));
                    for (List<String> partition: partitions) {
                        List<String> list = new ArrayList<>(1 + partition.size());
                        list.add(prefix);
                        list.addAll(partition);
                        result.add(list);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }

    /**
     * s是否是回文字符串
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        for(int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}

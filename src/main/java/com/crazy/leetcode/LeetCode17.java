package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author lintingmin
 * @date 2021-01-16
 */
public class LeetCode17 {
    public static void main(String[] args) {
        List<String> strings = new LeetCode17().letterCombinations("22");
        System.out.println(strings);
    }


    /**
     * 第一维为按键，第二维为按键对应的数字，如char[2] = [a, b, c]
     */
    private char[][] letters;

    /**
     * digits的引用
     */
    private String digits;

    /**
     * 结果集
     */
    private List<String> results;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>(0);
        }

        // 结果数为3^digits.length()
        results = new ArrayList((int)Math.pow(3, digits.length()));
        letters = new char[10][4];
        this.digits = digits;

        // 构造letters数组
        int count = 0;
        for (int i = 2; i <= 9; ) {
            for (int j = 0; j < 3; j++) {
                letters[i][j] = (char) ('a' + count);
                count++;
            }
            // 按键7和9对应4个字母
            if (i == 7 || i == 9) {
                letters[i][3] = (char)(letters[i][2] + 1);
                count++;
            }
            i++;
        }

        // 第一个组合，取每一个按键的第一个字母
        char[] first = new char[digits.length()];
        count = 0;
        for (int i = 0; i < digits.length();  i++) {
            first[count++] = letters[Integer.parseInt(digits.charAt(i) + "")][0];
        }
        results.add(new String(first));

        // 每次替换一个字母
        replace(0);

        return results;
    }

    /**
     * 取出结果集中已有的组合，替换其中的一个字母
     * @param index
     */
    private void replace(int index) {
        if (index == digits.length()) {
            return ;
        }
        int curNum = Integer.parseInt( digits.charAt(index)+ "");
        char[] letter = letters[curNum];
        int letterSize = (curNum == 7 || curNum == 9) ? 4 : 3;
        int resultSize = results.size();
        for (int i = 1; i < letterSize; i++) {
            for (int j = 0; j < resultSize; j++) {
                char[] chars = results.get(j).toCharArray();
                chars[index] = letter[i];
                results.add(new String(chars));
            }
        }
        replace(index + 1);
    }
}

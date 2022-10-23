package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 罗马数字转整数
 *
 * @author lintingmin
 * @date 2020-04-19
 */
public class LeetCode13 {
    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        System.out.println(leetCode13.romanToInt("III"));
        System.out.println(leetCode13.romanToInt("IV"));
        System.out.println(leetCode13.romanToInt("IX"));
        System.out.println(leetCode13.romanToInt("LVIII"));
        System.out.println(leetCode13.romanToInt("MCMXCIV"));
    }

    /**
     * 通常情况下，罗马数字中小的数字在大的数字的右边
     * 如果不满足这个特点，就把前一个字母对应的值减掉，再重新计算
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }

        int preValue = getValue(s.charAt(0));
        int sum = preValue;
        for (int i = 1; i < s.length(); i++) {
            int curValue = getValue(s.charAt(i));
            if (curValue > preValue) {
                sum = sum - preValue + curValue - preValue;
            } else {
                sum += curValue;
            }
            preValue = curValue;
        }
        return sum;
    }

    private int getValue (char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

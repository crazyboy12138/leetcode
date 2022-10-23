package com.crazy.leetcode;

import java.util.Objects;

/**
 * 外观数列
 *
 * @author lintingmin
 * @date 2020-03-14
 */
public class LeetCode38 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new LeetCode38().countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 前一项
        String lastStr = "1";
        int count;
        StringBuilder curStr = null;


        for (int i = 1; i < n; i++) {
            // 当前项
            curStr = new StringBuilder();
            int j = 1;
            count = 1;
            char[] chars = lastStr.toCharArray();

            while (j < lastStr.length()) {
                if (chars[j - 1] == chars[j]) {
                    count ++;
                } else {
                    curStr.append(count).append(chars[j - 1]);
                    count = 1;
                }
                j ++;
            }

            curStr.append(count).append(chars[lastStr.length() - 1]);
            lastStr = curStr.toString();
        }

        return lastStr;
    }
}

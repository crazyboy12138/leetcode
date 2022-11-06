package com.crazy.leetcode;

/**
 * Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class LeetCode6 {
    public static void main(String[] args) {
        System.out.println(new LeetCode6().convert("PAYPALISHIRING", 3));
        System.out.println(new LeetCode6().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        // 矩形
        int[][] arr = new int[numRows][1000];
        // Z字形排列时，当前遍历到第几列
        int column = 0;
        // 排列方向，0表示向下走，1表示向右上角走
        int regular = 0;
        // s字符串的下标
        int index = 0;
        // 字符串长度
        int length = s.length();

        while (index < length) {
            if (regular == 0) {
                for (int k = 0; k < numRows && index < length; k++) {
                    arr[k][column] = s.charAt(index);
                    index++;
                }
                column++;
                regular = 1;
            } else {
                for (int k = numRows - 2; k >= 1 && index < length; k--) {
                    arr[k][column] = s.charAt(index);
                    column++;
                    index++;
                }
                regular = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y <= column; y++) {
                if (arr[x][y] != 0) {
                    sb.append((char) arr[x][y]);
                }
            }
        }
        return sb.toString();
    }
}

package com.crazy.leetcode;

/**
 * 反转字符串
 */
public class LeetCode344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

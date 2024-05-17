package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 比特位计数
 */
public class LeetCode338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode338().countBits(20)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            result[i] = count(i);
        }

        return result;
    }

    /**
     * 计算num的二进制中1的数量
     */
    private int count(int num) {
        int count = 0;
        while (num > 0) {
            int k = (int)(Math.log(num) / Math.log(2));
            num -= Math.pow(2, k);
            count++;
        }
        return count;
    }
}

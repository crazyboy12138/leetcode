package com.crazy.leetcode;

/**
 * 回文数
 *
 * @author lintingmin
 * @date 2020-04-19
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindrome1(0));
    }

    // 39ms
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        // 求x的位数，如1234321的位数是7
        int bits = (int)(Math.log(x) / Math.log(10)) + 1;

        // x的最高位和最低位
        int high = 0, low = 0;

        for (int i = 1; i <= bits / 2; i++){
            high = (x / (int)Math.pow(10, bits - i)) % 10;
            low = (x % (int)Math.pow(10, i)) / (int) Math.pow(10, i - 1);
//            System.out.println("high: " + high + ", low: " + low);
            if (high != low) {
                return false;
            }
        }

        return true;
    }

    // 10ms
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        // 求x的位数，如1234321的位数是7
        int bits = (int)(Math.log(x) / Math.log(10)) + 1;
        int[] nums = new int[bits];
        int i = 0;

        while (x > 0) {
            nums[i++] = x % 10;
            x /= 10;
        }

        for (i = 0; i < bits / 2; i++) {
//            System.out.println("high: " + nums[bits - 1 - i] + ", low: " + nums[i]);
            if (nums[i] != nums[bits - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}

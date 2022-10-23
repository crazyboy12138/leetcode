package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 丢失的数字
 *
 * @author lintingmin
 * @date 2020-10-17
 */
public class LeetCode268 {
    public static void main(String[] args) {
        System.out.println(new LeetCode268().missingNumber(new int[]{3,0,1}));
        System.out.println(new LeetCode268().missingNumber(new int[]{0,1}));
        System.out.println(new LeetCode268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(new LeetCode268().missingNumber(new int[]{0}));
    }

    public int missingNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        // 利用异或“相同为0，不同为1”的特点，把0到n这n+1个数，与nums数组中n个数都异或一遍，相同的数字互相抵消，最后结果就是丢失的数字
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ i ^ nums[i];
        }
        return sum;
    }
}

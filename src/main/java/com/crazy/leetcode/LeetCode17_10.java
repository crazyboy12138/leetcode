package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 主要元素
 *
 * @author lintingmin
 * @date 2020-12-20
 */
public class LeetCode17_10 {
    public static void main(String[] args) {
        System.out.println(new LeetCode17_10().majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
        System.out.println(new LeetCode17_10().majorityElement(new int[]{3,2}));
        System.out.println(new LeetCode17_10().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new LeetCode17_10().majorityElement(new int[]{1}));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        // 当前重复次数
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            count = (nums[i] == nums[i - 1]) ? count + 1 : count;
            if (count > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

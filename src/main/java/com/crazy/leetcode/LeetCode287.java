package com.crazy.leetcode;

/**
 * 寻找重复数
 */
public class LeetCode287 {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int num: nums) {
            int index = num < 0 ? -num : num;

            // nums[index - 1] < 0，说明前面有重复的index把nums[index - 1]设置成负数
            if (nums[index - 1] < 0) {
                return index;
            }

            nums[index - 1] *= -1;
        }

        return -1;
    }
}

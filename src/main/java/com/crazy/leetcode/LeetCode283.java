package com.crazy.leetcode;

public class LeetCode283 {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

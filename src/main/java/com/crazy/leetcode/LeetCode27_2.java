package com.crazy.leetcode;

public class LeetCode27_2 {

    public static void main(String[] args) {
        System.out.println(new LeetCode27_2().removeElement(new int[]{2, 2, 1}, 1));
        System.out.println(new LeetCode27_2().removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            // left定位到第一个值为val的元素
            while (left < nums.length && nums[left] != val) {
                left++;
            }

            // left前面全都不等于val
            if (left == nums.length) {
                return left;
            }

            if (right == 0) {
                right = left + 1;
            }

            if (right == nums.length) {
                return left;
            }

            // right定位到第一个值不为val的元素
            while (right < nums.length && nums[right] == val) {
                right++;
            }

            if (right == nums.length) {
                return left;
            }

            // 交换left right元素
            nums[left] = nums[right];
            nums[right] = val;
            left++;
            right++;
        }

        return left;
    }
}

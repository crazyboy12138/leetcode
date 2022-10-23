package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 移除元素
 *
 * @author lintingmin
 * @date 2021-02-21
 */
public class LeetCode27 {

    public static void main(String[] args) {
        System.out.println(new LeetCode27().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new LeetCode27().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(new LeetCode27().removeElement(new int[]{1, 2}, 2));
        System.out.println(new LeetCode27().removeElement(new int[]{2}, 2));
        System.out.println(new LeetCode27().removeElement(new int[]{1}, 2));
        System.out.println(new LeetCode27().removeElement(new int[]{3, 3}, 3));
        System.out.println(new LeetCode27().removeElement(new int[]{4, 5}, 4));
        System.out.println(new LeetCode27().removeElement(new int[]{2, 2, 3}, 2));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 定义左右指针
        int left = 0, right = nums.length - 1;

        while (left < right) {
            // right指针从右往左，找不等于val的元素
            while (nums[right] == val && right > left) {
                right--;
            }

            // left指针从左往右，找等于val的元素
            while (nums[left] != val && right > left) {
                left++;
            }

            // 交换元素，把从左往右找到的等于val的元素移动到右边
            if (nums[right] != val && nums[left] == val && right > left) {
                swap(nums, right, left);
                right--;
                left++;
            }

//            System.out.println(Arrays.toString(nums));
        }

        return nums[left] == val ? left : left + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

package com.crazy.leetcode;

import java.util.Objects;

/**
 *  搜索插入位置
 *
 * @author lintingmin
 * @date 2020-03-28
 */
public class LeetCode35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(new LeetCode35().searchInsert(nums, 5));
        System.out.println(new LeetCode35().searchInsert(nums, 2));
        System.out.println(new LeetCode35().searchInsert(nums, 7));
        System.out.println(new LeetCode35().searchInsert(nums, 0));
        nums = new int[]{1, 3};
        System.out.println(new LeetCode35().searchInsert(nums, 0));
        System.out.println(new LeetCode35().searchInsert(nums, 5));
        nums = new int[]{1, 3, 4, 5, 10};
        System.out.println(new LeetCode35().searchInsert(nums, 0));
        nums = new int[]{3, 5, 7, 9, 10};
        System.out.println(new LeetCode35().searchInsert(nums, 8));
        nums = new int[]{3};
        System.out.println(new LeetCode35().searchInsert(nums, 8));

    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return nums[mid] >= target ? mid : mid + 1;
    }
}

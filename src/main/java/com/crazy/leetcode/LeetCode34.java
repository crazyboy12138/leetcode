package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5,7,7,8,8,10}, 7)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5,7,7,8,8,10}, 5)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10}, 4)));
    }

    int[] nums;

    int target;

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        this.nums = nums;
        this.target = target;

        int hitAnyOne = hitAnyOne();
        if (hitAnyOne == -1) {
            return new int[]{-1, -1};
        }

        int leftBound = findLeftBound(hitAnyOne);
        int rightBound = findRightBound(hitAnyOne);

        return new int[]{leftBound, rightBound};

    }

    private int findLeftBound(int hitAnyOne) {
        int left = 0, right = hitAnyOne;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 匹配到目标值，不直接返回，继续向左寻找
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && nums[right] == target) {
            return right;
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findRightBound(int hitAnyOne) {
        int left = hitAnyOne, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 匹配到目标值，不直接返回，继续向右寻找
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int hitAnyOne() {
        // 两端都是闭合区间
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

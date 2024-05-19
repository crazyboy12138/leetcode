package com.crazy.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序数组
 */
public class LeetCode912 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode912().sortArray(new int[]{5, 1, 1, 0, 0, 2})));
        System.out.println(Arrays.toString(new LeetCode912().sortArray(new int[]{5, 1, 1, 0, 0, 8})));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        shuffle(nums);

        sort(nums, 0, nums.length - 1);

        return nums;
    }

    /**
     * 对nums的[low, hign]区间升序排序
     */
    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    /**
     * 对于nums的[low, high]区间，找到一个下标p，p左边的数字都<=nums[p]，p右边的数字都>nums[p]
     * @return p
     */
    private int partition(int[] nums, int low, int high) {
         if (low >= high) {
             return -1;
         }

         int base = nums[low];
         int left = low + 1, right = high;

         while (left <= right) {
             // left移动到第一个 >base 的下标
             while (left < high && nums[left] <= base) {
                 left++;
             }
             // right移动到第一个 <=base 的下标
             while (right > low && nums[right] > base) {
                 right--;
             }

             if (left >= right) {
                 break;
             }

             swap(nums, left, right);
         }

         swap(nums, low, right);
         return right;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 洗牌算法
     */
    private void shuffle(int[] nums) {
        Random random = new Random();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int r = i + random.nextInt(length - i);
            swap(nums, i, r);
        }
    }
}

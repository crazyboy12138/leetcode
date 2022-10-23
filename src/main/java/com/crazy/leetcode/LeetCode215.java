package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 *
 * @author lintingmin
 * @date 2021-02-02
 */
public class LeetCode215 {
    public static void main(String[] args) {
        System.out.println(new LeetCode215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new LeetCode215().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return getTopK(nums, 0, nums.length, k - 1);
    }

    /**
     * 快排求topK大
     * 注意:
     * begin、end、left、right的关系处理好
     * while中，> >= < <=处理好，否则会死循环
     * @param arr
     */
    private int getTopK(int[] arr, int begin, int end, int k) {
        int tmp = arr[begin];
        int left = begin, right = end - 1;
        while (left < right) {
            while (arr[right] <= tmp && left < right) {
                right--;
            }
            if (arr[right] >= tmp && left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (arr[left] >= tmp && left < right) {
                left++;
            }
            if (arr[left] <= tmp && left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = tmp;

        if (left < k) {
            return getTopK(arr, left + 1, end, k);
        } else if (left > k) {
            return getTopK(arr, begin, left, k);
        } else {
            return arr[left];
        }
    }
}

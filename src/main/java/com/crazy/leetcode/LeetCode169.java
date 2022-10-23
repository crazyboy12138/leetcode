package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author lintingmin
 * @date 2020-08-02
 */
public class LeetCode169 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,2,3, 2, 3};
        int[] arr2 = new int[]{2,2,1,1,1,2,2};
        System.out.println(new LeetCode169().majorityElement(arr1));
        System.out.println(new LeetCode169().majorityElement(arr2));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int half = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            left = i;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            // 区间长度 > nums.length / 2
            if (i - left + 1 > half) {
                return nums[left];
            }
        }
        return -1;
    }
}

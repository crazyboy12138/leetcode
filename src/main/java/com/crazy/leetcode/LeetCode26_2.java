package com.crazy.leetcode;

import java.util.Arrays;

public class LeetCode26_2 {

    public static void main(String[] args) {
        new LeetCode26_2().case1();
        new LeetCode26_2().case2();
        new LeetCode26_2().case3();
        new LeetCode26_2().case4();
        new LeetCode26_2().case5();
    }

    private void case1() {
        int[] nums = new int[]{0, 1, 2, 3};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    private void case2() {
        int[] nums = new int[]{0, 1, 2, 2, 2, 3, 3, 5};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    private void case3() {
        int[] nums = new int[]{1, 1};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    private void case4() {
        int[] nums = new int[]{1, 1, 2};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    private void case5() {
        int[] nums = new int[]{1, 1, 2, 3};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[temp] != nums[i]) {
                temp++;
                nums[temp] = nums[i];
            }
        }
        return temp + 1;
    }
}

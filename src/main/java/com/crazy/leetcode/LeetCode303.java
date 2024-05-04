package com.crazy.leetcode;

/**
 * 区域和检索-数组不可变
 */
public class LeetCode303 {
    public static void main(String[] args) {
           new LeetCode303().case1();
    }

    private void case1() {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(numArray.sumRange(0, 3));
        System.out.println(numArray.sumRange(2, 3));
        System.out.println(numArray.sumRange(3, 3));
    }

    class NumArray {

        /**
         * preNums[i]表示sum(nums[0] + nums[1] + ... + nums[i])
         */
        private int[] preNums;

        public NumArray(int[] nums) {
            if (nums == null) {
                preNums = new int[0];
                return;
            }
            preNums = new int[nums.length];
            preNums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preNums[i] = preNums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return left == 0
                    ? preNums[right]
                    : preNums[right] - preNums[left - 1];
        }
    }
}

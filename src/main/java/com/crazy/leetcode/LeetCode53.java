package com.crazy.leetcode;

/**
 * 最大子序和
 *
 * @author lintingmin
 * @date 2020-08-23
 */
public class LeetCode53 {
    public static void main(String[] args) {
        System.out.println(new LeetCode53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new LeetCode53().maxSubArray(new int[]{1}));
        System.out.println(new LeetCode53().maxSubArray(new int[]{}));
    }

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        // 连续子数组的最大和
        int maxSum = nums[0];
        // lastMax表示遍历到nums[i]时，包含nums[i]的连续子数组的最大和
        int lastMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 包含nums[i]的连续子数组的最大和 = max(包含nums[i-1]的连续子数组的最大和 + nums[i], nums[i])
            lastMax = Math.max(lastMax + nums[i], nums[i]);
            maxSum = lastMax > maxSum ? lastMax : maxSum;
        }

        return maxSum;
    }
}

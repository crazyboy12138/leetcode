package com.crazy.leetcode;

/**
 * 面试题 17.16. 按摩师
 *
 * @author lintingmin
 * @date 2020-09-13
 */
public class LeetCode1716 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1716().massage(new int[]{1,2,3,1}));
        System.out.println(new LeetCode1716().massage(new int[]{2,7,9,3,1}));
        System.out.println(new LeetCode1716().massage(new int[]{2,1,4,5,3,1,1,3}));
    }

    public int massage(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 从1号预约到上上个预约的最优解
        int maxLastLast = nums[0];
        // 从1号预约到上个预约的最优解
        int maxLast = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 当前预约有选或不选两种情况
            // 1号预约到当前预约的最优解 = Math.max(从1号预约到上个预约的最优解, 从1号预约到上上个预约的最优解 + 当前预约时长)
            int maxCurrent = Math.max(maxLast, maxLastLast + nums[i]);
            maxLastLast = maxLast;
            maxLast = maxCurrent;
        }
        return maxLast;
    }
}

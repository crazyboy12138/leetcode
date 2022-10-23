package com.crazy.leetcode;

/**
 * 打家劫舍
 *
 * @author lintingmin
 * @date 2020-08-08
 */
public class LeetCode198 {
    public static void main(String[] args) {
        System.out.println(new LeetCode198().rob(new int[]{1,2,3,1}));
        System.out.println(new LeetCode198().rob(new int[]{2,7,9,3,1}));
        System.out.println(new LeetCode198().rob(new int[]{2,1,1,2}));
        System.out.println(new LeetCode198().rob(new int[]{1,2,1,1}));
        System.out.println(new LeetCode198().rob(new int[]{1,2,1,2}));
        System.out.println(new LeetCode198().rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(new LeetCode198().rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

    }

    private int[] nums;

    /**
     * sum[i]表示i号房到最后一号房可以取得的最大金额，默认为0
     */
    private int[] sums;

    public int rob(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        // 初始化为-1
        for (int i = 0; i < nums.length; i++) {
            sums[i] = -1;
        }
        return getMax(0);
    }

    /**
     * 求第index号房到最后一号房之间可以取得的最大金额
     * @param index 当前遍历到几号房
     */
    public int getMax(int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            return nums[index];
        }
        // 如果getMax(index)已经计算过，直接返回
        if (sums[index] >= 0) {
            return sums[index];
        }
        // 状态转移方程
        int max = Math.max(nums[index] + getMax(index + 2), getMax(index + 1));
        sums[index] = max;
        return max;
    }
}

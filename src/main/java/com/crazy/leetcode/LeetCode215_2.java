package com.crazy.leetcode;

public class LeetCode215_2 {
    public static void main(String[] args) {
        System.out.println(new LeetCode215_2().findKthLargest(new int[]{3, 2, 4, -6, 99, 23, 100}, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        // 数据范围为10^-4到10^4，数组下标不能是负数，因此统一在原数据基础上+10000
        int[] buckets = new int[20001];

        // 初始化buckets，记录每个数据出现次数
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }

        // 从后往前遍历
        for (int i = buckets.length - 1; i >= 0; i--) {
            k -= buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}

package com.crazy.leetcode;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 */
public class LeetCode560 {

    public static void main(String[] args) {
        System.out.println(new LeetCode560().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new LeetCode560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // key为前缀和，value为该前缀和出现次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        // 统计结果
        int result = 0;

        // 从num[0]开始的前缀和
        int pre = 0;

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            /*
                map.containsKey(pre - k)，表示存在前缀和为pre-k的区间
                假设前缀和为pre-k的区间为[0, a], [0, b], [0, c]
                那么[a + 1, i], [b + 1, i], [c + 1, i]这3个区间的区间和都是k
             */
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return result;
    }
}

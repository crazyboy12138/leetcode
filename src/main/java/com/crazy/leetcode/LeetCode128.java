package com.crazy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LeetCode128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int longest = 1;

        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int next = num + 1;
                while (set.contains(next)) {
                    next++;
                }
                int count = next - num;
                longest = longest < count ? count : longest;
            }
        }

        return longest;
    }
}

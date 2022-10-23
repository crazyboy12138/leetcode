package com.crazy.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 非递增顺序的最小子序列
 *
 * @author lintingmin
 * @date 2020-09-19
 */
public class LeetCode1403 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1403().minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(new LeetCode1403().minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(new LeetCode1403().minSubsequence(new int[]{6}));
    }

    public List<Integer> minSubsequence(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        // 求nums数组的和
        int sum = Arrays.stream(nums).sum();

        int tempSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            tempSum += nums[i];
            if (tempSum > sum - tempSum) {
                List<Integer> result = Arrays.stream(nums).boxed().collect(Collectors.toList()).subList(i, nums.length);
                Collections.reverse(result);
                return result;
            }
        }

        return new ArrayList<>();
    }
}

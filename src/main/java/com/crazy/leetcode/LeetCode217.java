package com.crazy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author lintingmin
 * @date 2020-08-15
 */
public class LeetCode217 {
    public static void main(String[] args) {
        System.out.println(new LeetCode217().containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] ^ nums[i - 1]) == 0) {
                return true;
            }
        }
        return false;
    }
}

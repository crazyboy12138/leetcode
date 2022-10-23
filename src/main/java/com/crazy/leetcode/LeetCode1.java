package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author lintingmin
 * @date 2019-12-28
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 7, 13, 3};
        int target = 9;
        int[] result = new LeetCode1().twoSum(nums, target);
        for (int i: result){
            System.out.print(i + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2indexMap = new HashMap((int)((float)nums.length / 0.75F + 1.0F));
        for (int i = 0; i < nums.length; i++) {
            if (num2indexMap.containsKey(target - nums[i]) && (num2indexMap.get(target - nums[i]) != i)){
                int[] ints = new int[2];
                ints[0] = num2indexMap.get(target - nums[i]);
                ints[1] = i;
                return ints;
            }
            num2indexMap.put(nums[i], i);
        }
        return null;
    }
}

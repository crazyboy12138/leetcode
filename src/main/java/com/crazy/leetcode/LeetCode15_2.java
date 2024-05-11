package com.crazy.leetcode;

import java.util.*;

public class LeetCode15_2 {
    public static void main(String[] args) {
        System.out.println(new LeetCode15_2().threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(new LeetCode15_2().threeSum(new int[]{0, 0, 0}));
        System.out.println(new LeetCode15_2().threeSum(new int[]{0, 0, 0, 0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();

        // 升序排序
        Arrays.sort(nums);

        // 如果nums[i]是正数，其后面元素必>=nums[i]，不可能满足条件
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // nums[i] == nums[i - 1]时，若nums[i - 1]能找到答案，nums[i]肯定也能，nums[i - 1]找到的是重复的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int thirdIndex = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 如果nums[i] + nums[j] + nums[thirdIndex] > 0，后续nums[j]越来越大，三者之和更大
                // 因此，thirdIndex必须变小
                while (nums[i] + nums[j] + nums[thirdIndex] > 0 && thirdIndex > j) {
                    thirdIndex--;
                }
                if (j == thirdIndex) {
                    break;
                }

                boolean check = nums[i] + nums[j] + nums[thirdIndex] == 0;
                if (check) {
                    resultList.add(Arrays.asList(nums[i], nums[j], nums[thirdIndex]));
                }
            }
        }

        return resultList;
    }
}

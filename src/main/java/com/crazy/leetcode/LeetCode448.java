package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 数组中消失的数字
 */
public class LeetCode448 {
    public static void main(String[] args) {
        System.out.println(new LeetCode448().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        for (int num: nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i] > 0，说明元素i + 1不存在，否则nums[i]会被改成负数
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}

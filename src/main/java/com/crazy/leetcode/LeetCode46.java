package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode46 {
    public static void main(String[] args) {
        System.out.println(new LeetCode46().permute(new int[]{1, 2, 3}));;
        System.out.println(new LeetCode46().permute(new int[]{1}));;
    }

    private int[] nums;

    /**
     * flag[i]=true，表示nums[i]已经被选择过
     */
    private boolean[] flag;

    /**
     * 最终结果
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        this.nums = nums;
        flag = new boolean[nums.length];

        dfs(new LinkedList<>());

        return result;
    }

    private void dfs(LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }

            current.add(nums[i]);
            flag[i] = true;

            dfs(current);

            current.removeLast();
            flag[i] = false;
        }
    }
}

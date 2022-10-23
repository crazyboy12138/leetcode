package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 组合总和
 *
 * @author lintingmin
 * @date 2020-01-11
 */
public class LeetCode39 {
    public static void main(String[] args) {
        int[] ints = {2,3,5};
        List<List<Integer>> lists = new LeetCode39().combinationSum(ints, 8);
        System.out.println(lists);
    }

    private List<List<Integer>> result;

    private int target;

    private int[] candidates;

    private int length;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        this.length = candidates.length;
        result = new ArrayList<>();

        Arrays.sort(candidates);

        cal(0, new ArrayList<Integer>(), 0);

        return result;
    }

    /**
     * 以nums=[2,3,5],target=8为例，如果已经算上了2，问题转换为nums=[2,3,5],target=6
     * @param currentSum 当前和
     * @param path 用于存符合条件的组合
     * @param index 数组下标，保证指针不会往前寻找元素
     */
    private void cal(int currentSum, List<Integer> path, int index) {
        for (int i = index; i < length; i++) {
            if (currentSum + candidates[i] == target) {
                path.add(candidates[i]);
                // 要复制一个List，否则path会被后面的操作影响
                List<Integer> copy = new ArrayList<>(path.size());
                copy.addAll(path);
                result.add(copy);
                path.remove(path.size() - 1);
                return ;
            } else if (currentSum + candidates[i] < target) {
                path.add(candidates[i]);
                cal(currentSum + candidates[i], path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}

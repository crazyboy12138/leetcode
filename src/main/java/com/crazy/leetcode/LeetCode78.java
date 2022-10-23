package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author lintingmin
 * @date 2020-08-16
 */
public class LeetCode78 {
    public static void main(String[] args) {
//        print(new int[]{1});
//        print(new int[]{1, 2});
        print(new int[]{1, 2, 3});

//        System.out.println(new LeetCode78().getCountOfSubSets(2));
    }

    public static void print(int[] nums) {
        List<List<Integer>> subsets = new LeetCode78().subsets(nums);
        for (List<Integer> set: subsets) {
            System.out.println(set);
        }
    }

    private int length;

    private int[] nums;

    private List<List<Integer>> subsets;

    public List<List<Integer>> subsets(int[] nums) {
        length = nums.length;
        this.nums = nums;
        // 判断子集数量
        subsets = new ArrayList<>(getCountOfSubSets(length));
        dfs(0, new ArrayList<>());
        return subsets;
    }

    private void dfs(int index, List<Integer> currentSet) {
        if (index >= length) {
            subsets.add(currentSet);
            return ;
        }

        // 不取当前元素
        dfs(index + 1, currentSet);

        // 取当前元素
        List<Integer> copyList = new ArrayList<>(currentSet);
        copyList.add(nums[index]);
        dfs(index + 1, copyList);
    }

    /**
     * 根据数组长度求子集数量
     * 即C(n, 0) + C(n, 1) + ... + C(n, n)
     * @param length
     * @return
     */
    private int getCountOfSubSets(int length) {
        int result = 0;
        for (int i = 0; i <= length; i++) {
            result += combine(length, i);
        }
        return result;
    }

    /**
     * 求C(n, k)，从n个数里取k个数的组合
     * @param n
     * @param k
     * @return
     */
    private int combine(int n, int k) {
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
        }
        for (int i = k; i >= 1; i--) {
            result /= i;
        }
        return result;
    }
}

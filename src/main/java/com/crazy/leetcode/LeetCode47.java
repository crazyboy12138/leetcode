package com.crazy.leetcode;

import java.util.*;

/**
 * 全排列 II
 *
 * @author lintingmin
 * @date 2020-01-18
 */
public class LeetCode47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = new LeetCode47().permuteUnique(nums);
        int count = 0;
        for (List<Integer> list: lists) {
            System.out.println(list);
            count ++;
        }
        System.out.println(count);
    }

    private int[] nums;

    // mark[i] = 0 表示nums[i]未使用，mark[i] = 1表示nums[i]已使用
    private int[] mark;

    private int length;

    private List<Integer> tempList;

    private List<List<Integer>> resultList;

    private Set<String> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        length = nums.length;
        this.nums = nums;
        mark = new int[length];
        for (int i = 0; i < length; i++) {
            mark[i] = 0;
        }
        tempList = new ArrayList<>(length);
        resultList = new ArrayList<>();
        set = new HashSet<>();

        Arrays.sort(nums);

        dfsPermute(0);

        return resultList;
    }

    public void dfsPermute(int index) {
        if (index == length) {
            resultList.add(new ArrayList<>(tempList));
        }

        Integer temp = null;
        for (int i = 0; i < length; i++) {

            if (mark[i] == 0 ) {

                if (temp != null && nums[i] == temp) {
                    continue;
                } else {
                    temp = nums[i];
                }


                mark[i] = 1;
                tempList.add(nums[i]);
                dfsPermute(index + 1);
                mark[i] = 0;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

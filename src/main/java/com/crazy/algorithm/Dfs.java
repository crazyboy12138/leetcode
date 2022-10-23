package com.crazy.algorithm;

import java.util.Set;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-01-09
 */
public class Dfs {

    private int length;

    // 源数据
    private int[] nums;

    // 用于标记元素是否已使用
    private int[] mark;

    private int[] path;

    private static int count = 0;

    private void traverse(int[] nums) {
        this.nums = nums;
        length = nums.length;
        mark = new int[length];
        path = new int[length];

        for (int i = 0; i < length; i++) {
            // mark[i] == 0 表示nums[i]未使用
            mark[i] = 0;
        }

        dfsPermutation(0);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums = new int[]{1, 2, 3, 4};
        new Dfs().traverse(nums);
        System.out.println(count);
    }



    /**
     * 有序dfs，相当于全排列
     * @param index
     */
    public void dfsPermutation(int index){
        if (index == length) {
            for (int i = 0; i < length; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            count ++;
            return;
        }

        for (int i = 0; i < length; i++){
            if (mark[i] == 0) {
                path[index] = nums[i];
                mark[i] = 1;
                dfsPermutation(index + 1);
                mark[i] = 0;
            }
        }
    }

}

package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 最多能完成排序的块
 *
 * @author lintingmin
 * @date 2020-02-08
 */
public class LeetCode769 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,0};
        System.out.println(new LeetCode769().maxChunksToSorted(arr));
    }

    /**
     * 思路核心: 设arr[i]=k，则区间[i, k]必须为一个块
     * 以[0,1,5,3,2,4]为例，arr[2]=5，区间[2,5]，即[5,3,2,4]必须为一个块
     * 以[0,1,4,3,2,5]为例，arr[2]=4，区间[2,4]，即[4,3,2]必须为一个块
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return 0;
        }

        // 块的数量
        int blockCount = 1;

        // 左闭右闭区间[left, right]为一个不可切割的块
        int left = 0;
        int right = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // i <= right，表示在当前块内
            if (i <= right) {
                // 当前块内出现更大的数，把区间向右扩大
                if (arr[i] > right) {
                    right = arr[i];
                }
            }
            // i > right，表示开始了新的块
            else {
                blockCount ++;
                left = i;
                right = arr[i];
            }
        }

        return blockCount;
    }
}

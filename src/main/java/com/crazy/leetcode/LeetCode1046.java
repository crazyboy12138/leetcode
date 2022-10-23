package com.crazy.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最后一块石头的重量
 *
 * @author lintingmin
 * @date 2021-01-02
 */
public class LeetCode1046 {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(new LeetCode1046().lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        // 小顶堆，从大到小排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone: stones) {
            minHeap.offer(stone);
        }

        while (minHeap.size() > 1) {
            Integer first = minHeap.poll();
            Integer second = minHeap.poll();
            if (first.equals(second)) {
                continue;
            }
            minHeap.offer(first - second);
        }

        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }
}

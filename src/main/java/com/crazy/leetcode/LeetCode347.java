package com.crazy.leetcode;

import java.util.*;

/**
 * 前K个高频元素
 */
public class LeetCode347 {

    public static void main(String[] args) {
        int[] arr1 = new LeetCode347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(arr1));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return new int[0];
        }

        // key为元素，value为频率
        Map<Integer, Integer> numToFrequent = new HashMap<>();
        for (int num: nums) {
            numToFrequent.put(num, numToFrequent.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> frequentToNum = new HashMap<>();
        numToFrequent.entrySet().forEach(entry -> {
            List<Integer> tempNums = frequentToNum.getOrDefault(entry.getValue(), new ArrayList<>());
            tempNums.add(entry.getKey());
            frequentToNum.put(entry.getValue(), tempNums);
        });

        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        for (int frequent: frequentToNum.keySet()) {
            queue.add(frequent);
        }

        int[] topK = new int[k];
        int index = 0;
        while (index < k) {
            Integer frequency = queue.poll();
            List<Integer> arr = frequentToNum.get(frequency);
            for (int i = 0; i < arr.size() && index < k; i++) {
                topK[index++] = arr.get(i);
            }
        }

        return topK;
    }
}

package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode752 {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        if (target == null || target.length() != 4) {
            return -1;
        }

        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        int minTimes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentNumber = queue.poll();
                if (currentNumber.equals(target)) {
                    return minTimes;
                }

                // 获取下一步可能出现的数字
            }

            minTimes++;
        }
        return minTimes;
    }

    private List<String> getNextNumbers(String currentNumber, String[] deadends) {
        List<String> nextNumberList = new ArrayList<>();


    }
}

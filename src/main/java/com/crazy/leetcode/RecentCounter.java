package com.crazy.leetcode;

import java.util.*;

/**
 * 933. 最近的请求次数
 *
 * @author lintingmin
 * @date 2020-11-14
 */
public class RecentCounter {

    private int[] times = new int[10000 + 10];
    private int count = 0;
    private int lastIndex = 0;

    public RecentCounter() {

    }

    public int ping(int t) {
        times[count++] = t;
        int index = Arrays.binarySearch(times, lastIndex, count, t - 3000);
        if (index < 0) {
            index = -(index + 1);
        }
        lastIndex = index;
        return count - index;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(100);
        list.add(3001);
        list.add(3002);
        int index = Collections.binarySearch(list, 2);
        if (index < 0) {
            index = -(index + 1);
        }
        System.out.println(index);
    }
}

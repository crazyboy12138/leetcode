package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 丑数 II
 *
 * @author lintingmin
 * @date 2020-05-03
 */
public class LeetCode264 {
    public static void main(String[] args) {
        System.out.println((new LeetCode264().nthUglyNumber(10)));
//        System.out.println(new LeetCode264().nthUglyNumber(2000));
    }

    public int nthUglyNumber(int n) {
        /**
         * 按顺序储存前limit个丑数
         */
        int[] uglyNums = new int[n];

        /**
         * 存储临时丑数
         */
        TreeSet<Long> set = new TreeSet<>();

        int count = 0;
        set.add(1L);

        while (count < n && !set.isEmpty()) {
            // set中最小的丑数
            Long minInSet = set.iterator().next();
            uglyNums[count++] = minInSet.intValue();

            set.add(minInSet * 2);
            set.add(minInSet * 3);
            set.add(minInSet * 5);

            set.remove(minInSet);
        }

        return uglyNums[n - 1];
    }

}

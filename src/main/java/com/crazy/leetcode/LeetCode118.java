package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author lintingmin
 * @date 2020-01-18
 */
public class LeetCode118 {
    public static void main(String[] args) {
        List<List<Integer>> generate = new LeetCode118().generate(8);
        generate.forEach(x -> {
            System.out.println(x);
        });
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>(numRows);

        if (numRows == 0) {
            return resultList;
        }

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);

        List<Integer> last;
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            last = resultList.get(i - 1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(last.get(j) + last.get(j + 1));
            }
            temp.add(1);
            resultList.add(temp);
        }
        return resultList;
    }
}

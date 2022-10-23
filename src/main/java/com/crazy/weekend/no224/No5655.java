package com.crazy.weekend.no224;

import javafx.util.Pair;

import java.util.*;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2021-01-17
 */
public class No5655 {
    public static void main(String[] args) {
        new No5655().largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1},{1,0,1}});
    }

    public int largestSubmatrix(int[][] matrix) {
        Map<Integer, List<Integer>> countToIndexMap = new HashMap<>(16);
        int[] indexToCount = new int[matrix.length];

        for(int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            int count = 0;
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 1) {
                    count ++;
                }
            }
            if (countToIndexMap.containsKey(count)) {
                countToIndexMap.get(count).add(i);
            } else {
                List<Integer> list = new ArrayList<>(16);
                list.add(i);
                countToIndexMap.put(count, list);
            }
            indexToCount[i] = count;
        }

        // 对map的key降序排序
        TreeSet<Integer> countSet = new TreeSet(countToIndexMap.keySet());
        System.out.println(countToIndexMap);

        Map<Integer, List<List<Integer>>> sumToIndexMap = new HashMap<>(16);
        int k = 1;
        for (int i = countSet.size() - 1; i >= 0; i--) {
            int count = countSet.last();
            List<Integer> indexs = countToIndexMap.get(count);
            for (int index: indexs) {
                List<Integer> list = new ArrayList<>();
                for (int sum: sumToIndexMap.keySet()) {
                    List<List<Integer>> lists = sumToIndexMap.get(sum);

                }
                list.add(index);

            }
        }

        System.out.println(sumToIndexMap);

        for (int i = countSet.size() - 1; i >= 0; i--) {
            int count = countSet.last();
            List<Integer> indexs = countToIndexMap.get(count);
            if (indexs.size() == 1) {
                return count;
            }
            if (check(indexs, matrix, indexToCount)) {
                return count;
            }
        }
        return 0;
    }

    private boolean check(List<Integer> indexs, int[][] matrix, int[] indexToCount) {
        int minCount = indexToCount[indexs.get(0)];
        int minIndex = indexs.get(0);
        for (int i = 1; i < indexs.size(); i++) {
            Integer index = indexs.get(i);
            if (indexToCount[index] < minCount) {
                minIndex = index;
                minCount = indexToCount[index];
            }
        }

        int[] minLine = matrix[minIndex];
        for (int i = 0; i < minLine.length; i++) {
            if (minLine[i] == 1) {
                for (int j = 0; j < indexs.size() && j != minIndex; j++) {
                    int[] otherLine = matrix[j];
                    if (otherLine[i] != 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

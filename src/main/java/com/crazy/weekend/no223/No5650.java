package com.crazy.weekend.no223;

import java.util.*;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2021-01-10
 */
public class No5650 {

    public static void main(String[] args) {
        System.out.println(new No5650().minimumHammingDistance(new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}}));
        System.out.println(new No5650().minimumHammingDistance(new int[]{1,2,3,4}, new int[]{1,3,2,4}, new int[][]{}));
        System.out.println(new No5650().minimumHammingDistance(new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}}));
    }

    int[] parents;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int length = source.length;
        parents = new int[length];
        for (int i = 0; i < length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < allowedSwaps.length; i++) {
            int index1 = allowedSwaps[i][0];
            int index2 = allowedSwaps[i][1];
            int parent1 = findParent(index1);
            int parent2 = findParent(index2);
            if (parent1 != parent2) {
                parents[parent2] = parent1;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            int parent = findParent(parents[i]);
            if (!map.containsKey(parent)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(parent, temp);
            } else {
                map.get(parent).add(i);
            }
        }

        int minHm = 0;

        Collection<List<Integer>> sets = map.values();
        for (List<Integer> set: sets) {
            List<Integer> sourceTemp = new ArrayList<>(set.size());
            int[] targetTemp = new int[set.size()];
            for (int i = 0; i < set.size(); i++) {
                sourceTemp.add(source[set.get(i)]);
                targetTemp[i] = target[set.get(i)];
            }
            Collections.sort(sourceTemp);
            for (int num: targetTemp) {
                int result = Collections.binarySearch(sourceTemp, num);
                if (result >= 0) {
                    sourceTemp.remove(result);
                }
            }
            minHm += sourceTemp.size();
        }

        return minHm;
    }

    private int findParent(int x) {
        int parent = parents[x] == x ? x : findParent(parents[x]);
        if (parent != parents[x]) {
            parents[x] = parent;
        }
        return parent;
    }
}

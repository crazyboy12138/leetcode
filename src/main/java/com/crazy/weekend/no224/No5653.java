package com.crazy.weekend.no224;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以形成最大正方形的矩形数目
 *
 * @author lintingmin
 * @date 2021-01-17
 */
public class No5653 {
    public static void main(String[] args) {

    }

    public int countGoodRectangles(int[][] rectangles) {
        int largest = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rectangle: rectangles) {
            int length = rectangle[0];
            int width = rectangle[1];
            int min = Math.min(length, width);
            largest = min > largest ? min : largest;
            map.put(min, map.containsKey(min) ? map.get(min) + 1 : 1);
        }
        return map.get(largest);
    }
}

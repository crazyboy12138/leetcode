package com.crazy.weekend.no224;

import java.util.HashMap;
import java.util.Map;

/**
 * 同积元组
 *
 * @author lintingmin
 * @date 2021-01-17
 */
public class No1726 {
    public static void main(String[] args) {
        System.out.println(new No1726().tupleSameProduct(new int[]{2,3,4,6}));
        System.out.println(new No1726().tupleSameProduct(new int[]{1,2,4,5,10}));
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] * nums[j];
                map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
            }
        }
        int result = 0;
        for (int sum: map.keySet()) {
            Integer count = map.get(sum);
            if (count > 1) {
                int combine = count * (count - 1) / 2;
                result += combine * 8;
            }
        }
        return result;
    }
}

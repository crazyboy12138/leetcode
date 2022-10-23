package com.crazy.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 供暖器
 *
 * @author lintingmin
 * @date 2020-07-12
 */
public class LeetCode475 {
    public static void main(String[] args) {
        System.out.println(new LeetCode475().findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println(new LeetCode475().findRadius(new int[]{1,2,3,4}, new int[]{1, 4}));
        System.out.println(new LeetCode475().findRadius(new int[]{1,2,3,4}, new int[]{1}));
        System.out.println(new LeetCode475().findRadius(new int[]{474833169,264817709,998097157,817129560}, new int[]{197493099,404280278,893351816,505795335}));
        System.out.println(new LeetCode475().findRadius(new int[]{1,2,3,5,15}, new int[]{2,30}));
        System.out.println(new LeetCode475().findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        // 从小到大排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 最小半径一定是某个house与某个heater之间的距离，即刚刚好能覆盖
        // 所以先从小到大算出所有可能的最小半径（剪枝），再一一遍历看是否满足条件

        // 使用Set去重
        Set<Integer> set = new HashSet<>();
        // 剪枝一: 已经计算过的house不再参与计算，所以j放外面
        int j = 0;
        for (int i = 0; i < heaters.length; i++) {
            for (; j < houses.length; j++) {
                // 半径
                int radius = Math.abs(houses[j] - heaters[i]);
                if (set.contains(radius)) {
                    continue;
                }
                // 剪枝二: 如果当前house的位置离下一个heater更近，跳出循环
                if (i < heaters.length - 1 && Math.abs(houses[j] - heaters[i + 1]) < radius) {
                    break;
                }

                // 判断当前半径是否满足条件
                boolean success = true;
                // 剪枝三: 如果前i个heater都不能覆盖当前house，那么下一个house也不用考虑前i个heater，因为下一个house离前i个heater更远，所以k放外面
                int k = 0;
                for (int house: houses) {
                    // 当前house是否能被任意一个heater覆盖
                    boolean covered = false;
                    for (; k < heaters.length; k++) {
                        if (house >= heaters[k] - radius & house <= heaters[k] + radius) {
                            covered = true;
                            // 当前heater满足当前house，看下一个house
                            break;
                        }
                    }
                    // 任意一个house不能被所有heater覆盖，看下一个半径
                    if (!covered) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    return radius;
                }

                set.add(Math.abs(houses[j] - heaters[i]));
            }
        }

        return -1;
    }
}

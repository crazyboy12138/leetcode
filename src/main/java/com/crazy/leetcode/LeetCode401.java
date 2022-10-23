package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表
 *
 * @author lintingmin
 * @date 2020-06-27
 */
public class LeetCode401 {
    public static void main(String[] args) {
        System.out.println(new LeetCode401().readBinaryWatch(1));
        System.out.println(new LeetCode401().readBinaryWatch(2));
        System.out.println(new LeetCode401().readBinaryWatch(6));
        System.out.println(new LeetCode401().readBinaryWatch(7));
        System.out.println(new LeetCode401().readBinaryWatch(20));
    }

    /**
     * 下标i表示二进制中1的数量，值表示二进制中1的数量为i的数
     */
    int[][] arr;

    /**
     * arr第二维数组的实际长度
     */
    int[] realSize;

    public List<String> readBinaryWatch(int num) {
        // 把0到59这60个数字的二进制中1的数量储存起来
        int[][] arr = generateArr();

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= num; i++) {
            // i表示小时部分亮灯数，j表示分钟部分亮灯数
            int j = num - i;
            for (int hour = 0; i <= 4 && hour < realSize[i] && arr[i][hour] < 12; hour++) {
                for (int minute = 0; j <= 6 && minute < realSize[j]; minute++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i][hour])
                      .append(":")
                      .append(arr[j][minute] > 9 ? arr[j][minute] : ("0" + arr[j][minute]));
                    result.add(sb.toString());
                }
            }
        }

        return result;
    }

    /**
     * 构造二维数组arr
     * @return
     */
    private int[][] generateArr() {
        arr = new int[7][60];
        realSize = new int[7];
        for (int i = 0; i <= 59; i++) {
            int countOfOne = getCountOfOne(i);
            arr[countOfOne][realSize[countOfOne]] = i;
            realSize[countOfOne] ++;
        }
        return arr;
    }

    /**
     * 求num的二进制中1的数量
     * @param num
     * @return
     */
    private int getCountOfOne(int num) {
        int count = 0;
        while (num > 0) {
            // 求num是2的几次幂
            int power = (int)(Math.log(num) / Math.log(2));
            count ++;
            num -= Math.pow(2, power);
        }
        return count;
    }
}

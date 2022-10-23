package com.crazy.leetcode;

/**
 * 面试题 17.09. 第 k 个数
 *
 * @author lintingmin
 * @date 2020-12-06
 */
public class LeetCode17_09 {

    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }

        // 素数
        int[] prime = new int[]{3, 5, 7};
        // 历史值，第一维表示已算出的数，第二维表示第一维下次参与计算时，要乘的素数，第二维的取值范围是prime数组的下标
        long[][] history = new long[10000][1];
        history[0] = new long[]{1, 0};
        // history数组中，下标在validFlag之前的是无效数据，不参与计算
        int validFlag = 0;
        // history数组的真实大小
        int actualSize = 1;

        for (int i = 1; i <= k - 1; i++) {
            long min = Long.MAX_VALUE;
            int minHistory = -1;
            for (int j = validFlag; j < actualSize; j++) {
                long value = history[j][0] * prime[(int) history[j][1]];
                if (value < min) {
                    minHistory = j;
                    min = value;
                }
            }

            history[minHistory][1] ++;
            // 如果某一个历史值乘以最大的素数也成为历史值，该历史值设为无效，不再参与计算
            if (history[minHistory][1] == prime.length) {
                validFlag = minHistory + 1;
            }

            if (min == history[actualSize - 1][0]) {
                k++;
            } else {
                history[actualSize++] = new long[]{min, 0};
            }

        }
        return (int)history[actualSize - 1][0];
    }


    public static void main(String[] args) {
//        System.out.println(": " + new LeetCode17_09().getKthMagicNumber(3));
//        System.out.println(": " + new LeetCode17_09().getKthMagicNumber(251));
//        System.out.println(": " + new LeetCode17_09().getKthMagicNumber(643));
        for (int i = 1; i < 10; i ++) {
            System.out.println(i + ": " + new LeetCode17_09().getKthMagicNumber(i));
        }
    }
}

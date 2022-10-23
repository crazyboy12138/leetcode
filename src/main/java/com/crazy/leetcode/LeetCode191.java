package com.crazy.leetcode;

/**
 * 位1的个数
 *
 * @author lintingmin
 * @date 2020-03-05
 */
public class LeetCode191 {
    public static void main(String[] args) {
//        System.out.println(new LeetCode191().hammingWeight(9));
//        System.out.println(new LeetCode191().hammingWeight(8));
//        System.out.println(new LeetCode191().hammingWeight(17));
//        System.out.println(new LeetCode191().hammingWeight(2));
//        System.out.println(new LeetCode191().hammingWeight(4));
        System.out.println();
        System.out.println(new LeetCode191().hammingWeight(0));
        System.out.println(new LeetCode191().hammingWeight(-9));
        System.out.println(new LeetCode191().hammingWeight(-10));
        System.out.println(new LeetCode191().hammingWeight(-16));
    }

    public int hammingWeight(int n) {
        if (n == Integer.MIN_VALUE) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        // 1的位数
        int count = 0;
        // 是否正数
        boolean positive = n > 0;
        // 取绝对值
        n = Math.abs(n);
        // 最低位的1的位置
        int lowOne = 1;
        // 是否已经获取lowOne
        boolean hasGetLowOne = false;

        // 处理正数
        while (n > 0) {
            if (n % 2 == 1) {
                hasGetLowOne = true;
            }

            count += n % 2;
            n /= 2;

            if (!hasGetLowOne) {
                lowOne ++;
            }
        }

        // 正数直接返回count
        if (positive) {
            return count;
        }

        // 如果最低位是1，那么除了符号位和最低位，其余30位是互补的
        if (lowOne == 1) {
            return (30 - (count - 1)) + 2;
        }

        // 如果最低位是0，那么最低位的1之前，除了符号位，是互补的，最低位的1之后，一定都是0
        return (31 - lowOne - (count - 1)) + 2;
    }
}

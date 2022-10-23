package com.crazy.leetcode;

/**
 * 	数字范围按位与
 *
 * @author lintingmin
 * @date 2020-06-27
 */
public class LeetCode201 {
    public static void main(String[] args) {
        System.out.println(new LeetCode201().rangeBitwiseAnd(5, 7));
        System.out.println(new LeetCode201().rangeBitwiseAnd(4, 6));
        System.out.println(new LeetCode201().rangeBitwiseAnd(5, 9));
        System.out.println(new LeetCode201().rangeBitwiseAnd(0, 1));
        System.out.println(new LeetCode201().rangeBitwiseAnd(2147483646, 2147483647));
    }

    /**
     * 有以下规律：
     * 1. 假如有一个数2^k（k是整数），那么小于2^k的数与2^k相与之后结果是0，因为2^k的末尾k位都是0
     * 2. 如果a != b，那么2^a & 2^b == 0
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        if (m == n) {
            return m;
        }

        // n是2的几次幂
        int power = (int)(Math.log(n) / Math.log(2));
        // 离n最近的2的幂次方
        int nearestPowerOf2 = (int)Math.pow(2, power);

        // 如果nearestPowerOf2 < m，后面那几位的结果无法确定，m到n分别减去nearestPowerOf2，再递归相与
        if (nearestPowerOf2 < m) {
            return nearestPowerOf2 + rangeBitwiseAnd(m - nearestPowerOf2, n - nearestPowerOf2);
        }

        // 如果nearestPowerOf2 == m，结果就是nearestPowerOf2，因为最高位全都是1，其余的低位与2^power相与结果都是0，
        if (nearestPowerOf2 == m) {
            return nearestPowerOf2;
        }

        // 如果m < nearestPowerOf2，结果是0，因为最高位同时有1和0，其余的低位与2^power相与结果都是0
        if (nearestPowerOf2 > m) {
            return 0;
        }

        return 0;
    }
}

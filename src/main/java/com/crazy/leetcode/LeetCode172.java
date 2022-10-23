package com.crazy.leetcode;

/**
 * 阶乘后的零
 *
 * @author lintingmin
 * @date 2020-09-05
 */
public class LeetCode172 {
    public static void main(String[] args) {
        System.out.println(new LeetCode172().trailingZeroes(125));
        System.out.println(new LeetCode172().trailingZeroes(126));
    }

    /**
     * 思路
     * 只有2*5会产生0，而2的数量一定比5多（每5个数有两个2，一个5），所以本题的结果，其实就是n!中含因子5的数量
     * 设最终结果为result
     * 假设1到n中，共有k1个5^1的倍数，5^1至少含1个因子5，result += k1
     * 假设1到n中，共有k2个5^2的倍数，5^2至少含2个因子5，但是其中1个上一步已经算过了，所以新增的因子5的数量只有k2，result += k2
     * 假设1到n中，共有k3个5^3的倍数，5^3至少含3个因子5，但是其中2个上一步已经算过了，所以新增的因子5的数量只有k3，result += k3
     * 依此类推
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int result = 0;
        // multiple是5的倍数
        for (long multiple = 5; multiple <= n; multiple *= 5) {
            result += n / multiple;
        }
        return result;
    }
}

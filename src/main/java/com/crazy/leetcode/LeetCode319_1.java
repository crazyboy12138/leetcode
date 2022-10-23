package com.crazy.leetcode;

/**
 * 灯泡开关
 *
 * @author lintingmin
 * @date 2020-06-21
 */
public class LeetCode319_1 {
    public static void main(String[] args) {
        System.out.println(new LeetCode319_1().bulbSwitch(1));
        System.out.println(new LeetCode319_1().bulbSwitch(2));
        System.out.println(new LeetCode319_1().bulbSwitch(3));
        System.out.println(new LeetCode319_1().bulbSwitch(4));
        System.out.println(new LeetCode319_1().bulbSwitch(5));
        System.out.println(new LeetCode319_1().bulbSwitch(99999));
        System.out.println(new LeetCode319_1().bulbSwitch(99999999));
    }

    /**
     * 发现规律：入参1到n的结果，打表后是3个1，5个2，7个3，9个4...
     * 分析：
     * 如LeetCode319中所说，对于第i个灯泡，只有当i是平方数时，最后第i个灯才会亮。
     * 设a、b是两个相邻的平方数（a < b），对于a、b之间的非平方数i，bulbSwitch(i)一定等于bulbSwitch(a)
     * 比如，a = 4, b = 9, 5至8是非平方数（最后都不亮），所以n = 5至8时，结果等于n = 4
     * 所以，1 - 3, 4 - 8, 9 - 15...每一组的结果都是一样的，也就是3个1，5个2，7个3...
     *
     * 最终答案其实也可以简化为一行代码：（int)Math.sqrt(n)
     * 即bulbSwitch(n) = 小于等于n的平方数的个数，因为只有平方数会亮
     * 如果n开方后等于k，说明n之前（包括n本身），有k个平方数
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 3;
        int count = 1;
        for (int i = 5; i <= Integer.MAX_VALUE; i += 2) {
            if (n <= sum) {
                return count;
            }
            sum += i;
            count ++;
        }
        return -1;
    }
}

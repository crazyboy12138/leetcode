package com.crazy.leetcode;

/**
 * 灯泡开关
 *
 * @author lintingmin
 * @date 2020-06-20
 */
public class LeetCode319 {
    public static void main(String[] args) {
//        System.out.println(new LeetCode319().bulbSwitch(1));
//        System.out.println(new LeetCode319().bulbSwitch(2));
//        System.out.println(new LeetCode319().bulbSwitch(3));
//        System.out.println(new LeetCode319().bulbSwitch(4));
//        System.out.println(new LeetCode319().bulbSwitch(5));
//        System.out.println(new LeetCode319().bulbSwitch(99999));
//        System.out.println(new LeetCode319().bulbSwitch(99999999));


        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ": " + new LeetCode319().bulbSwitch(i));
        }
    }

    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }

        // 对1到n个灯泡执行n轮操作，第i个灯泡被切换开关的次数，等于i的因子个数
        // 所有灯泡默认是关闭，偶数次操作相当于不操作，所以只需要统计因子数为奇数的数量
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 如果一个数不是平方数，因子数一定是偶数，因为一定可以拆成若干对不同的因子相乘
            // 如果一个数是平方数，因子数一定是奇数
            int sqrt = (int)Math.sqrt(i);
            // sqrt * sqrt == i，说明是平方数，即因子数是奇数
            if (sqrt * sqrt == i) {
                answer ++;
            }
        }

        return answer;
    }
}

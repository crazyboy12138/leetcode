package com.crazy.leetcode;

/**
 * 除数博弈
 *
 * @author lintingmin
 * @date 2020-12-13
 */
public class LeetCode1025 {
    public static void main(String[] args) {

    }

    /**
     * 思路分析：
     * 假设A、B两个玩家，A先操作
     * 若N=1，A必输，因为没法执行操作了
     * 若N=2，A必赢，因为只要A选1，N变成1，B必输
     * 若N=3，A必输，因为A只能选1，N变成2，B必赢
     * 若N=4，A必赢，因为只要A选1，N变成3，B必输
     * 若N=5，A必输，因为A只能选1，N变成4，B必赢
     * ...
     * 若N=9，A必输，因为9的因子一定是奇数，A操作后N一定是偶数，按照上面的规律，B必赢
     * ...
     * 综上，若N是奇数，A必输，否则A必赢
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}

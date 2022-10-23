package com.crazy.leetcode;

/**
 * 第K个语法符号
 *
 * @author lintingmin
 * @date 2020-06-06
 */
public class LeetCode779 {
    public static void main(String[] args) {
        System.out.println(new LeetCode779().kthGrammar(1, 1));
        System.out.println(new LeetCode779().kthGrammar(2, 1));
        System.out.println(new LeetCode779().kthGrammar(2, 2));
        System.out.println(new LeetCode779().kthGrammar(4, 5));
    }

    /**
     * 第N行的第K个字符，是由上一行的第K/2或(K+1)/2个字符产生的，取决于K是偶数还是奇数
     * 比如第3行的第4个字符是0，所以第4行的第7个字符是0，第8个字符是1
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        if (K % 2 == 0) {
            int last = kthGrammar(N - 1, K / 2);
            return last == 0 ? 1 : 0;
        }

        int last = kthGrammar(N - 1, (K + 1) / 2);
        return last == 0 ? 0 : 1;
    }
}

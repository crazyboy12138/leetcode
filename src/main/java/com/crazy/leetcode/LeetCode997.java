package com.crazy.leetcode;

/**
 * 找到小镇的法官
 *
 * @author lintingmin
 * @date 2020-11-21
 */
public class LeetCode997 {
    public static void main(String[] args) {
        System.out.println(new LeetCode997().findJudge(1, new int[][]{}));
        System.out.println(new LeetCode997().findJudge(2, new int[][]{{1, 2}}));
        System.out.println(new LeetCode997().findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(new LeetCode997().findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(new LeetCode997().findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        System.out.println(new LeetCode997().findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }

    public synchronized int findJudge(int N, int[][] trust) {
        if (null == trust || N == 0) {
            return -1;
        }

        // trustOther[i]=true表示i信任了其他人，即i不可能是法官
        boolean[] trustOther = new boolean[N + 1];

        // trustCount[i]表示i取得了trustCount[i]个信任，法官必须取得N-1个信任
        int[] trustCount = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            int[] pair = trust[i];
            trustOther[pair[0]] = true;
            trustCount[pair[1]] ++;
        }

        for (int i = 1; i <= N; i++) {
            // 没有信任其他人，且取得了N-1个信任，一定是法官
            if (!trustOther[i] && trustCount[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
}

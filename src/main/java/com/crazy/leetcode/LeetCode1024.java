package com.crazy.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 视频拼接
 *
 * @author lintingmin
 * @date 2020-05-17
 */
public class LeetCode1024 {
    public static void main(String[] args) {
        int [][] clips1 = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        System.out.println(new LeetCode1024().videoStitching(clips1, 10));

        int[][] clips2 = new int[][]{{0,1},{3,5}};
        System.out.println(new LeetCode1024().videoStitching(clips2, 5));

        int[][] clips3 = new int[][]{{0,1},{1,2}};
        System.out.println(new LeetCode1024().videoStitching(clips3, 5));

        int[][] clips4 = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(new LeetCode1024().videoStitching(clips4, 9));

        int[][] clips5 = new int[][]{{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        System.out.println(new LeetCode1024().videoStitching(clips5, 5));
    }

    private int[][] clips;

    private int T;

    public int videoStitching(int[][] clips, int T) {
        this.clips = clips;
        this.T = T;

        // 对clips升序排序，先排clips[i][0]，再排clips[i][1]
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ?  o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        if (clips[0][0] > 0 || clips[clips.length - 1][1] < T) {
            return -1;
        }

        Integer result = Integer.MAX_VALUE;

        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] < T && clips[i][1] >= T) {
                result = Math.min(dp(i), result);
            }
        }

        return result;
    }

    /**
     * dp(i)表示: 以第i段为末端时，最小所需片段数
     * @param i
     * @return
     */
    public int dp(int i) {
        if (clips[i][0] == 0) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < i; j++) {
            if (clips[j][1] >= clips[i][0]) {
                result = Math.min(result, dp(j) + 1);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}

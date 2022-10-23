package com.crazy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不同路径
 * TODO 哈希冲突会不会影响
 * 两个数组不相同，hashcode还是又可能相同
 *
 * @author lintingmin
 * @date 2020-08-08
 */
public class LeetCode62 {
    public static void main(String[] args) {
        System.out.println(new LeetCode62().uniquePaths(3,2 ));
        System.out.println(new LeetCode62().uniquePaths(7, 3 ));
        System.out.println(new LeetCode62().uniquePaths(3,3 ));
        System.out.println(new LeetCode62().uniquePaths(10, 10 ));
        System.out.println(new LeetCode62().uniquePaths(3, 7));
        System.out.println(new LeetCode62().uniquePaths(1,2));
        System.out.println(new LeetCode62().uniquePaths(4, 4));
        System.out.println(new LeetCode62().uniquePaths(23, 12));

    }

    /**
     * 向下和向右两个方向
     */
    private int[][] directions = new int[][]{{0, 1}, {1, 0}};

    /**
     * pathCount[y][x]表示: 从坐标(x,y)走到终点，有多少种不同的路径
     */
    private int[][] pathCount;

    /**
     * 对路径的hash值去重
     */
    private Set<Integer> set = new HashSet<>();

    private int m, n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        pathCount = new int[n][m];
        // 初始化为-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pathCount[i][j] = -1;
            }
        }
        return dfs(0, 0, 1);
    }

    /**
     * dfs遍历每一条路径
     * @param x x轴坐标
     * @param y y轴坐标
     * @param hash 坐标的哈希值，唯一标识一个坐标
     * @return 从坐标(x,y)走到终点，有多少种不同的路径
     */
    private int dfs(int x, int y, int hash) {
        // 走到了终点
        if (x == m - 1 && y == n - 1) {
            if (set.contains(hash)) {
                return 0;
            }
            set.add(hash);
            return 1;
        }

        // pathCount[y][x]不等于初始值，说明坐标(x,y)已经访问过，直接返回计算过的路劲数
        if (pathCount[y][x] != -1) {
            return pathCount[y][x];
        }

        // 当前坐标走到终点有几种不同的路径
        int count = 0;

        for (int i = 0; i < directions.length; i++) {
            // 下一步的x轴、y轴坐标
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if (check(nextX, nextY)) {
                // 唯一标识一个坐标
                int newHash = 31 * hash + getPlace(nextX, nextY);
                count += dfs(nextX, nextY, newHash);
            }
        }
        pathCount[y][x] = count;
        return count;
    }

    private boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    /**
     * 二维数组压缩成一维
     * @param x
     * @param y
     * @return
     */
    private int getPlace(int x, int y) {
        return y * m + (x + 1);
    }
}

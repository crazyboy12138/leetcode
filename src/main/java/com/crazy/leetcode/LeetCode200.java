package com.crazy.leetcode;

/**
 * 岛屿数量
 *
 * @author lintingmin
 * @date 2020-07-04
 */
public class LeetCode200 {
    public static void main(String[] args) {
//        new LeetCode200().test1();
        new LeetCode200().test2();
    }

    private void test1(){
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    private void test2(){
        char[][] gird = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(gird));
    }

    /**
     * isVisited[i][j]=true表示grid[i][j]已被访问，默认为false
     */
    private boolean[][] isVisited;

    /**
     * 搜索方向：上右下左
     */
    private int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        isVisited = new boolean[grid.length][grid[0].length];
        // 岛屿数量
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                // 如果grid[x][y]为1且未访问过，把grid[x][y]相邻的陆地都设置为已访问
                if (grid[x][y] == '1' && !isVisited[x][y]) {
                    count ++;
                    dfs(x, y);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && !isVisited[x][y] && grid[x][y] == '1') {
            isVisited[x][y] = true;
            for (int i = 0; i < direction.length; i++) {
                dfs(x + direction[i][0], y + direction[i][1]);
            }
        }
    }
}

package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 被围绕的区域
 *
 * @author lintingmin
 * @date 2020-11-07
 */
public class LeetCode130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'}};
        new LeetCode130().print(board);
        new LeetCode130().solve(board);
        System.out.println();
        new LeetCode130().print(board);
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 上右下左
     */
    int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * isNotSurrounded[i][j] = true表示board[i][j]没有被 'X' 围绕，默认为false
     */
    boolean[][] isNotSurrounded;

    char[][] board;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return ;
        }

        isNotSurrounded = new boolean[board.length][board[0].length];
        this.board = board;

        for (int j = 0; j < board[0].length; j++) {
            // 第一行
            if (board[0][j] == 'O' && (!isNotSurrounded[0][j])) {
                isNotSurrounded[0][j] = true;
                dfs(0, j);
            }
            // 最后一行
            if (board[board.length - 1][j] == 'O' && (!isNotSurrounded[board.length - 1][j])) {
                isNotSurrounded[board.length - 1][j] = true;
                dfs(board.length - 1, j);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            // 第一列
            if (board[i][0] == 'O' && (!isNotSurrounded[i][0])) {
                isNotSurrounded[i][0] = true;
                dfs(i, 0);
            }
            // 最后一列
            if (board[i][board[0].length - 1] == 'O' && (!isNotSurrounded[i][board[0].length - 1])) {
                isNotSurrounded[i][board[0].length - 1] = true;
                dfs(i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && (!isNotSurrounded[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 把与board[i][j]相连的'O'标识为没有被 'X' 围绕
     */
    private void dfs(int i, int j) {
        for (int k = 0; k < direction.length; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (check(x, y) && board[x][y] == 'O' && (!isNotSurrounded[x][y])) {
                isNotSurrounded[x][y] = true;
                dfs(x, y);
            }
        }
    }

    /**
     * 判断board[i][j]是否合法
     */
    private boolean check(int i, int j) {
        return  i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

}

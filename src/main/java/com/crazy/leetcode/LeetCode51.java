package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode51 {
    public static void main(String[] args) {
        System.out.println(new LeetCode51().solveNQueens(4));
        System.out.println(new LeetCode51().solveNQueens(1));
    }

    /**
     * n x n 的棋盘
     */
    private char[][] board;

    /**
     * 皇后
     */
    private char QUEUE = 'Q';

    /**
     * 空位
     */
    private char EMPTY = '.';

    /**
     * 最终结果
     */
    private List<List<String>> result = new ArrayList<>();

    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        // 初始化棋盘，全都初始化为空位
        init(n);

        // 从第0行开始
        dfs(0);

        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            addResult();
            return;
        }


        for (int column = 0; column < n; column++) {
            // 判断board[row][column]是否可以放皇后
            if (!isValid(row, column)) {
                continue;
            }

            board[row][column] = QUEUE;
            // 同一行最多放一个皇后，因此当前行任意一列放置皇后之后，直接看下一行
            dfs(row + 1);
            board[row][column] = EMPTY;
        }
    }

    /**
     * 判断board[row][column]是否可以放皇后
     *
     * @param row 行
     * @param column 列
     * @return true/false
     */
    private boolean isValid(int row, int column) {
        // 检查相同列上是否有皇后
        for (int i = 0; i <= row; i++) {
            if (board[i][column] == QUEUE) {
                return false;
            }
        }

        // 检查左上角是否有皇后
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            // 如果当前位置是[2,3]，需要检查[1,2]和[0,1]
            if (board[i][j] == QUEUE) {
                return false;
            }
        }

        // 检查右上角是否有皇后
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            // 如果当前位置是[2,0]，需要检查[1,1]和[0,2]
            if (board[i][j] == QUEUE) {
                return false;
            }
        }

        return true;
    }

    private void init(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    /**
     * 把当前棋盘放到最终结果里
     */
    private void addResult() {
        List<String> list = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < n; column++) {
                sb.append(board[row][column]);
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}

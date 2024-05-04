package com.crazy.leetcode;

/**
 * 二维区域和检索-矩阵不可变
 */
public class LeetCode304 {
    public static void main(String[] args) {

    }



    class NumMatrix {

        /**
         * preSum[x][y]表示以[0][0]为左上角，[x][y]为右下角的矩阵的元素和
         */
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                preSum = new int[0][0];
                return;
            }

            initPreSum(matrix);
        }

        private void initPreSum(int[][] matrix) {
            int rowLen = matrix.length;
            int columnLen = matrix[0].length;
            preSum = new int[rowLen][columnLen];

            preSum[0][0] = matrix[0][0];

            // x=0时，初始化preSum数组
            for (int column = 1; column < columnLen; column++) {
                preSum[0][column] = preSum[0][column - 1] + matrix[0][column];
            }

            // y=0时，初始化preSum数组
            for (int row = 1; row < rowLen; row++) {
                preSum[row][0] = preSum[row - 1][0] + matrix[row][0];
            }

            // 剩余坐标计算preSum
            for (int row = 1; row < rowLen; row++) {
                for (int column = 1; column < columnLen; column++) {
                    preSum[row][column] = preSum[row - 1][column] + preSum[row][column - 1] - preSum[row - 1][column - 1] + matrix[row][column];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0) {
                return preSum[row2][col2];
            }

            if (row1 == 0) {
                return preSum[row2][col2] - preSum[row2][col1 - 1];
            }

            if (col1 == 0) {
                return preSum[row2][col2] - preSum[row1 - 1][col2];
            }

            return preSum[row2][col2]
                - preSum[row1 - 1][col2]
                - preSum[row2][col1 - 1]
                + preSum[row1 - 1][col1 - 1];
        }
    }
}

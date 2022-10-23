package com.crazy.leetcode;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author lintingmin
 * @date 2020-09-13
 */
public class LeetCode120_2 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int length = triangle.size();
        // 注意：这里定义的数组偏大，相当于多了一层虚拟的第length+1层，这一层的结点值都是0
        int[][] dp = new int[length + 1][length + 1];

        // 从第length层开始往上遍历
        for (int i = length - 1; i >= 0; i--) {
            // 当前层
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                // 把当前元素设置为: 当前元素 + 相邻结点中的较小值
                dp[i][j] = current.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}

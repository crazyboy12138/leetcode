package com.crazy.leetcode;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * @author lintingmin
 * @date 2020-09-13
 */
public class LeetCode120 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        // 从倒数第二层开始往上遍历
        for (int i = triangle.size() - 2; i >= 0; i--) {
            // 当前层
            List<Integer> current = triangle.get(i);
            // 下一层
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < current.size(); j++) {
                // 把当前元素设置为: 当前元素 + 相邻结点中的较小值
                current.set(j, current.get(j) + Math.min(next.get(j), next.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}

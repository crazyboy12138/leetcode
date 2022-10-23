package com.crazy.leetcode;

/**
 * 朋友圈
 *
 * @author lintingmin
 * @date 2020-10-17
 */
public class LeetCode547 {
    public static void main(String[] args) {
        System.out.println(new LeetCode547().findCircleNum(new int[][]{{1,1,0},
                {1,1,0},
                {0,0,1}}));

        System.out.println(new LeetCode547().findCircleNum(new int[][]{{1,1,0},
                {1,1,1},
                {0,1,1}}));

        System.out.println(new LeetCode547().findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));

    }

    /**
     * parent[i] = j表示: j是i的父节点
     */
    private int[] parents;

    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0) {
            return 0;
        }

        // n名学生
        int n = M.length;
        parents = new int[n];

        // 把每个节点的父节点初始化为自己
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // 矩阵M是对称的，只看其中一半就行
        for (int i = 0; i < n; i++) {
            int parentI = findParent(i);
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    // 如果i和j的父节点不同，把parentJ的父节点设为i的父节点
                    int parentJ = findParent(j);
                    if (parentI != parentJ) {
                        parents[parentJ] = parentI;
                    }
                }
            }
        }

        int result = 0;
        // 寻找父节点为自己的节点
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                result ++;
            }
        }
        return result;
    }

    /**
     * 寻找并更新父节点
     * 假设有以下节点关系，x -> y表示x的父节点是y
     * 1 -> 0
     * 4 -> 3 -> 2 -> 0
     * 运行findParent(4)时，会把4、3两个节点的父节点更新为0
     * @param x 子节点
     * @return 父节点
     */
    private int findParent(int x) {
        int parent = parents[x] == x ? x : findParent(parents[x]);
        if (parent != parents[x]) {
            parents[x] = parent;
        }
        return parent;
    }
}

package com.crazy.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Objects;

/**
 * 最长同值路径
 *
 * @author lintingmin
 * @date 2020-05-30
 */
public class LeetCode687 {
    public static void main(String[] args) {
        System.out.println(new LeetCode687().test1());
        System.out.println(new LeetCode687().test2());
        System.out.println(new LeetCode687().test3());
        System.out.println(new LeetCode687().test4());
    }

    private int test1() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        return longestUnivaluePath(n1);
    }

    private int test2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        return longestUnivaluePath(n1);
    }

    private int test3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;
        return longestUnivaluePath(null);
    }

    private int test4() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n6.right = n7;
        return longestUnivaluePath(n1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 最大的最长同值路径的节点数
     */
    private int maxNumOfPath = 1;

    /**
     * 最长同值路径长度
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        // 求最长同值路径的节点数
        numOfLongPath(root);
        // 路径长度 = 节点数 - 1
        return maxNumOfPath - 1;
    }

    /**
     * 最长同值路径的节点数
     * @param root
     * @return
     */
    private int numOfLongPath(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return 1;
        }

        // 左节点的最长同值路径的节点数
        int left = numOfLongPath(root.left);
        // 右节点的最长同值路径的节点数
        int right = numOfLongPath(root.right);
        // root节点的最长同值路径的节点数
        int result = 1;

        // 如果root与左右子节点的值都相同，把root和左右子树连起来作为一条路径，更新maxNumOfPath
        if (requireNonNull(root, root.left, root.right) && allEquals(root, root.left, root.right)) {
            maxNumOfPath = Math.max(maxNumOfPath, left + right + 1);
        }

        // 如果root与左子节点的值相同，用left+1跟result比较
        if (requireNonNull(root.left) && allEquals(root, root.left)) {
            result = Math.max(result, left + 1);
        }
        // 如果root与右子节点的值相同，用right+1跟result比较
        if (requireNonNull(root.right) && allEquals(root, root.right)) {
            result = Math.max(result, right + 1);
        }

        // 更新最大值
        maxNumOfPath = Math.max(result, maxNumOfPath);
        return result;
    }

    /**
     * arr数组所有元素都不为空
     * @param arr
     * @return
     */
    private boolean requireNonNull(Object... arr) {
        for (Object obj: arr) {
            if (Objects.isNull(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * arr数组所有元素都相等
     * @param arr
     * @return
     */
    private boolean allEquals(TreeNode... arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (!Objects.equals(arr[0].val, arr[i].val)) {
                return false;
            }
        }
        return true;
    }
}

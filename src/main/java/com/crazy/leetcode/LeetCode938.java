package com.crazy.leetcode;

import java.util.*;

/**
 * 二叉搜索树的范围和
 *
 * @author lintingmin
 * @date 2020-06-06
 */
public class LeetCode938 {

    public static void main(String[] args) {
        new LeetCode938().test();
    }

    public void test() {
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7);
        TreeNode n18  = new TreeNode(18);

        n10.left = n5;
        n10.right = n15;
        n5.left = n3;
        n5.right = n7;
        n15.right = n18;

        int sum = rangeSumBST(n10, 7, 15);
        System.out.println(sum);
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    private int left, right, sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        left = L;
        right = R;
        printTree(root);
        return sum;
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        int value = root.val;
        if (value >= left && value <= right) {
            sum += value;
        }
        // 如果当前节点的值大于R，那么当前节点的右子树所有节点值肯定也大于R，无需再遍历
        if (value >= right) {
            printTree(root.left);
        } else if (value <= left) {
            printTree(root.right);
        } else {
            printTree(root.left);
            printTree(root.right);
        }
    }
}

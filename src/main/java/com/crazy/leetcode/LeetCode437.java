package com.crazy.leetcode;

/**
 * 路径总和 III
 *
 * @author lintingmin
 * @date 2020-11-28
 */
public class LeetCode437 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }

    /**
     * 满足要求的路径数
     */
    private int pathSum = 0;

    /**
     * 目标数值
     */
    private int targetSum;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = sum;
        recursion(root);
        return pathSum;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return ;
        }
        findPath(root, 0);
        recursion(root.left);
        recursion(root.right);
    }

    private void findPath(TreeNode node, int curSum) {
        curSum += node.val;
        // 达到目标数值了，不代表可以退出，有可能下一个节点数值是0，也算一个不同路径
        if (curSum == targetSum) {
            pathSum ++;
        }
        if (node.left == null && node.right == null) {
            return ;
        }
        if (node.left != null) {
            findPath(node.left, curSum);
        }
        if (node.right != null) {
            findPath(node.right, curSum);
        }
    }
}

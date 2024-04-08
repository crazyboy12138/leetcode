package com.crazy.leetcode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class LeetCode543 {

    public static void main(String[] args) {
        System.out.println(new LeetCode543().case1());
    }

    private int case1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        return diameterOfBinaryTree(root);
    }

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        // 左子树最大边数: 左子树最大深度 - 1
        // 右子树最大边数: 右子树最大深度 - 1
        // 根节点最大直径: 左子树最大边数 + 右子树最大边数 + 2
        int currentMaxDiameter = (leftMaxDepth - 1) + (rightMaxDepth - 1) + 2;
        maxDiameter = Math.max(maxDiameter, currentMaxDiameter);

        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
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
}

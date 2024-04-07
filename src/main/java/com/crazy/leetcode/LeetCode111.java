package com.crazy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode111 {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 1;

        while (!queue.isEmpty()) {
            // 需要提取变量，否则for循环中队列大小会发生变化
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队头取出节点
                TreeNode node = queue.poll();
                boolean isLeaf = node.left == null && node.right == null;

                if (isLeaf) {
                    return minDepth;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            minDepth++;
        }

        return minDepth;
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

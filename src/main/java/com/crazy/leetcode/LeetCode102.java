package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class LeetCode102 {

    private List<List<Integer>> sequences = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return sequences;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sonSequences = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                sonSequences.add(top.val);

                if (top.left != null) {
                    queue.add(top.left);
                }

                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            sequences.add(sonSequences);
        }

        return sequences;
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

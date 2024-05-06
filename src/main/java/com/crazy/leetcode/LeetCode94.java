package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class LeetCode94 {

    private List<Integer> sequences = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        inorderTraversal(root.left);

        sequences.add(root.val);

        inorderTraversal(root.right);

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

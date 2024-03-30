package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode113 {
    public static void main(String[] args) {
        new LeetCode113().case2();
    }

    private void case1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        List<List<Integer>> result = pathSum(root, 7);
        System.out.println(result);
    }

    private void case2() {
        TreeNode root = new TreeNode(7);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(-6);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(-7);
        root.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.left = node6;
        List<List<Integer>> result = pathSum(root, 0);
        System.out.println(result);
    }


    int targetSum;

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }

        this.targetSum = targetSum;

        List<Integer> trace = new ArrayList<>();
        trace.add(root.val);
        find(root, root.val, trace);

        return result;
    }

    private void find(TreeNode node, int currentSum, List<Integer> trace) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(trace));
                return;
            } else {
                return;
            }
        }

        TreeNode left = node.left;
        if (left != null) {
            trace.add(left.val);
            find(left, currentSum + left.val, trace);
            trace.remove(trace.size() - 1);
        }

        TreeNode right = node.right;
        if (right != null) {
            trace.add(right.val);
            find(right, currentSum + right.val, trace);
            trace.remove(trace.size() - 1);
        }
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
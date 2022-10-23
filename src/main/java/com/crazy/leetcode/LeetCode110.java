package com.crazy.leetcode;

import java.io.FileOutputStream;

/**
 * 平衡二叉树
 *
 * @author lintingmin
 * @date 2020-12-27
 */
public class LeetCode110 {

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

    public static void main(String[] args) {

    }

    /**
     * 非平衡二叉树的标志
     */
    private final int FLAG = -1;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != FLAG;
    }

    /**
     * 计算以root为根节点的树的深度，如果不平衡，返回-1
     * @param root
     * @return 深度
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算左子树深度
        int left = getHeight(root.left);
        // 左子树不平衡
        if (left == FLAG) {
            return FLAG;
        }

        // 计算右子树深度
        int right = getHeight(root.right);
        // 右子树不平衡
        if (right == FLAG) {
            return FLAG;
        }

        // 左右子树深度差大于1
        if (Math.abs(left - right) > 1) {
            return FLAG;
        }

        return Math.max(left, right) + 1;
    }


}

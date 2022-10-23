package com.crazy.leetcode;

/**
 * 二叉树的镜像
 *
 * @author lintingmin
 * @date 2020-09-26
 */
public class LeetCodeJZOffer27 {
    public static void main(String[] args) {

    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (null != root) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }

        return root;
    }
}

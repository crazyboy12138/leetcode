package com.crazy.leetcode;

/**
 * 验证二叉搜索树
 *
 * @author lintingmin
 * @date 2020-10-31
 */
public class LeetCode98 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean isValidBST = true;

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        // 左子树中最大值都比当前值小，说明左子树全都小于当前值
        // 右子树中最小值都比当前值大，说明右子树全都大于当前值
        check(root);
        return isValidBST;
    }

    /**
     * 检查以node为根节点的树是否是二叉搜索树，如果否返回null，如果是返回以node为根节点的树的最大值和最小值
     * @param node
     * @return
     */
    private MaxAndMin check(TreeNode node) {
        if (!isValidBST) {
            return null;
        }
        MaxAndMin curent = new MaxAndMin(node.val);

        if (null != node.left) {
            if (node.left.val >= node.val) {
                isValidBST = false;
                return null;
            }
            MaxAndMin left = check(node.left);
            if (null == left) {
                return null;
            }
            if (left.max >= node.val) {
                isValidBST = false;
                return null;
            }
            curent.max = Math.max(curent.max, left.max);
            curent.min = Math.min(curent.min, left.min);
        }

        if (null != node.right) {
            if (node.right.val <= node.val) {
                isValidBST = false;
                return null;
            }
            MaxAndMin right = check(node.right);
            if (null == right) {
                return null;
            }
            if (right.min <= node.val) {
                isValidBST = false;
                return null;
            }
            curent.min = Math.min(curent.min, right.min);
            curent.max = Math.max(curent.max, right.max);
        }
        return curent;
    }

    class MaxAndMin {
        int max;
        int min;
        MaxAndMin(int init) {
            this.max = init;
            this.min = init;
        }
    }
}

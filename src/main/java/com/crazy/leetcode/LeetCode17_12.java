package com.crazy.leetcode;

/**
 * 面试题 17.12. BiNode
 *
 * @author lintingmin
 * @date 2021-01-24
 */
public class LeetCode17_12 {

    public static void main(String[] args) {
        LeetCode17_12 main = new LeetCode17_12();
        main.test1();
    }

    private void test1() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(0);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;

        print(n1);
        TreeNode head = convertBiNode(n1);
        System.out.println();
        print(head);
    }

    private void test2() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(6);

        n1.right = n2;
        n2.right = n3;

        print(n1);
        TreeNode head = convertBiNode(n1);
        System.out.println();
        print(head);
    }

    private void print(TreeNode node) {
        if (node == null) {
            return ;
        }
        if (node.left != null) {
            print(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            print(node.right);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 未调整前的二叉树的最后一个节点
     */
    private TreeNode lastNode;

    /**
     * 调整中的二叉树的当前节点
     */
    private TreeNode curNode;

    public TreeNode convertBiNode(TreeNode root) {
        middleTravel(root);
        return lastNode;
    }

    /**
     * 中序遍历（左根右）
     * @param root
     */
    private void middleTravel(TreeNode root) {
        if (root == null) {
            return ;
        }

        if (lastNode == null && root.left == null && root.right == null) {
            lastNode = root;
            curNode = root;
            return ;
        }

        if (root.left != null) {
            middleTravel(root.left);
        }

        // 如果遍历完左子树，curNode依然为null，说明没有左子树，把curNode置为root
        if (curNode == null) {
            lastNode = root;
            curNode = root;
        } else {
            // 注意：要把左子树置为null，否则会形成环
            root.left = null;
            curNode.right = root;
            curNode = root;
        }

        if (root.right != null) {
            middleTravel(root.right);
        }
    }
}

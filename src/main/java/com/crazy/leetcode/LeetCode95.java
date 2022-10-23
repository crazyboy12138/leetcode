package com.crazy.leetcode;

import java.util.*;

/**
 * 不同的二叉搜索树 II
 *
 * @author lintingmin
 * @date 2020-05-31
 */
public class LeetCode95 {
    public static void main(String[] args) {
//        new LeetCode95().generateTrees(1);
//        new LeetCode95().generateTrees(2);
        new LeetCode95().generateTrees(3);
//        new LeetCode95().generateTrees(4);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 存放数字1到n
     */
    private int[] nums;

    /**
     * used[i]=false表示nums[i]未被使用，used[i]=true表示nums[i]已经被使用，默认为false
     */
    private boolean[] used;

    private int n;

    /**
     * 数字1到n的全排列
     */
    private List<String> permutatioin;

    /**
     * 最终TreeNode结果集
     */
    private List<TreeNode> resultList;



    public List<TreeNode> generateTrees(int n) {
        nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        used = new boolean[n];
        this.n = n;
        int size = fullPermutationiSize(n);
        permutatioin = new ArrayList<>(size);
        resultList = new ArrayList<>(size);
        fullPermutation(new StringBuilder());
        for (String num: permutatioin) {
            TreeNode root = new TreeNode(num.charAt(0) - '0');
            generateTree(root, root, num, 1);
        }
        removeDuplicates(resultList);
//        printTree(resultList);
        return resultList;
    }

    /**
     * 用当前排列创建二叉搜索树
     * @param root 根节点
     * @param currentNode 当前节点
     * @param num 排列
     * @param index 排列的索引
     */
    private void generateTree(TreeNode root, TreeNode currentNode, String num, int index) {
        if (index == n) {
            resultList.add(root);
            return ;
        }

        TreeNode left = currentNode.left;
        TreeNode right = currentNode.right;
        // 当前排列的值，即待插入树的值
        int currentNum = num.charAt(index) - '0';

        if (currentNum < currentNode.val) {
            if (left == null) {
                left = new TreeNode(currentNum);
                currentNode.left = left;
                generateTree(root, left, num, index + 1);
            } else {
                generateTree(root, left, num, index);
            }
        } else if (currentNum > root.val) {
            if (right == null) {
                right = new TreeNode(currentNum);
                currentNode.right = right;
                generateTree(root, right, num, index + 1);
            } else {
                generateTree(root, right, num, index);
            }
        }

    }

    /**
     * 全排列
     */
    private void fullPermutation(StringBuilder current) {
        if (current.length() == n) {
            permutatioin.add(current.toString());
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                fullPermutation(current.append(nums[i]));
                used[i] = false;
                current.deleteCharAt(current.length() - 1);
            }
        }
    }

    /**
     * 数字1到n的全排列结果集大小
     * @param n
     * @return
     */
    private int fullPermutationiSize(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * 对List<TreeNode>去重
     * @param list
     */
    private void removeDuplicates(List<TreeNode> list) {
        Set<String> set = new HashSet<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            String nodeStr = printTree(list.get(i));
            if (set.contains(nodeStr)) {
                list.remove(i);
            } else {
                set.add(nodeStr);
            }
        }
    }

    /**
     * 把node转换成形如"1 null 3 2 "的字符串
     * @param node
     * @return
     */
    private String printTree(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        printTree(sb, queue);
        return sb.toString();
    }

    private void printTree(StringBuilder sb, Queue<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null ");
                continue;
            }
            TreeNode left = node.left;
            TreeNode right = node.right;
            sb.append(node.val + " ");
            queue.add(left);
            queue.add(right);
        }
    }

    private void printTree(List<TreeNode> list) {
        for (TreeNode node: list) {
            System.out.println(printTree(node));
        }
    }
}

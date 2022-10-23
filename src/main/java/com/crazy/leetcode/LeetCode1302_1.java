package com.crazy.leetcode;

import java.util.*;

/**
 * 用例只过了13/15，不知道为什么错
 *
 * @author lintingmin
 * @date 2020-01-04
 */
public class LeetCode1302_1 {
    public static void main(String[] args) {
        List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
        for (int i = 0; i <= 20; i ++){
            treeNodeList.add(new TreeNode(i));
        }

        treeNodeList.get(1).left = treeNodeList.get(2);
        treeNodeList.get(1).right = treeNodeList.get(3);
        treeNodeList.get(2).left = treeNodeList.get(4);
        treeNodeList.get(2).right = treeNodeList.get(5);
        treeNodeList.get(3).right = treeNodeList.get(6);
        treeNodeList.get(4).left = treeNodeList.get(7);
        treeNodeList.get(6).right = treeNodeList.get(8);
//        treeNodeList.get(9).right = treeNodeList.get(10);
//        treeNodeList.get(6).right = treeNodeList.get(8);

        System.out.println(new LeetCode1302_1().deepestLeavesSum(treeNodeList.get(1)));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int deepestLeavesSum(TreeNode root) {
        // key为深度，value为该深度节点的和
        Map<Integer, Integer> depth2sumMap = new HashMap<>();
        int index = 1;
        // 深度
        int depth = preOrderTraveral(root, depth2sumMap, index);
        return depth2sumMap.get(depth);
    }

    public int preOrderTraveral(TreeNode root, Map<Integer, Integer> map, int index){
        if (null == root){
            return 0;
        }
        if (null == root.left && null == root.right){
            // 获取当前节点所在深度
            int currentDepth = (int)Math.floor(Math.log(index) / Math.log(2)) + 1;
            map.put(currentDepth, map.containsKey(currentDepth) ? map.get(currentDepth) + root.val : root.val);
            // 如果左右节点都是空，返回当前节点所在深度
            return currentDepth;
        }
        int leftDepth = preOrderTraveral(root.left, map, index * 2);
        int rightDepth = preOrderTraveral(root.right, map, index * 2 + 1);
        return Math.max(leftDepth, rightDepth);
    }
}

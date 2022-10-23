//package com.crazy;
//
//import java.util.*;
//
///**
// * 层数最深叶子节点的和
// *
// * @author lintingmin
// * @date 2020-01-04
// */
//public class LeetCode1302 {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode seven = new TreeNode(7);
//
//        root.left = two;
//        root.right = three;
//        two.left = four;
//        three.right = seven;
//
//        System.out.println(new LeetCode1302().deepestLeavesSum(root));
//    }
//
//     public static class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode(int x) { val = x; }
//     }
//
//    /**
//     * bfs实现层序遍历
//     * @param root
//     * @return
//     */
//    public int deepestLeavesSum(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int result = 0;
//        while (!queue.isEmpty()){
//            result = 0;
//            int size = queue.size();
//            for (int i = 0; i < size; i++){
//                TreeNode node = queue.poll();
//                result += node.val;
//
//                if (null != node.left){
//                    queue.offer(node.left);
//                }
//                if (null != node.right){
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return result;
//    }
//}

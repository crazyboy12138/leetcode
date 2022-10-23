package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 特定深度节点链表
 *
 * @author lintingmin
 * @date 2020-12-27
 */
public class LeetCode04_03 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        List<ListNode> lists = new ArrayList<>(10);
        // 队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            ListNode list = null;
            // 算出当前队列的大小，即上一层节点的数量
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // 把上一层节点放入链表list
                if (list == null) {
                    list = new ListNode(node.val);
                    lists.add(list);
                } else {
                    list.next = new ListNode(node.val);
                    list = list.next;
                }

                // 把左右节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        ListNode[] arr = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            arr[i] = lists.get(i);
        }
        return arr;
    }
}

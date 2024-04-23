package com.crazy.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个有序链表
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergeHead = new ListNode(-1);
        ListNode mergeTail = mergeHead;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // 把所有链表的头节点放进队列
        for (ListNode node: lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            // 取出队头最小值
            ListNode node = queue.poll();

            // 放到合并链表
            mergeTail.next = node;

            // 移动链表
            mergeTail = mergeTail.next;

            // 把链表的下一个节点放入队列
            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return mergeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

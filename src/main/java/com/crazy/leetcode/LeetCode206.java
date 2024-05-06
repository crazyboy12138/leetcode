package com.crazy.leetcode;

/**
 * 反转链表
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 虚拟头节点
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode newNode = head;
            head = head.next;
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

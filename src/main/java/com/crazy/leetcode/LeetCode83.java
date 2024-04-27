package com.crazy.leetcode;

public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            if (right.val == left.val) {
                right = right.next;
                continue;
            }

            left.next = right;
            left = left.next;
            right = right.next;
        }
        // 去掉链表尾部多余节点
        left.next = null;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

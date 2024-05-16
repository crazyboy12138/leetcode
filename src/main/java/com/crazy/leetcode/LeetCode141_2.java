package com.crazy.leetcode;

/**
 * 判断链表是否有环
 */
public class LeetCode141_2 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        int maxDistance = 10000 * 2;

        ListNode slow = head, fast = head;
        for (int i = 0; i < maxDistance; i++) {
            if (slow.next == null) {
                return false;
            }
            slow = slow.next;

            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

package com.crazy.leetcode;

/**
 * 判断链表是否有环
 */
public class LeetCode141_2 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 快慢指针，快指针速度是慢指针的2倍
        ListNode slow = head, fast = head;

        /*
            如果链表有环，在maxDistance最大距离内，快慢指针一定能重合。
            假设链表节点数是n（n < 10000），
            跑完第一圈后，快指针与慢指针差距为k，k<=n。
            再跑第二圈，慢指针每跑1步，2个指针的距离缩小1，第二圈跑完之前一定会重合。
         */
        int maxDistance = 10000 * 2;

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

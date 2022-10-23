package com.crazy.weekend.no223;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2021-01-10
 */
public class No5652 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        ListNode topK = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int tmp = slow.val;
        slow.val = topK.val;
        topK.val = tmp;

        return head;
    }
}

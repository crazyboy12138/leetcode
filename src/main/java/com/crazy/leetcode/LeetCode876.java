package com.crazy.leetcode;

/**
 * 链表的中间节点
 */
public class LeetCode876 {
    public static void main(String[] args) {
        new LeetCode876().case1();
    }

    private void case1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = middleNode(node1);

        print(node);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            // p2每走2步，p1走1步
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

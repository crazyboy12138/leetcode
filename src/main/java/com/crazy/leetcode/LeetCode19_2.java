package com.crazy.leetcode;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 *
 */
public class LeetCode19_2 {

    public static void main(String[] args) {
        new LeetCode19_2().case2();
    }

    private void case1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = removeNthFromEnd(node1, 2);

        print(node);
    }

    private void case2() {
        ListNode node1 = new ListNode(1);
        ListNode node = removeNthFromEnd(node1, 1);
        print(node);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head, p2 = head;

        // p1先走n步
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        // 如果p1走n步之后，p1 == null，说明
        if (p1 == null) {
            return head.next;
        }

        // p1 p2同时走，当p1走到终点，p2就走到倒数第n+1个节点
        // while循环退出条件: p1.next为空
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2.next赋值为p2.next.next
        p2.next = p2.next.next;

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

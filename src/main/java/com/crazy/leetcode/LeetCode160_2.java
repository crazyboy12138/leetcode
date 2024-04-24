package com.crazy.leetcode;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class LeetCode160_2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // A B链表各走一遍，得到各自的长度
        ListNode pointA = headA;
        int lengthA = 1;
        while (pointA.next != null) {
            lengthA++;
            pointA = pointA.next;
        }

        ListNode pointB = headB;
        int lengthB = 1;
        while (pointB.next != null) {
            lengthB++;
            pointB = pointB.next;
        }

        // 长度差距
        int distance = Math.abs(lengthA - lengthB);

        // 较长的链表先走k步
        ListNode longer = lengthA > lengthB ? headA : headB;
        for (int i = 0; i < distance; i++) {
            longer = longer.next;
        }

        ListNode shorter = lengthA > lengthB ? headB : headA;

        // 两个链表一起走
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

package com.crazy.leetcode;

/**
 * 链表相交
 *
 * @author lintingmin
 * @date 2020-08-27
 */
public class LeetCode0207 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // A、B链表各走一遍，保存两条链表的长度和终点
        int lengthA = 1, lengthB = 1;
        ListNode endA = null, endB = null;

        // 遍历A链表
        ListNode pointA = headA;
        while (pointA.next != null) {
            pointA = pointA.next;
            lengthA++;
        }
        endA = pointA;

        // 遍历B链表
        ListNode pointB = headB;
        while (pointB.next != null) {
            pointB = pointB.next;
            lengthB++;
        }
        endB = pointB;

        // 如果两条链表相交，终点一定一样
        // 如果终点不一样，说明不相交，直接返回null
        if (endA != endB) {
            return null;
        }

        // 如果A的长度小于B，交换A、B，保证A是较长的一方
        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        // 较长的链表先走k步（k为两者长度差）
        pointA = headA;
        int k = Math.abs(lengthA - lengthB);
        while (k-- > 0) {
            pointA = pointA.next;
        }

        // 然后，双方依次向前一步，如果节点引用相同，说明是交点
        pointB = headB;
        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return pointA;
    }
}

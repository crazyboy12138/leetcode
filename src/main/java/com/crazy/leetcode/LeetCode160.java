package com.crazy.leetcode;

/**
 * 相交链表
 *
 * @author lintingmin
 * @date 2020-11-07
 */
public class LeetCode160 {
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
        if (null == headA || null == headB) {
            return null;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;
        if (pointA == pointB) {
            return pointA;
        }

        // 求链表A、B的长度
        int lenA = 0, lenB = 0;
        while (null != pointA.next && null != pointB.next) {
            pointA = pointA.next;
            pointB = pointB.next;
            lenA ++;
            lenB ++;
        }
        while (null != pointA.next) {
            pointA = pointA.next;
            lenA ++;
        }
        while (null != pointB.next) {
            pointB = pointB.next;
            lenB ++;
        }

        pointA = headA;
        pointB = headB;
        // 较长的链表
        ListNode longer = lenA > lenB ? pointA : pointB;
        // 较短的链表
        ListNode sorter = lenA > lenB ? pointB : pointA;
        // 长度差
        int k = Math.abs(lenA - lenB);
        // 较长的链表先走k步
        for (int i = 0; i < k; i++) {
            longer = longer.next;
        }
        // 两条链表一起走
        while (longer != null) {
            if (longer == sorter) {
                return longer;
            }
            longer = longer.next;
            sorter = sorter.next;
        }
        return null;
    }

}

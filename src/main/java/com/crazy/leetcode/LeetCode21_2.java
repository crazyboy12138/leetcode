package com.crazy.leetcode;

import java.util.List;

/**
 * 合并2个有序链表
 */
public class LeetCode21_2 {

    public static void main(String[] args) {
        new LeetCode21_2().case1();
        new LeetCode21_2().case2();
    }

    private void case1() {
        ListNode firstList1 = new ListNode(1);
        ListNode firstList2 = new ListNode(2);
        ListNode firstList3 = new ListNode(4);

        ListNode secondList1 = new ListNode(1);
        ListNode secondList2 = new ListNode(3);
        ListNode secondList3 = new ListNode(4);

        firstList1.next = firstList2;
        firstList2.next = firstList3;

        secondList1.next = secondList2;
        secondList2.next = secondList3;

        ListNode mergeHead = mergeTwoLists(firstList1, secondList1);

        print(mergeHead);
    }

    private void case2() {
        ListNode firstList1 = new ListNode(2);
        ListNode secondList2 = new ListNode(1);
        ListNode mergeHead = mergeTwoLists(firstList1, secondList2);

        print(mergeHead);
    }

    private void print(ListNode mergeHead) {
        while (mergeHead != null) {
            System.out.println(mergeHead.val);
            mergeHead = mergeHead.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 合并链表头指针
        ListNode mergeHead;
        // 合并链表尾指针
        ListNode mergeTail;
        // 第一个链表的指针，该指针对应的节点，未合入合并链表
        ListNode firstPoint;
        // 第二个链表的指针，该指针对应的节点，未合入合并链表
        ListNode secondPoint;

        // 初始化上述4个指针
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeTail = list1;
            firstPoint = list1.next;
            secondPoint = list2;
        } else {
            mergeHead = list2;
            mergeTail = list2;
            firstPoint = list2.next;
            secondPoint = list1;
        }
        mergeHead.next = mergeTail;

        if (firstPoint == null) {
            mergeTail.next = secondPoint;
            return mergeHead;
        }

        if (secondPoint == null) {
            mergeTail.next = firstPoint;
            return mergeHead;
        }

        // while循环，直至firstPoint与secondPoint均为空
        while (firstPoint != null || secondPoint != null) {
            // 比较firstPoint与secondPoint的值，mergeTail指向较小者，较小者指针右移
            if (firstPoint.val < secondPoint.val) {
                mergeTail.next = firstPoint;
                firstPoint = firstPoint.next;
            } else {
                mergeTail.next = secondPoint;
                secondPoint = secondPoint.next;
            }
            mergeTail = mergeTail.next;

            if (firstPoint == null) {
                mergeTail.next = secondPoint;
                break;
            }

            if (secondPoint == null) {
                mergeTail.next = firstPoint;
                break;
            }
        }

        return mergeHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

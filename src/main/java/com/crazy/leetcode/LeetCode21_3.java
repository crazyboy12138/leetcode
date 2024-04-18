package com.crazy.leetcode;

/**
 * 合并2个有序链表
 */
public class LeetCode21_3 {

    public static void main(String[] args) {
//        new LeetCode21_3().case1();
        new LeetCode21_3().case2();
    }

    private void case1() {
        ListNode head = mergeTwoLists(null, null);
        print(head);
    }

    private void case2() {
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

        // 虚拟头节点
        ListNode mergeHead = new ListNode(-1);
        ListNode mergeTail = mergeHead;
        ListNode point1 = list1, point2 = list2;

        while (point1 != null && point2 != null) {
            if (point1.val < point2.val) {
                mergeTail.next = point1;
                point1 = point1.next;
            } else {
                mergeTail.next = point2;
                point2 = point2.next;
            }
            mergeTail = mergeTail.next;
        }

        if (point1 == null) {
            mergeTail.next = point2;
        }

        if (point2 == null) {
            mergeTail.next = point1;
        }

        return mergeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

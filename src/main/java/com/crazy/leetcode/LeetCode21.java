package com.crazy.leetcode;

/**
 * 合并两个有序链表
 *
 * @author lintingmin
 * @date 2020-10-23
 */
public class LeetCode21 {

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        new LeetCode21().test();
    }

    private void test() {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        l1_1.next = l1_2;
        l2_1.next = l2_2;

        ListNode head = mergeTwoLists(l1_1, l2_1);
        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 任意一个链表为空，则返回另一个
        if (null == l1 || null == l2) {
            return null == l1 ? l2 : l1;
        }

        ListNode head = null;
        ListNode point = null;

        while (null != l1 && null != l2) {
            // 临时节点
            ListNode temp;
            // 值相等的时候优先取l1
            if (l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }

            if (null == head) {
                point = temp;
                head = point;
            } else {
                point.next = temp;
                point = point.next;
            }
        }

        // 把l1和l2剩余部分拼接到point后面
        if (null != l1) {
            point.next = l1;
        } else if (null != l2) {
            point.next = l2;
        }

        return head;
    }

}

package com.crazy.leetcode;

/**
 * 单链表升序排序
 */
public class LeetCode148 {
    public static void main(String[] args) {
        new LeetCode148().case1();
    }

    private void case1() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        print(node1);

        ListNode newHead = sortList(node1);

        print(newHead);
    }

    private void print(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    /**
     * 升序排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-100001);

        ListNode pointer = head;
        while (pointer != null) {
            ListNode next = pointer.next;
            insert(dummyHead, pointer);
            pointer = next;
        }

        return dummyHead.next;
    }

    /**
     * 把toInsert插入到虚拟链表
     */
    private void insert(ListNode dummyHead, ListNode toInsert) {
        ListNode pre = dummyHead;
        ListNode current = dummyHead.next;
        while (current != null) {
            if (toInsert.val > pre.val && toInsert.val <= current.val) {
                pre.next = toInsert;
                toInsert.next = current;
                return;
            } else {
                pre = current;
                current = current.next;
            }
        }

        // 走到这里，说明toInsert大于链表任何一个值，需要尾部插入，此时pre指向链表尾部
        pre.next = toInsert;
        toInsert.next = null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

package com.crazy.leetcode;

/**
 * 两数相加 II
 *
 * @author lintingmin
 * @date 2020-12-20
 */
public class LeetCode445 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode sumList = null;
        ListNode pointer = null;

        // 进位
        int step = 0;
        while (l1 != null && l2 != null) {
            int curVal = l1.val + l2.val + step;
            step = 0;
            ListNode curNode = new ListNode(curVal % 10);
            if (pointer == null) {
                pointer = curNode;
                sumList = pointer;
            } else {
                pointer.next = curNode;
                pointer = pointer.next;
            }
            if (curVal >= 10) {
                step = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int curVal = l1.val + step;
            step = 0;
            ListNode curNode = new ListNode(curVal % 10);
            pointer.next = curNode;
            pointer = pointer.next;
            if (curVal >= 10) {
                step = 1;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int curVal = l2.val + step;
            step = 0;
            ListNode curNode = new ListNode(curVal % 10);
            pointer.next = curNode;
            pointer = pointer.next;
            if (curVal >= 10) {
                step = 1;
            }
            l2 = l2.next;
        }

        if (step == 1) {
            ListNode curNode = new ListNode(1);
            pointer.next = curNode;
        }

        return reverse(sumList);
    }

    /**
     * 反转链表
     * @param root
     * @return
     */
    public ListNode reverse(ListNode root) {
        ListNode lastLast = root;
        ListNode last = root.next;
        if (last == null) {
            return root;
        }
        lastLast.next = null;
        ListNode pointer = last.next;
        while (pointer != null) {
            last.next = lastLast;
            lastLast = last;
            last = pointer;
            pointer = pointer.next;
        }
        last.next = lastLast;
        return last;
    }

    public static void main(String[] args) {
        new LeetCode445().test1();
    }

    private void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode point = l1;
        print(point);
        point = reverse(l1);
        print(point);
    }

    private void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }
}

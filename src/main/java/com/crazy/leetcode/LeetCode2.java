package com.crazy.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-02-29
 */
public class LeetCode2 {
    public static void main(String[] args) {
       new  LeetCode2().resolve();

    }

    private void resolve () {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(5);
//        l2.next.next = new ListNode(5);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);

        ListNode l4 = new ListNode(4);
        l4.next = new ListNode(5);

        ListNode l5 = new ListNode(2);
        l5.next = new ListNode(4);
        l5.next.next = new ListNode(3);

        ListNode l6 = new ListNode(5);
        l6.next = new ListNode(6);
        l6.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l5, l6);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 指针
        ListNode pointer = null;
        // 结果链表
        ListNode result = null;
        // 进位
        int temp = 0;
        // 当前位上的数字
        int cur;
        // 两条链表相同位置数字和
        int sum = 0;

        do {
            sum = l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            cur = (sum % 10 + temp);
            cur %= 10;
            temp = (sum + temp ) / 10;

            if (null == pointer) {
                pointer = new ListNode(cur);
                result = pointer;
            } else {
                pointer.next = new ListNode(cur);
                pointer = pointer.next;
            }
        } while (null != l1 || null != l2);

        if (temp > 0) {
            pointer.next = new ListNode(temp);
        }

        return result;
    }
}

package com.crazy.leetcode;

import java.util.Objects;

/**
 * 删除链表的倒数第N个节点
 *
 * @author lintingmin
 * @date 2020-02-01
 */
public class LeetCode19 {
    public static void main(String[] args) {
        new LeetCode19().test();
    }

    public void test() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fouth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fouth;
        fouth.next = fifth;
        fifth.next = sixth;

//        removeNthFromEnd(first, 2);
//        removeNthFromEnd(second, 1);
        first = removeNthFromEnd(fifth, 2);

        ListNode curNode = first;
        while (Objects.nonNull(curNode)) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head)) {
            return null;
        }

        // 倒数第N+1个节点
        ListNode lastNNode = null;
        // 当前节点
        ListNode curNode = head;
        // curNode指向第几个节点
        int count = 1;

        // lastNNode始终表示curNode前的第N个节点
        // 链表遍历结束后，curNode表示链表的倒数第1个节点，lastNNode就是整个链表的倒数第N+1个节点
        while (Objects.nonNull(curNode)) {
            if (count == n + 1) {
                lastNNode = head;
            } else if (count > n + 1) {
                lastNNode = lastNNode.next;
            }
            curNode = curNode.next;
            count ++;
        }

        // 如果链表长度小于n，直接返回head
        if (count - 1 < n) {
            return head;
        }

        // 如果链表长度为n，要删除第n个节点，直接返回head.next即可
        if (count - 1 == n) {
            return head.next;
        }

        // 把倒数第N+1个节点的next指向倒数第N-1个节点
        lastNNode.next = lastNNode.next.next;

        return head;
    }
}

package com.crazy.leetcode;

/**
 * 旋转链表
 *
 * @author lintingmin
 * @date 2020-10-25
 */
public class LeetCode61 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0) {
            return null;
        }

        // 定义left、right双指针
        ListNode left = head;
        ListNode right = head;

        // right指针先走k步
        for (int i = 1; i <= k; i++) {
            // 如果没走完k步，发现right.next为null，说明链表长度小于k，且链表长度为i
            // 把k设为k % i，right指针重新走k步
            if (null == right.next) {
                k %= i;
                // k为0，说明k是链表长度的倍数，直接返回head
                if (k == 0) {
                    return head;
                }
                right = head;
                for (int j = 1; j <= k; j++) {
                    right = right.next;
                }
                break;
            }
            right = right.next;
        }

        // 双指针同时走，直到right.next为null，即right指向最后一个节点
        // 此时left指针后刚好有k个节点，因为right指针提前走了k步
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        // 把left指针之前的节点（包含left指向的节点）移到right节点后面
        ListNode newHead = left.next;
        right.next = head;
        left.next = null;

        return newHead;
    }
}

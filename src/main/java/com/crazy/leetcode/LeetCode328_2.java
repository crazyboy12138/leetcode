package com.crazy.leetcode;

/**
 * 奇偶链表-优化
 *
 * @author lintingmin
 * @date 2020-08-30
 */
public class LeetCode328_2 {
    public static void main(String[] args) {
        
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }

        // 用于遍历链表
        ListNode point = head;
        // 保存已遍历过的最后一个奇数节点
        ListNode lastOldNode = head;

        while (point.next != null && point.next.next != null) {
            // point指向下一个奇数节点
            point = point.next.next;
            // 把point节点放到上一个奇数节点的后面

            // 把上一个奇数节点指向point

        }

        return head;
    }
}

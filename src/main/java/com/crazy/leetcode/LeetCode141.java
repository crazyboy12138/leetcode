package com.crazy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author lintingmin
 * @date 2020-10-31
 */
public class LeetCode141 {
    public static void main(String[] args) {

    }

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public boolean hasCycle(ListNode head) {
        Set<String> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.toString())) {
                return true;
            }
            set.add(head.toString());
            head = head.next;
        }
        return false;
    }
}

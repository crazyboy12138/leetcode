package com.crazy.leetcode;

/**
 * 回文链表
 *
 * @author lintingmin
 * @date 2020-11-28
 */
public class LeetCode234 {
    public static void main(String[] args) {
        new LeetCode234().test1();
    }

    private void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(isPalindrome(n1));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    /**
     * 思路：使用快慢指针，快指针速度为慢指针2倍，快指针走到终点时，慢指针走到中点
     * 以1->2->3->2->1为例，快指针走到终点时，慢指针走到3
     * 慢指针走到中点这一过程中，把慢指针走过的部分反转链表
     * 也就是整个链表被分成1<-2<-3, 3->2->1两个子链表
     * 遍历这两个子链表，判断是否回文
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 定义快慢指针，快指针速度为慢指针2倍
        ListNode slow = head, fast = head;
        // 链表总节点数
        int count = 1;
        // 用于反转链表，last表示slow的上个节点，lastLast表示slow的上上个节点
        ListNode last = null, lastLast = null;

        while (true) {
            fast = fast.next;
            // 走奇数步后为null，说明节点总数是奇数
            if (fast == null) {
                break;
            }
            count ++;

            fast = fast.next;
            // 走偶数步后为null，说明节点总数是偶数
            if (fast == null) {
                break;
            }
            count ++;

            // 把slow走过的部分反转链表
            lastLast = last;
            last = slow;
            slow = slow.next;
            // 把根节点的next设为null
            if (count == 1) {
                last.next = null;
            }
            // last.next设为lastLast
            if (last != null && lastLast != null) {
                last.next = lastLast;
            }
        }

        // while循环退出后，slow指向中间节点，slow的next还未指向last
        // 假设链表共n个节点，编号从1开始
        // 如果n是偶数，slow指向n/2，把fast指向n/2+1
        if (count % 2 == 0) {
            fast = slow.next;
            slow.next = last;
        }
        // 如果n是奇数，slow指向n/2，把fast指向n/2+2
        else {
            fast = slow.next;
            slow = last;
        }

        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}

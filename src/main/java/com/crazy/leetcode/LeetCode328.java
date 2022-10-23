package com.crazy.leetcode;

/**
 * 奇偶链表
 *
 * @author lintingmin
 * @date 2020-08-30
 */
public class LeetCode328 {
    public static void main(String[] args) {
        new LeetCode328().test();
    }

    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode point = oddEvenList(n1);
        printNode(point);
    }

    private void printNode(ListNode head) {
        System.out.println(head.val);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 思路:
     * 遍历到奇数节点的时候，把该节点前的偶数节点依次后移一位，然后把奇数节点提到前面
     * 以1->2->3->4->5->6->7为例，
     * 遍历到3的时候，把2往后移，然后把3放到2的位置
     * 现在链表变成了1->3->2->4->5->6->7
     * 遍历到5的时候，把2、4往后移，然后把5放到2的位置
     * 现在链表变成了1->3->5->2->4->6->7
     * 遍历到7的时候，把2、4、6往后移，然后把7放到2的位置
     * 现在链表变成了1->3->5->7->2->4->6
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }

        // 用于遍历链表的指针
        ListNode point = head;
        // 保存当前遍历到第几个节点
        int count = 1;
        // 第一个偶数节点
        ListNode evenNode = head.next;

        while (null != point.next) {
            point = point.next;
            count++;
            // 遍历到奇数节点
            if (count % 2 == 1) {
                // 偶数节点需要移动的次数
                int times = count / 2;
                // 临时指针
                ListNode tempNode = evenNode.next;
                // 临时变量
                int curValue = evenNode.val, lastValue;
                for (int i = 0; i < times; i++) {
                    lastValue = curValue;
                    curValue = tempNode.val;
                    tempNode.val = lastValue;
                    tempNode = tempNode.next;
                }
                // 把第一个偶数节点的值替换成奇数节点的值
                evenNode.val = curValue;

                // 偶数节点往后移一位
                evenNode = evenNode.next;
            }
        }

        return head;
    }
}

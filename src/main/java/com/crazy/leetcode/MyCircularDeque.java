package com.crazy.leetcode;

/**
 * 设计循环双端队列
 *
 * @author lintingmin
 * @date 2020-11-14
 */
public class MyCircularDeque {

    /**
     * 头指针
     */
    private ListNode head;

    /**
     * 尾指针
     */
    private ListNode tail;

    /**
     * 当前实际大小
     */
    private int curSize = 0;

    /**
     * 队列大小
     */
    private int size;

    class ListNode {
        /**
         * 节点值
         */
        int value;

        /**
         * 上一个节点
         */
        ListNode front;

        /**
         * 下一个节点
         */
        ListNode rear;

        public ListNode(int value) {
            this.value = value;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (curSize == size) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (curSize == 0) {
            head = node;
            tail = node;
            curSize ++;
            return true;
        }
        node.rear = head;
        head.front = node;
        head = node;
        curSize ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (curSize == size) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (curSize == 0) {
            head = node;
            tail = node;
            curSize ++;
            return true;
        }
        tail.rear = node;
        node.front = tail;
        tail = node;
        curSize ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (curSize == 0) {
            return false;
        }
        head = head.rear;
        curSize --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (curSize == 0) {
            return false;
        }
        tail = tail.front;
        curSize --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return curSize == 0 ? -1 : head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return curSize == 0 ? -1 : tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return curSize == size;
    }
}

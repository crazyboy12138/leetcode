package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146 LRU缓存
 * get和put都算访问，都会把元素标记为最近访问
 */
public class LRUCache {

    public static void main(String[] args) {
        case1();
//        case2();
    }

    private static void case1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));;    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));;    // 返回 3
        System.out.println(lRUCache.get(4));;    // 返回 4
    }

    private static void case2() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }

    private Map<Integer, Node> map;

    /**
     * 双向链表
     */
    private DoubleList cache;

    /**
     * 最大容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        changeToRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            changeToRecently(key);
        } else {
            addNew(key, value);
        }
    }

    private void changeToRecently(int key) {
        if (!map.containsKey(key)) {
            return;
        }

        Node node = map.get(key);
        cache.delete(node);
        cache.addToTail(node);
    }

    private void addNew(int key, int value) {
        if (cache.getSize() == capacity) {
            removeLeastRecently();
        }

        Node newNode = new Node(key, value);
        cache.addToTail(newNode);
        map.put(key, newNode);
    }

    private void removeLeastRecently() {
        int key = cache.moveFromHead();
        map.remove(key);
    }

    private class DoubleList {

        /**
         * 最近访问的在队尾，最久未访问的在队首
         */
        private Node head, tail;

        private int size;

        DoubleList() {
            // 虚拟的头、尾节点，每一个真实node的pre和next都不可能为空，可以减少很多判空代码
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        /**
         * 队尾新增元素
         */
        private void addToTail(Node newNode) {
            newNode.next = tail;
            newNode.pre = tail.pre;
            tail.pre.next = newNode;
            tail.pre = newNode;
            size++;
        }

        /**
         * 删除元素
         */
        private void delete(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        /**
         * 移除队首元素
         * @return 返回队首元素的key
         */
        private int moveFromHead() {
            if (size == 0) {
                // 题目规定key不会是负数
                return -1;
            }

            int key = head.next.key;

            delete(head.next);

            return key;
        }

        private int getSize() {
            return size;
        }

    }

    private class Node {
        private int key, value;

        private Node pre, next;

        Node (int k, int v) {
            key = k;
            value = v;
        }
    }
}

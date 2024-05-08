package com.crazy.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存机制
 *
 * @author lintingmin
 * @date 2020-06-13
 */
public class LRUCache_old {
    public static void main(String[] args) {
//        new LRUCache(2).test1();
//        new LRUCache(2).test2();
        new LRUCache_old(2).test3();
    }

    private void test1() {
        LRUCache_old cache = new LRUCache_old(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private void test2() {
        LRUCache_old cache = new LRUCache_old(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }

    private void test3() {
        LRUCache_old cache = new LRUCache_old(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }


    /**
     * Pair的key为关键字，value为关键字对应值
     */
    private Pair<Integer, Integer>[] arr;

    /**
     * 头指针，指向arr数组中最久未使用的元素的下标
     */
    private int head;

    /**
     * LRU容量
     */
    private int capacity;

    /**
     * arr数组的实际大小
     */
    private int size;

    /**
     * key为关键字，value为关键字在arr的下标
     */
    private Map<Integer, Integer> map;

    public LRUCache_old(int capacity) {
        arr = new Pair[capacity];
        head = 0;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        int index = findKey(key);

        if (index == -1) {
            return -1;
        }

        int result = arr[index].getValue();

        // 如果key的位置刚好在head
        if (head == index) {
            if (size == 1) {
                // 只有一个元素，直接返回结果
                return result;
            } else if (size > 1) {
                // 不止一个元素，把head向后移一位
                head = (head + 1) % size;
                return result;
            }
        }

        // 把key后面的数向前移一位，然后把key放最后（即head的前一位）
        // 需要移动的次数
        int moveTimes = getMoveTimes(index, head);
        for (int i = 0, j = index; i < moveTimes; i++, j++) {
            arr[j % size] = arr[(j + 1) % size];
            map.put(arr[j % size].getKey(), j % size);
        }
        if (moveTimes > 0) {
            // 把key放到最后，即head的前一位
            // head - 1有可能是负数，所以先+size再取余
            int beforeHead = (head - 1 + size) % size;
            arr[beforeHead] = new Pair<>(key, result);
            map.put(key, beforeHead);
        }

        return result;
    }

    /**
     * 坑点：put方法也算对关键字的使用，需要手动get(key)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        int index = findKey(key);
        if (index != -1) {
            arr[index] = new Pair<>(key, value);
            // 手动get(key)
            get(key);
            return ;
        }

        if (size < capacity) {
            // 容量未满，直接放到数组最后
            arr[size] = new Pair(key, value);
            map.put(key, size);
            size ++;
            // 手动get(key)
            get(key);
        } else {
            // 容量已满
            // 把待淘汰的关键字从map中去掉
            map.remove(arr[head].getKey());
            // 把新加入的值放到head指针的位置，然后head指针向后移一位
            arr[head] = new Pair<>(key, value);
            map.put(key, head);
            head = (head + 1) % capacity;
        }
    }

    /**
     * 获取移动次数
     * @param keyIndex 关键字当前下标
     * @param head 最久未被访问的数的下标
     * @return
     */
    private int getMoveTimes(int keyIndex, int head) {
        keyIndex %= size;
        head %= size;
        if (head > keyIndex) {
            // 两个数之间的间隔-1
            return head - keyIndex - 1;
        }
        // 关键字后的数，以及head之前的数
        return size - 1 - keyIndex + head;
    }

    private int findKey (int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
}

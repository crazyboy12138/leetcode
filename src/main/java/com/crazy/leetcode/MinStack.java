package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小栈
 *
 * @author lintingmin
 * @date 2020-04-12
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    /**
     * 存储数据
     */
    private List<Integer> list;

    /**
     * 最后一个元素在list中的下标
     */
    private int tail = -1;

    /**
     * 把当前数据的前orderSize小存起来
     */
    private int orderSize;

    /**
     * orderNum[i]表示当前数据中第i小的值
     */
    private int[] orderNum = new int[orderSize];

    /**
     * orderIndex[i]表示orderNum[i]在list中的下标
     */
    private int[] orderIndex = new int[orderSize];

    /**
     * orderNum数组当前的size
     */
    private int orderCurSize = 0;


    public MinStack() {
        list = new ArrayList();
    }

    public void push(int x) {
        // tail不是最后一个元素的下标，则把新增的元素放到tail+1的位置
        if (list.size()  - 1 > tail) {
            list.set(++tail, x);
        } else {
            list.add(x);
            tail ++;
        }

        // 维护orderNum和orderIndex数组
        maintainOrderForPush(x);
    }

    public void pop() {
        // 维护orderNum和orderIndex数组


        if (tail >= 0) {
            list.remove(tail);
            tail --;
        }
    }

    public int top() {
        return list.get(tail);
    }

    public int getMin() {
        // orderNum数组当前有值
        if (orderCurSize > 0) {
            return orderNum[0];
        } else {
            // TODO
            return 0;
        }
    }

    /**
     * push时，维护orderNum和orderIndex数组
     * @param x
     */
    private void maintainOrderForPush (int x) {
        // 求x在orderNum数组中的应插入下标
        int insertIndex = Arrays.binarySearch(orderNum, 0, orderCurSize, x);
        // 如果orderNum数组不存在x，Arrays.binarySearch返回的是(-insertIndex)-1
        insertIndex = insertIndex < 0 ? (-(insertIndex + 1)) : insertIndex;
        for (int i = orderCurSize - 1; i >= insertIndex; i--) {
            orderNum[i + 1] = orderNum[i];
            orderIndex[i + 1] = orderIndex[i];
        }
        orderNum[insertIndex] = x;
        orderIndex[insertIndex] = tail;
        orderCurSize ++;
    }

    /**
     * pop时，维护orderNum和orderIndex数组
     */
    private void maintainOrderForPop () {
        for (int i = 0; i < orderCurSize; i++) {
            // 移除元素在orderNum数组中
            if (orderIndex[i] == tail) {
                for (int j = i; j < orderCurSize; j++) {
                    orderNum[j] = orderNum[j + 1];
                    orderIndex[j] = orderIndex[j + 1];
                }
                orderCurSize --;
                break;
            }
        }
    }

    private void getLastMin () {
        List<Integer> copy = new ArrayList<>(list);

    }
}

package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 用队列实现栈
 *
 * @author lintingmin
 * @date 2020-07-04
 */
public class MyStack {

    private List<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
        list = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return last;
    }

    /** Get the top element. */
    public int top() {
        return list.get(list.size() - 1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }
}

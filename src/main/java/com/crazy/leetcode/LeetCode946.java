package com.crazy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetCode946 {
    public static void main(String[] args) {
        System.out.println(new LeetCode946().validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4,5,3,2,1}
        ));

        System.out.println(new LeetCode946().validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4,3,5,1,2}
        ));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length == 0 || popped.length == 0) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int indexInPopped = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[indexInPopped]) {
                stack.pop();
                indexInPopped++;
            }
        }

        return stack.isEmpty();
    }

}

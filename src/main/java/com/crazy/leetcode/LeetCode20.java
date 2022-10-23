package com.crazy.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author lintingmin
 * @date 2021-01-16
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20().isValid("()"));
        System.out.println(new LeetCode20().isValid("()[]"));
        System.out.println(new LeetCode20().isValid("()[}]"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch: chars) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            Character top = stack.peek();
            if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}

package com.crazy.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * 字符串解码
 *
 * @author lintingmin
 * @date 2020-01-23
 */
public class LeetCode394 {
    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("2[abc]3[cd]ef"));
    }

    /**
     * 思路: 遍历字符串s，如果不是]，就入栈；
     * 如果是]，栈里肯定有[，而且栈里最近的[跟现在的]是对应的， 把这段[]内的字符串，按前面的的次数重复后，放回栈；
     * 重复这个过程，最后就能得出结果
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder tempSb;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果遇到]，不断出栈，直到遇到[
            if (ch == ']') {
                tempSb = new StringBuilder();
                while (true) {
                    String pop = stack.pop();
                    if (pop.equals("[")) {
                        // [ 的前面一定是数字，但不一定是个位数
                        StringBuilder numSb = new StringBuilder();
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
                            numSb.append(stack.pop().charAt(0));
                        }
                        int times = Integer.valueOf(numSb.reverse().toString()) - 1;
                        String tempStr = tempSb.toString();
                        for (int j = 0; j < times; j++) {
                            tempSb.append(tempStr);
                        }
                        stack.push(tempSb.toString());
                        break;
                    } else {
                        tempSb.append(pop);
                    }
                }
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuilder resultSb = new StringBuilder();
        while (!stack.empty()) {
            resultSb.append(stack.pop());
        }

        return resultSb.reverse().toString();
    }
}

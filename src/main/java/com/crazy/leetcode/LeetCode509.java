package com.crazy.leetcode;

public class LeetCode509 {
    public static void main(String[] args) {
        LeetCode509 leetCode509 = new LeetCode509();
        for (int i = 0; i <= 20; i++) {
            System.out.println(i + ": " + new LeetCode509().fib(i));
        }
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int lastLast = 0, last = 1;

        for (int i = 2; i <= n; i++) {
            int temp = last;
            last = lastLast + last;
            lastLast = temp;
        }

        return last;
    }
}

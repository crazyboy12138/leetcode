package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 移动石子直到连续
 *
 * @author lintingmin
 * @date 2020-06-20
 */
public class LeetCode1033 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode1033().numMovesStones(1, 2, 5)));
        System.out.println(Arrays.toString(new LeetCode1033().numMovesStones(4, 3, 2)));
        System.out.println(Arrays.toString(new LeetCode1033().numMovesStones(3, 5, 1)));
    }

    public int[] numMovesStones(int a, int b, int c) {
        // 对a、b、c从小到大排序
        int sum = a + b + c;
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        a = min;
        c = max;
        b = sum - a - c;

        int[] answer = new int[2];
        if (b - a == 1 && c - b == 1) {
            answer[0] = 0;
        } else if (b - a == 1 || c - b == 1 || b - a == 2 || c - b == 2) {
            answer[0] = 1;
        } else {
            answer[0] = 2;
        }
        answer[1] = c - b - 1 + (b - a - 1);
        return answer;
    }

}

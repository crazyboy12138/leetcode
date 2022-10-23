package com.crazy.leetcode;

/**
 * 三步问题
 *
 * @author lintingmin
 * @date 2020-05-17
 */
public class LeetCode0801 {
    public static void main(String[] args) {
        System.out.println(new LeetCode0801().waysToStep(1));
        System.out.println(new LeetCode0801().waysToStep(2));
        System.out.println(new LeetCode0801().waysToStep(3));
        System.out.println(new LeetCode0801().waysToStep(4));
        System.out.println(new LeetCode0801().waysToStep(5));
        System.out.println(new LeetCode0801().waysToStep(6));
        System.out.println(new LeetCode0801().waysToStep(61));
        System.out.println(new LeetCode0801().waysToStep(76));
        System.out.println(new LeetCode0801().waysToStep(1000000));
    }

    public int waysToStep(int n) {
        long[] arr = new long[]{1, 2, 4};

        for (int i = 4; i < n; i++) {
            long current = (arr[0] + arr[1] + arr[2]) % 1000000007;
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = current;
        }
        Long result = n < 4 ? arr[n - 1] : (arr[0] + arr[1] + arr[2]) % 1000000007;
        return result.intValue();
    }
}

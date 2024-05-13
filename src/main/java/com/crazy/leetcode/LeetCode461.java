package com.crazy.leetcode;

public class LeetCode461 {

    public static void main(String[] args) {
        System.out.println(new LeetCode461().hammingDistance(1, 4));
        System.out.println(new LeetCode461().hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int distance = 0;
        for (int i = 30; i >= 0; i--) {
            int temp = (int)Math.pow(2, i);
            if (temp <= num) {
                num = num % temp;
                distance++;
            }
        }
        return distance;
    }
}

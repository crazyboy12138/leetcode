package com.crazy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素，单调递增栈
 */
public class LeetCode496 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new LeetCode496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(new LeetCode496().nextGreaterElement(new int[]{3,1,5,7,9,2,6}, new int[]{1,2,3,5,6,7,9,11})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nextBig[i]表示nums[i]的下一个更大元素
        int[] nextBig = buildNextBig(nums2);
        System.out.println(Arrays.toString(nextBig));

        // key为nums1的元素，value为key在nums2中对应下标
        Map<Integer, Integer> num1ToNum2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            num1ToNum2.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer index = num1ToNum2.get(nums1[i]);
            result[i] = nextBig[index];
        }

        return result;
    }

    private int[] buildNextBig(int[] nums2) {
        int length = nums2.length;;
        int[] nextBig = new int[length];

        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[length - 1]);
        nextBig[length  - 1] = -1;

        for (int i = nums2.length - 2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            nextBig[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        return nextBig;
    }
}

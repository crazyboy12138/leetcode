package com.crazy.leetcode;

import java.util.Objects;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-03-07
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = new int[] {2, 5, 4, 5, 6};
        int[] nums3 = new int[] {3, 4, 2, 6, 3, 4, 5, 6, 7};
        int[] nums4 = new int[] {3, 4, 2, 6};
        int[] nums5 = new int[] {0};

        System.out.println(new LeetCode300().lengthOfLIS(nums1));
        System.out.println(new LeetCode300().lengthOfLIS(nums2));
        System.out.println(new LeetCode300().lengthOfLIS(nums3));
        System.out.println(new LeetCode300().lengthOfLIS(nums4));
        System.out.println(new LeetCode300().lengthOfLIS(nums5));
    }

    public int lengthOfLIS(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        int result = 1;
        // length[i]表示到nums[i]为止最长上升序列长度
        int length[] = new int[nums.length];

        length[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int longest = 0;
            // 从nums[0]到nums[i-1]中找出能与nums[i]组成的最长上升序列
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && length[j] > longest) {
                    longest = length[j];
                }
            }
            length[i] = longest + 1;
            result = length[i] > result ? length[i] : result;
        }

        return result;
    }
}

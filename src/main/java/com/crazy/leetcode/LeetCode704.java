package com.crazy.leetcode;

/**
 * 二分查找
 */
public class LeetCode704 {
    public static void main(String[] args) {
        System.out.println(new LeetCode704().search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(new LeetCode704().search(new int[]{-1,0,3,5,9,12}, 4));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 两端都是闭区间
        int left = 0, right = nums.length - 1;

        // 如果写成left < right，循环终止条件是[left, right]，会漏掉搜索区间，比如[2, 2]
        while (left <= right) {
            // 结果与(left+right)/2，但是可以防止mid溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // mid无需再次搜索，因此需要+1
                left = mid + 1;
            } else {
                // mid无需再次搜索，因此需要-1
                right = mid - 1;
            }
        }

        return -1;
    }


}

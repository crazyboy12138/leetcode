package com.crazy.leetcode;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2019-12-28
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1, 2, 2, 3, 4, 5 ,89};
        int result = new LeetCode26().removeDuplicates(nums);
        System.out.println("result: " + result);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int temp = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[temp] != nums[i]){
                temp ++;
                nums[temp] = nums[i];
            }
        }
        return temp + 1;
    }
}

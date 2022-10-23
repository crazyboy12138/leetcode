package com.crazy.leetcode;

import java.util.Objects;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-02-08
 */
public class LeetCode80 {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        int newLength = new LeetCode80().removeDuplicates(nums);
        System.out.println(newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (Objects.isNull(nums) && nums.length == 0) {
            return 0;
        }

        // 旧长度
        int oldLength = nums.length;
        // 新长度
        int newLength = 0;
        // 当前下标
        int index = 0;
        // 保存临时数
        int temp;

        while(index < oldLength) {
            // nums[index] == nums[index + 2]，说明重复次数 > 2
            if (index + 2 < oldLength && nums[index] == nums[index + 2]) {
                temp = nums[index];
                index = index + 3;
                // index往后移，直到不重复
                while (index < oldLength && nums[index] == temp) {
                    index ++;
                }
                if (index == newLength) {
                    newLength += 2;
                } else {
                    nums[newLength++] = temp;
                    nums[newLength++] = temp;
                }
            }
            // 重复次数刚好为2，index++
            else if (index + 1 < oldLength && nums[index] == nums[index + 1]) {
                if (index == newLength) {
                    newLength += 2;
                    index += 2;
                } else {
                    nums[newLength++] = nums[index];
                    nums[newLength++] = nums[index];
                    index += 2;
                }
            }
            // 重复次数刚好为1
            else if (index < oldLength){
                if (index == newLength) {
                    newLength ++;
                    index ++;
                } else {
                    nums[newLength++] = nums[index];
                    index ++;
                }

            }
        }

        return newLength;
    }
}

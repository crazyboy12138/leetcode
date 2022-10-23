package com.crazy.leetcode;

/**
 * 主要元素
 *
 * @author lintingmin
 * @date 2020-12-21
 */
public class LeetCode17_10_1 {
    public static void main(String[] args) {
        System.out.println(new LeetCode17_10_1().majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
        System.out.println(new LeetCode17_10_1().majorityElement(new int[]{3,2}));
        System.out.println(new LeetCode17_10_1().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new LeetCode17_10_1().majorityElement(new int[]{1}));
        System.out.println(new LeetCode17_10_1().majorityElement(new int[]{6, 5, 5}));
    }


    public int majorityElement(int[] nums) {
        // 主要元素的候选人
        int major = nums[0];
        // major的计数器，即major的数量
        int count = 0;

        for (int num: nums) {
            // count为0，说明前面的互相抵消完了
            if (count == 0) {
                // 重新选择候选人
                major = num;
                count = 1;
            } else {
                // 如果当前元素与候选人相同，则count+1，否则count-1，表示候选人被抵消掉一个
                count = (major == num ? count + 1 : count - 1);
            }
        }
        // count为0，说明不存在主要元素
        if (count == 0) {
            return -1;
        }
        // count不为0，不代表major就是主要元素，比如1 2 1 2 3这种情况
        // 所以还需要遍历数组，计算major的出现次数，判断是否大于数组一半
        count = 0;
        for (int num: nums) {
            count = (num == major ? count + 1 : count - 1);
        }
        return count > 0 ? major : -1;
    }
}

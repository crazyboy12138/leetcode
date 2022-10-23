package com.crazy.leetcode;

import java.util.*;

/**
 * 划分为k个相等的子集
 *
 * @author lintingmin
 * @date 2020-05-30
 */
public class LeetCode698 {
    public static void main(String[] args) {
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6}, 3));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{10,10,10,7,7,7,6}, 3));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{10,10,10}, 3));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{780,935,2439,444,513,1603,504,2162,432,110,1856,575,172,367,288,316}, 4));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{2999,3914,1064,927,64,1130,2048,235,159,3549,241,987,972,976,279,1004}, 4));
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{7628, 3147, 7137, 2578, 7742, 2746, 4264, 7704, 9532, 9679, 8963, 3223, 2133, 7792, 5911, 3979}, 6));
    }

    /**
     * nums数组的引用
     */
    private int[] nums;

    /**
     * used[i]=false表示nums[i]未被使用，used[i]=true表示nums[i]已被使用，默认为false
     */
    private boolean[] used;

    /**
     * partition[i]表示第i个子集目前的和
     */
    private int[] subset;

    /**
     * 每个子集的元素总和
     */
    private int subsetSum;


    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 总和
        int sum = 0;
        // 最大值
        int max = nums[0];
        for (int num: nums) {
            sum += num;
            max = Math.max(max, num);
        }
        subsetSum = sum / k;
        // 数组总和不能平均分成k部分，返回false
        if (sum % k != 0 || max > subsetSum) {
            return false;
        }
        subset = new int[k];
        used = new boolean[nums.length];
        Arrays.sort(nums);
//        this.nums = nums;
        int[] copy = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            copy[i] = nums[j];
        }
        this.nums = copy;

        // 拆分子集
        return partition(0);
    }

    /**
     * 拆分子集
     */
    private boolean partition(int index) {
        // 所有元素都已经被使用
        boolean allUsed = true;

        for (int i = index; i < nums.length; i++) {
            // 元素未被使用
            if (!used[i]) {
                allUsed = false;
                int pre = -1;
                for (int j = 0; j < subset.length; j++) {
                    // 对于同一个nums[i]，如果本子集和上一个子集的和相同，执行结果是一样的，可以跳过
                    if (subset[j] == pre) {
                        continue;
                    }
                    if (subset[j] + nums[i] <= subsetSum) {
                        pre = subset[j];
                        // 标记为已使用
                        used[i] = true;
                        subset[j] += nums[i];
                        if (partition(i + 1)) {
                            return true;
                        }
                        // 恢复现场
                        subset[j] -= nums[i];
                        used[i] = false;
                    }
                }
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        if (allUsed) {
            for (int i = 1; i < subset.length; i++) {
                if (subset[i] != subsetSum) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

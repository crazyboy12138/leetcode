package com.crazy.leetcode;

/**
 * 最接近的三数之和
 * AC，时间击败8.35%
 *
 * @author lintingmin
 * @date 2020-01-09
 */
public class LeetCode16 {

    private int closestSum;

    // 用于标记元素是否被使用
    // mark[i] == 1 表示nums[i]已被使用
    private int[] mark;

    // 数组长度
    private int length;

    // 存三个数
    private int[] path;

    // 引用入参数组，dfs方法才可以使用
    private int[] nums;

    // 引用入参数组，dfs方法才可以使用
    private int target;

    // 结束标志
    private boolean endFlag;

    public int threeSumClosest(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        mark = new int[nums.length];
        length = nums.length;
        path = new int[3];
        closestSum = nums[0] + nums[1] + nums[2];
        // false表示还未结束
        endFlag = false;

        for (int i = 0; i < length; i++) {
            mark[i] = 0;
        }

        dfs(0);

        return closestSum;
    }

    public void dfs(int index) {
        if (index == 3) {
            int currentSum = path[0] + path[1] + path[2];
            if (currentSum == target) {
                endFlag = true;
            }
//            System.out.println(path[0] + " " + path[1] + " " + path[2]);
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentSum;
            }
            return ;
        }

        for (int i = 0; i < length; i++) {
            if (mark[i] == 0) {
                mark[i] = 1;
                path[index] = nums[i];
                dfs(index + 1);
                if (endFlag) {
                    return ;
                }
                mark[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int result = new LeetCode16().threeSumClosest(nums, 10);
        System.out.println(result);
    }
}

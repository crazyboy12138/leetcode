package com.crazy.leetcode;

import java.util.*;

/**
 *  找到k个最接近的元素
 *
 * @author lintingmin
 * @date 2020-03-28
 */
public class LeetCode658 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(new LeetCode658().findClosestElements(arr, 4, 3));
        System.out.println(new LeetCode658().findClosestElements(arr, 4, -1));
        arr = new int[]{0,0,1,2,3,3,4,7,7,8};
        System.out.println(new LeetCode658().findClosestElements(arr, 3,5));

        arr = new int[]{1,1,1,17,10,10};
        System.out.println(new LeetCode658().findClosestElements(arr, 1,9));
    }

    /**
     * 优化空间：
     * 1.arr数组是有序的，最终结果一定是arr数组的一段连续元素，只需要存这段元素的头尾索引即可，不需要再定义一个List
     * 2.left和right这两个指针，如果其中一个到边缘了，可以直接退出while循环，从另一指针开始取数
     * 3.如果有办法直接确定最终的区间的开始和结束位置，就可以省去Collections.sort
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int insertIndex = searchInsert(arr, x);
        List<Integer> result = new ArrayList<>(k);
        int left = insertIndex - 1;
        int right = insertIndex;

        // 二分法找得到x应插入arr的位置，然后双指针向左右寻找
        while (result.size() < k) {
            if (left >= 0 && right < arr.length) {
                result.add(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? arr[left--] : arr[right++]);
            } else if (left < 0 && right < arr.length) {
                result.add(arr[right++]);
            } else if (left >= 0 && right >= arr.length) {
                result.add(arr[left--]);
            }
        }

        Collections.sort(result);

        return result;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return nums[mid] >= target ? mid : mid + 1;
    }
}

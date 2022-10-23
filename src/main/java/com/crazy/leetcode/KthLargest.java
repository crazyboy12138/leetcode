package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @author lintingmin
 * @date 2020-12-06
 */
public class KthLargest {

    public KthLargest(){}

    /**
     * 初始无序数组
     */
    private int[] nums;

    /**
     * nums数组长度
     */
    private int length;

    /**
     * 堆末已排好序的节点数量
     */
    private int orderCount = 0;

    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (nums.length > k) {
            length = nums.length;
            this.nums = nums;
            // 构造大顶堆
            buildHeap();
            // 堆排序求topK，排序后nums数组的最后k个元素为topK大，升序排序
            adjustHeap();
        } else {
            length = nums.length;
            this.nums = new int[k];
            for (int i = 0; i < length; i++) {
                this.nums[i] = nums[i];
            }
        }
    }

    public int add(int val) {
        if (length < k) {
            nums[length++] = val;
            Arrays.sort(nums, 0, length);
            return nums[0];
        }

        int topK = nums[length - k];
        // 如果val <= topK，直接返回topK，舍弃val
        if (val <= topK) {
            return topK;
        }
        // 二分找到val在nums[length - k]到nums[length - 1]之间的插入位置
        int index = Arrays.binarySearch(nums, length - k, length, val);
        if (index < 0) {
            index = -(index + 1);
        }
        // 把原topK个元素中小于val的元素往前移
        for (int i = length - k + 1; i < index; i++) {
            nums[i - 1] = nums[i];
        }
        nums[index - 1] = val;
        return nums[length - k];
    }



    /**
     * 构造大顶堆
     */
    private void buildHeap() {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustNode(i);
        }
    }

    /**
     * 调整堆：
     * 1.交换根节点与最后一个节点（不包括已排好序的节点）
     * 2.堆末已排好序的节点数量 + 1
     * 3.对未排好序的部分，构造大顶堆
     * 4.重复以上步骤，直到已排好序的节点数量 = k
     */
    private void adjustHeap() {
        while (orderCount < k && length - 1 >= orderCount) {
            swap(0, length - 1 - orderCount);
            orderCount ++;
            for (int i = (length - orderCount) / 2 - 1; i >= 0; i--) {
                adjustNode(i);
            }
        }
    }

    /**
     * 调整节点：若左节点或右节点大于当前节点，把当前节点与左右节点中较大者交换
     * @param i 当前节点下标
     */
    private void adjustNode(int i) {
        // 当前节点的值
        int curVal = nums[i];
        // 左节点的值
        int leftVal = nums[2 * i + 1];
        // 右节点不为空
        if (2 * i + 2 < length - orderCount) {
            // 右节点的值
            int rightVal = nums[2 * i + 2];
            if (rightVal > leftVal && rightVal > curVal) {
                // 交换当前节点和右节点
                swap(i, 2 * i + 2);
                return;
            }
        }
        if (leftVal > curVal) {
            // 交换当前节点和左节点
            swap(i, 2 * i + 1);
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void test1() {
        int[] nums1 = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums1);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }

    private void test2() {
        int[] nums1 = new int[]{0};
        KthLargest kthLargest = new KthLargest(2, nums1);
        System.out.println(kthLargest.add(-1));
        kthLargest.add(1);   // return 5
        kthLargest.add(-2);  // return 5
        kthLargest.add(-4);   // return 8
        kthLargest.add(3);   // return 8
    }

    public static void main(String[] args) {
        new KthLargest().test2();

    }
}

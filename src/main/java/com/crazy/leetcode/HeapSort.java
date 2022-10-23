package com.crazy.leetcode;

import java.util.Arrays;

/**
 * 堆排序（大顶堆）
 *
 * @author lintingmin
 * @date 2020-12-06
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 8, 5, 9, 11, 13, 3, 5, 17};
        new HeapSort().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


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
    private int orderCount;

    /**
     * 对数组升序排序
     * @param nums 无序数组
     */
    private void heapSort(int[] nums) {
        this.nums = nums;
        length = nums.length;
        orderCount = 0;
        buildHeap();
        adjustHeap();
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
     * 4.重复以上步骤，直到已排好序的节点数量 = 总节点数
     */
    private void adjustHeap() {
        while (orderCount < length) {
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

    /**
     * 交换元素
     * @param i 元素i
     * @param j 元素j
     */
    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

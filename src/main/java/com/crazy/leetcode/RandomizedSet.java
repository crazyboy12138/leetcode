package com.crazy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * leetcode 380，O(1)时间插入、删除、获取随机元素
 */
public class RandomizedSet {

    private int[] nums;

    /**
     * key为元素值，value为该元素值在nums数组的下标
     */
    private Map<Integer, Integer> numToIndex;

    public RandomizedSet() {
        nums = new int[200001];
        numToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }

        // 插入到数组末尾
        int index = numToIndex.size();
        nums[index] = val;
        numToIndex.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }

        int toDelIndex = numToIndex.get(val);
        int lastIndex = numToIndex.size() - 1;

        // val与末尾元素交换
        nums[toDelIndex] = nums[lastIndex];

        // 必须先put再remove，因为调用remove时，只有一个元素
        numToIndex.put(nums[toDelIndex], toDelIndex);
        numToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(numToIndex.size());
        return nums[index];
    }
}

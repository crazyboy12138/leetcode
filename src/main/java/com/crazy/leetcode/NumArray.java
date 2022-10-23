package com.crazy.leetcode;

/**
 * 区域和检索 - 数组可修改
 *
 * @author lintingmin
 * @date 2020-09-06
 */
public class NumArray {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }

    private int[] nums;

    /**
     * 线段树节点
     */
    private Node[] nodes;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length > 0) {
            nodes = new Node[nums.length << 2];
            // 构建线段树
            build(1, 1, nums.length);
        }
    }

    public void update(int i, int val) {
        if (nodes != null) {
            // 从根节点开始更新
            update(1, i + 1, val);
        }
    }

    public int sumRange(int i, int j) {
        if (nodes == null) {
            return 0;
        }
        // 从根节点开始搜索
        return search(1, i + 1, j + 1);
    }

    class Node{
        /**
         * 区间的开始对应的数组下标
         */
        int left;
        /**
         * 区间的结束对应的数组下标
         */
        int right;
        /**
         * 区间[left, right]的和
         */
        int sum;
    }

    /**
     * 构建线段树
     * @param no 节点编号
     * @param left 区间开始
     * @param right 区间结束
     */
    private void build(int no, int left, int right) {
        nodes[no] = new Node();
        nodes[no].left = left;
        nodes[no].right = right;
        // left == right，说明是叶子节点
        if (left == right) {
            nodes[no].sum = nums[left - 1];
            return;
        }
        int mid = (left + right) >> 1;
        // 建左子树
        build(no << 1, left, mid);
        // 建右子树
        build(no << 1 | 1, mid + 1, right);
        // 求和
        nodes[no].sum = nodes[no << 1].sum + nodes[no << 1 | 1].sum;
    }

    /**
     * 求区间和
     * @param no 当前节点编号
     * @param left 求和区间的开始
     * @param right 求和区间的结束
     * @return 区间和
     */
    private int search(int no, int left, int right) {
        // 当前节点
        Node node = nodes[no];

        // 当前节点的区间完全被求和区间覆盖，返回当前节点的sum
        if (node.left >= left && node.right <= right) {
            return node.sum;
        }

        // 当前节点的区间与求和区间无交集，直接返回0
        if (node.left > right || node.right < left) {
            return 0;
        }

        int sum = 0;
        // 当前节点左子树与求和区间有交集
        if (nodes[no << 1].right >= left) {
            sum += search(no << 1, left, right);
        }
        // 当前节点右子树与求和区间有交集
        if (nodes[no << 1 | 1].left <= right) {
            sum += search(no << 1 | 1, left, right);
        }
        return sum;
    }

    /**
     * 更新nums[index]的值为newValue
     * @param no 当前遍历到的节点编号
     * @param index nums数组下标
     * @param newValue 更新后的值
     */
    private void update(int no, int index, int newValue) {
        // 叶子节点，说明找到了
        if (nodes[no].left == nodes[no].right) {
            nodes[no].sum = newValue;
            return;
        }
        if (index <= nodes[no << 1].right) {
            update(no << 1, index, newValue);
        } else {
            update(no << 1 | 1, index, newValue);
        }
        nodes[no].sum = nodes[no << 1].sum + nodes[no << 1 | 1].sum;
    }
}

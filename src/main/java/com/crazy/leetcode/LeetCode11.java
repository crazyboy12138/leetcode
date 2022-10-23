package com.crazy.leetcode;

/**
 * 盛最多水的容器
 *
 * @author lintingmin
 * @date 2020-03-14
 */
public class LeetCode11 {
    public static void main(String[] args) {
        int[] height = new int[]{100,8,6,2,5,4,8,900,7};
        System.out.println(new LeetCode11().maxArea(height));

    }

    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        int result = 0;
        int curResult = 0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                curResult = (j-i) * (height[i] < height[j]? height[i] : height[j]);
                result = curResult < result? result : curResult;
            }
        }
        return result;
    }
}

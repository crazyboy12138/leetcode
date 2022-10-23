package com.crazy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2020-05-04
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 20; i++) {
            System.out.println(new Solution().nthUglyNumber(i));
        }
    }

    int specialNum1 = 2, specialNum2 = 3, specialNum3 = 5;
    int twoRef = 0 , threeRef = 0, fiveRef = 0;
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        while(list.size()<n){
            int min = minRef(list);
            list.add(min);
        }
        return list.get(list.size()-1);
    }

    public int minRef(List<Integer> list){
        int middle = 0;
        int twoRefNum = list.get(twoRef) * specialNum1;
        int threeRefNum = list.get(threeRef) * specialNum2;
        int fiveRefNum = list.get(fiveRef) * specialNum3;

        if(twoRefNum<=threeRefNum && twoRefNum<=fiveRefNum){
            middle = twoRefNum;
            twoRef++;
        }
        if(threeRefNum<=twoRefNum && threeRefNum<=fiveRefNum){
            middle = threeRefNum;
            threeRef++;
        }
        if(fiveRefNum<=twoRefNum && fiveRefNum<=threeRefNum){
            middle = fiveRefNum;
            fiveRef++;
        }
        return middle;
    }
}

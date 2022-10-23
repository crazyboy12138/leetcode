package com.crazy.leetcode;

/**
 * 猜数字
 *
 * @author lintingmin
 * @date 2020-01-04
 */
public class LeetCodeLCP1 {
    public static void main(String[] args) {
        int[] guess = new int[]{1, 2, 3};
        int[] answer = new int[]{1, 2, 4};
        System.out.println(new LeetCodeLCP1().game(guess, answer));
    }

    public int game(int[] guess, int[] answer) {
        return resolve(guess, answer);
    }

    public int resolve(int[] guess, int[] answer){
        int ans = 0;
        for (int i = 0; i < 3; i++){
            ans += guess[i] == answer[i] ? 1 : 0;
        }
        return ans;
    }
}

package com.crazy.weekend.no223;

import java.util.Arrays;

/**
 * TODO
 *
 * @author lintingmin
 * @date 2021-01-10
 */
public class No5649 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No5649().decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(new No5649().decode(new int[]{6,2,7,3}, 4)));
    }

    public int[] decode(int[] encoded, int first) {
        int[] origin = new int[encoded.length + 1];
        origin[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            origin[i + 1] = encoded[i] ^ origin[i];
        }
        return origin;
     }
}

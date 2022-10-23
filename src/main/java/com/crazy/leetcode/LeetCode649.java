package com.crazy.leetcode;

/**
 * Dota2 参议院
 *
 * @author lintingmin
 * @date 2021-01-03
 */
public class LeetCode649 {

    public static void main(String[] args) {
        System.out.println(new LeetCode649().predictPartyVictory("RD"));
        System.out.println(new LeetCode649().predictPartyVictory("RDD"));
        System.out.println(new LeetCode649().predictPartyVictory("RRDDD"));
        System.out.println(new LeetCode649().predictPartyVictory("RRR"));
        System.out.println(new LeetCode649().predictPartyVictory("RDR"));
        System.out.println(new LeetCode649().predictPartyVictory("DDRRRR"));
    }

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.length() == 0) {
            return null;
        }

        final char R = 'R';
        final char D = 'D';
        final String groupR = "Radiant";
        final String groupD = "Dire";
        int length = senate.length();
        // isSkip为true表示senete[i]失去权利
        boolean[] isSkip = new boolean[length];
        // 即将失去权利的R参议员的数量
        int skipR = 0;
        // 即将失去权利的D参议员的数量
        int skipD = 0;
        // 参议员
        char[] senators = senate.toCharArray();

        while (true) {
            // 本轮投票中，R阵营是否有权利投票
            boolean hasRightR = false;
            // 本轮投票中，D阵营是否有权利投票
            boolean hasRightD = false;


            for (int i = 0; i < senators.length; i++) {
                if (isSkip[i]) {
                    continue;
                }
                char senator = senators[i];

                if (senator == R) {
                    // 跳过当前R
                    if (skipR > 0) {
                        isSkip[i] = true;
                        skipR--;
                    }
                    // 跳过下一个D
                    else {
                        skipD++;
                        hasRightR = true;
                    }
                }

                else if (senator == D) {
                    // 跳过当前D
                    if (skipD > 0) {
                        isSkip[i] = true;
                        skipD--;
                    }
                    // 跳过下一个R
                    else {
                        skipR++;
                        hasRightD = true;
                    }
                }
            }

            // R阵营没有权利投票
            if (!hasRightR) {
                return groupD;
            }
            // D阵营没有权利投票
            if (!hasRightD) {
                return groupR;
            }
        }
    }
}

package com.qhy.practice.history.dp.longestPalindromicSubSequence;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 25, 2018 19:05
 */
public class Solution {
    public static int longestPalindromSeq(String seq) {
        int n = seq.length();
        int l;
        int table[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            table[i][i] = 1;
        }
        for (int j = 2; j <= n; j++)
            for (int k = 0; k < n - j + 1; k++) {
                l = k + j - 1;
                if (seq.charAt(k) == seq.charAt(l) && 2 == j) {
                    table[k][l] = 2;
                } else if (seq.charAt(k) == seq.charAt(l)) {
                    table[k][l] = table[k+1][l-1] + 2;
                } else {
                    table[k][l] = Math.max(table[k][l-1], table[k+1][l]);
                }
            }
       return table[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(Solution.longestPalindromSeq("abcefgcba"));
    }

}

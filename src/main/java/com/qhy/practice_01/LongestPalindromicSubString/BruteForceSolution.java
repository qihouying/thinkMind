package com.qhy.practice_01.LongestPalindromicSubString;

/**
 * Created by dream on 2017/10/6.
 */
public class BruteForceSolution {
    public String longestPalindromicSubString(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < len; i++)
            for (int j = i+1; j < len; j++) {
                int span = 0;
                while (c[i+span] == c[j+span]) {
                    span++;
                }
                if (maxLen < span) {
                    maxLen = span;
                    start = i;
                }
            }
        return s.substring(start, start+maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        System.out.println(bruteForceSolution.longestPalindromicSubString(s));
    }

}

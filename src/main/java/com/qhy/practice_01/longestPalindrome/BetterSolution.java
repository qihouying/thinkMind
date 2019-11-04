package com.qhy.practice_01.longestPalindrome;

/**
 * Created by dream on 2017/10/2.
 */
public class BetterSolution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L > 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R-L-1;
    }

    public static void main(String[] args) {
        String s = "babad";
        BetterSolution betterSolution = new BetterSolution();
        System.out.println(betterSolution.longestPalindrome(s));
    }
}

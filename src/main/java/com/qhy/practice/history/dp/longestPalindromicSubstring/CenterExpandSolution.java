package com.qhy.practice.history.dp.longestPalindromicSubstring;

/**
 * Desc:
 *
 * http://windliang.cc/2018/08/05/leetCode-5-Longest-Palindromic-Substring/
 * 提到5种解决方案
 *
 * author: qihouying@meituan.com
 * Date:   09 25, 2018 14:51
 */
public class CenterExpandSolution {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int expandFromCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >=0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R-L-1;
    }

    public static void main(String[] args) {
        System.out.println(CenterExpandSolution.longestPalindrome("bbb"));
    }
}

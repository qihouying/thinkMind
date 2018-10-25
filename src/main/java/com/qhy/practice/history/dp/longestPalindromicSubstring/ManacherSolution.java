package com.qhy.practice.history.dp.longestPalindromicSubstring;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 26, 2018 15:36
 */
public class ManacherSolution {
    public static String longestPalindrome(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }
        String str = preProcess(s);
        int n = str.length();
        int r = 0, c = 0;
        int[] p = new int[n];
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < str.length()-1; i ++) {
            int i_mirror = 2*c-i;
            p[i] = (r > i) ? Math.min(r-i, p[i_mirror]) : 0;

            while(i+1+p[i] < n && i-1-p[i] > -1 && str.charAt(i+1+p[i]) == str.charAt(i-1-p[i])) {
                p[i]++;
            }

            if (r < i + p[i]) {
                c = i;
                r = i + p[i];
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        System.out.println(maxLen);
        int start = (centerIndex - maxLen)/2;
        return s.substring(start, start + maxLen);

    }

    public static String preProcess(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += "#" + s.charAt(i);
        }
        result += "#";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ManacherSolution.longestPalindrome("ababbabbaba"));
    }
}

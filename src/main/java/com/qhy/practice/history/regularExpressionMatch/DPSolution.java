package com.qhy.practice.history.regularExpressionMatch;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 08, 2018 16:10
 */
public class DPSolution {
    public static boolean isMatch(String text, String pattern) {
        if (null == pattern || pattern.isEmpty())
            return null == text || text.isEmpty();
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        dp[0][0] = true;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pattern.charAt(j) == '*') {
                    if (pattern.charAt(j-1) != text.charAt(i) && pattern.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }

    public static void main(String[] args) {
        System.out.println(DPSolution.isMatch("mississippi", "mis*is*p*."));
    }
}

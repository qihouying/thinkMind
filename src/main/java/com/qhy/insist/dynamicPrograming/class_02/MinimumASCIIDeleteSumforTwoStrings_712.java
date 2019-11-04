package com.qhy.insist.dynamicPrograming.class_02;

/**
 * @Author dream
 * @Date 2019/11/2 9:58 PM
 * @Description [Medium]   Topics: [String] [Dynamic Programming]
 *
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

    Example 1:
    Input: s1 = "sea", s2 = "eat"
    Output: 231
    Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
    Deleting "t" from "eat" adds 116 to the sum.
    At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
    Example 2:
    Input: s1 = "delete", s2 = "leet"
    Output: 403
    Explanation: Deleting "dee" from "delete" to turn the string into "let",
    adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
    At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
    If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
    Note:

    0 < s1.length, s2.length <= 1000.
    All elements of each string will have an ASCII value in [97, 122].
 */
public class MinimumASCIIDeleteSumforTwoStrings_712 {
    /**
     * dp[i][j] is the cost for s1.substr(0,i) and s2.substr(0, j). Note s1[i], s2[j] not included in the substring.

         Base case: dp[0][0] = 0
         target: dp[m][n]

         if s1[i-1] = s2[j-1]   // no deletion
         dp[i][j] = dp[i-1][j-1];
         else   // delete either s1[i-1] or s2[j-1]
         dp[i][j] = min(dp[i-1][j]+s1[i-1], dp[i][j-1]+s2[j-1]);
     *
     */
    public int minimumDeleteSum(String str1, String str2) {
        if (isNull(str1) ||  isNull(str2))
            return 0;
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + str2.charAt(i-1);
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + str1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + str1.charAt(i-1), dp[i][j-1] + str2.charAt(j-1));
                }
            }
        }
        return dp[m][n];

    }

    public boolean isNull(String str) {
        return null == str;
    }

}

package com.qhy.insist.dynamicPrograming.class_02;

import java.util.Arrays;

/**
 * @Author dream
 * @Date 2019/11/2 11:47 PM
 * @Description [Hard]   Topics: [String] [Dynamic Programming]
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')

    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
 *
 */
public class EditDistance_72 {

    /**
     * To apply DP, we define the state dp[i][j] to be the minimum number of operations to convert word1[0..i) to word2[0..j).

         For the base case, that is, to convert a string to an empty string, the mininum number of operations (deletions)
     is just the length of the string. So we have dp[i][0] = i and dp[0][j] = j.

         For the general case to convert word1[0..i) to word2[0..j), we break this problem down into sub-problems. Suppose
     we have already known how to convert word1[0..i - 1) to word2[0..j - 1) (dp[i - 1][j - 1]), if word1[i - 1] == word2[j - 1],
     then no more operation is needed and dp[i][j] = dp[i - 1][j - 1].

         If word1[i - 1] != word2[j - 1], we need to consider three cases.

         Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
         If word1[0..i - 1) = word2[0..j) then delete word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
         If word1[0..i) + word2[j - 1] = word2[0..j) then insert word2[j - 1] to word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).
         So when word1[i - 1] != word2[j - 1], dp[i][j] will just be the minimum of the above three cases.
     *
     */
    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2)
            return -1;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     *
     * Note that each time when we update dp[i][j], we only need dp[i - 1][j - 1], dp[i][j - 1] and dp[i - 1][j]. We may
     * optimize the space of the code to use only two vectors.
     */

    public int minDistance_optim1(String word1, String word2) {
        if (null == word1 || null == word2)
            return -1;
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n+1], cur = new int[n+1];
        for (int i = 1;  i <= n; i++) {
            pre[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur[j] = pre[i-1];
                } else {
                    cur[j] = Math.min(pre[j-1], Math.min(cur[j-1], pre[j]))+1;
                }
            }
            Arrays.fill(pre, 0);

            //swap(pre, cur);
            int[] temp = new int[n+1];
            temp = cur;
            cur = pre;
            pre = temp;
        }
        return pre[n];
    }

    //Or even just one vector
    public int minDistance_optim2(String word1, String word2) {
        if (null == word1 || null == word2)
            return -1;
        int m = word1.length(), n = word2.length();
        int[] cur = new int[n + 1];
        int pre;

        for (int i = 1; i <= n; i++) {
            cur[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            pre = cur[0];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = cur[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre;
                } else {
                    cur[j] = Math.min(pre, Math.min(cur[j-1], cur[j]))+1;
                }
                pre = temp;
            }
        }
        return cur[n];
    }

}

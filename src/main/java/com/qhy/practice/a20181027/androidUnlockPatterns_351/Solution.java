package com.qhy.practice.a20181027.androidUnlockPatterns_351;

/**
 * Created by dream on 2018/10/28.
 *
 *
 *
 Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 Rules for a valid pattern:
     1. Each pattern must connect at least m keys and at most n keys.
     2. All the keys must be distinct.
     3. If the line connecting two consecutive keys in the pattern passes through any other
     keys, the other keys must have previously selected in the pattern. No jumps through
     non selected key is allowed.
     4. The order of keys used matters.
 Explanation:
     |1|2|3 | |4|5|6 | |7|8|9 |
     Invalid move: 4 - 1 - 3 - 6
     Line 1 - 3 passes through key 2 which had not been selected in the pattern.
     Invalid move: 4 - 1 - 9 - 2
     Line 1 - 9 passes through key 5 which had not been selected in the pattern.
     Valid move: 2 - 4 - 1 - 3 - 6
     Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

     Valid move: 6 - 5 - 4 - 1 - 9 - 2
     Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 Example:
     Given m = 1, n = 1, return 9.


 amazing!!!!
 *
 */
public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] =
                skip[4][6] = skip[6][4] = skip[3][7] = skip[7][3] = 5;
        boolean visit[] = new boolean[10];
        int result = 0;
        for (int i = m; i <= n; i++) {
            result += dfs(visit, skip, 1, i-1)*4;
            result += dfs(visit, skip, 2, i-1)*4;
            result += dfs(visit, skip, 5, i-1);
        }
        return result;
    }

    public int dfs(boolean[] visit, int[][] skip, int current, int remain) {
        if (remain < 0)
            return 0;
        if (remain == 0)
            return 1;
        visit[current] = true;
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visit[i] && (skip[i][current] == 0 || visit[skip[i][current]])) {
                result += dfs(visit, skip, i, remain-1);
            }
        }
        visit[current] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPatterns(1, 1));
    }
}

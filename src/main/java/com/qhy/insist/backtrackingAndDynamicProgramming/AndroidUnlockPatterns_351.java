package com.qhy.insist.backtrackingAndDynamicProgramming;

/**
 * @Author houyingqi
 * @Date 2019-10-02 13:02
 * @Description [Medium] Topic: [Dynamic Programming]  [Backtracking]
 *
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen, which consist of
 * minimum of m keys and maximum n keys.
 * Rules for a valid pattern:
 * 1. Each pattern must connect at least m keys and at most n keys.
 * 2. All the keys must be distinct.
 * 3. If the line connecting two consecutive keys in the pattern passes through any other
 * keys, the other keys must have previously selected in the pattern. No jumps through
 * non selected key is allowed.
 * 4. The order of keys used matters.
 *
 *
 * Explanation:
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the
 * pattern
 *
 * Explanation:
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the
 * patter
 **/
//思路不容易想到，巧妙利用对称性和DFS
public class AndroidUnlockPatterns_351 {

    public int numberOfPatterns(int m, int n) {
        boolean[] vis = new boolean[10];
        int res = 0;
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        for (int i = m ; i <= n; i++) {
            res += DFS(vis, 1, skip, i-1)*4;
            res += DFS(vis, 2, skip, i-1)*4;
            res += DFS(vis, 5, skip, i-1);
        }
        return res;
    }
    public int DFS(boolean[] vis, int cur, int[][] skip, int remain) {
        if (remain < 0)
            return 0;
        if (remain==0)
            return 1;
        vis[cur] = true;
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if (!vis[i] && (0 != skip[i][cur]) || vis[skip[i][cur]]) {
                res += DFS(vis, i, skip, remain-1);
            }
        }
        vis[cur] = false;// backtracking
        return res;
    }

    public static void main(String[] args) {
        AndroidUnlockPatterns_351 androidUnlockPatterns = new AndroidUnlockPatterns_351();
        System.out.println(androidUnlockPatterns.numberOfPatterns(1,1));
    }
}

package com.qhy.insist.Fourth;

import java.util.*;

/**
 * @Author houyingqi
 * @Date 2019-10-01 21:21
 * @Description [Medium]
 *
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 *
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest
 * fibonacci-like subsequence of A.  If one does not exist, return 0.
 *
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none)
 * from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 *
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 *
 *
 * Note:
 *
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 **/
public class LengthOfLongestFibonacciSubsequence_873 {
    //Method1: 太过暴力，LeetCode直接不通过，时间超了 N^3
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                List<Integer> subsequence = new ArrayList<>();
                int num1 = A[i], num2 = A[j];
                int times = 0;
                for (int k = j+1; k < n; k++) {
                    if (A[k] > num1 + num2)
                        break;
                    if (A[k] < num1 + num2)
                        continue;
                    if (times == 0) {
                        subsequence.add(num1);
                        subsequence.add(num2);
                    }
                    if (A[k] == num1 + num2) {
                        subsequence.add(A[k]);
                        num1 = num2;
                        num2 = A[k];
                        times++;
                    }
                }
                if (subsequence.size() > max) {
                    max = subsequence.size();
                }
            }
        return max;
    }

    //Method2: LeetCode 给出的暴力求解法, 比Method1稍微好些 N^2 *logN
    public int lenLongestFibSubseq2(int[] A) {
        int n = A.length;
        int max = 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int a : A) {
            s.add(a);
        }
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                int len = 2;;
                int num1 = A[i], num2 = A[j], sum = num1+num2;
                int times = 0;
                while (s.contains(sum)) {
                    num1 = num2;
                    num2 = sum;
                    sum = num1 + num2;
                    max = Math.max(max, ++len);
                }
            }
        return max >= 3 ? max : 0;
    }

    //Method3:动态规划, 提交显示，不如Method2时间短
    public int lenLongestFibSubseq3(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        Map<Integer, Integer> longest = new HashMap();
        int max = 0;

        for (int k = 0; k < N; ++k)
            for (int j = 0; j < k; ++j) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int len = longest.getOrDefault(i * N + j, 2) + 1;
                    longest.put(j * N + k, len);
                    max = Math.max(max, len);
                }
            }

        return max >= 3 ? max : 0;
    }

    //Method4:动态规划  LeetCode提交耗时最长
    public int lenLongestFibSubseq4(int[] A) {
        int max = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            index.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int k = index.getOrDefault(A[j] - A[i], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && k >= 0) ? dp[k][i] + 1 : 2;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max > 2 ? max : 0;
    }

    public static void main(String[] args) {
        int[] A = {1,3,7,11,12,14,18};
        int[] A1 = {1,2,3,4,5,6,7,8};
        LengthOfLongestFibonacciSubsequence_873 longestFibonacciSubsequence = new LengthOfLongestFibonacciSubsequence_873();
        /*System.out.println(longestFibonacciSubsequence.lengthOfLongestFibonacciSeq(A));
        System.out.println(longestFibonacciSubsequence.lengthOfLongestFibonacciSeq(A1));*/
        System.out.println(longestFibonacciSubsequence.lenLongestFibSubseq4(A1));
    }

}

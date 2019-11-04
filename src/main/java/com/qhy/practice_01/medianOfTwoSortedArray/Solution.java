package com.qhy.practice_01.medianOfTwoSortedArray;

/**
 * Created by dream on 2018/9/24.
 */
public class Solution {
    public static double findMedianOfTwoSortedArray(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int temp = m; m = n; n = temp;
            int[] tempNum = A; A = B; B = tempNum;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1)/2;
        while (iMin <= iMax) {
            int i = (iMin + iMax)/2;
            int j = halfLen - i;
            if (i > iMin && A[i-1] > B[j]) {
                iMax = i-1;
            } else if (i < iMax && B[j-1] > A[i]) {
                iMin = i+1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1];
                } else if (j == 0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                if ((m+n) % 2 == 1)
                    return maxLeft;
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == m) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        int[] B = new int[]{4};
        System.out.println(Solution.findMedianOfTwoSortedArray(A, B));
    }
}

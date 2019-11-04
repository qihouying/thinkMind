package com.qhy.practice_01.medianOfTwoSortedArray;

/**
 * Created by dream on 2017/10/6.
 */
public class BestSolution {
    public double findMedianOfTwoSortedArray(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp1 = m;
            m = n;
            n = temp1;
        }
        System.out.println(m);
        if (0 == m && 0 == n)
            return 0.0;
        else if (0 == m) {
            if (n % 2 == 1)
                return nums2[n/2];
            else
                return (nums2[n/2-1]+nums2[n/2])/2;
        }

        int start_nums1 = 0, end_nums1 = m;
        int half = (m+n+1)/2;
        int maxLeft = 0;
        int minRight = 0;

        while (start_nums1 <= end_nums1) {
            int i = (start_nums1 + end_nums1) / 2;
            int j = half - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                end_nums1 = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                start_nums1 = i + 1;
            } else {
                if (0 == i) {
                    maxLeft = nums2[j - 1];
                } else if (0 == j) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m+n) % 2 == 1)
                    return maxLeft;

                if (m == i) {
                    minRight = nums2[j];
                } else if (n == j){
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        BestSolution bestSolution = new BestSolution();
        System.out.println(bestSolution.findMedianOfTwoSortedArray(nums1,nums2));
    }
}

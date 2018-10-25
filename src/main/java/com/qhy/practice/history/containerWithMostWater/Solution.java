package com.qhy.practice.history.containerWithMostWater;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 08, 2018 17:18
 */
public class Solution {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i+1; j < height.length; j++) {
                int area = (j-i)*Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(Solution.maxArea(height));
    }
}

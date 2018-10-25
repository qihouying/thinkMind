package com.qhy.practice.history.containerWithMostWater;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 08, 2018 17:47
 */
public class BetterSolution {
    public static int maxArea(int[] height) {
        int s = 0, e = height.length-1, maxArea = 0;
        while (s < e) {
            maxArea = Math.max(maxArea, (e-s)*Math.min(height[s], height[e]));
            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(BetterSolution.maxArea(height));
    }
}

package com.qhy.sort.quickSort;

import java.util.Arrays;

/**
 * @Author dream
 * @Date 2020/2/16 8:48 AM
 * @Description []   Topics: []  companies: []
 */
public class QuickSort1 {
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotLoc = partition(nums, left, right);
            quickSort(nums, left, pivotLoc-1);
            quickSort(nums, pivotLoc+1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivotKey = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivotKey) --right;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivotKey) ++left;
            nums[right] = nums[left];
        }
        nums[left] = pivotKey;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 1, 0, 3, 10};
        System.out.println("Before quickSort：" + Arrays.toString(nums));

        QuickSort1 quickSort1 = new QuickSort1();
        quickSort1.quickSort(nums, 0, nums.length-1);
        System.out.println("After quickSort：" + Arrays.toString(nums));
    }
}

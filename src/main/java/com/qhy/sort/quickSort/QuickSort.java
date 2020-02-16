package com.qhy.sort.quickSort;

/**
 * @Author dream
 * @Date 2020/2/15 9:54 PM
 * @Description []   Topics: []  companies: []
 */
public class QuickSort {
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
}

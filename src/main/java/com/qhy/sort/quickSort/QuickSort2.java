package com.qhy.sort.quickSort;

import java.util.Arrays;

/**
 * @Author dream
 * @Date 2020/2/16 9:03 AM
 * @Description []   Topics: []  companies: []
 */
public class QuickSort2 {
    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(nums, low, high);
            quickSort(nums, low, pivotLoc-1);
            quickSort(nums, pivotLoc+1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivotKey) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivotKey) {
                ++ low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivotKey;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 1, 0, 3, 10};
        System.out.println("Before quickSort：" + Arrays.toString(nums));

        QuickSort2 quickSort = new QuickSort2();
        quickSort.quickSort(nums, 0, nums.length-1);

        System.out.println("After quickSort：" + Arrays.toString(nums));
    }
}

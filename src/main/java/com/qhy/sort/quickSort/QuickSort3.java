package com.qhy.sort.quickSort;

import java.util.Arrays;

/**
 * @Author dream
 * @Date 2020/2/16 9:25 AM
 * @Description []   Topics: []  companies: []
 */
public class QuickSort3 {
    public  <T extends Comparable<? super T>> void quickSort(T[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(nums, low, high);
            quickSort(nums, low, pivotLoc-1);
            quickSort(nums, pivotLoc+1, high);
        }
    }

    public  <T extends Comparable<? super T>> int partition(T[] nums, int low, int high) {
        T pivotKey = nums[low];
        while (low < high) {
            while (low < high && (nums[high]).compareTo(pivotKey) >= 0) {
                --high;
            }
            nums[low] = nums[high];
            while (low < high && (nums[low]).compareTo(pivotKey) <= 0) {
                ++low;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivotKey;
        return low;
    }

    public <T extends Comparable<? super T>> void sort(T[] input) {
        quickSort(input, 0, input.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 1, 0, 3, 10};
        Integer[] numsInt = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInt[i] = nums[i];
        }

        System.out.println("Before int nums quickSort：" + Arrays.toString(nums));

        QuickSort3 quickSort = new QuickSort3();
        quickSort.sort(numsInt);

        System.out.println("After int nums quickSort：" + Arrays.toString(numsInt));

        Double[] nums1 = {4.0, 9.0, 2.0, 1.0, 0.0, 3.0, 10.0};
        System.out.println("Before Double nums quickSort：" + Arrays.toString(nums1));

        quickSort.sort(nums1);

        System.out.println("After Double nums quickSort：" + Arrays.toString(nums1));

        Long[] numsLong = {4l, 9l, 2l, 1l, 0l, 3l, 10l};
        quickSort.sort(numsLong);

        System.out.println("After Long nums quickSort：" + Arrays.toString(numsLong));

    }
}

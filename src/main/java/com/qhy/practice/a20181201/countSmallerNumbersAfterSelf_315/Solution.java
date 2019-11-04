package com.qhy.practice.a20181201.countSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dream on 2018/12/2.
 *
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 Example:
     Given nums = [5, 2, 6, 1]
     To the right of 5 there are 2 smaller elements (2 and 1).
     To the right of 2 there is only 1 smaller element (1).
     To the right of 6 there is 1 smaller element (1).
     To the right of 1 there is 0 smaller element.
     Return the array [2, 1, 1, 0].
 Companies
    Google
 Topics
    Divide and Conquer Binary Indexed Tree Segment Tree Binary Search Tree

 *
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        List<Integer> sortedList = new ArrayList<Integer>();
        for (int i = nums.length-1; i >= 0; i--) {
            int index = findIndex(sortedList, nums[i]);
            result[i] = index;
            sortedList.add(index, nums[i]);
        }
        return Arrays.asList(result);
    }

    public int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0)
            return 0;
        int start = 0;
        int end = sorted.size()-1;
        if (sorted.get(end) < target)
            return end+1;
        if (sorted.get(start) >= target)
            return 0;
        while(start+1 < end) {
            int mid = start + (end-start)/2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target)
            return start;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        Solution solution = new Solution();
        System.out.println(solution.countSmaller(nums));
    }

}

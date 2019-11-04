package com.qhy.summary._firstClass;

import java.util.Arrays;

/**
 * Created by dream on 2019/3/2.
 *
 *   Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 *   that satisfy the condition nums[i] + nums[j] + nums[k] < target .
 *
     For example,
        given nums = [-2, 0, 1, 3], and target = 2.
        Return 2. Because there are two triplets which sums are less than 2:
         [-2, 0, 1]
         [-2, 0, 3]
     Follow up:
        Could you solve it in O(n2) runtime?
     Companies
        Google
     Topics
        Array Two Pointers
 */
public class ThreeSumSmaller_259_medium {
    public int threeSumSmaller(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    count += right-left;
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        ThreeSumSmaller_259_medium threeSumSmaller_259_medium = new ThreeSumSmaller_259_medium();
        System.out.println(threeSumSmaller_259_medium.threeSumSmaller(nums, 2));
    }
}

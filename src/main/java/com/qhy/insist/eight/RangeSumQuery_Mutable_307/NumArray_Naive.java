package com.qhy.insist.eight.RangeSumQuery_Mutable_307;

/**
 * @Author houyingqi
 * @Date 2019-10-04 19:53
 * @Description [Medium] Topics: [Binary Indexed Tree] [Segment Tree]
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 **/
/**
 * Approach 1: Naive Method
 *
 * 直接就用个数组 data 接住 nums，然后要更新就更新，要求区域和，就遍历求区域和
 *
 * 时间复杂度：O(n) 空间复杂度：O(n)，或者直接在原数组上修改，则时间复杂度为O(1)
 * Time complexity : O(n) - range sum query, O(1) - update query
 * For range sum query we access each element from the array for constant time and in the worst case we access n elements.
 * Therefore time complexity is O(n), Time complexity of update query is O(1).
 * Space complexity : O(1).
 */
public class NumArray_Naive {
    int[] nums;

    public NumArray_Naive(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray_Naive numArray_naive = new NumArray_Naive(nums);
        numArray_naive.update(1, 2);
        System.out.println(numArray_naive.sumRange(0, 2));
    }

}

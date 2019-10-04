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
//A classic subject，including many methods, you should review it again
public class NumArray_SqrtDecomposition {
    int[] nums;
    int len;
    int[] block;

    /**
     * Approach 2: Sqrt Decomposition
     *
     * 思想：
     * The idea is to split the array in blocks with length of sqrt{n}. Then we calculate the sum of each block and
     * store it in auxiliary memory b. To query RSQ(i, j), we will add the sums of all the blocks lying inside and
     * those that partially overlap with range [i…j].
     *
     * Complexity Analysis
     *
     * Time complexity : O(n)- preprocessing, O(sqrt{n})- range sum query, O(1)- update query
     *
     * For range sum query in the worst-case scenario we have to sum approximately 3*sqrt{n} elements.
     * In this case the range includes sqrt{n-2} blocks, which total sum costs sqrt{n-2} operations. In addition to this
     * we have to add the sum of the two boundary blocks. This takes another 2*sqrt{n-1} operations. The total amount of
     * operations is around 3*sqrt{n}
     *
     * Space complexity : O(sqrt{n})
     *
     * We need additional sqrt{n} memory to store all block sums
     *
     */
    public NumArray_SqrtDecomposition(int[] nums) {
        this.nums = nums;
        double q = Math.sqrt(nums.length); //尽量让每个block中包含的数字个数相等
        len = (int)Math.ceil(nums.length/q);
        block = new int[len];
        for (int i = 0; i < nums.length; i++) {
            block[i/len] += nums[i];
        }

    }

    public void update(int i, int val) {
        int sum = 0;
        int b_l = i/len;
        block[b_l] += val - nums[i];
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int b_l = i/len;
        int b_r = j/len;
        if (b_l == b_r) {
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
        } else {
            for (int k = i; k < (b_l+1)*len; k++) {
                sum += nums[k];
            }
            for (int k = b_l+1; k < b_r; k++) {
                sum += block[k];
            }
            for (int k = b_r*len; k <= j; k++) {
                sum += nums[k];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray_SqrtDecomposition numArray_sqrtDecomposition = new NumArray_SqrtDecomposition(nums);
        numArray_sqrtDecomposition.update(1, 2);
        System.out.println(numArray_sqrtDecomposition.sumRange(0, 2));
    }

}

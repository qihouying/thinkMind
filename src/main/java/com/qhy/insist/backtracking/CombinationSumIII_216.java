package com.qhy.insist.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/10/26 9:47 PM
 * @Description [Medium]   Topics: [Array] [Backtracking]
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
 * used and each combination should be a unique set of numbers.

    Note:

    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Example 2:

    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */

//与CombinationSumII比较相似，只是增加判断k的限制，和num需要人为构造，而且省去了sort过程
public class CombinationSumIII_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<Integer>(), nums, k, n, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subList, int[] nums, int k, int target, int start) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<Integer>(subList));
        } else {
            for (int i = start; i < nums.length && target > 0 && k > 0; i++) {
                subList.add(nums[i]);
                backtrack(result, subList, nums, k-1, target-nums[i], i+1);
                subList.remove(subList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII_216 combinationSum = new CombinationSumIII_216();
        System.out.println(combinationSum.combinationSum3(3, 9));
    }

}

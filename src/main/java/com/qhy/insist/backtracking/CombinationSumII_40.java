package com.qhy.insist.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/10/26 9:47 PM
 * @Description [Medium]   Topics: [Array] [Backtracking]
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 */
public class CombinationSumII_40 {
    /**
     * Build an array to apply to "subset" template. Each time we add an element to the "list", for the next step,
     * target= target - num[i]. Since we have already added one element, for the next step, we can only add k-1 elements.
     * Since no duplicated elements accept, for the next loop, the "start" should point to the next index of current index.
     * The list.remove(list.size() - 1) here means, we need to change the element here. I know it is hard to understand it,
     * let me give you an example.
     * When k=3, n=9, my answer works like this:\
     * [1]->[1,2]->[1,2,3]. Since now sum is not 9, no more backtracking, so after list.remove(list.size() - 1), it is [1,2].
     * Then next follows [1,2,4], sum is not 9, repeat process above untill [1,2,6]. When go to next backtracking, the list
     * will be added to result, and for this list, no more backtracking.
     * Now we can go back to a previous backtracking, which is [1,3]->[1,3,4], fail. [1,4,]->[1,4,5], fail. And so one.
     * So the point of list.remove(list.size() - 1) is, after each "fail" or "success", since we don't need to do further
     * attempts given such a condition, we delete the last element, and then end current backtracking. Next step is, add
     * the next element to the deleted index, go on attempting.
     *
     */

    public List<List<Integer>> combinationSum2(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, n, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subList, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(subList));
        } else {
            for (int i = start; i < nums.length && target > 0; i++) {
                if (nums[i] > target)
                    return;
                //check duplicate combination
                if (i > start && nums[i] == nums[i-1])
                    continue;
                subList.add(nums[i]);
                backtrack(result, subList, nums,target-nums[i], i+1);
                subList.remove(subList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII_40 combinationSum = new CombinationSumII_40();
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(combinationSum.combinationSum2(nums, 8));
    }

}

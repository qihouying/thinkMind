package com.qhy.insist.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/10/26 9:47 PM
 * @Description [Medium]   Topics: [Array] [Backtracking]
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *  Note:
 *  All numbers (including target) will be positive integers.
 *  The solution set must not contain duplicate combinations.
 *  Example 1:
 *  Input: candidates = [2,3,6,7], target = 7,
 *  A solution set is:
 *  [
 *  [7],
 *  [2,2,3]
 *  ]
 *
 *  Example 2:
 *  Input: candidates = [2,3,5], target = 8,
 *  A solution set is:
 *  [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 *  ]
 *
 */


/**
 * 像这种结果要求返回所有符合要求解的题十有八九都是要利用到递归，而且解题的思路都大同小异，相类似的题目有 Path Sum II，Subsets II，
 * Permutations，Permutations II，Combinations 等等，如果仔细研究这些题目发现都是一个套路，都是需要另写一个递归函数，这里我们新加入
 * 三个变量，start 记录当前的递归到的下标，out 为一个解，res 保存所有已经得到的解，每次调用新的递归函数时，此时的 target 要减去当前数组的的数
 */
public class CombinationSum_39 {
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
     * Time complexity is O(2^n). Space complexity O(n). Basically, for each num you have two choices, pick it or not.
     *
     */

    public List<List<Integer>> combinationSum(int[] nums, int n) {
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
                subList.add(nums[i]);
                backtrack(result, subList, nums,target-nums[i], i);
                subList.remove(subList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_39 combinationSum = new CombinationSum_39();
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum.combinationSum(nums, 7));
    }

}

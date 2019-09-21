package com.qhy.practice.a20181121.combinationSumII_40;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by dream on 2018/11/14.
 *
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 Each number in C may only be used once in the combination. Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
 (ie, a1 ≤ a2 ≤ ... ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8 , A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class Solution {
    public List<List<Integer>> combineationSumII(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs_combineation(array, 0, target, path, result);

        return result;
    }

    public void dfs_combineation(int[] array, int index, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        if (target < 0)
            return;

        for (int i = index; i < array.length; i++) {
            if (i > index && array[i] == array[i-1]) {
                continue;
            }
            path.add(path.size(), array[i]);
            dfs_combineation(array, i+1, target-array[i], path, result);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] array = {10,1,2,7,6,1,5};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(solution.combineationSumII(array, target));
    }
}

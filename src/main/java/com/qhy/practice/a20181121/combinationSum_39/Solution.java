package com.qhy.practice.a20181121.combinationSum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2018/11/26.
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 The same repeated number may be chosen from C unlimited number of times. Note:
 All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7, A solution set is:
 [
 [7],
 [2, 2, 3] ]
 Companies
    Uber Snapchat
 Topics
    Array Backtracking

 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        recursive(new ArrayList<Integer>(), target, candidates, 0, result);
        return result;
    }

    public void recursive(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> result) {
        if (0 == target) {
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget >= 0) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(candidates[i]);
                recursive(copy, newTarget, candidates, i, result);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(candidates, target));
    }
}

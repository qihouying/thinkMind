package com.qhy.practice.a20181121.combinationSumIII_216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2018/11/26.
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 Example 1:
     Input: k = 3, n = 7 Output:
     [[1,2,4]]
 Example 2:
     Input: k = 3, n = 9 Output:
     [[1,2,6], [1,3,5], [2,3,4]]
 Companies
 Topics
    Array Backtracking
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> com, int k, int start, int n) {
        if (com.size() == k && n == 0) {
            List<Integer> temp = new ArrayList<Integer>(com);
            ans.add(temp);
            return;
        }
        for (int i = start; i<= 9; i++) {
            com.add(i);
            combination(ans, com, k, i+1, n-i);
            com.remove(com.size()-1);
        }
    }
}

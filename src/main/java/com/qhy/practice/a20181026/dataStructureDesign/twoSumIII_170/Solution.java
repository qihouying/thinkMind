package com.qhy.practice.a20181026.dataStructureDesign.twoSumIII_170;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2018/10/28.
 *
 * amazing!!!!!
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find .
   add - Add the number to an internal data structure.
   find - Find if there exists any pair of numbers which sum is equal to the value.
   For example,
         add(1); add(3); add(5);
         find(4) -> true
         find(7) -> false
 *
 */
public class Solution {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number)+1 : 1);
    }
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if (i == j && entry.getValue() > 1 || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.add(1);
        solution.add(3);
        solution.add(3);
        solution.add(5);
        System.out.println(solution.find(4));
        System.out.println(solution.find(7));
        System.out.println(solution.find(6));
    }
}

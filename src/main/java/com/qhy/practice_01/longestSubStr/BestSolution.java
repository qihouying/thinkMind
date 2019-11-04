package com.qhy.practice_01.longestSubStr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2017/9/25.
 */
public class BestSolution {
    public int lengthOfLongestSubString(String s) {
        int maxLength = 0, start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }


            maxLength = Math.max(maxLength, j-i+1);
            map.put(s.charAt(j), j+1);
//            start = j;
//            end = j+maxLength-1;
//            System.out.println(s.substring(start, end));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        BestSolution bestSolution = new BestSolution();
        System.out.println(bestSolution.lengthOfLongestSubString(s));
    }
}

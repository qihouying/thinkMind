package com.qhy.practice_01.longestSubStr;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dream on 2017/9/25.
 */
public class BetterSolution {

    public int lengthOfLongestSubString(String s) {
        Set<Character> set = new HashSet<Character>();
        int maxLength = 0, i =0, j = 0, n = s.length();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(i))) {
                maxLength = Math.max(maxLength, j-i);
                set.add(s.charAt(j++));
            } else {
               set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwweuw";
        BetterSolution betterSolution = new BetterSolution();
        System.out.println(betterSolution.lengthOfLongestSubString(s));
    }
}

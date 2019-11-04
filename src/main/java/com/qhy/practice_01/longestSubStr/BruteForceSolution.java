package com.qhy.practice_01.longestSubStr;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dream on 2017/9/22.
 */
public class BruteForceSolution {
    public int lengthOfLongestSubString(String s) {
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                if (unique(s,i,j)) {
                    maxLength = Math.max(maxLength, j-i);
                }
            }
            return maxLength;
    }

    public boolean unique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "pwweuw";
        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        System.out.println(bruteForceSolution.lengthOfLongestSubString(s));
    }
}

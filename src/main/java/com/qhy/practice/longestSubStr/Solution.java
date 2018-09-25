package com.qhy.practice.longestSubStr;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 18, 2018 20:17
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            Character c = chars[i];
            if (charIndex.containsKey(c)) {
                j = Math.max(i, charIndex.get(c)+1);
            }
            charIndex.put(c, i);
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
    }
}

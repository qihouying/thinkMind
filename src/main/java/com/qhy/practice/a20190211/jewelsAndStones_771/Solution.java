package com.qhy.practice.a20190211.jewelsAndStones_771;

import com.sun.tools.javac.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dream on 2018/12/31.
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

 The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 so "a" is considered a different type of stone from "A".

 Example 1:

 Input: J = "aA", S = "aAAbbbb"
 Output: 3
 Example 2:

 Input: J = "z", S = "ZZ"
 Output: 0
 Note:

 S and J will consist of letters and have length at most 50.
 The characters in J are distinct.
 *
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        if (null == J || null == S)
            return 0;
        char[] types = J.toCharArray();
        char[] stones = S.toCharArray();
        int count = 0;
        Map<Character, Integer> typeNum = new HashMap<>();
        for (char type : types) {
            if (typeNum.containsKey(type)) {
                typeNum.put(type, typeNum.get(type)+1);
            } else {
                typeNum.put(type, 1);
            }
        }
        for (char stone : stones) {
            if (typeNum.containsKey(stone)) {
                count += typeNum.get(stone);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        Solution solution = new Solution();
        System.out.println(solution.numJewelsInStones(J, S));
    }
}

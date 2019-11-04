package com.qhy.practice_01.regularMatch;

/**
 * Created by dream on 12/10/2017.
 */

public class Solution {
    public static boolean isMatch(String s, String p) {
        if (isEmpty(p))
            return isEmpty(s);
        if ((isEmpty(s) && !isEmpty(p)) || (!isEmpty(s) && isEmpty(p)))
            return false;
        boolean firstMatch = !isEmpty(s) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean isEmpty(String s) {
        if (null == s || s.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(Solution.isMatch(s, p));
    }
}

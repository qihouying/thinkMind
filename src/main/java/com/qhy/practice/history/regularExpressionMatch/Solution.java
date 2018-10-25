package com.qhy.practice.history.regularExpressionMatch;


/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 08, 2018 15:04
 */
public class Solution {
    public static boolean isMatch(String text, String pattern) {
        if (null == pattern || pattern.isEmpty()) {
            return null == pattern || text.isEmpty();
        }
        boolean firstMatch = (null != text && !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isMatch("mississippi", "mis*is*p*."));
    }
}

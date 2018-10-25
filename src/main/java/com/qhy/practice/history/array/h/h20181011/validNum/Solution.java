package com.qhy.practice.history.array.h.h20181011.validNum;

/**
 * Desc:
 *
 * Validate if a given string can be interpreted as a decimal number.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 " -90e3   " => true
 " 1e" => false
 "e3" => false
 " 6e-1" => true
 " 99e2.5 " => false
 "53.5e93" => true
 " --6 " => false
 "-+3" => false
 "95a54e53" => false

 * author: qihouying@meituan.com
 * Date:   10 11, 2018 17:18
 */
public class Solution {
    public static boolean isNumber(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while (start <= end && Character.isWhitespace(s.charAt(start))) start++;
        if (start > len - 1) return false;
        while (end >= start && Character.isWhitespace(s.charAt(end))) end--;
        // skip leading +/-
        if (s.charAt(start) == '+' || s.charAt(start) == '-') start++;
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (start <= end) {
            char c = s.charAt(start);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if(exp || dot) return false;
                dot = true;
            } else if (c == 'e') {
                if(exp || !num) return false;
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(start - 1) != 'e') return false;
            } else {
                return false;
            }
            start++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isNumber("53.5e93"));
    }
}

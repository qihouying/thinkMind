package com.qhy.practice_01.stringToInteger;

/**
 * Created by dream on 11/10/2017.
 */
public class Solution {
    public int myAtoi(String str) {
        if (null == str || "".equals(str))
            return 0;
        int len = str.length();
        int result = 0;
        int start = 0;
        char sign = '+';
        while (' ' == str.charAt(start)) {
           start++;
        }

        for (int i = start; i < len; i++) {
            char c = str.charAt(i);
            if (start == i && '-' == c) {
                sign = '-';
                continue;
            } else if (start == i && '+' == c) {
                continue;
            }

            if (Character.isDigit(c)) {
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && c - '0' > 7)) {
                    if ('-' == sign)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }

                result = 10 * result + Integer.valueOf(c-'0');
            } else {
                break;
            }
        }
        if ('-' == sign) {
            result = 0-result;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "123  456";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(str));
        System.out.println(Integer.MAX_VALUE);
    }
}

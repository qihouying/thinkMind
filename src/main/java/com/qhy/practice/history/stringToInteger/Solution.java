package com.qhy.practice.history.stringToInteger;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 27, 2018 17:57
 */
public class Solution {
    public static int myAtoi(String str) throws Exception {
        int sign = 1;
        long sum = 0;
        int start = 0;
        if (null == str || 0 == str.length())
            throw new Exception("string is null");

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && !"-".equals(str.charAt(start)) && !"+".equals(str.charAt(start))) {
                start++;
            }
        }
        if ("-".equals(str.charAt(start))) {
            sign = -1;
            start++;
        } else if ("+".equals(str.charAt(start))) {
            start++;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)(sign*sum);
            }
            sum = 10*sum + Integer.valueOf(str.charAt(i)-48);
            if (1 == sign && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (-1 == sign && sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)(sign*sum);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(Solution.myAtoi("   -42"));
    }
}

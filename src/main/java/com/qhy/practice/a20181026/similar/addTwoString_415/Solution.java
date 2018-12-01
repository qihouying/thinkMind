package com.qhy.practice.a20181026.similar.addTwoString_415;

/**
 * Created by dream on 2018/10/27.
 *
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2 .
    Note:
         1. The length of both num1 and num2 is
         2. Both num1 and num2 contains only digits 0-9 .
         3. Both num1 and num2 does not contain any leading zero.
         4. You must not use any built-in BigInteger library or convert the inputs
         to integer directly.
 */
public class Solution {
    public String addTwoStrings(String num1, String num2) {
        if (null == num1 || null == num2 || num1.isEmpty() || num2.isEmpty())
            return "";
        int i = num1.length()-1, j = num2.length()-1, sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += num1.charAt(i--)-'0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--)-'0';
            }
            result.append(sum%10);
            sum /= 10;
        }
        if (sum > 0) {
            result.append(sum);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addTwoStrings("122", "879"));
    }
}

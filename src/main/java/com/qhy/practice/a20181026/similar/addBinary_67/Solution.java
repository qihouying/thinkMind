package com.qhy.practice.a20181026.similar.addBinary_67;

/**
 * Created by dream on 2018/10/27.
 *
 * Given two binary strings, return their sum (also a binary string).
     For example, a = "11"
     b = "1" Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int i = a.length()-1, j = b.length()-1;
        while (i >= 0 || j >= 0) {
            if (i >=0) {
                sum += a.charAt(i--)-'0';
            }
            if (j >= 0) {
                sum += b.charAt(j--)-'0';
            }
            result.append(sum%2);
            sum = sum/2;
        }
        if (sum != 0) {
            result.append(sum);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}

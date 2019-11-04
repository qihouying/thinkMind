package com.qhy.practice_01.palindromeNumber;

/**
 * Created by dream on 11/10/2017.
 * 不符合要求，占用了额外的空间
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        if (0 > x)
            return false;
        int i = 0, j = str.length()-1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = -15;
        System.out.println(Solution.isPalindrome(n));
    }
}

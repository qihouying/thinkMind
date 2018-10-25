package com.qhy.practice.history.dp.PalindromeNumber;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   09 27, 2018 17:00
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = x;
        int reverted = 0;
        while (y > reverted) {
            reverted = reverted * 10 + reverted % 10;
            y = reverted / 10;
        }

        if (y == reverted || reverted /10 == y)
            return  true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(1221));
    }
}

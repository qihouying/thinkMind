package com.qhy.practice_01.palindromeNumber;

/**
 * Created by dream on 11/10/2017.
 * 右半部分逆转
 */
public class BestSolution {
    public static boolean isPalindrome(int x) {
        int rightReverse = 0;
        if (x < 0 || (0 != x && 0 == x % 10))
            return false;
        while (x > rightReverse) {
            rightReverse = rightReverse*10 + x % 10;
            x = x / 10;
        }
        if (x == rightReverse || x == rightReverse/10)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(BestSolution.isPalindrome(n));
    }
}

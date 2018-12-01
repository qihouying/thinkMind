package com.qhy.practice.a20181026.similar.plusOne_66;

/**
 * Created by dream on 2018/10/28.
 *
 *   Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

     The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

     You may assume the integer does not contain any leading zero, except the number 0 itself.

     Example 1:

         Input: [1,2,3]
         Output: [1,2,4]
         Explanation: The array represents the integer 123.

     Example 2:

         Input: [4,3,2,1]
         Output: [4,3,2,2]
         Explanation: The array represents the integer 4321.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (null == digits || 0 == digits.length)
            return new int[0];
        int len = digits.length;
        for (int i = len-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[len+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] input = {};
        Solution solution = new Solution();
        int[] result = solution.plusOne(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

package com.qhy.practice.a20181026.similar.multiplyStrings_43;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2018/10/28.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

     Example 1:

         Input: num1 = "2", num2 = "3"
         Output: "6"

     Example 2:

         Input: num1 = "123", num2 = "456"
         Output: "56088"
     Note:

         The length of both num1 and num2 is < 110.
         Both num1 and num2 contain only digits 0-9.
         Both num1 and num2 do not contain any leading zero, except the number 0 itself.
         You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution{
    public String multiplyString(String a, String b) {
        if (null == a || null == b || a.isEmpty() || b.isEmpty())
            return "";
        List<String> multiplyResult = new ArrayList();
        StringBuilder result = new StringBuilder();
        for (int i = b.length()-1; i >= 0; i--) {
            StringBuilder multiply = new StringBuilder();
            int first = b.charAt(i)-'0';
            int carry = 0;
            for (int j = a.length()-1; j >= 0; j--) {
                int second = a.charAt(j)-'0';
                int temp = first * second + carry;
                multiply.insert(0, temp%10);
                carry = temp / 10;
            }
            if (carry > 0) {
                multiply.insert(0, carry);
            }
            multiplyResult.add(multiply.toString());
        }
        for (int i = 0; i < multiplyResult.get(0).length(); i++) {
            result.append(multiplyResult.get(0).charAt(i));
        }
        System.out.println(multiplyResult);
        for (int i = 1; i < multiplyResult.size(); i++) {
            String secondString =  multiplyResult.get(i);
            StringBuilder temp = new StringBuilder();
            for (int j = result.length()-1; j > result.length()-i-1; j--) {
                temp.append(result.charAt(j) - '0');
            }
            int second = secondString.length()-1, first = result.length()-i-1, sum = 0;

            while (first >= 0 || second >= 0) {
                if (first >= 0) {
                    sum += result.charAt(first--)-'0';
                }
                if (second >= 0) {
                    sum += secondString.charAt(second--)-'0';
                }
                temp.insert(0, sum%10);
                sum /= 10;
            }
            if (sum > 0) {
                temp.insert(0, sum);
            }
            result = temp;
            System.out.println(result);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiplyString("123", "456"));
    }
}

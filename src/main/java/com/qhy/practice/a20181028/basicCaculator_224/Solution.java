package com.qhy.practice.a20181028.basicCaculator_224;

import java.util.Stack;

/**
 * Created by dream on 2018/10/30.
 *
 Implement a basic calculator to evaluate a simple expression string.
 The expression string may contain open ( and closing parentheses ), the plus + or
 minus sign -, non-negative integers and empty spaces .
 You may assume that the given expression is always valid.
 Some examples:
     "1 + 1" = 2
     " 2-1 + 2 " = 3
     "(1+(4+5+2)-3)+(6+8)" = 23

 amazing!!!!
 */
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10*number + (int)(c-'0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) {
            result += sign * result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("12+(2+3)"));
    }
}

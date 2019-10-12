package com.qhy.insist.ten;

import java.util.Collections;
import java.util.Stack;

/**
 * @Author houyingqi
 * @Date 2019-10-06 19:15
 * @Description [Hard] Topics: [Math] [Stack]
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 **/
public class BasicCalculator_224 {
    public int calculate(String s) {
        if (null == s || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, num = 0, sign =1, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10*num + c - '0';
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.peek(); stack.pop();
                res += stack.peek(); stack.pop();
            }
            System.out.println("res="+res+", num=" +num + ", sign=");
        }
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "(1+(4+5+2)-3)+(6+8)";
        String s2 = " 2-1 + 2 ";
        String s3 = "1 + 1";
        BasicCalculator_224 basicCalculator = new BasicCalculator_224();
        System.out.println(basicCalculator.calculate(s1));
        /*System.out.println(basicCalculator.calculate(s2));
        System.out.println(basicCalculator.calculate(s3));*/





    }
}

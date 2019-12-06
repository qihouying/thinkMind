package com.qhy.insist.stack;

import java.util.Stack;

/**
 * @Author houyingqi
 * @Date 2019-10-06 00:13
 * @Description [Medium] Topics: [String]
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, + , - , * , / operators and
 * empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 **/
public class BasicCalculatorII_227 {
    public int calculate(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int res = 0;
        int num = 0;
        int op = '+';
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '/'){
                    int tmp = stack.peek()/num;
                    stack.pop();
                    stack.push(tmp);
                } else if (op == '*') {
                    int tmp = stack.peek()*num;
                    stack.pop();
                    stack.push(tmp);
                }
                op = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

    //Method2: No stack
    public int calculate1(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int res = 0, curRes = 0, num = 0, n = s.length();
        int op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10*num + c -'0';
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == n-1) {
                switch(op) {
                    case '+': curRes += num; break;
                    case '-': curRes -= num; break;
                    case '*': curRes *= num; break;
                    case '/': curRes /= num; break;
                }
                if (c == '+' || c == '-' || i == n-1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String str = "3+2*2";
        String str1 = " 3/2 ";
        BasicCalculatorII_227 basicCalculatorII = new BasicCalculatorII_227();
        System.out.println(basicCalculatorII.calculate(str));
        System.out.println(basicCalculatorII.calculate(str1));
        System.out.println(basicCalculatorII.calculate1(str));
        System.out.println(basicCalculatorII.calculate1(str1));
    }
}

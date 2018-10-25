package com.qhy.practice.history.array.h.h20181022;

import java.util.List;
import java.util.Stack;

/**
 * Desc:
 *
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].
 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.
 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.

 * author: qihouying@meituan.com
 * Date:   10 22, 2018 17:17
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (null == s || s.isEmpty())
            return null;
        if ('[' != s.charAt(0)) {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger curr = null;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if ('[' == s.charAt(r)) {
                if (null != curr) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r+1;
            } else if (']' == s.charAt(r)) {
                String num = s.substring(l, r);
                if (null != num && !num.isEmpty()) {
                    stack.push(new NestedInteger(Integer.valueOf(num)));
                }
                if (null != stack && !stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            } else if (',' == s.charAt(r)) {
                if (']' != s.charAt(r-1)) {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
        MiniParser miniParser = new MiniParser();
        NestedInteger nestedInteger = miniParser.deserialize(s);
        while (null != nestedInteger) {
            System.out.println(nestedInteger.value);
            nestedInteger = nestedInteger.nestedInteger;
        }

    }
}

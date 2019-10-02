package com.qhy.insist.four;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author houyingqi
 * @Date 2019-10-01 12:20
 * @Description [Medium] Topics: [String] [Backtracking] [Greedy]
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 *
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 *
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes,
 * except if the piece is the number 0 itself.
 *
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 *
 * Example 1:
 *
 * Input: "123456579"
 * Output: [123,456,579]
 *
 * Example 2:
 *
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 *
 * Example 3:
 *
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 *
 * Example 4:
 *
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 *
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 *
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 **/
public class SplitArrayIntoFibonacciSequence_842 {

    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        int n = num.length();
        for (int i = 1; i <= (n-1)/2; i++) {
            if (num.charAt(0) == '0' && i > 1)
                return res;
            BigInteger x1 = new BigInteger(num.substring(0,i));
            if (x1.longValue() > Integer.MAX_VALUE)
                break;
            for (int j = i+1; j-i <= n-j && i <= n-j; j++) {
                if (num.charAt(i) == '0' && j-i > 1)
                    break;
                BigInteger x2 = new BigInteger(num.substring(i, j));
                if (x2.longValue() > Integer.MAX_VALUE)
                    break;
                List<Integer> remainList = new ArrayList<>();
                boolean isValid = splitIntoFibonacci(num.substring(j), x1, x2, remainList);
                if (!isValid)
                    continue;
                res.addAll(remainList);
                return res;
            }
        }
        return res;

    }
    public boolean splitIntoFibonacci(String num, BigInteger x1, BigInteger x2, List<Integer> remain) {
        if ("".equals(num)) {
            remain.add(Integer.parseInt(x1.toString()));
            remain.add(Integer.parseInt(x2.toString()));
            return true;
        }
        BigInteger temp = x1;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String str = x2.toString();
        if (!num.startsWith(str))
            return false;
        remain.add(Integer.parseInt(temp.toString()));
        return splitIntoFibonacci(num.substring(str.length()), x1, x2, remain);
    }


    //LeetCode提交代码不允许使用BigInteger
    public List<Integer> splitIntoFibonacci2(String num) {
        List<Integer> res = new ArrayList<>();
        int n = num.length();
        for (int i = 1; i <= (n-1)/2; i++) {
            if (num.charAt(0) == '0' && i > 1)
                return res;
            long x1 = Long.valueOf(num.substring(0,i));
            if (x1 > Integer.MAX_VALUE)
                break;
            for (int j = i+1; j-i <= n-j && i <= n-j; j++) {
                if (num.charAt(i) == '0' && j-i > 1)
                    break;
                long x2 = Long.valueOf(num.substring(i,j));
                if (x2 > Integer.MAX_VALUE)
                    break;
                List<Integer> remainList = new ArrayList<>();
                boolean isValid = splitIntoFib2(num.substring(j), x1, x2, remainList);
                if (!isValid)
                    continue;
                res.addAll(remainList);
                return res;
            }
        }
        return res;

    }
    public boolean splitIntoFib2(String num, long x1, long x2, List<Integer> remain) {
        if ("".equals(num)) {
            remain.add(Integer.parseInt(String.valueOf(x1)));
            remain.add(Integer.parseInt(String.valueOf(x2)));
            return true;
        }
        long sum = x1+x2;
        String str = ((Long)sum).toString();
        if (!num.startsWith(str))
            return false;
        if (sum > Integer.MAX_VALUE)
            return false;
        remain.add(Integer.parseInt(String.valueOf(x1)));
        return splitIntoFib2(num.substring(str.length()), x2, sum, remain);
    }

    //Method2:
    public List<Integer> splitIntoFibonacci1(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        for (int i=idx; i<s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }
            long num = Long.parseLong(s.substring(idx, i+1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            // early termination
            if (size >= 2 && num > ans.get(size-1)+ans.get(size-2)) {
                break;
            }
            if (size <= 1 || num == ans.get(size-1)+ans.get(size-2)) {
                ans.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, ans, i+1)) {
                    return true;
                }
                ans.remove(ans.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String num =  "11235813";
        String num1 = "1101111";
        String num2 ="123456579";
        String num3 ="1011";
        String num4 = "74912134825162255812723932620170946950766784234934";
        SplitArrayIntoFibonacciSequence_842 splitArrayIntoFibonacciSequence = new SplitArrayIntoFibonacciSequence_842();
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci(num));
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci(num1));
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci(num2));
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci(num3));
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci(num4));
        System.out.println(splitArrayIntoFibonacciSequence.splitIntoFibonacci1(num));
    }
}

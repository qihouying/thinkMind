package com.qhy.insist.math;

/**
 * @Author houyingqi
 * @Date 2019-10-02 13:08
 * @Description [Easy] Topics: [Math]
 *
 * Given a non-negative integer num , repeatedly add all its digits until the result has only
 * one digit.
 * For example:
 * Given num = 38 , the process is like: 3 + 8 = 11 , 1 + 1 = 2 . Since 2 has only one
 * digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 **/
//比较巧妙：巧用数学奇妙公式
public class AddDigits_258 {

    /**
     *
     * The problem, widely known as digit root problem, has a congruence formula:
     * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
     *
     * For base b (decimal case b = 10), the digit root of an integer is:
     * dr(n) = 0 if n == 0
     * dr(n) = (b-1) if n != 0 and n % (b-1) == 0
     * dr(n) = n mod (b-1) if n % (b-1) != 0
     * or
     * dr(n) = 1 + (n - 1) % 9
     *
     * For example：
     * If an integer is like 100a+10b+c, then (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9
     *
     */
    public int addDigit(int num) {
        return (1+ (num-1)%9);
    }

    public static void main(String[] args) {
        AddDigits_258 addDigits = new AddDigits_258();
        System.out.println(addDigits.addDigit(38));
    }
}

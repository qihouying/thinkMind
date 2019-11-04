package com.qhy.practice_01.stringToInteger;

/**
 * Created by dream on 11/10/2017.
 */
public class AnotherSolution {
    public static int myAtoi(String str) {
        //空串
        if (null == str || "".equals(str))
            return 0;
        int sign = 1, base = 0, i = 0;
        //开头是空格的情况
        while (str.charAt(i) == ' ')
            i++;
        System.out.println("i="+i);
        //符号
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        //溢出情况
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

    public static void main(String[] args) {
        String str = "123  456";
        System.out.println(AnotherSolution.myAtoi(str));
    }
}

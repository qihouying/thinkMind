package com.qhy.practice_01.reverseInteger;


/**
 * Created by dream on 11/10/2017.
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int temp = x;
        while(0 != temp) {
            int remainder = temp % 10;
            int quotient = temp / 10;
            System.out.println("remainder="+remainder+",quoatient="+quotient);

            int newResult = 10 * result + remainder;

            //判断是否溢出
            if ((newResult - remainder) / 10 != result)
                return 0;

            temp = quotient;
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = -234;
        Solution solution = new Solution();
        System.out.println(solution.reverse(n));
    }
}

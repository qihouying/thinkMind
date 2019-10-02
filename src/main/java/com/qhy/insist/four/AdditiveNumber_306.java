package com.qhy.insist.four;

import java.math.BigInteger;

/**
 * @Author houyingqi
 * @Date 2019-09-30 19:24
 * @Description [Medium] Topics: [Backtracking]
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first
 * two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1,
 * 1, 2, 3, 5, 8 .
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199 .
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1,
 * 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9' , write a function to determine if it's an
 * additive number.
 *
 * Follow up:
 * How would you handle overflow for very large input integers?
 **/

//解法比较独特，需要再次推敲
public class AdditiveNumber_306 {

    //Method1:
    public boolean isAdditiveNumber1(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid1(i, j, num)) return true;
        return false;
    }
    private boolean isValid1(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
    //to handle overflow
    private boolean isValid1_1(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }

    //Method2:

    /**
     * The idea is quite straightforward:
     * 1. Choose the first number A , it can be the leftmost 1 up to i digits. i<=(L-1)/2 because the third number
     * should be at least as long as the first number
     * 2. Choose the second number B , it can be the leftmost 1 up to j digits excluding the first number. the limit
     * for j is a little bit tricky, because we don't know whether A or B is longer. The remaining string (with length L-j ) after
     * excluding A and B should have a length of at least max(length A , length B ),where length A = i and length B = j-i ,
     * thus L-j >= max(j-i, i)
     * 3. Calls the recursive checker function and returns true if passes the checker function, or continue to the next
     * choice of B ( A ) until there is no more choice for B or A , in which case returns a false
     *
     */
    public boolean isAdditiveNumber2(String num) {
        int len = num.length();
        // choose the first number A
        for (int i = 1; i <= (len-1)/2; i++) {
            // A cannot start with a 0 if its length is more than 1
            if (num.charAt(0) == '0' && i > 1)
                break;//previous code: continue;
            for (int j = i+1; j-i <= len - j && i <= len -j; j++) {
                // B cannot start with a 0 if its length is more than 1
                if (num.charAt(i) == '0' && j-i > 1)
                    break;// previous: continue;
                long num1 = Long.parseLong(num.substring(0,i));
                long num2 = Long.parseLong(num.substring(i, j));

                if (isValid2(num.substring(j), num1, num2))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid2(String num, long num1, long num2) {
        if ("".equals(num))
            return true;
        //此处可能会溢出,为避免overflow，同样采用 BigInteger的方式
        long sum = num1 + num2;
        String str = ((Long)sum).toString();
        // if string does not start with sum of num1 and num2, returns false
        if (!num.startsWith(str))
            return false;
        // recursively checks the remaining string
        return isValid2(num.substring(str.length()), num2, sum);
    }

    public static void main(String[] args) {
        String num = "120122436";
        AdditiveNumber_306 additiveNumber = new AdditiveNumber_306();
        System.out.println(additiveNumber.isAdditiveNumber1(num));
        System.out.println(additiveNumber.isAdditiveNumber2(num));

    }

}

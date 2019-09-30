package com.qhy.insist.Third;

/**
 * @Author houyingqi
 * @Date 2019-09-25 16:23
 * @Description [Easy]
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 **/
public class AddBinary_67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += b.charAt(i--) - '0';
            if (j >= 0) sum += a.charAt(j--) - '0';
            sb.append(sum & 1); // sum % 2
            carry = (sum >> 1) & 1; // carry = sum / 2
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        AddBinary_67 addBinary = new AddBinary_67();
        System.out.println(addBinary.addBinary(a, b));
    }
}

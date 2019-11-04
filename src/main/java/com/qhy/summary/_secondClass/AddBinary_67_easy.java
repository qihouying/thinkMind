package com.qhy.summary._secondClass;

/**
 * Created by dream on 2019/3/9.
 *
 * Given two binary strings, return their sum (also a binary string).
 For example, a = "11"
 b = "1" Return "100".
 Companies
    Facebook
 Topics
    Math String

 */
public class AddBinary_67_easy {
    public String addBinay(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        int i = ac.length-1, j = bc.length-1;
        while (i >= 0 || j >= 0 || carry == 1) {
            carry += i >= 0 ? ac[i--] - '0' : 0;
            carry += j >= 0 ? bc[j--] - '0' : 0;

            sum.append((char)(carry % 2 + '0'));
            carry /= 2;
        }
        return sum.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67_easy addBinary_67_easy = new AddBinary_67_easy();
        System.out.println(addBinary_67_easy.addBinay("11", "1"));
    }
}

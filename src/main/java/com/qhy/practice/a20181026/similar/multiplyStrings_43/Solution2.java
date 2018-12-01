package com.qhy.practice.a20181026.similar.multiplyStrings_43;

/**
 * Created by dream on 2018/10/28.
 *
 * amazing!!!!
 */
public class Solution2 {
    public String multiply(String a, String b) {
        if (null == a || null == b || a.isEmpty() || b.isEmpty())
            return "";
        StringBuilder result = new StringBuilder();
        int[] product = new int[a.length()+b.length()];
        for (int i = a.length()-1; i >= 0; i--) {
            for (int j = b.length()-1; j >= 0; j--) {
                int pos1 = i + j, pos2 = pos1+1;
                int multiply = (a.charAt(i)-'0') * (b.charAt(j)-'0');
                int sum = multiply + product[pos2];
                product[pos1] += sum / 10;
                product[pos2] = sum % 10;
            }
        }
        for (int proc : product) {
            if (!(result.length() == 0 && proc == 0)) {
                result.append(proc);
            }
        }
        return result.length() == 0? "0":result.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.multiply("123", "456"));
    }
}

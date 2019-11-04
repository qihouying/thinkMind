package com.qhy.FLag;

/**
 * Created by dream on 2019/3/17.
 */
public class Permutation {
    public boolean permutation(String s, String t) {
        if (null == s && null == t) {
            return true;
        } else if ((null == s && null != t) || (null != s && null == t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] temp = s.toCharArray();
        int[] letters = new int[256];

        for (int i = 0; i < temp.length; i++) {
            letters[temp[i]]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permutation("abcdeff", "abffdec"));
    }
}

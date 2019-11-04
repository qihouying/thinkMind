package com.qhy.FLag;

/**
 * Created by dream on 2019/3/17.
 */
public class Compress {
    public String compress(String s) {
        if (null == s) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            sb.append(s.charAt(i));
            int j = i+1;
            while (j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            sb.append(j-i);
            i = j;
        }
        return (s.length() > sb.toString().length()) ? sb.toString() : s.toString();
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        System.out.println(compress.compress("aabcccccaaa"));
    }
}

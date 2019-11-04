package com.qhy.FLag;

/**
 * Created by dream on 2019/3/17.
 */
public class Replace {
    public void replace(char[] s, int len) {
        if (null == s) {
            return;
        }
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                spaceCount++;
            }
        }
        int newLen = len + 2*spaceCount;
        System.out.println(newLen);

        s[--newLen] = '\0';
        for (int i = len-1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[newLen--] = '0';
                s[newLen--] = '2';
                s[newLen--] = '%';
            } else {
                s[newLen--] = s[i];
            }
        }
    }

    public static void main(String[] args) {
        char[] s = "Mr John Smith\0    ".toCharArray();
        System.out.println(s.length);
        Replace replace = new Replace();
        replace.replace(s,14);
        System.out.println(s.toString());
    }
}

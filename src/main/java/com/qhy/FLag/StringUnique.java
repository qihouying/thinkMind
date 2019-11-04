package com.qhy.FLag;

/**
 * Created by dream on 2019/3/13.
 */
public class StringUnique {
    public boolean isUniqueChar(String str) {
        if (null == str || "" == str) {
            return true;
        }
        if (str.length() > 256) {
            return false;
        }
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i)-'a';
            if ((check & (1 << value)) > 0) {
                return false;
            }
            check |= 1 << value;
            System.out.println("check=" +check + ",value=" + value);
        }
        return true;
    }

    public static void main(String[] args) {
        StringUnique stringUnique = new StringUnique();
        System.out.println(stringUnique.isUniqueChar("abcdefa"));
    }
}

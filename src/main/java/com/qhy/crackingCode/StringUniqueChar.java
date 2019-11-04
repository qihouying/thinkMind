package com.qhy.crackingCode;

/**
 * Created by dream on 2019/5/19.
 */
public class StringUniqueChar {
    public boolean isUniqueChar(String str) {
        if (null == str || "" == str)
            return false;
        if (str.length() > 256)
            return false;
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}

package com.qhy.practice_01.LongestPalindromicSubString;

/**
 * Created by dream on 2017/10/7.
 */
public class BestSolution {
    public String longestPalindromicSubString(String s) {
        if(isEmpty(s))
            return null;
        String str = preProcess(s);
        System.out.println(str);

        char[] chars = str.toCharArray();
        int len = chars.length;
        int center = 0, right = 0;
        int[] p = new int[len];
        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 1; i < len-1; i++) {
            int i_mirror = 2*center-i;
            p[i] = (right > i) ? Math.min(right-i, p[i_mirror]) : 0;

            while (i-1-p[i] > -1 && i+1+p[i] < len && chars[i+1+p[i]] == chars[i-1-p[i]]) {
                p[i]++;
            }

            if (i+p[i] > right) {
                center = i;
                right = i+p[i];
            }

            //求出p[i]最大值对应的下标
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        /**
         * 2*validMaxLen+1 = maxLen
         * 2*validCenterIndex+1 = centerIndex
         * int startIndex = validCenterIndex-validMaxLen=(centerIndex-maxLen)/2;
         * int endIndex = startIndex+2*validMaxLen+1=(maxLen+centerIndex-1)/2;
         */
        int startIndex = (centerIndex-maxLen)/2;
        int endIndex = (centerIndex+maxLen)/2;

        return s.substring(startIndex, endIndex);

    }

    public String preProcess(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder result = new StringBuilder();
        result.append("#");
        for (int i = 0; i < len; i++) {
            result.append(c[i]).append("#");
        }
        return result.toString();
    }

    public boolean isEmpty(String s) {
        if(null == s || "" == s)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "babcbabcbaccba";
        BestSolution bestSolution = new BestSolution();
        System.out.println(bestSolution.longestPalindromicSubString(s));
    }
}

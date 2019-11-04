package com.qhy.practice_01.PalindromePairs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dream on 2018/10/18.
 */
public class PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> palindromeIndex = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ("".equals(words[i]) && isPalindrome(words[j])) {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    palindromeIndex.add(index);
                    index = new ArrayList<>();
                    index.add(j);
                    index.add(i);
                    palindromeIndex.add(index);
                    continue;
                } else if ("".equals(words[j]) && isPalindrome(words[i])) {
                    List<Integer> index = new ArrayList<>();
                    index.add(j);
                    index.add(i);
                    palindromeIndex.add(index);
                    index = new ArrayList<>();
                    index.add(i);
                    index.add(j);
                    palindromeIndex.add(index);
                    continue;
                }

                String pairWords = new StringBuilder(words[i]).append(words[j]).toString();
                if (isPalindrome(pairWords)) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(i);
                    indexList.add(j);
                    palindromeIndex.add(indexList);
                }
                String pairWords1 = new StringBuilder(words[j]).append(words[i]).toString();
                if (isPalindrome(pairWords1)) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(j);
                    indexList.add(i);
                    palindromeIndex.add(indexList);
                }
            }
        }
        return palindromeIndex;
    }
    public static boolean isPalindrome(String str) {
        if (0 == str.length())
            return false;
        int s = 0, e = str.length()-1;
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                break;
            }
        }
        if (s >= e) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] str = {"a","b","c","ab","ac","aa"};
        System.out.println(PalindromePairs.palindromePairs(str));
    }
}

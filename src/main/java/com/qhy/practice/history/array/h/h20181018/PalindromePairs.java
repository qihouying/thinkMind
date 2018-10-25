package com.qhy.practice.history.array.h.h20181018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 18, 2018 14:40
 */
public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> palindromeIndex = new ArrayList<>();
        Map<String, Integer> wordIndex = new HashMap<String, Integer>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            wordIndex.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < len; i++) {
            String word = words[i];
            if ("".equals(word)) {
                for (Map.Entry<String, Integer> entry : wordIndex.entrySet()) {
                    if (isPalindrome(entry.getKey())) {
                        List<Integer> indexList = new ArrayList<>();
                        indexList.add(i);
                        indexList.add(entry.getValue());
                        palindromeIndex.add(indexList);
                    }
                }
            }
            for (int j = 0; j < word.length(); j++) {
                String leftWord = word.substring(0, j);
                String rightWord = word.substring(j, word.length());
                if (("".equals(leftWord) || isPalindrome(leftWord)) && wordIndex.containsKey(rightWord) && wordIndex.get(rightWord) != i) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(wordIndex.get(rightWord));
                    indexList.add(i);
                    palindromeIndex.add(indexList);
                }
                if (("".equals(rightWord) || isPalindrome(rightWord)) && wordIndex.containsKey(leftWord) && wordIndex.get(leftWord) != i) {
                    List<Integer> indexList = new ArrayList<>();
                    indexList.add(i);
                    indexList.add(wordIndex.get(leftWord));
                    palindromeIndex.add(indexList);
                }
            }
        }
        return palindromeIndex;
    }

    public static boolean isPalindrome(String str) {
        if (null == str || "".equals(str))
            return false;
        int s = 0, e = str.length()-1;
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"aba",""};
        System.out.println(PalindromePairs.palindromePairs(words));

    }
}

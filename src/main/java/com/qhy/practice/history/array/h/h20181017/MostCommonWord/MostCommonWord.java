package com.qhy.practice.history.array.h.h20181017.MostCommonWord;

import java.util.*;

/**
 * Desc:
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 Example:

     Input:
         paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
         banned = ["hit"]
     Output: "ball"
     Explanation:
         "hit" occurs 3 times, but it is a banned word.
         "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
         Note that words in the paragraph are not case sensitive,
         that punctuation is ignored (even if adjacent to words, such as "ball,"),
         and that "hit" isn't the answer even though it occurs more because it is banned.


 Note:

     1 <= paragraph.length <= 1000.
     1 <= banned.length <= 100.
     1 <= banned[i].length <= 10.
     The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     There are no hyphens or hyphenated words.
     Words only consist of letters, never apostrophes or other punctuation symbols.

 * author: qihouying@meituan.com
 * Date:   10 17, 2018 17:34
 */
public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        int max = 0;
        String[] words = paragraph.toLowerCase().split("([.,!?:;'\"-]|\\s)+");
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> frequency = new HashMap<String, Integer>();
        for (String str : banned) {
            bannedSet.add(str.toLowerCase());
        }
        for (String str : words) {
            System.out.println(str);
            if (str.contains(",") || str.contains(".")  || str.contains("!")  || str.contains("?")  || str.contains("''") || str.contains(";")) {
                str = str.substring(0, str.length()-1);
            }
            if (!bannedSet.isEmpty() && bannedSet.contains(str)) {
                continue;
            } else {
                if (frequency.containsKey(str)) {
                    frequency.put(str, frequency.get(str) + 1);
                } else {
                    frequency.put(str, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] banned = {"a"};
        System.out.println(MostCommonWord.mostCommonWord("a, a, a, a, b,b,b,c, c", banned));
    }
}

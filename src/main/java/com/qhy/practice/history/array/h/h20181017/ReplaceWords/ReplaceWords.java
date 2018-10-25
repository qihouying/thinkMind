package com.qhy.practice.history.array.h.h20181017.ReplaceWords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Desc:
 *
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

 Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

 You need to output the sentence after the replacement.

 Example 1:
     Input: dict = ["cat", "bat", "rat"]
     sentence = "the cattle was rattled by the battery"
     Output: "the cat was rat by the bat"
 Note:
     The input will only have lower-case letters.
     1 <= dict words number <= 1000
     1 <= sentence words number <= 1000
     1 <= root length <= 100
     1 <= sentence words length <= 1000
 *
 * author: qihouying@meituan.com
 * Date:   10 17, 2018 15:41
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root: dict) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] str = {"abc", "efg"};
        String[] str1 = str;
        String[] str2 = {"xyz"};
        str = str2;
        System.out.println(str1[0]);
    }
}

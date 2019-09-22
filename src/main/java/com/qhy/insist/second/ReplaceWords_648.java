package com.qhy.insist.second;

import java.util.Arrays;
import java.util.List;

/**
 * @Author houyingqi
 * @Date 2019-09-22 14:23
 * @Description   [medium]
 *
 * In English, we have a concept called root, which can be followed by some other words to form another longer word
 * - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence
 * with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 **/
public class ReplaceWords_648 {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildDic(dict);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String rattled = shortestWord(word, root);
            sb.append(rattled).append(" ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    public TrieNode buildDic(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (null == node.children[c-'a']) {
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isLeaf = true;
        }
        return root;
    }

    public String shortestWord(String word, TrieNode root) {
        StringBuilder result = new StringBuilder();
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (null != node.children[c-'a']) {
                node = node.children[c-'a'];
                result.append(c);
            } else if (node.isLeaf) {
                return result.toString();
            }
        }
        return word;
    }

    public static void main(String[] args) {
        ReplaceWords_648 replaceWords = new ReplaceWords_648();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords.replaceWords(dict, sentence));
    }
}

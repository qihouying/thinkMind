package com.qhy.practice.a20181026.dataStructureDesign.addAndSearchWod_211;

/**
 * Created by dream on 2018/10/26.
 *
 * Design a data structure that supports the following two operations:
 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 For example:
     addWord("bad")
     addWord("dad")
     addWord("mad")
     search("pad") -> false
     search("bad") -> true
     search(".ad") -> true
     search("b..") -> true
 Note:
    You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int k, TrieNode trieNode) {
        if (k == chars.length)
            return !trieNode.item.equals("");
        if (chars[k] != '.') {
            return trieNode.children[chars[k]-'a'] != null && match(chars, k+1, trieNode.children[chars[k]-'a']);
        } else {
            for (int i = 0; i < trieNode.children.length; i++) {
                if (trieNode.children[i] != null) {
                    if (match(chars, k+1, trieNode.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

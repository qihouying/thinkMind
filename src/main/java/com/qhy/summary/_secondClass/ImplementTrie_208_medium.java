package com.qhy.summary._secondClass;

/**
 * Created by dream on 2019/3/3.
 *
 *Implement a trie with insert, search, and startsWith methods. Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 Companies
    Google Facebook Microsoft Bloomberg Uber Twitter
 Topics
    Design Trie
 */
public class ImplementTrie_208_medium {
    private TrieNode root;
    public ImplementTrie_208_medium() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode words = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (words.children[c-'a'] == null) {
                words.children[c-'a'] = new TrieNode(c);
            }
            words = words.children[c-'a'];
        }
        words.isWord = true;
    }

    public boolean search(String word) {
        TrieNode words = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (words.children[c-'a'] == null) {
                return false;
            }
            words = words.children[c-'a'];
        }
        return words.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode words = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (words.children[c-'a'] == null) {
                return false;
            }
            words = words.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie_208_medium implementTrie_208_medium = new ImplementTrie_208_medium();
        implementTrie_208_medium.insert("apple");
        System.out.println(implementTrie_208_medium.search("apple"));
        System.out.println(implementTrie_208_medium.search("app"));
        System.out.println(implementTrie_208_medium.startsWith("app"));
        implementTrie_208_medium.insert("app");
        System.out.println(implementTrie_208_medium.search("app"));
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c) {
        this.val = c;
    }
}

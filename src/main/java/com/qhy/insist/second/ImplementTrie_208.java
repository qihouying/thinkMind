package com.qhy.insist.second;

/**
 * @Author houyingqi
 * @Date 2019-09-22 12:03
 * @Description  [medium]
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 **/
public class ImplementTrie_208 {
    private TrieNode root = new TrieNode();
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (null == node.children[c-'a']) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (null == node.children[c-'a'])
                return false;
            node = node.children[c-'a'];
        }
        return node.isLeaf;
    }

    public boolean startWith(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (null == node.children[c-'a'])
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie_208 trie = new ImplementTrie_208();
        trie.insert("word");
        System.out.println(trie.search("beach"));
        System.out.println(trie.search("word"));
        System.out.println(trie.startWith("wo"));
        System.out.println(trie.startWith("ba"));
    }

}

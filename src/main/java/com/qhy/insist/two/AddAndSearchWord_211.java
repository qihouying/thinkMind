package com.qhy.insist.two;

/**
 * @Author houyingqi
 * @Date 2019-09-21 15:58
 * @Description  [medium]  Topics: [Backtracking] [Design] [Trie]
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
 * means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 **/
public class AddAndSearchWord_211 {
    private TrieNode root = new TrieNode();

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isLeaf;
    }


    public void addWord(String word) {
        if (null == word || 0 == word.length())
            return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == node.children[c-'a']) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }


    public boolean search(String word) {
        if (null == word || 0 == word.length())
            return false;
        return isMatch(word.toCharArray(), 0, root);

    }

    public boolean isMatch(char[] word, int k, TrieNode node) {
        if (k == word.length)
            return node.isLeaf;
        if (word[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if(null != node.children[i] && isMatch(word, k+1, node.children[i]))
                    return true;
            }
        } else {
            return (null != node.children[word[k]-'a'] && isMatch(word, k+1, node.children[word[k]-'a']));
        }
        return false;
    }


    public static void main(String[] args) {
        AddAndSearchWord_211 wordDictionary = new AddAndSearchWord_211();
        wordDictionary.addWord("word");
        System.out.println(wordDictionary.search("pattern"));
        System.out.println(wordDictionary.search("word"));
        System.out.println(wordDictionary.search("w.rd"));
    }
}

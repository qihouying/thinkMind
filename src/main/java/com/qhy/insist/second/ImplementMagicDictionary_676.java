package com.qhy.insist.second;

import java.util.Arrays;
import java.util.List;

/**
 * @Author houyingqi
 * @Date 2019-09-22 18:40
 * @Description
 *
 * Implement a magic directory with buildDict, and search methods.
 *
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 *
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into
 * another character in this word, the modified word is in the dictionary you just built.
 *
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 **/
public class ImplementMagicDictionary_676 {
    private TrieNode root;

    public ImplementMagicDictionary_676(){
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode node = new TrieNode();
            for (char c : word.toCharArray()) {
                if (null == node.children[c-'a']) {
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isLeaf = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode node = root;
        int time = 0;
        for (char c : word.toCharArray()) {
            if (null == node.children[c-'a'] && time > 1)
                return false;
            else if(null == node.children[c-'a'] && time < 1) {
                time++;
            }
            node = node.children[c-'a'];
        }
        return node.isLeaf && time == 1;
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    public static void main(String[] args) {
        ImplementMagicDictionary_676 magicDict = new ImplementMagicDictionary_676();
        String[] dict = {"cat", "bat", "rat"};
        magicDict.buildDict(dict);
        System.out.println(magicDict.search("gat"));
    }
}

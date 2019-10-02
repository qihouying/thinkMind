package com.qhy.insist.two;

/**
 * @Author houyingqi
 * @Date 2019-09-22 18:40
 * @Description [medium]
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

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }
    //Method1:
    // 利用前缀树，将dic中的单词构建为前缀树，遍历word中的每个字符，除了与自身相等外，从a-z进行替换，
    // 然后，判断替换后的word是否在dic中单词构成的前缀树中
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
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
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    /**
     * replace every character and check if the replaced one is equal to the word of the dict
     * @param word
     * @return
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (char r = 'a'; r <='z'; r++) {
                if (word.charAt(i) == r)
                    continue;
                char temp = chars[i];
                chars[i] = r;
                if (search(root, new String(chars)))
                    return true;
                chars[i] = temp;
            }
        }
        return false;
    }

    public boolean search(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return node.isLeaf;
    }

    //Method2:
    //利用HashMap：构建词典：遍历dict中的每个word，将word中的每个字符去掉后的剩余字符组成的字符串作为key，
    // 将去掉字符在单词中的下标和字符组成的pair对组成的list作为value。search：对要查找的word，依然做如上的处理，
    // 判断去掉某字符后组成的key是否在map中，如果在，再判断去掉字符的下标是否在该key对应的list中，对应的字符是否与value中的相同
    /*class MagicDictionary {

        Map<String, List<int[]>> map = new HashMap<>();
        *//** Initialize your data structure here. *//*
        public MagicDictionary() {
        }

        *//** Build a dictionary through a list of words *//*
        public void buildDict(String[] dict) {
            for (String s : dict) {
                for (int i = 0; i < s.length(); i++) {
                    String key = s.substring(0, i) + s.substring(i + 1);
                    int[] pair = new int[] {i, s.charAt(i)};

                    List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                    val.add(pair);

                    map.put(key, val);
                }
            }
        }

        *//** Returns if there is any word in the trie that equals to the given word after modifying exactly one character *//*
        public boolean search(String word) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(key)) {
                    for (int[] pair : map.get(key)) {
                        if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                    }
                }
            }
            return false;
        }
    }*/

    public static void main(String[] args) {
        ImplementMagicDictionary_676 magicDict = new ImplementMagicDictionary_676();
        String[] dict = {"cat", "bat", "rat"};
        magicDict.buildDict(dict);
        System.out.println(magicDict.search("gat"));
        System.out.println("bert".substring(0,0) + "bert".substring(1));
        System.out.println("bert".substring(0,1) + "bert".substring(2));
        System.out.println("bert".substring(0,2) + "bert".substring(3));
    }
}

package com.qhy.insist.five;

import java.util.*;

/**
 * @Author houyingqi
 * @Date 2019-10-01 23:09
 * @Description [hard] Topics: [Graph] [Topological Sort]
 *
 * There is a new alien language which uses the latin alphabet. However, the order
 * among letters are unknown to you. You receive a list of non-empty words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language . Derive the order of letters in this language.
 * Example 1:
 * Given the following words in dictionary,
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf" .
 * Example 2:
 * Given the following words in dictionary,
 * [
 * "z",
 * "x"
 * ]
 * The correct order is: "zx" .
 * Example 3:
 * Given the following words in dictionary,
 * [
 * "z",
 * "x",
 * "z"
 * ]
 * The order is invalid, so return "" .
 * Note:
 * 1. You may assume all letters are in lowercase.
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given
 * dictionary.
 * 3. If the order is invalid, return an empty string.
 * 4. There may be multiple valid order of letters, return any one of them is fine.
 *
 **/
public class AlienDictionary_269 {

    public String correnctOrderAlienDic(List<String> words) {
        StringBuilder sb = new StringBuilder();
        if (null == words || words.size() == 0)
            return "";
        Map<Character, Integer> charIndex = new HashMap<Character, Integer>();
        int n = words.size();
        int i  = 0;

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                int index = j*(n-1) + i + j;
                Character c = word.charAt(j);
                if (charIndex.containsKey(c)) {
                    if(charIndex.get(c) > index) {
                        charIndex.put(c, index);
                    }
                } else {
                    charIndex.put(c, index);
                }
            }
            i++;
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(charIndex.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> arg0,
                               Map.Entry<Character, Integer> arg1) {
                return arg0.getValue() - arg1.getValue();
            }
        });

        for(Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("wrt", "wrf", "er", "ett", "rftt");
        List<String> words1 = Arrays.asList("z", "x", "z");
        AlienDictionary_269 alienDic = new AlienDictionary_269();
        System.out.println(alienDic.correnctOrderAlienDic(words));
        System.out.println(alienDic.correnctOrderAlienDic(words1));
    }
}

package com.qhy.practice.history.array.h.h20181010.WordLadderII;

import java.util.*;

/**
 * Desc: It is really difficult!!!!!!
 *
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

     Return an empty list if there is no such transformation sequence.
     All words have the same length.
     All words contain only lowercase alphabetic characters.
     You may assume no duplicates in the word list.
     You may assume beginWord and endWord are non-empty and are not the same.

 Example 1:

 Input:
     beginWord = "hit",
     endWord = "cog",
     wordList = ["hot","dot","dog","lot","log","cog"]

 Output:
     [
     ["hit","hot","dot","dog","cog"],
     ["hit","hot","lot","log","cog"]
     ]

 Example 2:

 Input:
     beginWord = "hit"
     endWord = "cog"
     wordList = ["hot","dot","dog","lot","log"]

 Output: []

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 https://leetcode.com/problems/word-ladder-ii/discuss/172308/A-kind-of-concept-with-diagrams-()
 *
 *
 *
 *
 * author: qihouying@meituan.com
 * Date:   10 09, 2018 15:40
 */
public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> path = new ArrayList<String>();
        wordList.add(beginWord);
        wordList.add(endWord);

        //bfs: get adjacency list, meanwhile, it needs a hashMap to record the stepCount of every point
        bfs(beginWord, endWord, wordList, distance, map);

        //dfs: back to front, add the end every time, afterwards, recursively to use the end. note, stepcount needs to minus 1
        dfs(beginWord, endWord, map, distance, path, ladders);
        return ladders;
    }


    //importantly, dfs is from end to start
    public static void dfs(String start, String end, Map<String, List<String>> map,  Map<String, Integer> distance, List<String> path, List<List<String>> ladders) {
        path.add(end);
        if (end.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(end)) {
                if (distance.containsKey(next) && distance.get(end) == distance.get(next) + 1) {
                    dfs(start, next, map, distance, path, ladders);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void bfs(String start, String end, Set<String> dict, Map<String, Integer> distance, Map<String, List<String>> map) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);

            for (String next : nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt)+1);
                    q.offer(next);
                }
            }
        }
    }

    public static List<String> expand(String start, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < start.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != start.charAt(i)) {
                    String expanded = start.substring(0, i) + ch + start.substring(i+1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(WordLadderII.findLadders(beginWord, endWord, wordList));
    }
}

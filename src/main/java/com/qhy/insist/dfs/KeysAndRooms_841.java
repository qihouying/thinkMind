package com.qhy.insist.binaryTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author dream
 * @Date 2019/11/26 9:30 AM
 * @Description [Medium]   Topics: [Depth-first Search] [Graph] companies: []
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may
 * have some keys to access the next room.

    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1]
    where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

    Initially, all the rooms start locked (except for room 0).

    You can walk back and forth between rooms freely.

    Return true if and only if you can enter every room.

    Example 1:

    Input: [[1],[2],[3],[]]
    Output: true
    Explanation:
    We start in room 0, and pick up key 1.
    We then go to room 1, and pick up key 2.
    We then go to room 2, and pick up key 3.
    We then go to room 3.  Since we were able to go to every room, we return true.

    Example 2:

    Input: [[1,3],[3,0,1],[2],[0]]
    Output: false
    Explanation: We can't enter the room with number 2.
    Note:

    1 <= rooms.length <= 1000
    0 <= rooms[i].length <= 1000
    The number of keys in all rooms combined is at most 3000.

 */
public class KeysAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        addKey(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    public void addKey(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(room);
        for (int key : rooms.get(room)) {
            if (!visited.contains(key)) {
                addKey(key, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0));
        KeysAndRooms_841 keysAndRooms = new KeysAndRooms_841();
        System.out.println(keysAndRooms.canVisitAllRooms(rooms));
    }

}

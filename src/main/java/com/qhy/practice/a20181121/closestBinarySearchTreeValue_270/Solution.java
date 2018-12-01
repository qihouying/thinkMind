package com.qhy.practice.a20181121.closestBinarySearchTreeValue_270;

import java.util.HashMap;

/**
 * Created by dream on 2018/11/14.
 *
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors .
 OJ's undirected graph serialization: Nodes are labeled uniquely.
 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 The graph has a total of three nodes, and therefore contains three parts as separated
 by #.
     1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     2. Second node is labeled as 1. Connect node 1 to node 2.
     3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-
     cycle.
 Visually, the graph looks like the following:
     1 /\ /\ 0 --- 2
     /\ \_/
 Companies
    Google Facebook Uber
 Topics
    Pocket Gems Breadth-first Search Graph



 */
public class Solution {
    public HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (null == node)
            return null;
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(copyNode.label, copyNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copyNode.neighbors.add(clone(neighbor));
        }
        return copyNode;
    }
}

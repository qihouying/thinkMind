package com.qhy.practice.a20181120.cloneGraph_133;

import java.util.ArrayList;

/**
 * Created by dream on 2018/11/24.
 */
public class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

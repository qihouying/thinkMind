package com.qhy.practice.a20181107.binaryTreeLayerOrderTraversalI_107;

import com.qhy.practice.a20181027.balancedBinaryTree_110.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dream on 2018/11/8.
 *
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
     For example:
     Given binary tree {3,9,20,#,#,15,7} ,
     3 /\ 9 20
     /\ 15 7
     return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3] ]
     confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
     OJ's Binary Tree Serialization:
     The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
     Here's an example:
     1 /\ 23
     / 4
     \ 5
     The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}" .

     BFS solution:
     The addFirst() method of LinkedLinked save us from reverse final result
 *
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        addLevel(result, 0, root);
        return result;
    }

    public void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
        if (null == node)
            return;
        if (list.size()-1 < level) {
            list.addFirst(new LinkedList<Integer>());
        }
        list.get(list.size()-1-level).add(node.val);
        addLevel(list, level+1, node.left);
        addLevel(list, level+1, node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);

        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(treeNode));
    }
}

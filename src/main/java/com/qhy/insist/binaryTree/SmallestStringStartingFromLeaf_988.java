package com.qhy.insist.binaryTree;

/**
 * @Author dream
 * @Date 2019/11/25 8:52 AM
 * @Description [Medium]   Topics: [Tree] [Depth-first Search]  companies: []
 *
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value
 * of 0 represents 'a', a value of 1 represents 'b', and so on.

    Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

    (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically
    smaller than "aba".  A leaf of a node is a node that has no children.)



    Example 1:



    Input: [0,1,2,3,4,3,4]
    Output: "dba"
    Example 2:



    Input: [25,1,3,1,3,0,2]
    Output: "adz"
    Example 3:



    Input: [2,2,1,null,1,0,null,0]
    Output: "abc"


    Note:

    The number of nodes in the given tree will be between 1 and 8500.
    Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf_988 {
    public String smallestStringStartingFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    public String dfs(TreeNode node, String suffix) {
        if (node == null) {
            return suffix;
        }
        suffix = "" + (char)('a'+node.val)+suffix;
        if (null == node.left && null == node.right) {
            return suffix;
        }
        if (null == node.left || null == node.right) {
            return (null == node.left) ? dfs(node.right, suffix) : dfs(node.left, suffix);
        }

        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);

        return left.compareTo(right) <= 0 ? left :right;
    }
}

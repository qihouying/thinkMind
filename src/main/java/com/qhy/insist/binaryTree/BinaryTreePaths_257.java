package com.qhy.insist.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dream
 * @Date 2019/11/12 7:57 AM
 * @Description [Easy]   Topics: [Tree Depth-first Search]  companies: []
 *
 *Given a binary tree, return all root-to-leaf paths.

    Note: A leaf is a node with no children.

    Example:

    Input:

    1
    /   \
    2     3
    \
    5

    Output: ["1->2->5", "1->3"]

    Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
public class BinaryTreePaths_257 {
    public List<String> BinaryTreePath(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (null == root)
            return result;
        helper(root, "", result);
        return result;
    }

    public void helper(TreeNode node, String path, List<String> result) {
        if (null == node)
            return;
        if (null == node.left && null == node.right) {
            result.add(path+node.val);
            return;
        }
        if (null != node.left) {
            helper(node.left, path+node.val+"->", result);
        }
        if (null != node.right) {
            helper(node.right, path+node.val+"->", result);
        }
    }
}

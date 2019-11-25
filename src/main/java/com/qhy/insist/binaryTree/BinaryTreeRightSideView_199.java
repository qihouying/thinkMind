package com.qhy.insist.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author dream
 * @Date 2019/11/12 8:38 AM
 * @Description [Medium]   Topics: [Tree Depth-first Search Breadth-first Search]  companies: [Amazon]
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
    Example:

    Input: [1,2,3,null,5,null,4]
    Output: [1, 3, 4]
    Explanation:

      1            <---
    /   \
    2     3         <---
    \     \
    5     4       <---

You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int curDepth) {
        if (null == curr)
            return;
        if (curDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, curDepth+1);
        rightView(curr.left, result, curDepth+1);
    }

    //BFS
    public List<Integer> rightSideView2(TreeNode root) {
        if (null == root)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (size == 0) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}

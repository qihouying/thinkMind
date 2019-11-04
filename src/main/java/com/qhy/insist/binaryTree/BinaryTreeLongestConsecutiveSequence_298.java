package com.qhy.insist.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author dream
 * @Date 2019/11/3 11:12 AM
 * @Description [Medium]   Topics: [Tree]  companies: [Google]
 *
 * Given a binary tree, find the length of the longest consecutive sequence path.

    The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
    connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

    For example,

    1
    \
    3
    / \
    2   4
    \
    5
    Longest consecutive sequence path is 3-4-5, so return 3.

    2
    \
    3
    /
    2
    /
    1
    Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 *
 */
public class BinaryTreeLongestConsecutiveSequence_298 {

    /**
     * Method1:
     * 这道题让我们求二叉树的最长连续序列，关于二叉树的题基本都需要遍历树，而递归遍历写起来特别简单，下面这种解法是用到了递归版的先序遍历，
     * 我们对于每个遍历到的节点，我们看节点值是否比参数值(父节点值)大1，如果是则长度加1，否则长度重置为1，然后更新结果res，再递归调用左右
     * 子节点即可
     */
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (null == root)
            return 0;
        dfs(root, 0, root.val);
        return max;
    }

    private void dfs(TreeNode node, int cur, int target) {
        if (null == node)
            return;
        if (node.val == target+1) {
            cur++;
        } else {
            cur = 1;
        }
        max = Math.max(cur, max);
        dfs(node.left, cur, node.val+1);
        dfs(node.right, cur, node.val+1);
    }

    //Method2:更简洁的一种写法,分治的思想
    public int longestConsecutive2(TreeNode root) {
        return helper(root, null, 0);
    }

    public int helper(TreeNode node, TreeNode parent, int res) {
        if (null == node)
            return res;
        res = (null != parent && node.val == parent.val+1) ? res+1 : 1;
        return Math.max(res, Math.max(helper(node.left, node, res), helper(node.right, node, res)));
    }

    /**
     * Method3:迭代法
     *
     * 下面我们来看看迭代的方法，写法稍稍复杂一些，用的还是DFS的思想，以层序来遍历树，对于遍历到的节点，我们看其左右子节点有没有满足题意的，
     * 如果左子节点比其父节点大1，若右子节点存在，则排入queue，指针移到左子节点，反之若右子节点比其父节点大1，若左子节点存在，则排入queue，
     * 指针移到右子节点，依次类推直到queue为空
     */
    public int longestConsecutive3(TreeNode root) {
        if (null == root) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = 1;
            TreeNode t = q.peek(); q.poll();
            while ((null != t.left && t.left.val == t.val + 1) || (null != t.right && t.right.val == t.val + 1)) {
                if (null != t.left && t.left.val == t.val + 1) {
                    if (null != t.right) q.offer(t.right);
                    t = t.left;
                } else if (null != t.right && t.right.val == t.val + 1) {
                    if (null != t.left) q.offer(t.left);
                    t = t.right;
                }
                ++len;
            }
            if (null != t.left) q.offer(t.left);
            if (null != t.right) q.offer(t.right);
            res = Math.max(res, len);
        }
        return res;
    }

}

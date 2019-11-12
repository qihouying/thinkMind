package com.qhy.insist.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dream
 * @Date 2019/11/9 11:01 PM
 * @Description [Easy]   Topics: [Tree]  companies: [ ]
 *
 * You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
    nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

    Example:

    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

    10
    /  \
    5   -3
    / \    \
    3   2   11
    / \   \
    3  -2   1

    Return 3. The paths that sum to 8 are:

    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11
 */
public class PathSumIII_437 {
    public int pathSum(TreeNode root, int sum) {
        if (null == root)
            return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumFrom(TreeNode node, int sum) {
        if (null == node)
            return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum-node.val) + pathSumFrom(node.right, sum-node.val);
    }

    /**
     * Method2: 改进上面求解方法，我们可以用 HashMap 来建立路径之和跟其个数之间的映射，即路径之和为 curSum 的个数为 m[curSum]，这里
     * 我们需要将 m[0] 初始化为1，后面会讲解原因。在递归函数中，首先判空，若为空，直接返回0。然后就是 curSum 加上当前结点值。由于此时
     * curSum 可能已经大于了目标值 sum，所以用 curSum 减去 sum，并去 HashMap 中查找这个差值的映射值，若映射值大于0的化，说明存在结束点
     * 为当前结点且和为 sum 的路径，这就相当于累加和数组快速求某个区域和的原理。当 curSum 等于 sum 的时候，表明从根结点到当前结点正好是
     * 一条符合要求的路径，此时 res 应该大于0，这就是为啥要初始化 m[0] 为1的原因，举个例子来说吧，看下面这棵树：

     1
     /
     2
     /
     1
     假设 sum=3，当我们遍历根结点1时，curSum 为1，那么 curSum-sum=-2，映射值为0，然后建立映射 m[1]=1。此时遍历结点2，curSum 为3，
     那么 curSum-sum=0，由于 m[0] 初始化为1，所以 res=1，这是 make sense 的，因为存在和为3的路径。此时再遍历到第二个结点1，curSum
     为4，那么 curSum-sum=1，由于之前建立了 m[1]=1 的映射，所以当前的 res 也为1，因为存在以第二个结点1为结尾且和为3的路径，那么递归返
     回到结点2时候，此时的 res 累加到了2，再返回根结点1时，res 就是2，最终就返回了2，那么可以看出递归函数的意义，某个结点的递归函数的返回
     值就是该结点上方或下方所有和为 sum 的路径总个数。
     */


    /**
     * 1. The prefix stores the sum from the root to the current node in the recursion
     2. The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from the root
     to the current node. The sum from any node in the middle of the path to the current node = the difference between
     the sum from the root to the current node and the prefix sum of the node in the middle.
     3. We are looking for some consecutive nodes that sum up to the given target value, which means the difference discussed
     in 2. should equal to the target value. In addition, we need to know how many differences are equal to the target value.
     4. Here comes the map. The map stores the frequency of all possible sum in the path to the current node. If the difference
     between the current sum and the target value exists in the map, there must exist a node in the middle of the path,
     such that from this node to the current node, the sum is equal to the target value.
     5. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map
     is used to help with this.
     6. Therefore, in each recursion, the map stores all information we need to calculate the number of ranges that sum up
     to target. Note that each range starts from a middle node, ended by the current node.
     7. To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.
     8. Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can
     be divided into three parts:
     - the total number of valid paths in the subtree rooted at the current node's left child
     - the total number of valid paths in the subtree rooted at the current node's right child
     - the number of valid paths ended by the current node
     The interesting part of this solution is that the prefix is counted from the top(root) to the bottom(leaves), and
     the result of total count is calculated from the bottom to the top :D
     */
    public int pathSum1(TreeNode root, int sum) {
        if (null == root)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper(root, sum,0, map);
    }

    public int helper(TreeNode node, int sum, int curSum, Map<Integer, Integer> map) {
        if (null == node)
            return 0;
        // update the prefix sum by adding the current val
        curSum += node.val;

        // get the number of valid path, ended by the current node
        int res = map.getOrDefault(curSum-sum, 0);

        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(curSum, map.getOrDefault(curSum, 0)+1);

        // add the 3 parts discussed in 8. together
        res += helper(node.left, sum, curSum, map) + helper(node.right, sum, curSum, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(curSum, map.get(curSum)-1);
        return res;
    }


}

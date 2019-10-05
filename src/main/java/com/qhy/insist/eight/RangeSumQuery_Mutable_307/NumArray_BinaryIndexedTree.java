package com.qhy.insist.eight.RangeSumQuery_Mutable_307;

/**
 * @Author houyingqi
 * @Date 2019-10-04 19:53
 * @Description [Medium] Topics: [Binary Indexed Tree] [Segment Tree]
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 **/
/**
 * Approach 4: Binary Indexed Tree
 *
 * 参考：https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/
 *
 * Binary Indexed Tree, 树状数组比较有意思，所有的奇数位置的数字和原数组对应位置的相同，偶数位置是原数组若干位值之和，假如原数组
 * A(a1, a2, a3, a4 ...)，和其对应的树状数组 C(c1, c2, c3, c4 ...)有如下关系：
 * C1 = A1
 * C2 = A1 + A2
 * C3 = A3
 * C4 = A1 + A2 + A3 + A4
 * C5 = A5
 * C6 = A5 + A6
 * C7 = A7
 * C8 = A1 + A2 + A3 + A4 + A5 + A6 + A7 + A8
 * ...
 * bit[] as a binary tree:
 *      *            ______________*
 *      *            ______*
 *      *            __*     __*
 *      *            *   *   *   *
 *      * indices: 0 1 2 3 4 5 6 7 8
 * 那么是如何确定某个位置到底是有几个数组成的呢，原来是根据坐标的最低位 Low bit 来决定的，所谓的最低位，就是二进制数的最右边的一个1
 * 开始，加上后面的0(如果有的话)组成的数字，例如1到8的最低位如下面所示：
 *
 * 坐标          二进制       最低位
 *
 * 1               0001          1
 *
 * 2               0010          2
 *
 * 3               0011          1
 *
 * 4               0100          4
 *
 * 5               0101          1
 *
 * 6               0110          2
 *
 * 7               0111          1
 *
 * 8               1000          8
 *
 * ...
 *
 * 最低位的计算方法有两种，一种是 x&(x^(x–1))，另一种是利用补码特性 x&-x。
 *
 * 这道题我们先根据给定输入数组建立一个树状数组 bit，比如，对于 nums = {1, 3, 5, 9, 11, 13, 15, 17}，建立出的 bit 数组为：
 *
 * bit -> 0 1 4 5 18 11 24 15 74
 *
 * 注意到我们给 bit 数组开头 padding 了一个0，这样我们在利用上面的树状数组的性质时就不用进行坐标转换了。可以发现bit数组中奇数位上的
 * 数字跟原数组是相同的，参见上面标记蓝色的数字。偶数位则是之前若干位之和，符合上图中的规律。
 *
 *
 * 时间复杂度:
 *     查询和修改复杂度均为 O(logn)
 *     Space complexity : O(1).
 */
//重点掌握该方法
public class NumArray_BinaryIndexedTree {
    int[] nums;
    int[] bit;
    int n;

    /**
     * 1. Build Binary Indexed Tree
     *
     * 这里构建过程是不是有点复杂呢？ 是否可以直接将奇数位填充，然后，计算相应偶数位的数呢？
     */
    public NumArray_BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        n = nums.length;
        bit = new int[n+1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            bit[i] += val;
            System.out.println("i=" + i + ", bit[" +i+"]=" + bit[i]);
            i += (i & -i);
        }
    }


    /**
     * 2.Update segment tree
     * 现在我们要更新某一位数字时，比如将数字5变成2，即 update(2, 2)，那么现求出差值 diff = 2 - 5 = -3，然后我们需要更新树状数组bit，
     * 根据最低位的值来更新后面含有这一位数字的地方，一般只需要更新部分偶数位置的值即可。由于我们在开头padding了个0，所以我们的起始位置要加1，
     * 即 j=3，然后现将 bit[3] 更新为2，然后更新下一位，根据图中所示，并不是 bit[3] 后的每一位都需要更新的，下一位需要更新的位置的计算方法为
     * j += (j&-j)，这里我们的j是3，则 (j&-j) = 1，所以下一位需要更新的是 bit[4]，更新为15，现在j是4，则 (j&-j) = 4，所以下一位需要
     * 更新的是 bit[8]，更新为71，具体的变换过程如下所示：
     *
     * 0 1 4 5 18 11 24 15 74
     *
     * 0 1 4 2 18 11 24 15 74
     *
     * 0 1 4 2 15 11 24 15 74
     *
     * 0 1 4 2 15 11 24 15 71
     */
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    /**
     * 3. Range Sum Query
     * 接下来就是求区域和了，直接求有些困难，我们需要稍稍转换下思路。比如若我们能求出前i-1个数字之和，跟前j个数字之和，那么二者的差值就是
     * 要求的区间和了。所以我们先实现求前任意i个数字之和，当然还是要利用树状数组的性质，此时正好跟 update 函数反过来，我们的j从位置i开始，
     * 每次将 bit[j] 累加到 sum，然后更新j，通过 j -= (j&-j)，这样就能快速的求出前i个数字之和了，从而也就能求出任意区间之和了
     *
     */
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
     private int getSum(int i) {
        int res = 0;
        for (int j = i+1; j > 0; j -= (j & -j)) {
            res += bit[j];
        }
        return res;
     }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray_BinaryIndexedTree numArray_binaryIndexedTree = new NumArray_BinaryIndexedTree(nums);
        numArray_binaryIndexedTree.update(1,2);
        System.out.println(numArray_binaryIndexedTree.sumRange(0,2));

    }

}

package com.qhy.insist.dynamicPrograming.class_05.RangeSumQuery_Mutable_307;

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
 * Approach 3: Segment Tree
 *
 * Segment tree is a very flexible data structure, because it is used to solve numerous range query problems like
 * finding minimum, maximum, sum, greatest common divisor, least common denominator in array in logarithmic time.
 * 分段树用数组模拟，确实很tricky。用一个大小为 2n 的 tree 数字，然后就要往里面填数字了。填数字的方式先给 tree 数组的后n个数字按顺序填上 nums 数字，比如对于 nums = [1 3 5 7]，那么 tree 数组首先填上：
 *_ _ _ _ 1 3 5 7
 *
 * 然后从 i=3 开始，每次填上 tree[2*n] + tree[2*n+1]，那么以此为：
 *
 * _ _ _ 12 1 3 5 7
 *
 * _ _ 4 12 1 3 5 7
 *
 * _ 16 4 12 1 3 5 7
 *
 * 那么最终的 tree 数组就是 [0 16 4 12 1 3 5 7]，tree[0] 其实没啥作用
 *
 *
 * Complexity Analysis
 *
 * Time complexity : O(logn).
 *
 * Algorithm has O(logn) time complexity, because there are a few tree nodes with range that include ith array element,
 * one on each level. There are log(n) levels.
 *
 * Space complexity : O(1).
 */
public class NumArray_SegmentTree {
    int[] nums;
    int[] tree;
    int n;

    /**
     * 1. Build segment tree
     * We will use a very effective bottom-up approach to build segment tree. We already know from the above that if some
     * node pp holds the sum of [i…j] range, its left and right children hold the sum for range [i…(i+j)/2] and [(i+j)/2+1,j]
     * respectively.
     *
     * Therefore to find the sum of node pp, we need to calculate the sum of its right and left child in advance.
     *
     * We begin from the leaves, initialize them with input array elements a[0,1,…,n−1]. Then we move upward to the higher
     * level to calculate the parents' sum till we get to the root of the segment tree.
     * @param nums
     */
    public NumArray_SegmentTree(int[] nums) {
        this.nums = nums;
        if (null != nums && nums.length > 0) {
            n = nums.length;
            tree = new int[n*2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2*n; i++,j++) {
            tree[i] = nums[j];
        }
        for (int i = n-1; i > 0; i--) {
            tree[i] = tree[2*i] + tree[2*i+1];
        }
    }

    /**
     * 2.Update segment tree
     * When we update the array at some index i we need to rebuild the segment tree, because there are tree nodes which
     * contain the sum of the modified element. Again we will use a bottom-up approach. We update the leaf node that
     * stores a[i]. From there we will follow the path up to the root updating the value of each parent as a sum of
     * its children values.
     */
    public void update(int i, int val) {
        i += n;
        tree[i] = val;
        while (i > 0) {
            int left = i;
            int right = i;
            if (i % 2 == 0) {
                right = i + 1;
            } else {
                left = i - 1;
            }
            tree[i/2] = tree[left] + tree[right];
            i /= 2;
        }
    }

    /**
     * 3. Range Sum Query
     * We can find range sum query [L, R][L,R] using segment tree in the following way:
     *
     * Algorithm hold loop invariant:
     *
     * l≤r and sum of [L…l] and [r…R] has been calculated, where l and r are the left
     * and right boundary of calculated sum. Initially we set ll with left leaf L and r with right leaf R. Range [l,r]
     * shrinks on each iteration till range borders meets after approximately logn iterations of the algorithm
     *
     * Loop till rl≤r
     * Check if l is right child of its parent P
     * 1) l is right child of P. Then P contains sum of range of l and another child which is outside the range [l,r]
     * and we don't need parent P sum. Add l to sum without its parent P and set l to point to the right of P on the
      * upper level.
     * 2) l is not right child of P. Then parent P contains sum of range which lies in [l,r]. Add P to sum and set l to
     * point to the parent of P
     * Check if r is left child of its parent P
     * 1) r is left child of P. Then P contains sum of range of r and another child which is outside the range [l,r] and
     * we don't need parent P sum. Add rr to sumsum without its parent PP and set rr to point to the left of PP on the upper level.
     * 2)r is not left child of P. Then parent P contains sum of range which lies in [l,r]. Add P to sum and set r to
     * point to the parent of P
     * 中文解释:
     * 比如我们要求 sumRange(1, 3)，对于更新后的数组 nums = [1 3 2 7]，我们可以很快算出来，是12。那么对于tree = [13 13 4 9 1 3 2 7]，
     * 我们如何计算呢。当然还是要先进行坐标变换，i变为5，j变为7。然后进行累加，我们的策略是，若i是左子结点，那么跟其成对儿出现的右边的结点
     * 就在要求的区间里，则此时直接加上父结点值即可，若i是右子结点，那么只需要加上结点i本身即可。同理，若j是左子结点，那么只需要加上结点j本身，
     * 若j是右子结点，那么跟其成对儿出现的左边的结点就在要求的区间里，则此时直接加上父结点值即可。具体的实现方法是，判断若i是奇数，
     * 则说明其是右子结点，则加上 tree[i] 本身，然后i自增1；再判断若j是偶数，则说明其是左子结点，则加上 tree[j] 本身，然后j自减1。
     * 那么你可能有疑问，i是偶数，和j是奇数的情况就不用处理了么，当然不是，这两种情况都是要加父结点的，我们可以到下一轮去加，因为每一轮后，
     * i和j都会除以2，那么i一定会有到奇数的一天，所以不用担心会有值丢失，一定会到某一个父结点上把值加上的
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        for (i += n,j += n; i <= j; i /= 2,j /= 2) {
            //如果i为奇数，即为右结点
            if ((i & 1) == 1) {
                sum += tree[i++];
            }
            //如果j为偶数，即为左结点
            if ((j & 1) == 0) {
                sum += tree[j--];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray_SegmentTree numArray_segmentTree = new NumArray_SegmentTree(nums);
        numArray_segmentTree.update(1, 2);
        System.out.println(numArray_segmentTree.sumRange(0, 2));
    }

}

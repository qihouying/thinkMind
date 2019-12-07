package com.qhy.insist.dynamicPrograming.class_04;

/**
 * @Author houyingqi
 * @Date 2019-10-03 21:32
 * @Description [Hard] Topics: [Binary Search] [Divide and Conquer] [Sort] [Binary Indexed Tree] [Segment Tree]
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 *
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 **/

import java.util.Arrays;

/**
 *
 * It looks like a host of solutions are out there (BST-based, BIT-based, Merge-sort-based). Here I'd like to focus on
 * the general principles behind these solutions and its possible application to a number of similar problems.
 *
 * The fundamental idea is very simple: break down the array and solve for the subproblems.
 *
 * A breakdown of an array naturally reminds us of subarrays. To smoothen our following discussion, let's assume the
 * input array is nums, with a total of n elements. Let nums[i, j] denote the subarray starting from index i to index j
 * (both inclusive), T(i, j) as the same problem applied to this subarray (for example, for Reverse Pairs, T(i, j) will
 * represent the total number of important reverse pairs for subarray nums[i, j]).
 *
 * With the definition above, it's straightforward to identify our original problem as T(0, n - 1). Now the key point is
 * how to construct solutions to the original problem from its subproblems. This is essentially equivalent to building
 * recurrence relations for T(i, j). Since if we can find solutions to T(i, j) from its subproblems, we surely can build
 * solutions to larger subarrays until eventually the whole array is spanned.
 *
 * While there may be many ways for establishing recurrence relations for T(i, j), here I will only introduce the following
 * two common ones:
 *
 * T(i, j) = T(i, j - 1) + C, i.e., elements will be processed sequentially and C denotes the subproblem for processing
 * the last element of subarray nums[i, j]. We will call this sequential recurrence relation.
 *
 * T(i, j) = T(i, m) + T(m + 1, j) + C where m = (i+j)/2, i.e., subarray nums[i, j] will be further partitioned into two
 * parts and C denotes the subproblem for combining the two parts. We will call this partition recurrence relation.
 *
 * For either case, the nature of the subproblem C will depend on the problem under consideration, and it will determine
 * the overall time complexity of the original problem. So usually it's crucial to find efficient algorithm for solving
 * this subproblem in order to have better time performance. Also pay attention to possibilities of overlapping subproblems,
 * in which case a dynamic programming (DP) approach would be preferred.
 *
 * Next, I will apply these two recurrence relations to this problem "Reverse Pairs" and list some solutions for your reference.
 *
 * I -- Sequential recurrence relation
 *
 * Again we assume the input array is nums with n elements and T(i, j) denotes the total number of important reverse pairs
 * for subarray nums[i, j]. For sequential recurrence relation, we can set i = 0, i.e., the subarray always starts from
 * the beginning. Therefore we end up with:
 *
 * T(0, j) = T(0, j - 1) + C
 *
 * where the subproblem C now becomes "find the number of important reverse pairs with the first element of the pair
 * coming from subarray nums[0, j - 1] while the second element of the pair being nums[j]".
 *
 * Note that for a pair (p, q) to be an important reverse pair, it has to satisfy the following two conditions:
 *
 * p < q: the first element must come before the second element;
 * nums[p] > 2 * nums[q]: the first element has to be greater than twice of the second element.
 * For subproblem C, the first condition is met automatically; so we only need to consider the second condition, which
 * is equivalent to searching for all elements within subarray nums[0, j - 1] that are greater than twice of nums[j].
 *
 * The straightforward way of searching would be a linear scan of the subarray, which runs at the order of O(j). From
 * the sequential recurrence relation, this leads to the naive O(n^2) solution.
 *
 * To improve the searching efficiency, a key observation is that the order of elements in the subarray does not matter,
 * since we are only interested in the total number of important reverse pairs. This suggests we may sort those elements
 * and do a binary search instead of a plain linear scan.
 *
 * If the searching space (formed by elements over which the search will be done) is "static" (it does not vary from run
 * to run), placing the elements into an array would be perfect for us to do the binary search. However, this is not the
 * case here. After the j-th element is processed, we need to add it to the searching space so that it becomes searchable
 * for later elements, which renders the searching space expanding as more and more elements are processed.
 *
 * Therefore we'd like to strike a balance between searching and insertion operations. This is where data structures like
 * binary search tree (BST) or binary indexed tree (BIT) prevail, which offers relatively fast performance for both operations.
 */

//此题解法繁多，需要重点看
public class ReversePairs_493 {

    //Method1: 暴力法，Time complexity is O(n^2)，改进方法是：第二层for循环之前，先排序，后采用二分查找法，时间复杂度降低到O(nlogn)
    public int reversePairs1(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] f = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 2 * nums[i];
        }

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++) {
                if (nums[i] > f[j]) {
                    count++;
                }
            }
        return count;
    }

    /**
     * Method2: BST-based solution
     *
     *  we will define the tree node as follows, where val is the node value and cnt is the total number of elements in
     *  the subtree rooted at current node that are greater than or equal to val:
     */

    /**
     * In the main program, in which we will search for all elements no less than twice of current element plus
     * 1 (converted to long type to avoid overflow) while insert the element itself into the BST.
     *
     * Note: this homemade BST is not self-balanced and the time complexity can go as bad as O(n^2) (in fact you will
     * get TLE if you copy and paste the solution here). To guarantee O(nlogn) performance, use one of the self-balanced
     * BST's (e.g. Red-black tree, AVL tree, etc.).
     *
     */
    public int reversePairs2(int[] nums) {
        int res = 0;
        Node root = null;

        for (int elem : nums) {
            root = insert(root, elem);
            res += search(root, 2L * elem + 1);
        }

        return res;
    }

    class Node {
        int val, cnt;
        Node left, right;
        int height; //just for AVL tree

        Node(int val) {
            this.val = val;
            this.cnt = 1;
            height = 1;
        }
    }

    private int search(Node root, long val) {
        if (null == root) {
            return 0;
        } else if (val == root.val) {
            return root.cnt;
        } else if (val < root.val) {
            return root.cnt + search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private Node insert(Node root, int val) {
        if (null == root) {
            root = new Node(val);
        } else if (val == root.val) {
            root.cnt++;
        } else if (val < root.val){
            root.left = insert(root.left, val);
        } else {
            root.cnt++;
            root.right = insert(root.right, val);
        }

        root.height = Math.max(getHeight(root.left), getHeight((root.right))) + 1;

        int balance = getBalance(root);

        //case1 left left
        if (balance > 1 && getHeight(root.left.left) > getHeight(root.left.right)) {
            return rightRotate(root);
        }

        //case2 left right
        if (balance > 1 && getHeight(root.right.left) < getHeight(root.right.right)) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // case 3 right right
        if (balance < -1 && getHeight(root.right.left) < getHeight(root.right.right)) {
            return leftRotate(root);
        }

        // case 4 right left
        if (balance < -1 && getHeight(root.right.left) > getHeight(root.right.right)) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node leftRotate(Node root) {
        //step1: take care of nodes
        Node newRoot = root.right;
        Node b = newRoot.left;

        newRoot.left = root;
        root.right = b;

        //step2: take care of height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        //step3: take care of cnt(rightCount)
        root.cnt -= getCnt(newRoot);
        return newRoot;
    }
    private Node rightRotate(Node root) {
        //step1: take care of nodes
        Node newRoot = root.left;
        Node b = newRoot.right;

        newRoot.right = root;
        root.left = b;

        //step2: take care of height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        //step3: take care of cnt(rightCount)
        newRoot.cnt += getCnt(root);
        return newRoot;
    }


    private int getHeight(Node node) {
        return null == node ? 0 : node.height;
    }
    private int getBalance(Node node) {
        return null == node ? 0 : getHeight(node.left)-getHeight(node.right);
    }
    private int getCnt(Node node) {
        return null == node ? 0 : node.cnt;
    }

    /**
     * Method3:  BIT-based solution
     *
     * In the main program, where again we will search for all elements greater than twice of current element while insert
     * the element itself into the BIT. For each element, the "index" function will return its index in the BIT. Unlike
     * the BST-based solution, this is guaranteed to run at O(nlogn)
     *
     * More explanation for the BIT-based solution:
     *
     * 1.We want the elements to be sorted so there is a sorted version of the input array which is copy.
     *
     * 2.The bit is built upon this sorted array. Its length is one greater than that of the copy array to account for the root.
     *
     * 3.Initially the bit is empty and we start doing a sequential scan of the input array. For each element being scanned,
     * we first search the bit to find all elements greater than twice of it and add the result to res. We then insert
     * the element itself into the bit for future search.
     *
     * 4.Note that conventionally searching of the bit involves traversing towards the root from some index of the bit,
     * which will yield a predefined running total of the copy array up to the corresponding index. For insertion, the
     * traversing direction will be opposite and go from some index towards the end of the bit array.
     *
     * 5.For each scanned element of the input array, its searching index will be given by the index of the first element
     * in the copy array that is greater than twice of it (shifted up by 1 to account for the root), while its insertion
     * index will be the index of the first element in the copy array that is no less than itself (again shifted up by 1).
     * This is what the index function is for.
     *
     * 6.For our case, the running total is simply the number of elements encountered during the traversal process. If we
     * stick to the convention above, the running total will be the number of elements smaller than the one at the given
     * index, since the copy array is sorted in ascending order. However, we'd actually like to find the number of
     * elements greater than some value (i.e., twice of the element being scanned), therefore we need to flip the
     * convention. This is what you see inside the search and insert functions: the former traversing towards the end of
     * the bit while the latter towards the root.
     *
     */

    public int reversePairs3(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        for (int ele : nums) {
            res += search(bit, index(copy, 2L * ele + 1));
            insert(bit, index(copy, ele));
        }

        return res;
    }

    //1.用于计算(2L * ele + 1)后在copy数组中的下标 2.计算原数组中每个元素在copy数组中的下标
    private int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }

    private int search(int[] bit, int i) {
        int sum = 0;

        while (i < bit.length) {
            sum += bit[i];
            i += i & -i;
        }

        return sum;
    }

    /**
     * For each element being scanned,we first search the bit to find all elements greater than twice of it and add the
     * result to res. We then insert the element itself into the bit for future search.
     *
     *Let me add more explanations for why the BIT approach is
     * "i += i&(-i)" for search, and
     * "i -= i &(-i)" for insert.
     * which is contrary to the "commonly" used way for BIT, where
     * "i += (-i)" for insert, and
     * "i -= i&(-i)" for search
     */
    private void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i;
        }
    }

    /**
     * Method4: Partition recurrence relation
     *
     * For partition recurrence relation, setting i = 0, j = n - 1, m = (n-1)/2, we have:
     *
     * T(0, n - 1) = T(0, m) + T(m + 1, n - 1) + C
     *
     * where the subproblem C now reads "find the number of important reverse pairs with the first element of the pair
     * coming from the left subarray nums[0, m] while the second element of the pair coming from the right subarray
     * nums[m + 1, n - 1]".
     *
     * Again for this subproblem, the first of the two aforementioned conditions is met automatically. As for the second
     * condition, we have as usual this plain linear scan algorithm, applied for each element in the left (or right)
     * subarray. This, to no surprise, leads to the O(n^2) naive solution.
     *
     * Fortunately the observation holds true here that the order of elements in the left or right subarray does not
     * matter, which prompts sorting of elements in both subarrays. With both subarrays sorted, the number of important
     * reverse pairs can be found in linear time by employing the so-called two-pointer technique: one pointing to elements
     * in the left subarray while the other to those in the right subarray and both pointers will go only in one direction
     * due to the ordering of the elements.
     *
     * The last question is which algorithm is best here to sort the subarrays. Since we need to partition the array int
     * o halves anyway, it is most natural to adapt it into a Merge-sort. Another point in favor of Merge-sort is that
     * the searching process above can be embedded seamlessly into its merging stage.
     *
     * So here is the Merge-sort-based solution, where the function "reversePairsSub" will return the total number of
     * important reverse pairs within subarray nums[l, r]. The two-pointer searching process is represented by the nested
     * while loop involving variable p, while the rest is the standard merging algorithm.
     *
     */

    public int reversePairs4(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p]) p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r) merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        int[] nums1 = {2,4,3,5,1};
        ReversePairs_493 reversePairs = new ReversePairs_493();

        System.out.println(reversePairs.reversePairs1(nums));
        System.out.println(reversePairs.reversePairs1(nums1));

        System.out.println(reversePairs.reversePairs2(nums));
        System.out.println(reversePairs.reversePairs2(nums1));

        System.out.println(reversePairs.reversePairs3(nums));
        System.out.println(reversePairs.reversePairs3(nums1));

        System.out.println(reversePairs.reversePairs4(nums));
        System.out.println(reversePairs.reversePairs4(nums1));

    }
}

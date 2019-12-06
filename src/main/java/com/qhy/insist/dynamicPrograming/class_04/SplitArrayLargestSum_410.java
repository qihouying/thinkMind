package com.qhy.insist.dynamicPrograming.class_04;

/**
 * @Author houyingqi
 * @Date 2019-10-03 11:54
 * @Description [hard] Topics: [Binary Search] [Dynamic Programming]
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 * 题目意思是说，给你一个数组，然后一个m，把数组划分成m部分，前提是这m个子数组都是连续从原有数组中提取出来的，找出m部分最大的子数组和，
 * 并针对所有的可能划分情况，找到最小的最大的子数组和。
 *
 * 乍一看很难理解，没关系，举个例子很容易理解题意。如数组：
 * [7,2,5,10,8]，m = 2
 *
 * 那么可以有几种划分使得变成两个数组？
 * 1. [7],[2,5,10,8]
 * 2. [7,2],[5,10,8]
 * 3. [7,2,5],[10,8]
 * 4. [7,2,5,10],[8]
 *
 * 对应于每个划分，我们可以分别求出每个划分中最大的子数组和，有：
 * 1. 25
 * 2. 23
 * 3. 18
 * 4. 24
 *
 * 所以应该返回18.
 **/
//重点看，解法比较独特，既可以通过二分查找的贪婪解法，又可以用动态规划求解
public class SplitArrayLargestSum_410 {

    /**
     *  Method1: binary search + greedy  [Amazing]
     *
     *  大神的整体思路：假设我们已经在解空间里有了一系列minMaxsums，去搜索一个minMaxsum(尽量让划分后的m个部分的sum相近，此时，划分后最大sum几位所求)使得符合m
     *
     *  进一步思考：可能的minMaxsum有哪些，中间的哪些minMaxsum我们是不知道的，这是问题的关键！所以这个问题就假设最极端的两头情况：
     *
     * 当 m = 1 时，这种情况，minMaxsum = 整个数组之和。
     * 当 m = 数组长度时，这种情况，minMaxsum = 数组中最大的那个元素。
     *
     *
     *
     *
     * The range of the answer is between max(nums) and sum(nums). Do a binary search on this range. For every mid value,
     * I check if the array can be split into m sub-arrays, where each sub-array's sum <= mid.
     * If I can, that means mid is too large. Keep the left half.
     * If I can't, that means mid is too small. Keep the right half.
     *
     * Since I'm to split the array into sub-arrays, I can be greedy when I check if the array can be split into m parts.
     * As soon as current sum exceeds mid, I continue onto the next sub-array.
     *
     * 收获：对二分查找有了重新的认识：
     *
     * 下标不一定是数组的下标，求解问题的解空间同样可以当作下标，满足状态递增就行。
     * 一定要符合状态空间中元素的有序性么？不一定，只要在搜索时，能够有约束条件排除左半或者右半即可。
     */
    public int splitArray1(int[] nums, int m) {
        long left = 0;
        long right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            //现在mid的物理含义是minMaxsum
            long mid = (left + right) / 2;
//            System.out.println("left=" + left + ", right=" + right + ", mid="+mid);

            //如果在当前sum下能找出m，我们不妨试试更小的sum
            if (canSplit1(nums, m, mid)) {
                right = mid - 1;

                //当前minMaxsum下划分part个数超过m，m越小，minMaxsum越大，因此，为了减小part个数，需要增加minMaxsum
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
        //最后结束的条件：left == right+1，而此时mid=right+1,因为最后一次一定是能找到正确划分为m个part的minMaxsum
        return (int) left;
    }

    //搜索解空间，找对应的m，符合情况就输出
    private boolean canSplit1(int[] nums, int m, long cap) {
        int count = 1;
        long sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum > cap) {
                count++;
                if (count > m) {
                    return false;
                }
                sum = num;
            }
        }
        return true;
    }

    /**
     *  Method2: dynamic programming  [Amazing]
     *
     *  整体思路：
     *  建立一个二维数组dp，其中dp[i][j]表示将数组中前j个数字分成i组所得到的的最小的各个子数组中最大值，
     *  初始化为整型最大值，如果无法分为i组，那么还是保持为整型最大值。
     *  为了快速的算出子数组之和，还要建立累计和数组，难点就在于推导状态转移方程了。
     *  来分析一下，如果前j个数字要分成i组，那么i的范围是什么，由于只有j个数字，如果每个数字都是单独的一组，那么最多有j组；
     *  如果将整个数组看为一个整体，那么最少有1组，所以i的范围是[1,j]，
     *  所以要遍历这中间所有的情况，假如中间任意一个位置k，dp[i-1][k]表示数组中前k个数字分成i-1组所能得到的最小的各个子数组中最大值，
     *  而f[0][j] - f[0][k]就是后面的数字之和，取二者之间的较大值，然后，和dp[i][j]原有值进行对比，更新dp[i][j]为二者之中的较小值，这样k在[1,j]的
     *  范围内扫过一遍，dp[i][j]就能更新到最小值，最终返回dp[m][n]即可
     *
     * 1.Sub-problem: minimize the largest sum among a (a < m) sub-arrays of a sub-array of nums.
     * 2.Function: m is the rows and nums is the columns. f[i][j] = min(max(f[i - 1][k] + nums[k] + nums[k + 1] + ... + nums[j])).
     * 3.Initialization: f[1][i] = prefix sum of nums[i].
     * 4.Answer: f[m][nums.length].
     *
     * Time complexity: O(mn^2).
     * If the prefix sums are stored in a separate array, the space complexity can be optimized by using one-dimensional DP.
     */

    public int splitArray2(int[] nums, int m) {
        if (m <= 0) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }

        int[][] f = new int[m][nums.length];
        f[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[0][i] = f[0][i - 1] + nums[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < nums.length; j++) {
                //所有可能组合
                int min = Integer.MAX_VALUE;
                //要计算f[i][j]，需要计算f[i-1][k]的所有可能组i-1<=k<j中最小的
                for (int k = i - 1; k < j; k++) {
                    //递推公式：要计算f[i][j]，即计算数组中前k个数字分成i-1组所能得到的最小的各个子数组中最大值，和后面一组(f[0][j] - f[0][k])比较，取最大的
                    min = Math.min(min, Math.max(f[i - 1][k], f[0][j] - f[0][k]));
                }
                f[i][j] = min;
//                System.out.println("f["+i+"]["+j+"]="+f[i][j]);
            }
        }
        return f[m - 1][nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        SplitArrayLargestSum_410 splitArrayLargestSum = new SplitArrayLargestSum_410();
        System.out.println(splitArrayLargestSum.splitArray1(nums, m));
        System.out.println(splitArrayLargestSum.splitArray2(nums, m));
    }
}

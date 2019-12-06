package com.qhy.insist.dynamicPrograming.class_05;

/**
 * @Author houyingqi
 * @Date 2019-10-05 01:12
 * @Description [Medium] Topics: [Dynamic Programming]
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3),
 * which contains sum = 8.
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * 1. You may assume that the matrix does not change.
 * 2. There are many calls to sumRegion function.
 * 3. You may assume that row1 ≤ row2 and col1 ≤ col2.
 **/
//This subject is the extensibility of 303. The key is to find the regulation
public class RangeSumQuery2D_Immutable_304 {
    int row, col;
    int[][] matrix;
    int[][] dp; //dp[i][j]存储从(0,0)到(i,j)之间元素的sum
    /**
     * Construct a 2D array sums[row+1][col+1]
     *
     * (notice: we add additional blank row sums[0][col+1]={0} and blank column sums[row+1][0]={0} to remove the edge
     * case checking), so, we can have the following definition
     *
     * sums[i+1][j+1] represents the sum of area from matrix[0][0] to matrix[i][j]
     *
     * To calculate sums, the ideas as below
     *
     * +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
     * |     | |       |     |        |     |     |     |         |     |     |        |
     * |     | |       |     |        |     |     |     |         |     |     |        |
     * +-----+-+       |     +--------+     |     |     |         |     +-----+        |
     * |     | |       |  =  |              |  +  |     |         |  -  |              |
     * +-----+-+       |     |              |     +-----+         |     |              |
     * |               |     |              |     |               |     |              |
     * |               |     |              |     |               |     |              |
     * +---------------+     +--------------+     +---------------+     +--------------+
     *
     *    sums[i][j]      =    sums[i-1][j]    +     sums[i][j-1]    -   sums[i-1][j-1]   +
     *
     *                         matrix[i-1][j-1]
     * So, we use the same idea to find the specific area's sum.
     *
     * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     * |               |   |         |    |   |   |           |   |         |    |   |   |          |
     * |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
     * |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
     * |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
     * |   |      |    |   |         |    |   |   |           |   |              |   |              |
     * |   +------+    |   +---------+    |   +---+           |   |              |   |              |
     * |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
     * +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
     *
     *
     * Complexity analysis
     *
     * Time complexity : O(1) time per query, O(mn) time pre-computation. The pre-computation in the constructor
     * takes O(mn) time. Each sumRegion query takes O(1) time.
     *
     * Space complexity : O(mn). The algorithm uses O(mn) space to store the cumulative region sum.
     */
    public RangeSumQuery2D_Immutable_304(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return;
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        dp = new int[row+1][col+1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        RangeSumQuery2D_Immutable_304 rangeSumQuery2D_immutable = new RangeSumQuery2D_Immutable_304(matrix);
        System.out.println(rangeSumQuery2D_immutable.sumRegion(2, 1, 4, 3));
        System.out.println(rangeSumQuery2D_immutable.sumRegion(1, 1, 2, 2));
        System.out.println(rangeSumQuery2D_immutable.sumRegion(1, 2, 2, 4));
    }
}

package com.qhy.insist.eight.RangeSumQuery2D_Mutable_308;

/**
 * @Author houyingqi
 * @Date 2019-10-05 20:28
 * @Description [Hard] Topics: [Binary Indexed Tree] [Segment Tree]
 *  *
 *  * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
 *  * its upper left corner (row1, col1) and lower right corner (row2, col2).
 *  * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3),
 *  * which contains sum = 8.
 *  * Example:
 *  * Given matrix = [
 *  * [3, 0, 1, 4, 2],
 *  * [5, 6, 3, 2, 1],
 *  * [1, 2, 0, 1, 5],
 *  * [4, 1, 0, 1, 7],
 *  * [1, 0, 3, 0, 5]
 *  * ]
 *  * sumRegion(2, 1, 4, 3) -> 8
 *  * update(3, 2, 2)
 *  * sumRegion(2, 1, 4, 3) -> 10
 *  * Note:
 *  * 1. The matrix is only modifiable by the update function.
 *  * 2. You may assume the number of calls to update and sumRegion function is distributed evenly.
 *  * 3. You may assume that row1 ≤ row2 and col1 ≤ col2.
 *  **/

/**
 * Approach 1: Column Sum
 *
 * 网上还看到了另一种解法，这种解法并没有用到树状数组，而是利用了列之和，所谓列之和，就是(i, j)就是(0, j) + (1, j) + ... + (i, j)之和，
 * 相当于把很多个一维的区间之和拼到了一起，那么我们在构造函数中需要建立起这样一个列之和矩阵，然后再更新某一个位置时，我们只需要将该列中改变
 * 的位置下面的所有数字更新一下即可，而在求某个区间和时，只要将相差的各列中对应的起始和结束的行上的值的差值累加起来即可
 *
 * 时间复杂度:
 *     查询和修改的复杂度均为O(n)
 */

//重点掌握该方法
public class NumMatrix_ColumnSum {
    int row, col;
    int[][] matrix;
    int[][] colSum;

    public NumMatrix_ColumnSum(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return;
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        colSum = new int[row+1][col];
        for (int r = 1; r < row+1; r++) {
            for (int c = 0; c < col; c++) {
                colSum[r][c] = colSum[r-1][c] + matrix[r-1][c];
            }
        }
    }


    public void update(int r, int c, int val) {
        for (int i = r+1; i < row+1; i++) {
            colSum[i][c] += val - matrix[r][c];
        }
        matrix[r][c] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int j = col1; j <= col2; j++) {
            res += colSum[row2+1][j] - colSum[row1][j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix_ColumnSum numMatrix_segmentTree = new NumMatrix_ColumnSum(matrix);
        numMatrix_segmentTree.update(3, 2, 2);
        System.out.println(numMatrix_segmentTree.sumRegion(2, 1, 4, 3));
    }

}

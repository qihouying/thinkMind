package com.qhy.insist.dynamicPrograming.class_05.RangeSumQuery2D_Mutable_308;

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
 * Approach 1: Binary Indexed Tree (2D)
 *
 * 该题与 Range Sum Query - Mutable 相同，只不过是将原来的一维数组转换成了二维矩阵。
 * 但是解法类似，我们还是要建立树状数组，我们根据数组中的每一个位置，建立一个二维的树状数组，然后还需要一个getSum函数，以便求得从(0, 0)到
 * (i, j)的区间的数字和，然后在求某一个区间和时，就利用其四个顶点的区间和关系可以快速求出。
 *
 * 时间复杂度:
 *     查询和修改的复杂度均为O(logn)
 */

//重点掌握该方法
public class NumMatrix_BinaryIndexedTree {
    int row, col;
    int[][] matrix;
    int[][] bit;

    public NumMatrix_BinaryIndexedTree(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return;
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        bit = new int[row+1][col+1];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                init(r, c, matrix[r][c]);
            }
        }
    }

    public void init(int r, int c, int val) {
        for (int i = r+1; i <= row; i += (i & (-i))) {
            for (int j = c+1; j <= col; j += (j & (-j))) {
                bit[i][j] += val;
            }
        }
    }

    public void update(int r, int c, int val) {
        int diff = val - matrix[r][c];
        init(r, c, diff);
        matrix[r][c] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1,col2+1) - getSum(row2+1, col1) - getSum(row1, col2+1) + getSum(row1, col1);
    }

    public int getSum(int r, int c) {
        int res = 0;
        for (int i = r; i > 0; i -= (i & (-i))) {
            for (int j = c; j > 0; j -= (j & (-j))) {
                res += bit[i][j];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix_BinaryIndexedTree numMatrix_segmentTree = new NumMatrix_BinaryIndexedTree(matrix);
        numMatrix_segmentTree.update(3, 2, 2);
        System.out.println(numMatrix_segmentTree.sumRegion(2, 1, 4, 3));
    }

}

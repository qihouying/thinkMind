package com.qhy.FLag;

/**
 * Created by dream on 2019/3/20.
 */
public class MatrixFind {
    public boolean find(int[][] matrix, int target) {
        int colNum = matrix[0].length;
        int rowNum = matrix.length;
        for (int i = 0; i < rowNum;) {
            for (int j = colNum-1; j >= 0; ) {
                if (matrix[i][j] > target) {
                    colNum--;
                    j--;
                } else if (matrix[i][j] < target) {
                    i++;
                    rowNum--;
                } else if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        MatrixFind matrixFind = new MatrixFind();
        System.out.println(matrixFind.find(matrix, 7));

    }
}

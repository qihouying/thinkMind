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
 * Approach 1: Segment Tree (2D)
 * 该题与 Range Sum Query - Mutable 相同，只不过是将原来的一维数组转换成了二维矩阵。
 * 但是解法仍然相同，只需要在线段树的结构上进行稍微的调整即可。
 * 根据需求，我们需要构建2D Segment Tree。依然是使用Divide and Conquer的思想。
 * 我们要把整个平面分成 4 个部分，每个节点有四个子节点，NW, NE, SW, SE，节点的 sum 是四个子节点的 sum 之和。
 * 这样我们就可以用与 1D Segment Tree 类似的方法来写 rangeSum 以及 update。
 *
 * 注意：进行查询时因为是二维结构，因此总共有四块部分。要考虑的情况比较复杂一些。
 * 我们可以试着这样进行 Divide：
 * 首先考虑查询范围只分布在上半部分，然后再对上半部分分为左右两块进行讨论。（左，右，横跨左右）
 * 然后考虑查询范围只分布在下半部分，然后再对下半部分分为左右两块进行讨论。（左，右，横跨左右）
 * 如果均不符合以上情况，说明查询范围横跨上下两个部分，然后同样将其分为左右两块进行讨论（左，右，横跨整个矩阵）
 */

//To use segment is too complex!!!
public class NumMatrix_SegmentTree {
    private class SegmentTreeNode2D {
        public int tlRow;
        public int tlCol;
        public int brRow;
        public int brCol;
        public int sum;
        public SegmentTreeNode2D nw, ne, sw, se;

        public SegmentTreeNode2D(int tlRow, int tlCol, int brRow, int brCol) {
            this.tlRow = tlRow;
            this.tlCol = tlCol;
            this.brRow = brRow;
            this.brCol = brCol;
            this.sum = 0;
        }
    }
    public SegmentTreeNode2D root;

    public NumMatrix_SegmentTree(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        root = buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private SegmentTreeNode2D buildTree(int[][] matrix, int tlRow, int tlCol, int brRow, int brCol) {
        if(tlRow > brRow || tlCol > brCol) {
            return null;
        } else {
            SegmentTreeNode2D node = new SegmentTreeNode2D(tlRow, tlCol, brRow, brCol);
            if(tlRow == brRow && tlCol == brCol) {
                node.sum = matrix[tlRow][tlCol];
            } else {
                int rowMid = tlRow + (brRow - tlRow) / 2;
                int colMid = tlCol + (brCol - tlCol) / 2;
                node.nw = buildTree(matrix, tlRow, tlCol, rowMid, colMid);
                node.ne = buildTree(matrix, tlRow, colMid + 1, rowMid, brCol);
                node.sw = buildTree(matrix, rowMid + 1, tlCol, brRow, colMid);
                node.se = buildTree(matrix, rowMid + 1, colMid + 1, brRow, brCol);
                node.sum = 0;
                if(node.nw != null) {
                    node.sum += node.nw.sum;
                }
                if(node.ne != null) {
                    node.sum += node.ne.sum;
                }
                if(node.sw != null) {
                    node.sum += node.sw.sum;
                }
                if(node.se != null) {
                    node.sum += node.se.sum;
                }
            }
            return node;
        }
    }

    public void update(int row, int col, int val) {
        update(root, row, col, val);
    }

    private void update(SegmentTreeNode2D node, int row, int col, int val) {
        if(node.tlRow == row && node.brRow == row && node.tlCol == col && node.brCol == col) {
            node.sum = val;
            return;
        }
        int rowMid = node.tlRow + (node.brRow - node.tlRow) / 2;
        int colMid = node.tlCol + (node.brCol - node.tlCol) / 2;
        if(row <= rowMid) {
            if(col <= colMid) {
                update(node.nw, row, col, val);
            } else {
                update(node.ne, row, col, val);
            }
        } else {
            if(col <= colMid) {
                update(node.sw, row, col, val);
            } else {
                update(node.se, row, col, val);
            }
        }

        node.sum = 0;
        if(node.nw != null) {
            node.sum += node.nw.sum;
        }
        if(node.ne != null) {
            node.sum += node.ne.sum;
        }
        if(node.sw != null) {
            node.sum += node.sw.sum;
        }
        if(node.se != null) {
            node.sum += node.se.sum;
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }

    private int sumRegion(SegmentTreeNode2D node, int tlRow, int tlCol, int brRow, int brCol) {
        if(node.tlRow == tlRow && node.tlCol == tlCol && node.brRow == brRow && node.brCol == brCol) {
            return node.sum;
        }
        int rowMid = node.tlRow + (node.brRow - node.tlRow) / 2;
        int colMid = node.tlCol + (node.brCol - node.tlCol) / 2;
        if(brRow <= rowMid) {  // top-half plane
            if(brCol <= colMid) {         // north-west quadrant
                return sumRegion(node.nw, tlRow, tlCol, brRow, brCol);
            } else if(tlCol > colMid) {    // north-east quadrant
                return sumRegion(node.ne, tlRow, tlCol, brRow, brCol);
            } else {                // intersection between nw and ne
                return sumRegion(node.nw, tlRow, tlCol, brRow, colMid) + sumRegion(node.ne, tlRow, colMid + 1, brRow, brCol);
            }
        } else if(tlRow > rowMid) {         // bot-half plane
            if(brCol <= colMid) {         // south-west quadrant
                return sumRegion(node.sw, tlRow, tlCol, brRow, brCol);
            } else if(tlCol > colMid) {    // south-east quadrant
                return sumRegion(node.se, tlRow, tlCol, brRow, brCol);
            } else {                //intersection between sw and sw
                return sumRegion(node.sw, tlRow, tlCol, brRow, colMid) + sumRegion(node.se, tlRow, colMid + 1, brRow, brCol);
            }
        } else {                // full-plane intersection
            if(brCol <= colMid) {         // left half plane
                return sumRegion(node.nw, tlRow, tlCol, rowMid, brCol) + sumRegion(node.sw, rowMid + 1, tlCol, brRow, brCol) ;
            } else if(tlCol > colMid) {    // right half plane
                return sumRegion(node.ne, tlRow, tlCol, rowMid, brCol) + sumRegion(node.se, rowMid + 1, tlCol, brRow, brCol) ;
            } else {                // full-plane intersection
                return sumRegion(node.nw, tlRow, tlCol, rowMid, colMid)
                        + sumRegion(node.ne, tlRow, colMid + 1, rowMid, brCol)
                        + sumRegion(node.sw, rowMid + 1, tlCol, brRow, colMid)
                        + sumRegion(node.se, rowMid + 1, colMid + 1, brRow, brCol);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix_SegmentTree numMatrix_segmentTree = new NumMatrix_SegmentTree(matrix);
        numMatrix_segmentTree.update(3, 2, 2);
        System.out.println(numMatrix_segmentTree.sumRegion(2, 1, 4, 3));

    }

}

package com.qhy.practice.a20181027.arithmeticSlices_413;

/**
 * Created by dream on 2018/10/29.
 *
 * not understand
 *
 *
 * From the dpdp solution, we can observe that for kk consecutive elements sastisfying the common
 * difference criteria, we update the sumsum for each such element by 1, 2, 3, ..., k1,2,3,...,k
 * counts in that order. Thus, instead of updating the sumsum at the same time, we can just keep a
 * track of the number of consecutive elements satisfying the common differnce criteria in a countcount
 * variable and just update the sumsum directly as count*(count+1)/2count∗(count+1)/2 whenver an element
 * not satisfying this criteria is found. At the same time, we also need to reset the countcount value.
 */
public class Solution5 {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] -A[i-2]) {
                count++;
            } else {
                sum += (count+1)*(count)/2;
                count = 0;
            }
        }
        return count;
    }
}

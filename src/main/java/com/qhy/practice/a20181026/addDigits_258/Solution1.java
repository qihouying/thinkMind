package com.qhy.practice.a20181026.addDigits_258;

/**
 * Created by dream on 2018/10/27.
 *
 * Given a non-negative integer num , repeatedly add all its digits until the result has only one digit.
     For example:
     Given num = 38 , the process is like: 3 + 8 = 11 , 1 + 1 = 2 . Since 2 has only one digit, return it.
     Follow up:
     Could you do it without any loop/recursion in O(1) runtime?
         1. A naive implementation of the above process is trivial. Could yLeou come up with other methods?
         2. What are all the possible results?
         3. How do they occur, periodically or randomly?
         4. YoumayfindthisWikipediaarticleuseful.
 */
public class Solution1 {
    public int addDigits(int num) {
        int res = num % 9;
        return (res != 0 || num == 0)? res : 9;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.addDigits(897));
    }
}

package com.qhy.practice.a20181201.countPrimes_204;

/**
 * Created by dream on 2018/12/13.
 *
 * Description:
 Count the number of prime numbers less than a non-negative number,n. Credits:
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <=2)
            return 0;
        Boolean[] isPassed = new Boolean[n];
        for (int i = 0; i < n; i++) {
            isPassed[i] = false;
        }
        int sum = 1;
        int upper = (int)Math.sqrt(n);
        for (int i = 3; i < n; i+=2) {
            if (!isPassed[i]) {
                sum++;
                if (i>upper)
                    continue;
                for (int j = i*i; j < n; j+=i) {
                    isPassed[j] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(9));
    }
}

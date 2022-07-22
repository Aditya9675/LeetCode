/*

Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106

*/

class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        
        boolean[] primes = new boolean[n];
        int count = 1;
        for(int p = 3; p < n; p += 2) {
            if(!primes[p]) {
                count++;
                for(int i = p * 3; i < n; i += p * 2)
                    primes[i] = true;
            }
        }
                
        return count;
    }
}

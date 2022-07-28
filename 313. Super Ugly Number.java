/*

A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
Example 2:

Input: n = 1, primes = [2,3,5]
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
 

Constraints:

1 <= n <= 105
1 <= primes.length <= 100
2 <= primes[i] <= 1000
primes[i] is guaranteed to be a prime number.
All the values of primes are unique and sorted in ascending order.
*/


class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        
        int[] mul = new int[m];
        
        Arrays.fill(mul, 0);
        
        int[] dp = new int[n];
        
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            
            int temp1 = -1;
            
            for (int j = 0; j < m; j++) {
                int temp2 = dp[mul[j]] * primes[j];
                
                if (dp[i] > temp2) {
                    dp[i] = temp2;
                    
                    temp1 = j;
                } else if (dp[i] == temp2)
                    mul[j] = mul[j] + 1;
            }
            
            mul[temp1] = mul[temp1] + 1;
        }
        
        return dp[n - 1];
    }
}

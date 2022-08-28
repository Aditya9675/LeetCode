/*

Given an integer n, return the largest palindromic integer that can be represented as the product of two n-digits integers. Since the answer can be very large, return it modulo 1337.

 

Example 1:

Input: n = 2
Output: 987
Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
Example 2:

Input: n = 1
Output: 9
 

Constraints:

1 <= n <= 8

*/

class Solution {
    public int largestPalindrome(int n) {
         
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        int max_11 = (max / 11)  * 11;
        long product;
        for (int i=max; i > (int) Math.pow(10, n-1); i--){
            product = Long.parseLong(i + new StringBuilder(String.valueOf(i)).reverse().toString());
            for (long j = max_11; j > (int) Math.pow(10, n-1); j-=11) {
                if ((product/j) / (max+1) == 0){ 
                    if (product%j==0) return (int)(product% 1337);
                }
                else break;
            }
        }
        return -1;
    }
}

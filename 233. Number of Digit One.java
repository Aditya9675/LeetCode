/*

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 

Example 1:

Input: n = 13
Output: 6
Example 2:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 109

*/

class Solution {
    public int countDigitOne(int n) {
        int res = 0;
       long a = 0;
       long b = 0;
       for(long m=1;m<=n;m*=10){
           a = n/m;
           b = n%m;
           if(a % 10 > 1){
               res += a/10 * m + m;
           }else if( a%10 == 1){
               res += a/10 * m + b + 1;
           }else{
               res += a/10 * m;
           }
       }
        return res;
    }
}

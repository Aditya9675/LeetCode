/*

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.
 

Constraints:

-231 <= n <= 231 - 1


*/

class Solution {
    public boolean isUgly(int num) {
    if(num==0) return false;
    if(num==1) return true;
 
    if(num%2==0){
        num=num/2;
        return isUgly(num);
    }
 
    if(num%3==0){
        num=num/3;
        return isUgly(num);
    }
 
    if(num%5==0){
        num=num/5;
        return isUgly(num);
    }
 
    return false;
    }
}

/*

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 
 
 */

class Solution {
    public boolean isPowerOfThree(int n) {
    
    int c=0;
    boolean x=false;
    if(n!=0){
    while(c==0){
        if(n==1){
            x=true;
            break;
        }
        c=n%3;
        n=n/3;
    }
    }
    return x;
    }
}

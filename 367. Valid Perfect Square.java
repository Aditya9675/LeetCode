/*

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1

*/
class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i * i <= num; i++) {
            if ((num % i == 0) && (num / i == i)) {
                return true;
            }
        }
        return false; 
    }
}

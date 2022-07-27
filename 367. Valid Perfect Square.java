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
          long l = 1;
    long r = num;

    while (l < r) {
      final long m = (l + r) / 2;
      if (m >= num / m)
        r = m;
      else
        l = m + 1;
    }

    return l * l == num; 
    }
}

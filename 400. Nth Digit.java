/*

Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

Example 1:

Input: n = 3
Output: 3
Example 2:

Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 

Constraints:

1 <= n <= 231 - 1

*/
class Solution {
    public int findNthDigit(int n) {
        int digitSize = 1;
    int startNum = 1;
    long count = 9;

    while (digitSize * count < n) {
      n -= digitSize * count;
      ++digitSize;
      startNum *= 10;
      count *= 10;
    }

    final int targetNum = startNum + (n - 1) / digitSize;
    final int index = (n - 1) % digitSize;
    return String.valueOf(targetNum).charAt(index) - '0';
    }
}

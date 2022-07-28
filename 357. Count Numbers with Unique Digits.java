/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

 

Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
Example 2:

Input: n = 0
Output: 1
 

Constraints:

0 <= n <= 8

*/

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] arr = new int[n+1];
    arr[0]=1;
 
    for(int i=1; i<=n; i++){
        arr[i]=9;
        for(int j=9; j>=9-i+2; j--){
            arr[i] *= j;
        }
    }
 
    int result =0;
    for(int i: arr)
        result += i;
 
    return result;
    }
}

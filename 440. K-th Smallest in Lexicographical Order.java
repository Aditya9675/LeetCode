/*

Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

 

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
Example 2:

Input: n = 1, k = 1
Output: 1
 

Constraints:

1 <= k <= n <= 109


*/


class Solution {
    
    private int countSteps(long left, long right, int n) {
        int res = 0;
        while(left <= n || right <= n) {
            res += Math.min(n+1, right) - left;
            left *= 10;
            right *= 10;
        }
        return res;
    }
    public int findKthNumber(int n, int k) {
        if(k == 0) return 0;
        int curr = 1;
        k--;
        while(k > 0) {
            int steps = countSteps(curr, curr+1, n);
            if(steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
}


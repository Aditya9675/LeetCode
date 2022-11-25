/*

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

*/

class Solution {
  public int sumSubarrayMins(int[] arr) {
    final int kMod = 1_000_000_007;
    final int n = arr.length;
    long ans = 0;
   
    int[] prev = new int[n];
    
    int[] next = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();

    Arrays.fill(prev, -1);
    Arrays.fill(next, n);

    for (int i = 0; i < arr.length; ++i) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        final int index = stack.pop();
        next[index] = i;
      }
      if (!stack.isEmpty())
        prev[i] = stack.peek();
      stack.push(i);
    }

    for (int i = 0; i < arr.length; ++i) {
      ans += (long) arr[i] * (i - prev[i]) * (next[i] - i);
      ans %= kMod;
    }

    return (int) ans;
  }
}

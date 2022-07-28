/*

Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

 

Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105

*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
    final int m = matrix.length;
    final int n = matrix[0].length;
    int ans = Integer.MIN_VALUE;

    for (int baseCol = 0; baseCol < n; ++baseCol) {
      
      int[] sums = new int[m];
      for (int j = baseCol; j < n; ++j) {
        for (int i = 0; i < m; ++i)
          sums[i] += matrix[i][j];
        
        TreeSet<Integer> accumulate = new TreeSet<>(Arrays.asList(0));
        int prefix = 0;
        for (final int sum : sums) {
          prefix += sum;
          final Integer lo = accumulate.ceiling(prefix - k);
          if (lo != null)
            ans = Math.max(ans, prefix - lo);
          accumulate.add(prefix);
        }
      }
    }

    return ans;
    }
}

/*

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100

*/

class Solution {
    public int maxCoins(int[] nums) {
         final int n = nums.length;

    A = new int[n + 2];

    System.arraycopy(nums, 0, A, 1, n);
    A[0] = 1;
    A[n + 1] = 1;

   
    dp = new int[n + 2][n + 2];
    return maxCoins(1, n);
  }

  private int[][] dp;
  private int[] A;

  private int maxCoins(int i, int j) {
    if (i > j)
      return 0;
    if (dp[i][j] > 0)
      return dp[i][j];

    for (int k = i; k <= j; ++k)
      dp[i][j] = Math.max(dp[i][j],
                          maxCoins(i, k - 1) +
                          maxCoins(k + 1, j) +
                          A[i - 1] * A[k] * A[j + 1]);

    return dp[i][j];
    }
}

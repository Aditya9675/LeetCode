/*

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
 

Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105

*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

   
    int ans = 0;
    int[] dp = new int[envelopes.length];

    for (int[] e : envelopes) {
      int i = Arrays.binarySearch(dp, 0, ans, e[1]);
      if (i < 0)
        i = -(i + 1);
      dp[i] = e[1];
      if (i == ans)
        ++ans;
    }

    return ans;
    }
}
    

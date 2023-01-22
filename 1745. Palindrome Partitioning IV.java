/*

Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed.

 

Example 1:

Input: s = "abcbdd"
Output: true
Explanation: "abcbdd" = "a" + "bcb" + "dd", and all three substrings are palindromes.
Example 2:

Input: s = "bcbddxy"
Output: false
Explanation: s cannot be split into 3 palindromes.
 

Constraints:

3 <= s.length <= 2000
s​​​​​​ consists only of lowercase English letters.

*/

class Solution {
    public boolean checkPartitioning(String s) {
    final int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for(int i = 0; i < n; ++i)
      dp[i][i] = true;

    for(int d = 1; d < n; ++d)
      for(int i = 0; i + d < n; ++i) {
        final int j = i + d;
        if(s.charAt(i) == s.charAt(j))
          dp[i][j] = i + 1 > j - 1 || dp[i + 1][j - 1];
      }

    for(int i = 0; i < n; ++i)
      for(int j = i + 1; j < n; ++j)
        if(dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1])
          return true;

    return false;    
    }
}

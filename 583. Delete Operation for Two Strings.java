/*

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

 

Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4
 

Constraints:

1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.

*/

class Solution {
    public int minDistance(String word1, String word2) {
        final int k =lcs(word1, word2);
        return(word1.length()-k)+(word2.length()-k);
    }
    private int lcs(final String A, final String B){
        final int m=A.length();
        final int n=B.length();
        int[][] dp=new int [m+1][n+1];
        
        for(int i=1;i<=m;i++)
        for(int j=1;j<=n;++j)
        if(A.charAt(i-1)==B.charAt(j-1))
        dp[i][j]=1+dp[i-1][j-1];
        else
        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

    return dp[m][n];    
    }
}

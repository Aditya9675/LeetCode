/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase English letters only.

*/


class Solution {
    public int minCut(String s) {
        int n = s.length();
 
	boolean dp[][] = new boolean[n][n];
	int cut[] = new int[n];
 
	for (int j = 0; j < n; j++) {
		cut[j] = j; 
		for (int i = 0; i <= j; i++) {
			if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1])) {
				dp[i][j] = true;
 
				
				if (i > 0){
					cut[j] = Math.min(cut[j], cut[i-1] + 1);
				}else{
				
					cut[j] = 0; 
				}	
			}
		}
	}
 
	return cut[n-1];
    }
}

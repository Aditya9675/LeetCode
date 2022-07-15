/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m non-empty substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 
 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        char[] a3 = s3.toCharArray();
        int[][] dp = new int[a1.length+1][a2.length+1];
        
        return helper(a1, a2,a3,0,0,0,dp);
    }
    boolean helper(char[] a1, char[] a2, char[] a3, int i1, int i2, int i3, int[][] dp) {
        if(i1==a1.length && i2==a2.length && i3==a3.length) return true;
        
        if(dp[i1][i2]!=0) return false;
        
        if(i1<a1.length && a1[i1]==a3[i3] ) {
            if(helper(a1, a2, a3, i1+1, i2, i3+1,dp)) return true;
           
        }
        if(i2<a2.length && a2[i2]==a3[i3]){
            if(helper(a1, a2, a3, i1, i2+1, i3+1, dp)) return true;
        }
        dp[i1][i2]=1;
        
        return false;
    }
}

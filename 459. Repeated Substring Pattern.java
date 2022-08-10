/*

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int count = n / 2; count >= 1; count --) {
            if (n % count == 0) {
                int num = n / count;
                StringBuilder sb = new StringBuilder();
                String cand = s.substring(0, count);
                for (int j = 0; j < num; j ++) {
                    sb.append(cand); 
                }
                if (sb.toString().equals(s)) 
                    return true;
            }
        }
        return false;
    }
}

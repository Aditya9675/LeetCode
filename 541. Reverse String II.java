/*

Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104

*/

class Solution {
    public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < sb.length(); i += 2 * k) {
      int l = i;
      int r = Math.min(i + k - 1, sb.length() - 1);
      while (l < r) {
        sb.setCharAt(l, s.charAt(r));
        sb.setCharAt(r, s.charAt(l));
        ++l;
        --r;
      }
    }

    return sb.toString();
    }
}

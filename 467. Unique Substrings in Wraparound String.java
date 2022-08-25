/*

We define the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this:

"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
Given a string p, return the number of unique non-empty substrings of p are present in s.

 

Example 1:

Input: p = "a"
Output: 1
Explanation: Only the substring "a" of p is in s.
Example 2:

Input: p = "cac"
Output: 2
Explanation: There are two substrings ("a", "c") of p in s.
Example 3:

Input: p = "zab"
Output: 6
Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of p in s.
 

Constraints:

1 <= p.length <= 105
p consists of lowercase English letters.

*/

class Solution {
    public int findSubstringInWraproundString(String p) {
       
    int maxLength = 1;
    int[] count = new int[26]; 

    for (int i = 0; i < p.length(); ++i) {
      if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25))
        ++maxLength;
      else
        maxLength = 1;
      final int index = p.charAt(i) - 'a';
      count[index] = Math.max(count[index], maxLength);
    }

    return Arrays.stream(count).sum();
    }
}

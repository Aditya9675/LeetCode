/*

You are given two strings stamp and target. Initially, there is a string s of length target.length with all s[i] == '?'.

In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.

For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
place stamp at index 0 of s to obtain "abc??",
place stamp at index 1 of s to obtain "?abc?", or
place stamp at index 2 of s to obtain "??abc".
Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e., you cannot place stamp at index 3 of s).
We want to convert s to target using at most 10 * target.length turns.

Return an array of the index of the left-most letter being stamped at each turn. If we cannot obtain target from s within 10 * target.length turns, return an empty array.

 

Example 1:

Input: stamp = "abc", target = "ababc"
Output: [0,2]
Explanation: Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would also be accepted as an answer, as well as some other answers.
Example 2:

Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]
Explanation: Initially s = "???????".
- Place stamp at index 3 to get "???abca".
- Place stamp at index 0 to get "abcabca".
- Place stamp at index 1 to get "aabcaca".
 

Constraints:

1 <= stamp.length <= target.length <= 1000
stamp and target consist of lowercase English letters.

*/

class Solution {
  public int[] movesToStamp(String stamp, String target) {
    List<Integer> ans = new ArrayList<>();
    char[] T = target.toCharArray();
    boolean[] stamped = new boolean[target.length()];
    int stampedCount = 0;

    while (stampedCount < T.length) {
      boolean isStamped = false;
     
      for (int i = 0; i <= T.length - stamp.length(); ++i) {
        if (stamped[i])
          continue;
        final int stampified = stampify(stamp, T, i);
        if (stampified == 0)
          continue;
        stampedCount += stampified;
        isStamped = true;
        stamped[i] = true;
        ans.add(i);
      }
      
      if (!isStamped)
        return new int[] {};
    }

    Collections.reverse(ans);
    return ans.stream().mapToInt(i -> i).toArray();
  }
  private int stampify(final String stamp, char[] T, int s) {
    int stampified = stamp.length();

    for (int i = 0; i < stamp.length(); ++i)
      if (T[s + i] == '*') 
        --stampified;
      else if (T[s + i] != stamp.charAt(i))
        return 0; 

    Arrays.fill(T, s, s + stamp.length(), '*');

    return stampified;
  }
}

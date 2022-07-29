/*

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return all the possible results. You may return the answer in any order.

 

Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]
 

Constraints:

1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s.

*/

class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    final int[] counts = getLeftAndRightCounts(s);
    dfs(s, 0, counts[0], counts[1], ans);
    return ans;
  }

 
  private int[] getLeftAndRightCounts(final String s) {
    int l = 0;
    int r = 0;

    for (final char c : s.toCharArray())
      if (c == '(')
        ++l;
      else if (c == ')') {
        if (l == 0)
          ++r;
        else
          --l;
      }

    return new int[] {l, r};
  }

  private void dfs(final String s, int start, int l, int r, List<String> ans) {
    if (l == 0 && r == 0 && isValid(s)) {
      ans.add(s);
      return;
    }

    for (int i = start; i < s.length(); ++i) {
      if (i > start && s.charAt(i) == s.charAt(i - 1))
        continue;
      if (l > 0 && s.charAt(i) == '(') 
        dfs(s.substring(0, i) + s.substring(i + 1), i, l - 1, r, ans);
      else if (r > 0 && s.charAt(i) == ')') 
        dfs(s.substring(0, i) + s.substring(i + 1), i, l, r - 1, ans);
    }
  }

  private boolean isValid(final String s) {
    int count = 0; 

    for (final char c : s.toCharArray()) {
      if (c == '(')
        ++count;
      else if (c == ')')
        --count;
      if (count < 0)
        return false;
    }

    return true; 
  }
}
    

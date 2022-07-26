/*

Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.

*/

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
    
     List<List<Integer>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>(); 

    for (int i = 0; i < words.length; ++i)
      map.put(new StringBuilder(words[i]).reverse().toString(), i);

    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
    
      if (map.containsKey("") && map.get("") != i && isPalindrome(word))
        ans.add(Arrays.asList(i, map.get("")));
      for (int j = 1; j <= word.length(); ++j) {
        final String l = word.substring(0, j);
        final String r = word.substring(j);
        if (map.containsKey(l) && map.get(l) != i && isPalindrome(r))
          ans.add(Arrays.asList(i, map.get(l)));
        if (map.containsKey(r) && map.get(r) != i && isPalindrome(l))
          ans.add(Arrays.asList(map.get(r), i));
      }
    }

    return ans;
  }

  private boolean isPalindrome(final String word) {
    int l = 0;
    int r = word.length() - 1;
    while (l < r)
      if (word.charAt(l++) != word.charAt(r--))
        return false;
    return true;
    }
}

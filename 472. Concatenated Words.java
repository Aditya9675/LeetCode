/*

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 

Constraints:

1 <= words.length <= 104
1 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
All the strings of words are unique.
1 <= sum(words[i].length) <= 105


*/

class Solution{
    public List<String> findAllConcatenatedWordsInADict(String[] words){
    List<String> ans = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(Arrays.asList(words));
    Map<String, Boolean> memo = new HashMap<>();

    for(final String word : words)
      if (wordBreak(word, wordSet, memo))
        ans.add(word);

    return ans;
  }

  private boolean wordBreak(final String word, Set<String> wordSet, Map<String, Boolean> memo){
    if (memo.containsKey(word))
      return memo.get(word);

    for(int i = 1; i < word.length(); ++i){
      final String prefix = word.substring(0, i);
      final String suffix = word.substring(i);
      if (wordSet.contains(prefix) &&
          (wordSet.contains(suffix) || wordBreak(suffix, wordSet, memo))){
        memo.put(word, true);
        return true;
      }
    }

    memo.put(word, false);
    return false;
    }
}

/*

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

*/


class Solution {
    private int min = Integer.MAX_VALUE >> 1;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> result = new ArrayList<>();
 		Set<String> words = new HashSet<>(wordList);
 		if(!words.contains(endWord)) return result;
 		int len = beginWord.length();
 		List<String> temp = new ArrayList<String>();
 		temp.add(beginWord);
 		dfs(result, words, len, endWord, beginWord, temp);
 		return result;
 	}
 	private void dfs(List<List<String>> result, Set<String> words, int len, String endWord, String cur, List<String> temp){
 		if(cur.equals(endWord)){
 			if(temp.size() < min){
 				result.clear();
 				min = temp.size();
 			}
 			result.add(new ArrayList<String>(temp));
 		}else if(temp.size() < min){
 			for(int i = 0; i < len; i++){
 				char[] arr = cur.toCharArray();
 				for(char c = 'a'; c <= 'z'; c++){
 					arr[i] = c;
 					String next = new String(arr);
 					if(words.contains(next)){
 						words.remove(next);
 						temp.add(next);
 						dfs(result, words, len, endWord, next, temp);
 						temp.remove(temp.size() - 1);
 						words.add(next);
 					}
 				}
 				arr[i] = cur.charAt(i);
 			}
 		}
    }
}

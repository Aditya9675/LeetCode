/*

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/


class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new List[s.length() + 1];
        int len = s.length();
        dp[0] = new ArrayList<>();
        if(len == 0) return dp[0];
        Set<Integer> set = new HashSet<>();
        for(String ss : wordDict)
            set.add(ss.length());
        for(int i = 1; i <= len; i++){
            dp[i] = new ArrayList<>();
            for(Integer in : set){
                if(i - in >= 0){
                    String sub = s.substring(i - in, i);
                    if(wordDict.contains(sub)){
                        List<String> tmp = dp[i - in];
                        if(i - in == 0)
                            dp[i].add(sub);
                        else{
                            for(String ss : tmp){
                                dp[i].add(ss + " " + sub);
                            }
                        }
                    }
                }
            }
        }
        return dp[len];
        
    }
}

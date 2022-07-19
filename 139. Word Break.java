/*

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}

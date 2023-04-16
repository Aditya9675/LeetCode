/*

You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

 

Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
Example 2:

Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 1000
All strings in words have the same length.
1 <= target.length <= 1000
words[i] and target contain only lowercase English letters.


*/


class Solution {
    public int numWays(String[] words, String target) {
     final int MODULO = 1000000007;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int targetLength = target.length();
        int wordLength = words[0].length();
        if(targetLength > wordLength)
            return 0;
        for(String word : words){
            for(int i = 0; i <wordLength; i++){
                int letterIndex = word.charAt(i) - 'a';
                int key = i * 26 + letterIndex;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
            }
        }
        long[][] dp = new long[targetLength][wordLength];
        int letterIndex0 = target.charAt(0) - 'a';
        int maxStart0 = wordLength - targetLength;
        for(int j = 0; j <= maxStart0; j++){
            int key= j * 26 + letterIndex0;
            dp[0][j]=map.getOrDefault(key,0);
            if(j>0)
                dp[0][j] = (dp[0][j - 1] + dp[0][j]) % MODULO;
        }
        for(int i = 1; i <targetLength; i++){
            int letterIndex = target.charAt(i) - 'a';
            int maxStart = wordLength - targetLength + i;
            for(int j = i; j <= maxStart; j++){
                int key = j * 26 + letterIndex;
                long curCount = map.getOrDefault(key,0);
                if(curCount >0)
                    dp[i][j] = dp[i - 1][j - 1] * curCount % MODULO;
                if(j>i)
                    dp[i][j] = (dp[i][j - 1] + dp[i][j]) % MODULO;
            }
        }
        return (int) dp[targetLength - 1][wordLength - 1];    
    }
}

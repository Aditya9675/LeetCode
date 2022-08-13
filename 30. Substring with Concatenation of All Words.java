/*

You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.

*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || words[0].length() == 0 || s.length() == 0) return res;
        int wordLen = words[0].length();
        int wordNum = words.length;
        int windowSize = wordLen * wordNum;
        Map<String,Integer> map = new HashMap<>();
        
        for(String eachWord : words) {
            map.put(eachWord,map.getOrDefault(eachWord,0) + 1);
        }
       
        for(int i = 0;i + windowSize - 1 < s.length();i++) {
            String lastWord = s.substring(i + windowSize - wordLen,i + windowSize);
            if(map.containsKey(lastWord)) {
                boolean bre = false;
                Map<String,Integer> currMap = new HashMap<>(map);
                for(int j = i;j < i + windowSize;j += wordLen) {
                    String currWord = s.substring(j,j + wordLen);
                    currMap.put(currWord,currMap.getOrDefault(currWord,0) - 1);
                    if(currMap.get(currWord) < 0) {
                        bre = true;
                        break;
                    }
                }
                if(!bre)res.add(i);
            }
        }
        return res;
    }
}

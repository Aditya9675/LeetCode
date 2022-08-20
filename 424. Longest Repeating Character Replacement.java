/*

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

*/

class Solution {
    public int characterReplacement(String s, int k) {
        
    int start=0;
    int longCharCount=0;
    Map<Character, Integer> map = new HashMap<>();
    int maxLength=0;

    for(int end=0;end<s.length();end++){
        char endchar = s.charAt(end);
        map.put(endchar, map.getOrDefault(endchar,0)+1);
        longCharCount = Math.max(longCharCount, map.get(endchar));
        
        if(end-start+1-longCharCount >k){
            char startChar=s.charAt(start);
            map.put(startChar, map.getOrDefault(startChar,0)-1);
            start++;
        }
        
        maxLength = Math.max(maxLength, end-start+1);
    }
    
    return maxLength;
    }
}


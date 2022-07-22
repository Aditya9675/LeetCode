/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null)
        return false;
 
    if(s.length()!=t.length())
        return false;
 
    int[] arr = new int[26];
    for(int i=0; i<s.length(); i++){
        arr[s.charAt(i)-'a']++;
        arr[t.charAt(i)-'a']--;
    }
 
    for(int i: arr){
        if(i!=0)
            return false;
    }
 
    return true;
    }
}

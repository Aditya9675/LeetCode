/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
        return false;
    }
 
    HashMap<Character, Character> map1 = new HashMap<>();
    HashMap<Character, Character> map2 = new HashMap<>();
 
    for(int i=0; i<s.length(); i++){
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);
 
        if(map1.containsKey(c1)){
            if(c2!=map1.get(c1)){
                return false;
            }
        }else{
            if(map2.containsKey(c2)){
                return false;
            }
 
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
    }
 
    return true;
    }
}

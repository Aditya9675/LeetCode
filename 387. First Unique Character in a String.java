/*

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

*/

class Solution {
    public int firstUniqChar(String s) {
         Map<Character, Integer> occurrences = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = occurrences.get(c);
            if (count == null) {
                occurrences.put(c, 1);
            } else {
                occurrences.put(c, ++count);
            }
        }
        for (int i = 0; i< s.length(); i++) {
            if (occurrences.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

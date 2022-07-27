/*

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.


*/

class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] sarr = s.toCharArray();
        while(i < j) {
            if(!s.substring(i, i+1).matches("[aeiouAEIOU]")) {
                i++;
            } else if(!s.substring(j, j+1).matches("[aeiouAEIOU]")) {
                j--;
            } else {
                char temp = sarr[i];
                sarr[i] = sarr[j];
                sarr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(sarr);
    }
}

/*
Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.
  */
  

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for (String word : d) {
            if (isSubsequence(word, s)) {
                if (word.length() > max_str.length()
                        || (word.length() == max_str.length() && word.compareTo(max_str) < 0) ) {
                    max_str = word;
                }
            }
        }
        return max_str;
    }

    public boolean isSubsequence(String str1, String str2) {
        int index1 = 0;
        for (int index2 = 0; index2 < str2.length() && index1 < str1.length(); index2++) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
            }
        }
        return index1 == str1.length();
    }
}
  

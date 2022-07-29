/*

Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.


*/

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0)
            return res;

        for(String word: words) {
            if(match(word, pattern))
                res.add(word);
        }

        return res;
    }

    public boolean match(String word, String pattern) {
        if(pattern.length() != word.length())
            return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            char c2 = word.charAt(i);

            if(map1.containsKey(c1) && !map2.containsKey(c2))
                return false;
            if(!map1.containsKey(c1) && map2.containsKey(c2))
                return false;

            if(map1.containsKey(c1) && map2.containsKey(c2)) {
                if(c1 != map2.get(c2) || c2 != map1.get(c1))
                    return false;
            } else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
}

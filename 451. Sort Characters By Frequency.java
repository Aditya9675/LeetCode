/*

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.


*/

class Solution {
    public String frequencySort(String s) {
    int[][] count = new int[256][2];

  for(char c: s.toCharArray()) {
    count[c][0] = c;
    count[c][1]++;
  }

  Arrays.sort(count, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
      return a[1] == b[1] ? 0 : (a[1] < b[1] ? 1 : -1);
    }
  });


  StringBuilder sb = new StringBuilder();
  for(int i=0; i<256; i++) {
    if (count[i][1] > 0) {
      for(int j=0; j<count[i][1]; j++) {
        sb.append((char)count[i][0]);
      }
    }
  }

  return sb.toString();
    }
}

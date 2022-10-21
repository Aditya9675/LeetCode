/*

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 

*/

class Solution{
    public String[] findWords(String[] words){
        List<String> sameRowList = new ArrayList<String>();
        for(String word : words){
           if(findWordInSameRow(word)){
               sameRowList.add(word);
           }
        }
        String[] samwWords = new String[sameRowList.size()];
        samwWords = sameRowList.toArray(samwWords);
        return samwWords;
    }

    public boolean findWordInSameRow(String word){
        String keyBoard = "qwertyuiopasdfghjkl&zxcvbnm&&&";
        char[] charWord = word.toLowerCase().toCharArray();
        int row = keyBoard.indexOf(charWord[0]) / 10;
        for(char c : charWord){
            if(row != keyBoard.indexOf(c) / 10){
                return false; 
            }
        }
        return true;
    }
}

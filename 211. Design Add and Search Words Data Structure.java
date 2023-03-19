/*

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

*/


class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        private final int N = 26;
        
        TrieNode() {
            children = new TrieNode[N];
        }
    }
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.isWord = true;
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }
    
    private boolean dfsSearch(TrieNode cur, String word, int i) {
        if(cur == null) 
         return false;
        if(i == word.length()) 
        return cur.isWord;
        char c = word.charAt(i);
        if(c == '.'){
            for(int j = 0; j < 26; j++){
                if(dfsSearch(cur.children[j],word, i+1)){
                    return true;
                }
            }
            return false;
        } 
     else{
            return dfsSearch(cur.children[c - 'a'], word, i + 1);
        }
    }
}

//Aditya Sharma

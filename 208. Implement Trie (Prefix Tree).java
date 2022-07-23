/*

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

*/


class Trie {
  
  private TrieNode root;
  
  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new TrieNode());
      }
      curr = curr.children.get(c);
    }
    curr.isWord = true;
  }

  public boolean search(String word) {
    TrieNode searchNode = searchHelper(word);
    return searchNode != null && searchNode.isWord;
  }

  public boolean startsWith(String prefix) {
    return searchHelper(prefix) != null;
  }
  
  private TrieNode searchHelper(String s) {
    TrieNode curr = root;
    for (char c : s.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        return null;
      }
      curr = curr.children.get(c);
    }
    return curr;
  }
  
  private class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    
    public TrieNode() {
      this.children = new HashMap<>();
    }
  }
}

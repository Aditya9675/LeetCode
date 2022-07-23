/*

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

*/

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String s : words) root.add(s, 0);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, i, j, root.next[board[i][j] - 'a'], res);
            }
        }
        return new ArrayList<>(res);
    }
    
    private void find(char[][] board, int i, int j, TrieNode root, Set<String> res) {
        if (root == null) return;
        if (root.word != null) res.add(root.word);
        char c = board[i][j];
        board[i][j] = 'z' + 1;
        if (i > 0) find(board, i - 1, j, root.next[board[i - 1][j] - 'a'], res);
        if (j > 0) find(board, i, j - 1, root.next[board[i][j - 1] - 'a'], res);
        if (i < board.length - 1) find(board, i + 1, j, root.next[board[i + 1][j] - 'a'], res);
        if (j < board[0].length - 1) find(board, i, j + 1, root.next[board[i][j + 1] - 'a'], res);        
        board[i][j] = c;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[27];
        String word;
        public void add(String s, int index) {
            char c = s.charAt(index);
            if (next[c - 'a'] == null) next[c - 'a'] = new TrieNode();
            if (index + 1 < s.length()) next[c - 'a'].add(s, index + 1);
            else next[c - 'a'].word = s;
        }
    }
}




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
    
        ArrayList<String> result = new ArrayList<String>();
 
	int m = board.length;
	int n = board[0].length;
 
	for (String word : words) {
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char[][] newBoard = new char[m][n];
				for (int x = 0; x < m; x++)
					for (int y = 0; y < n; y++)
						newBoard[x][y] = board[x][y];
 
				if (dfs(newBoard, word, i, j, 0)) {
					flag = true;
				}
			}
		}
		if (flag) {
			result.add(word);
		}
	}
 
	return result;
}
 
public boolean dfs(char[][] board, String word, int i, int j, int k) {
	int m = board.length;
	int n = board[0].length;
 
	if (i < 0 || j < 0 || i >= m || j >= n || k > word.length() - 1) {
		return false;
	}
 
	if (board[i][j] == word.charAt(k)) {
		char temp = board[i][j];
		board[i][j] = '#';
 
		if (k == word.length() - 1) {
			return true;
		} else if (dfs(board, word, i - 1, j, k + 1)
				|| dfs(board, word, i + 1, j, k + 1)
				|| dfs(board, word, i, j - 1, k + 1)
				|| dfs(board, word, i, j + 1, k + 1)) {
			board[i][j] = temp;
			return true;
		}
 
	} else {
		return false;
	}
 
	return false;
    }
}



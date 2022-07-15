/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            if(dfs(board, word, i, j, 0)){
                return true;
            }
        } 
    }
 
    return false;
}
 
public boolean dfs(char[][] board, String word, int i, int j, int k){
    if(board[i][j]!=word.charAt(k)){
        return false;
    }
 
    if(k>=word.length()-1){
        return true;
    }
 
    int[] di={-1,0,1,0};
    int[] dj={0,1,0,-1};
 
    char t = board[i][j];
    board[i][j]='#';
 
    for(int m=0; m<4; m++){
        int pi=i+di[m];
        int pj=j+dj[m];
        if(pi>=0&&pi<board.length&&pj>=0&&pj<board[0].length&&board[pi][pj]==word.charAt(k+1)){
            if(dfs(board,word,pi,pj,k+1)){
                return true;
            }
        }
    }
 
    board[i][j]=t;
 
    return false;
    }
}

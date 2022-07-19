/*

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

*/


class Solution {
    public void solve(char[][] board) {
         if (board.length == 1 || board[0].length == 1) 
             return;
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') visit(board, 0, i);
            if (board[board.length - 1][i] == 'O') visit(board, board.length - 1, i);
        }
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O') visit(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') visit(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    
    private void visit(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'Y';
        visit(board, i - 1, j);
        visit(board, i + 1, j);
        visit(board, i, j - 1);
        visit(board, i, j + 1);
    }
}

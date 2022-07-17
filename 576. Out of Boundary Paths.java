/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
*/

class Solution {
   
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N + 1][m][n];
        for(int k = 1; k <= N; k++){
            for(int r = 0; r < m; r++){
                for(int c = 0; c < n; c++){
                   
                    int tempRow = 0, tempCol = 0;
                    for(int d = 0; d < 4; d++){
                        
                        tempRow = r + dir[d][0];
                        tempCol = c + dir[d][1];
                        
                        if(tempRow < 0 || tempRow >= m || tempCol < 0 || tempCol >= n){
                          
                            
                            dp[k][r][c] += 1;
                        }
                        else{
                            dp[k][r][c] = (dp[k][r][c] + dp[k - 1][tempRow][tempCol]) % 1000000007;
                        }
                    }
                }
            }
        }
        return dp[N][i][j]; 
    }
}

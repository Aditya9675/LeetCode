/*

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
    
    int result = 0;
    int m = matrix.length;
    int n = matrix[0].length;
 
    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int t = helper(matrix, mem, i, j);
            result = Math.max(result, t);
        }
    }
 
    return result;
}
 
private int helper(int[][] matrix, int[][] mem, int i, int j) {
    if (mem[i][j] > 0) {
        return mem[i][j];
    }
 
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
 
    for (int k = 0; k < 4; k++) {
        int x = i + dx[k];
        int y = j + dy[k];
 
        if (x >= 0 && y >= 0
                && x < matrix.length
                && y < matrix[0].length
                && matrix[x][y] > matrix[i][j]) {
            mem[i][j] = Math.max(mem[i][j], helper(matrix, mem, x, y));
        }
    }
 
    return ++mem[i][j];
    }
}

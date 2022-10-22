/*

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105

*/
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
    int dir = 0;
    int x = 0;
    int y = 0;
    int numOfRows = mat.length;
    int numOfCols = mat[0].length;
    int[] ans = new int[numOfRows * numOfCols];
    for(int i = 0; i < numOfRows * numOfCols; i++){
      ans[i] = mat[x][y];
      if((x + y) % 2 == 0){
        if(y == numOfCols - 1){
          x++;
        } 
        else if(x == 0){
          y++;
        } 
        else{
          x--;
          y++;
        }
      } 
      else{
        if(x == numOfRows - 1){
          y++;
        } 
        else if(y == 0){
          x++;
        } 
        else{
          x++;
          y--;
        }
      }
    }
    return ans;
    }
}

/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.


*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        Queue<int[]>queue=new LinkedList<>();
        int freshCount=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] DIRS ={{-1,0},{1,0},{0,-1},{0,1}};
        int step=0;
        while(!queue.isEmpty() && freshCount>0){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int[] curr =queue.poll();
                for(int[] dir: DIRS ){
                    int nextX=curr[0]+dir[0];
                    int nextY=curr[1]+dir[1];
                       if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || grid[nextX][nextY] != 1) {
                        continue;                  
                    
                    }
                    queue.offer(new int[]{nextX,nextY});
                    grid[nextX][nextY]=2;
                    freshCount--;
                }
            }
        step++;
        }
    return freshCount==0 ?step:-1;
    }
}

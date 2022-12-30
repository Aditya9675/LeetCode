/*

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.

*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
    final int m =mat.length;
    final int n=mat[0].length;
    final int[]dirs=new int[] {0, 1, 0,-1, 0};
    Queue<int[]>q=new ArrayDeque<>();
    boolean[][]seen=new boolean[m][n];

    for(int i=0;i<m;++i)
      for (intj=0;j<n;++j)
        if(mat[i][j]==0) {
          q.offer(new int[]{i, j});
          seen[i][j]=true;
        }

    while(!q.isEmpty()){
      final int i=q.peek()[0];
      final int j=q.poll()[1];
      for (int k=0;k<4;++k) {
        final int x=i+dirs[k];
        final int y=j+dirs[k + 1];
        if(x<0|| x==m || y<0||y==n)
          continue;
        if(seen[x][y])
          continue;
        mat[x][y]=mat[i][j] +1;
        q.offer(new int[]{x,y});
        seen[x][y] =true;
      }
    }
    return mat;
    }
}


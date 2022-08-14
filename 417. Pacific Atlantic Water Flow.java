/*

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105

*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    
    final int m = heights.length;
    final int n = heights[0].length;
    List<List<Integer>> ans = new ArrayList<>();
    Queue<int[]> qP = new ArrayDeque<>();
    Queue<int[]> qA = new ArrayDeque<>();
    boolean[][] seenP = new boolean[m][n];
    boolean[][] seenA = new boolean[m][n];

    for (int i = 0; i < m; ++i) {
      qP.offer(new int[] {i, 0});
      qA.offer(new int[] {i, n - 1});
      seenP[i][0] = true;
      seenA[i][n - 1] = true;
    }

    for (int j = 0; j < n; ++j) {
      qP.offer(new int[] {0, j});
      qA.offer(new int[] {m - 1, j});
      seenP[0][j] = true;
      seenA[m - 1][j] = true;
    }

    bfs(heights, qP, seenP);
    bfs(heights, qA, seenA);

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        if (seenP[i][j] && seenA[i][j])
          ans.add(new ArrayList<>(Arrays.asList(i, j)));

    return ans;
  }

  private static final int[] dirs = {0, 1, 0, -1, 0};

  private void bfs(int[][] heights, Queue<int[]> q, boolean[][] seen) {
    while (!q.isEmpty()) {
      final int i = q.peek()[0];
      final int j = q.poll()[1];
      final int h = heights[i][j];
      for (int k = 0; k < 4; ++k) {
        final int x = i + dirs[k];
        final int y = j + dirs[k + 1];
        if (x < 0 || x == heights.length || y < 0 || y == heights[0].length)
          continue;
        if (seen[x][y] || heights[x][y] < h)
          continue;
        q.offer(new int[] {x, y});
        seen[x][y] = true;
      }
    }
    }
}

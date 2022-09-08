/*

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104

*/

class T {
  public int i;
  public int j;
  public int h;
  public T(int i, int j, int h) {
    this.i = i;
    this.j = j;
    this.h = h;
  }
}

class Solution {
  public int trapRainWater(int[][] heightMap) {
    final int m = heightMap.length;
    final int n = heightMap[0].length;
    final int[] dirs = {0, 1, 0, -1, 0};
    int ans = 0;
    Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.h - b.h);
    boolean[][] seen = new boolean[m][n];

    for (int i = 0; i < m; ++i) {
      minHeap.offer(new T(i, 0, heightMap[i][0]));
      minHeap.offer(new T(i, n - 1, heightMap[i][n - 1]));
      seen[i][0] = true;
      seen[i][n - 1] = true;
    }

    for (int j = 1; j < n - 1; ++j) {
      minHeap.offer(new T(0, j, heightMap[0][j]));
      minHeap.offer(new T(m - 1, j, heightMap[m - 1][j]));
      seen[0][j] = true;
      seen[m - 1][j] = true;
    }

    while (!minHeap.isEmpty()) {
      final int i = minHeap.peek().i;
      final int j = minHeap.peek().j;
      final int h = minHeap.poll().h;
      for (int k = 0; k < 4; ++k) {
        final int x = i + dirs[k];
        final int y = j + dirs[k + 1];
        if (x < 0 || x == m || y < 0 || y == n)
          continue;
        if (seen[x][y])
          continue;
        if (heightMap[x][y] < h) {
          ans += h - heightMap[x][y];
          minHeap.offer(new T(x, y, h)); 
        } else {
          minHeap.offer(new T(x, y, heightMap[x][y]));
        }
        seen[x][y] = true;
      }
    }

    return ans;
  }
}

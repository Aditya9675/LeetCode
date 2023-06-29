/*

You are given an m x n grid grid where:

'.' is an empty cell.
'#' is a wall.
'@' is the starting point.
Lowercase letters represent keys.
Uppercase letters represent locks.
You start at the starting point and one move consists of walking one space in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.

If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.

For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys. If it is impossible, return -1.

 

Example 1:


Input: grid = ["@.a..","###.#","b.A.B"]
Output: 8
Explanation: Note that the goal is to obtain all the keys not to open all the locks.
Example 2:


Input: grid = ["@..aA","..B#.","....b"]
Output: 6
Example 3:


Input: grid = ["@Aa"]
Output: -1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 30
grid[i][j] is either an English letter, '.', '#', or '@'.
The number of keys in the grid is in the range [1, 6].
Each key in the grid is unique.
Each key in the grid has a matching lock.

  */

class T {
  public int i;
  public int j;
  public int keys; 
  public T(int i, int j, int keys) {
    this.i = i;
    this.j = j;
    this.keys = keys;
  }
}

class Solution {
  public int shortestPathAllKeys(String[] grid) {
    final int m = grid.length;
    final int n = grid[0].length();
    final int keysCount = getKeysCount(grid);
    final int kKeys = (1 << keysCount) - 1;
    final int[] dirs = {0, 1, 0, -1, 0};
    final int[] start = getStart(grid);
    int ans = 0;
    Queue<T> q = new ArrayDeque<>(Arrays.asList(new T(start[0], start[1], 0)));
    boolean[][][] seen = new boolean[m][n][kKeys];
    seen[start[0]][start[1]][0] = true;

    while (!q.isEmpty()) {
      ++ans;
      for (int sz = q.size(); sz > 0; --sz) {
        final int i = q.peek().i;
        final int j = q.peek().j;
        final int keys = q.poll().keys;
        for (int k = 0; k < 4; ++k) {
          final int x = i + dirs[k];
          final int y = j + dirs[k + 1];
          if (x < 0 || x == m || y < 0 || y == n)
            continue;
          final char c = grid[x].charAt(y);
          if (c == '#')
            continue;
          final int newKeys = 'a' <= c && c <= 'f' ? keys | 1 << c - 'a' : keys;
          if (newKeys == kKeys)
            return ans;
          if (seen[x][y][newKeys])
            continue;
          if ('A' <= c && c <= 'F' && (newKeys >> c - 'A' & 1) == 0)
            continue;
          q.offer(new T(x, y, newKeys));
          seen[x][y][newKeys] = true;
        }
      }
    }

    return -1;
  }

  private int getKeysCount(String[] grid) {
    int count = 0;
    for (final String s : grid)
      count += (int) s.chars().filter(c -> 'a' <= c && c <= 'f').count();
    return count;
  }

  private int[] getStart(String[] grid) {
    for (int i = 0; i < grid.length; ++i)
      for (int j = 0; j < grid[0].length(); ++j)
        if (grid[i].charAt(j) == '@')
          return new int[] {i, j};
    throw new IllegalArgumentException();
  }
}

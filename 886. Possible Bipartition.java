/*

We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
*/
enum Color { kWhite, kRed, kGreen }
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
    List<Integer>[] graph = new List[n + 1];
    Color[] colors = new Color[n + 1];
    Arrays.fill(colors, Color.kWhite);

    for (int i = 1; i <= n; ++i)
      graph[i] = new ArrayList<>();

    for (int[] d : dislikes) {
      final int u = d[0];
      final int v = d[1];
      graph[u].add(v);
      graph[v].add(u);
    }
    for (int i = 1; i <= n; ++i)
      if (colors[i] == Color.kWhite && !isValidColor(graph, i, colors, Color.kRed))
        return false;

    return true;
  }

  private boolean isValidColor(List<Integer>[] graph, int u, Color[] colors, Color color) {
    if (colors[u] != Color.kWhite)
      return colors[u] == color;

    colors[u] = color; 

    for (final int v : graph[u])
      if (!isValidColor(graph, v, colors, color == Color.kRed ? Color.kGreen : Color.kRed))
        return false;

    return true;
    }
}

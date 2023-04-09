/*

There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

Example 1:



Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
Example 2:



Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.
 

Constraints:

n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
*/

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
    final int n = colors.length();
    int ans = 0;
    int processed = 0;
    List<Integer>[] graph = new List[n];
    int[] inDegree = new int[n];
    int[][] count = new int[n][26];

    for(int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();


    for(int[] edge : edges){
      final int u = edge[0];
      final int v = edge[1];
      graph[u].add(v);
      ++inDegree[v];
    }

 
    Queue<Integer> q = IntStream.range(0, n)
                           .filter(i -> inDegree[i] == 0)
                           .boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));

    while(!q.isEmpty()){
      final int out = q.poll();
      ++processed;
      ans = Math.max(ans, ++count[out][colors.charAt(out) - 'a']);
      for(final int in : graph[out]) {
        for(int i = 0; i < 26; ++i)
          count[in][i] = Math.max(count[in][i], count[out][i]);
        if(--inDegree[in] == 0)
          q.offer(in);
      }
    }

    return processed == n ? ans : -1;
    
    }
}

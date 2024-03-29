/*
You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.

 

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]
 

Constraints:

1 <= n <= 100
0 <= redEdges.length, blueEdges.length <= 400
redEdges[i].length == blueEdges[j].length == 2
0 <= ai, bi, uj, vj < n

*/

enum Color { kInit, kRed, kBlue }
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    List<Pair<Integer, Color>>[] graph = new List[n];
    Queue<Pair<Integer, Color>> q = new ArrayDeque<>(Arrays.asList(new Pair<>(0, Color.kInit)));

    for(int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();

    for(int[] edge: redEdges){
      final int u = edge[0];
      final int v = edge[1];
      graph[u].add(new Pair<>(v, Color.kRed));
    }

    for(int[] edge:blueEdges){
      final int u = edge[0];
      final int v = edge[1];
      graph[u].add(new Pair<>(v, Color.kBlue));
    }

    for(int step=0;!q.isEmpty(); ++step)
      for(int sz = q.size();sz > 0;--sz){
        final int u = q.peek().getKey();
        Color prevColor = q.poll().getValue();
        ans[u] = ans[u] == -1 ? step : ans[u];
        for (int i = 0; i < graph[u].size(); ++i) {
          Pair<Integer, Color> node = graph[u].get(i);
          final int v = node.getKey();
          Color edgeColor = node.getValue();
          if(v == -1 || edgeColor == prevColor)
            continue;
          q.add(new Pair<>(v, edgeColor));
          graph[u].set(i, new Pair<>(-1, edgeColor));
        }
      }

    return ans;    
    }
}

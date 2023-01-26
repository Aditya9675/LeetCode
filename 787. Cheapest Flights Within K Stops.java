/*

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst


*/


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<Pair<Integer, Integer>>[] graph = new List[n];
    Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
    int[][] dist = new int[n][k + 2];
    Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));

    for(int i = 0; i < n; ++i)
      graph[i] = new ArrayList<>();

    for(int[] f : flights){
      final int u =f[0];
      final int v =f[1];
      final int w =f[2];
      graph[u].add(new Pair<>(v, w));
    }

    minHeap.offer(new int[]{0, src, k + 1}); 
    dist[src][k + 1] = 0;

    while(!minHeap.isEmpty()){
      final int d = minHeap.peek()[0];
      final int u =minHeap.peek()[1];
      final int stops = minHeap.poll()[2];
      if(u==dst)
        return d;
      if(stops>0)
        for(Pair<Integer,Integer>pair :graph[u]){
          final int v = pair.getKey();
          final int w = pair.getValue();
          final int newDist = d + w;
          if(newDist <dist[v][stops-1]){
            dist[v][stops-1]=newDist;
            minHeap.offer(new int[] {d + w, v, stops - 1});
          }
        }
    }

    return -1;    
    }
}

/*

You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

 

Example 1:


Input: parent = [-1,0,0,1,1,2], s = "abacbe"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3 is returned.
It can be proven that there is no longer path that satisfies the conditions. 
Example 2:


Input: parent = [-1,0,0,0], s = "aabc"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.
 

Constraints:

n == parent.length == s.length
1 <= n <= 105
0 <= parent[i] <= n - 1 for all i >= 1
parent[0] == -1
parent represents a valid tree.
s consists of only lowercase English letters.
*/

class Solution {
    public int longestPath(int[] parent, String s) {
    final int n=parent.length;
    List<Integer>[] graph=new List[n];

    for(int i=0;i<n;++i)
      graph[i]=new ArrayList<>();

    for(int i=1;i<n;++i)
      graph[parent[i]].add(i);

    longestPathDownFrom(graph, 0, s);
    return ans;
  }

  private int ans=0;

  private int longestPathDownFrom(List<Integer>[] graph,int u,final String s){
    int max1=0;
    int max2=0;

    for(final int v:graph[u]){
      final int res = longestPathDownFrom(graph,v,s);
      if(s.charAt(u)==s.charAt(v))
        continue;
      if(res > max1){
        max2 = max1;
        max1 = res;
      } else if(res>max2){
        max2 =res;
      }
    }

    ans = Math.max(ans, 1 +max1+ max2);
    return 1 +max1;   
    }
}

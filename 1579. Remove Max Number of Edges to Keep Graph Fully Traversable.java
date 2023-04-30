/*

Alice and Bob have an undirected graph of n nodes and three types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 

Example 1:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
Example 2:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
Output: 0
Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
Example 3:



Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
Output: -1
Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.
 

 

Constraints:

1 <= n <= 105
1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)
edges[i].length == 3
1 <= typei <= 3
1 <= ui < vi <= n
All tuples (typei, ui, vi) are distinct.


*/

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
    
        Arrays.sort(edges, (a, b)->{
            return b[0]-a[0];
        });
        int []parentAlice= new int[n+1];
        int []parentBob= new int[n+1];
        
        for(int i= 0; i< n+1; i++){
            parentAlice[i]= i;
            parentBob[i]= i;
        }
        int mergeAlice= 1;
        int mergeBob= 1;
  
        int removeEdge= 0;
        
        for(int []edge: edges)
        {
            int cat= edge[0];
            int u= edge[1];
            int v= edge[2];
            
            if(cat == 3){
                boolean tempAlice= union(u, v, parentAlice);
                boolean tempBob= union(u, v, parentBob);
                
                if(tempAlice == true)
                    mergeAlice+= 1;
                
                if(tempBob == true)
                    mergeBob+= 1;
                
                if(tempAlice == false && tempBob == false)
                    removeEdge+= 1;
            }
            else if(cat == 2){
                boolean tempBob= union(u, v, parentBob);
                
                if(tempBob == true)
                    mergeBob+= 1;
                else
                    removeEdge+= 1;
            }
            else{
                boolean tempAlice= union(u, v, parentAlice);
                
                if(tempAlice == true)
                    mergeAlice+= 1; 
                else
                    removeEdge+= 1;
            }
        }
        if(mergeAlice != n || mergeBob != n) 
            return -1;
        return removeEdge;
    }
    
    public int find(int x, int[] parent)
    {
        if(parent[x] == x) 
            return x;
        
        int temp= find(parent[x], parent);
        
        parent[x]= temp;
        
        return temp;
    }
    
    public boolean union(int x, int y, int[] parent)
    {
        int lx= find(x, parent);
        int ly= find(y, parent);
        
        if(lx != ly){
            parent[lx]= ly;
            
            return true;
        }
        else
            return false;    
    }
}

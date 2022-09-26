/*

You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 

Constraints:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] is a lowercase letter.
equations[i][1] is either '=' or '!'.
equations[i][2] is '='.
equations[i][3] is a lowercase letter.

*/

class UnionFind {
  public int[] id;

  public UnionFind(int n) {
    id = new int[n];
    for (int i = 0; i < n; ++i)
      id[i] = i;
  }

  public void union(int u, int v) {
    id[find(u)] = find(v);
  }

  public int find(int u) {
    return id[u] == u ? u : (id[u] = find(id[u]));
  }
}

class Solution {
  public boolean equationsPossible(String[] equations) {
    UnionFind uf = new UnionFind(26);

    for (final String e : equations)
      if (e.charAt(1) == '=') {
        final int x = e.charAt(0) - 'a';
        final int y = e.charAt(3) - 'a';
        uf.union(x, y);
      }

    for (final String e : equations)
      if (e.charAt(1) == '!') {
        final int x = e.charAt(0) - 'a';
        final int y = e.charAt(3) - 'a';
        if (uf.find(x) == uf.find(y))
          return false;
      }

    return true;
  }
}

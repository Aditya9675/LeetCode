/*

Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true
 

Constraints:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104

*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    Set<Integer> distSet = new HashSet<>();
    int[][] points = {p1, p2, p3, p4};

    for (int i = 0; i < 4; ++i)
      for (int j = i + 1; j < 4; ++j)
        distSet.add(dist(points[i], points[j]));

    return !distSet.contains(0) && distSet.size() == 2;
  }

  private int dist(int[] p1, int[] p2) {
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);    
    }
}

/*

Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle. The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).

Return true if all the rectangles together form an exact cover of a rectangular region.

 

Example 1:


Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
Output: true
Explanation: All 5 rectangles together form an exact cover of a rectangular region.
Example 2:


Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
Output: false
Explanation: Because there is a gap between the two rectangular regions.
Example 3:


Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
Output: false
Explanation: Because two of the rectangles overlap with each other.
 

Constraints:

1 <= rectangles.length <= 2 * 104
rectangles[i].length == 4
-105 <= xi, yi, ai, bi <= 105

*/

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        Set<int[]> set = new TreeSet<>((int[] a, int[] b) -> {
            if (a[3] <= b[1]) {
                return -1;
            } else if (a[1] >= b[3]) {
                return 1;
            } else if (a[2] <= b[0]) {
                return -1;
            } else if (a[0] >= b[2]) {
                return 1;
            } else return 0;
        });
        
        int area = 0;
        int up = Integer.MIN_VALUE;
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int[] rect : rectangles) {
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            up = Math.max(up, rect[3]);
            right = Math.max(right, rect[2]);
            down = Math.min(down, rect[1]);
            left = Math.min(left, rect[0]);
            if (!set.add(rect)) {
                return false;
            }
        }
        if (!(((up - down) * (right - left)) == area)) return false;
        return true;
    
    }
}

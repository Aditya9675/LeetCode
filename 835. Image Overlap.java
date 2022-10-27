/*

You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.

Return the largest possible overlap.

 

Example 1:


Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3 (shown in red).

Example 2:

Input: img1 = [[1]], img2 = [[1]]
Output: 1
Example 3:

Input: img1 = [[0]], img2 = [[0]]
Output: 0
 

Constraints:

n == img1.length == img1[i].length
n == img2.length == img2[i].length
1 <= n <= 30
img1[i][j] is either 0 or 1.
img2[i][j] is either 0 or 1.

*/

class Solution {
  public int largestOverlap(int[][] A, int[][] B) {
    final int n = A.length;
    final int magic = 100;
    int ans = 0;
    List<int[]> onesA = new ArrayList<>();
    List<int[]> onesB = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j) {
        if (A[i][j] == 1)
          onesA.add(new int[] {i, j});
        if (B[i][j] == 1)
          onesB.add(new int[] {i, j});
      }

    for (int[] a : onesA)
      for (int[] b : onesB) {
        final int key = (a[0] - b[0]) * magic + a[1] - b[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
      }

    for (final int value : map.values())
      ans = Math.max(ans, value);

    return ans;
  }
}

/*

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
          Integer[] ans = new Integer[rowIndex + 1];
    Arrays.fill(ans, 1);

    for (int i = 2; i < rowIndex + 1; ++i)
      for (int j = 1; j < i; ++j)
        ans[i - j] += ans[i - j - 1];

    return Arrays.asList(ans);
    }
}

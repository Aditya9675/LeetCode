/*

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

Example 1:

Input: nums = [2,1,2]
Output: 5
Example 2:

Input: nums = [1,2,1]
Output: 0
 

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106

*/

class Solution {
    public int largestPerimeter(int[] A) {
    Arrays.sort(A);

    for (int i = A.length - 1; i > 1; --i)
      if (A[i - 2] + A[i - 1] > A[i])
        return A[i - 2] + A[i - 1] + A[i];

    return 0;
    }
}

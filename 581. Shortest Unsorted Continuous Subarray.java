/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
  
  
  */


class Solution {
  public int findUnsortedSubarray(int[] nums) {
    final int n = nums.length;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    boolean meetDecrease = false;
    boolean meetIncrease = false;

    for (int i = 1; i < n; ++i) {
      if (nums[i] < nums[i - 1])
        meetDecrease = true;
      if (meetDecrease)
        min = Math.min(min, nums[i]);
    }

    for (int i = n - 2; i >= 0; --i) {
      if (nums[i] > nums[i + 1])
        meetIncrease = true;
      if (meetIncrease)
        max = Math.max(max, nums[i]);
    }

    int l = 0;
    for (l = 0; l < n; ++l)
      if (nums[l] > min)
        break;

    int r = 0;
    for (r = n - 1; r >= 0; --r)
      if (nums[r] < max)
        break;

    return l > r ? 0 : r - l + 1;
  }
}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

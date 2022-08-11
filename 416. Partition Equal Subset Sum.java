/*

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

*/

class Solution {
    public boolean canPartition(int[] nums) {
         if (nums == null || nums.length < 1) {
            return true;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        return isSumSubarray(nums, sum, nums.length - 1);
    }
    
    private boolean isSumSubarray(int[] nums, int sum, int last) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || last < 0) {
            return false;
        }
        return (isSumSubarray(nums, sum, last - 1) || 
            isSumSubarray(nums, sum - nums[last], last - 1));
    }
}

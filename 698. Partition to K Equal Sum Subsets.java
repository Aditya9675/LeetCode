/*

Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].

*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
    final int sum = Arrays.stream(nums).sum();
    if(sum%k != 0)
      return false;

    final int t = sum/k;
    boolean[] seen = new boolean[nums.length];
    return dfs(nums, 0, k, t, t, seen);
  }

  private boolean dfs(int[] nums, int s, int k, int target, int subsetTargetSum, boolean[] seen){
    if(k==0)
      return true;
    if(target<0)
      return false;
    if(target==0)
      return dfs(nums, 0, k - 1, subsetTargetSum, subsetTargetSum, seen);

    for(int i=s; i< nums.length;++i){
      if (seen[i])
        continue;
      seen[i]=true;
      if(dfs(nums, i + 1, k, target - nums[i], subsetTargetSum, seen))
        return true;
      seen[i] = false;
    }

    return false;    
    }
}

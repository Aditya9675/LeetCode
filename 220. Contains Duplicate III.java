/*
Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1

*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length<2||k<0||t<0)
        return false;
 
    TreeSet<Long> set = new TreeSet<Long>();
    for(int i=0; i<nums.length; i++){
        long curr = (long) nums[i];
 
        long leftBoundary = (long) curr-t;
        long rightBoundary = (long) curr+t+1; 
        SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
        if(sub.size()>0)
            return true;
 
        set.add(curr);   
 
        if(i>=k){ 
            set.remove((long)nums[i-k]);
        }
    }
 
    return false;
    }
}

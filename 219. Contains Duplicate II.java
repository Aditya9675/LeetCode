/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         if(nums==null || nums.length<2 || k==0)
        return false;
 
    int i=0; 
 
    HashSet<Integer> set = new HashSet<Integer>();
 
    for(int j=0; j<nums.length; j++){
        if(!set.add(nums[j])){
            return true;
        }            
 
        if(set.size()>=k+1){
            set.remove(nums[i++]);
        }
    }
 
    return false;
    }
}

/*

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109

*/

class Solution {
    public boolean find132pattern(int[] nums) {
          
    if(nums==null||nums.length<3) 
        return false;
    int[] min=new int[nums.length];
    int[] max=new int[nums.length];
    min[0]=nums[0];
    max[0]=nums[0];
    for(int i=1;i<nums.length;i++){
        if(nums[i]>=max[i-1]){
            max[i]=nums[i];
            min[i]=min[i-1];
        }
        else if(nums[i]<=min[i-1]){
            min[i]=nums[i];
            max[i]=max[i-1];
        }
        else{
            int j=0;
            for( j=i-1;j>=1;j--){
                if(nums[j]>nums[i])
                    break;
            }
            if(j>=1&&min[j-1]<nums[i])
                return true;
            max[i]=max[i-1];
            min[i]=min[i-1];
        }
    }
    return false;
    }
}


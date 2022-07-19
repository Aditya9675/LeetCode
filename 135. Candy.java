/*

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104

*/

class Solution {
    public int candy(int[] nums) {
         int ans = 0;
            int n = nums.length;
            int[] candy = new int[n];
            
            for(int i=nums.length-1;i>0;i--){
                if(nums[i-1]>nums[i]){
                    candy[i-1] = candy[i]+1;
                }
            }
            
            for(int i=0;i<nums.length-1;i++)
            {
                if(nums[i]<nums[i+1] && candy[i]>=candy[i+1])
                {
                    candy[i+1] = candy[i]+1;
                }
                ans+=candy[i];
            }
            
            return n+ans+candy[n-1];
    }
}

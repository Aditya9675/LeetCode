/*

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         List<Integer> result = new ArrayList<Integer>();
    if(nums==null||nums.length==0)
        return result;
 
    Arrays.sort(nums);
 
    int[] t = new int[nums.length];
    int[] index = new int[nums.length];
    Arrays.fill(t, 1);
    Arrays.fill(index, -1);
 
    int max=0;
    int maxIndex=-1;
 
    for(int i=0; i<t.length; i++){
        for(int j=i-1; j>=0; j--){
            if(nums[i]%nums[j]==0 && t[j]+1>t[i]){
                t[i]=t[j]+1;
                index[i]=j;
            }
        }
 
        if(max<t[i]){
            max=t[i];
            maxIndex=i;
        }
    }
 
    int i=maxIndex;
    while(i>=0){
        result.add(nums[i]);
        i=index[i];
    }
 
    return result;
    }
}

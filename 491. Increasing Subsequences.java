/*
Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.

The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100

*/

class Solution{
    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>>res = new ArrayList<>();
        List<Integer> element = new ArrayList<>();
        dfs(res, element, 0, nums);

        return new ArrayList(res);
    }

    private void dfs(List<List<Integer>>res, List<Integer> element, int pos, int[] nums){
        if(element.size()>= 2) res.add(new ArrayList(element));
        Set<Integer> s = new HashSet<>(nums.length);
        for(int i  = pos; i < nums.length; i++){
            if((element.size() == 0 || element.get(element.size() - 1) <= nums[i])&& !s.contains(nums[i])){
                element.add(nums[i]);
                dfs(res, element, i + 1, nums);
                element.remove(element.size() - 1);
                s.add(nums[i]);
            }
        }
    }
}


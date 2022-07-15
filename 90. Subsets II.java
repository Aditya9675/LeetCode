/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10.

*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList());
        
        Arrays.sort(num);
        
        for(int i : num){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> sub : result){
                List<Integer> inner = new ArrayList<Integer>(sub);
                inner.add(i);
                if(!result.contains(inner))
                    temp.add(inner);
            }
            result.addAll(temp);
        }
        return result;
    }
}

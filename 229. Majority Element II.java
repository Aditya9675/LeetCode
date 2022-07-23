/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 
 
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
    
        List<Integer> result = new ArrayList<>();
 
    Integer n1 = null, n2 = null;
    int c1 = 0, c2 = 0;
 
    for (int i : nums) {
        if (n1 != null && i == n1.intValue()) {
            c1++;
        } else if (n2 != null && i == n2.intValue()) {
            c2++;
        } else if (c1 == 0) {
            c1 = 1;
            n1 = i;
        } else if (c2 == 0) {
            c2 = 1;
            n2 = i;
        } else {
            c1--;
            c2--;
        }
    }
 
    c1 = c2 = 0;
 
    for (int i : nums) {
        if (i == n1.intValue()) {
            c1++;
        } else if (i == n2.intValue()) {
            c2++;
        }
    }
 
    if (c1 > nums.length / 3)
        result.add(n1);
    if (c2 > nums.length / 3)
        result.add(n2);
 
    return result;
    }
}

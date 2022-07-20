/*
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

 

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109

*/

class Solution {
    public int maximumGap(int[] nums) {
       int N = nums.length;
        if (N<=1) return 0;
        
        radix_sort(nums, 0, N, 31);
        
        int max_gap = 0;
        for (int i=0; i<N-1; i++)
            max_gap = Math.max(max_gap, nums[i+1]-nums[i]);
        return max_gap;
    }
    
    public void radix_sort(int[] nums, int start, int end, int d) {
        if (d<0 || start>=end) return;
        int N = nums.length;
        int l = start;
        for (int i=start; i<end; i++) 
            if( ((nums[i]>>d)&1)==0 ) swap(nums, i, l++);
        
        radix_sort(nums, start, l, d-1);
        radix_sort(nums, l, end, d-1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

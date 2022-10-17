/*

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

*/

class Solution{
    public int reversePairs(int[] nums){
    if(nums == null || nums.length == 0){
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right){
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        
        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right)
                + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right){
        int[] helper = new int[right - left + 1];

        int i = 0, rst = 0;
        int p1 = left, p2 = mid + 1, p = mid + 1;
        while (p1 <= mid) {
           
            while(p <= right && nums[p1] / 2.0 > nums[p]){
                p++;
            }
            rst += p - (mid + 1);

            while(p2 <= right && nums[p1] > nums[p2]){
                helper[i++] = nums[p2++];
            }
            helper[i++] = nums[p1++];
        }
        while(p2 <= right){
            helper[i++] = nums[p2++];
        }

        for (i = 0; i < helper.length; i++){
            nums[left + i] = helper[i];
        }
        return rst;
    }
}

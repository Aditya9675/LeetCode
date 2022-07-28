/*

Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.

*/


class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
    int mid = n / 2 - (n % 2 == 0 ? 1 : 0);
    int[] sorted = Arrays.copyOf(nums, n);
    Arrays.sort(sorted);

    for (int i = 0, copyOffset = 0; copyOffset <= mid; copyOffset++, i += 2) {
        nums[i] = sorted[mid - copyOffset];
        if (i + 1 < n)
            nums[i + 1] = sorted[n - copyOffset - 1];
    }
}
}

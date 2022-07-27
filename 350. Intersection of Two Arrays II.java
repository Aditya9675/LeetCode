/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        int i;
        int value;
        for(i = 0; i < nums1.length; i++) {
            value = hMap.containsKey(nums1[i]) ? hMap.get(nums1[i])+1 : 1;
            hMap.put(nums1[i], value);
        }
        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] intersection = new int[size];
        int j = 0;
        for(i = 0; i < nums2.length; i++) {
            value = hMap.containsKey(nums2[i]) ? hMap.get(nums2[i]) : 0; 
            if (value > 0) {
               intersection[j++] = nums2[i];
               hMap.put(nums2[i], value-1);
            }
        }
        int[] result = new int[j];
        for (i = 0; i < j; i++) {
            result[i] = intersection[i];
        }
        return result;
    }
}

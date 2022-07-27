/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
    Arrays.sort(nums2);
    ArrayList<Integer> list = new ArrayList<Integer>();
    int p1=0, p2=0;
    while(p1<nums1.length && p2<nums2.length){
        if(nums1[p1]<nums2[p2]){
            p1++;
        }else if(nums1[p1]>nums2[p2]){
            p2++;
        }else{
            list.add(nums1[p1]);
            p1++;
            p2++;
 
        }
    }
 
    int[] result = new int[list.size()];
    int i=0;
    while(i<list.size()){
        result[i]=list.get(i);
        i++;
    }
    return result;
    }
}

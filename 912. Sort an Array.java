/*
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

*/

class Solution {
    public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }
  private void mergeSort(int[] A, int l, int r){
    if(l>= r)
      return;

    final int m = (l + r) / 2;
    mergeSort(A, l, m);
    mergeSort(A, m + 1, r);
    merge(A, l, m, r);
  }

  private void merge(int[] A,int l,int m,int r){
    int[] sorted = new int[r - l + 1];
    int k = 0;     
    int i = l;     
    int j = m + 1; 

    while(i <= m && j <= r)
      if(A[i] < A[j])
        sorted[k++] = A[i++];
      else
        sorted[k++] = A[j++];

    while(i <= m)
      sorted[k++] = A[i++];

    while(j <= r)
      sorted[k++] = A[j++];
    System.arraycopy(sorted, 0, A, l, sorted.length);    
    }
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

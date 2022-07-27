/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    int len = nums.length;
        
        if (k == len) {
            return nums;
        }
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        } 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> hm.get(n1) - hm.get(n2)
        );
        
        for (int num : hm.keySet()) {
            pq.offer(num);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}

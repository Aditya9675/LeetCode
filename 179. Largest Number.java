/*

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109

*/

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
			
		    public int compare(Integer a,Integer b){
			    
			    String num1 = String.valueOf(a)+String.valueOf(b);
			    String num2 = String.valueOf(b)+String.valueOf(a);
			    
			    return num2.compareTo(num1);
			}
		});

		for (int a : nums)	pq.offer(a);
		
		String res="";	
		
		while(!pq.isEmpty()) res+=pq.poll();
		
		if(res.charAt(0)=='0') return "0";
		
        return res;
    }
}

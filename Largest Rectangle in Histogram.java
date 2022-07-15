/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104 .

*/


class Solution {
    public int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
		return 0;
	}
 
	Stack<Integer> stack = new Stack<Integer>();
 
	int max = 0;
	int i = 0;
 
	while (i < height.length) {
		
		if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
			stack.push(i);
			i++;
		} else {
		
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
 
	}
 
	while (!stack.isEmpty()) {
		int p = stack.pop();
		int h = height[p];
		int w = stack.isEmpty() ? i : i - stack.peek() - 1;
		max = Math.max(h * w, max);
	}
 
	return max;
   }
}

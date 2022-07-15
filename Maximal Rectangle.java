/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
	int n = m == 0 ? 0 : matrix[0].length;
	int[][] height = new int[m][n + 1];
 
	int maxArea = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (matrix[i][j] == '0') {
				height[i][j] = 0;
			} else {
				height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
			}
		}
	}
 
	for (int i = 0; i < m; i++) {
		int area = maxAreaInHist(height[i]);
		if (area > maxArea) {
			maxArea = area;
		}
	}
 
	return maxArea;
}
 
private int maxAreaInHist(int[] height) {
	Stack<Integer> stack = new Stack<Integer>();
 
	int i = 0;
	int max = 0;
 
	while (i < height.length) {
		if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
			stack.push(i++);
		} else {
			int t = stack.pop();
			max = Math.max(max, height[t]
					* (stack.isEmpty() ? i : i - stack.peek() - 1));
		}
	}
 
	return max;
    }
}

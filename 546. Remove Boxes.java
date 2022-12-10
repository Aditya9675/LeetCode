/*

You are given several boxes with different colors represented by different positive numbers.

You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.

Return the maximum points you can get.

 

Example 1:

Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
----> [1, 3, 3, 3, 1] (1*1=1 points) 
----> [1, 1] (3*3=9 points) 
----> [] (2*2=4 points)
Example 2:

Input: boxes = [1,1,1]
Output: 9
Example 3:

Input: boxes = [1]
Output: 1
 

Constraints:

1 <= boxes.length <= 100
1 <= boxes[i] <= 100

*/

class Solution {
    private int[][][] dp;
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        dp = new int[len][len][len];
        return dfs(boxes, 0, len - 1, 0);
    }
    private int dfs(int[] boxes, int i, int j, int k){
        if(i > j) return 0;
        if(dp[i][j][k] > 0) return dp[i][j][k];
        dp[i][j][k] = dfs(boxes, i, j - 1, 0) + (k + 1) * (k + 1);
        for(int p = i; p < j; p++){
            if(boxes[p] == boxes[j]){
                dp[i][j][k] = Math.max(dp[i][j][k], dfs(boxes, i, p, k + 1) + dfs(boxes, p + 1, j - 1, 0));
            }
        }
        return dp[i][j][k];
    }
}

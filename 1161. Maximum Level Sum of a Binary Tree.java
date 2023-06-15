/*

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105

*/

class Solution {
    public int maxLevelSum(TreeNode root) {
    int ans = 1;
    int maxLevelSum = Integer.MIN_VALUE;
    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

    for (int level = 1; !q.isEmpty(); ++level) {
      int levelSum = 0;
      for(int sz = q.size(); sz > 0; --sz){
        TreeNode node = q.poll();
        levelSum += node.val;
        if(node.left != null)
          q.offer(node.left);
        if(node.right != null)
          q.offer(node.right);
      }
      if(maxLevelSum < levelSum){
        maxLevelSum = levelSum;
        ans = level;
      }
    }

    return ans;    
    }
}

/*

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [5,4,5,1,1,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 5).
Example 2:


Input: root = [1,4,5,4,4,null,5]
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 4).
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.

*/

class Solution {
    public int longestUnivaluePath(TreeNode root) {
    longestUnivaluePathDownFrom(root);
    return ans;
  }

  private int ans = 0;

  private int longestUnivaluePathDownFrom(TreeNode root){
    if(root == null)
      return 0;

    final int l = longestUnivaluePathDownFrom(root.left);
    final int r = longestUnivaluePathDownFrom(root.right);
    final int arrowLeft = root.left != null && root.left.val == root.val ? l + 1 : 0;
    final int arrowRight = root.right != null && root.right.val == root.val ? r + 1 : 0;
    ans=Math.max(ans, arrowLeft + arrowRight);
    return Math.max(arrowLeft, arrowRight);    
    }
}

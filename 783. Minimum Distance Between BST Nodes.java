/*

Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105
 
 
 */

class Solution {
    public int minDiffInBST(TreeNode root) {
    inorder(root);
    return ans;
  }

  private int ans = Integer.MAX_VALUE;
  private Integer pred = null;

  private void inorder(TreeNode root){
    if(root ==null)
      return;

    inorder(root.left);
    if(pred!=null)
      ans =Math.min(ans,root.val-pred);
    pred=root.val;
    inorder(root.right);    
    }
}


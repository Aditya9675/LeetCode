/*

Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

*/

class Solution {
 int val, maxRow = -1;
    public void traverse(TreeNode root, int level){
        if(root == null) return;
        if(level > maxRow) {
            maxRow = level;
            val = root.val;
        }
        if(root.left != null) traverse(root.left, level+1);
        if(root.right != null) traverse(root.right, level+1);
    }
    public int findBottomLeftValue(TreeNode root){
        traverse(root, 0);
        return val;        
    }
}

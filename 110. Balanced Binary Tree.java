/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

*/
class Solution {
    public boolean isBalanced(TreeNode root) {
         if(root == null) 
             return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) 
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode node){
        if(node == null) 
            return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}

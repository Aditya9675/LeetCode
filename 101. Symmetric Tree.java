/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
		return true;
	return isSymmetric(root.left, root.right);
}
 
public boolean isSymmetric(TreeNode l, TreeNode r) {
	if (l == null && r == null) {
		return true;
	} else if (r == null || l == null) {
		return false;
	}
 
	if (l.val != r.val)
		return false;
 
	if (!isSymmetric(l.left, r.right))
		return false;
	if (!isSymmetric(l.right, r.left))
		return false;
 
	return true;
    }
}

//Aditya Sharma

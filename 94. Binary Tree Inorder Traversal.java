/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> resultList = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode current = root; 
    while (current != null || !stack.isEmpty()) {
        while (current != null) { 
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        resultList.add(current.val);
        current = current.right;
    }
    return resultList;
    }
}

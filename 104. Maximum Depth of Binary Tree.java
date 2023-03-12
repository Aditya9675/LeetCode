/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/

class Solution {
    public int maxDepth(TreeNode root) {
          if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 0;
        while(q.size()>0){
            int n = q.size();
            count++;
            for(int i = 0;i<n;i++){
                TreeNode node = q.remove();
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right !=null){
                    q.add(node.right);
                }
            }
        }
        return count;
    }
}
// Aditya Sharma

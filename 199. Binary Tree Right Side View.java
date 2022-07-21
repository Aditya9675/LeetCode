/*

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
 
    if(root == null) return result;
 
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
 
    while(queue.size() > 0){

        int size = queue.size();
 
        for(int i=0; i<size; i++){
            TreeNode top = queue.remove();
 
   
            if(i==0){
                result.add(top.val);
            }
          
            if(top.right != null){
                queue.add(top.right);
            }
           
            if(top.left != null){
                queue.add(top.left);
            }
        }
    }
 
    return result;
    }
}

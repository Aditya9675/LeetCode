/*

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxValues = new ArrayList<>();
        if(root == null) return maxValues;
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            int count = 0;
            int max = Integer.MIN_VALUE;
      
            while(count < size){
                TreeNode curr = bfs.poll();
                
                max = Math.max(max, curr.val);
                
                if(curr.left != null){
                    bfs.offer(curr.left);
                }                
                if(curr.right != null){
                    bfs.offer(curr.right);
                }                
                count++;
            }     
            maxValues.add(max);
        }        
        return maxValues;
    }
}


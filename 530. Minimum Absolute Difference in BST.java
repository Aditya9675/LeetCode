/*

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*/

class Solution {
    public int getMinimumDifference(TreeNode root) {
        int ans=Integer.MAX_VALUE;
        int prev=-1;
        Deque<TreeNode>stack=new ArrayDeque<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(prev>=0)
            ans=Math.min(ans, root.val-prev);
            prev=root.val;
            root=root.right;
        }
        return ans;
    }
}


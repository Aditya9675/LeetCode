/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.

*/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode helper(int []inorder,int si,int ei,int[] postorder,int ps,int pe){
        if(si>ei)
            return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int idx=si;
        while(idx<inorder.length && inorder[idx]!=postorder[pe])
            idx++;
        int count=idx-si;
        root.left=helper(inorder,si,idx-1,postorder,ps,ps+count-1);
        root.right=helper(inorder,idx+1,ei,postorder,ps+count,pe-1);
        return root;  
    }
}

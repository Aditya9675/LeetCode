/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

10108

271

Add to List

Share
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
           int preStart = 0;
    int preEnd = preorder.length-1;
    int inStart = 0;
    int inEnd = inorder.length-1;
 
    return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
}
 
public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart>preEnd||inStart>inEnd){
        return null;
    }
 
    int val = preorder[preStart];
    TreeNode p = new TreeNode(val);
 
   
    int k=0;
    for(int i=0; i<inorder.length; i++){
        if(val == inorder[i]){
            k=i;
            break;
        }
    }
 
    p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
    p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
 
    return p;
    }
}

/*

You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100


*/

class T {
  public int leftMax;
  public int rightMax;
  public int subtreeMax;

  public T(int leftMax, int rightMax, int subtreeMax) {
    this.leftMax = leftMax;
    this.rightMax = rightMax;
    this.subtreeMax = subtreeMax;
  }
}

class Solution {
    public int longestZigZag(TreeNode root) {
    return dfs(root).subtreeMax;
  }

  private T dfs(TreeNode root) {
    if (root == null)
      return new T(-1, -1, -1);
    T left = dfs(root.left);
    T right = dfs(root.right);
    final int leftZigZag = left.rightMax + 1;
    final int rightZigZag = right.leftMax + 1;
    final int subtreeMax =
        Math.max(Math.max(leftZigZag, rightZigZag), Math.max(left.subtreeMax, right.subtreeMax));
    return new T(leftZigZag, rightZigZag, subtreeMax);    
    }
}

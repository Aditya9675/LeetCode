/*

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean rightToLeft = false;
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode current = nodesQueue.remove();
                if (current.left != null)
                    nodesQueue.add(current.left);
                if (current.right != null)
                    nodesQueue.add(current.right);
                level.add(current.val);
            }
            if (rightToLeft)
                Collections.reverse(level);
            rightToLeft = !rightToLeft;
            ans.add(level);
        }
        return ans;
    
    }
}

/*

Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105

*/

class Solution {
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        process(root, count);
        int max = 0;
        int length = 0;
        for(Integer val:count.keySet()){
            if(count.get(val) == max){
                length ++;
            }
            if(count.get(val) > max){
                length = 1;
                max = count.get(val);
            }
        }
        int[] result = new int[length];
        int k = 0;
        for(Integer val:count.keySet()){
            if(count.get(val) == max){
                result[k++] = val;
            }
        }
        return result;
    }
    private void process(TreeNode root, HashMap<Integer, Integer> count) {
        if(root == null){
            return;
        }
        if(!count.containsKey(root.val)){
            count.put(root.val, 1);
        }
        else{
            count.put(root.val, count.get(root.val) + 1);
        }
        process(root.left, count);
        process(root.right, count);
    }
} 

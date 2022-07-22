/*


Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

*/


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> finalResult = new ArrayList<String>();
 
    if(root==null)
        return finalResult;
 
    ArrayList<String> curr = new ArrayList<String>();
    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
 
    dfs(root, results, curr);
 
    for(ArrayList<String> al : results){
        StringBuilder sb = new StringBuilder();
        sb.append(al.get(0));
        for(int i=1; i<al.size();i++){
            sb.append("->"+al.get(i));
        }
 
        finalResult.add(sb.toString());
    }
 
    return finalResult;
}
 
public void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
    curr.add(String.valueOf(root.val));
 
    if(root.left==null && root.right==null){
        list.add(curr);
        return;
    }
 
    if(root.left!=null){
        ArrayList<String> temp = new ArrayList<String>(curr);
        dfs(root.left, list, temp);
    }
 
    if(root.right!=null){
        ArrayList<String> temp = new ArrayList<String>(curr);
        dfs(root.right, list, temp);
    }
}

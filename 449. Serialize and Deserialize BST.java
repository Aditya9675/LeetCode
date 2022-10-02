/*

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

 

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.

*/

public class Codec {
public String serialize(TreeNode root) {
    if(root==null)
        return null;
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    StringBuilder sb = new StringBuilder();
 
    while(!stack.isEmpty()){
        TreeNode h = stack.pop();   
        if(h!=null){
            sb.append(h.val+",");
            stack.push(h.right);
            stack.push(h.left);  
        }else{
            sb.append("#,");
        }
    }
 
    return sb.toString().substring(0, sb.length()-1);
}
 
public TreeNode deserialize(String data) {
    if(data == null)
        return null;
 
    int[] t = {0};
    String[] arr = data.split(",");
 
    return helper(arr, t);
}
 
public TreeNode helper(String[] arr, int[] t){
    if(arr[t[0]].equals("#")){
        return null;
    }
 
    TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
 
    t[0]=t[0]+1;
    root.left = helper(arr, t);
    t[0]=t[0]+1;
    root.right = helper(arr, t);
 
    return root;
}
}

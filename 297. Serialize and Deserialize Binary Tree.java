/*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000

*/

public class Codec {
    List<String> count;
   
    public String serialize(TreeNode root) {
        count = new ArrayList<>();
        iter(root, 1);
        count.remove(0);
        String ret = "";
        for (String i: count){
            ret = ret+i;
            ret = ret+",";
        }
        ret.substring(0, ret.length()-1);
        return ret;
    }
    
    public void iter(TreeNode root, int index){
        if (root == null) return;
        while (index >= count.size())
            count.add(new String("n"));
        count.add(index, String.valueOf(root.val));
        iter(root.left, index*2);
        iter(root.right, index*2+1);
    }

    
    public TreeNode deserialize(String data) {
        String[] raw = data.split(",");
        return iter2(raw, 1);
    }
    
    public TreeNode iter2(String[] raw, int index){
        if (raw[index-1] == "n")
            return null;
        TreeNode cur = new TreeNode(Integer.valueOf(raw[index-1]));
        cur.left = iter2(raw, index*2);
        cur.right = iter2(raw, index*2+1);
        return cur;
    }
}

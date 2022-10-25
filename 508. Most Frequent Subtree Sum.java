/*

Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

 

Example 1:


Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:


Input: root = [5,2,-5]
Output: [2]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105

*/

class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
 
    helper(root, map);
    int maxCount = 0;
    for(int i: map.keySet()){
        if(map.get(i)>maxCount){
            maxCount=map.get(i);
        }
    } 
    List<Integer> mf = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        if(entry.getValue()==maxCount){
            mf.add(entry.getKey());
        }
    }
 
    int[] result = new int[mf.size()];
    int k=0;
    for(int i: mf){
        result[k++]=i;
    } 
    return result;
}
 
public Integer helper(TreeNode root, HashMap<Integer,Integer> map){
    if(root==null){
        return null;
    }
 
    Integer left = helper(root.left, map);
    if(left==null){
        left=0;
    }
 
    Integer right = helper(root.right, map);
    if(right==null){
        right=0;
    }
    int sum = root.val + left + right;
    map.put(sum, map.getOrDefault(sum, 0)+1);
 
    return sum;
    }
}

/*

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000

*/

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
   class Group{
            TreeNode treeNode;
            int dis;
            int vd;
            Group(TreeNode treeNode, int dis, int vd){
                this.treeNode = treeNode;
                this.dis = dis;
                this.vd = vd;
            }
        }
        List<List<Integer>> ans = new ArrayList();
        if( root == null)   return ans;
        Map<Integer,List< Group>> dic = new HashMap();
        List<Group > list = new ArrayList();
        Queue<Group> queue = new LinkedList();
        queue.add(new Group(root, 0, 0));
        int minDis = Integer.MAX_VALUE;
        int maxDis = Integer.MIN_VALUE;
        
        while( ! queue.isEmpty() ){
            Group group = queue.poll();
            
            minDis = Math.min(minDis, group.dis);
            maxDis = Math.max(maxDis, group.dis);
            
            if( group.treeNode.left !=null ) {
                queue.add(new Group(group.treeNode.left, group.dis-1, group.vd+1) );
            }
            if( group.treeNode.right !=null){
                queue.add(new Group(group.treeNode.right, group.dis+1, group.vd+1) );
            }
            if( dic.containsKey(group.dis)){
                list = dic.get(group.dis);
                list.add(group);
                dic.put(group.dis,new ArrayList(list ));
                list.clear();
            }
            else{
                list.add(group );
                dic.put(group.dis, new ArrayList(list));
                list.clear();
            }
         }
        
        int index = 0;
        for(int d = minDis; d <= maxDis; d++ ){
            list =  dic.get(d);
            Collections.sort(list, (a,b) -> {
                
                if( a.vd == b.vd)   return a.treeNode.val - b.treeNode.val ;
                else
                    return a.vd - b.vd;
            
            } );
            
            ans.add(new ArrayList());
            
             for(Group g : list){
                 ans.get(index).add(g.treeNode.val);
             }
            
            index++;
        }
        return ans;
    }
}

/*

Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
Example 2:


Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 

Constraints:

The number of nodes in the tree is in the range [2, 5 * 104].
1 <= Node.val <= 104
*/

class Solution {
    public int maxProduct(TreeNode root) {
    final int kMod = 1_000_000_007;
    long ans = 0;
    List<Integer> allSums = new ArrayList<>();
    final long totalSum = treeSum(root, allSums);

    for (final long sum : allSums)
      ans = Math.max(ans, sum * (totalSum - sum));

    return (int) (ans % kMod);
  }

  private int treeSum(TreeNode root, List<Integer> allSums) {
    if (root == null)
      return 0;

    final int leftSum = treeSum(root.left, allSums);
    final int rightSum = treeSum(root.right, allSums);
    final int sum = root.val + leftSum + rightSum;
    allSums.add(sum);
    return sum;
    }
}

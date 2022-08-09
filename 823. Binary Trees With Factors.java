/*

Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 

Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
All the values of arr are unique.
*/

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
         Arrays.sort(arr);
        int len = arr.length;
        long ans = 0;
        HashMap<Integer, Long> fmap = new HashMap<>();
        for (int num : arr) {
            long ways = 1;
            double lim = Math.sqrt(num);
            for (int j = 0, farr = arr[0]; farr <= lim; farr = arr[++j]) {
                if (num % farr != 0) 
                    continue;
                int fB = num / farr;
                if (fmap.containsKey(fB))
                    ways += fmap.get(farr) * fmap.get(fB) * (farr == fB ? 1 : 2);
            }
            fmap.put(num, ways);
            ans = (ans + ways) % 1000000007;
        }
        return (int)ans;
    }
}

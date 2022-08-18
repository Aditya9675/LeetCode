/*

You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

 

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 

Constraints:

2 <= arr.length <= 105
arr.length is even.
1 <= arr[i] <= 105

*/

class Solution {
    public int minSetSize(int[] arr) {
        
    final int n = arr.length;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (final int a : arr)
      map.merge(a, 1, Integer::sum);

    int[][] count = new int[map.size()][2];
    int i = 0;

    for (final int key : map.keySet()) {
      count[i][0] = key;
      count[i++][1] = map.get(key);
    }

    Arrays.sort(count, (c1, c2) -> c2[1] - c1[1]);

    for (i = 0; i < count.length; ++i) {
      sum += count[i][1];
      if (sum >= n / 2)
        return i + 1;
    }

    throw new IllegalArgumentException();
    }
}

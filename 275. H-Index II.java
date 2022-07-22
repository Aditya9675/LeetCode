/*

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.

You must write an algorithm that runs in logarithmic time.

 

Example 1:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,2,100]
Output: 2
 

Constraints:

n == citations.length
1 <= n <= 105
0 <= citations[i] <= 1000
citations is sorted in ascending order.

*/

class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;
        else if (citations.length == 1) {
            if (citations[0] == 0)
                return 0;
            else
                return 1;
        }

        int n = citations.length;
        if (n <= citations[0])
            return n;

        int l = 1;
        int r = n;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (n - m <= citations[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return n - r;
    }
}
